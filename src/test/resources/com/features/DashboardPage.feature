@Dashboard
Feature: Dashboard Page Verification

  Background:
    Given user is logged into the application

  Scenario: Verify Dashboard page is opened successfully
    When user lands on the Dashboard page
    Then Dashboard should be displayed successfully
    And Dashboard title should be visible
    
    
    
    
 Scenario: Verify user can scroll down and up on Dashboard page
    When user scrolls down the Dashboard page
    And user scrolls up the Dashboard page
    Then Dashboard page should remain visible
    
   
    
    
    
    
    
