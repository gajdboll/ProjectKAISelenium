package driver;

public class DriverUtilities {

    public static void initialConfiguraiotn(){
       // That line is replaced with explicit waits 
        // DriverManager.getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        DriverManager.getWebDriver().manage().window().maximize();
    }
    public static void navigateToPage(String URL){
        DriverManager.getWebDriver().navigate().to(URL);
    }
}
