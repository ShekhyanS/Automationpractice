package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;

public class CreateWishlistTest extends BaseTest {

    HomePage homePage;
    UserAuthenticationPage userAuthenticationPage;
    UserAccountPage userAccountPage;
    UserWishlistPage userWishlistPage;
    ProductPage productPage;

    @Test
    public void createWishlistAndAddItemsTest() {
        homePage = new HomePage(driver);
        userAuthenticationPage = new UserAuthenticationPage(driver);
        userAccountPage = new UserAccountPage(driver);
        userWishlistPage = new UserWishlistPage(driver);
        productPage = new ProductPage(driver);


        homePage.openPage();
        homePage.clickSignIn();
        userAuthenticationPage.enterEmailAddress("lusinepapyan05@gmail.com");
        userAuthenticationPage.enterPassword("lusinePapyan");
        userAuthenticationPage.clickSubmitButton();
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
