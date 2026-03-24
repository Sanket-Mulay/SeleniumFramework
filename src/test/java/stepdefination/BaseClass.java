package stepdefination;

import org.openqa.selenium.WebDriver;

import com.pages.AdminPage;
import com.pages.DashboardPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

public class BaseClass {
	
	//here use the encapsulation 
	
	private static String title;
	WebDriver driver;
	private DashboardPage alarmPage=new DashboardPage(DriverFactory.getDriver());
	private LoginPage loginPage=new LoginPage(DriverFactory.getDriver());
	
	private AdminPage adminPage=new AdminPage(DriverFactory.getDriver());
	
	

}
