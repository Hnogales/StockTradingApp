@story3a
Feature: Stock Homepage
  User should be able to operate the following tasks from the Homepage


#Harold
@logInAddTrade @SmokeTest
	 Scenario: As an external user, once logged in
  	Given I am on the Stock Homepage
  	And click on "Add a trade"
  	Then I should be able to add a trade
  	
#Einar
@logOutScenario @SmokeTest
	Scenario: As an external user, once logged in I should be able to log out succesfully  
		Given I am on the Stock Homepage
		When I click on "Log out" button
		Then I should be able to log out of the application
 