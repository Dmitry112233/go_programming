package tests;

import org.testng.annotations.Test;

public class NavigationBarTest extends BaseTest {

    @Test
    public void NavigationBarTest() {

        startPage.validateNavigationBar();
    }
}
