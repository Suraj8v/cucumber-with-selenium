Feature: Login Functionality

  Scenario Outline: Successful login with valid credentials
    Given the user is on the login page
    When the user enters valid "<username>" and "<password>"
    And clicks on the login button
    Then the user should be navigated to the dashboard
    And clicks on the PLM button and Add employee button
    When the user fills out the form with the following details
      | first_name | middle_name | last_name | employee_id | username    | password   | confirm_password |
      | John       | A.          | Doe       | 12345       | jdoeadoe    | J0hnDoe!   | J0hnDoe!        |
      | Jane       | B.          | Smith     | 12346       | jsmith      | Jan3Smith  | Jan3Smith       |
      | Michael    | C.          | Johnson    | 12347       | mjohnson    | M1keJ0hn!  | M1keJ0hn!       |
      | Emily      | D.          | Brown     | 12348       | ebrown      | Em!ly2023   | Em!ly2023       |
      | Robert     | E.          | Davis      | 12349       | rdavis      | R0bert123!  | R0bert123!      |
      | Lisa       | F.          | Miller     | 12350       | lmiller     | L1s@Miller  | L1s@Miller      |
      | David      | G.          | Wilson     | 12351       | dwilson     | Dav!d456    | Dav!d456        |
      | Sarah      | H.          | Garcia     | 12352       | sgarcia     | S4rahG!@    | S4rahG!@        |
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
#  Delete the Employee and Check the Success Message.\