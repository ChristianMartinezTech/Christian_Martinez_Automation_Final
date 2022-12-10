Feature: Test the Disneyland Website

# Starting the App
  Background:
    Given Disneyland app is loaded

  # Checking on Hotels
  Scenario: Hotels option is available
    When Tap Map button
    Then Check if the Hotels Option is available

  # Checking on Privacy & Legal
  Scenario: Privacy and Legal is available
    When Tap on Menu Button
    And Scroll down until bottom
    And Tap on Privacy & legal
    Then User can see Privacy & legal options

  # Checking on Add Plans option
  Scenario:  Reserve Dining Option available
    When Tap Add Plans Button
    Then Check Reserve Dining is in the list