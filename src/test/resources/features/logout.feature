Feature: logout functionality
  Background: user logged in
    Given user logged in successfully
  Scenario:
1- User can log out by using log out button inside profile info and ends up in login page.

2- The user can not go to the home page again by clicking the step back button after successfully logged out.

3- The user must be logged out if the user close the open tab (all tabs if there are multiple open tabs)
