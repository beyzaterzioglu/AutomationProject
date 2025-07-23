package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverFactory;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() {
        try {
            Thread.sleep(3000); // 3 saniye bekle
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        DriverFactory.quitDriver();
    }
}
