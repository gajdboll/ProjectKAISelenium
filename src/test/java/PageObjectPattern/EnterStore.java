package PageObjectPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterStore {
    @FindBy(css = "#Content a")
    private WebElement enterStoreLink;

    private WebDriver driver;
    //constructor of that page
    public EnterStore(WebDriver driver){
      this.driver =driver;
        //for each contructor we add that line / check below
        PageFactory.initElements(driver, this);
    }
    public void clickOnEnterStoreLink() {
        //that elements is replaced with @FindBy
        //WebElement enterStoreLink = driver.findElement(By.cssSelector("#Content a"));
        enterStoreLink.click();

    }
}
