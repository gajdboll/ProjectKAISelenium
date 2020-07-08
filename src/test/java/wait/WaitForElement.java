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
    public static void waitUntilElementIsVisible(WebElement element) {
        WebDriverWait webDriverWait = getWebDriverWait();
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    //waiting for element to be clickable
    public static void waitUntilElementIsClickable(WebElement element) {
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
    // example of FluentWait
/* FluentWait<WebDriver> fluentWait = new FluentWait(driver);
 fluentWait.withTimeout(Duration.ofSeconds(5));
 fluentWait.pollingEvery(Duration.ofMillis(250));
 fluentWait.ignoring(NoSuchElementException.class);
 fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
}
/*Previos version of explicit waits when driver was on place
 public WebElement waitUntilPresenceOfElementLocated(By by) {
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitUntilElementIsInvisible(WebElement checkboxBeforeClick) {
        webDriverWait.until(ExpectedConditions.invisibilityOf(checkboxBeforeClick));
    }

    Cechy implementacji klasy FluentWait:

Jest to rodzic klasy WebDriverWait
Najważniejsze metody to:
- until() – w metodzie tej ustawiamy, na jaki typ zdarzenia ma czekać driver.
Do typu zdarzenia wykorzystuje się klasę ExpectedConditions (wrócimy do tej klasy w kolejnych stronach kursu).
 Jest to metoda generyczna, oznacza to, że zwraca nam typ w zależności od wybranej metody z klasy ExpectedConditions
- pollingEvery() – określamy interwał, z jakim driver ma pytać przeglądarkę czy dany warunek został spełniony
- withTimeout() – określa po jakim czasie wyszukiwanie ma zostać przerwane,
jeśli do zadanego czasu warunek nie został spełniony
- ignoring() lub ignoreAll() – pozwala nam ignorować specyficzny wyjątek lub wszystkie wyjątki danego typu
 w trakcie czekania. Przykład takiego wyjątku, który może wystąpić w trakcie działania to np. NoSuchElementException
*/
