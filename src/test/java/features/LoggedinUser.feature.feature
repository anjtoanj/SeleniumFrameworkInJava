Feature: Logged in User View

  Scenario: Validate user is able to view after login
    Given User navigates to the Login page
    When User successfully enters the login details
    Then User should be able to view the product category page
