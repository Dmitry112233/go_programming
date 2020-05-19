package pages;

import data.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProjectPage extends BasePage {

    private final WebDriver driver;

    private By header = By.className("DetailsHeader-title");
    private String tabStr = "//ul[@class='DetailsNav-list']//a[@class='DetailsNav-link' and contains(text(),'%s')]";
    private By attr_published = By.xpath("//span[text()='Published:']//following-sibling::strong");
    private By attr_licenses = By.xpath("//span[@data-test-id='DetailsHeader-infoLabelLicense']/span");
    private By attr_module = By.xpath("//a[@data-test-id='DetailsHeader-infoLabelModule']");


    public ProjectPage(WebDriver driver) {
        this.driver = driver;
    }

    @Deprecated
    protected void load() {
        driver.get(TestData.BASE_URL);
    }

    protected ProjectPage loadProject(String name) {
        driver.get(TestData.BASE_URL + "/" + name + "?tab=overview");
        return this;
    }

    protected void isLoaded() throws Error {
        new WebDriverWait(driver, 4)
                .until(ExpectedConditions.presenceOfElementLocated(header));
    }

    private boolean isProjectTabDisplayed(String tabName) {
        return driver.findElement(By.xpath(String.format(tabStr, tabName))).isDisplayed();
    }

    private String getProjectTabLink(String tabName) {
        return driver.findElement(By.xpath(String.format(tabStr, tabName))).getAttribute("href");
    }

    private ProjectPage openTabByName(String tabName) {
        driver.findElement(By.xpath(String.format(tabStr, tabName))).click();
        return this;
    }

    private ProjectPage validateProjectTab(String tabName) {
        String projectTabLink = getProjectTabLink(tabName);

        assertTrue(isProjectTabDisplayed(tabName),
                String.format(TestData.messageElementNotDisplayed, tabName));
        assertTrue(!projectTabLink.equals("") && projectTabLink != null,
                String.format(TestData.messageLinkIsNullOrEmpty, projectTabLink));
        return this;
    }

    public ProjectPage validateNavigationOfProject() {

        isLoaded();

        openTabByName(TestData.TAB_ITEM1);
        validateProjectTab(TestData.TAB_ITEM2);
        validateProjectTab(TestData.TAB_ITEM3);
        validateProjectTab(TestData.TAB_ITEM4);
        validateProjectTab(TestData.TAB_ITEM5);
        validateProjectTab(TestData.TAB_ITEM6);
        validateProjectTab(TestData.TAB_ITEM7);
        openTabByName(TestData.TAB_ITEM2);
        validateProjectTab(TestData.TAB_ITEM1);

        return this;
    }

    public String getProjectAttributeValue(By path){
        return driver.findElement(path).getText();
    }

    public ProjectPage validateProjectAttributes(){

        isLoaded();

        String publish = getProjectAttributeValue(attr_published);
        String licenses = getProjectAttributeValue(attr_licenses);
        String module = getProjectAttributeValue(attr_module);

        assertEquals(publish, TestData.PROJECT_PUBLISHED,
                String.format(TestData.messageElementIncorrectValue, publish, TestData.PROJECT_PUBLISHED));
        assertEquals(licenses, TestData.PROJECT_LICENSES,
                String.format(TestData.messageElementIncorrectValue, licenses, TestData.PROJECT_LICENSES));
        assertEquals(module, TestData.PROJECT_NAME,
                String.format(TestData.messageElementIncorrectValue, module, TestData.PROJECT_NAME));

        return this;
    }
}
