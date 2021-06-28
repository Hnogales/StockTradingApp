package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class stockHomepageElements {
	
	// This class contains all our homepage elements

	public stockHomepageElements() {						
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy (xpath="//a[contains(@href, '/records/showFormForAdd')]")
	public WebElement addTradeBtn;
	
	@FindBy (xpath="//select[@id='longTrade']/option[2]")
	public WebElement sellToOpenBtn;
	
	@FindBy (id="symbol")
	public WebElement symbol;
	
	@FindBy (xpath="//input[@id='openDate']")
	public WebElement openDate;
	
	@FindBy (xpath="//input[@id='entry']")
	public WebElement entryPrice;
	
	@FindBy (xpath="//input[@id='closeDate']")
	public WebElement closeDate;
	
	@FindBy (xpath="//input[@id='exit']")
	public WebElement exitPrice;
	
	@FindBy (xpath="//button[contains(text(),'Save')]")
	public WebElement saveBtn;
	
	
}
