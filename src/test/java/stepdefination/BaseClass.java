package stepdefination;

import org.openqa.selenium.WebDriver;

import com.pages.AdminPage;
import com.pages.DashboardPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

public class BaseClass {
	
	//here use the encapsulation 
	
	protected static String title;
	WebDriver driver;
	protected DashboardPage alarmPage=new DashboardPage(DriverFactory.getDriver());
	protected LoginPage loginPage=new LoginPage(DriverFactory.getDriver());
	
	protected AdminPage adminPage=new AdminPage(DriverFactory.getDriver());
	
	

}
