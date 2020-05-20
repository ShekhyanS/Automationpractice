package util;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static driver.DriverSingletone.getDriver;

public class WebElementActionsUtil {
    private static WebDriver driver = getDriver();
    protected static final int WAIT_TIMEOUT_SECONDS = 20;
    public static void setChecked(WebElement element, boolean checked) {
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
        new Select(dropdown).selectByVisibleText(dropdownOption);
    }

    public static void enterText(WebElement element, String text) {
        element.click();
        element.sendKeys(text);
    }

    public static String getWebElementText(WebElement element) {
        return element.getText().trim();
    }

    public static void scrollPage(String scrollValue) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0," + scrollValue + " )");
    }


    public static void performTab() {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.TAB).build().perform();

    }

    public static void highlightElement(WebDriver driver, WebElement element, String color) {
        {
            JavascriptExecutor js = ((JavascriptExecutor) driver);
            js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);

        }
    }

    public static boolean waitForElementBePresent(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        return wait.until(ExpectedConditions.not(ExpectedConditions.invisibilityOf(element)));
    }

    public static void waitForElementBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
