package cucumber.testng.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.User;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page.HomePage;
import page.UserAccountPage;
import page.UserAuthenticationPage;
import service.UserCreator;


import java.net.MalformedURLException;

import static driver.DriverSingletone.getDriver;

public class SignInSteps {
    protected WebDriver driver = getDriver();
    public User testUser = new UserCreator().userWithCredentials();

    private HomePage homePage = new HomePage(driver);
    private UserAuthenticationPage userAuthenticationPage = new UserAuthenticationPage(driver);
    protected   UserAccountPage userAccountPage = new UserAccountPage(driver);

    public SignInSteps() throws MalformedURLException {

    }

    @Given("the user opens online shop website")
    public void openOnlineShopWebsite() {
        homePage.openPage();
    }

    @When("the user clicks Sign In link")
    public void clickSignInLink() {
        homePage.clickSignIn();
    }

    @When("the user enters valid username")
    public void enterValidUsername() {
        userAuthenticationPage.enterEmailAddress(testUser.getUsername());

    }

    @When("the user enters valid password")
    public void enterValidPassword(){
        userAuthenticationPage.enterPassword(testUser.getPassword());
    }

    @When("the user clicks Sign In button")
    public void clickSignInButton() {
        userAuthenticationPage.clickSubmitButton();
    }

    @Then("{string} user account page is displayed")
    public void verifyAccountNamePresence(String accountName) {
        Assert.assertEquals(userAccountPage.getAccountName(), accountName);
    }


}
