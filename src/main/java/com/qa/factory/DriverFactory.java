package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	//we can use a polymorphism is here 
	
	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<>();
	
	//parallal browser working.! one time multiple browser runs 
	public WebDriver init_driver(String browser) {
		System.out.println("browser value is:"+browser);
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		}
		else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		}
		else if(browser.equals("safari")) {
			WebDriverManager.safaridriver().setup();
			tlDriver.set(new SafariDriver());
		}else {
			System.out.println("Please pass the corretc browser value:"+browser);
		}
		
  getDriver().manage().deleteAllCookies();
  
  getDriver().manage().window();
			return getDriver();
	}
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
		
	}
	
	
	

}
