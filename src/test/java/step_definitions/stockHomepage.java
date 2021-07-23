package step_definitions;


import org.junit.Assert;
import org.openqa.selenium.WebElement;

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
	
	@Given("I am on the app log in page")
	public void i_am_on_the_app_log_in_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I enter valid username {string} and password {string}")
	public void i_enter_valid_username_and_password(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I click signin button")
	public void i_click_signin_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("I am on the Homepage")
	public void i_am_on_the_homepage() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I click on the Update button for the one of the trades")
	public void i_click_on_the_update_button_for_the_one_of_the_trades() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("I should be on Save Trade form")
	public void i_should_be_on_save_trade_form() {
	    
	}

	@When("I update the Trade by changing Entry Price to {string}")
	public void i_update_the_trade_by_changing_entry_price_to(String string) {
	   
	}

	@When("I click Save button")
	public void i_click_save_button() {
	    
	}

	@Then("The trade is updated based on the change")
	public void the_trade_is_updated_based_on_the_change() {
	   
	}

	@Then("The trade remains on the same position on the Trade table")
	public void the_trade_remains_on_the_same_position_on_the_trade_table() {
	   
	}

	@Given("I am on the Homepage")
	public void i_am_on_the_homepage1() {
	    
	}

	@When("I update the Trade with invalid data by leaving the symbol field blank {string}")
	public void i_update_the_trade_with_invalid_data_by_leaving_the_symbol_field_blank(String string) {
	   
	}

	@Then("An error message should be displayed as {string}")
	public void an_error_message_should_be_displayed_as(String string) {
	    
	}

	@Then("The trade should not be updated in the database or the table view")
	public void the_trade_should_not_be_updated_in_the_database_or_the_table_view() {
	    
	}

}
