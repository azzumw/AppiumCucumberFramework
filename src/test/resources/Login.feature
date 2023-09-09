Feature: Login scenarios
  Let's you authenticate the user

  @test
  Scenario Outline: Login fails when invalid username is provided
    Given I enter the username as "<username>"
    And I enter the password as "<password>"
    When I press the login button
    Then Login should fail with the error "<error>"
    Examples:
      | username | password | error |
    | invalidUsername | secret_sauce | Username and password do not match any user in this service.|

  @test
  Scenario Outline: Login with invalid password
    Given I enter the username as "<username>"
    And I enter the password as "<password>"
    When I press the login button
    Then Login should fail with the error "<error>"
    Examples:
      | username | password | error |
      | standard_user | invalidpassword | Username and password do not match any user in this service.|

  Scenario Outline: Login with valid username and password
    Given I enter the username as "<username>"
    And I enter the password as "<password>"
    When I press the login button
    Then I should see products page with title "<title>"
    Examples:
      | username | password | title |
      | standard_user | secret_sauce | PRODUCTS |