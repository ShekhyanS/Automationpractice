package util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.BasePage;

import static driver.DriverSingletone.getDriver;

public class WebElementActionsUtil {
    protected static final int WAIT_TIMEOUT_SECONDS = 20;
    private static final Logger LOGGER = LogManager.getLogger(WebElementActionsUtil.class.getName());
    private static WebDriver driver = getDriver();

    public static void setChecked(WebElement element, boolean checked) {
        LOGGER.info("Turning checkbox on.");
        if (element.isSelected()) {
            if (!checked) {
                element.click();
            }
        } else {
            if (checked) {
                element.click();
            }
        }
    }

    public static void selectDropdownOption(WebElement dropdown, String dropdownOption) {
        LOGGER.info("Selecting option by visible text.");
        new Select(dropdown).selectByVisibleText(dropdownOption);
    }

    public static void enterText(WebElement element, String text) {
        LOGGER.info("Entering the text value: " + text);
        element.click();
        element.sendKeys(text);
    }

    public static String getWebElementText(WebElement element) {
        LOGGER.info("Getting WebElement text: " + element.getText());
        return element.getText().trim();
    }

    public static void scrollPage(String scrollValue) {
        LOGGER.info("Scroll page by: " + scrollValue);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0," + scrollValue + " )");
    }


    public static void performTab() {
        LOGGER.info("Clicking TAB button.");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.TAB).build().perform();
    }

    public static void highlightElement(WebDriver driver, WebElement element, String color) {
        LOGGER.info("Highlighting element background");
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
    }

    public static boolean waitForElementBePresent(WebElement element) {
        LOGGER.info("Waiting for element to be present for" +WAIT_TIMEOUT_SECONDS + "seconds.");
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        return wait.until(ExpectedConditions.not(ExpectedConditions.invisibilityOf(element)));
    }

    public static void waitForElementBeClickable(WebElement element) {
        LOGGER.info("Wait for element to be clickable for " + WAIT_TIMEOUT_SECONDS + "seconds.");
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
