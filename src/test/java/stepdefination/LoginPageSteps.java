package stepdefination;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginPageSteps extends BaseClass{
	
	private static String title;
	WebDriver driver;
	
	private LoginPage loginPage=new LoginPage(DriverFactory.getDriver());
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
		 driver = DriverFactory.getDriver();       // ✅ get driver after browser launch
		    loginPage = new LoginPage(driver); 
		DriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		
	
	  
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		String title=loginPage.getLoginPageTitle();
		System.out.println("login page title is:"+title);
		
	  
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
		String title=loginPage.getLoginPageTitle();
		System.out.println("login page title is:"+title);
		Assert.assertTrue(title.contains(expectedTitleName));
	 
	}

	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
		  boolean isDisplayed = loginPage.isForgetPwdLinkExist();

		    if (isDisplayed) {
		        System.out.println("✅ Forgot Password link is displayed on Login page");
		    } else {
		        System.out.println("❌ Forgot Password link is NOT displayed on Login page");
		    }
	}
	

	@When("user enters username {string}")
	public void user_enters_username(String username) {
		
		loginPage.enterUserName(username); 
	
		}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
		loginPage.enterPassword(password);
		
	}
	  
	

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		loginPage.clickOnLogin();
	    
	}
//
@Then("user gets the title of the home page")
	public void user_gets_the_title_of_the_home_page() {
	
		 WebDriver driver = DriverFactory.getDriver(); // DriverFactory se driver le rahe hain
		    if(driver != null) {
		        String title = driver.getTitle();
		        System.out.println("Home page title is: " + title);
		    } else {
		        throw new IllegalStateException("WebDriver is not initialized. Cannot get page title.");
		    }
}
		    //dashboard scroll down and scroll up
		    
		    @When("User scrolls down the dashboard page")
		    public void user_scrolls_down_the_dashboard_page() throws InterruptedException {
		    	Thread.sleep(3000);
		    	 JavascriptExecutor js = (JavascriptExecutor) driver;
		         js.executeScript("window.scrollBy(0,1000)");
		       
		    }
		    @When("User scrolls up the dashboard page")
		    public void user_scrolls_up_the_dashboard_page() throws InterruptedException {
		    	Thread.sleep(3000);
		    	JavascriptExecutor js = (JavascriptExecutor) driver;
		        js.executeScript("window.scrollTo(1000,0)");
		    }
		    @Then("Dashboard page should be visible properly")
		    public void dashboard_page_should_be_visible_properly() throws InterruptedException {
		    	WebDriver driver = DriverFactory.getDriver(); // DriverFactory se driver le rahe hain
		    	Thread.sleep(2000);
			    if(driver != null) {
			        String title = driver.getTitle();
			        System.out.println("Home page title is: " + title);
			    } else {
			        throw new IllegalStateException("WebDriver is not initialized. Cannot get page title.");
			    }
	}
		  
		    //Refresh dashboard page scenario
		    @When("Refersh the dashboard page")
		    public void refersh_the_dashboard_page() throws InterruptedException {
		    	Thread.sleep(2000);
		       driver.navigate().refresh();
		       System.out.println("Dahsboard page refresh");
		    }
		    
		    //scenario with 
		    
		    @Then("user should see {string}")
		    public void user_should_see(String result) throws InterruptedException {
		    	Thread.sleep(2000); // Wait for login response

		        if (result.startsWith("http")) {

		            String currentUrl = driver.getCurrentUrl();
		            Assert.assertEquals(currentUrl, result);

		        } else {
                  Thread.sleep(2000);
		            Assert.assertTrue(loginPage.isErrorMessageDisplayed(),
		                    "Error message is not displayed");
		            Thread.sleep(2000);
		            String actualError = loginPage.getErrorMessageText();
		            Assert.assertEquals(actualError, result);
		        }
		  
}
		    
		    @Then("user should see required error message {string}")
		    public void user_should_see_required_error_message(String emptyerrormessage) {
		    	
		    	// check if the empty error message is displayed
		        boolean isDisplayed = loginPage.isEmptyErrorMessageDisplayed();
		        
		        // fail the test if message is not displayed
		        Assert.assertTrue(isDisplayed, "Required error message is not displayed!");

		        // validate the actual text
		        String actualMessage = loginPage.getEmptyErrorMessageText();
		        Assert.assertEquals(actualMessage, emptyerrormessage, "Error message text does no");
		       
		    }
		    
		    
		    
		   
}