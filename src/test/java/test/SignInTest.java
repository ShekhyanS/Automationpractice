package test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest extends BaseTest {

    @Test
    public void signInWithRegisteredUserTest(){
       Assert.assertEquals(userAccountPage.getAccountName(), "Lusine Papyan");
    }
}
