package PageObjectPattern;

import driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import wait.WaitForElement;

// In each page constructor we can remove  this.driver = driver; & replace driver with getDriver from DriverManager
public class LoginPage {
    //all the elemenents are replacedwith @FindBy annotations so elements are searched only once
    @FindBy(name = "username")
    private WebElement login;
    @FindBy(name = "password")
    private WebElement password;
    @FindBy(name = "signon")
    private WebElement loginBtn;
    @FindBy(css = "#Content ul[class='messages'] li")
    private WebElement messageAfterLogin;

    private Logger logger = LogManager.getRootLogger();
    public LoginPage(){//that driver can be removed too(WebDriver driver)
          PageFactory.initElements(DriverManager.getWebDriver(), this);
    }
    //void is replaced with LoginPage  cause we are staying on the same page (LoginPage)
    public LoginPage enterLogin(String loginStr) {
        WaitForElement.waitUntilElementIsVisible(login);
        login.clear();// to be sure that field is empty
        login.sendKeys(loginStr);
        logger.info("Typed into User Name Field {}", loginStr);
    return this;
    }

    //void is replaced with LoginPage  cause we are staying on the same page (LoginPage)
    public LoginPage enterPassword(String pass) {
        //WebElement password = driver.findElement(By.name("password")); that element and other is replaced by FindBy
        password.clear();// to be sure that field is empty
        password.sendKeys(pass);
        logger.info("Typed into Password Field {}", pass);
    return this;
    }
//void is replaced with Footer Page  cause we are moving to next page (Footer page)
    public FooterSignInPage clickLoginBtn() {
        loginBtn.click();
        logger.info("Clicked on Login Button");
    return new FooterSignInPage();
    }

    //message occurs after login and is validated
    public String messageValidation() {
        logger.info("Warning text is : {}", messageAfterLogin.getText());
        String messageValivdation = messageAfterLogin.getText();
        return messageValivdation;
    }


}
