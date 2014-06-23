package pageObjects;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginPage extends BasePage{
//	private WebDriver driver;
//	private StringBuffer verificationErrors = new StringBuffer();
	
	public LoginPage(WebDriver driver){
//		if (!driver.getTitle().matches("WordPress Demo Install*Log In")){
//			throw new IllegalStateException("This is not login page");
//		}
//		this.driver = driver;
		super(driver, "WordPress Demo Install.*Log In");
	}
	
	public LoginPage enterUserName(String user){
		UI.TextBox.username(driver).clear();
		UI.TextBox.username(driver).sendKeys(user);
	    return this;
	}
	
	public LoginPage enterPassword(String pass){
		UI.TextBox.password(driver).clear();
		UI.TextBox.password(driver).sendKeys(pass);
	    return this;
	}
	
	public void clickSubmit(){
		UI.Buttons.submit(driver).click();
//		return new HomePage(driver);
	}
	
	public LoginPage clickSubmitNoSuccess(){
		UI.Buttons.submit(driver).click();
		return new LoginPage(driver);
	}
	
	public void loginAs(String user, String password){
		enterUserName(user);
		enterPassword(password);
		clickSubmit();
	}
	
	public Boolean hasErrorText(String expected){
		String actual = UI.Text.loginError(driver).getText();
		return actual.matches("ERROR.*" + expected);
	}
//	// ------------------- Verification Methods ---------------------
//	public void checkUserNameMatches(String name){
//	    try {
//	    	AssertJUnit.assertEquals( "Howdy, "+name, UI.Links.myAccount(driver).getText() );
//    	} catch (Error e) {
//    		verificationErrors.append(e.toString());
//    	}
//	}
	
	
	//------------------------ Object Repository ---------------------
	public static class UI{
		public static class TextBox{
			public static WebElement username(WebDriver page){
				return page.findElement(By.id("user_login"));
			}
			
			public static WebElement password(WebDriver page){
				return page.findElement(By.id("user_pass"));
			}
		}
		
		public static class Buttons{
			public static WebElement submit(WebDriver page){
				return page.findElement(By.id("wp-submit"));
			}	
		}

		public static class Text{
			public static WebElement loginError(WebDriver page){
				return page.findElement(By.id("login_error"));
			}
		}
//		public static class Links{
//			public static WebElement myAccount(WebDriver page){
//				return page.findElement(By.cssSelector("a.ab-item"));
//			}
//		}

	}
	
}



//
//
////==================== BEST EXAMPLE FOR UI LAYER FOUND ONLINE ============================
//package com.clearqa.test;
//
//import java.io.IOException;
//import java.util.Properties;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
// 
//public class CTaxBandSearch
//{
//  private WebDriver driver;
//	private Properties prop = new Properties();
//	
//	public CTaxBandSearch(WebDriver d) {
//		this.driver = d;
//		if(!driver.getTitle().equals("Search for your Council Tax band")) {
//			throw new IllegalStateException("This is not Council Tax band search page. It title is: " + driver.getTitle());
//		}
//		try {
//			prop.load(getClass().getClassLoader().getResourceAsStream("ui_mapping.properties"));
//		} catch (IOException e) {
//			throw new IllegalStateException(e);
//		}
//	}
//	
//	public String search(String postcode, String first_addr_line) {
//	    driver.findElement(By.id(prop.getProperty("ctband.postcode_search"))).clear();
//	    driver.findElement(By.id(prop.getProperty("ctband.postcode_search"))).sendKeys(postcode);
//	    driver.findElement(By.xpath(prop.getProperty("ctband.search_button_xpath"))).click();
//	    driver.findElement(By.partialLinkText(first_addr_line.toUpperCase())).click();
//	    WebElement e = driver.findElement(By.xpath(prop.getProperty("ctband.result_table_xpath")));
//	    return e.getText();
//	}
//}