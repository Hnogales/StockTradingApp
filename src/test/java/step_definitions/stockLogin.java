package step_definitions;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.stockHomepageElements;
import pages.stockLoginElements;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.PropertiesReader;

public class stockLogin {
	
	
	stockHomepageElements stockhomepage = new stockHomepageElements(); // calling stockHomePage
	stockLoginElements stocklogin = new stockLoginElements();
	
	
	// Jeff
	@Given("I am on the signin page")
	public void i_am_on_the_signin_page() {
		Driver.getDriver().get(PropertiesReader.getProperty("stockURL"));
		Driver.getDriver().manage().window().maximize();
	}
	@When("I enter correct sigin credentials username {string} password {string}")
	public void i_enter_correct_sigin_credentials_username_password(String username, String password) throws InterruptedException {
		Thread.sleep(2000);
		stocklogin.usernameInputField.sendKeys(username);
		Thread.sleep(2000);
		stocklogin.passwordInputField.sendKeys(password);
		Thread.sleep(2000);
	}
	@When("I click on signin button")
	public void i_click_on_signin_button() throws InterruptedException {
		stocklogin.signinBtn.click();
		Thread.sleep(2000);
	}
	@Then("I should be directed to the login page")
	public void i_should_be_directed_to_the_login_page() {
		Assert.assertTrue(stockhomepage.addTradeBtn.isDisplayed());
		Driver.quitDriver();
	}

	
	

}
