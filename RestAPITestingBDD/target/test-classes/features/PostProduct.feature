Feature: Insert product usnig Post api

  Scenario Outline: Validate post product api works correectly
    Given I hit the url of post products api endpoint
    When I pass the url of products in the request
    When I recieve the response code as 200
    And I pass the request body of product title "Shoes"
