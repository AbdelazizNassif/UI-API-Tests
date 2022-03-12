package pages.cartPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.CheckoutPage.CheckoutPage;

public class CartPage {

    private WebDriver driver;

    // constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final String QUANTITY_OF_ITEMS = "(//div[@class='cart_quantity'])[%s]" ;
    private static final String TITLES_OF_ITEMS = "(//div[@class='inventory_item_name'])[%s]" ;
    private static final String DESCRIPTION_OF_ITEMS = "(//div[@class='inventory_item_desc'])[%s]" ;
    private static final String PRICE_OF_ITEMS = "(//div[@class='inventory_item_price'])[%s]" ;
    private static final By CHECKOUT_BUTTON = By.id("checkout");

    private By findQuantityByIndex (int productIndex) {
        String xpath = String.format(QUANTITY_OF_ITEMS, productIndex);
        return By.xpath(xpath) ;
    }
    public String getQuantityOfAddedItems (int productIndex)
    {
        return driver.findElement(findQuantityByIndex(productIndex)).getText();
    }
    private By findTitleByIndex (int productIndex) {
        String xpath = String.format(TITLES_OF_ITEMS, productIndex);
        return By.xpath(xpath) ;
    }
    public String getTitleOfAddedItems (int productIndex)
    {
        return driver.findElement(findTitleByIndex(productIndex)).getText();
    }
    private By findDescriptionByIndex (int productIndex) {
        String xpath = String.format(DESCRIPTION_OF_ITEMS, productIndex);
        return By.xpath(xpath) ;
    }
    public String getDescriptionOfAddedItems (int productIndex)
    {
        return driver.findElement(findDescriptionByIndex(productIndex)).getText();
    }
    private By findPriceByIndex (int productIndex) {
        String xpath = String.format(PRICE_OF_ITEMS, productIndex);
        return By.xpath(xpath) ;
    }
    public String getPriceOfAddedItems (int productIndex)
    {
        return driver.findElement(findPriceByIndex(productIndex)).getText();
    }
    public CheckoutPage clickCheckoutButton ()
    {
        driver.findElement(CHECKOUT_BUTTON).click();
        return new CheckoutPage(driver) ;
    }

}
