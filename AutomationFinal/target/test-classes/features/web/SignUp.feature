Feature: Sign Up to the ESPN Website

# getting to the Sign Up
Background:
  Given ESPN website is loaded
  When click Sign Up button

  # Successful Sign Up
  Scenario: Sign Up successful
    Then Sign Up with complete information
    And user is logged in

  # Unsuccessful Sign Up
  Scenario: Sign Up unsuccessful
    Then Sign Up with incomplete information
    And user is not logged in