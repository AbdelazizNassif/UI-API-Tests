package pages.CheckoutPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage {

    private WebDriver driver;

    // constructor
    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By FINISH_BUTTON = By.id("finish");

    public CheckoutCompletionPage clickFinishButton ()
    {
        driver.findElement(FINISH_BUTTON).click();
        return new CheckoutCompletionPage(driver);
    }

}
