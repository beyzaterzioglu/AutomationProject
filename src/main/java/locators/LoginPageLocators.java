package locators;

import org.openqa.selenium.By;

public class LoginPageLocators {

    public static final By usernameField = By.xpath("//input[@placeholder='Username']");
    public static final By passwordField = By.xpath("//input[@placeholder='Password']");
    public static final By loginButton = By.xpath("//input[@id='login-button']");
    public static final By errorMessage = By.xpath("//div[@class='error-message-container error']");
}
