@screan
Feature: Change password

  Scenario: Change password successfully
    Given I successfully login
    When I click Preferences button
    And I input current password
    And I input new password
    And I confirm new password
    And I click save button
    Then I expect change password message "Your password has been successfully changed."
    And I close Preferences window
    And I logout
    And I successfully login


