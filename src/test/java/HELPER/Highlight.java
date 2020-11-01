package HELPER;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Highlight {

        @Test
        //Creating a custom function
        public static void highLighterMethod(WebDriver driver, WebElement element){
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

            try{
                Thread.sleep(500);
            }
            catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
            js.executeScript("arguments[0].setAttribute('style','border: 2px solid white;');", element);
        }

    }


