package com.qa.utill;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	
	 private WebDriver driver;
	    private WebDriverWait wait;

	    // Constructor
	    public WaitUtils(WebDriver driver, int timeoutInSeconds) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	    }

	    // Element visible
	    public WebElement waitForElementVisible(By locator) {
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	    }

	    // Element clickable
	    public WebElement waitForElementClickable(By locator) {
	        return wait.until(ExpectedConditions.elementToBeClickable(locator));
	    }

	    // Text present in element
	    public boolean waitForTextToBePresent(By locator, String text) {
	        return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
	    }

	    // Presence of element
	    public WebElement waitForElementPresence(By locator) {
	        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	    }
	 // Define overlay locator
	    private By overlay = By.cssSelector(".oxd-form-loader");

	    // Wait until overlay is gone
	    public void waitForOverlayToDisappear() {
	        new WebDriverWait(driver, Duration.ofSeconds(10))
	            .until(ExpectedConditions.invisibilityOfElementLocated(overlay));
	    }

	}