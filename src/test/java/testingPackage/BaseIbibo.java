package testingPackage;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseIbibo {
	public static WebDriver driver;
	public static Properties prop;
	
	
	@BeforeTest
	public void beforeTest() throws IOException
	{
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
		driver.manage().deleteAllCookies();
		driver.get("https://www.goibibo.com/flights/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		prop = new Properties();
		File fl = new File(System.getProperty("user.dir")+ "\\src\\\\test\\\\java\\\\testingPackage\\Data.properties");
		FileInputStream fts =new FileInputStream(fl);
		prop.load(fts);
		
		
		
	}
	
	
	@AfterTest
	public void afterTest()
	{
		driver.close();
	}

}
