package PageObjectPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    private WebDriver driver;

    //constructor of that page
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        //for each contructor we add that line / check below
        PageFactory.initElements(driver, this);
    }
    //enter login
    public void enterLogin() {
        //WebElement login = driver.findElement(By.name("username")); that element and other is replaced by FindBy
        login.clear();// to be sure that field is empty
        login.sendKeys("NotExistingLogin");
    }

    //enter password
    public void enterPassword() {
        //WebElement password = driver.findElement(By.name("password")); that element and other is replaced by FindBy
        password.clear();// to be sure that field is empty
        password.sendKeys("NotProperPassword");
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
}

