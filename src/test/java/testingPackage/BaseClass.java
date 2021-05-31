package testingPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.google.common.io.Files;

public class BaseClass {

	
	public static WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	public static ArrayList<Object> ItemdataArray;
	public static ArrayList<Object> QtydataArray;
	
	public static ArrayList<ArrayList<Object>> AllData;
	
	
	@BeforeTest
	public void setDriver() throws IOException
	{
		
		ItemdataArray = new ArrayList<Object>();
		QtydataArray = new ArrayList<Object>();
		
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\aroy1\\eclipse-workspace\\seleniumTesting\\chromedriver.exe");	
		driver.get("https://www.flipkart.com/");
		wait = new WebDriverWait(driver,10);
			
		
	}
	
	
	public ArrayList<ArrayList<Object>> setData() throws IOException{
		
		ItemdataArray = new ArrayList<Object>();
		QtydataArray = new ArrayList<Object>();
		AllData = new ArrayList<ArrayList<Object>>();
		
		Properties prop = new Properties();
		
		FileInputStream fts = new FileInputStream(System.getProperty("user.dir")+"\\TestDataProperty.properties");
		prop.load(fts);
		ItemdataArray.add(prop.getProperty("Item").toString().replace("[","").replace("]",""));
		QtydataArray.add(Integer.parseInt(prop.getProperty("Qty").toString().replace("[","").replace("]","")));
		
		AllData.add(ItemdataArray);
		AllData.add(QtydataArray);
		
		return AllData;
	}
	
	@AfterTest
	public void closeBrowser() throws IOException
	{
		
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File (System.getProperty("user.dir")+"\\CurrentPage.jpg");
		
		Files.copy(src, dest);
		driver.close();
	}
	}





