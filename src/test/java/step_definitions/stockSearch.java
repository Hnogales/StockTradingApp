package step_definitions;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.StockSearchPage;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.PropertiesReader;

public class stockSearch {
	
	//Giggy
	
	BrowserUtils util = new BrowserUtils();
	StockSearchPage searchPage = new StockSearchPage();
	String inputSymbol;
	
	// senario1
	@Given("I am on the app log in page")
	public void i_am_on_the_app_log_in_page() {
		Driver.getDriver().get(PropertiesReader.getProperty("url"));
		
	}
	@When("I enter valid username {string} and password {string}")
	public void i_enter_valid_username_and_password(String string, String string2) {
		searchPage.username.sendKeys(string);
		searchPage.password.sendKeys(string2);
	}
	@And("I click on sign-in btn")
	public void i_click_on_sign_in_btn() {
	   searchPage.signInBtn.click();
	}
	@Then("I should be in the trade homepage")
	public void i_should_be_in_the_trade_homepage() {
	   util.waitUntilElementVisible(searchPage.addTradeBtn);
	}
	@When("I enter an existing data in search field {string}")
	public void i_enter_an_existing_data_in_search_field(String symbol) {
		searchPage.searchField.sendKeys(symbol);
		inputSymbol = symbol;
		System.out.println("Search field " + symbol);
	}
	@And("I enter a date value {string}")
	public void i_enter_a_date_value(String date) {
		searchPage.dateField.sendKeys(date);
		System.out.println("Date value " + date);
	}
	
	@And("I click on search button")
	public void i_click_on_search_button() {
	   searchPage.searchBtn.click();
//	   util.waitUntilElementVisible(searchPage.addTradeBtn);
//	   Assert.assertTrue(searchPage.addTradeBtn.isDisplayed());
	}
	
	@Then("The system should display the matching records")
	public void the_system_should_display_the_matching_records() {
		util.waitUntilElementVisible(searchPage.dataInFirstRow.get(0));

		List<String> list = new ArrayList<>();

		for (int i = 0; i < searchPage.dataInFirstRow.size() - 1; i++) {
			list.add(searchPage.dataInFirstRow.get(i).getText());
		}

		String actualSymbol = list.get(1);
		Assert.assertEquals(actualSymbol, inputSymbol);
			
	}
	
	@Given("I enter an non existing data {string}")
	public void i_enter_an_non_existing_data(String invalidSymbol) {
		searchPage.searchField.sendKeys(invalidSymbol);
		
	}

	@And("I enter an invalid Date textbox {string}")
	public void i_enter_an_invalid_date_textbox(String invalidDate) {
		searchPage.dateField.sendKeys(invalidDate);
	}
	
	@Then("The system should display an empty table")
	public void the_system_should_display_an_empty_table() {	 
		 boolean getdataTable = util.isElementPresent(searchPage.firstRowOfTable);
		 Assert.assertFalse(getdataTable);
	}
	
	
	

}
