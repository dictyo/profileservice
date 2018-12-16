Feature: a domain can be retrieved
  Scenario: client makes call to GET /domains with id backend
    When the client gets /domains/backend
    Then the client receives status code of 200
    And the client receives 3 categories
  Scenario: client makes call to GET /domains with WRONG id
    When the client gets /domains/backends
    Then the client receives status code of 404