package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static util.WebElementActionsUtil.*;

public class UserAccountPage extends BasePage {
    protected static final String CURRENT_PAGE_URL = "/index.php?controller=my-account";


    @FindBy(className = "logout")
    private WebElement signOut;
    @FindBy(xpath = "//*[@class='account']/span")
    private WebElement accountName;
    @FindBy(xpath = "//span[contains(text(), 'My wishlists')]")
    private WebElement myWishlist;
    @FindBy(name = "submit_search")
    private WebElement searchSubmitButton;
    @FindBy(id = "search_query_top")
    private WebElement searchField;
    @FindBy(xpath = " //a[contains(@class,'add_to_cart')]")
    private List<WebElement> addToCardButtons;
    @FindBy(className = "cross")
    private WebElement closePopupIcon;
    @FindBy(xpath = "//*[@class='shopping_cart']/a")
    private WebElement shoppingCartButton;
    @FindBy(xpath = "//a[contains(@href,'controller=addresses')]")
    private WebElement myAddressLink;
    @FindBy(xpath = "//a[contains(@href,'controller=history')]")
    private WebElement orderHistoryAndDetailsLink;
    @FindBy(xpath = "//*[@id='contact-link']/a")
    private WebElement contactusLink;

    public UserAccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected String currentPageUrl() {
        return CURRENT_PAGE_URL;
    }

    public String getAccountName() {
        return accountName.getText();
    }

    public void clickSignOut() {
        signOut.click();
    }

    public void clickMyWishlist() {
        waitForElementBePresent(myWishlist);
        myWishlist.click();
    }

    public void clickSearchSubmitButton() {
        searchSubmitButton.click();
    }

    public void enterSearchTerm(String searchItem) {
        waitForElementBePresent(searchField);
        enterText(searchField, searchItem);
    }

    public void addSearchResultProductsToCart() {
        for (WebElement addToCartBtn : addToCardButtons) {
            addToCartBtn.click();
            waitForElementBePresent(closePopupIcon);
            closePopupIcon.click();

        }
    }

    public void openShoppingCart() {
        waitForElementBePresent(shoppingCartButton);
        shoppingCartButton.click();
    }

    public void clickMyAddress() {
        waitForElementBePresent(myAddressLink);
        myAddressLink.click();
    }

    public void clickOrderHistoryAndDetails() {
        waitForElementBePresent(orderHistoryAndDetailsLink);
        orderHistoryAndDetailsLink.click();
    }

    public void clickContactUsLink() {
        waitForElementBePresent(contactusLink);
        mouseMoveClick(contactusLink);

    }
}
