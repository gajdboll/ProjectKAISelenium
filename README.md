 
# ProjectKAISelenium - Sprint One -Version 1.10

## Version1.10 - Relative URL - Focus on Login Functionality - no navigation

Acceptance Criteria


Test sustainability
It is very important in tests, especially automated, that:

- tests were carried out quickly,
- were not susceptible to frequent changes, 
- tested one specific functionality.
Therefore, they should be short and goal-oriented (specific functionality). 

Analyzing our tests, we can safely conclude that their main goal is to test login on the 
site. Do they then meet the first point?
No, because switching from Landing Page to Login Page artificially lengthens them.

In addition, if the "Enter the Store" or "Sign in" link stopped working due to an error or change, the tests will also stop working. Despite the fact that the login functionality itself could not change. In short, current tests are susceptible to change. They do not therefore comply with the second rule.

So how do you approach the matter?

The answer to this question is very simple. To make our tests easier to maintain, we must apply the jumping / navigation practice directly to the functionality we test.

Example of relative URL implementation
In order to implement relative URLs, we need to make changes to the project. First of all, from the TestBase class we have to get the URL of the application to another class, because we will stick to it the URI (acronym of Uniform Resource Locator) of individual pages. 

http://przyklady.javastart.pl/jpetstore/ + actions/Account.action?signonForm=


Let's start by creating a new class called ApplicationURLs, which we will place in the navigation package (a new package must also be created). Project after creating the navigation package and adding the empty ApplicationURLs class:


After creating the new ApplicationURLs class, we need to move the URL from the TestBase class to the ApplicationURLs class as a constant. We will call this constant APPLICATION_URL.
Then in the ApplicationURLs class, we need to create a new constant named LOGIN_URL, which will be a combination of the APPLICATION_URL constant with the URI of the login page, and so we have:
package navigation;

 public class ApplicationURLs {
     public static final String APPLICATION_URL = "http://przyklady.javastart.pl/jpetstore/";
     public static final String LOGIN_URL = APPLICATION_URL + "actions/Account.action?signonForm=";
 }
 We have all the necessary components to change the implementation of login tests. The tests will start with navigation to the tested functionality page, i.e. with:
 
 DriverUtils.navigateToPage(LOGIN_URL);
 
 package tests;
 
 import driver.manager.DriverUtils;
 import org.testng.annotations.Test;
 import page.objects.LoginPage;
 
 import static navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.AssertJUnit.assertEquals;
 
 public class FailedLoginTests extends TestBase {
 
     @Test
     public void asUserTryToLogInWithIncorrectLoginAndPassword() {
         DriverUtils.navigateToPage(LOGIN_URL);
 
         LoginPage loginPage = new LoginPage();
         loginPage
                 .typeIntoUserNameField("NotExistingLogin")
                 .typeIntoPasswordField("NotProperPassword")
                 .clickOnLoginButton();
         String warningMessage = loginPage.getWarningMessage();
 
         assertEquals(warningMessage, "Invalid username or password. Signon failed.");
     }
 
 }
 
 
Finally, the question remains as to the other functionality of the transition from LandingPage to LoginPage?

The answer to this question is again very simple. To test whether the user can go from page to page, we should implement a new test whose purpose would be to test navigation, and more precisely the transition from LandingPage to LoginPage.





The Test should be stored in master as well as Version1.10 the branch on the global repository (remote)

The master branch should always contain the latest version of the project
