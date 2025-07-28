package pages;

import org.openqa.selenium.WebDriver;

import static expected.GeneralExpecteds.*;
import static locators.CompletePageLocators.backHomeButton;
import static locators.CompletePageLocators.message;
import static locators.ProductsPageLocators.productsPageHeader;

public class CompletePage extends PageObject{
    public CompletePage(WebDriver driver)
    {

        super(driver);
    }

    public boolean checkMessage()
    {
        return driver.findElement(message).getText().equals(EXPECTED_MESSAGE);
    }
    public boolean checkBackHomeButtonProperty()
    {
        driver.findElement(backHomeButton).click();
        return getPageHeader(productsPageHeader).equals(EXPECTED_PRODUCT_PAGE_HEADER);
    }
}
