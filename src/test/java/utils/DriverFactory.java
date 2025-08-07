package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            return getDriver("chrome");  // Default olarak chrome başlat
        }
        return driver;
    }

    public static WebDriver getDriver(String browser) {
        if (driver == null) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();

                    ChromeOptions chromeOptions = new ChromeOptions();
                    Map<String, Object> chromePrefs = new HashMap<>();

                    // Şifre yöneticisi ve ilgili uyarıları devre dışı bırak
                    chromePrefs.put("credentials_enable_service", false);
                    chromePrefs.put("profile.password_manager_enabled", false);

                    chromeOptions.setExperimentalOption("prefs", chromePrefs);
                    chromeOptions.addArguments("--disable-features=AutofillServerCommunication");
                    chromeOptions.addArguments("--disable-save-password-bubble");
                    chromeOptions.addArguments("--disable-notifications");
                    chromeOptions.addArguments("--incognito");  //Solution to Chrome Pop Up Problem

                    driver = new ChromeDriver(chromeOptions);
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();

                    FirefoxProfile profile = new FirefoxProfile();
                    profile.setPreference("signon.rememberSignons", false);
                    profile.setPreference("signon.autofillForms", false);
                    profile.setPreference("signon.generation.enabled", false);
                    profile.setPreference("extensions.formautofill.available", "off");
                    profile.setPreference("extensions.formautofill.addresses.enabled", false);
                    profile.setPreference("extensions.formautofill.creditCards.enabled", false);

                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.setProfile(profile);
                    driver = new FirefoxDriver(firefoxOptions);
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();

                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--disable-features=AutofillServerCommunication");
                    edgeOptions.addArguments("--disable-save-password-bubble");
                    edgeOptions.addArguments("--disable-notifications");
                    edgeOptions.addArguments("--inprivate"); // Edge gizli mod

                    driver = new EdgeDriver(edgeOptions);
                    break;

                default:
                    throw new IllegalArgumentException("Desteklenmeyen browser: " + browser);
            }

            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
