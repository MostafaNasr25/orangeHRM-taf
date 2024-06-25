Feature: Create , search and delete new user

  Scenario Outline: Create , search and delete new user
    Given  Admin navigate to the orangeHRM website
    When Admin login with username "<username>" and password "<password>"
    And  navigate to the Admin page
    Then get user counts
    And  click on add button
    And  enter user role "<userRole>" , employee name "<employeeName>" and status "<status>"
    And enter user name "<newUsername>", password "<userPassword>" and confirm password "<confirmPassword>"
    And click on save button
    Then validate that new user added
    Then validate user counts increased by one
    And search for new user b name "<newUsername>"
    And click on delete button and confirmation delete
    Then validate that new user deleted
    Then validate that user counts decreased by one

    Examples:
      | username | password | userRole | employeeName | status  | newUsername | userPassword | confirmPassword |
      | username | password | ESS      | Test           | Enabled | Tester3     | Test1234     | Test1234        |