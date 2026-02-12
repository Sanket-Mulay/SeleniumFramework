package com.pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmployeesOnLeaveConfigPage {

	

    WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public EmployeesOnLeaveConfigPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // 🔹 Locators

    @FindBy(xpath = "//h6[text()='Dashboard']")
    WebElement dashboardTitle;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[5]/div/div[1]/i")
    WebElement settingsIcon;
    
    
    @FindBy(xpath = "//div[contains(@class,'oxd-dialog-container')]//h6")
    WebElement popupTitle;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[5]/div[2]/div/div/div/div/div/p[2]")
    WebElement configurationPopup;
    
    

 

    @FindBy(xpath = "//label[contains(.,'Only show accessible employees on leave for other users')]")
    WebElement toggleLabel;
    
    //enabled tongle
    @FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[5]/div[2]/div/div/div/form/div[1]/div/div[2]/div/label/span")
    WebElement toggleButton;
    
    @FindBy(xpath="//button[@type='submit']")
    WebElement saveButton;
    
    @FindBy(xpath="//div[contains(@class,'oxd-toast')]\n")
    WebElement successMessage;
    
    
    
    
    

    // 🔹 Methods

    public boolean dashboardtitle() {
    	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	    
    	    // Find element fresh inside wait
    	    WebElement dashboard = wait.until(ExpectedConditions.visibilityOfElementLocated(
    	        By.xpath("//h6[text()='Dashboard']")
    	    ));
    	    
    	    return dashboard.isDisplayed();
    	
    }

    public void clickSettingsIcon() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(settingsIcon));
        settingsIcon.click();
    }

    public boolean isPopupDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(configurationPopup));
        return configurationPopup.isDisplayed();
    }

    public String getPopupTitle() {
        wait.until(ExpectedConditions.visibilityOf(popupTitle));
        return popupTitle.getText();
    }

    public boolean isToggleVisible() {
        wait.until(ExpectedConditions.visibilityOf(toggleLabel));
        return toggleLabel.isDisplayed();
    }
    
    
    public void enableAccessibleEmployeesToggle()
{
    	
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement toggle = wait.until(
            ExpectedConditions.elementToBeClickable(toggleButton)
        );

        if (!toggle.isSelected()) {
            toggle.click();
        }
        
    	/*
    	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    	    // Wait for popup to exist AND fully visible
    	    WebElement popup = wait.until(driver -> {
    	        try {
    	            WebElement dialog = driver.findElement(By.xpath("//div[@role='dialog']"));
    	            if (dialog.isDisplayed() && dialog.getCssValue("opacity").equals("1")) {
    	                return dialog;
    	            }
    	            return null; // keep waiting
    	        } catch (NoSuchElementException e) {
    	            return null; // keep waiting
    	        }
    	    });

    	    // Find the toggle specifically inside the popup
    	    WebElement toggle = wait.until(ExpectedConditions.elementToBeClickable(
    	            popup.findElement(By.cssSelector("input.oxd-switch-input"))
    	    ));

    	    // Enable toggle if not selected
    	    if (!toggle.isSelected()) {
    	        toggle.click();

    	        // Wait until the toggle is actually selected — find fresh element inside the wait
    	        wait.until(driver -> {
    	            WebElement freshToggle = popup.findElement(By.cssSelector("input.oxd-switch-input"));
    	            // Check either 'checked' attribute or 'aria-checked'
    	            return "true".equals(freshToggle.getAttribute("aria-checked")) 
    	                   || freshToggle.isSelected();
    	        });
    	    }
    	    */
    	}
    
    
    public void isSaveButton() {
    	wait.until(ExpectedConditions.visibilityOf(saveButton));
    	saveButton.click();
    	
    }

    
    public boolean ispopupClosed() {
    	  wait.until(ExpectedConditions.visibilityOf(dashboardTitle));
          return dashboardTitle.isDisplayed();
      }
    
    
    public boolean isSuccess() {
    	 wait.until(ExpectedConditions.visibilityOf(successMessage));
    	return successMessage.isDisplayed();
    	
    	
    }
    	
    }
    
