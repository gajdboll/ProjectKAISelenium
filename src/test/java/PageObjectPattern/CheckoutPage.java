package PageObjectPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    @FindBy(xpath = "//div[@id='Cart']/a")
    private WebElement checkoutBtn;

    private WebDriver driver;

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void clickOnCheckOutBtn(){
        checkoutBtn.click();
    }
}
