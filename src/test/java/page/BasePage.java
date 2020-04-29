package page;

import org.openqa.selenium.*;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class BasePage {
    protected WebDriver driver;
    protected final int WAIT_TIMEOUT_SECONDS = 10;
    public static final String BASE_URL = "http://automationpractice.com";

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

    public void openPage(){
        driver.get(getPageFullUrl());
    }

    public void clickSignIn(){
        signIn.click();
    }

    public void clickLogout(){
        logout.click();
    }

    public boolean userIsSignedOut(){
        return waitForElementBePresent(signIn);
    }

    public void enterText(WebElement element, String text){
        element.click();
        element.sendKeys(text);
    }

    public String getWebElementText(WebElement element){
        return element.getText().trim();
    }

    public boolean waitForElementBePresent(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        return wait.until(ExpectedConditions.not(ExpectedConditions.invisibilityOf(element)));
    }

    public boolean isWebElementPresentByText(String xpath, String text){
        try{
            xpathFormator(xpath, text);
            return true;
        }catch (NotFoundException e){
            return false;
        }
    }

    public void scrollPage(String scrollValue){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,"+ scrollValue + " )");
    }

    public void setChecked(WebElement element, boolean checked){
        if(element.isSelected()){
            if(!checked){
                element.click();
            }
        } else {
            if(checked){
                element.click();
            }
        }
    }

    public void selectDropdownOption(WebElement dropdown, String dropdownOption){
        new Select(dropdown).selectByVisibleText(dropdownOption);
    }

    public WebElement xpathFormator(String xpath, String xpathVariableValue) {
        return driver.findElement(By.xpath(String.format(xpath, xpathVariableValue)));
    }

    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }


}

