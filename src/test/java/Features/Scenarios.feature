Feature: Interview Task

  Scenario: As a user I need to change domicile
    Given I go to website ubs.com
    When I push the button to change domicile
    Then Language should be changed

  Scenario: As a US client login with incorrect password and login <negative test>
    Given I navigate to website ubs.com
    And Go to Login Page
    When I enter the following for Login
    Then Should appear error message

  Scenario: As a user want to check DAX stocks
    Given I go to ubs.com
    When I check DAX stock value
    And I checking first value
    And I refresh browser
    Then I should see different value of DAX