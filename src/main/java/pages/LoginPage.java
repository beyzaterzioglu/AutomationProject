package pages;

import org.openqa.selenium.WebDriver;

import static expected.LoginPageExpected.*;
import static locators.LoginPageLocators.errorMessage;
import static locators.LoginPageLocators.loginButton;


public class LoginPage extends PageObject{
    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    public String loginWithoutUsername()
    {
        getLoginPage();
        enterPassword(PASSWORD);
        click(loginButton);
        return driver.findElement(errorMessage).getText();
    }
    public String loginWithoutPassword()
    {
        getLoginPage();
        enterUsername(FIRST_USERNAME_OPTION);
        click(loginButton);
        return driver.findElement(errorMessage).getText();
    }
    public String invalidUsernameLogin()
    {
        getLoginPage();
        enterUsername(INVALID_USERNAME_OPTION);
        enterPassword(PASSWORD);
        click(loginButton);
        return driver.findElement(errorMessage).getText();
    }
    public String invalidPasswordLogin()
    {
        getLoginPage();
        enterUsername(FIRST_USERNAME_OPTION);
        enterPassword(INVALID_PASSWORD);
        click(loginButton);
        return driver.findElement(errorMessage).getText();
    }
    public String nullLogin()
    {
        getLoginPage();
        click(loginButton);
        return driver.findElement(errorMessage).getText();
    }

}
