package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.BasePage;
import page.HomePage;
import page.UserAccountPage;
import page.UserAuthenticationPage;

public class SignInTest extends BaseTest {

    @Test
    public void signInWithRegisteredUserTest(){
       Assert.assertEquals(userAccountPage.getAccountName(), "Lusine Papyan");
    }
}
