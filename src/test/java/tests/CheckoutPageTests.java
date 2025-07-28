package tests;

import base.BaseTest;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.google.gson.internal.NonNullElementWrapperList;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;

public class CheckoutPageTests extends BaseTest {
    @Test
    public void checkHeaderTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        CheckoutPage checkoutPage= new CheckoutPage(driver);
        checkoutPage.openCheckoutPage();
        Assert.assertTrue(checkoutPage.checkCheoutPageHeader());
    }
}
