Feature: Create Search Functionality

User should be able to search and filter their list of trades. 

@existingTest @smokeTest
Scenario: as a user, I should be able to search existing data with date values
Given I am on the app log in page
When I enter valid username "Natnicha" and password "SuperNatnicha123!"
And I click on sign-in btn
Then I should be in the trade homepage
When I enter an existing data in search field "AAPL" 
And I enter a date value "06-01-2021"
And I click on search button 
Then The system should display the matching records

@invalidTest @smokeTest
Scenario: as a user, I should not be able to search non existing data
Given I enter an non existing data "coffe mug"
Then I enter an invalid Date textbox "02-28-2021"
And I click on search button 
Then The system should display an empty table


