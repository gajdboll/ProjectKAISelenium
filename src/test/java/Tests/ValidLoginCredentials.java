package Tests;

import PageObjectPattern.EnterStore;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

// rename that Class with actual name what that test with verify (easy to understand)
//from SeleniumTestK to Invalid Login
public class ValidLoginCredentials extends TestBase{

    @Test
    // rename that test with actual name what that test with verify (easy to understand)
    public void positiveLoginTOTheStore() {
//New Fluent Test
        EnterStore enterstore = new EnterStore();
        //we can assign response to the boolean variable
        boolean isBannerAfterLoginDisplayed = enterstore
                .clickOnEnterStoreLink()
                .clickOnSignInLink()
                .enterLogin("j2ee")
               .enterPassword("j2ee")
                .clickLoginBtn()
                .existingOfBannerfterLogin();

        assertTrue(isBannerAfterLoginDisplayed);

        /*old code below
        //Clicks on "Enter the Store" - First Page
        EnterStore enterStore = new EnterStore();//that (driver);can be removed after DriverManger Deployment
        enterStore.clickOnEnterStoreLink();

        //Clicks on "Sign In" - SEC page - this time we use our POP class
        SignInPageMainPage signInPageMainPage = new SignInPageMainPage();//that (driver);can be removed after DriverManger Deployment
        signInPageMainPage.clickOnSignInLink();

        //Set up username and password and then Login- Third page
        LoginPage loginPage = new LoginPage();//that (driver);can be removed after DriverManger Deployment
        loginPage.enterLogin("j2ee");
        loginPage.enterPassword("j2ee");
        loginPage.clickLoginBtn();
        //we will use that variable inside the assertion - method d could be easly used inside the assertion but it is all about good practices
        //new class instantiation
        FooterSignInPage footerSignInPage = new FooterSignInPage();//that (driver);can be removed after DriverManger Deployment
        //Assertion
        assertTrue(footerSignInPage.existingOfBannerfterLogin());
        System.out.println(footerSignInPage.existingOfBannerfterLogin());*/
    }
}
