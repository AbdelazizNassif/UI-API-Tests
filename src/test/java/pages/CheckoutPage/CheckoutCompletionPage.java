package pages.CheckoutPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletionPage {

    private WebDriver driver;

    // constructor
    public CheckoutCompletionPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By ORDER_COMPLETION_HEADER = By.className("complete-header");
    private static final By ORDER_COMPLETION_TEXT = By.className("complete-text");

    public String getOrderCompletionHeader ()
    {
        return driver.findElement(ORDER_COMPLETION_HEADER).getText() ;
    }
    public String getOrderCompletionText ()
    {
        return driver.findElement(ORDER_COMPLETION_TEXT).getText() ;
    }


}
