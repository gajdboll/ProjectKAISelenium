package PageObjectPattern;

import driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import wait.WaitForElement;

public class EnterStore {
    @FindBy(css = "#Content a")
    private WebElement enterStoreLink;

   private Logger logger = LogManager.getRootLogger();
    public EnterStore(){//that driver can be removed too(WebDriver driver)
     // this.driver =driver;
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }
    public void clickOnEnterStoreLink() {
        WaitForElement.waitUntilElementIsClickable(enterStoreLink);
        enterStoreLink.click();
        logger.info("Clicked on Enter Store Link");

    }
}
