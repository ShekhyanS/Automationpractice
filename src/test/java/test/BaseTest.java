package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import page.HomePage;
import page.UserAccountPage;
import page.UserAuthenticationPage;

public class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;
    protected UserAuthenticationPage userAuthenticationPage;
    protected UserAccountPage userAccountPage;

    @BeforeTest(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
    }

    @BeforeMethod(alwaysRun = true)
    public void accountLogin(){
        homePage = new HomePage(driver);
        userAuthenticationPage = new UserAuthenticationPage(driver);
        userAccountPage = new UserAccountPage(driver);
        homePage.openPage();
        homePage.clickSignIn();
        userAuthenticationPage.enterEmailAddress("lusinepapyan05@gmail.com");
        userAuthenticationPage.enterPassword("lusinePapyan");
        userAuthenticationPage.clickSubmitButton();
    }

    @AfterTest(alwaysRun = true)
    public void browserTearDown() throws InterruptedException {
//        driver.quit();
//        driver = null;
    }

}
