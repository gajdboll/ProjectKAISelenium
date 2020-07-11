package driver;

import driver.manager.BrowserFactory;
import driver.manager.BrowserType;
import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static final BrowserType BROWSER_TYPE = BrowserType.FIREFOX; //that s the field where we select the brwoser
    private static WebDriver driver;

    private DriverManager() {
    }
//using that method below we will get the driver
    public static WebDriver getWebDriver() {
        //we change that class and tha method if we want to use that method generly across all the browsers
        if (driver == null) {
           //we cahnge tha code below to make more universal
            // driver = BrowserFactory.getBrowser(BrowserType.FIREFOX);
        //new code below
            driver = BrowserFactory.getBrowser(BROWSER_TYPE);

        }

        return driver;
    }
     /*previous code
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "C:/driver/chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }*/

    public static void disposeDriver(){
       //that code is change so allows us to kill the drier

            driver.close();
            if (!BROWSER_TYPE.equals(BrowserType.FIREFOX)){
                driver.quit();
            }
            driver = null;
        }
        /* prevoois versio of the coce

       driver.close();//close the tab
        driver.quit();//close the browser
        driver=null;//kill the object
    }
*/
}
