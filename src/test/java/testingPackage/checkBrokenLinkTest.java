package testingPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;


public class checkBrokenLinkTest {
	
	@Test
	public void checkLinks() throws MalformedURLException, IOException
	{
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromeDriver.exe");
		driver.navigate().to("https://www.booking.com/");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		WebElement FooterElement = driver.findElement(By.cssSelector("div#footer"));
		List <WebElement> links = FooterElement.findElements(By.tagName("a"));
		
		SoftAssert sa = new SoftAssert();
		System.out.println(links.size());
		
		for (WebElement link: links )
		{
			String hrefattribute = link.getAttribute("href");
			
			HttpURLConnection URL = (HttpURLConnection) new URL(hrefattribute).openConnection();
			URL.setRequestMethod("HEAD");
			URL.connect();
			if(URL.getResponseCode()>=400)
					{
				System.out.println("This link" + link.getText() + " is broken");
				    sa.assertFalse(URL.getResponseCode()>=400);
					}
			
		}
		sa.assertAll();
		driver.close();
	}

}
