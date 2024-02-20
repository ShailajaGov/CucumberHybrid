Feature: Login functionality

Scenario Outline: Login with valid credentials
Given User has navigated to login page
When User enters valid email address <email> into email field
And User enters valid password <password> into password field
And User clicks on login button
Then User should login successfully
Examples: 
|email|password|
|shailaja.sireesh@gmail.com|12345|
|abc@gmail.com|12345|

Scenario: Login with invalid credentials	
Given User has navigated to login page 	
When User enters invalid email address "abc1234@gmail.com" into email field
And User enters invalid password "1234567" into password field
And User clicks on login button
Then User should not be able to login successfully
And User get proper warning message


Scenario: Login without providing credentials 
Given User has navigated to login page
When User dont enter any credentials
And User clicks on login button
Then User should not be able to login successfully
And User get proper warning message

Scenario: Login with invalid email credentials and valid password
Given User has navigated to login page
When User enters below invalid email address and valid password 
|email|xyz@gmail.com|
|password|12345| 
And User clicks on login button
Then User should not be able to login successfully
And User get proper warning message

Scenario: Login with entering  valid email and invalid password
Given User has navigated to login page
When User enters valid email address "abc@gmail.com" into email field
And User enters invalid password "1234905" into password field
And User clicks on login button
Then User should not be able to login successfully
And User get proper warning message

