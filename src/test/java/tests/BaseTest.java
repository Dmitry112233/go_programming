package tests;

import driver.DriverManager;
import driver.DriverManagerFactory;
import driver.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.ResultsPage;
import pages.StartPage;
import utils.PropertyReader;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    private DriverManager driverManager;
    private int timeout = 2;

    protected StartPage startPage;
    protected ResultsPage resultsPage;

    @BeforeMethod
    public void init() {
        configureBrowser();
        driver.get(new PropertyReader().get("url.path.go.dev"));
        this.startPage = new StartPage(driver);
        this.resultsPage = new ResultsPage(driver);
    }

    public void configureBrowser() {
        driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
        driver = driverManager.getWebDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void quitBrowser() {
        driverManager.quitWebDriver();
    }
}
