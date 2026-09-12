package com.pages;

import java.time.Duration;
import com.qa.utill.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.utill.WaitUtils;

public class PunchInOutPage {
	private WaitUtils waitUtils;  // WaitUtils object
	private WebDriverWait wait;
	private WebDriver driver;
	
	
	// 1.by locators
	//private By EnterDate = By.xpath("//input[@class=\"oxd-input oxd-input--active\"]"); // username input
	private By EnterDate = By.xpath("//label[text()='Date']/following::input[1]");


	private By EnterTime = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input"); // password input
	private By EnterNote = By.xpath("//textarea[@class=\"oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical\"]"); // login but
	private By PunchInButton = By.cssSelector("button[type='submit']");
	//punchINmessage
	private By PunchedIN=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/form/div[1]/div/div[1]/div/div[1]/label");
	
	private By OutButtonXpath=By.xpath("//button[@type=\"submit\"]");
	
	
	
	

	public PunchInOutPage(WebDriver driver) {
	    this.driver = driver;
	    this.waitUtils = new WaitUtils(driver, 10); // initialize waitUtils with 10 sec timeout
	}




	// 3. Page actions with wait

		 public void enterDate(String date) {
			 /*int attempts = 0;
			    while (attempts < 3) {
			        try {
			            WebElement dateField = waitUtils.waitForElementVisible(EnterDate);
			            dateField.click();
			            dateField.clear();
			            dateField.sendKeys(date);
			            break; // success → exit loop
			        } catch (org.openqa.selenium.StaleElementReferenceException e) {
			            attempts++;
			        }
			    }
			    */
			 
			 // Wait for login button and click

			 waitUtils.waitForOverlayToDisappear(); // ✅ wait first
	    	    WebElement dateField = waitUtils.waitForElementClickable(EnterDate);
	    	    dateField.clear();
	    	    dateField.sendKeys(date);
	    
			 
			}
		 
    public void enterTime(String time) {
    	   WebElement dateField = waitUtils.waitForElementClickable(EnterDate);
   	    dateField.clear();
   	    dateField.sendKeys(time);
    	
    }

    public void enterNote(String note) {
        WebElement noteField = waitUtils.waitForElementVisible(EnterNote); // ✅ pass locator
        noteField.clear();
        noteField.sendKeys(note); // ✅ then send the text
    }

    public void clickPunchIn() {
      ///  waitUtils.waitForElementClickable(PunchInButton).click();
      ///  // 1. Wait for overlay to disappear
    	waitUtils.waitForOverlayToDisappear();

    // 2. Wait until button is clickable
    WebElement button = waitUtils.waitForElementClickable(PunchInButton);

    // 3. Retry click to avoid stale/intercepted elements
    int attempts = 0;
    while(attempts < 3) {
        try {
            button.click();
            break;
        } catch (ElementClickInterceptedException | StaleElementReferenceException e) {
           // waitForOverlayToDisappear();
            button = waitUtils.waitForElementClickable(PunchInButton);
            attempts++;
        }
    }
    }
    
    public boolean outbutton() {
    	  try {
    	        // Wait until element is visible
    	        WebElement outBtn = new WebDriverWait(driver, Duration.ofSeconds(10))
    	            .until(ExpectedConditions.visibilityOfElementLocated(OutButtonXpath));
    	        return outBtn.isDisplayed();
    	    } catch (Exception e) {
    	        // If not found or not visible, return false
    	        return false;
    }
    }
  
  //click on Alarm 
  public void ClickOnOutButton() {
  	  WebElement AlarmButtonTabON = wait.until(ExpectedConditions.visibilityOfElementLocated(OutButtonXpath));
  	  AlarmButtonTabON.click();
  }
}