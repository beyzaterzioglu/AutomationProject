package tests.LoginPageTests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

import static expected.LoginPageExpected.*;
@Listeners(listeners.TestListener.class)
public class NegativeLoginPageTests extends BaseTest {
    @Test
    public void loginWithoutUsernameTest()
    {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertEquals(loginPage.loginWithoutUsername(),ERROR_MESSAGE_IF_USERNAME_IS_REQUIRED);
    }
    @Test
    public void loginWithoutPasswordTest()
    {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertEquals(loginPage.loginWithoutPassword(),ERROR_MESSAGE_IF_PASSWORD_IS_REQUIRED);

    }
    @Test
    public void invalidUsernameTest()
    {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertEquals(loginPage.invalidUsernameLogin(),ERROR_MESSAGE_IF_PASSWORD_OR_USERNAME_INVALID);
    }
    @Test
    public void invalidPasswordTest()
    {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertEquals(loginPage.invalidPasswordLogin(),ERROR_MESSAGE_IF_PASSWORD_OR_USERNAME_INVALID);

    }
    @Test
    public void nullLoginTest()
    {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertEquals(loginPage.nullLogin(),ERROR_MESSAGE_IF_USERNAME_IS_REQUIRED);

    }
}
