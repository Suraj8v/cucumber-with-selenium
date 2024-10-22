Feature: Login Functionality

  Scenario Outline: Successful login with valid credentials
    Given the user is on the login page
    When the user enters valid "<username>" and "<password>"
    And clicks on the login button
    Then the user should be navigated to the dashboard
    And clicks on the PLM button and Add employee button
    When the user fills out the form with the following details
      | first_name | middle_name | last_name | employee_id | username    | password   | confirm_password |
      | John       | A.          | Doe       | 431202      | jdo226   | J0hnDoe!   | J0hnDoe!        |
      | Jane       | B.          | Smith     | 451202   | jsmith226     | Jan3Smith  | Jan3Smith       |
      | Michael    | C.          | Johnson    | 751202      | mjoh226    | M1keJ0hn!  | M1keJ0hn!       |
     And search all users
      | employee_id |
      | 431202      | 
      | 451202     | 
      | 751202       |
  #    Then check the employee
    Examples:
      | username | password |
#      | ram      | ram1     |
      | Admin    | admin123 |

#  TC_01_AddEmployee_E2E
#  This TC verfies the End to End Addition/Validation/Deletion of Employee, functionality of the Application.
#
#  Login into the Application
#  Add Employee
#  Validate if the newly added employee name present in the Employee list or not.
#  Delete the Employee and Check the Success Message.

