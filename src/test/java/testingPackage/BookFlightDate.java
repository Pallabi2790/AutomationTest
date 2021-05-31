package testingPackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookFlightDate {
	
	
	@Test
	public void selectDate()
	{
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromeDriver.exe");
		driver.navigate().to("https://www.booking.com/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("div[data-mode='checkin']")).click();
		
		
		WebElement checkinmonth = driver.findElement(By.xpath("//div[@class='bui-calendar__content']/div[1]/div"));
		WebElement checkoutmonth = driver.findElement(By.xpath("//div[@class='bui-calendar__content']/div[2]/div"));
		
		WebElement NextMonth = driver.findElement(By.cssSelector("div[class*='calendar-contrasts'] div[data-bui-ref='calendar-next'] svg"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(NextMonth));
				
		//checkinmonth.click();
				
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click()", returndate);
	
		//wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'datepicker-group-first')]/div/div/span[1]")));
		
		while(!(driver.findElement(By.xpath("//div[@class='bui-calendar__content']/div[1]/div")).getText().contains("October")))
		{
			NextMonth.click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='bui-calendar__content']/div[1]/div")));
			
		}//
		
		
		List <WebElement> CheckInDateParent = driver.findElements(By.xpath("//div[@class='bui-calendar__content']/div[1]/table/tbody/tr/td"));
		List <WebElement> CheckInDateChild = driver.findElements(By.xpath("//div[@class='bui-calendar__content']/div[1]/table/tbody/tr/td/span/span"));
		
		for(int i= 0; i< CheckInDateChild.size(); i++)
		{
			String Date = CheckInDateChild.get(i).getAttribute("innerText");
			if(Date.equals("21)"))
			{
				System.out.println("clicked");
				//CheckInDateParent.get(i).click();
				
			  break;
			}
					
		}
	}

}
