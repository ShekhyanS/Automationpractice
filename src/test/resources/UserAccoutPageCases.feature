Feature: As a user I want to manage my account

  Background:
    Given the user opens online shop website
    When the user clicks Sign In link
    And  the user enters valid username
    And the user enters valid password
    And the user clicks Sign In button

  @smoke
  Scenario Outline: Valid user should be logged in successfully
    Then "<user>" user account page is displayed
    Examples:
      | user          |
      | Lusine Papyan |

  @smoke
  Scenario: Valid user should be able to view order history
    And the user clicks Order History and Details option
    Then the list of following orders is displayed
      | SRNEKXBCS |
      | QGORPJEPG |