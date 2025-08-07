package listeners;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.*;

import utils.DriverFactory;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    private static String reportPath;

    @Override
    public void onStart(ITestContext context) {
        // reports klasörünü oluştur
        String reportsDir = System.getProperty("user.dir") + File.separator + "reports";
        new File(reportsDir).mkdirs();

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        reportPath = reportsDir + File.separator + "extent-report_" + timeStamp + ".html";

        ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
        reporter.config().setReportName("Automation Test Report");
        reporter.config().setDocumentTitle("Test Results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Beyza Terzioğlu");

        System.out.println("[INFO] Test suite started: " + context.getName());

        // JVM kapanmadan önce raporu yaz
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (extent != null) {
                extent.flush();
                System.out.println("[INFO] Shutdown hook: Report flushed.");
            }
        }));
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
        test.get().info("Test started");

        System.out.println("[START] Test started: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test passed");
        System.out.println("[PASS] Test passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().fail(result.getThrowable());
        System.out.println("[FAIL] Test failed: " + result.getMethod().getMethodName());

        WebDriver driver = DriverFactory.getDriver();

        if (driver != null) {
            try {
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String fileName = "screenshot_" + result.getMethod().getMethodName() + "_" + timestamp + ".png";

                String screenshotsDir = System.getProperty("user.dir") + File.separator + "test-output" + File.separator + "screenshots";
                new File(screenshotsDir).mkdirs();

                File destination = new File(screenshotsDir + File.separator + fileName);
                FileUtils.copyFile(screenshot, destination);

                test.get().addScreenCaptureFromPath(destination.getAbsolutePath(), "Screenshot on Failure");
                System.out.println("[SCREENSHOT] Screenshot saved at: " + destination.getAbsolutePath());
            } catch (IOException e) {
                test.get().warning("Could not save screenshot: " + e.getMessage());
                System.out.println("[ERROR] Could not save screenshot: " + e.getMessage());
            }
        } else {
            test.get().warning("WebDriver instance is null. Screenshot not taken.");
            System.out.println("[WARN] WebDriver instance is null. Screenshot not taken.");
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip("Test skipped: " + result.getMethod().getMethodName());
        System.out.println("[SKIP] Test skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        if (extent != null) {
            extent.flush();
            System.out.println("[INFO] Test suite finished: " + context.getName());
            System.out.println("[INFO] Report saved at: " + reportPath);
        }
        try {
            File htmlFile = new File(reportPath);
            if (htmlFile.exists()) {
                Desktop.getDesktop().browse(htmlFile.toURI());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Gerekirse kullanılabilir
    }
}
