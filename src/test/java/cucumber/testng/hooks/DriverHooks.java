package cucumber.testng.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import model.User;
import org.openqa.selenium.WebDriver;
import service.UserCreator;

import java.net.MalformedURLException;

import static driver.DriverSingletone.browserTearDown;
import static driver.DriverSingletone.getDriver;

public class DriverHooks {
    protected WebDriver driver;


    @Before
    public void setupDriver() throws MalformedURLException {
        driver = getDriver();
    }

    @After
    public void closeDriver() {
       browserTearDown();
    }

}
