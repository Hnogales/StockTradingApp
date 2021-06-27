package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class stockUpdatePage {

	
	public stockUpdatePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	
	@FindBy(id = "username")
	public WebElement username;
	
	@FindBy(id = "password")
	public WebElement password;
	
	@FindBy(xpath = "//button[text()='Sign in']")
	public WebElement signInBtn;
	
	@FindBy(linkText = "Add trade")
	public WebElement addTradeBtn;
	
	@FindBy(linkText = "Update")
	public WebElement UpdateTradeBtn;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-striped']/tbody/tr/td[4]")
	public List<WebElement> anyRowEntryPrice;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-striped']/tbody/tr[1]/td")
	public List<WebElement> dataInFirstRow;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-striped']/tbody/tr[4]/td[4]")
	public WebElement updateValueField;
	
	@FindBy(xpath = "input[@type='hidden']")
	public WebElement errorMessagefield;
	
	@FindBy(linkText = "Back to Transactions")
	public WebElement backToRecordBtn;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-striped']/tbody/tr/td[2]")
	public List<WebElement> anyRowSymbol;
	
	
	
	@FindBy(id = "longTrade")
	public WebElement buySellDropdown;
	
	@FindBy(id = "symbol")
	public WebElement stockSymbol;
	
	@FindBy(id = "openDate")
	public WebElement entryDate;
	
	@FindBy(id = "entry")
	public WebElement entryPrice;
	
	@FindBy(id = "closeDate")
	public WebElement exitDate;
	
	@FindBy(id = "exit")
	public WebElement exitPrice;
	
	@FindBy(xpath = "//button[text()='Save']")
	public WebElement saveTradeBtn;
	
	
	

	
	
	
	
}
