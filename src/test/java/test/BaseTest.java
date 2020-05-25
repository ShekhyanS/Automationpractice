package test;

import driver.DriverSingletone;
import model.User;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import page.HomePage;
import page.UserAccountPage;
import page.UserAuthenticationPage;
import service.UserCreator;

import java.net.MalformedURLException;

import static driver.DriverSingletone.*;

public class BaseTest {

    private HomePage homePage;
    private UserAuthenticationPage userAuthenticationPage;
    protected UserAccountPage userAccountPage;

    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void accountLogin() throws MalformedURLException {
        driver = initiateDriver();
        User testUser = new UserCreator().userWithCredentials();
        homePage = new HomePage(driver);
        userAuthenticationPage = new UserAuthenticationPage(driver);
        userAccountPage = new UserAccountPage(driver);
        homePage.openPage();
        homePage.clickSignIn();
        userAuthenticationPage.login(testUser);
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() throws InterruptedException {
        browserTearDown();
    }
}
