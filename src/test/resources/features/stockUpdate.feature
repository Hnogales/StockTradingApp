Feature: Update Trade Functionality

  User should be able to update and modify their previously entered trades in stock trading tracking App

#Angkana
@UpdateValidTest @SmokeTest
Scenario: User update functionality with valid data

Given I am on the app log in page
When I enter valid username "Angkana" and password "SuperAngkana123!"
And I click signin button
Then I am on the Homepage
When I click on the Update button for the one of the trades
Then I should be on Save Trade form
When I update the Trade by changing Entry Price to "300.05"
And I click Save button
Then The trade is updated based on the change
And The trade remains on the same position on the Trade table


@UpdateInvalidTest @SmokeTest
Scenario: User update functionality with invalid data

Given I am on the Homepage
When I click on the Update button for the one of the trades
Then I should be on Save Trade form
When I update the Trade with invalid data by leaving the symbol field blank ""
And I click Save button
Then An error message should be displayed as "Please fill out this field."
And The trade should not be updated in the database or the table view