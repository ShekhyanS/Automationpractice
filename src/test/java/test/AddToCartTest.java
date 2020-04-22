package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;

public class AddToCartTest extends BaseTest {

    HomePage homePage;
    UserAuthenticationPage userAuthenticationPage;
    UserAccountPage userAccountPage;
    ShoppingCartPage shoppingCartPage;

    @Test
    public void addItemsToCartDeleteAndCheckoutTest() {
        homePage = new HomePage(driver);
        userAuthenticationPage = new UserAuthenticationPage(driver);
        userAccountPage = new UserAccountPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);

        homePage.openPage();
        homePage.clickSignIn();
        userAuthenticationPage.enterEmailAddress("lusinepapyan05@gmail.com");
        userAuthenticationPage.enterPassword("lusinePapyan");
        userAuthenticationPage.clickSubmitButton();
        userAccountPage.enterSearchTerm("Printed Summer Dress");
        userAccountPage.clickSearchSubmitButton();
        userAccountPage.addSearchResultProductsToCart();
        userAccountPage.openShoppingCart();

        shoppingCartPage.deleteItemFromCart("demo_6");
        Assert.assertFalse(shoppingCartPage.itemIsOnCart());
        shoppingCartPage.clickProceedCheckoutButton();
        shoppingCartPage.clickProcessAddressCheckoutButton();
        shoppingCartPage.agreeWithTerms();
        shoppingCartPage.clickProcessCarrierCheckoutButton();
        Assert.assertEquals(shoppingCartPage.getCartTotalPrice(),"$47.38" );

    }
}
