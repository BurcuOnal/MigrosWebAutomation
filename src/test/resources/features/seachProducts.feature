@UserStory2

Feature: Migros Search Products and Add to Basket

  Scenario Outline: Delivery option from store search for products
    Given User go to website
    And User close the popUps
    When User click choose deliver location button
    When User click take it from the store button
    When User chose delivery city as "İstanbul"
    When User chose delivery town as "Adalar"
    When User chose delivery store as " BÜYÜKADA İSTANBUL M MİGROS "
    And User search for "<Products>"
    Then Check currentURL contains "<Products>"
    And Add first product to the basket
    And Go to basket
    Then Check the product's name and price correct
    Then Close the tap
    Examples:
      | Products |
      | Çikolata |
  #    | Sakız    |


