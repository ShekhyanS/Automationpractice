package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    protected static final String CURRENT_PAGE_URL = "/";

    @FindBy(id = "wishlist_button")
    private WebElement wishlistButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected String currentPageUrl() {
        return CURRENT_PAGE_URL;
    }

    public void clickWishlistButton(){
        waitForElementBePresent(wishlistButton);
        wishlistButton.click();
    }

}
