@story3a
Feature: Stock Homepage
  User should be able to operate the following tasks from the Homepage


#Tayaba
@verifyHomepage @SmokeTest
	Scenario: as a user, I should be directed to the homepage of the application
		Given I am on the Stock Homepage
		Then I should be directed to the homepage
			
#Einar
@logOutScenario @SmokeTest
	Scenario: As an external user, once logged in I should be able to log out succesfully  
		Given I am on the Stock Homepage
		When I click on "Log out" button
		Then I should be able to log out of the application

 
 #Harold
@logInAddTrade @SmokeTest
	 Scenario: As an external user, once logged in
  	Given I am on the Stock Homepage
  	And click on "Add a trade"
  	Then I should be able to add a trade
 
 
#Giggy
@searchExisting @SmokeTest
	Scenario: as a user, I should be able to search existing data with date values
		Given I am on the Stock Homepage
		When I enter an existing data in search field "CB Test" 
		And I enter a date value "06-08-2021"
		And I click on search button 
		Then The system should display the matching records

@searchInvalid @SmokeTest
	Scenario: as a user, I should not be able to search non existing data
		Given I am on the Stock Homepage
		When I enter an non existing data "Coffee mug"
		And I enter an invalid Date textbox "02-28-2021"
		And I click on search button 
		Then The system should display an empty table


#Angkana 
@UpdateValidTest @SmokeTest
	Scenario: User update functionality with valid data
		Given I am on the Stock Homepage
		When I click on the Update button for the one of the trades
		Then I should be on Save Trade form
		When I update the Trade by changing Entry Price to "300.05"
		And I click Save button
		Then The trade is updated based on the change
		And The trade remains on the same position on the Trade table

@UpdateInvalidTest @SmokeTest
	Scenario: User update functionality with invalid data
		Given I am on the Stock Homepage
		When I click on the Update button for the one of the trades
		Then I should be on Save Trade form
		When I update the Trade with invalid data by leaving the symbol field blank ""
		And I click Save button
		Then An error message should be displayed as "Please fill out this field."
		And The trade should not be updated in the database or the table view


 #Sofia
@deleteTrade @SmokeTest
	Scenario: Delete functionality 
		Given I am on the Stock Homepage 
		When I click on the Delete button for one of the trades
		Then I should be able to Delete the trade details
