Feature: User Search Functionality

  Background:
    Given User is on Login page
    When User enters valid username and password
    Then User should be logged in successfully
    And User clicks on Admin menu

  @HighPriorit
  Scenario: Search user by valid credentials
    When User enters valid Username "Admin"
    And Enter valid User Role
    And Search User Name
    And Enter User Status
    And User clicks on Search button
    Then User should see matching user record
    
    
  @SearchByInvalidUsername
  Scenario: Search user by invalid Username
    When User enters invalid Username "InvalidUser123"
    And Enter valid User Role
    And Search User Name
    And Enter User Status
    And User clicks on Search button
    Then No Records Found message should be displayed
    
      @SearchByInvalidRole
  Scenario: Search user by invalid User Role 
    When User enters valid Username "Admin"
    And Enter in-valid User Role
    And Search User Name
    And Enter User Status
    And User clicks on Search button
    Then No Records Found message should be displayed

    