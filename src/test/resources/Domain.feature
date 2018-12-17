Feature: a domain can be retrieved
  Scenario: client makes call to GET /domain with id "backend"
    When the client gets /domains/backend
    Then the client receives status code of 200
    And the client receives for each path an expected value:
      # path                            # value     #
      | $[0].name                       | Languages |
      | $[0].skills[0].name             | PHP       |

  Scenario: client makes call to GET /domains with WRONG id
    When the client gets /domains/backends
    Then the client receives status code of 404