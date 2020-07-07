# ProjectKAISelenium - Sprint One -Version 1.6


## Replacing Implicit wait with EXPLICIT WAITS 

Implicit wait from DriverUtilities has been removed
Explicit Wait package called wait with WaitFOrElement class (WebDriverWait class)
Tha class contains :
- private static WebDriverWait getWebDriverWait() {
        return new WebDriverWait(DriverManager.getWebDriver(), 10);    }
-public static void waitUntilElementIsVisible(WebElement element){
-public static void waitUntilElementIsClickable(WebElement element){
-public static WebElement waitUntilPresenceOfElementLocated(By by)  

// method above is used when DOM is reloaded again StaleElementReferenceException occurs - the same element can't be found so that method help with that Excetion
     
       

### ORIGINAL FRAMEWORK - KAI

