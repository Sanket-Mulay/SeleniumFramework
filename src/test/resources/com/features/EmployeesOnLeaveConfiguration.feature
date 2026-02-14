@LeaveConfiguration
Feature: Employees on Leave Today Configuration

  As an Admin user
  I want to configure the visibility of employees on leave
  So that I can control accessible employee leave data

  Background:
    Given User launches the OrangeHRM application
    And User is navigated to Dashboard page

 
  Scenario: Verify Employees on Leave Today configuration popup opens successfully
    When User clicks on Employees on Leave Today settings icon
    Then Configuration popup should be displayed
    And Toggle option "Only show accessible employees on leave for other users" should be visible
    

  Scenario: Verify Employees on Leave Today configuration popup opens and closes successfully
    When User clicks on Employees on Leave Today settings icon
    Then Configuration popup should be displayed
    And Toggle option "Only show accessible employees on leave for other users" should be visible
    When User clicks on the close icon on the popup
    Then Configuration popup should close successfully
    And User should remain on the Dashboard page
    
    
      @Regression 
  Scenario: Verify user can enable accessible employees toggle and save
    When User clicks on Employees on Leave Today settings icon
    And User enables the accessible employees toggle
    And User clicks on Save button
    Then Configuration popup should be closed
    And Success message should be displayed
    
        
   
  Scenario:  Verify user can save configuration without selecting toggle statee
    When User clicks on Employees on Leave Today settings icon
    Then Configuration popup should be displayed
    And User clicks on Save buttons
    Then Configuration popup should be closed
    And Success message should be displayed
    
    @smoke
  Scenario:  Verify user can cancel configuration without selecting toggle statee
    When User clicks on Employees on Leave Today settings icon
    Then Configuration popup should be displayed
    And User clicks on cancel button
    Then Configuration popup should be closed


    
    
    
    
    
    