package Tests;

import driver.DriverManager;
import driver.DriverUtilities;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static navigation.ApplicationURLs.APPLICATION_URLS;

public class TestBase {

    public WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
         DriverManager.getWebDriver();

        DriverUtilities.initialConfiguraiotn();
        //URL is replaced with final variable - imported from ApplicationUrls class
        DriverUtilities.navigateToPage(APPLICATION_URLS);
    }
    @AfterMethod
    public void afterTest() {

        DriverManager.disposeDriver();
    }
}
