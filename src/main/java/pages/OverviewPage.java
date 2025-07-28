package pages;

import org.openqa.selenium.WebDriver;

import static expected.GeneralExpecteds.*;
import static locators.CompletePageLocators.completePageHeader;
import static locators.OverviewPageLocators.*;
import static locators.ProductsPageLocators.productsPageHeader;

public class OverviewPage extends PageObject {
    public OverviewPage(WebDriver driver)
    {
        super(driver);
    }
    public boolean checkOverviewPageHeader()
    {
        return driver.findElement(overviewPageHeader).getText().equals(EXPECTED_OVERVIEW_PAGE_HEADER);
    }
    public boolean checkCancelButtonProperty()
    {
        driver.findElement(cancelButton).click();
        return driver.findElement(productsPageHeader).getText().equals(EXPECTED_PRODUCT_PAGE_HEADER);
    }
    public boolean checkFinishButtonProperty()
    {
        return getPageHeader(completePageHeader).equals(EXPECTED_COMPLETE_PAGE_HEADER);
    }

}
