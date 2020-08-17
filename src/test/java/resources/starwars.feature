Feature: the message can be retrieved
  Scenario: client makes call to GET /hello
    Given the client calls /hello
    Then the client receives status code of 200