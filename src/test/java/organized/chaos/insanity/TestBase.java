	package organized.chaos.insanity;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
	
	private static WebDriver driver;
	
	public static WebDriver navigateToPage(String url){
	    String baseUrl = "http://demo.opensourcecms.com/";
	    driver = TestBase.setDriver("firefox");
		driver.get(baseUrl+url);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//		Boolean myDynamicElement = (new WebDriverWait(driver, 10))
//				.until( ExpectedConditions.titleContains("WordPress") );
//		System.out.println(myDynamicElement);
		return driver;
	}
	
	public static WebDriver setDriver(String browser){
//		if (browser=="firefox"){
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		}
		return driver;
	}

	public static WebDriver getDriverInstance(){
		return driver;
	}
}
