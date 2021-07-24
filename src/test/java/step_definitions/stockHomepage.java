package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.Driver;
import utilities.PropertiesReader;

public class stockHomepage {
	
	stockLoginElements stocklogin = new stockLoginElements();
	
	//Homepage
	
	@Given("I am external user of Stock Trade market APP")
	public void i_am_external_user_of_stock_trade_market_app() {
	    Driver.getDriver().get(PropertiesReader.getProperty("stockURL"));
	 
	}
	@Given("I login")
	public void i_login() {
		stocklogin.usernameInputField.sendKeys("Sofia");
		stocklogin.passwordInputField.sendKeys("SuperSofia123!");
		stocklogin.signinBtn.click();
	   
	    
	}
	@Then("I should be directed to the homepage of the application")
	public void i_should_be_directed_to_the_homepage_of_the_application() {
	    
		
	}



	



	
}
