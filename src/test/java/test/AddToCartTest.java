package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import page.*;

public class AddToCartTest extends BaseTest {

    private ShoppingCartPage shoppingCartPage;

    @BeforeMethod
    public void setup() {
        shoppingCartPage = new ShoppingCartPage(driver);
    }

    @Ignore("There is a change on the page. Test should be refactored according ot changes")
    @Test()
    public void addItemsToCartDeleteAndCheckoutTest() {
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
