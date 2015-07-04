@screan
Feature: Login

  Scenario: Successful Login
    Given I access the login page
    When I enter "eu@fast.com"/"eu.pass" credentials
    And  I click Login button
    Then I check if user was logged in

  Scenario: Login with wrong credentials
    Given I access the login page
    When I enter "cineva@fast.com"/"eu.pass" credentials
    And  I click Login button
    Then I expect message "Invalid user or password!"

  Scenario: Login with no password
    Given I access the login page
    When I enter "eu@fast.com"/"" credentials
    And  I click Login button
    Then I expect message "Please enter your password!"

  Scenario: Login with no user
    Given I access the login page
    When I enter ""/"wrong" credentials
    And  I click Login button
    Then I expect message "Please enter your email!"

  Scenario Outline: Failed login
    Given I access the login page
    When I enter "<email>"/"<pass>" credentials
    And  I click Login button
    Then I expect message "<message>"
    Examples:
      | email       | pass | message                     |
      | aa@fast.com |      | Please enter your password! |
      |             | pass | Please enter your email!    |
      | aa@fast.com | pass | Invalid user or password!   |
      |             |      | Please enter your email!    |

    Scenario: Logout success
      Given I successfully login
      When I access some elements

