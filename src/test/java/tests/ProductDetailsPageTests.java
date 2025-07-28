package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductsPage;

import static locators.ProductDetailsPageLocators.addToCartButton;
import static locators.ProductDetailsPageLocators.removeButton;

public class ProductDetailsPageTests extends BaseTest {
    @Test
    public void checkItemDetailsHeader() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        ProductDetailsPage productDetailsPage=new ProductDetailsPage(driver);
        Assert.assertTrue(productDetailsPage.checkItemDetailsHeader());
    }
    @Test
    public void checkBackToProductsButtonProperty()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        ProductDetailsPage productDetailsPage=new ProductDetailsPage(driver);
        productDetailsPage.backToProducts();
        ProductsPage productsPage=new ProductsPage(driver);
        Assert.assertTrue(productsPage.checkProductsPageHeader());
    }
    @Test
    public void checkAddtoCartButton() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        ProductDetailsPage productDetailsPage=new ProductDetailsPage(driver);
        productDetailsPage.openDetailPage();
        Assert.assertTrue(productDetailsPage.checkAddToCart(addToCartButton,removeButton));
    }

}
