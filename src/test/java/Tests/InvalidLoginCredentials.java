package Tests;

import PageObjectPattern.LoginPage;
import driver.DriverUtilities;
import org.testng.annotations.Test;

import static navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.Assert.assertEquals;

public class InvalidLoginCredentials extends TestBase{

    @Test
    public void incorrectCredentialsInvalidLogin() {
    //new way of moving to Login Page
        DriverUtilities.navigateToPage(LOGIN_URL);
        //fluent method changed
        LoginPage loginPage= new LoginPage();
                loginPage.enterLogin("invalid login")
                .enterPassword("invalid pass")
                .clickLoginBtn();
        LoginPage loginPageAgain = new LoginPage();
        //Assertion
        assertEquals(loginPageAgain.messageValidation(), "Invalid username or password. Signon failed.");


    }
}
