Feature: Login functionality of OrangeHRM

  As a user of OrangeHRM
  I want to be able to log into the system using valid credentials
  So that I can access my account

  Background:
    Given I am on the OrangeHRM login page

  @login
  Scenario: Successful login with valid credentials
    When I enter a valid username "Admin"
    And I enter a valid password "admin123"
    When I click on the "Login" button
    Then I should be redirected to the "Dashboard" page
    And I should see the "Dashboard" text on the page

  @login
  Scenario: Login with invalid credentials
    Given I enter an invalid username "InvalidUser"
    And I enter an invalid password "InvalidPass123"
    When I click on the "Login" button
    Then I should see a validation message "Invalid credentials"

  @login
  Scenario: Login with blank username and password
    Given I leave the username field blank
    And I leave the password field blank
    When I click on the "Login" button
    Then I should see a validation message "Required"

  @login
  Scenario: Login with blank username and valid password
    Given I leave the username field blank
    And I enter a valid password "admin123"
    When I click on the "Login" button
    Then I should see a validation message "Required"

  @login
  Scenario: Login with valid username and blank password
    Given I enter a valid username "Admin"
    And I leave the password field blank
    When I click on the "Login" button
    Then I should see a validation message "Required"
