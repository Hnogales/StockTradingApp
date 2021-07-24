Feature: Stock Homepage
  User should be able to operate the following tasks from the Homepage

#Harold
	 Scenario: As an external user, once logged in
  	Given I am on the Stock Homepage
  	And click on "Add a trade"
  	Then I should be able to add a trade
  	
  	
 @HomePage
  Scenario: As a stock Trade app User, i sould be able to long in Homepage.
  Given I am external user of Stock Trade market APP
  And I login
  Then I should be directed to the homepage of the application
  	
 