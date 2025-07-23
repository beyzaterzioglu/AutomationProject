package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static expected.LoginPageExpected.URL;
import static locators.LoginPageLocators.passwordField;
import static locators.LoginPageLocators.usernameField;

public class PageObject {
    protected WebDriver driver;
    public PageObject(WebDriver driver) {
        this.driver = driver;
    }


    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected void getLoginPage() {
        driver.get(URL);
    }
    protected void enterUsername(String username)
    {
        driver.findElement(usernameField).sendKeys(username);
    }
    protected void enterPassword(String password)
    {
        driver.findElement(passwordField).sendKeys(password);
    }
    protected String getPageHeader(By header) {
        return driver.findElement(header).getText();
    }




}
