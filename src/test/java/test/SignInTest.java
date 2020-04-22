package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.BasePage;
import page.HomePage;
import page.UserAccountPage;
import page.UserAuthenticationPage;

public class SignInTest extends BaseTest {

    HomePage homePage;
    UserAuthenticationPage userAuthenticationPage;
    UserAccountPage userAccountPage;

    @Test
    public void signInWithRegisteredUserTest(){
        homePage = new HomePage(driver);
        userAuthenticationPage = new UserAuthenticationPage(driver);
        userAccountPage = new UserAccountPage(driver);
        homePage.openPage();
        homePage.clickSignIn();
        userAuthenticationPage.enterEmailAddress("lusinepapyan05@gmail.com");
        userAuthenticationPage.enterPassword("lusinePapyan");
        userAuthenticationPage.clickSubmitButton();
        Assert.assertEquals(userAccountPage.getAccountName(), "Lusine Papyan");
    }
}
