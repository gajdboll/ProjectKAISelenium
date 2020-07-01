package driver;

import java.util.concurrent.TimeUnit;

public class DriverUtilities {

    public static void initialConfiguraiotn(){
        DriverManager.getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        DriverManager.getWebDriver().manage().window().maximize();
    }
    public static void navigateToPage(String URL){
        DriverManager.getWebDriver().navigate().to(URL);
    }
}
