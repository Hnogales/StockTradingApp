package step_definitions;


import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.stockHomepageElements;
import pages.stockLoginElements;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.PropertiesReader;

public class stockHomepage {

	BrowserUtils utils = new BrowserUtils(); // calling utils
	stockHomepageElements stockhomepage = new stockHomepageElements(); // calling stockHomePage
	stockLoginElements stocklogin = new stockLoginElements();
	Driver driver = new Driver();
	int totalTradeBeforeDeleted;
	String InputUpdatePrice;
	String InputUpdateSymbol;
	String inputSymbol;

	 
	// Harold
	@Given("I am on the Stock Homepage")
	public void i_am_on_the_stock_homepage() {
	Driver.getDriver().get(PropertiesReader.getProperty("stockURL")); 
	Driver.getDriver().manage().window().maximize();
	stocklogin.usernameInputField.sendKeys("Harold");
	stocklogin.passwordInputField.sendKeys("SuperHarold123!");
	stocklogin.signinBtn.click();

	}
	
	@Given("click on {string}")
	public void click_on(String string) throws InterruptedException {
		Thread.sleep(2000);
		stockhomepage.addTradeBtn.click();

	}

	@Then("I should be able to add a trade")
	public void i_should_be_able_to_add_a_trade() throws InterruptedException {
		stockhomepage.sellToOpenBtn.click();
		stockhomepage.symbol.sendKeys("CB Test");
		Thread.sleep(2000);
		stockhomepage.openDate.sendKeys("06/08/2021");
		Thread.sleep(2000);
		stockhomepage.entryPrice.sendKeys("28");
		Thread.sleep(2000);
		stockhomepage.closeDate.sendKeys("06/28/2021");
		Thread.sleep(2000);
		stockhomepage.exitPrice.sendKeys("77");
		Thread.sleep(2000);
		stockhomepage.saveBtn.click();
		Driver.quitDriver();

	}
	
	// Einar
	@When("I click on {string} button")
	public void i_click_on_button(String string) throws InterruptedException {
		Thread.sleep(2000);
		stockhomepage.logoutBtn.click();
		Thread.sleep(2000);
		stockhomepage.logoutBtn2.click();
	}

	@Then("I should be able to log out of the application")
	public void i_should_be_able_to_log_out_of_the_application() {
		String expectedSignoutMessage = "You have been signed out";
		
		String actual = stockhomepage.signoutMessage.getText();
		
		System.out.println(actual);
		
		Assert.assertEquals(actual, expectedSignoutMessage);
		
		Driver.quitDriver();
	    
	}
	
	
	
	
	// Angkana
	// UpdateValidTest
	@When("I click on the Update button for the one of the trades")
	public void i_click_on_the_update_button_for_the_one_of_the_trades() throws InterruptedException {
		Thread.sleep(2000);
		stockhomepage.UpdateTradeBtn.click();
		Thread.sleep(2000);
	}

	@Then("I should be on Save Trade form")
	public void i_should_be_on_save_trade_form() {
		utils.waitUntilElementVisible(stockhomepage.saveBtn);
		Assert.assertTrue(stockhomepage.saveBtn.isDisplayed());
	}

	@When("I update the Trade by changing Entry Price to {string}")
	public void i_update_the_trade_by_changing_entry_price_to(String updatePrice) throws InterruptedException {
		InputUpdatePrice = updatePrice;
		Thread.sleep(2000);
		stockhomepage.entryPrice.clear();
		Thread.sleep(2000);

		stockhomepage.entryPrice.sendKeys(updatePrice);
		Thread.sleep(4000);

		System.out.println("InputUpdatePriceprice is " + InputUpdatePrice);

	}

	@When("I click Save button")
	public void i_click_save_button() throws InterruptedException {
		stockhomepage.saveBtn.click();
		Thread.sleep(4000);
	}

	@Then("The trade is updated based on the change")
	public void the_trade_is_updated_based_on_the_change() {
		utils.waitUntilElementVisible(stockhomepage.anyRowEntryPrice.get(0));

		for (WebElement element : stockhomepage.anyRowEntryPrice) {

			String actualUpdatePrice = element.getText();

			System.out.println("actualUpdatePrice is " + actualUpdatePrice); // PRINT

			boolean flag = false;

			if (actualUpdatePrice.substring(1).equals(InputUpdatePrice)) {
				flag = true;
				Assert.assertTrue(flag);
				System.out.println(flag);
				break;
			}
		}
	}

	@Then("The trade remains on the same position on the Trade table")
	public void the_trade_remains_on_the_same_position_on_the_trade_table() {
		utils.waitUntilElementVisible(stockhomepage.dataInFirstRow.get(0));

		for (WebElement element : stockhomepage.dataInFirstRow) {
			String actualUpdatePrice = element.getText();

			System.out.println("dataInFirstRow is " + actualUpdatePrice); // PRINT

			boolean flag = false;

			if (actualUpdatePrice.substring(1).equals(InputUpdatePrice)) {
				flag = true;
				Assert.assertTrue(flag);
				System.out.println(flag);
				break;
			}

		}
	}

	// UpdateInvalidTest
	@When("I update the Trade with invalid data by leaving the symbol field blank {string}")
	public void i_update_the_trade_with_invalid_data_by_leaving_the_symbol_field_blank(String updateSymbol)
			throws InterruptedException {
		Thread.sleep(2000);
		InputUpdateSymbol = updateSymbol;

		stockhomepage.symbol.clear();
		Thread.sleep(3000);

		stockhomepage.symbol.sendKeys(updateSymbol);
		Thread.sleep(3000);
		System.out.println("InputUpdateSymbol: " + InputUpdateSymbol);
	}

