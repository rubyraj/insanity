package myTests;

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

public class JavaJunit4WebdriverTestNG {
  private WebDriver driver;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

//  @BeforeTest
  public void setUp() throws Exception {
	  driver = TestBase.navigateToPage("/wordpress/wp-login.php");
  }

//  @Test
  public void testJavaJunit4Webdriver() throws Exception {
	LoginPage loginPage = new LoginPage(driver);
	loginPage.loginAs("admin", "demo123");
	Assert.assertTrue( loginPage.isUsernameMatches("admin") ); 
	  
	HomePage homePage = new HomePage(driver);
	PostsPage postsPage = homePage.clickPosts();
    
    AddNewPostPage addNewPostPage = postsPage.clickAddNew();
	EditPostPage editPostPage = addNewPostPage
		.enterPostTitle("Selenium Demo Post")
		.clickPublish();
	Assert.assertTrue( editPostPage.isPublished() );
  }

//  @AfterTest
  public void tearDown() throws Exception {
	  //logout
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      Assert.fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
