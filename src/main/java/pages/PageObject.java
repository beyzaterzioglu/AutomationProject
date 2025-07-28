package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static expected.CheckoutPageExpected.*;
import static expected.LoginPageExpected.*;
import static locators.CartPageLocators.checkoutButton;
import static locators.CheckoutPageLocators.*;
import static locators.CheckoutPageLocators.zipCode;
import static locators.LoginPageLocators.*;
import static locators.OverviewPageLocators.finishButton;
import static locators.ProductsPageLocators.*;

public class PageObject {
    protected static WebDriver driver;
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
        System.out.println(driver.findElement(header).getText());
        return driver.findElement(header).getText();
    }

    public void login()
    {
        getLoginPage();
        enterUsername(FIRST_USERNAME_OPTION);
        enterPassword(PASSWORD);
        click(loginButton);

    }
    public void logOut()
    {
       driver.findElement(productsPageMenuButton).click();
        waitWithThread();
       driver.findElement(logOutButton).click();


    }
    public void waitWithThread()
    {
        try {
            Thread.sleep(2000); // 2 saniye bekle
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public String productHeader() {

        return driver.findElement(firstItemName).getText();
    }
    public void openCartPage()
    {
        driver.findElement(cartButton).click();
    }
    public void openCheckoutPage()
    {
        openCartPage();
        driver.findElement(checkoutButton).click();
    }

    public void openOverviewPage()
    {
        openCheckoutPage();
        fillTheBlanks();
        driver.findElement(continueButton).click();
    }
    public void openCompletePage()
    {
        openOverviewPage();
        driver.findElement(finishButton).click();
    }

    public boolean checkAddToCart(By addToCartButton, By removeFromCartButton) {
        driver.findElement(addToCartButton).click();
        return driver.findElement(removeFromCartButton).isDisplayed();
    }
    public void addToCart(By addToCartButton) {
        driver.findElement(addToCartButton).click();
    }
    public void addToCartProducts(int number )
    {
        for(int i=0;i<number;i++)
            addToCart(itemAddtoCart);

    }

    public static void chooseFromList(String option) {

        Select select = new Select(driver.findElement(sortButton));
        select.selectByVisibleText(option);
    }
    public static List<String> makeList(By sortType)
    {
        List<WebElement> itemElements = driver.findElements(sortType);
        List<String> itemNames = new ArrayList<>();
        for (WebElement item : itemElements) {
            itemNames.add(item.getText());
        }
        return itemNames;
    }
    public void fillTheBlanks()
    {
        driver.findElement(firstName).sendKeys(FIRST_NAME);
        driver.findElement(lastName).sendKeys(LAST_NAME);
        driver.findElement(zipCode).sendKeys(ZIP_CODE);
    }


}
