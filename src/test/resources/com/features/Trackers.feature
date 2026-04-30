@trackers
Feature: Trackers page feature

Background:
  Given User is logged into the application
   When User clicks on Performance tab
    And User clicks on Configure Dropdwon
    And User clicks on Tracekrs options
     When User clicks on Employee Name text field

@smoke @Skip
  Scenario: Verify Tracekrs page is displayed after clicking on Trackers opations
    Then Trackers page should be displayed successfully
    
    
    @smoke @Skip
   Scenario: Verify search with valid Employee Name on Trackers page
  And User searches for a valid Employee Name
  And User clicks on Search button
  Then Searched user should be visible on Trackers page
  
     
     @smoke @Skip
   Scenario: Verify search with in-valid Employee Name on Trackers page
  And User searches for a in-valid Employee Name
  And User clicks on Search button
  Then Seacrhed a not found this Trackers page
  
  
 @sanity @Skip
    Scenario: Verify search empty  Employee Name on Trackers page
  And User clicks on Search button
  Then Seacrhed a not found this Trackers page
  
  @regression
    Scenario: Verify search empty and tab pn reset button Employee Name on Trackers page
  And User clicks on Reset button
  Then Seacrhed a not found this Trackers page
  
  
  
  
  
  
  
  
  
  
    
    
    