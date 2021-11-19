@login
Feature: login functionality

  Background: User login
    Given the user is on the loginpage
@TRN-1019
  Scenario Outline: All users can log in with valid credentials
    When the user logged in as "<userType>"
    Then the user should land on the "<relatedPage>"
    Examples:
      | userType     | relatedPage     |
      | driver       | Quick Launchpad |
      | salesManager | Dashboard       |
      | storeManager | Dashboard       |
@TRN-1022
  Scenario Outline: The system shouldn't allow users to login to application without providing valid credentials

    When the user logged in as "<userType>"
    Then the user logged out successfully and paste the same url to browser and try to skip authentication step
    Then the user should not be able to logged in
    Examples:
      | userType     |
      | driver       |
      | salesManager |
      | storeManager |
  @TRN-1023
  Scenario Outline: All users can see their own usernames in profile menu
    When the user logged in as "<userType>"
    Then the user see their own usernames in profile menu "<userName>"
    Examples:
      | userType     | userName |
      | driver       | John Doe |
      | salesManager | John Doe |
      | storeManager | John Doe |
@TRN-1026
  Scenario: "Invalid username or password." error message should be displayed for invalid credentials
    When the user enter invalid username and invalid password
    Then the user should see "Invalid user name or password." message
@TRN-1027
  Scenario: User should see the password in bullet signs by default
    When the user enter password
    Then the user should see bullet signs by default
@TRN-1028
  Scenario: User land on the Forgot Password page after clicking on the "Forgot your password?" link
    When the user click on the Forgot your password? link
    Then the user land on the "Forgot Password" page
@TRN-1030
  Scenario: User can see Remember me on this computer link on the login page and it should be clickable
    When the user on the login page should user see the "Remember me on this computer" link
    Then the user should be able to click on the checkbox
    And the user should be able to click
@TRN-1031
  Scenario: Verify that user can use "Enter" key from their keyboard on the login page
    When the user clicks on Username hit the enter and enter Password input box hit the enter
    Then the user should be able to logged in


