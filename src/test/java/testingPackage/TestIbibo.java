package testingPackage;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestIbibo extends BaseIbibo{
	
	GoIbibo goIbibo ;
	//ArrayList <String> Cities;
	//ReadExcelIbibo readexcel;
	
	
	
	@Test	
	public void test() throws IOException, InterruptedException
	{
		
		//Cities = new ArrayList<String>();
		
		goIbibo = new GoIbibo(driver);
		//Cities = readexcel.readData();
		goIbibo.selectCities(prop.getProperty("source"), prop.getProperty("destination"));
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class*='today']")));
		
		goIbibo.selectCurrentDate();
		goIbibo.SearchFlightsandClickBook();
		
		String TotalAmount = goIbibo.TotalAmount();
		
		Assert.assertTrue(Integer.parseInt(TotalAmount)>0);
		
		
		
	}

}
