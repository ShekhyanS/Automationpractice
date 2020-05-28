package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverCreator implements WebDriverCreator{
    private static FirefoxOptions firefoxOptions;

    @Override
    public WebDriver createWebDriver() {
        firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("start-maximized");
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
