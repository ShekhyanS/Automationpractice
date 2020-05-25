package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.OrderHistoryPage;

public class SeeOrderHistoryTest extends BaseTest {
    private OrderHistoryPage orderHistoryPage;


    @BeforeMethod
    public void setup() {
        orderHistoryPage = new OrderHistoryPage(driver);
    }

    @Test
    public void checkOrderStatusTest() {
        userAccountPage.clickOrderHistoryAndDetails();
        Assert.assertEquals(orderHistoryPage.getOrderStatusByReference("QGORPJEPG"), "On backorder");
    }
}
