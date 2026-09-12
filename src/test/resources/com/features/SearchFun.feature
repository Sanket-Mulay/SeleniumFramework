@Search
Feature: OrangeHRM Dashboard Search functionality

  Background: 
    Given user is on login page
    When user enters username "Admin"
    And user enters password "admin123"
    And user clicks on Login button
    Then Dashboard page should be visible properly

  @smoke
  Scenario: Verify user can search Admin menu from Dashboard
    When user enters "Admin" in the Search box
    Then "Admin" menu should be displayed in the search results
    When user clicks on "Admin" from the search results
    Then Admin page should be displayed
