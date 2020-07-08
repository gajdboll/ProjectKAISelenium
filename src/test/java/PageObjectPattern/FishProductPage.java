package PageObjectPattern;

import driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import wait.WaitForElement;

// In each page constructor we can remove  this.driver = driver; & replace driver with getDriver from DriverManager
public class FishProductPage {
    @FindBy(xpath = "//*[@href='/jpetstore/actions/Catalog.action?viewProduct=&productId=FI-SW-01']")
    private WebElement angelFish;

    private Logger logger = LogManager.getRootLogger();

    public FishProductPage() {//that driver can be removed too(WebDriver driver)
       PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public String angelFishText() {
        logger.info("The Angel Fish is {}", angelFish.getText());
        return angelFish.getText();
    }

    public void clickOnAngelFishProduct() {
        WaitForElement.waitUntilElementIsClickable(angelFish);
        angelFish.click();
        logger.info("Clicked on Angel Fish");
    }
}
