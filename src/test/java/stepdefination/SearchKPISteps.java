package stepdefination;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.pages.DashboardPage;
import com.pages.EmployeesOnLeaveConfigPage;
import com.pages.SearchKPIsDataPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchKPISteps {

//	private	SearchKPIsDataPage searchKPIsDataPage=new SearchKPIsDataPage(DriverFactory.getDriver());
	//private DashboardPage dashboardPage=new DashboardPage(DriverFactory.getDriver());
	 private WebDriver driver;
	 private DashboardPage dashboardPage;
	 private SearchKPIsDataPage searchKPIsDataPage;
	
	
	
	
	@Given("User is logged into the application")
	public void user_is_logged_into_the_application() {
		 driver = DriverFactory.getDriver();       // ✅ get driver after browser launch
		 searchKPIsDataPage = new SearchKPIsDataPage(driver); 
		 dashboardPage =new DashboardPage(driver);
		DriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		// 3. Initialize Page Objects

		dashboardPage = new DashboardPage(driver);
		
		searchKPIsDataPage = new SearchKPIsDataPage(driver);

	    // 4. Perform login
		dashboardPage.login("Admin", "admin123");// replace with valid credentials
	}

	
	@When("User clicks on Performance tab")
	public void user_clicks_on_performance_tab() {
		searchKPIsDataPage.performance();
	  
	}
	@When("User clicks on Configure Dropdwon")
	public void user_clicks_on_configure_dropdwon() {
		searchKPIsDataPage.tabOnConfigureDropdwon();
	  
	}
	@When("User clicks on KPIs options")
	public void user_clicks_on_kp_is_options() {
		searchKPIsDataPage.tabONKPISOptions();
	}
	

@Then("KPI page should be displayed successfully")
public void kpi_page_should_be_displayed_successfully() {
	Assert.assertTrue(searchKPIsDataPage.KPIPageShouldDisplayed(), "Page displayed");
	
}

//performance indicator button close/opne scenario
@When("Tab on close Performance Title Button")
public void tab_on_close_performance_title_button() throws InterruptedException {
	searchKPIsDataPage.tabONCloseIndicator();
  
}
@When("Tab on open Performance Title Button")
public void tab_on_open_performance_title_button() throws InterruptedException {
	searchKPIsDataPage.tabONOpenIndicator();
	
}
@Then("Shoud be displyed Job Title WebElements")
public void shoud_be_displyed_job_title_web_elements() {
	Assert.assertTrue(searchKPIsDataPage.DisplayedTitle(), "Title displayed");


}

//search valid job title
@When("Entered valid job title")
public void entered_valid_job_title() {
	searchKPIsDataPage.serachJobTitle("QA Lead");
   
}


@When("click on search button")
public void click_on_search_button() {
	searchKPIsDataPage.searchButton();
}
@Then("Should be displyed list of Records")
public void should_be_showing_a() {
	searchKPIsDataPage.recordFound();
  
    
	
   
}


@Then("Should be displyed all records of Records")
public void should_be_displyed_all_records_of_records() {
	 if(searchKPIsDataPage.allrecordFound()) {
	        System.out.println("All records are displayed");
	 
	    }
}


//without selected job title tab on reset button 

@When("click on reset button")
public void click_on_reset_button() {
	searchKPIsDataPage.clickONResetbutton();
	
   
}
@Then("Should be working reset button")
public void should_be_working_reset_button() {
	 if(searchKPIsDataPage.allrecordFound()) {
	        System.out.println("All records are displayed");
	 
	    }
	
}
}