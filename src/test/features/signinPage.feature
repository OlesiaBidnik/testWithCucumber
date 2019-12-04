# new feature
# Tags: optional
# language: en
@all

Feature: Sign in page
    
  Scenario: Sign in with empty field
    Given I am on sign up page
    When I wait until page load
    Then log in button is disabled


  Scenario: Sign up with short password
    Given I am on sign up page
    When I click log in link
    When I wait until page load
    When I type email "Test"
    When I type pass "Test"
    Then log in button is disabled


  Scenario: Sign in with empty email
    Given I am on sign up page
    When I click log in link
    When I type pass "Test666"
    Then log in button is disabled


  Scenario: Sign in with incorrect credentials
    Given I am on sign up page
    When I click log in link
    When I wait until page load
    When I type email "Test"
    When I type pass "Test66666"
    When I click log in button
    Then I see alert


  Scenario: Check show password button
    Given I am on sign up page
    When I click log in link
    When I wait until page load
    When I type email "test"
    When I type pass "test8908990"
    When I click Show button
    When I wait until page load
    Then I see password "test8908990"


  Scenario: Check login with facebook button
    Given I am on sign up page
    When I click log in link
    When I wait until page load
    When I click log in with Facebook button
    Then facebook page opens


  Scenario: Check 'Forgot password' link
    Given I am on sign up page
    When I click log in link
    When I wait until page load
    When I click Forgot Password link
    Then reset password page opens


  Scenario: Check sign up link
      Given I am on sign up page
      When I click log in link
      When I wait until page load
      When I click sign up link
      Then sign up page opens

