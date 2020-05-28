package driver;

import org.openqa.selenium.WebDriver;
import java.net.MalformedURLException;

public class DriverSingletone {
    private static final String RESOURCES_PATH = "src/test/resources/";
    private static WebDriver driver;

    public static WebDriver initiateDriver() throws MalformedURLException {

        switch (System.getProperty("browser")) {
            case "firefox": {
                FirefoxDriverCreator firefoxDriverCreator = new FirefoxDriverCreator();
                driver = firefoxDriverCreator.createWebDriver();
            }
            case "remote": {
                 RemoteDriverCreator remoteDriverCreator = new RemoteDriverCreator();
                 driver = remoteDriverCreator.createWebDriver();
            }
            default: {
                ChromeDriverCreator chromeDriverCreator = new ChromeDriverCreator();
                driver = chromeDriverCreator.createWebDriver();
            }

        }

        return driver;
    }

    public static void browserTearDown() {
        driver.quit();
        driver = null;
    }

    public static WebDriver getDriver() throws MalformedURLException {
        if (driver == null) {
            initiateDriver();
        }
        return driver;
    }
}
