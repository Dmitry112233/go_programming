package pages;

import data.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultsPage extends BasePage {

    private final WebDriver driver;

    private By header = By.className("SearchResults-header");
    private String link_pageStr = "//div[@class='SearchResults-resultCount']//a[@class='Pagination-number'" +
            " and text()='%s']";
    private String link_projectStr = "//div[@class='SearchSnippet']//a[contains(@href, '%s')]";

    public ResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    protected void load() {
        driver.get(TestData.BASE_URL + "/search");
    }

    protected void isLoaded() throws Error {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(header));
    }

    public ResultsPage openPage(int number) {
        isLoaded();
        driver.findElement(By.xpath(String.format(link_pageStr, number))).click();
        return this;
    }

    public ProjectPage openProject(String name) {
        isLoaded();
        driver.findElement(By.xpath(String.format(link_projectStr, name))).click();
        return new ProjectPage(driver);
    }
}
