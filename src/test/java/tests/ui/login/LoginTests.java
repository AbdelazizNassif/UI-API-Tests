package tests.ui.login;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.homePage.HomePage;
import tests.ui.TestBase;

public class LoginTests extends TestBase {
    HomePage homePage = null;
    SoftAssert softAssert = null;

    @BeforeMethod
    public void setupLoginTests ()
    {
        driver.get(baseUrl);
        softAssert = new SoftAssert();
    }

    @Test(description = "Test Valid Login With Std Credentials")
    public void testLoginAsStandardUserWithValidCredentials() {
        homePage = loginPage.loginToApp(stdUsername, stdPassword);
        softAssert.assertTrue(homePage.isAppPrimaryHeaderContentsDisplayed(),
                "The Logo is supposed to be displayed");
        softAssert.assertEquals(homePage.getAppSecondaryHeaderTitle(), "PRODUCTS",
                "The title should be PRODUCTS");
        softAssert.assertEquals(homePage.getAppSecondaryHeaderSortingDropdownActiveOption(), "NAME (A TO Z)",
                "The active option should be [NAME (A TO Z)");
        softAssert.assertEquals(homePage.getInitialNumberOfDisplayedProducts(), 6,
                "The page should display 6 products initially");
        softAssert.assertAll("Some Login assertion are not as expected");
    }

}
