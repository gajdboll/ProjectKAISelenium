package PageObjectPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPageMainPage {

    private WebDriver driver;
    //constructor of that page
    public SignInPageMainPage(WebDriver driver){
        this.driver =driver;
    }
    public void clickOnSignInLink() {
        WebElement signInLink= driver.findElement(By.cssSelector("#MenuContent a[href*='signonForm']"));
        signInLink.click();
    }
}
