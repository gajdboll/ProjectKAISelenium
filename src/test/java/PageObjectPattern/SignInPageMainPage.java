package PageObjectPattern;

import driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

   private Logger logger = LogManager.getRootLogger();
    public SignInPageMainPage(){//that driver can be removed too(WebDriver driver)
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }
    public LoginPage clickOnSignInLink() {//void is replaced with Login page - so we are expecting LoginPage
        WaitForElement.waitUntilElementIsClickable(signInLink);
         signInLink.click();
         logger.info("Clicked On Sign Link");
    return new LoginPage();
    }
    //void is replaced with FidgPage - cause we will move to that page
    public FishProductPage clickOnQuickLinkFish(){
        quickLinFish.click();
        return new FishProductPage();
    }
}
