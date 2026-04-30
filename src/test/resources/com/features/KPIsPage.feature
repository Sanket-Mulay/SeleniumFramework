@KPIs
Feature: KPI Page Navigation

Background:
  Given User is logged into the application
   When User clicks on Performance tab
    And User clicks on Configure Dropdwon
    And User clicks on KPIs options

  Scenario: Verify KPI page is displayed after clicking on KPI under Performance
    And User clicks on Configure Dropdwon
    And User clicks on KPIs options
    Then KPI page should be displayed successfully
    
    @title
    Scenario: verify Key Performance Indicators for Job Title Successfully Button 
     And Tab on close Performance Title Button
     And Tab on open Performance Title Button
     Then Shoud be displyed Job Title WebElements
     
   @Positive
Scenario: verify search valid job title 
  When Entered valid job title
  And click on search button
  Then Should be displyed list of Records
  
  
Scenario: verify search valid without search job title  
  And click on search button
  Then Should be displyed all records of Records
  
  
    
Scenario: verify reset button without search job title  
  And click on reset button
  Then Should be working reset button
  And Should be displyed all records of Records
  
  
   @negative
Scenario: verify reset button with search job title  
When Entered valid job title
  And click on reset button
  Then Should be working reset button
  And Should be displyed all records of Records
  
  
  
  
  
  
  
  
     
     
     
     
 
     
     
     
     
     
     