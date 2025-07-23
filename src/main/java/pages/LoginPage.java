package pages;

import org.openqa.selenium.WebDriver;

import static expected.LoginPageExpected.FIRST_USERNAME_OPTION;
import static expected.LoginPageExpected.PASSWORD;
import static locators.LoginPageLocators.loginButton;


public class LoginPage extends PageObject{
    public LoginPage(WebDriver driver)
    {
        super(driver);
    }
    public void login()
    {
       getLoginPage();
       enterUsername(FIRST_USERNAME_OPTION);
       enterPassword(PASSWORD);
       click(loginButton);

    }
}
