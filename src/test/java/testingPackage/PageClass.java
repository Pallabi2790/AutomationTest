package testingPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageClass {
	
	protected WebDriver driver;
	
	public PageClass(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		 this.driver = driver;
	}

}
