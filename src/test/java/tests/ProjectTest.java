package tests;

import data.TestData;
import org.testng.annotations.Test;

public class ProjectTest extends BaseTest {

    @Test
    public void ValidateProject() {

        startPage
                .searchForAPackage(TestData.SEARCH_DATA)
                .openPage(4)
                .openProject(TestData.PROJECT_NAME)
                .validateNavigationOfProject()
                .validateProjectAttributes();
    }
}
