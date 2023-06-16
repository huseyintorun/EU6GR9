@logout
Feature: logout functionality
  // I added some comments
  // I add new comments 2
  // I added new comments 3


  Background: the user logged in
    Given the user is on the loginpage
@TRN-1033
  Scenario Outline: "User" can log out by using log out button inside profile info and ends up in login page
    Given "<userType>" logged in successfully
    When the "<userType>" click on the logout button
    And the "<userType>" landed in login page
    Examples:
      | userType     |
      | driver       |
      | salesManager |
      | storeManager |
@TRN-1034
  Scenario Outline: "user" can not go to the home page again by clicking the step back button
                      after successfully logged out
    Given "<userType>" logged in successfully
    When the "<userType>" click on the logout button
    Then the "<userType>" can log out successfully
    And the "<userType>" can not go to the home page again by clicking the step back button
    Examples:
      | userType     |
      | driver       |
      | salesManager |
      | storeManager |

@TRN-1035
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


