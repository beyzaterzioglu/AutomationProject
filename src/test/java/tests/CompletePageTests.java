package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.CompletePage;
import pages.LoginPage;
import pages.OverviewPage;

public class CompletePageTests extends BaseTest {
    @Test
    public void checkTheMessage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        CompletePage completePage=new CompletePage(driver);
        completePage.openCompletePage();
        Assert.assertTrue(completePage.checkMessage());
    }
    @Test
    public void checkBackHomeButtonProperty() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        CompletePage completePage=new CompletePage(driver);
        completePage.openCompletePage();
        Assert.assertTrue(completePage.checkBackHomeButtonProperty());
    }
}
