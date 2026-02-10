Feature: Alarm Functionality


  Background:
    Given user is logged into the application
    When user clicks on Alarm

  Scenario: Open Alarm Page
    Then Alarm page should open successfully
   
     
   
  Scenario: Punch In Successfully
    Given user is on the Punch In page
    When user enters the Date "2026-01-15" and Time "09:30 AM"
    And user enters a note "Arrived on time"
    And user clicks the In button
    Then the punch in should be recorded successfully	
    

    
    
    
    
   
    
    
    
    
    
