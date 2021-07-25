package pages;

import java.util.List;

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
	
	@FindBy (xpath="//select[@id='longTrade']/option[2]")
	public WebElement sellToOpenBtn;
	
	@FindBy (id="symbol")
	public WebElement symbol;
	
	@FindBy(id = "openDate")
	public WebElement entryDate;
	
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
	
	@FindBy (xpath="//*[@id=\"navbarSupportedContent\"]/form[2]/button")
	public WebElement logoutBtn;
	
	@FindBy (xpath="/html/body/nav/button/span")
	public WebElement expandBtn;
	
	@FindBy (xpath="//button[contains(text(),'Log Out')]")
	public WebElement logoutBtn2;
	
	@FindBy (xpath="//div[contains(text(), 'You have been signed out' )]")
	public WebElement signoutMessage;
	
	
	//Sofia
	@FindBy (linkText = "Delete")
	public WebElement deletedBtn;
	
	
	//Giggy
	@FindBy(id = "username")
	public WebElement username;
	
	@FindBy(id = "password")
	public WebElement password;
	
	@FindBy(xpath = "//button[text()='Search']")
	public WebElement searchBtn;

	@FindBy(xpath = "//input[@placeholder='Symbol']")
	public WebElement searchField;
	
	@FindBy(xpath = "//input[@type='date']")
	public WebElement dateField;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-striped']/tbody/tr")
	public WebElement firstRowOfTable;
	
	
	// Tayaba
	@FindBy(xpath = "//li[@class='nav-item active']//a[@class='nav-link']")
	public WebElement homeTitle;
	
	@FindBy (linkText = "Finom Group")
	public WebElement finomGroupTitle;
	
	@FindBy (linkText = "Slack Channel")
	public WebElement slackTitle;
	
	@FindBy(id = "navbarDropdown")
	public WebElement toolsDropdown;
	
	
}
