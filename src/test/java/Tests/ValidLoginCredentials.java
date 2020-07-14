package Tests;

import PageObjectPattern.LoginPage;
import driver.DriverUtilities;
import org.testng.annotations.Test;

import static navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.Assert.assertTrue;

// rename that Class with actual name what that test with verify (easy to understand)
//from SeleniumTestK to Invalid Login
public class ValidLoginCredentials extends TestBase{

    @Test
    // rename that test with actual name what that test with verify (easy to understand)
    public void positiveLoginTOTheStore() {
//new way of moving to Login Page
        DriverUtilities.navigateToPage(LOGIN_URL);
        //fluent method changed and is shorter and focus only on valid Login
        LoginPage loginPage = new LoginPage();
        boolean isBannerAfterLoginDisplayed = loginPage
                .enterLogin("j2ee")
               .enterPassword("j2ee")
                .clickLoginBtn()
                .existingOfBannerfterLogin();

        assertTrue(isBannerAfterLoginDisplayed);


    }
}
