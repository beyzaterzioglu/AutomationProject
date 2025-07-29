package tests.CheckoutPageTests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.LoginPage;

public class PositiveCheckoutPageTests extends BaseTest {
    @Test
    public void checkHeaderTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        CheckoutPage checkoutPage= new CheckoutPage(driver);
        checkoutPage.openCheckoutPage();
        Assert.assertTrue(checkoutPage.checkCheckoutPageHeader());
    }
    @Test
    public void checkCancelButtonTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        CheckoutPage checkoutPage= new CheckoutPage(driver);
        checkoutPage.openCheckoutPage();
        Assert.assertTrue(checkoutPage.checkCancelButtonProperty());
    }
    @Test
    public void checkContinueButtonTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        CheckoutPage checkoutPage= new CheckoutPage(driver);
        checkoutPage.openCheckoutPage();
        Assert.assertTrue(checkoutPage.checkContinueButtonProperty());
    }


}
