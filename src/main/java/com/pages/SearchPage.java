package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
	
	WebDriver driver;
	private WebDriverWait wait;

    // Constructor
    public SearchPage(WebDriver driver) {
    	 this.driver = driver;
    	    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    	    PageFactory.initElements(driver, this);
    	}

	// login page
		
    
    		@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement SeachInputFromSearchBAR;
    		
    		
    		@FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name']")
    		WebElement Verify_Search_Suggestion;
    		
    		
    		@FindBy(xpath = "//h6[text()='Admin']")
    		WebElement Admin_Page_WebElement;
    		
    		
    		
    		
    		public void Search_Value(String name) {
    			 wait.until(ExpectedConditions.elementToBeClickable(SeachInputFromSearchBAR));
    			 SeachInputFromSearchBAR.sendKeys(name); 
    			 			
    		}
    		
    		
    		public void Verify_Suggested_Search_Result(String name)
    		{

    		    boolean Search_Result = Verify_Search_Suggestion.isDisplayed();

    		    if (Search_Result) {
    		        System.out.println("Search suggestion is displayed successfully");
    		    } else {
    		        System.out.println("Search suggestion is NOT displayed");
    		    }
    		}
    		
    		
    		public void Search_Result_click() {
    			 wait.until(ExpectedConditions.elementToBeClickable(Verify_Search_Suggestion));
    			 Verify_Search_Suggestion.click();
    			 			
    			
    		}
    		
    		
    		
    		public void Admin_Page_Verifiyed() {
    			 wait.until(ExpectedConditions.elementToBeClickable(Admin_Page_WebElement));
    			boolean Admin_text= Admin_Page_WebElement.isDisplayed();
    			if (Admin_text) {
    		        System.out.println("Admin Page Text is displayed successfully");
    		    } else {
    		        System.out.println("Admin Page Text is NOT displayed");
    		    }
    		}
    			
    			
    

    		
}
