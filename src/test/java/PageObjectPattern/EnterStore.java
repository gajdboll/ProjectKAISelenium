package PageObjectPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EnterStore {

    private WebDriver driver;
    //constructor of that page
    public EnterStore(WebDriver driver){
      this.driver =driver;
    }
    public void clickOnEnterStoreLink() {
        WebElement enterStoreLink = driver.findElement(By.cssSelector("#Content a"));
        enterStoreLink.click();

    }
}
