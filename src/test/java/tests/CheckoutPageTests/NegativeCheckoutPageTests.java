package tests.CheckoutPageTests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.LoginPage;

public class NegativeCheckoutPageTests extends BaseTest {
    @Test
    public void checkContinueButtonWithoutNameTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        CheckoutPage checkoutPage= new CheckoutPage(driver);
        checkoutPage.openCheckoutPage();
        Assert.assertTrue(checkoutPage.checkContinueButtonPropertyWithoutName());
    }
    @Test
    public void checkContinueButtonWithoutLastnameTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        CheckoutPage checkoutPage= new CheckoutPage(driver);
        checkoutPage.openCheckoutPage();
        Assert.assertTrue(checkoutPage.checkContinueButtonPropertyWithoutLastname());
    }
    @Test
    public void checkContinueButtonWithoutZipCodeTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        CheckoutPage checkoutPage= new CheckoutPage(driver);
        checkoutPage.openCheckoutPage();
        Assert.assertTrue(checkoutPage.checkContinueButtonPropertyWithoutZipCode());
    }
    @Test
    public void checkContinueButtonWithNullFieldsTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        CheckoutPage checkoutPage= new CheckoutPage(driver);
        checkoutPage.openCheckoutPage();
        Assert.assertTrue(checkoutPage.checkContinueButtonPropertyWithNullFields());
    }

}
