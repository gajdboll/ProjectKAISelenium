package PageObjectPattern;

import driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import wait.WaitForElement;

public class AngelFishPage {

// In each page constructor we can remove  this.driver = driver; & replace driver with getDriver from DriverManager
        @FindBy(css = "#Catalog > table > tbody > tr:nth-child(2) > td:nth-child(5) > a")
        private WebElement largeAngelFish;

    private Logger logger = LogManager.getRootLogger();

    public AngelFishPage(){//that driver can be removed too
                       PageFactory.initElements(DriverManager.getWebDriver(),this);
        }
        public void clickOnLargeAngelFish(){
            WaitForElement.waitUntilElementIsClickable(largeAngelFish);
             largeAngelFish.click();
             logger.info("Clicked on Angel Fish");
        }
    }

