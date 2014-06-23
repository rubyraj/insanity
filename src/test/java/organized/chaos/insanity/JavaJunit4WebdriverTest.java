package organized.chaos.insanity;

import org.testng.annotations.*;
import org.testng.Assert;
//import org.testng.AssertJUnit;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
//import org.junit.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.Select;

import pageObjects.AddNewPostPage;
import pageObjects.EditPostPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.PostsPage;

@Listeners({ ScreenShotOnFailure.class })

public class JavaJunit4WebdriverTest {
	private WebDriver driver;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private String loginUrl =  "http://demo.opensourcecms.com/wordpress/wp-login.php";

	@BeforeTest
	public void setUp() throws Exception {
		driver = TestBase.setDriver("firefox");
	}

	@AfterTest
	public void tearDown() throws Exception {
		// logout
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			Assert.fail(verificationErrorString);
		}
	}
	
	@Test
	public void testJavaJunit4Webdriver() throws Exception {
		driver.get(loginUrl);
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginAs("admin", "demo123");
		Thread.sleep(3000);
		Assert.assertTrue(loginPage.isUsernameMatches("admin"));

		HomePage homePage = new HomePage(driver);
		PostsPage postsPage = homePage.clickPosts();

		AddNewPostPage addNewPostPage = postsPage.clickAddNew();
		EditPostPage editPostPage = addNewPostPage.enterPostTitle(
				"Selenium Demo Post").clickPublish();
		Assert.assertTrue(editPostPage.isPublished());
		
		editPostPage.logout();
	}

	@Test
	public void testInvalidUsername() throws Exception {
		driver.get(loginUrl);
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginAs("exit", "demo123");
		Assert.assertTrue(loginPage.hasErrorText("Invalid username.*"));
	}
	
	@Test
	public void testInvalidPassword() throws Exception {
		driver.get(loginUrl);
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginAs("admin", "admin");
		Assert.assertTrue(loginPage.hasErrorText("The password you entered for the username admin is incorrect.*"));
	}
	

//	private boolean isElementPresent(By by) {
//		try {
//			driver.findElement(by);
//			return true;
//		} catch (NoSuchElementException e) {
//			return false;
//		}
//	}
//
//	private boolean isAlertPresent() {
//		try {
//			driver.switchTo().alert();
//			return true;
//		} catch (NoAlertPresentException e) {
//			return false;
//		}
//	}
//
//	private String closeAlertAndGetItsText() {
//		try {
//			Alert alert = driver.switchTo().alert();
//			String alertText = alert.getText();
//			if (acceptNextAlert) {
//				alert.accept();
//			} else {
//				alert.dismiss();
//			}
//			return alertText;
//		} finally {
//			acceptNextAlert = true;
//		}
//	}
}
