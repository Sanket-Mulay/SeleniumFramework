package stepdefination;

import com.pages.LoginPage;
import com.pages.PunchInOutPage;
import com.qa.factory.DriverFactory;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.pages.DashboardPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DashboardPageStep extends BaseClass{
	
	private DashboardPage alarmPage=new DashboardPage(DriverFactory.getDriver());
	private DashboardPage dashboardPage=new DashboardPage(DriverFactory.getDriver());
	 private WebDriver driver;
	

	@Given("user is logged into the application")
	public void user_is_logged_into_the_application() {
		 driver = DriverFactory.getDriver();       // ✅ get driver after browser launch
		 alarmPage = new DashboardPage(driver); 
		DriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		// 3. Initialize Page Objects
  
        alarmPage = new DashboardPage(driver);

        // 4. Perform login
        alarmPage.login("Admin", "admin123");// replace with valid credentials
	}


@When("user lands on the Dashboard page")
public void user_lands_on_the_dashboard_page() {
   
}
@Then("Dashboard should be displayed successfully")
public void dashboard_should_be_displayed_successfully() {
	 Assert.assertTrue(
             dashboardPage.isDashboardDisplayed(),
             "Dashboard page is NOT displayed"
     );
}
@Then("Dashboard title should be visible")
public void dashboard_title_should_be_visible() {
	   Assert.assertTrue(
               dashboardPage.isDashboardTitleVisible(),
               "Dashboard title is NOT visible"
       );
}
}