	@Then("An error message should be displayed as {string}")
	public void an_error_message_should_be_displayed_as(String expectedErrorMessage) throws InterruptedException {

		String actualErrorMessage = stockhomepage.symbol.getAttribute("validationMessage");

		System.out.println("expectedErrorMessage: " + expectedErrorMessage);
		System.out.println("actualErrorMessage: " + actualErrorMessage);

		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
	}

	@Then("The trade should not be updated in the database or the table view")
	public void the_trade_should_not_be_updated_in_the_database_or_the_table_view() throws InterruptedException {

		stockhomepage.backToRecordBtn.click();
		Thread.sleep(3000);
		utils.waitUntilElementVisible(stockhomepage.anyRowSymbol.get(0));

		System.out.println("InputUpdateSymbol is " + InputUpdateSymbol); // PRINT

		for (WebElement element : stockhomepage.anyRowSymbol) {
			String actualUpdateSymbol = element.getText();

			System.out.println("actualUpdateSymbol is " + actualUpdateSymbol); // PRINT

			boolean flag = false;

			if (actualUpdateSymbol.equals(InputUpdateSymbol)) {
				flag = true;
				Assert.assertFalse(flag);
				System.out.println(flag);
				break;
			}

		}

		Driver.quitDriver();
	}

	// Sofia
	@When("I click on the Delete button for one of the trades")
	public void i_click_on_the_delete_button_for_one_of_the_trades() throws InterruptedException {
		Thread.sleep(3000);
		totalTradeBeforeDeleted = stockhomepage.anyRowSymbol.size();
		System.out.println("Total of Trade before delete: " + totalTradeBeforeDeleted);
		Thread.sleep(3000);
		stockhomepage.deletedBtn.click();
		utils.waitUntilAlertIsPresent();
		utils.switchToAlert();
		Thread.sleep(3000);
		utils.alertAccept();
		Thread.sleep(5000);
	}

	@Then("I should be able to Delete the trade details")
	public void i_should_be_able_to_delete_the_trade_details() {
		int totalTradeAfterDeleted = stockhomepage.anyRowSymbol.size();

		System.out.println("Total of Trade after delete: " + totalTradeAfterDeleted);

		Assert.assertEquals(totalTradeAfterDeleted, totalTradeBeforeDeleted - 1);

		Driver.quitDriver();
	}

	// Giggy
	// searchExisting
	@When("I enter an existing data in search field {string}")
	public void i_enter_an_existing_data_in_search_field(String symbol) throws InterruptedException {
		Thread.sleep(2000);
		stockhomepage.searchField.sendKeys(symbol);
		inputSymbol = symbol;
		Thread.sleep(3000);
		System.out.println("Search field " + symbol);
	}

	@When("I enter a date value {string}")
	public void i_enter_a_date_value(String date) throws InterruptedException {
		stockhomepage.dateField.sendKeys(date);
		Thread.sleep(3000);
		System.out.println("Date value " + date);
	}

	@When("I click on search button")
	public void i_click_on_search_button() throws InterruptedException {
		stockhomepage.searchBtn.click();
		Thread.sleep(3000);
	}

	@Then("The system should display the matching records")
	public void the_system_should_display_the_matching_records() throws InterruptedException {
		utils.waitUntilElementVisible(stockhomepage.dataInFirstRow.get(0));

		List<String> list = new ArrayList<>();

		for (int i = 0; i < stockhomepage.dataInFirstRow.size() - 1; i++) {
			list.add(stockhomepage.dataInFirstRow.get(i).getText());
		}
		Thread.sleep(1000);
		String actualSymbol = list.get(1);
		Assert.assertEquals(actualSymbol, inputSymbol);
	}

	// searchInvalid
	@When("I enter an non existing data {string}")
	public void i_enter_an_non_existing_data(String invalidSymbol) throws InterruptedException {
		Thread.sleep(2000);
		stockhomepage.searchField.sendKeys(invalidSymbol);
		Thread.sleep(3000);
	}

	@When("I enter an invalid Date textbox {string}")
	public void i_enter_an_invalid_date_textbox(String invalidDate) throws InterruptedException {
		stockhomepage.dateField.sendKeys(invalidDate);
		Thread.sleep(3000);
	}

	@Then("The system should display an empty table")
	public void the_system_should_display_an_empty_table() {
		boolean getdataTable = utils.isElementPresent(stockhomepage.firstRowOfTable);
		Assert.assertFalse(getdataTable);

		Driver.quitDriver();
	}

	// Tayaba
	// verifyHomepage
	@Then("I should be directed to the homepage")
	public void i_should_be_directed_to_the_homepage() throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertTrue(stockhomepage.homeTitle.isDisplayed());
		Assert.assertTrue(stockhomepage.finomGroupTitle.isDisplayed());
		Assert.assertTrue(stockhomepage.slackTitle.isDisplayed());
		Assert.assertTrue(stockhomepage.toolsDropdown.isDisplayed());
		Assert.assertTrue(stockhomepage.searchField.isDisplayed());
		Assert.assertTrue(stockhomepage.dateField.isDisplayed());
		Assert.assertTrue(stockhomepage.searchBtn.isDisplayed());
		Assert.assertTrue(stockhomepage.logoutBtn.isDisplayed());
		Assert.assertTrue(stockhomepage.addTradeBtn.isDisplayed());
		Thread.sleep(3000);

		Driver.quitDriver();
	}
	

}
