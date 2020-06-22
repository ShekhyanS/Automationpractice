package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.NoSuchElementException;

import static util.WebElementActionsUtil.*;

public class OrderHistoryPage extends BasePage{
   protected static final String CURRENT_PAGE_URL ="/index.php?controller=history";

   String orderLinkByReference = "//*[contains(text(), '%s')]/../..//*[contains(@class,'history_state')]/span";
   String orderLinkByTitle = "//*[contains(text(), '%s')]/../..//*[contains(@class,'history_link')]/a";

   public OrderHistoryPage(WebDriver driver){
       super(driver);
   }

    @Override
    protected String currentPageUrl() {
        return CURRENT_PAGE_URL;
    }

    public String getOrderStatusByReference(String orderReference){
       WebElement element = xpathFormator(orderLinkByReference, "QGORPJEPG");
       return getWebElementText(element);

    }

    public boolean ordersListIsDisplayed(List<String> orders){
       boolean orderIsOnList=false;
       for(String order: orders){
           try {
               WebElement element = xpathFormator(orderLinkByTitle, order);
               orderIsOnList = true;
           } catch (NoSuchElementException e){
               orderIsOnList =false;
           }
       }
       return orderIsOnList;
    }

}
