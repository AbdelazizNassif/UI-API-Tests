package pages.homePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.cartPage.CartPage;

public class HomePage {

    private WebDriver driver;

    // constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // locators of primary header
    private final static By APP_LOGO = By.xpath("//div[@class='app_logo']");
    private final static By LEFT_BURGER_MENU = By.id("react-burger-menu-btn");
    private final static By SHOPPING_CART_LINK = By.xpath("//div[@id='shopping_cart_container']/a");
    private final static By NUMBER_OF_ADDED_ITEMS = By.xpath("//div[@id='shopping_cart_container']/a/span");

    // locators of secondary header
    private final static By SEC_HEADER_TITLE = By.
            xpath("//div[@class='header_secondary_container']//span[@class='title']");
    private final static By SEC_HEADER_RIGHT_DROPDOWN = By.xpath("//div[@class='right_component']");
    private final static By SEC_HEADER_RIGHT_DROPDOWN_ACTIVE_OPTION = By.
            xpath("//div[@class='right_component']/span/span");
    // locators of displayed products
    By INITIAL_DISPLAYED_PRODUCTS = By.xpath("//div[@class='inventory_item_desc']");
    By SAUCE_LABS_BACKPACK_ADD_TO_CART = By.id("add-to-cart-sauce-labs-backpack");
    By SAUCE_LABS_BACKPACK_REMOVE_FROM_CART = By.id("remove-sauce-labs-backpack");
    By SAUCE_LABS_BACKPACK_PRICE = By.xpath
            ("//div[@class=\"inventory_item_price\"][following::button[@id=\"remove-sauce-labs-backpack\"] or following::button[@id=\"add-to-cart-sauce-labs-backpack\"]]");
    By SAUCE_LABS_BACKPACK_TITLE = By.xpath
            ("//div[@class=\"inventory_item_name\"][following::button[@id=\"remove-sauce-labs-backpack\"] or following::button[@id=\"add-to-cart-sauce-labs-backpack\"]]");
    By SAUCE_LABS_BACKPACK_DESCRIPTION = By.xpath
        ("//div[@class=\"inventory_item_desc\"][following::button[@id=\"remove-sauce-labs-backpack\"] or following::button[@id=\"add-to-cart-sauce-labs-backpack\"]]") ;
    // page operations
    public boolean isAppPrimaryHeaderContentsDisplayed() {
        return (driver.findElement(APP_LOGO).isDisplayed()
                && driver.findElement(LEFT_BURGER_MENU).isDisplayed()
                && driver.findElement(SHOPPING_CART_LINK).isDisplayed()
        );
    }

    public String getAppSecondaryHeaderTitle() {
        if (driver.findElement(SEC_HEADER_TITLE).isDisplayed()) {
            return driver.findElement(SEC_HEADER_TITLE).getText();
        } else {
            Assert.fail("The secondary header title should be displayed");
        }
        return "Failed Test Case";
    }

    public String getAppSecondaryHeaderSortingDropdownActiveOption() {
        if (driver.findElement(SEC_HEADER_RIGHT_DROPDOWN).isDisplayed()) {
            return driver.findElement(SEC_HEADER_RIGHT_DROPDOWN_ACTIVE_OPTION).getText();
        } else {
            Assert.fail("The active option should be [Name (A to Z)]");
        }
        return "Failed Test Case";
    }

    public int getInitialNumberOfDisplayedProducts() {
        return driver.findElements(INITIAL_DISPLAYED_PRODUCTS).size();
    }

    public void addBackpackToCart ()
    {
        driver.findElement(SAUCE_LABS_BACKPACK_ADD_TO_CART).click();
        //return driver.findElement(SAUCE_LABS_BACKPACK_REMOVE_FROM_CART).isDisplayed();
    }
    public boolean isAddToCartButtonDisplayed ()
    {
        return driver.findElement(SAUCE_LABS_BACKPACK_ADD_TO_CART).isDisplayed();
    }
    public boolean isRemoveButtonDisplayed ()
    {
        return driver.findElement(SAUCE_LABS_BACKPACK_REMOVE_FROM_CART).isDisplayed();
    }
    public void clickRemoveBackpackButton()
    {
        driver.findElement(SAUCE_LABS_BACKPACK_REMOVE_FROM_CART).click();
    }
    public String getBackpackTitle ()
    {
        return driver.findElement(SAUCE_LABS_BACKPACK_TITLE).getText() ;
    }
    public String getBackpackDescription ()
    {
        return driver.findElement(SAUCE_LABS_BACKPACK_DESCRIPTION).getText() ;
    }
    public String getBackpackPrice ()
    {
        return driver.findElement(SAUCE_LABS_BACKPACK_PRICE).getText() ;
    }
    public CartPage clickShoppingCartLink ()
    {
        driver.findElement(SHOPPING_CART_LINK).click(); ;
        return new CartPage(driver);
    }
    public String  getNumberOfItemsAddedToTheCard ()
    {
        System.out.println(driver.findElement(NUMBER_OF_ADDED_ITEMS).getText());
        return driver.findElement(NUMBER_OF_ADDED_ITEMS).getText();
    }
}
