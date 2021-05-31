package testingPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;



public class PageClassIbibo {

	WebDriver driver;

	public PageClassIbibo(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		driver = this.driver;
	}

}
