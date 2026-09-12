package stepdefination;

import com.pages.AdminPage;
import com.pages.SearchPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchStepdefination {
	
	 public SearchPage Searchpage;

	    public SearchStepdefination() {
	        Searchpage = new SearchPage(DriverFactory.getDriver());
	    }


@When("user enters {string} in the Search box")
public void user_enters_in_the_search_box(String name) {
	Searchpage.Search_Value(name);
	
   
}

@Then("{string} menu should be displayed in the search results")
public void menu_should_be_displayed_in_the_search_results(String name) {
	Searchpage.Verify_Suggested_Search_Result(name);
   
}

@When("user clicks on {string} from the search results")
public void user_clicks_on_from_the_search_results(String string) {
	Searchpage.Search_Result_click();
   
}

@Then("Admin page should be displayed")
public void admin_page_should_be_displayed() {
	Searchpage.Admin_Page_Verifiyed();
    
}

	
}
