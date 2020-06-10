package cucumber.testng.steps;


import io.cucumber.java.en.And;

import io.cucumber.java.en.Then;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import page.OrderHistoryPage;
import page.UserAccountPage;


import java.net.MalformedURLException;
import java.util.List;

import static driver.DriverSingletone.getDriver;

public class ViewOrdersSteps {
    protected WebDriver driver = getDriver() ;

    private UserAccountPage userAccountPage = new UserAccountPage(driver);
    private OrderHistoryPage orderHistoryPage = new OrderHistoryPage(driver);

    public ViewOrdersSteps() throws MalformedURLException {

    }

    @And("^the user clicks (.*) option")
    public void clickOrderHistoryAndDetailsButton(String name) {
        userAccountPage.clickOrderHistoryAndDetails();

    }

    @Then("the list of following orders is displayed")
    public void listOfOrdersIsDisplayed(List<String> orders) {
       Assert.assertTrue(orderHistoryPage.ordersListIsDisplayed(orders));
    }
}
