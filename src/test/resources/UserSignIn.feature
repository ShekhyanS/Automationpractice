Feature: As a user I want to login into my account

  @smoke
  Scenario Outline: Valid user should be logged in successfully
    Given the user opens online shop website
    When the user clicks Sign In link
    And  the user enters valid username
    And the user enters valid password
    And the user clicks Sign In button
    Then "<user>" user account page is displayed
 Examples:
    |user|
    |Lusine Papyan|


