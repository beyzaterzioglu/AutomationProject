package tests.LoginPageTests;


import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

import static expected.LoginPageExpected.URL;

public class PositiveLoginPageTests extends BaseTest {

    @Test
    public void loginTest()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        ProductsPage productsPage=new ProductsPage(driver);
        Assert.assertTrue(productsPage.checkProductsPageHeader());

    }
    @Test
    public void logOutTest()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        ProductsPage productsPage=new ProductsPage(driver);
        productsPage.logOut();
        Assert.assertEquals(driver.getCurrentUrl(),URL);
    }
}
