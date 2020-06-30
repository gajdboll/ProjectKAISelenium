package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//we will replace driver witl Silngleton pattern - driver will be encapsulated
public class DriverManager {
// by creating that class we can replace some code in the TestBase -> we move there to make more changes
    private static WebDriver driver;

    //constructor is private cause we just want to be sure that there is only one isntance of driver
    private DriverManager() {
    }
//using that method below we will get the driver
    public static WebDriver getWebDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "C:/driver/chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void disposeDriver(){
        driver.close();//close the tab
        driver.quit();//close the browser
        driver=null;//kill the object
    }

}
