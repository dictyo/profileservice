Feature: the version can be retrieved
  Scenario: client makes call to GET /version
    When the client gets /version
    Then the client receives status code of 200
    And the client receives field version with value 0.9-SNAPSHOT
