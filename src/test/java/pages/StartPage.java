package pages;

import data.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertTrue;

public class StartPage extends BasePage {

    private final WebDriver driver;

    private By image_logo = By.className("Header-logo");
    private String navigationBarItemStr = "//li[@class='Header-menuItem ']/a[contains(text(),'%s')]";
    private By input_search = By.name("q");

    public StartPage(WebDriver driver) {
        this.driver = driver;
    }

    protected void load() {
        driver.get(TestData.BASE_URL);
    }

    protected void isLoaded() throws Error {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.presenceOfElementLocated(image_logo));
    }

    private boolean isMenuItemDisplayed(String menuItem) {
        return driver.findElement(By.xpath(String.format(navigationBarItemStr, menuItem))).isDisplayed();
    }

    private String getMenuItemLink(String menuItem) {
        return driver.findElement(By.xpath(String.format(navigationBarItemStr, menuItem))).getAttribute("href");
    }

    public StartPage validateNavigationBar() {
        isLoaded();
        validateMenuItem(TestData.MENU_ITEM1);
        validateMenuItem(TestData.MENU_ITEM2);
        validateMenuItem(TestData.MENU_ITEM3);
        validateMenuItem(TestData.MENU_ITEM4);

        return this;
    }

    private void validateMenuItem(String menuItem) {
        String linkMenuItem = getMenuItemLink(menuItem);

        assertTrue(isMenuItemDisplayed(menuItem),
                String.format(TestData.messageElementNotDisplayed, menuItem));
        assertTrue(!linkMenuItem.equals("") && linkMenuItem != null,
                String.format(TestData.messageLinkIsNullOrEmpty, menuItem));
    }

    public ResultsPage searchForAPackage(String packageName) {
        driver.findElement(input_search).sendKeys(packageName + Keys.ENTER);
        return new ResultsPage(driver);
    }
}
