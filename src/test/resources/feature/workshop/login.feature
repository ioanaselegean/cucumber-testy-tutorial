Feature: Login

  Scenario: Successful Login
    
    Given I access the login page
    And I insert valid credentials
    When I click Login button
    Then I check if user was logged in

  Scenario: Login with wrong credentials

    Given I access the login page
    And I insert valid credentials
    When I click Login button
    Then I expect invalid credentials message
