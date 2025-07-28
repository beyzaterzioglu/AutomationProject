package tests;

import base.BaseTest;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductsPage;

import static locators.ProductDetailsPageLocators.addToCartButton;
import static locators.ProductDetailsPageLocators.removeButton;

public class CartPageTests extends BaseTest {

    @Test
    public void checkAddCartButtonProperty() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        CartPage cartPage=new CartPage(driver);
        Assert.assertTrue( cartPage.checkItemHead());
    }
    @Test
    public void removeProductButton() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        CartPage cartPage=new CartPage(driver);
        Assert.assertTrue(cartPage.removeProduct());
    }
    @Test
    public void checkContinueShoppingProperty()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        CartPage cartPage=new CartPage(driver);
        cartPage.continueShopping();
        ProductsPage productsPage=new ProductsPage(driver);
        Assert.assertTrue(productsPage.checkProductsPageHeader());
    }
    @Test
    public void checkProductsNumber()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        CartPage cartPage=new CartPage(driver);
        cartPage.addToCartProducts(2);
        Assert.assertTrue( cartPage.checkTheNumberOfProducts(2));
    }
}
