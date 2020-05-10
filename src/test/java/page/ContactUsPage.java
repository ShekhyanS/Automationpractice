package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends BasePage{
   protected static final String CURRENT_PAGE_URL ="/index.php?controller=contact";

   @FindBy(id="id_contact")
   private WebElement subjectHeading;
   @FindBy(id="email")
   private WebElement emailAddress;
   @FindBy(id ="id_order")
   private WebElement orderRefference;
   @FindBy(id="fileUpload")
   private WebElement attachFile;
   @FindBy(id="message")
   private WebElement message;

   public ContactUsPage(WebDriver driver){
       super(driver);
   }

    @Override
    protected String currentPageUrl() {
        return CURRENT_PAGE_URL;
    }


}
