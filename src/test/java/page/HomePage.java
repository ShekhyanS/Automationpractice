package page;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
   protected static final String CURRENT_PAGE_URL ="/index.php";


   public HomePage(WebDriver driver){
       super(driver);
   }

    @Override
    protected String currentPageUrl() {
        return CURRENT_PAGE_URL;
    }


}
