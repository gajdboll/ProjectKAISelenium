import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class SeleniumTestK {


    private WebDriver driver;
    //On Eclipse TestNG can be download from
   // https://dl.bintray.com/testng-team/testng-eclipse-release/7.0.0/
    @BeforeMethod
    public void beforeTest() {
      System.setProperty("webdriver.chrome.driver", "C:/driver/chromedriver.exe");
        driver = new ChromeDriver();
 //implicit wait set up on the begining of the test  - we will avoid that idea in the next releases
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        /* it's running the browser but is failing for some reason - investagate later   //
       System.setProperty("webdriver.gecko.driver", "C:/driver/geckodriver.exe");
    driver = new FirefoxDriver(); */
       //Testing IE - it's working but the last closing method has to be changed//
       /* System.setProperty("webdriver.ie.driver", "C:/driver/IEDriverServer.exe");
        driver = new InternetExplorerDriver();*/
       //Opera driver - test - work perfect
       /* System.setProperty("webdriver.opera.driver", "C:/driver/operadriver.exe");
        driver = new OperaDriver();*/
       //edge driver//-> installed in CMD using administrator rights and pasted:
        //DISM.exe /Online /Add-Capability /CapabilityName:Microsoft.WebDriver~~~~0.0.1.0
        // System.setProperty("webdriver.edge.driver", "C:/driver/operadriver.exe"); - works
       // driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://przyklady.javastart.pl/jpetstore/");
       //below method redirects to the web too
        // driver.get("http://przyklady.javastart.pl/jpetstore/");

    }

    @Test
    public void firstTest() {
        //Clicks on "Enter the Store" - First Page
        driver.findElement(By.cssSelector("#Content a")).click();

        //Clicks on "Sign In" - SEC page
        driver.findElement(By.cssSelector("#MenuContent a[href*='signonForm']")).click();

        //Set up username and passord - Third page
        driver.findElement(By.name("username")).sendKeys("NotExistingLogin");
        driver.findElement(By.name("password")).sendKeys("NotProperPassword");
        //Login
        driver.findElement(By.name("signon")).click();

        //Assertion
        assertEquals(driver.findElement(By.cssSelector("#Content ul[class='messages'] li")).getText(), "Invalid username or password. Signon failed.");

    }
    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
        driver = null;

    }
}
