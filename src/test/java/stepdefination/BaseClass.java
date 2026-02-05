package stepdefination;

import org.openqa.selenium.WebDriver;

import com.pages.AdminPage;
import com.pages.AlarmPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

public class BaseClass {
	
	private static String title;
	WebDriver driver;
	private AlarmPage alarmPage=new AlarmPage(DriverFactory.getDriver());
	private LoginPage loginPage=new LoginPage(DriverFactory.getDriver());
	
	private AdminPage adminPage=new AdminPage(DriverFactory.getDriver());
	

}
