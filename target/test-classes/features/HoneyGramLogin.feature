Feature: Log in Screen
  Background: Open Homeygram app
  @login
  Scenario Outline: Test Log in with valid credential
    When User will open the Honeygram app
    Given User will enter login id <login_id>
    Then User will enter password <password>
    And  User will click enter button
    Then User will see dashboard
    Examples:
      | login_id| password|
      |abdcasd  |efdsd    |


