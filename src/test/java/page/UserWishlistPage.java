package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UserWishlistPage extends BasePage {
    protected static final String CURRENT_PAGE_URL = "/index.php?controller=my-account";

    private String wishlistName = "Sona wishlist";

    @FindBy(id = "name")
    private WebElement wishlistNameField;
    @FindBy(id = "submitWishlist")
    private WebElement saveWishlistButton;
    @FindBy(xpath = "//*[starts-with(@id,'wishlist')]//a")
    private List<WebElement> wishlists;
    @FindBy(xpath = "//a[@class='product-name']")
    private List<WebElement> topsellers;
    @FindBy(id="s_title")
    private List<WebElement> wishlistItems;
    @FindBy(linkText = "Sona wishlist")
    private WebElement wishlistTitle;
    @FindBy(id="showSendWishlist")
    private WebElement sendThisWishlistButton;
    @FindBy(xpath = "//tr[starts-with(@id,'wishlist')]/td[2]")
    private WebElement wishlistItemsQuantity;
    @FindBy(xpath = "//*[@class='wishlist_delete']/a")
    private WebElement deleteWishlist;

    public UserWishlistPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected String currentPageUrl() {
        return CURRENT_PAGE_URL;
    }

    public void enterWishlistName() {
        waitForElementBePresent(wishlistNameField);
        enterText(wishlistNameField, wishlistName);
    }

    public String getWishlistName() {
        return wishlistName;
    }

    public void clickSaveWishlistButton() {
        saveWishlistButton.click();
    }

    public boolean wishlistIsCreated(String wishlistName) {
        boolean isPresent = false;
        for (WebElement wishlist : wishlists) {
            if ((wishlist.getText()).equals(wishlistName)) {
                System.out.println(wishlist.getText());
                isPresent = true;
                break;
            }

        }
        return isPresent;
    }


    public void clickBestSellerProduct(int index) {
        topsellers.get(index).click();
    }

    public int getProductsQuantityAddedToWishlist(){
        waitForElementBePresent(sendThisWishlistButton);
        return wishlistItems.size();
    }

    public void clickWishlistTitle(){
        wishlistTitle.click();
    }

    public String getWishlistItemsQuantity(){
        return wishlistItemsQuantity.getText();
    }

    public void deleteWishlist(){
        deleteWishlist.click();
        acceptAlert();
    }

}
