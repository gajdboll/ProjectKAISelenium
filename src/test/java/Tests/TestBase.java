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
        // two lines below can be removed and Sigleton can be used in testbase class
        //System.setProperty("webdriver.chrome.driver", "C:/driver/chromedriver.exe");
        //driver = new ChromeDriver();
        DriverManager.getWebDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//that code is mode to DriverUtilitis(initialCofiguration)
        //driver.manage().window().maximize();//that code is mode to DriverUtilitis(initialCofiguration)
        //driver.navigate().to("http://przyklady.javastart.pl/jpetstore/");//that code is mode to DriverUtilitis(navigation)
        //Singleton Implementation
        DriverUtilities.initialConfiguraiotn();
        DriverUtilities.navigateToPage("http://przyklady.javastart.pl/jpetstore/");




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

    }

    @AfterMethod
    public void afterTest() {
        //those 3 lines below can be replaced by only one line of the code
    /*    driver.close();
        driver.quit();
        driver = null;*/
        DriverManager.disposeDriver();


    }
}
