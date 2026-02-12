Feature: Employees on Leave Today Configuration

  As an Admin user
  I want to configure the visibility of employees on leave
  So that I can control accessible employee leave data

  Background:
    Given User launches the OrangeHRM application
    And User is navigated to Dashboard page

  @Smoke @Dashboard
  Scenario: Verify Employees on Leave Today configuration popup opens successfully
    When User clicks on Employees on Leave Today settings icon
    Then Configuration popup should be displayed
    And Toggle option "Only show accessible employees on leave for other users" should be visible
    
      @Regression @Dashboard
  Scenario: Verify user can enable accessible employees toggle and save
    When User clicks on Employees on Leave Today settings icon
    And User enables the accessible employees toggle
    And User clicks on Save button
    Then Configuration popup should be closed
    And Success message should be displayed
    
    
    