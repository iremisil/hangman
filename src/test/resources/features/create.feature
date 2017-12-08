Feature: Create single player
  Scenario:
    Given Player informations
      | name | age|
      | irem | 25 |
    When perform POST request to "player"
    Then after request all players should have id
    Then after create player status should be 200