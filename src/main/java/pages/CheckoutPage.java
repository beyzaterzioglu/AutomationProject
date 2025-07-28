package pages;

import org.openqa.selenium.WebDriver;

import static expected.GeneralExpecteds.EXPECTED_CHECKOUT_PAGE_HEADER;

import static locators.CheckoutPageLocators.*;

public class CheckoutPage extends PageObject{
    public CheckoutPage(WebDriver driver) {

        super(driver);
    }

    public boolean checkCheoutPageHeader() {
        openCheckoutPage();
        return getPageHeader(checkoutPageHeader).equals(EXPECTED_CHECKOUT_PAGE_HEADER);
    }



}
