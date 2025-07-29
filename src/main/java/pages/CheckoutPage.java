package pages;

import org.openqa.selenium.WebDriver;

import static expected.CheckoutPageExpected.*;
import static expected.GeneralExpecteds.*;
import static locators.CartPageLocators.cartPageHeader;
import static locators.CheckoutPageLocators.*;
import static locators.OverviewPageLocators.overviewPageHeader;

public class CheckoutPage extends PageObject{
    public CheckoutPage(WebDriver driver) {

        super(driver);
    }

    public boolean checkCheckoutPageHeader() {
        openCheckoutPage();
        return getPageHeader(checkoutPageHeader).equals(EXPECTED_CHECKOUT_PAGE_HEADER);
    }
    public boolean checkCancelButtonProperty()
    {
        driver.findElement(cancelButton).click();
        return getPageHeader(cartPageHeader).equals(EXPECTED_CART_PAGE_HEADER);
    }
    public boolean checkContinueButtonProperty()
    {
        openOverviewPage();
        return driver.findElement(overviewPageHeader).getText().equals(EXPECTED_OVERVIEW_PAGE_HEADER);
    }
    public boolean checkContinueButtonPropertyWithoutName()
    {
        fillTheLastnameField();
        fillTheZipCodeField();
        driver.findElement(continueButton).click();
        System.out.println(driver.findElement(errorMessageField).getText());
        return driver.findElement(errorMessageField).getText().equals(FIRST_NAME_REQUIRED_MESSAGE);
    }
    public boolean checkContinueButtonPropertyWithoutLastname()
    {
        fillTheNameField();
        fillTheZipCodeField();
        driver.findElement(continueButton).click();
        return driver.findElement(errorMessageField).getText().equals(LAST_NAME_REQUIRED_MESSAGE);
    }
    public boolean checkContinueButtonPropertyWithoutZipCode()
    {
        fillTheNameField();
        fillTheLastnameField();
        driver.findElement(continueButton).click();
        return driver.findElement(errorMessageField).getText().equals(ZIP_CODE_REQUIRED_MESSAGE);
    }
    public boolean checkContinueButtonPropertyWithNullFields()
    {

        driver.findElement(continueButton).click();
        return driver.findElement(errorMessageField).getText().equals(FIRST_NAME_REQUIRED_MESSAGE);
    }

}
