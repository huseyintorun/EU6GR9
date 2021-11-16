Feature: logout functionality

  Background: the user logged in
    Given the user is on the loginpage

  Scenario Outline: "User" can log out by using log out button inside profile info and ends up in login page
    Given "<userType>" logged in successfully
    When the "<userType>" click on the logout button
    Then the "<userType>" can log out successfully
    Examples:
      | userType     |
      | driver       |
      | salesManager |
      | storeManager |

  Scenario Outline: "user" can not go to the home page again by clicking the step back button
                      after successfully logged out
    Given "<userType>" logged in successfully
    When the "<userType>" click on the logout button
    Then the "<userType>" can log out successfully
    And the "<userType>" can not go to the home page agin by clicking the step back button
    Examples:
      | userType     |
      | driver       |
      | salesManager |
      | storeManager |


  Scenario Outline: "user" must be logged out if the user close the open tab
  (all tabs if there are multiple open tabs)
    Given "<userType>" logged in successfully
    When the "<userType>" close the tab
    Then the "<userType>" can not be still logged in
    Examples:
      | userType     |
      | driver       |
      | salesManager |
      | storeManager |


