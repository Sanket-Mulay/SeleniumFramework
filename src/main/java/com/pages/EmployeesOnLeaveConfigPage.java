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
    @FindBy(xpath ="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[5]/div/div[1]/div/p")
    WebElement popupCLoseSuccessfully;
    
    

//close popup button
    
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[5]/div[2]/div/div/div/button")
    WebElement isCloseButton;

    @FindBy(xpath = "//label[contains(.,'Only show accessible employees on leave for other users')]")
    WebElement toggleLabel;
    
    //enabled tongle
    @FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[5]/div[2]/div/div/div/form/div[1]/div/div[2]/div/label/span")
    WebElement toggleButton;
    
    @FindBy(xpath="//button[@type='submit']")
    WebElement saveButton;
    
    @FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[5]/div[2]/div/div/div/form/div[2]/button[2]")
    WebElement saveButtonss;
    
    
    
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

    public boolean DashboardPavetitle() {
    	  wait.until(ExpectedConditions.visibilityOf(dashboardTitle));
    	    return dashboardTitle.isDisplayed();
    }
    

    public void closebutton() {
    	
    	wait.until(ExpectedConditions.visibilityOf(isCloseButton));
    	isCloseButton.click();
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
        
    	
    	}
    
    
    public void isSaveButton() {
    	wait.until(ExpectedConditions.visibilityOf(saveButton));
    	saveButton.click();
    	
    }

    
    public boolean ispopupClosed() {
    	 wait.until(ExpectedConditions.visibilityOf(dashboardTitle));
     	return successMessage.isDisplayed();
    	
      }
    
    
    public boolean isclosesucccessfullyPopup() {
   	 wait.until(ExpectedConditions.visibilityOf(popupCLoseSuccessfully));
    	return popupCLoseSuccessfully.isDisplayed();
    	
    }
    
    public boolean isSuccess() {
    	 wait.until(ExpectedConditions.visibilityOf(successMessage));
    	return successMessage.isDisplayed();

    	
    }
    
    
    public void isTabOnSaveButton() {
    	
    	wait.until(ExpectedConditions.visibilityOf(saveButtonss));
    	saveButtonss.click();
    }
    	
    }
    