package pageObjects;

import org.openqa.selenium.*;
import org.testng.AssertJUnit;
import org.openqa.selenium.interactions.Actions;

import pageObjects.LoginPage.UI;

public class BasePage {
	protected WebDriver driver;
	protected StringBuffer verificationErrors = new StringBuffer();
	
	public BasePage(WebDriver driver, String title){
			String expected = driver.getTitle(); 
			if (!expected.matches(title)){
				throw new IllegalStateException("This is not " +title+" Page. Got:" + expected);
			}
			this.driver = driver;
	}
	
	public void logout(){
	    Actions action = new Actions(driver);
	    action.moveToElement( UI.Links.myAccount(driver) );
		action.moveToElement( driver.findElement(By.id("wp-admin-bar-logout")) ).click();
		action.build().perform();
	}
	
	// ------------------- Verification Methods ---------------------
	public Boolean isUsernameMatches(String name){
		UI.Links.myAccount(driver).click();
		String actual = UI.Links.myAccount(driver).getText();
		return ("Howdy, "+name).equals( actual );
//	    try {
//	    	AssertJUnit.assertEquals( "Howdy, "+name, UI.Links.myAccount(driver).getText() );
//    	} catch (Error e) {
//    		verificationErrors.append(e.toString());	
//    	}
	}
	
	
	//------------------------ Object Repository ---------------------
	public static class UI{	
		public static class Links{
			public static WebElement myAccount(WebDriver page){
//				return page.findElement(By.cssSelector("a.ab-item"));
				return page.findElement(By.id("wp-admin-bar-my-account"));
			}
		}
	}
}
	