package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test.BaseTest;

public class UserAuthenticationPage extends BasePage {

    protected static final String CURRENT_PAGE_URL ="/index.php?controller=authentication&back=my-account";

    @FindBy(id ="email")
    private WebElement emailAddressField;
    @FindBy(id ="passwd")
    private WebElement emailPasswordField;
    @FindBy(id ="SubmitLogin")
    private WebElement sbmitButton;

    public UserAuthenticationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected String currentPageUrl() {
        return CURRENT_PAGE_URL;
    }

    public void enterEmailAddress(String email){
        waitForElementBePresent(emailAddressField);
        enterText(emailAddressField, email);
    }

    public void enterPassword(String password){
       enterText(emailPasswordField, password);
    }

    public void clickSubmitButton(){
       sbmitButton.click();
    }


}
