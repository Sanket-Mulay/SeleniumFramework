package stepdefination;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.pages.DashboardPage;
import com.pages.EmployeesOnLeaveConfigPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeeOnLeaveConfiguration{
 
	
	
	
	

	private EmployeesOnLeaveConfigPage employeesOnLeaveConfigPage=new EmployeesOnLeaveConfigPage(DriverFactory.getDriver());
	private DashboardPage dashboardPage=new DashboardPage(DriverFactory.getDriver());
	 private WebDriver driver;
	


@Given("User launches the OrangeHRM application")
public void user_launches_the_orange_hrm_application() {
	 driver = DriverFactory.getDriver();       // ✅ get driver after browser launch
	 employeesOnLeaveConfigPage = new EmployeesOnLeaveConfigPage(driver); 
	 dashboardPage =new DashboardPage(driver);
	DriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	// 3. Initialize Page Objects

	dashboardPage = new DashboardPage(driver);
	
	employeesOnLeaveConfigPage = new EmployeesOnLeaveConfigPage(driver);

    // 4. Perform login
	dashboardPage.login("Admin", "admin123");// replace with valid credentials
}

	
	
  
@Given("User is navigated to Dashboard page")
public void user_is_navigated_to_dashboard_page() {
	Assert.assertTrue(employeesOnLeaveConfigPage.dashboardtitle()," dashboard page not visible");
	
	
  
}
@When("User clicks on Employees on Leave Today settings icon")
public void user_clicks_on_employees_on_leave_today_settings_icon() {
	employeesOnLeaveConfigPage.clickSettingsIcon();
}
@Then("Configuration popup should be displayed")
public void configuration_popup_should_be_displayed() {
	employeesOnLeaveConfigPage.isPopupDisplayed();
}
@Then("Popup title should be {string}")
public void popup_title_should_be(String string) {
	 String actualTitle = employeesOnLeaveConfigPage.getPopupTitle();
     Assert.assertEquals(
             actualTitle,

             "Popup title mismatch"
     );
}
@Then("Toggle option {string} should be visible")
public void toggle_option_should_be_visible(String string) {
	 Assert.assertTrue(
             employeesOnLeaveConfigPage.isToggleVisible(),
             "Toggle option not visible"
     );
	
}

//


@When("User enables the accessible employees toggle")
public void user_enables_the_accessible_employees_toggle() {
	
	employeesOnLeaveConfigPage.enableAccessibleEmployeesToggle();
	
 
}
@When("User clicks on Save button")
public void user_clicks_on_save_button() {
	employeesOnLeaveConfigPage.isSaveButton();
	
 
}
@Then("Configuration popup should be closed")
public void configuration_popup_should_be_closed() {
	employeesOnLeaveConfigPage.ispopupClosed();
  
}
@Then("Success message should be displayed")
public void success_message_should_be_displayed() {
	Assert.assertTrue(employeesOnLeaveConfigPage.isSuccess(),"this is success message can't found");
	
	
	
	
 
}


}
