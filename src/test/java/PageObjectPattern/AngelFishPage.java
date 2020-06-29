package PageObjectPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AngelFishPage {


        @FindBy(css = "#Catalog > table > tbody > tr:nth-child(2) > td:nth-child(5) > a")
        private WebElement largeAngelFish;

        private WebDriver driver;

         public AngelFishPage(WebDriver driver){
            this.driver = driver;
             PageFactory.initElements(driver,this);
        }
        public void clickOnLargeAngelFish(){
            largeAngelFish.click();
        }
    }

