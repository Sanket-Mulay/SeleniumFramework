package stepdefination;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import com.pages.AdminPage;
import com.pages.AlarmPage;
import com.pages.PunchInOutPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminPageSteps extends BaseClass{
	
	private AdminPage adminPage=new AdminPage(DriverFactory.getDriver());
	//private PunchInOutPage punchInPage=new PunchInOutPage(DriverFactory.getDriver());




@Given("User is on Login page")
public void user_is_on_login_page() {
	 driver = DriverFactory.getDriver();       // ✅ get driver after browser launch
	 adminPage = new AdminPage(driver); 
	DriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	// 3. Initialize Page Object
	adminPage = new AdminPage(driver);

  

}

@When("User enters valid username and password")
public void user_enters_valid_username_and_password() throws InterruptedException {
	  // 4. Perform login
	Thread.sleep(3000);
		adminPage.login("Admin", "admin123");// replace with valid credentials

}

@Then("User should be logged in successfully")
public void user_should_be_logged_in_successfully() {
	
	String currentURL=driver.getCurrentUrl();
	String expectedURL="https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers";
	if(currentURL.equals(expectedURL)) {
		System.out.println("Currently on Dashboard Page");
	}else {
		System.out.println("Not on Dashboard Page");
		
	}
	
	
	
   
}

@Then("User clicks on Admin menu")
public void user_clicks_on_admin_menu() {
	adminPage.clickOnAdminMenu();
  
}

@When("User enters valid Username {string}")
public void user_enters_valid_username(String username) {
	adminPage.enterUsername(username);
}

@When("Enter valid User Role")
public void enter_valid_user_role() {
   adminPage.SearchUserRole();
}

@When("Search User Name")
public void search_user_name() {
	adminPage.selectUserFromAutoSuggestion("perf user test");
}

@When("Enter User Status")
public void enter_user_status() throws InterruptedException {
	adminPage.selectStatus("Enabled");
    
}


@When("User clicks on Search button")
public void user_clicks_on_search_button() {
	adminPage.serachButton();
    
}

@Then("User should see matching user record")
public void user_should_see_matching_user_record() {
	
	 Assert.assertTrue(
	            adminPage.isUserRecordDisplayed(),
	            "Matching user record is NOT displayed"
	    );
	
 //invalid usernmae 
}

@When("User enters invalid Username {string}")
public void user_enters_invalid_username(String username) {
	
	adminPage.enterUsername(username);
	
	
   
}

@Then("No Records Found message should be displayed")
public void no_records_found_message_should_be_displayed() {
	adminPage.userNotFound();
	

}
//ivalid user role

@When("Enter in-valid User Role")
public void enter_in_valid_user_role() {
  adminPage.InvalidUserRole();
}

}
