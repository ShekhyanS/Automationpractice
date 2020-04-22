package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.UserAccountPage;
import page.UserAuthenticationPage;

public class SignOutTest extends BaseTest {

    HomePage homePage;
    UserAuthenticationPage userAuthenticationPage;
    UserAccountPage userAccountPage;

    @Test
    public void signOutTest(){
        homePage = new HomePage(driver);
        userAuthenticationPage = new UserAuthenticationPage(driver);
        userAccountPage = new UserAccountPage(driver);
        homePage.openPage();
        homePage.clickSignIn();
        userAuthenticationPage.enterEmailAddress("lusinepapyan05@gmail.com");
        userAuthenticationPage.enterPassword("lusinePapyan");
        userAuthenticationPage.clickSubmitButton();
        Assert.assertEquals(userAccountPage.getAccountName(), "Lusine Papyan");
        userAccountPage.clickLogout();
        Assert.assertTrue(userAccountPage.userIsSignedOut());
    }
}
