Feature: Test the ESPN Website

# getting to the Sign Up
Background:
  Given ESPN website is loaded

  # Successful Sign Up
  Scenario: Sign Up successful
    When click Sign Up button
    Then Sign Up with "Chris" "Martinez" "Aloha.123@gmail.com" and "Aloha.123"

  # Check Carousel
  Scenario: Carousel present
    When click Watch button
    Then Check carousel have title and description
    And go back to main screen

  # Check User
  Scenario: User is logged in
    When users logs in with "Aloha.123@gmail.com" and "Aloha.123"
    Then hover over user icon and confirm "Chris"