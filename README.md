 Version1.7
# ProjectKAISelenium - Sprint One -Version 1.9

## Version1. - Fluent Interface

Acceptance Criteria

Acceptance Criteria

The Fluent Interface is a part of the code-building concept based on the principle that code formulates complex full sentences, making it more understandable. The creator of this idea is Martin Folwer (creator of Page Object Pattern). Using the Fluent Interface approach, the code begins to build a specific language for us in the literature referred to as DSL. Language-specific for the domain. And so for the usual technical specification, we could understand the SQL query in the form:

Author author = AUTHOR.as("author");
 create.selectFrom(author)
       .where(exists(selectOne()
                    .from(BOOK)
                    .where(BOOK.STATUS.eq(BOOK_STATUS.SOLD_OUT))
                    .and(BOOK.AUTHOR_ID.eq(author.ID))));

The test code based on the Page Object Pattern allows us to apply the Fluent Interface concept, which will further increase the readability of the tests.

How to apply it then? For this, we will need to know-how methods in Page Objects can refer to other methods in the same or different class. Currently, methods in PO classes cannot refer to other methods.

The inability of methods to refer to other methods, whether from the same class or another, results from the fact that methods in Page Objects return nothing. All methods in PO return void or emptiness.

In this case, we need to add them the option of returning a given page object, depending on the situation of the given method:

In the first case, when after the method we remain on the same page.

 In the second case, when we perform an action that will take us to another, new page - we must then return the new object of the page on which we find ourselves.The rules sound complicated, but a simple example will show us when to apply a given case. We will develop an example using the positive login test - (example below):

  @Test
     public void asUserLoginUsingValidLoginAndPassword() {
 
         LandingPage landingPage = new LandingPage();
         landingPage.clickOnEnterStoreLink();
 
         TopMenuPage topMenuPage = new TopMenuPage();
         topMenuPage.clickOnSignInLink();
 
         LoginPage loginPage = new LoginPage();
         loginPage.typeIntoUserNameField("j2ee");
         loginPage.typeIntoPasswordField("j2ee");
         loginPage.clickOnLoginButton();
         FooterPage footerPage = new FooterPage();
 
         assertTrue(footerPage.isBannerAfterLoginDisplayed());
     }

Reading the test, we can see that calling the clickOnEnterStroreLink () method causes the transition to a new page, in which case we must apply the second case, i.e. call the new page object which is TopMenuPage. We will apply the same case to the clickOnSignInLink () method, except that we will create a LoginPage object. The situation changes when calling the typeIntoUserNameField (), typeIntoPasswordField () methods. After performing these methods we are on the same object/page, the action of our test is still on the LoginPage page. Therefore, we can no longer create a new object, but we must return an existing object (first case). We will use the keyword for this purpose. 

Summarizing: For methods in Page Objects that cause a transition to another page, we return the object of the page to which we go For methods in Page Objects that do not switch to another page, we return the current page object using the keyword this Implementation of Fluent Interface in tests Knowing the rules, we can proceed to implementation. Let's start with the LandingPage class. After adding the return of a new TopMenuPage object to the clickOnEnterStoreLink () method, we have:

 public class LandingPage{
 
     private Logger logger = LogManager.getRootLogger();
 
     @FindBy(css = "#Content a")
     private WebElement enterStoreLink;
 
     public LandingPage() {
         PageFactory.initElements(DriverManager.getWebDriver(), this);
     }
 
     public TopMenuPage clickOnEnterStoreLink() {
         WaitForElement.waitUntilElementIsClickable(enterStoreLink);
         enterStoreLink.click();
         logger.info("Clicked on Enter Store link");
         return new TopMenuPage();
     }
 
 }

As you can see, the amount of code in the test has decreased and after calling the clickOnEnterStoreLink () method, we can call the clickOnSignInLink () method. If we now repeat this action for all Page Objects, remembering when we must return the objectNote: In the FooterPage class, the isBannerAfterLoginDisplayed () method and in the LoginPage class, the getWarningMessage () method has not changed because they return us the states needed for assertion! Fluent Interface does not apply to methods used for assertion. In this case, the event string is interrupted.How we gonna use the code in the invalidLoginCredential (similar example below)

 public class FailedLoginTests extends TestBase {
 
     @Test
     public void asUserTryToLogInWithIncorrectLoginAndPassword() {
         LandingPage landingPage = new LandingPage();
         landingPage
                 .clickOnEnterStoreLink()
                 .clickOnSignInLink()
                 .typeIntoUserNameField("NotExistingLogin")
                 .typeIntoPasswordField("NotProperPassword")
                 .clickOnLoginButton();
         LoginPage loginPage = new LoginPage();
         String warningMessage = loginPage.getWarningMessage();
 
         assertEquals(warningMessage, "Invalid username or password. Signon failed.");
     }
 
 }

You should stop here and explain a problem to yourself. The problem appears in the LoginPage class for the clickOnLoginButton () method, this method is used in two tests (positive and negative). Both tests end differently. Namely, in the positive passage, we go to the FooterPage page, while in the negative we remain on LoginPage. So what object should the clickOnLoginButton () method return? Himself or this or new LoginPage ();?

This is a conventional issue and depends on our approach. In the code above, calling a new page object (i.e. new PageObject ()) is when we assume that the click will be positive and will take us to the new page. This convention is due to one more fact, namely calling the initElements () method from the PageFactory class. This method in our architecture initializes WebElements on the page only when creating a new page object, because clicking the Login button with incorrect login data causes the display of a new webelement which is the Warning Message - this is equivalent to overloading the DOM. Therefore, we should reload all page objects and initialize them again to avoid the typical exception found in Selenium tests - StaleElementException.

SummaryThanks to the fluid interface, the readability of our tests have increased further. It is a practice that over time also speeds up writing tests because individual actions combine into strings to form a coherent whole.

The Test should be stored in master as well as Version1.9 the branch on the global repository (remote)

The master branch should always contain the latest version of the project



The Test should be stored in master as well as Version1.9 the branch on the global repository (remote)

The master branch should always contain the latest version of the project
