Feature: Login Feature
  Verify if user with wrong data is not able to Login in to the site

  Scenario: Login as a incorrect user
    Given user is on homepage
    When user navigates to Login Page
    And user enters incorrect username and Password
    Then error message is displayed
