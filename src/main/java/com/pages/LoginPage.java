package com.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.WebDriverWait;
public class LoginPage {
	
	private WebDriverWait wait;
	private WebDriver driver;
	
	
	// 1.by locators
	private By emailid = By.name("username"); // username input
	private By password = By.name("password"); // password input
	private By signInButton = By.cssSelector("button.orangehrm-login-button"); // login but
	private By forgetPwdLink = By.partialLinkText("kkkForgotppp");

	//error message locators 
	private By errorMessage=By.xpath("//p[text()='Invalid credentials']");
//empty message locators
	private By emptyerrormessage=By.xpath("//span[text()='Required']");
	  

	//2. Constructors of the page class
	public LoginPage(WebDriver driver) {
		  this.wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // ✅ VERY IMPORTANT
		this.driver=driver;
	}
//3. page actions: feature (behavior) of the form of methods
	public String getLoginPageTitle() {
	return driver.getTitle();		
	}
	
	 
	public boolean isForgetPwdLinkExist() {
		
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	            driver.switchTo().defaultContent();

	            List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
	            if (!iframes.isEmpty()) {
	                driver.switchTo().frame(0);
	            }

	            List<WebElement> elements =
	                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(forgetPwdLink));

	            return !elements.isEmpty() && elements.get(0).isDisplayed();

	        } catch (Exception e) {
	            System.out.println("Forgot Password link not found");
	            return false;
	        }
	    
	}
	

	public void enterUserName(String username) {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        WebElement userInput = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(emailid)
	        );
	        userInput.clear();
	        userInput.sendKeys(username);
	    }
		
	

	public void enterPassword(String pwd) {
		   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	        WebElement pwdInput = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(password)
	        );
	        pwdInput.clear();
	        pwdInput.sendKeys(pwd);
		
	}
	
	public void clickOnLogin() {
		//driver.findElement(signInButton).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement loginBtn = wait.until(
            ExpectedConditions.elementToBeClickable(signInButton)
        );
        loginBtn.click();
		
	
	}
	

	public boolean isErrorMessageDisplayed() {
	    try {
	        WebElement error = wait.until(
	                ExpectedConditions.presenceOfElementLocated(errorMessage)
	        );
	        return error.isDisplayed();
	    } catch (TimeoutException e) {
	        return false;
	    }
	}

	public String getErrorMessageText() {
	    return wait.until(
	            ExpectedConditions.visibilityOfElementLocated(errorMessage)
	    ).getText();
	}
	//Validate login with empty username and/or passwor

	public boolean isEmptyErrorMessageDisplayed() {
		try {
			WebElement EmptyError=wait.until(ExpectedConditions.presenceOfElementLocated(emptyerrormessage)
	        );
			return EmptyError.isDisplayed();
		}catch(TimeoutException e) {
			return false;
		}
	}
	
	public String getEmptyErrorMessageText() {
	    return wait.until(
	            ExpectedConditions.visibilityOfElementLocated(emptyerrormessage)
	    ).getText();
	}
	
	
	
}
