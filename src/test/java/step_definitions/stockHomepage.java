package step_definitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.stockHomepageElements;
import pages.stockLoginElements;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.PropertiesReader;

public class stockHomepage {

	BrowserUtils utils = new BrowserUtils(); // calling utils
	 stockHomepageElements stockhomepage = new stockHomepageElements(); // calling stockHomePage
	 stockLoginElements stocklogin = new stockLoginElements();

	// Harold

	@Given("I am on the Stock Homepage")
	public void i_am_on_the_stock_homepage() {
	Driver.getDriver().get(PropertiesReader.getProperty("stockURL")); 
	stocklogin.usernameInputField.sendKeys("Harold");
	stocklogin.passwordInputField.sendKeys("SuperHarold123!");
	stocklogin.signinBtn.click();

	}

	@Given("click on {string}")
	public void click_on(String string) {
		stockhomepage.addTradeBtn.click();

	}

	@Then("I should be able to add a trade")
	public void i_should_be_able_to_add_a_trade() {
		stockhomepage.sellToOpenBtn.click();
		stockhomepage.symbol.sendKeys("CB Test");
		stockhomepage.openDate.sendKeys("06/08/2021");
		stockhomepage.entryPrice.sendKeys("28");
		stockhomepage.closeDate.sendKeys("06/28/2021");
		stockhomepage.exitPrice.sendKeys("77");
		stockhomepage.saveBtn.click();

	}

}
