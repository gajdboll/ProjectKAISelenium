package PageObjectPattern;

import driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterSignInPage {
    // In each page constructor we can remove  this.driver = driver; & replace driver with getDriver from DriverManager
    @FindBy(xpath = "//*[@id='Banner']/img")
    private WebElement footerAfterLogin;

    // private WebDriver driver;  -- it can be remowed too cause we are getting driver from Driver Manager

    public FooterSignInPage(){//that driver can be removed too(WebDriver driver)
        // this.driver =driver;
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public boolean existingOfBannerfterLogin() {
        return footerAfterLogin.isDisplayed();
    }
}
