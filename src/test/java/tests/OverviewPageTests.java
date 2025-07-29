package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.OverviewPage;
import pages.ProductsPage;

import static locators.ProductsPageLocators.itemAddtoCart;

public class OverviewPageTests extends BaseTest {
    @Test
    public void checkHeaderTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        OverviewPage overviewPage= new OverviewPage(driver);
        overviewPage.openOverviewPage();
        Assert.assertTrue(overviewPage.checkOverviewPageHeader());
    }
    @Test
    public void checkCancelButtonPropertyTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        OverviewPage overviewPage= new OverviewPage(driver);
        overviewPage.openOverviewPage();
        Assert.assertTrue(overviewPage.checkCancelButtonProperty());
    }
    @Test
    public void checkFinishButtonPropertyTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        OverviewPage overviewPage= new OverviewPage(driver);
        overviewPage.openCompletePage();
        Assert.assertTrue(overviewPage.checkFinishButtonProperty());
    }
    @Test
    public void checkProductDetailsTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        ProductsPage productsPage=new ProductsPage(driver);
        productsPage.addToCart(itemAddtoCart);
        OverviewPage overviewPage= new OverviewPage(driver);
        overviewPage.openOverviewPage();
        Assert.assertTrue(overviewPage.checkProductDetails());
    }


}
