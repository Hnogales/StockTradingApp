Feature: Stock login
  User should be able to login and logout using Stock login feature

	@loginValidTest		@SmokeTest
	Scenario: As a user, I should be directed to the login page and click on the sign in button
		Given I am on the signin page
		When I enter correct sigin credentials username "" password ""
		And I click on signin button
		Then I should be directed to the login page

  Scenario: 
