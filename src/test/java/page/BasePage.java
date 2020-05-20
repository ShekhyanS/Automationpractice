package page;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static util.WebElementActionsUtil.*;


public abstract class BasePage {
    public static final String BASE_URL = "http://automationpractice.com";
    protected WebDriver driver;
    @FindBy(className = "login")
    private WebElement signIn;
    @FindBy(className = "logout")
    private WebElement logout;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected abstract String currentPageUrl();

    private String getPageFullUrl() {
        return BASE_URL + currentPageUrl();
    }

    public void openPage() {
        driver.get(getPageFullUrl());
    }

    public void clickSignIn() {
        signIn.click();
    }

    public void clickLogout() {
        logout.click();
    }

    public boolean userIsSignedOut() {
        return waitForElementBePresent(signIn);
    }


    public void mouseMoveClick(WebElement element) {
        Actions action = new Actions(driver);
        action.click(element).build().perform();

    }

    public  void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public  boolean isWebElementPresentByText(String xpath, String text) {
        try {
            xpathFormator(xpath, text);
            return true;
        } catch (NotFoundException e) {
            return false;
        }
    }

    public  WebElement xpathFormator(String xpath, String xpathVariableValue) {
        return driver.findElement(By.xpath(String.format(xpath, xpathVariableValue)));
    }

    public void performEnter(WebElement element) {
        Actions action = new Actions(driver);
        action.sendKeys(element, Keys.RETURN).build().perform();

    }

    public  void jsClick(WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }

}

