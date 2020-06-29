package Tests;

import PageObjectPattern.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SuccessfulChechoutFish extends TestBase{
    /*
    1.Create Additional test case - Start from the same page (EnterStore page)
    2. Go to Main page (Sign In Page) and click on FISH quicklink (top of the page)
    3. On next page Click o Fish IdOn next page Add Large AngelFish to the basket
    4. On next Page - leave the number the same and simply checkout
    5. On the next page (Login Page) verify the text in top left corner of the page
   */
    String expectedMessage = "You must sign on before attempting to check out. Please sign on and try checking out again.";

    @Test
    public void youMustSignInBeforeCheckoutMessage(){
//enterstore page -> SignIn page
        EnterStore enterStore =new EnterStore(driver);
        enterStore.clickOnEnterStoreLink();
//SignInPage -> FishProduct
        SignInPageMainPage signInPageMainPage = new SignInPageMainPage(driver);
        signInPageMainPage.clickOnQuickLinkFish();
//FisfPage -> AngelFishPage
        FishProductPage fishProductPage = new FishProductPage(driver);
        System.out.println(fishProductPage.angelFishText());
        fishProductPage.clickOnAngelFishProduct();
        //Angelfish -> CheckoutPage
        AngelFishPage angelFishPage = new AngelFishPage(driver);
        angelFishPage.clickOnLargeAngelFish();
        //Checkout -> Sign In page
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickOnCheckOutBtn();
        //Sign in page & validation
        LoginPage loginPage= new LoginPage(driver);
        String checkoutMessage =loginPage.meesageAfterCheckoutWithNoLogin();

    assertEquals(checkoutMessage,expectedMessage);


    }
}
