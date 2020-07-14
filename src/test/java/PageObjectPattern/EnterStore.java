package PageObjectPattern;

import driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import wait.WaitForElement;

public class EnterStore {
    @FindBy(xpath = "//*[@id='Content']/p[1]/a")
    private WebElement enterStoreLink;

   private Logger logger = LogManager.getRootLogger();
    public EnterStore(){//that driver can be removed too(WebDriver driver)
    PageFactory.initElements(DriverManager.getWebDriver(), this);
    }
    //void is replaced with SignInPageMainPage cause we are moving to next page (SignInPageMainPage)
    public SignInPageMainPage clickOnEnterStoreLink() {
        //change the return type for next page
        WaitForElement.waitUntilElementIsClickable(enterStoreLink);
        enterStoreLink.click();
        logger.info("Clicked on Enter Store Link");
    return new SignInPageMainPage();
    }
}
