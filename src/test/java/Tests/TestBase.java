package Tests;

import driver.DriverManager;
import driver.DriverUtilities;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    public WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
         DriverManager.getWebDriver();

        DriverUtilities.initialConfiguraiotn();
        DriverUtilities.navigateToPage("http://przyklady.javastart.pl/jpetstore/");
    }
    @AfterMethod
    public void afterTest() {

        DriverManager.disposeDriver();
    }
}
