package PageObjectPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FishProductPage {
@FindBy(xpath = "//*[@href='/jpetstore/actions/Catalog.action?viewProduct=&productId=FI-SW-01']")
private WebElement angelFish;

    private WebDriver driver;

        public FishProductPage(WebDriver driver){
        this.driver = driver;
        //dont forget to put PageFactorClass to initiate elements
            PageFactory.initElements(driver,this);
    }
public String angelFishText(){
            return angelFish.getText();
}
    public void clickOnAngelFishProduct(){
            angelFish.click();
    }
}
