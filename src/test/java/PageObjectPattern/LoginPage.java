package PageObjectPattern;

import driver.DriverManager;
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


    // private WebDriver driver;  -- it can be remowed too cause we are getting driver from Driver Manager

        public LoginPage(){//that driver can be removed too(WebDriver driver)
            // this.driver =driver;
        //for each contructor we add that line / check below
            PageFactory.initElements(DriverManager.getWebDriver(), this);
    }
    //enter login > modify that method - it become more generic so it can be use across all the tests
    public void enterLogin(String loginStr) {
        WaitForElement.waitUntilElementIsVisible(login);

        login.clear();// to be sure that field is empty
        login.sendKeys(loginStr);
    }

    //enter password  > it become more generic so it can be use across all the tests
    public void enterPassword(String pass) {
        //WebElement password = driver.findElement(By.name("password")); that element and other is replaced by FindBy
        password.clear();// to be sure that field is empty
        password.sendKeys(pass);
    }

    //click Login button after all credentials are entered
    public void clickLoginBtn() {
        //WebElement loginBtn = driver.findElement(By.name("signon")); that element and other is replaced by FindBy
        loginBtn.click();
    }

    //message occurs after login and is validated
    public String messageValidation() {
       //that element and other is replaced by FindBy
        // WebElement messageAfterLogin = driver.findElement(By.cssSelector("#Content ul[class='messages'] li"));

        return messageAfterLogin.getText();
    }
    public String meesageAfterCheckoutWithNoLogin(){
        return messageAfterLogin.getText();
    }

}
