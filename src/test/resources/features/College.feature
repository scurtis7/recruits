Feature: Retrieve list of colleges
  Scenario: client makes call to GET colleges
    Given the colleges are in the database
    When the client calls GET colleges
    Then the client receives status code 200
    And the client receives a list of colleges
