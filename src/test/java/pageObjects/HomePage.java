package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class HomePage extends BasePage{

	public HomePage(WebDriver driver){
		super(driver, "Dashboard.*WordPress Demo Install.*WordPress");
	}

	public PostsPage clickPosts(){
		UI.posts(driver).click();
		return new PostsPage(driver);
	}
	
	//-------------------- Object Repository -----------------------------//
	public static class UI{
		public static WebElement posts(WebDriver page){
			return page.findElement(By.linkText("Posts"));
		}
	}

}
