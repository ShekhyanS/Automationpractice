package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.ContactUsPage;

import java.io.IOException;

public class ContuctUsTest extends BaseTest {
    ContactUsPage contactUsPage;

    @BeforeMethod
    public void setup(){
        contactUsPage = new ContactUsPage(driver);
    }

    @Test
    public void sendContactUsMessage() throws IOException, InterruptedException {
        userAccountPage.clickContactUsLink();
        contactUsPage.selectSubjectHeading("Webmaster");
        contactUsPage.selectOrderReference("QGORPJEPG - 04/29/2020");
        contactUsPage.selectProduct("Faded Short Sleeve T-shirts - Color : Orange, Size : M");
        contactUsPage.sendMessage("Hello", "green");
        //contactUsPage.brouseFile("test");
        Assert.assertEquals(contactUsPage.getAlertMessage(),"Your message has been successfully sent to our team.");
        contactUsPage.clickBackButton();
        Assert.assertEquals(userAccountPage.getAccountName(), "Lusine Papyan");

    }







}
