package wait;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForElement {

    private static WebDriverWait getWebDriverWait() {
        return new WebDriverWait(DriverManager.getWebDriver(), 10);
    }
//waiting for element to be visible
    public static void waitUntilElementIsVisible(WebElement element){
        WebDriverWait webDriverWait = getWebDriverWait();
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }
    //waiting for element to be clickable
    public static void waitUntilElementIsClickable(WebElement element){
        WebDriverWait webDriverWait = getWebDriverWait();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }
//below method is used if we want to find element after DOM is reloaded again - otherwise we get the StaleElementReferenceException
    public static WebElement waitUntilPresenceOfElementLocated(By by) {
        WebDriverWait webDriverWait = getWebDriverWait();
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    //waiting for element to be invisible
    public static void waitUntilElementIsInvisible(WebElement element) {
        WebDriverWait webDriverWait = getWebDriverWait();
        webDriverWait.until(ExpectedConditions.invisibilityOf(element));
    }
}
/*Previos version of explicit waits when driver was on place
 public WebElement waitUntilPresenceOfElementLocated(By by) {
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitUntilElementIsInvisible(WebElement checkboxBeforeClick) {
        webDriverWait.until(ExpectedConditions.invisibilityOf(checkboxBeforeClick));
    }
}*/
