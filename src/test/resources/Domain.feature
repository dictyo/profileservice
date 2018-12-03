Feature: a domain can be retrieved
  Scenario: client makes call to GET /domains with id backend
    When the client gets /domains/backend
    Then the client receives status code of 200
    And the client receives 5 categories
#    And the client receives path $.categories[?(@.name == 'Languages')].skills[?(@name == 'PHP')].experience.value with value 1