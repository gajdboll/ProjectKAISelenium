package PageObjectPattern;

import driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import wait.WaitForElement;

public class FooterSignInPage {
    // In each page constructor we can remove  this.driver = driver; & replace driver with getDriver from DriverManager
    @FindBy(xpath = "//*[@id='Banner']/img")
    private WebElement footerAfterLogin;

    private Logger logger = LogManager.getRootLogger();

    public FooterSignInPage(){
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public boolean existingOfBannerfterLogin() {
        WaitForElement.waitUntilElementIsVisible(footerAfterLogin);
        boolean isDisplayed = footerAfterLogin.isDisplayed(); //that result method is saved in the variable cause need to be returned
        logger.info("Returning status of banner after login: {}", isDisplayed);
        return isDisplayed;
    }
}
