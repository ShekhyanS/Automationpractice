package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCartPage extends BasePage{
   protected static final String CURRENT_PAGE_URL ="/index.php?controller=order";

    String itemDeleteIcon = "//*[@class='cart_ref' and contains(text(), '%s')]//..//..//a[@class='cart_quantity_delete']";
    String itemTotalPrice = "//*[@class='cart_ref' and contains(text(), '%s')]//..//..//td[@class='cart_total']";

        @FindBy(xpath = "//a[@class='cart_quantity_delete']")
    private List<WebElement> deleteItemFromCartButton;
    @FindBy(id = "total_price")
    private WebElement cartTotalPrice;
    @FindBy(xpath = "//*[@class='cart_ref' and contains(text(), 'demo_6)]")
    private WebElement deletedItem;
    @FindBy(xpath = "//*[contains(@class,'cart_navigation clearfix')]/a")
    private WebElement proceedCheckoutButton;
    @FindBy(name = "processAddress")
    private WebElement processAddressCheckoutButton;
    @FindBy(name ="processCarrier")
    private WebElement processCarrierCheckoutButton;
    @FindBy(id="cgv")
    private WebElement agreeWithTerms;
   public ShoppingCartPage(WebDriver driver){
       super(driver);
   }

    @Override
    protected String currentPageUrl() {
        return CURRENT_PAGE_URL;
    }

    public void deleteItemFromCart(String skuValue) {
        driver.findElement(By.xpath(String.format(itemDeleteIcon, skuValue))).click();
    }

    public String getItemTotalPrice(String skuValue) {
        return driver.findElement(By.xpath(String.format(itemTotalPrice, skuValue))).getText();
    }

    public String getCartTotalPrice() {
        waitForElementBePresent(cartTotalPrice);
        return cartTotalPrice.getText();
    }

    public boolean itemIsOnCart(){

        try{
            waitForElementBePresent(deletedItem);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public void clickProceedCheckoutButton(){
        scrollPage("1000");
        waitForElementBePresent(proceedCheckoutButton);
        proceedCheckoutButton.click();
    }

    public void clickProcessAddressCheckoutButton(){
        waitForElementBePresent(processAddressCheckoutButton);
        processAddressCheckoutButton.click();
    }

    public void clickProcessCarrierCheckoutButton(){
        waitForElementBePresent(processCarrierCheckoutButton);
        processCarrierCheckoutButton.click();
    }

    public void agreeWithTerms(){
        setChecked(agreeWithTerms,true);
    }


}
