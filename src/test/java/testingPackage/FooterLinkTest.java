package testingPackage;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class FooterLinkTest {
	
	
	@Test
	public void clickOnFooterLinks()
	{
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromeDriver.exe");
		driver.navigate().to("https://www.booking.com/");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		
		WebElement FooterElement = driver.findElement(By.cssSelector("div#footer"));
		WebElement  footerlinkscolumn = FooterElement.findElement(By.cssSelector("div.footer-navigation-links-column:nth-of-type(1) ul.footer-navigation-links-list"));
		List <WebElement> footerlinks = footerlinkscolumn.findElements(By.tagName("a"));
		
		
		for(WebElement footerlink:footerlinks )
		{
			footerlink.sendKeys(Keys.chord(Keys.CONTROL,Keys.ENTER));
		}
		
		Assert.assertTrue(footerlinks.size()==7);
		
		Set <String> windowhandles = driver.getWindowHandles();
		Iterator <String> it = windowhandles.iterator();
		
		while(it.hasNext())
		{
			System.out.println(driver.switchTo().window(it.next()).getTitle());
				
		}
		driver.quit();
		
		
	}

}
