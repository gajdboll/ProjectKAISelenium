package PageObjectPattern;

import driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import wait.WaitForElement;

// In each page constructor we can remove  this.driver = driver; & replace driver with getDriver from DriverManager
public class SignInPageMainPage {
    @FindBy(css = "#MenuContent a[href*='signonForm']")
    private WebElement signInLink;
    @FindBy(xpath = "//img[@src='../images/sm_fish.gif']")
    private WebElement quickLinFish;

    public SignInPageMainPage(){//that driver can be removed too(WebDriver driver)
        // this.driver =driver;
        //for each contructor we add that line / check below
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }
    public void clickOnSignInLink() {
        WaitForElement.waitUntilElementIsClickable(signInLink);
         signInLink.click();
    }
    //new method - top wuick links - FISH
    public void clickOnQuickLinkFish(){
        quickLinFish.click();
    }
}
