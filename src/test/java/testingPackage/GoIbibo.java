package testingPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoIbibo extends PageClassIbibo{
	
	
	@FindBy(css="input#gosuggest_inputSrc") public WebElement SourceCity;
	@FindBy(css="input#gosuggest_inputDest") public WebElement DestinationCity;
	@FindBy(xpath="//input[@id='departureCalendar']") public WebElement DateSelector;
	@FindBy(css="div[class*='today']") public WebElement CurrentDate;
	@FindBy(xpath="//button[contains(text(),'SEARCH')]") public WebElement SearchButton;
	@FindBy(xpath="//div[contains(@class,'RightWrap')] //div //button[contains(text(),'BOOK')][1]") public WebElement Book;
	@FindBy(xpath="//span[contains(text(),'Total Amount')]/parent::div/following-sibling::div/div/span") public WebElement Total;
	
	public GoIbibo(WebDriver driver)
	{
		super(driver);
		
	}

	
	public void selectCities(String source, String destination) throws InterruptedException
	{
		SourceCity.sendKeys(source);
		
		Thread.sleep(2000);
		SourceCity.sendKeys(Keys.DOWN);
		SourceCity.sendKeys(Keys.ENTER);		
				
	    DestinationCity.sendKeys(destination);
				
		Thread.sleep(2000);
		DestinationCity.sendKeys(Keys.DOWN);
		DestinationCity.sendKeys(Keys.ENTER);
	}
	
	public void selectCurrentDate()
	{
		
		DateSelector.click();
		CurrentDate.click();
	}
	
	public void SearchFlightsandClickBook()
	{
		SearchButton.click();
		Book.click();
	}
	
	public String TotalAmount()
	{
		return Total.getAttribute("innerText").replace("₹", "").replace(",","");
		
	}
}
