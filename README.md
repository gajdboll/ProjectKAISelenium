# ProjectKAISelenium - Sprint One -Version 1.2


## PageFactory for creating code more generic and usable - no elements duplications 

descriptions: 

- @FindBy css -> driver.findElement(By.cssSelector()); 
- @FindBy name ->driver.findElement (By.name()); 
- @FindBy id  -> driver.findElement(By.id()); 
- @FindBy className  ->driver.findElement (By.className()); 
- @FindBy linkText  -> driver.findElement(By.linkText()); 
- @FindBy partialLinkText  -> driver.findElement(By.partialLinkText()); 
- @FindBy tagName  -> driver.findElement(By.tagName()); 
- @FindBy XPath ->driver.findElement (By.xpath());

For each web page after @FindBy we need to use PageFactory class - it has only one method “initElements()”,
we can use it in the test, but that would be code duplication and bad practice.

The best use of it is to attach it into web page contractor. more info about PageFactory & POP: https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/support/PageFactory.html





### ORIGINAL FRAMEWORK - KAI

