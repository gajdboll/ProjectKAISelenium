package Tests;

import PageObjectPattern.EnterStore;
import PageObjectPattern.LoginPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class InvalidLoginCredentials extends TestBase{

    @Test
    public void incorrectCredentialsInvalidLogin() {
        //new way of presenting code - Fluent way
        EnterStore enterStore = new EnterStore();
        //navigation through the pages
        enterStore.clickOnEnterStoreLink()
                .clickOnSignInLink()
                .enterLogin("invalid login")
                .enterPassword("invalid pass")
                .clickLoginBtn();
        LoginPage loginPage = new LoginPage();
        //Assertion
        assertEquals(loginPage.messageValidation(), "Invalid username or password. Signon failed.");


        /*old way of presenting code
        //Clicks on "Enter the Store" - First Page
        EnterStore enterStore = new EnterStore();//that (driver);can be removed after DriverManger Deployment
        enterStore.clickOnEnterStoreLink();

        //Clicks on "Sign In" - SEC page - this time we use our POP class
        SignInPageMainPage signInPageMainPage = new SignInPageMainPage();//that (driver);can be removed after DriverManger Deployment
        signInPageMainPage.clickOnSignInLink();

        //Set up username and password and then Login- Third page
        LoginPage loginPage = new LoginPage();//that (driver);can be removed after DriverManger Deployment
        loginPage.enterLogin("Invalid Login");
        loginPage.enterPassword("Invalid Password");
        loginPage.clickLoginBtn();
        //we will use that variable inside the assertion - methods d could be easly used inside the assertion but it is all about good practices
        String warningText = loginPage.messageValidation();
        //Assertion
        assertEquals(warningText, "Invalid username or password. Signon failed.");
*/
    }
   }
