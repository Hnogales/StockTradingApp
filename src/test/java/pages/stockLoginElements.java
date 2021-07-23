package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class stockLoginElements {
	
	
	// This class contains all our login page elements
	
	public stockLoginElements() {						
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy (xpath="//input[contains(@id, 'username')]")
	public WebElement usernameInputField;
	
	@FindBy (xpath="//input[contains(@id, 'password')]")
	public WebElement passwordInputField;
	
	@FindBy (xpath="//button[contains(text(), 'Sign in')]")
	public WebElement signinBtn;

}
