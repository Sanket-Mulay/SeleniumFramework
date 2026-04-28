package stepdefination;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.pages.DashboardPage;
import com.pages.SearchKPIsDataPage;
import com.pages.TracekrsPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TracekrsSteps extends BaseClass {

	private TracekrsPage tracekrsPage;
	 private WebDriver driver;
	

	    public TracekrsSteps() {
	        driver = DriverFactory.getDriver();
	        tracekrsPage = new TracekrsPage(driver);
	    }

    @When("User clicks on Tracekrs options")
    public void user_clicks_on_trackers_options() {
    	tracekrsPage.tracekers();
    	
    	
        
    }

    @Then("Trackers page should be displayed successfully")
    public void trackers_page_should_be_displayed_successfully() {
    	tracekrsPage.TrackersPageShouldDisplayed();
        
    }
    
    //searhced valid employee name oon trackers page
    
    // 1️⃣ Click Employee Name field
   

@When("User clicks on Employee Name text field")
public void user_clicks_on_employee_name_text_field() {
	tracekrsPage.clickEmployeeNameField();
 
}
@When("User searches for a valid Employee Name")
public void user_searches_for_a_valid_employee_name() {
	/*
	tracekrsPage.searchValidUserName("test user");
	tracekrsPage.selectUserFromSuggestion("test akhil user");
	*/
	
//	   String searchText = "test user";
//	    String suggestionName = "test akhil user";
//
//	    tracekrsPage.searchValidUserName(searchText);
//	    tracekrsPage.selectUserFromSuggestion(suggestionName);
//	
	

	   tracekrsPage.searchValidUserName("manda akhil user");
	   tracekrsPage.selectUserFromSuggestion("manda akhil user");
	
 
}


// 3️⃣ Click Search button
@When("User clicks on Search button")
public void user_clicks_on_search_button() {
	tracekrsPage.clickSearchButton();
}

@Then("Searched user should be visible on Trackers page")
public void searched_user_should_be_visible_on_trackers_page() {
	Assert.assertTrue(tracekrsPage.visibleList(),"User Found");
	
}

//invalid name search
@When("User searches for a in-valid Employee Name")
public void user_searches_for_a_in_valid_employee_name() {
	
	 tracekrsPage.searchinValidUserName("sanke akhil user");
	   tracekrsPage.selectUserFromSuggestion("sanke akhil user");
}

@Then("Seacrhed a not found this Trackers page")
public void seacrhed_a_not_found_this_trackers_page() {
	Assert.assertTrue(tracekrsPage.visibleList(),"User Found");
 
}
//reset button tab without entred data on employee name
@When("User clicks on Reset button")
public void user_clicks_on_reset_button() {
	tracekrsPage.tabonResetButton();
	
   
}
}