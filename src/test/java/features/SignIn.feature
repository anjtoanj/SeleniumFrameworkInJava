Feature: Logged in User View

  Scenario: Validate user is able to view after login
    Given User navigates to the Login page
    When User clicked on hamburger icon
    And User selected SignIn Portal
    And User successfully enters the login details
      | username  | password |
      | testuser  | password |
    And User clicked the login button
    Then User should be able to view the product category page