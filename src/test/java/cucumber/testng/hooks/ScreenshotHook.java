package cucumber.testng.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

import static driver.DriverSingletone.getDriver;

public class ScreenshotHook {
    public static final String PNG_FILE_EXTENSION = "image/png";
    protected WebDriver driver ;

    @After
    public void takeScreenshot(Scenario scenario) throws MalformedURLException {
        driver = getDriver();
        scenario.write(driver.getCurrentUrl());
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, PNG_FILE_EXTENSION, scenario.getName());
    }
}
