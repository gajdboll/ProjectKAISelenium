package PageObjectPattern;

import driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import wait.WaitForElement;

// In each page constructor we can remove  this.driver = driver; & replace driver with getDriver from DriverManager
public class CheckoutPage {
    @FindBy(xpath = "//div[@id='Cart']/a")
    private WebElement checkoutBtn;

    // private WebDriver driver;  -- it can be remowed too cause we are getting driver from Driver Manager

    public CheckoutPage(){//that driver can be removed too(WebDriver driver)
       // this.driver = driver;
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }
    public void clickOnCheckOutBtn(){
        WaitForElement.waitUntilElementIsClickable(checkoutBtn);
        checkoutBtn.click();
    }
}
