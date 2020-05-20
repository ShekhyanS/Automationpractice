package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverSingletone {
    private static final String RESOURCES_PATH = "src/test/resources/";
    private static WebDriver driver;
    private static ChromeOptions chromeOptions;
    private static FirefoxOptions firefoxOptions;

    public static WebDriver initiateDriver() throws MalformedURLException {
        if (driver == null) {
            switch (System.getProperty("browser")) {
                case "firefox": {
                    firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("start-maximized");
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }
                case "remote": {
                    chromeOptions.setCapability("platformName", Platform.WINDOWS);
                    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
                }
                default: {
                    chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("start-maximized");
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(chromeOptions);
                }

            }
        }
        return driver;
    }

    public static void browserTearDown() throws InterruptedException {
        driver.quit();
        driver = null;
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
