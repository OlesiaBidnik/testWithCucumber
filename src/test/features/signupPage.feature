# new feature
# Tags: optional
# language: en
@all

Feature: Sign up page

    Scenario: Sign up with empty fields
        Given I am on sign up page
        When I click signup
        Then I see error

    Scenario: Sign up with empty phone
        Given  I am on sign up page
        When I wait until page load
        When I type username "Test"
        When I type password "Test"
        When I click signup
        Then I see error

    Scenario: Sign up with empty username
        Given I am on sign up page
        When I wait until page load
        When I type phone "89879566202"
        When I type password "Test"
        When I click signup
        Then I see error

    Scenario: Sign up with empty password
        Given I am on sign up page
        When I wait until page load
        When I type phone "89852355202"
        When I type username "Test"
        When I click signup
        Then I see error

    Scenario: Sign up with incorrect number
        Given I am on sign up page
        When I wait until page load
        When I type phone "666666666666666"
        When I type name "test"
        When I type username "test"
        When I type password "test"
        When I click signup
        Then I see error

    Scenario: Check login with facebook
        Given I am on sign up page
        When I wait until page load
        When I click sign up with facebook
        Then facebook page opens

    Scenario: Check login link
        Given I am on sign up page
        When I wait until page load
        When I click log in link
        Then login page opens

