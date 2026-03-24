@Trackers
Feature: Trackers page feature

Background:
  Given User is logged into the application
   When User clicks on Performance tab
    And User clicks on Configure Dropdwon
    And User clicks on Tracekrs options
     When User clicks on Employee Name text field


  Scenario: Verify Tracekrs page is displayed after clicking on Trackers opations
    Then Trackers page should be displayed successfully
    
    
    
   Scenario: Verify search with valid Employee Name on Trackers page
  And User searches for a valid Employee Name
  And User clicks on Search button
  Then Searched user should be visible on Trackers page
  
     
 
   Scenario: Verify search with in-valid Employee Name on Trackers page
  And User searches for a in-valid Employee Name
  And User clicks on Search button
  Then Seacrhed a not found this Trackers page
  
  
     @TrackersScenario
    Scenario: Verify search empty  Employee Name on Trackers page
  And User clicks on Search button
  Then Seacrhed a not found this Trackers page
  
  
  
  
  
  
  
  
    
    
    