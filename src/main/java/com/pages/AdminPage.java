package com.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;




public class AdminPage {

	WebDriver driver;
	private WebDriverWait wait;

    // Constructor
    public AdminPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // ✅ FIX
    }

	// login page
		private By emailid = By.name("username"); // username input
		private By password = By.name("password"); // password input
		private By signInButton = By.cssSelector("button.orangehrm-login-button"); // login but
		
		
		private By loginContainer =
			    By.cssSelector("div.orangehrm-login-container");
		
		// Locators 
    By adminMenu = By.xpath("//span[normalize-space()='Admin']");
    
 // ✅ Username search field
    By usernameField = By.xpath("//label[normalize-space()='Username']/following::input[1]");
    
    //Role Dropdown
    private By userRoleDropdown =
            By.xpath("//label[text()='User Role']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text-input')]");
//Admin option
    private By adminRoleOption =
            By.xpath("//div[@role='option']//span[text()='Admin']");
 // ESS option
    private By essRoleOption =
            By.xpath("//div[@role='option']//span[normalize-space()='ESS']");
    
    private  By searchUserRole = By.xpath("//div[@class='oxd-select-text-input' and normalize-space()='-- Select --']\n");
    private By userNameInput = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div/input");



    // Dynamic suggestion
       private By userSuggestion(String name) {
           return By.xpath("//div[@role='option']//span[contains(text(),'" + name + "')]");
       }
       
       
    // Status dropdown
    private By statusDropdown =
            By.xpath("//label[normalize-space()='Status']/following::div[contains(@class,'oxd-select-text')][1]");

    private By dropdownOption(String option) {
        return By.xpath("//div[@role='option']//span[normalize-space()='" + option + "']");
    }
    
    //Search button
private By searchButton=By.xpath("//button[contains(@type,'submit')]");


//Assertion mes
private By searchResultRow =
By.xpath("//div[@class='oxd-table-body']//div[@role='row']");

private By noRecordsFound =
By.xpath("//span[normalize-space()='No Records Found']");


private By norecordmess=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span");




    
    // Actions / Methods

    public void clickOnAdminMenu() {   
    	    WebElement AlarmButtonTabON = wait.until(ExpectedConditions.visibilityOfElementLocated(adminMenu));
    		  AlarmButtonTabON.click();
       
    }

    public void enterUsername(String usernmme) {
    	
    	WebElement username = wait.until(
    	        ExpectedConditions.elementToBeClickable(usernameField)
    	    );
    	username.click();
    	    username.clear();
    	    username.sendKeys(usernmme);
    	

     
    }

    public void SearchUserRole() {
    	// Click dropdown
        WebElement dropdown = wait.until(
                ExpectedConditions.elementToBeClickable(userRoleDropdown)
        );
        dropdown.click();

        // Select Admin role
        WebElement adminOption = wait.until(
                ExpectedConditions.elementToBeClickable(adminRoleOption)
        );
        adminOption.click();
    	
    }

    public void selectUserFromAutoSuggestion(String userName) {

        WebElement input = wait.until(
                ExpectedConditions.visibilityOfElementLocated(userNameInput)
        );
        input.clear();
        input.sendKeys(userName);

        WebElement suggestion = wait.until(
                ExpectedConditions.elementToBeClickable(userSuggestion(userName))
        );
        suggestion.click();
        
    }

    
     
    public void selectStatus(String status) throws InterruptedException {
        // 1️⃣ Focus move using TAB
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).perform();

        // 2️⃣ Wait & click Status dropdown
        WebElement dropdown = wait.until(
                ExpectedConditions.elementToBeClickable(statusDropdown)
        );
        dropdown.click();

        // 3️⃣ Wait & select option (Enabled / Disabled)
        WebElement option = wait.until(
                ExpectedConditions.elementToBeClickable(dropdownOption(status))
        );
        option.click();
    }
    

     
  public void serachButton() {
	   WebElement AlarmButtonTabON = wait.until(ExpectedConditions.visibilityOfElementLocated(searchButton));
		  AlarmButtonTabON.click();
	  
  }

  
  
  public boolean isUserRecordDisplayed() {
	    return wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultRow))
	               .isDisplayed();
	}
    
    
  
  //invalid username entred
  
  public void invalid_usernmae(String usernamm) {

  	WebElement username = wait.until(
  	        ExpectedConditions.elementToBeClickable(usernameField)
  	    );
  	username.click();
  	    username.clear();
  	    username.sendKeys(usernamm);
  	

   
 
  }
  

  
  //username invalid message shown
  
  public void userNotFound() {
	  WebElement noRecordMsg = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(noRecordsFound)
		);

		String actualText = noRecordMsg.getText().trim();

		// ✅ Validate message manually
		if (!"No Records Found".equals(actualText)) {
		    throw new RuntimeException(
		        "Expected 'No Records Found' message but found: " + actualText
		    );
		}

		// ✅ Validate table has no rows
		List<WebElement> rows = driver.findElements(
		        By.cssSelector(".oxd-table-body .oxd-table-row")
		);

		if (!rows.isEmpty()) {
		    throw new RuntimeException(
		        "User records are still displayed in table. Row count: " + rows.size()
		    );
		}
		
		}



public void login(String username, String passwordd) {
	 WebElement userField =
		        wait.until(ExpectedConditions.visibilityOfElementLocated(emailid));
		    userField.sendKeys(username);

		    WebElement passField =
		        wait.until(ExpectedConditions.visibilityOfElementLocated(password));
		    passField.sendKeys(passwordd);

		    WebElement loginBtn =
		        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
		    loginBtn.click();
		}


//invalid userrole


public void InvalidUserRole() {
	// Click dropdown
    WebElement dropdown = wait.until(
            ExpectedConditions.elementToBeClickable(userRoleDropdown)
    );
    dropdown.click();

    // Select Admin role
    WebElement adminOption = wait.until(
            ExpectedConditions.elementToBeClickable(essRoleOption)
    );
    adminOption.click();
	
}
}


	


