package tests.ui.cart;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.cartPage.CartPage;
import pages.homePage.HomePage;
import tests.ui.TestBase;

public class CartTests extends TestBase {
    HomePage homePage = null ;
    SoftAssert softAssert = null ;

    @BeforeMethod
    public void setupCartTests ()
    {
        driver.get(baseUrl);
        homePage = loginPage.loginToApp(stdUsername, stdPassword);
        softAssert = new SoftAssert();
    }
    String backpackTitle_homePage;
    String backpackDescription_homePage;
    String backpackPrice_homePage;
    @Test(priority = 1)
    public void checkTheDataOfTheBackpack () {
        backpackTitle_homePage = homePage.getBackpackTitle();
        softAssert.assertEquals(backpackTitle_homePage, "Sauce Labs Backpack");
        backpackDescription_homePage = homePage.getBackpackDescription();
        softAssert.assertTrue(backpackDescription_homePage.contains("laptop and tablet protection."), "Sauce Labs Backpack");
        backpackPrice_homePage = homePage.getBackpackPrice();
        softAssert.assertEquals(backpackPrice_homePage, "$29.99");
        softAssert.assertAll("Some of Cart assertions are not as expected");
    }
    @Test (priority = 2)
    public void clickAddItemsToCartThenCheckExistenceOfRemoveButton () {
        homePage.addBackpackToCart();
        softAssert.assertTrue(homePage.isRemoveButtonDisplayed(),
                "The remove from card button should be displayed");
        homePage.clickRemoveBackpackButton();
        softAssert.assertTrue(homePage.isAddToCartButtonDisplayed(),
                "The add to cart button should be displayed");
        softAssert.assertAll("Some of Cart assertions are not as expected");
    }

    @Test (priority = 3)
    public void checkThatTheItemsAddedWillReflectOnTheShoppingCart () {
        homePage.addBackpackToCart();
        softAssert.assertEquals(homePage.getNumberOfItemsAddedToTheCard(), "1",
                "The number of items added should be only 1");
        CartPage cartPage = homePage.clickShoppingCartLink() ;
        softAssert.assertEquals(cartPage.getQuantityOfAddedItems(1), "1",
                "The quantity of items should be only 1");
        softAssert.assertEquals(cartPage.getDescriptionOfAddedItems(1), backpackDescription_homePage);
        softAssert.assertEquals(cartPage.getTitleOfAddedItems(1), backpackTitle_homePage);
        softAssert.assertEquals(cartPage.getPriceOfAddedItems(1), backpackPrice_homePage);
        softAssert.assertAll("Some of Cart assertions are not as expected");
    }
}
