package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlarmPage {

	private WebDriverWait wait;
	private WebDriver driver;
	
	// 1.by locators
		private By emailid = By.name("username"); // username input
		private By password = By.name("password"); // password input
		private By signInButton = By.cssSelector("button.orangehrm-login-button"); // login but
	//click on Alarm logo
	private By AlarmClick = By.xpath("//button[@class='oxd-icon-button oxd-icon-button--solid-main orangehrm-attendance-card-action']");
	
	
	

	//2. Constructors of the page class
	public AlarmPage(WebDriver driver) {
		  this.wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // ✅ VERY IMPORTANT
		this.driver=driver;
	}
	
	

//click on Alarm 
public void clickOnAlarm() {
	  WebElement AlarmButtonTabON = wait.until(ExpectedConditions.visibilityOfElementLocated(AlarmClick));
	  AlarmButtonTabON.click();
}




public void login(String username, String passwordd) {
	// Wait for username field and get the WebElement
    WebElement userField = wait.until(ExpectedConditions.visibilityOfElementLocated(emailid));
    userField.sendKeys(username);

    // Wait for password field and get the WebElement
    WebElement passField = wait.until(ExpectedConditions.visibilityOfElementLocated(password));
    passField.sendKeys(passwordd);

    // Wait for login button and click
    WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(signInButton));
    loginBtn.click();
}

}


	


