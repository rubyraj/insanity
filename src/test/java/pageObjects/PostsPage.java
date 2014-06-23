package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PostsPage extends BasePage{
	
	public PostsPage(WebDriver driver){
//		if (!driver.getTitle().matches("Posts.*")){
//			throw new IllegalStateException("This is not Posts Page");
//		}
//		this.driver = driver;
		super(driver, "Posts.*");
	}
	
	public AddNewPostPage clickAddNew(){
		UI.addNew(driver).click();
		return new AddNewPostPage(driver);
	}
	
	public static class UI{
		public static WebElement addNew(WebDriver page){
			return page.findElement(By.linkText("Add New"));
		}
	}
}










// ---------------  OLD Style -------------------------

//public class PostsPage {
//	private WebDriver driver;
//	
//	public PostsPage(WebDriver driver){
//		if (!driver.getTitle().matches("Posts.*")){
//			throw new IllegalStateException("This is not Posts Page");
//		}
//		this.driver = driver;
//	}
//	
//	By addNew = By.linkText("Add New");
//	
//	public AddNewPostPage clickAddNew(){
//		driver.findElement(addNew).click();
//		return new AddNewPostPage(driver);
//	}
//}