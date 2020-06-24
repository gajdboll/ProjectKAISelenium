package PageObjectPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPageMainPage {
    @FindBy(css = "#MenuContent a[href*='signonForm']")
    private WebElement signInLink;

    private WebDriver driver;
    //constructor of that page
    public SignInPageMainPage(WebDriver driver){
        this.driver =driver;
        //for each contructor we add that line / check below
        PageFactory.initElements(driver, this);
    }
    public void clickOnSignInLink() {
       //that elements is replaced with @FindBy
        // WebElement signInLink= driver.findElement(By.cssSelector("#MenuContent a[href*='signonForm']"));
        signInLink.click();
    }
}
