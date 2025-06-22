
Feature: Get all products from the api

  Scenario: Verify the get api of the products
    Given I hit the url of get products api endpoint
    When I pass the url of products in the request 
    When I recieve the response code as 200
   
      
  Scenario Outline: Verify the rate of the first products
  Given I hit the url of get products api endpoint
  When I pass the url of products in the request 
  Then  I verify the rate of the first product is <FirstProductRate>

  Examples:
    | FirstProductRate |
    |    3.9 |          
    
    