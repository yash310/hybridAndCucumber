Feature: Urban Ladder application Test

Scenario: Home page Title validation
Given The driver is initialized
When user is on urban ladder home page
Then verify if the title contains Urban Ladder

Scenario: Email subscription validation
Given The driver is initialized
When user is on urban ladder home page
And user enters "test1@example.com" and clicks on subscribe
Then verify if the subscription is successful
 
 Scenario: Support email verification
Given The driver is initialized
When user is on urban ladder home page
And user clicks on contact us button in footer
Then verify if the support email is displayed

 Scenario: Application Signup test
Given The driver is initialized
When user is on urban ladder signup page
And user enters "test1@example.com" and "test@1234" on signup page
And clicks on Signup
Then verify if sign up is successful

Scenario: Application Login test
Given The driver is initialized
When user is on urban ladder login page
And user enters "test1@example.com" and "test@1234" on login page
And clicks on Login
Then verify if login is successful

Scenario: Adding a product to cart 
Given The driver is initialized
When user is on urban ladder home page
And user selects a product
And clicks on Add to cart
Then verify if the product is added to cart

Scenario: Facebook redirection 
Given The driver is initialized
When user is on urban ladder home page
And user clicks on facebook icon
Then verify if it is redirected to the correct URL

Scenario: Playstore Validation 
Given The driver is initialized
When user is on urban ladder home page
And user clicks on Playstore icon 
Then verify if correct App is displayed

Scenario: Store address validation 
Given The driver is initialized
When user is on urban ladder home page
And user clicks on visit us 
And clicks on the store 
Then verify if the correct store address is displayed

Scenario: Careers URL validation 
Given The driver is initialized
When user is on urban ladder home page
And user clicks Careers in footer tab 
Then verify that the user ias navigated to the right URL




