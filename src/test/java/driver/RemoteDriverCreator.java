package driver;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteDriverCreator implements WebDriverCreator {
    private static ChromeOptions chromeOptions;
    @Override
    public WebDriver createWebDriver() throws MalformedURLException {
        chromeOptions.setCapability("platformName", Platform.WINDOWS);
        return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
    }
}
