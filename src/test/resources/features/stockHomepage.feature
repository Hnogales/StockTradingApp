@story3a
Feature: Stock Homepage
  User should be able to operate the following tasks from the Homepage

#Harold
	 Scenario: As an external user, once logged in
  	Given I am on the Stock Homepage
  	And click on "Add a trade"
  	Then I should be able to add a trade
 