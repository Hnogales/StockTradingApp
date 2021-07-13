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

}
