package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class StockSearchPage {
	
	public StockSearchPage() {
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
	
	@FindBy(xpath = "//button[text()='Search']")
	public WebElement searchBtn;

	@FindBy(xpath = "//input[@placeholder='Symbol']")
	public WebElement searchField;
	
	@FindBy(xpath = "//input[@type='date']")
	public WebElement dateField;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-striped']/tbody/tr[1]/td[2]")
	public WebElement anyRowStockSymbol;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-striped']/tbody/tr[1]/td")
	public List<WebElement> dataInFirstRow;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-striped']/tbody/tr")
	public WebElement firstRowOfTable;

}
