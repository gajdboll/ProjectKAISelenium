package Tests;

import PageObjectPattern.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SuccessfulChechoutFish extends TestBase{
    /*
    Stwórz nową klasę testową, która będzie rozszerzać klasę TestBase.
    Przejdź do strony głównej sklepu.
    Przejdź do podstrony rybek (Fish).
    Kliknij w ID rybki Angel Fish.
    Dodaj Small Angelfish do koszyka.
    Kliknij w przycisk Proceed to checkout.
    Potwierdź, że nastąpiło przekierowanie do strony logowania
    i wyświetlił się komunikat You must sign on before attempting to check out.*/
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
