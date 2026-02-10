package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

	private WebDriverWait wait;
	private WebDriver driver;
	
	// 1.by locators
		private By emailid = By.name("username"); // username input
		private By password = By.name("password"); // password input
		private By signInButton = By.cssSelector("button.orangehrm-login-button"); // login but
	
		
		 // Dashboard locators
	    private By dashboardHeader = By.xpath("//h6[text()='Dashboard']");
	    private By dashboardTitle = By.xpath("//span[text()='Dashboard']");
		

	//2. Constructors of the page class
	public DashboardPage(WebDriver driver) {
		  this.wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // ✅ VERY IMPORTANT
		this.driver=driver;
	}
	
	
	  // Verify Dashboard page loaded
    public boolean isDashboardDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardHeader)).isDisplayed();
    }

    // Verify Dashboard title
    public boolean isDashboardTitleVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardTitle)).isDisplayed();
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


	


