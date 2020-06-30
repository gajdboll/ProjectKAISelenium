# ProjectKAISelenium - Sprint One -Version 1.5


Singleton Design Pattern - more info:

https://sourcemaking.com/design_patterns/singleton

The idea of creating Singleton Pattern is to create one instance of the object, we use different techniques like encapsulation (we hide driver) but we give the access globally

## Steps

- Create Class DriverManager in the new Package (called a driver) - with an empty private constructor.

- Create static private WebDriver

- create a static method allowing you to  get a driver (call it getDriver())and include those lines of the code:  if (driver == null) {         System.setProperty("webdriver.chrome.driver", "C:/driver/chromedriver.exe");        
driver = new ChromeDriver();    }   
return driver;}

- use that new static method and call it in TestBase class and replace driver & location of the driver with a new method by calling: DriverManager.getDriver()

- remove driver from each Page Object Pattern Class from a constructor as well as:// this.driver = driver;In the Pagefactory - replace the driver with new getDriver() similar to above

- remove a driver from Tests where an object is created in the same driver, package create an additional class called DrverUtilities and will contain 2 methods that will replace a bit of code from @BeforeMethod method from TestBase as well as @AfterMethos method from the same class

- two methods in the driverUtilieties are called WebConfiguration and will contain basic configuration:
DriverManager.getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
DriverManager.getWebDriver().manage().window().maximize();and navigateToPage(String URL ) with codeDriverManager.getWebDriver().navigate().to(URL); 

- those two methods replace some code in TestBase Class - and make that code smaller and clearer




The Test should be stored in master as well as Version1.5 branch on the global repository (remote)

The master branch should always contain the latest version of the project





### ORIGINAL FRAMEWORK - KAI

