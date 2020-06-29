# ProjectKAISelenium - Sprint One -Version 1.3


## PageFactory for creating code more generic and usable - no elements duplications 

Add extra test (positive) and create additional web class /instance(object) - to valiadate message on the page occuring after successful login
That page has a class already - but we need to create seperate class for it otherwise the program with throw exception
There is a few ways how to do the same scenario without creating additional class for already existing page in the class - we will resolve that after Fraework is completed
Bug for that issue is raised already - KAI-12

Each test we keep in the seperate class (for now before we find out more about TestNG functionality and usage)
So we create package called Tests which will contain all the tests.
@BeforeMethod and AfterMethod is repeating - so we will create seperate class for that functionality and we will call it TestBase
Other tests will extend that class so they have access to driver
On top of that - all the tests methods names are changed to express the test purpose - that will make it easy in the future to understand the cerrtain test




The best idea how to use of PageFactory class is to attach it (create PageFactoryobject ) into web page contractor.
more info about PageFactory & POP:
https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/support/PageFactory.html



******resolve the issue of creating additional POP classes when cust. is back to the same page (
overload page issue/initiation of elements issue) → raise a SIR(resolution in Sprint 2) - KAI-12


### ORIGINAL FRAMEWORK - KAI

