package Tests;

import PageObjectPattern.EnterStore;
import PageObjectPattern.FooterSignInPage;
import PageObjectPattern.LoginPage;
import PageObjectPattern.SignInPageMainPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

// rename that Class with actual name what that test with verify (easy to understand)
//from SeleniumTestK to Invalid Login
public class ValidLoginCredentials extends TestBase{

    @Test
    // rename that test with actual name what that test with verify (easy to understand)
    public void positiveLoginTOTheStore() {
        //Clicks on "Enter the Store" - First Page
        EnterStore enterStore = new EnterStore(driver);
        enterStore.clickOnEnterStoreLink();

        //Clicks on "Sign In" - SEC page - this time we use our POP class
        SignInPageMainPage signInPageMainPage = new SignInPageMainPage(driver);
        signInPageMainPage.clickOnSignInLink();

        //Set up username and password and then Login- Third page
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterLogin("j2ee");
        loginPage.enterPassword("j2ee");
        loginPage.clickLoginBtn();
        //we will use that variable inside the assertion - method d could be easly used inside the assertion but it is all about good practices
        //new class instantiation
        FooterSignInPage footerSignInPage = new FooterSignInPage(driver);
        //Assertion
        assertTrue(footerSignInPage.existingOfBannerfterLogin());
        System.out.println(footerSignInPage.existingOfBannerfterLogin());
    }
}
