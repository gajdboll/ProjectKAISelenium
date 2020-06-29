package Tests;

import PageObjectPattern.EnterStore;
import PageObjectPattern.LoginPage;
import PageObjectPattern.SignInPageMainPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

// rename that Class with actual name what that test with verify (easy to understand)
//from SeleniumTestK to Invalid Login
public class InvalidLoginCredentials extends TestBase{



    @Test
    // rename that test with actual name what that test with verify (easy to understand)
    public void incorrectCredentialsInvalidLogin() {
        //Clicks on "Enter the Store" - First Page
        EnterStore enterStore = new EnterStore(driver);
        enterStore.clickOnEnterStoreLink();

        //Clicks on "Sign In" - SEC page - this time we use our POP class
        SignInPageMainPage signInPageMainPage = new SignInPageMainPage(driver);
        signInPageMainPage.clickOnSignInLink();

        //Set up username and password and then Login- Third page
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterLogin("Invalid Login");
        loginPage.enterPassword("Invalid Password");
        loginPage.clickLoginBtn();
        //we will use that variable inside the assertion - methods d could be easly used inside the assertion but it is all about good practices
        String warningText = loginPage.messageValidation();
        //Assertion
        assertEquals(warningText, "Invalid username or password. Signon failed.");

    }
   }
