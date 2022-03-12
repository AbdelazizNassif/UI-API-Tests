package tests.ui.checkout;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CheckoutPage.CheckoutCompletionPage;
import pages.CheckoutPage.CheckoutOverviewPage;
import pages.CheckoutPage.CheckoutPage;
import pages.cartPage.CartPage;
import pages.homePage.HomePage;
import tests.ui.TestBase;

import static utils.filesReaders.JsonReader.getJsonValue;

public class CheckoutTests extends TestBase {
    HomePage homePage = null ;
    SoftAssert softAssert = null ;
    // Test data
    String firstName = null;
    String lastName = null;
    String zipCode = null;

    private void loadCheckoutTestData ()
    {
        firstName = getJsonValue("checkoutTestDataJson.json" , "firstName");
        lastName = getJsonValue("checkoutTestDataJson.json" , "lastName");
        zipCode = getJsonValue("checkoutTestDataJson.json" , "zipCode");
    }

    @BeforeMethod
    public void setupCheckoutTests ()
    {
        loadCheckoutTestData();
        driver.get(baseUrl);
        homePage = loginPage.loginToApp(stdUsername, stdPassword);
        softAssert = new SoftAssert();
    }
    @Test
    public void testCheckoutToCompleteTheOrder ()
    {
        homePage.addBackpackToCart();
        CartPage cartPage = homePage.clickShoppingCartLink() ;
        CheckoutPage checkoutPage = cartPage.clickCheckoutButton () ;
        CheckoutOverviewPage checkoutOverviewPage =
                checkoutPage.fillCheckoutFormThenClickContinue(firstName, lastName, zipCode);

        CheckoutCompletionPage checkoutCompletionPage = checkoutOverviewPage.clickFinishButton();
        softAssert.assertEquals(checkoutCompletionPage.getOrderCompletionHeader(),
                "THANK YOU FOR YOUR ORDER");
        softAssert.assertEquals(checkoutCompletionPage.getOrderCompletionText(),
                "Your order has been dispatched, and will arrive just as fast as the pony can get there!");
        softAssert.assertAll("Some of Checkout assertions are not as expected");
    }
}
