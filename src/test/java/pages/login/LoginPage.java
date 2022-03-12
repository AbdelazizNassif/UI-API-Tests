package pages.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.homePage.HomePage;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // locators
    private final static By USER_NAME_FIELD = By.id("user-name") ;
    private final static By PASSWORD_FIELD = By.id("password") ;
    private final static By LOGIN_BUTTON = By.id("login-button") ;

    public HomePage loginToApp (String userName, String password)
    {
        driver.findElement(USER_NAME_FIELD).sendKeys(userName);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new HomePage(driver);
    }


}
