package pages.CheckoutPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    private WebDriver driver;

    // constructor
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By FIRST_NAME = By.id("first-name");
    private static final By LAST_NAME = By.id("last-name");
    private static final By ZIP_CODE = By.id("postal-code");
    private static final By CONTINUE_BUTTON = By.id("continue");

    public CheckoutOverviewPage fillCheckoutFormThenClickContinue(String firstName, String lastName, String zipCode) {
        driver.findElement(FIRST_NAME).sendKeys(firstName);
        driver.findElement(LAST_NAME).sendKeys(lastName);
        driver.findElement(ZIP_CODE).sendKeys(zipCode);
        driver.findElement(CONTINUE_BUTTON).click();
        return new CheckoutOverviewPage(driver);
    }
}
