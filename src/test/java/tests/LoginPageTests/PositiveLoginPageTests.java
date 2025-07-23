package tests.LoginPageTests;


import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class PositiveLoginPageTests extends BaseTest {

    @Test
    public void loginTest()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        ProductsPage productsPage=new ProductsPage(driver);
        Assert.assertTrue(productsPage.checkProductsPageHeader());

    }
}
