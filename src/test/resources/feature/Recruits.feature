Feature: Validate recruits application

  Scenario: Recruits returns players
    Given recruits application running
    When get players is called
    Then players are returned
