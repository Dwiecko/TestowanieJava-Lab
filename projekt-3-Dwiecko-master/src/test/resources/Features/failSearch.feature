Feature: Search feature
  Scenario: Verify if incorrect data gives no results
    Given user is on homepage
    When user navigates to searchbar
    And user enters data not available on page
    Then fail message is displayed
