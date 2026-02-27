package com.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.utill.WaitUtils;

public class SearchKPIsDataPage {
	
	private WaitUtils waitUtils;  // WaitUtils object
	private WebDriverWait wait;
	private WebDriver driver;
	
	
	
	 // 🔹 Locators

	@FindBy(xpath = "//span[text()='Performance']")
	WebElement tabOnPerformance;
   
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[1]/span")
    WebElement configureDropdwon;
    
    @FindBy(xpath="//a[text()='KPIs']\n")
    WebElement tabKPIsOptions;
    @FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[1]/div[1]/h5")
    WebElement KPIPageText;
    
    @FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[1]/div[2]/div[3]/button/i")
    WebElement jobTitleIndicatorClose;
    
    @FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[1]/div[2]/div[3]/button")
    WebElement jobTitleIndicatorOpen;
    @FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div/div/div[1]/label")
    WebElement titleDisplyed;
    
    
    //serach job title  valid job
    @FindBy(xpath="//div[@class=\"oxd-select-text-input\"]")
    WebElement searchJobTitle;
    

    @FindBy(xpath="//div[@class=\"oxd-select-text-input\"]")
    WebElement searchButton;
    
    
    @FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]")
    WebElement recordFoundtext;
    
    
    @FindBy(xpath = "//div[@role='row']")
    List<WebElement> recordsList;
    @FindBy(xpath =("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[1]"))
    WebElement resetButton;
    
    
    // Constructor
    public SearchKPIsDataPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    
    public void performance() {
    	wait.until(ExpectedConditions.visibilityOf(tabOnPerformance));
    	tabOnPerformance.click();
    }
    
    

    public void tabOnConfigureDropdwon() {
    	wait.until(ExpectedConditions.visibilityOf(configureDropdwon));
    	configureDropdwon.click();
    }
    
    public void tabONKPISOptions() {
    	wait.until(ExpectedConditions.visibilityOf(tabKPIsOptions));
    	tabKPIsOptions.click();
    	
    }
    
    
    public boolean KPIPageShouldDisplayed() {
    	wait.until(ExpectedConditions.visibilityOf(KPIPageText));
    	return KPIPageText.isDisplayed();
    	
    
    }
    
    
    public void tabONCloseIndicator() throws InterruptedException{
    	Thread.sleep(3000);
    	wait.until(ExpectedConditions.visibilityOf(jobTitleIndicatorClose));
    	jobTitleIndicatorClose.click();
    	
    }
    
    
    public void tabONOpenIndicator() throws InterruptedException{
    	Thread.sleep(3000);
    	wait.until(ExpectedConditions.visibilityOf(jobTitleIndicatorOpen));
    	jobTitleIndicatorOpen.click();
    	
    }
    
    
    
    public boolean DisplayedTitle() {
    	wait.until(ExpectedConditions.visibilityOf( titleDisplyed));
    	return  titleDisplyed.isDisplayed();
    	
    
    }
    
    
    public void serachJobTitle(String jobTitle) {
    	  // 1️⃣ Click dropdown
        wait.until(ExpectedConditions.elementToBeClickable(searchJobTitle)).click();

        // 2️⃣ Create dynamic option locator
        By optionLocator = By.xpath("//div[@role='option']//span[text()='" + jobTitle + "']");

        // 3️⃣ Wait for option and click
        wait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
        wait.until(ExpectedConditions.elementToBeClickable(optionLocator)).click();
    	
    
    	
    }
    
   
    public boolean searchButton() {
    	wait.until(ExpectedConditions.visibilityOf(searchButton));
    	return  titleDisplyed.isDisplayed();
    	
    
    }
    
    
//    public boolean recordFound() {
//    	return recordFoundtext.isDisplayed();
//    }
//    
    public void recordFound() {
    	List<WebElement> list = driver.findElements(
    	        By.xpath("//div[@role='row']//div[text()='QA Lead']"));

    	if (list.size() > 0) {
    	    System.out.println("QA Lead record found ✅");
    	} else {
    	    System.out.println("QA Lead record NOT found ❌");
    	}
    }

    	public boolean allrecordFound() {
    	    return recordsList.size() > 0;
    	}
    	
    	
    	public void clickONResetbutton() {
    	   	wait.until(ExpectedConditions.visibilityOf(resetButton));
        	tabOnPerformance.click();
    	
    	}
    	
    	
    	
    }
    
    

