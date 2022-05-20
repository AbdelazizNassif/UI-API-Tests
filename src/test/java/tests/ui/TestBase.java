package tests.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.login.LoginPage;
import utils.filesReaders.PropertiesFileReader;

public class TestBase extends PropertiesFileReader {

    protected WebDriver driver = null;
    protected LoginPage loginPage = null ;

    @BeforeClass
    public void setup ()
    {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-infobars") ;
        var headless = Boolean.parseBoolean(System.getenv("HEADLESS_CHROME")) | false ;
        chromeOptions.setHeadless(headless) ;
        WebDriverManager.chromedriver().setup() ;
        driver = new ChromeDriver(chromeOptions) ;
        Dimension desiredBrowserDimensions = new Dimension(1024,768);
        loadUIStaticConfigs("ui_config.properties");
        driver.manage().window().setSize(desiredBrowserDimensions);
        loginPage = new LoginPage(driver);
    }

    @AfterClass
    public void teardown ()
    {
        driver.quit();
    }
}
