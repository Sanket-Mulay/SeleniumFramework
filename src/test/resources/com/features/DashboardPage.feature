Feature: Dashboard Page Verification

  Background:
    Given user is logged into the application

  Scenario: Verify Dashboard page is opened successfully
    When user lands on the Dashboard page
    Then Dashboard should be displayed successfully
    And Dashboard title should be visible
