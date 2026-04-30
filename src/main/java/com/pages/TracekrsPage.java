package com.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.utill.WaitUtils;

public class TracekrsPage {


	private WaitUtils waitUtils;  // WaitUtils object
	private WebDriverWait wait;
	private WebDriver driver;
	
	
	// 🔹 Locators

		@FindBy(xpath = "//a[text()='Trackers']")
		WebElement tabOnTracekrs;

	    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
	    WebElement employeeName;
	    

	    // 🔹 Dynamic suggestion locator
	    private By userSuggestion(String name) {
	        return By.xpath("//div[@role='listbox']//span[contains(text(),'" + name + "')]");
	    }


	    @FindBy(xpath = "//button[@type='submit']")
	    WebElement searchButton;

	    @FindBy(xpath ="//div[@role='table']")
WebElement listofUsers;
	    
	    @FindBy(xpath ="//button[contains(@type,'button')]")
	    WebElement tabonReset;
	    	    
	    
	
	

    // Constructor
    public TracekrsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
	 // 🔹 Locators

    public void tracekers() {
    	wait.until(ExpectedConditions.visibilityOf(tabOnTracekrs));
    	tabOnTracekrs.click();
    }
    

    public boolean TrackersPageShouldDisplayed() {
    String currentURL=driver.getCurrentUrl();
    String expectedURL="https://opensource-demo.orangehrmlive.com/web/index.php/performance/viewPerformanceTracker";
    if(currentURL.equals(expectedURL)) {
    	return true;
    }else {
    return false;
    	
    
    }
    }
    
    //valid employee name seatch on tracker page
 // 🔹 Click Employee Name field
    public void clickEmployeeNameField() {
        wait.until(ExpectedConditions.elementToBeClickable(employeeName));
        employeeName.click();
    }

    
    
    // 🔹 Enter Employee Name
    public void searchValidUserName(String username) {
        wait.until(ExpectedConditions.visibilityOf(employeeName));
        employeeName.clear();
        employeeName.sendKeys(username);
    }
    
    //enter incorrect username
    // 🔹 Enter Employee Name
    public void searchinValidUserName(String username) {
        wait.until(ExpectedConditions.visibilityOf(employeeName));
        employeeName.clear();
        employeeName.sendKeys(username);
    }
    

    // 🔹 Select user from suggestion dropdown
    public void selectUserFromSuggestion(String username) {

    	// Wait for Employee Name field to be visible and clear
        wait.until(ExpectedConditions.visibilityOf(employeeName));
        employeeName.clear();
        
        // Type username
        employeeName.sendKeys(username);

        // Wait for suggestion dropdown to appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='listbox']")));

        // Find first matching suggestion
        List<WebElement> suggestions = driver.findElements(
                By.xpath("//div[@role='option']//span[contains(text(),'" + username + "')]"));

        if (!suggestions.isEmpty()) {
            WebElement firstSuggestion = suggestions.get(0);
            firstSuggestion.click(); // Click the suggestion (safe)
            // OR use keyboard if needed:
            // firstSuggestion.sendKeys(Keys.TAB);
        } else {
            System.out.println("No suggestion found for: " + username);
        }
    
        
    }
    // 🔹 Click Search button
    public void clickSearchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
    }
    
    
    public void tabonSearchButton() {
    	  wait.until(ExpectedConditions.visibilityOf(searchButton));
    	  searchButton.click();
    	  
    }
    
    public boolean visibleList() {
    	  wait.until(ExpectedConditions.elementToBeClickable(listofUsers));
    	  if(listofUsers.isDisplayed()) {
    	  return true;
    	
    }else {
    	return false;
    }
    	  
}
    
    
    public void tabonResetButton() {
    	 wait.until(ExpectedConditions.elementToBeClickable(tabonReset));
    	 tabonReset.click();
    	
    }

}