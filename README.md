 Version1.7
# ProjectKAISelenium - Sprint One -Version 1.8

## Version1.8 - Browser Factory - Multiple Browsers inclused int he project

Acceptance Criteria

So far we have only worked on the Chrome browser in the project, however, in the "real" project, we will probably need to support other browsers.Currently, the code does not allow this, because the selection of the browser is entered in Hardcoded, in tests in the DriverManager class.

To change this, we must provide a class that will allow us to choose the type of browser depending on our preferences.For this purpose, we will use the factory pattern, and more precisely the so-called a simple factory.

Let's start by defining the list of browsers.Let's assume that our tests will support the three most popular browsers in the world, namely:

Chrome

Firefox

Internet Explorer

Opera

Edge

Having a list, let's create Enum, which will store the list of browsers.To do this, create an Enum class in your existing driver package in your project.You can do it by selecting New -> Java Class and from the available options select Enum:

Let's call Enuma BrowserType.

After creating Enuma, we can add him a body and so we have:

package driver;
 
 public enum BrowserType {
     
     FIREFOX("firefox"),
     CHROME("chrome"),
     IE("internetexplorer");
 
     private final String browser;
 
     BrowserType(String browser) {
         this.browser = browser;
     }

Note that Enum consists of a list of browsers and a constructor. Having defined Enum, we can create the BrowserFactory class in which we sew the implementation of the browser selection. Let's create the BrowserFactory class in the driver package. Ultimately we have:

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
             default:
                 throw new IllegalStateException("Unknown browser type! Please check your configuration");
         }

As you can see, there is only one method in the class. A method called getBrowser (), which uses Enum BrowserType as the parameter. Inside the getBrowser () method there is a switch-case which, depending on the value of the BrowserType parameter chosen, will select the given browser. Finally, let's see what the package structure looks like after creating both classes.

FireFox configurationIn the code in the getBrowser () method for the FireFox browser, as for the Chrome browser, we must provide the file path for GeckoDriver.

GeckoDriver, just like ChromeDriver, is an executable * .exe file responsible for controlling FireFox. The creator of GeckoDriver is David Burns. 

Like chromedriver.exe, place it in the path you choose and add a line in the code:

case FIREFOX:
     System.setProperty("webdriver.gecko.driver", "C:/drivers/geckodriver.exe");
     return new FirefoxDriver();

With the Firefox browser already installed, we can run tests on Firefox by changing the call in the DriverManager class to:

public static WebDriver getWebDriver() {
 
     if (driver == null) {
         driver = BrowserFactory.getBrowser(BrowserType.FIREFOX);
     }
 
     return driver;

As a reminder, the getWebDriver () method previously looked like this:

 public static WebDriver getWebDriver() {
 
         if (driver == null) {
             System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
             driver = new ChromeDriver();
         }
 
         return driver;

Now running any test in the console will show us an additional login, which is normal for geckodriver:

org.openqa.selenium.SessionNotCreatedException: Tried to run command without establishing a connection

This error is caused by a different operation of the close () method for the implementation of geckodriver compared to ChromeDriver. For geckodriver, calling the close () method also kills the driver instance (additionally calls the quit () method when we have only one browser window). Therefore, in the disposeDriver () method, we need to change the implementation to:

public static void disposeDriver() {
     driver.close();
     if (!BROWSER_TYPE.equals(BrowserType.FIREFOX)){
         driver.quit();
     }
     driver = null;

Finally for the DriverManager class we have:

public class DriverManager {
 
     private static final BrowserType BROWSER_TYPE = BrowserType.FIREFOX;    private static WebDriver driver;
 
     private DriverManager() {
     }
 
     public static WebDriver getWebDriver() {
 
         if (driver == null) {
             driver = BrowserFactory.getBrowser(BROWSER_TYPE);
         }
 
         return driver;
     }
 
     public static void disposeDriver() {
         driver.close();
         if (!BROWSER_TYPE.equals(BrowserType.FIREFOX)){
             driver.quit();
         }
         driver = null;

Internet Explorer configurationSimilarly as before in the getBrowser () method for InternetExplorer, we must provide the path to the file for InternetExplorerDriver.

InternetExplorerDriver, just like ChromeDriver, is an executable * .exe file responsible for controlling InternetExplorer. The InternetExplorer Driver itself can be downloaded from https://www.selenium.dev/downloads/ from the "The Internet Explorer Driver Server" section

After downloading the * .exe file, we need to put it in the right place and provide the path to it according to:

case IE:
     System.setProperty("webdriver.ie.driver", "C:/drivers/IEDriverServer.exe");
     return new InternetExplorerDriver();

This is not the end of the configuration. Internet Explorer requires additional configuration from us on the browser side. Required settings are:

Zoom set to 100% (Zoom Level 100%)

Without this Zoom setting, if we run the tests we will get an error:

org.openqa.selenium.SessionNotCreatedException: Unexpected error launching Internet Explorer. Browser zoom level was set to 125%. It should be set to 100%

Security (Security Mode), i.e. Protected Mode set for all zones the same.To set them:

1 Go to Internet Explorer Internet Options2 Go to the Security tab

3 For all "Zones" * select or mark the "Enable Protected Mode" checkbox. It doesn't matter if the mode is on or off. It is important that it is set the same for all "Zones":

From this moment we can run tests on one of five browsers.

The Test should be stored in master as well as Version1.8 the branch on the global repository (remote)

The master branch should always contain the latest version of the project
