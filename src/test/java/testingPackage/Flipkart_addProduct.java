package testingPackage;


import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.*;

public class Flipkart_addProduct extends BaseClass{
	
	FlipkartLoginPage flc ;
	
	public static ArrayList<ArrayList<Object>> TestData;
	
	@Test
	
	public void logintoFlipkartandAddProducts() throws IOException
	{
	
		
		flc = new FlipkartLoginPage(driver);
		flc.login();
		TestData = setData();
		
		flc.addBedsheets(TestData.get(0).get(0).toString(),Integer.parseInt(TestData.get(1).get(0).toString()));
		
		
		
    }
	
}
