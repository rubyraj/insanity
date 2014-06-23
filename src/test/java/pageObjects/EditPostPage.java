package pageObjects;

import org.openqa.selenium.*;
import org.testng.AssertJUnit;

public class EditPostPage extends BasePage{
//	private WebDriver driver;
//	private StringBuffer verificationErrors = new StringBuffer();
	
	public EditPostPage(WebDriver driver){
//			if (!driver.getTitle().matches("Edit Post.*")){
//				throw new IllegalStateException("This is not Edit Post Page.");
//			}
//			this.driver = driver;
			super(driver, "Edit Post.*");
	}
	
	public Boolean isPublished(){
		return UI.publishMessage(driver).getText().matches("^Post published.*");
	}
	
	//----------------------------- Verification Methods -------------------------//
	public void checkMessage(String message){
	    try {
	        AssertJUnit.assertTrue(UI.publishMessage(driver).getText().matches("^"+message+".*"));
	      } catch (Error e) {
	        verificationErrors.append(e.toString());
	      }
	}
	
	//-------------------- Object Repository -----------------------------//
	public static class UI{
		public static WebElement publishMessage(WebDriver page){
			return page.findElement(By.id("message"));
		}
	}

}
