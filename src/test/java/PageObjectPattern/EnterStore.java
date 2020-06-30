package PageObjectPattern;

import driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// In each page constructor we can remove  this.driver = driver; & replace driver with getDriver from DriverManager
public class EnterStore {
    @FindBy(css = "#Content a")
    private WebElement enterStoreLink;

    // private WebDriver driver;  -- it can be remowed too cause we are getting driver from Driver Manager

    public EnterStore(){//that driver can be removed too(WebDriver driver)
     // this.driver =driver;
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }
    public void clickOnEnterStoreLink() {
        //that elements is replaced with @FindBy
        //WebElement enterStoreLink = driver.findElement(By.cssSelector("#Content a"));
        enterStoreLink.click();

    }
}
