Feature: Login Functionality

Scenario Outline: Login with Valid Credentials

Given User navigates to Login Page
When User enters the valid email address <username> into email field
And User enters the valid password <password> into password field
And User clicks on Login button
Then User should get logged in successfully
Examples:
|username								|password|
|amotooricap1@gmail.com	|12345|
|amotooricap2@gmail.com	|12345|
|amotooricap3@gmail.com	|12345|

Scenario: Login with Invalid Credentials

Given User navigates to Login Page
When User enters the invalid email address into email field
And User enters the invalid password "12345abc" into password field
And User clicks on Login button
Then User should get a proper warning message

Scenario: Login with valid email and invalid password

Given User navigates to Login Page
When User enters the valid email address "abc@gmail.com" into email field
And User enters the invalid password "12345abc" into password field
And User clicks on Login button
Then User should get a proper warning message

Scenario: Login with invalid email and valid password

Given User navigates to Login Page
When User enters the invalid email address into email field
And User enters the valid password "12345" into password field
And User clicks on Login button
Then User should get a proper warning message

Scenario: Login with no credentials

Given User navigates to Login Page
When User dont enter email into email field
When User dont enter password into password field
And User clicks on Login button
Then User should get a proper warning message