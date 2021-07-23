package step_definitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.stockUpdatePage;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.PropertiesReader;

public class stockUpdate {
	
	
	stockUpdatePage updatePage = new stockUpdatePage();
	BrowserUtils utils = new BrowserUtils();
	String InputUpdatePrice;
	String InputUpdateSymbol;
	
	
	// UpdateValid
	
	@Given("I am on the app log in page")
	public void i_am_on_the_app_log_in_page() {
		Driver.getDriver().get(PropertiesReader.getProperty("stockURL"));
	}
	@When("I enter valid username {string} and password {string}")
	public void i_enter_valid_username_and_password(String string, String string2) {
		updatePage.username.sendKeys(string);
		updatePage.password.sendKeys(string2);
	}

	@And("I click signin button")
	public void i_click_signin_button() {
		updatePage.signInBtn.click();
	}
	
	@Then("I am on the Homepage")
	public void i_am_on_the_homepage() {
		utils.waitUntilElementVisible(updatePage.addTradeBtn);
	}
	
	@When("I click on the Update button for the one of the trades")
	public void i_click_on_the_update_button_for_the_one_of_the_trades() {
		updatePage.UpdateTradeBtn.click();
	}
	
	@Then("I should be on Save Trade form")
	public void i_should_be_on_save_trade_form() {
		 utils.waitUntilElementVisible(updatePage.saveTradeBtn);
		 Assert.assertTrue(updatePage.saveTradeBtn.isDisplayed());
	}
	
	
	@When("I update the Trade by changing Entry Price to {string}")
	public void i_update_the_trade_by_changing_entry_price_to(String updatePrice) throws InterruptedException {
		InputUpdatePrice = updatePrice;
		
		updatePage.entryPrice.clear();
	    Thread.sleep(3000);
	    
	    updatePage.entryPrice.sendKeys(updatePrice);
	    Thread.sleep(3000);
	    
		System.out.println("InputUpdatePriceprice is " + InputUpdatePrice);    // PRINT
	    //System.out.println("InputUpdatePrice is " + InputUpdatePrice.substring(0, InputUpdatePrice.length()-1));  // PRINT
	}
	
	
	
	@And("I click Save button")
	public void i_click_save_button() {
		updatePage.saveTradeBtn.click();
	}
	
	@Then("The trade is updated based on the change")
	public void the_trade_is_updated_based_on_the_change() {
	  
			utils.waitUntilElementVisible(updatePage.anyRowEntryPrice.get(0));
			
			for(WebElement element : updatePage.anyRowEntryPrice) {
	
				String actualUpdatePrice = element.getText();
				
				System.out.println("actualUpdatePrice is " + actualUpdatePrice);    // PRINT
				
				boolean flag = false;
				
				if(actualUpdatePrice.substring(1).equals(InputUpdatePrice)) {
					flag = true;
					Assert.assertTrue(flag);
					System.out.println(flag);
					break;	
				}
				
		}
			
		
	}
	

	@And("The trade remains on the same position on the Trade table")
	public void the_trade_remains_on_the_same_position_on_the_trade_table() {
		
		System.out.println("================================================");  // PRINT
		
		utils.waitUntilElementVisible(updatePage.dataInFirstRow.get(0));
		
		for(WebElement element : updatePage.dataInFirstRow) {

			String actualUpdatePrice = element.getText();
			
			System.out.println("dataInFirstRow is " + actualUpdatePrice);    // PRINT
			
			
			boolean flag = false;
			
			if(actualUpdatePrice.substring(1).equals(InputUpdatePrice)) {
				flag = true;
				Assert.assertTrue(flag);
				System.out.println(flag);
				break;	
			}
			
		}
		
	}	
		
//		String actualUpdateValueField = updatePage.updateValueField.getText();
//		Assert.assertEquals(actualUpdateValueField.substring(1), InputUpdatePrice);
//		
//		Driver.getDriver().quit();
//		
//		System.out.println("InputUpdatePrice is " + InputUpdatePrice);	// PRINT
//		System.out.println("actualUpdateValueField price is " + actualUpdateValueField.substring(1));  // PRINT
	
		
	

	
	// UpdateInvalid
	
	
	
//	@When("I update the Trade with invalid data by leaving the symbol field blank")
//	public void i_update_the_trade_with_invalid_data_by_leaving_the_symbol_field_blank() {
//	    
//	}
	
	
	
	@When("I update the Trade with invalid data by leaving the symbol field blank {string}")
	public void i_update_the_trade_with_invalid_data_by_leaving_the_symbol_field_blank(String updateSymbol) throws InterruptedException {
		InputUpdateSymbol = updateSymbol;
		
		updatePage.stockSymbol.clear();
//		Thread.sleep(3000);
		
		updatePage.stockSymbol.sendKeys(updateSymbol);
//		Thread.sleep(3000);

		System.out.println("InputUpdateSymbol: " + InputUpdateSymbol);
		
	}


	@Then("An error message should be displayed as {string}")
	public void an_error_message_should_be_displayed_as(String expectedErrorMessage) throws InterruptedException {
		
		Thread.sleep(2000);
		
		String actualErrorMessage = updatePage.stockSymbol.getAttribute("validationMessage");
		
		//String errorMessage = updatePage.stockSymbol.getAttribute("class");
		System.out.println("expectedErrorMessage: " + expectedErrorMessage);
		System.out.println("actualErrorMessage: " + actualErrorMessage);
		
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
		
		
		
	}
	@And("The trade should not be updated in the database or the table view")
	public void the_trade_should_not_be_updated_in_the_database_or_the_table_view() {
	
		updatePage.backToRecordBtn.click();
		
		utils.waitUntilElementVisible(updatePage.anyRowSymbol.get(0));
		
		System.out.println("InputUpdateSymbol is " + InputUpdateSymbol);    // PRINT
		
		for(WebElement element : updatePage.anyRowSymbol) {

			String actualUpdateSymbol = element.getText();
			
			
			System.out.println("actualUpdateSymbol is " + actualUpdateSymbol);    // PRINT
			
			boolean flag = false;
			
			if(actualUpdateSymbol.equals(InputUpdateSymbol)) {
				flag = true;
				Assert.assertFalse(flag);
				System.out.println(flag);
				break;	
			}	
			
		}
		
		Driver.quitDriver();	
		
		
	}

	
	
	
	
}