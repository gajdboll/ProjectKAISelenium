package PageObjectPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    //constructor of that page
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //enter login
    public void enterLogin() {
        WebElement login = driver.findElement(By.name("username"));
        login.sendKeys("NotExistingLogin");
    }

    //enter password
    public void enterPassword() {
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("NotProperPassword");
    }

    //click Login button after all credentials are entered
    public void clickLoginBtn() {
        WebElement loginBtn = driver.findElement(By.name("signon"));
        loginBtn.click();
    }

    //message occurs after login and is validated
    public String messageValidation() {
        WebElement messageAfterLogin = driver.findElement(By.cssSelector("#Content ul[class='messages'] li"));
        return messageAfterLogin.getText();
    }
}

