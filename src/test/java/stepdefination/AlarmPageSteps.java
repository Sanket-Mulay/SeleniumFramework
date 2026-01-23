package stepdefination;

import com.pages.LoginPage;
import com.pages.PunchInOutPage;
import com.qa.factory.DriverFactory;

import org.openqa.selenium.WebDriver;

import com.pages.AlarmPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AlarmPageSteps extends BaseClass{
	
	private AlarmPage alarmPage=new AlarmPage(DriverFactory.getDriver());
	private PunchInOutPage punchInPage=new PunchInOutPage(DriverFactory.getDriver());
	
	@Given("user is logged into the application")
	public void user_is_logged_into_the_application() {
		 driver = DriverFactory.getDriver();       // ✅ get driver after browser launch
		 alarmPage = new AlarmPage(driver); 
		DriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		// 3. Initialize Page Objects
  
        alarmPage = new AlarmPage(driver);

        // 4. Perform login
        alarmPage.login("Admin", "admin123");// replace with valid credentials
	}

	@When("user clicks on Alarm")
	public void user_clicks_on_alarm() {
		alarmPage.clickOnAlarm();
	}
	@Then("Alarm page should open successfully")
	public void alarm_page_should_open_successfully() {
	 // Get current URL
	    String currentUrl = driver.getCurrentUrl();
	    System.out.println(currentUrl);
	    
	  
	    // Expected URL of Alarm page
	    String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/attendance/punchIn";

	    // Validation
	    if(currentUrl.equals(expectedUrl)) {
	        System.out.println("Alarm page opened successfully ✅");
	    } else {
	        System.out.println("Alarm page did NOT open ❌");
	        System.out.println("Expected URL: " + expectedUrl);
	        System.out.println("Current URL : " + currentUrl);
	        throw new AssertionError("Alarm page did not open as expected");
	    }
	}
//Punch in 

@Given("user is on the Punch In page")
public void user_is_on_the_punch_in_page() {
	
	String Actual_URL=driver.getCurrentUrl();
	String expectd_URL="https://opensource-demo.orangehrmlive.com/web/index.php/attendance/punchIn";
	if(Actual_URL.equals(expectd_URL)) {
		System.out.println("User on Punch In Page");
	}else {
		System.out.println("User not on Punch In Page");
	}
	
	
  
}



@When("user enters the Date {string} and Time {string}")
public void user_enters_the_date_and_time(String Date, String Time) {

    WebDriver driver = DriverFactory.getDriver();   // driver already initialized
    punchInPage = new PunchInOutPage(driver);          // ✅ constructor called

    punchInPage.enterDate(Date);
    punchInPage.enterTime(Time);
}  


@When("user enters a note {string}")
public void user_enters_a_note(String Note) {
	punchInPage.enterNote(Note);
  
}

//@When("user clicks the In button")
//public void user_clicks_the_button(String string) {
//	
//	        punchInPage.clickPunchIn();
//	    }
	
	
@When("user clicks the In button")
public void user_clicks_the_in_button() {
    // Call your PunchInPage method to click the button
    punchInPage.clickPunchIn();
}



@Then("the punch in should be recorded successfully")
public void the_punch_in_should_be_recorded_successfully() {
	
	// Check if Out button is displayed
    if(punchInPage.outbutton()) {
        System.out.println("Punch In recorded successfully ✅ Out button is displayed.");
    } else {
        throw new AssertionError("Punch In NOT recorded ❌ Out button is NOT displayed.");
    }
}
	
	
   
/*
@Then("a confirmation message {string} should be displayed")
public void a_confirmation_message_should_be_displayed(String expectedMessage) {
	
	 String actualMessage = punchInPage.getPunchedInMessage();
	    if(actualMessage != null && actualMessage.contains(expectedMessage)) {
	        System.out.println("Confirmation message displayed ✅ : " + actualMessage);
	    } else {
	        throw new AssertionError("Expected message: '" + expectedMessage + "' but got: '" + actualMessage + "'");
	    }
	}
	*/

//out 

@When("user clicks the Out button")
public void user_clicks_the_out_button() {
	punchInPage.ClickOnOutButton();
    
}


  
}



	   
	



