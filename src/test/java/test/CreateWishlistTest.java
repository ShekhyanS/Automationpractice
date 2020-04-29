package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.*;

public class CreateWishlistTest extends BaseTest {

    UserWishlistPage userWishlistPage;
    ProductPage productPage;

    @BeforeMethod
    public void setup() {
        userWishlistPage = new UserWishlistPage(driver);
        productPage = new ProductPage(driver);
    }


    @Test
    public void createWishlistAndAddItemsTest() {
        userAccountPage.clickMyWishlist();
        userWishlistPage.enterWishlistName();
        userWishlistPage.clickSaveWishlistButton();
        Assert.assertTrue(userWishlistPage.wishlistIsCreated("Sona wishlist"));
        userWishlistPage.clickBestSellerProduct(0);
        productPage.clickWishlistButton();
        userWishlistPage.openPage();
        userAccountPage.clickMyWishlist();
        userWishlistPage.clickBestSellerProduct(1);
        productPage.clickWishlistButton();
        userWishlistPage.openPage();
        userAccountPage.clickMyWishlist();
        userWishlistPage.clickWishlistTitle();
        Assert.assertEquals(userWishlistPage.getProductsQuantityAddedToWishlist(), 2,"Product(s) are not added to the wishlist.");
        Assert.assertEquals(userWishlistPage.getWishlistItemsQuantity(), "2", "Wishlist items quantity is wrong.");
        userWishlistPage.deleteWishlist();
    }
}
