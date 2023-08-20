Feature: Products scenarios

  Scenario Outline: Validate product info on Products page
    Given I am logged in
    Then The product is listed with title "<title>" and price "<price>"
    Examples:
    |title | price |
    |Sauce Labs Bolt T-shits | $15.99 |


    Scenario Outline: Validate product info on Product Detail page
      Given I am logged in
      When I click on product title "<title>"
      Then I am navigated to Product Detail page with the same "title", and price "<price>" and description "<description>"

      Examples:
        | title | price | description |
        | Sauce Labs Backpack | $29.99 | carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection. |
