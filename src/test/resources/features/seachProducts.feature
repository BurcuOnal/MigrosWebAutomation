@UserStory2

Feature: Migros: Add Products to Basket

  Background:
    Given User go to website
    And User close the popUps
    When User click choose deliver location button
    When User click take it from the store button
    When User chose delivery city as "İstanbul"
    When User chose delivery town as "Adalar"
    When User chose delivery store as " BÜYÜKADA İSTANBUL M MİGROS "

  @TestCase3
  Scenario Outline: Add products to the basket
    And User search for "<Products>"
    Then Check currentURL contains "<Products>"
    And Add first product to the basket
    Then Close the tap
    Examples:
      | Products |
      | Çikolata |
  #   | Sakız    |
  @TestCase4
  Scenario Outline: Check basket: if the product's price and basket's price are match
    And User search for "<Products>"
    Then Check currentURL contains "<Products>"
    And Add first product to the basket
    And Go to basket
    Then Check if the product price and basket price are the same
    Then Close the tap
    Examples:
      | Products |
      | Çikolata |
  #    | Sakız    |
  @TestCase5
  Scenario Outline: Check basket w more than one product: if the product's total price and basket's price are match
    And User search for "<Products>"
    Then Check currentURL contains "<Products>"
    And Add first product to the basket
    And Go to basket
    And Add one more different product to the basket
    Then Check if the basket price and total price of the products are same
    Then Close the tap
    Examples:
      | Products |
      | Çikolata |
  #    | Sakız    |
