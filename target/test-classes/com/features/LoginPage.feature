@Login
Feature: Login page feature


  Background:
  Given user is on login page
@sanity
Scenario: Login page title
  When user gets the title of the page
  Then page title should be "OrangeHRM"

@smoke
Scenario: Login with correct credentials
  When user enters username "Admin"
  And user enters password "admin123"
  And user clicks on Login button
  Then user gets the title of the home page
  And page title should be "OrangeHRM"
@smoke
Scenario: Scroll down and up on Dashboard page
  When user enters username "Admin"
  And user enters password "admin123"
  And user clicks on Login button
  And User scrolls down the dashboard page
  And User scrolls up the dashboard page
  Then Dashboard page should be visible properly
  
  @regression 
  Scenario: Refresh the dashboard page
   When user enters username "Admin"
   And user enters password "admin123"
   And user clicks on Login button
   And Refersh the dashboard page
   Then Dashboard page should be visible properly
  
  
  Scenario Outline: Login with multiple different credentials
    When user enters username "<username>"
    And user enters password "<password>"
    And user clicks on Login button
    And user should see "<result>"

Examples:
  | username | password   | result            |
  | Admin    | admin123   |https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index |
  | Admin    | wrong123   | Invalid credentials |
  | Wrong    | admin123   | Invalid credentials |
  | Wrong    | wrong123   | Invalid credentials |
  


  Scenario Outline: Validate login with empty username and/or password
    Given user is on login page
    When user enters username "<username>"
    And user enters password "<password>"
    And user clicks on Login button
    Then user should see required error message "<errorMessage>"

    Examples:
      | username | password | errorMessage |
      |          |          | Required     |
      | Admin    |          | Required     |
      |          | admin123 | Required     |
      
      
      
      
      
      
      


  
 