package driver.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

//browser factory allows us to pick one of those browsers
public class BrowserFactory {
    public static WebDriver getBrowser(BrowserType browserType) {
        switch (browserType) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
                return new ChromeDriver();
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "C:/drivers/geckodriver.exe");
                return new FirefoxDriver();
            case IE:
                System.setProperty("webdriver.ie.driver", "C:/drivers/IEDriverServer.exe");
                return new InternetExplorerDriver();
            case OPERA:
                System.setProperty("webdriver.opera.driver", "C:/driver/operadriver.exe");
                return new OperaDriver();
            case EDGE:
                //DISM.exe /Online /Add-Capability /CapabilityName:Microsoft.WebDriver~~~~0.0.1.0
                 System.setProperty("webdriver.edge.driver", "C:/driver/operadriver.exe");
                return new EdgeDriver();
            default:
                throw new IllegalStateException("Unknown browser type! Please check your configuration");
        }
    }
}
