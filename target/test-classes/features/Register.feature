Feature: Registration Functionality

Scenario: User creates an account only with mandatory fields

Given User navigates to Register Account Page
When User enters the details into below fields
|firstName		|Arun|
|lastName			|Qafox|
|telephone		|9848012547|
|password			|123456|
And User selects privacy policy
And User clicks on continue button
Then User account should get created successfully

Scenario: User creates an account with all fields

Given User navigates to Register Account Page
When User enters the details into below fields
|firstName		|Arun|
|lastName			|Qafox|
|telephone		|9848012547|
|password			|123456|
And User selects Yes for newsletter
And User selects privacy policy
And User clicks on continue button
Then User account should get created successfully

Scenario: User creates a duplicate account

Given User navigates to Register Account Page
When User enters exisiting email along with other below fields
|firstName		|Arun|
|lastName			|Qafox|
|emailAddress	|amotooricap1@gmail.com|
|telephone		|9848012547|
|password			|123456|
And User selects Yes for newsletter
And User selects privacy policy
And User clicks on continue button
Then User account should get a proper warning about duplicate email

Scenario: User creates an account without filling any details

Given User navigates to Register Account Page
When User dont enters any details into fields
And User clicks on continue button
Then User account should get a proper warning messages for every mandatory field