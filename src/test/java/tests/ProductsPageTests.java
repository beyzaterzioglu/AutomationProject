package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;


import static expected.LoginPageExpected.*;
import static locators.ProductsPageLocators.itemAddtoCart;
import static locators.ProductsPageLocators.itemRemoveFromCart;
import static pages.ProductsPage.SortType.*;

public class ProductsPageTests extends BaseTest {



    @Test
    public void checkHeaderTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        ProductsPage productsPage=new ProductsPage(driver);
        Assert.assertTrue(productsPage.checkProductsPageHeader());
    }

    @Test
    public void checkAddtoCartButton() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        ProductsPage productsPage=new ProductsPage(driver);
        Assert.assertTrue(productsPage.checkAddToCart(itemAddtoCart,itemRemoveFromCart));
    }
    @Test
    public void sortNameAtoZ() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        ProductsPage productsPage=new ProductsPage(driver);
        Assert.assertTrue(productsPage.sortBy(NAME_A_TO_Z));
    }
    @Test
    public void sortNameZtoA() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        ProductsPage productsPage=new ProductsPage(driver);
        Assert.assertTrue(productsPage.sortBy(NAME_Z_TO_A));
    }
    @Test
    public void sortPriceHightoLow() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        ProductsPage productsPage=new ProductsPage(driver);
        Assert.assertTrue(productsPage.sortBy(PRICE_HIGH_TO_LOW));
    }
    @Test
    public void sortPriceLowtoHigh() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        ProductsPage productsPage=new ProductsPage(driver);
        Assert.assertTrue(productsPage.sortBy(PRICE_LOW_TO_HIGH));
    }



}
