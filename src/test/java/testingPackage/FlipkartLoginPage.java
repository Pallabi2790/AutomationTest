package testingPackage;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
public class FlipkartLoginPage extends PageClass{
	
	@FindBy(how = How.XPATH, using = ".//form[@autocomplete='on']/div[1]/input[1]") public static WebElement User;
	@FindBy(xpath= ".//span[contains(text(),'Enter Password')]/parent::label/parent::div/input") public static WebElement Password;
	@FindBy(xpath= ".//span[contains(text(),'Login')]/parent::button") public static WebElement Login;
	@FindBy(xpath="//p[contains(text(),'Home & Furniture')]/parent::a") public WebElement Furniture;
	@FindBy(xpath="//div[contains(text(),'Grab Now')]/parent::a[contains(@href,'bedsheets')]/div[2]") public WebElement Bedsheets;
	@FindBy(css="input[placeholder*='Search']") public WebElement SearchBox;
	@FindBy(xpath="//ul/li/button[1]") public WebElement AddToCart;
	@FindBy(xpath="//div[contains(text(),'Save for later')]/ancestor::div/div[2]/div/div/button[2]") public WebElement IncreaseCount;
	@FindBy(xpath="//span[contains(text(),'Place Order')]/parent::button") public WebElement PlaceOrder;
	
	@FindBy(xpath="//div[contains(text(),'4')]/parent::label/input") public WebElement FourStarRating;
	@FindBy(xpath="//span[contains(text(),'Price')]/ancestor::section/descendant::select[1]") public WebElement LowestPrice;
	@FindBy(xpath="//span[contains(text(),'Price')]/ancestor::section/descendant::select[2]") public WebElement HighestPrice;
	
	WebDriverWait wait;
	JavascriptExecutor js;
	
	//div/div/div/div[1]/div[1]/button[1]/following-sibling::button[1]
	public FlipkartLoginPage(WebDriver driver)
	{
	    super(driver);
	}
		

	

	public void login() throws IOException
	{	
	if (driver.findElement(By.xpath(".//a[contains(text(),'New to Flipkart')]")).isDisplayed())
    User.sendKeys("9073906808");
	Password.sendKeys("Pallabi@27");	
	Login.click();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	js = (JavascriptExecutor)driver;	
	wait = new WebDriverWait(driver,15);
   }
	
	public void addBedsheets(String Item, int Qty)
	{
	
		wait.until(ExpectedConditions.elementToBeClickable(Furniture));
		js.executeScript("arguments[0].click()", Furniture);
		
		
		
		wait.until(ExpectedConditions.titleContains("Home Furniture"));
		
		SearchBox.sendKeys("\""+Item+"\"");
		SearchBox.sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//a[contains(text(),'" + "Tanishka Fabs 140 TC Microfiber Double Floral Bedsheet" + "')]")).isDisplayed();
		driver.findElement(By.xpath("//a[contains(text(),'" + "Tanishka Fabs 140 TC Microfiber Double Floral Bedsheet" + "')]")).click();
		
		Set <String> windows = driver.getWindowHandles();
		java.util.Iterator <String> it = windows.iterator() ;
		it.next();
		
		
		driver.switchTo().window(it.next()).getTitle();
		
		int count = 1;
		AddToCart.click();
		
		while (count<Qty)
		{
			
			IncreaseCount.click();
			count = count + 1;
		/*Bedsheets.click();
		
		FourStarRating.click();
		
		Select lowestPrice = new Select(LowestPrice);
		Select highestPrice = new Select(HighestPrice);
		
		lowestPrice.selectByValue("Min");
		highestPrice.selectByValue("500");
		
		Item.click();*/
		
	}
		PlaceOrder.click();
}
	
}

