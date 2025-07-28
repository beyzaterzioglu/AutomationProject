package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.OverviewPage;

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
    public void checkCancelButtonProperty() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        OverviewPage overviewPage= new OverviewPage(driver);
        overviewPage.openOverviewPage();
        Assert.assertTrue(overviewPage.checkCancelButtonProperty());
    }
    @Test
    public void checkFinishButtonProperty() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        OverviewPage overviewPage= new OverviewPage(driver);
        overviewPage.openCompletePage();
        Assert.assertTrue(overviewPage.checkFinishButtonProperty());
    }


}
