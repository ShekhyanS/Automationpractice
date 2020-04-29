package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.UserAccountPage;
import page.UserAuthenticationPage;

public class SignOutTest extends BaseTest {

    @Test
    public void signOutTest(){
        Assert.assertEquals(userAccountPage.getAccountName(), "Lusine Papyan");
        userAccountPage.clickLogout();
        Assert.assertTrue(userAccountPage.userIsSignedOut());
    }
}
