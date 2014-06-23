package pageObjects;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AddNewPostPage {
	private WebDriver driver;
	
	public AddNewPostPage(WebDriver driver){
			if (!driver.getTitle().matches("Add New Post.*")){
				throw new IllegalStateException("This is not Add New Post Page.");
			}
			this.driver = driver;
	}

	By title = By.id("title");
	By publish = By.id("publish");
	
	public AddNewPostPage enterPostTitle(String text){
		driver.findElement(title).clear();
		driver.findElement(title).sendKeys(text);
		return this;
	}
	
	public EditPostPage clickPublish(){
		driver.findElement(publish).click();
		return new EditPostPage(driver);
	}
	
	public EditPostPage addNewPost(String title){
		enterPostTitle(title);
		return clickPublish();
	}
}
