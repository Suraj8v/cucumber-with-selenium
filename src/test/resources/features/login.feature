Feature: Login Functionality

  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user enters valid username and password
    And clicks on the login button
    Then the user should be navigated to the dashboard
    Then check the employee
