@UserStory2

Feature: Migros Deliver To Store Search Products Test

  Scenario Outline: Delivery option from store search for products
    Given User go to website
    And  User close the popUps
 #   When User click choose deliver location button
 #   When User click take it from the store button
  #  When User chose delivery city as "<Citys>"
   # When User chose delivery town as "<Towns>"
    #When User chose delivery store as "<Stores>"
    And User search for "<Products>"
   # Then Check title contains "<Products>"
    Then Close the tap
    Examples:
      | Citys    | Towns  | Stores                     | Products |
      | İstanbul | Adalar | BÜYÜKADA İSTANBUL M MİGROS | Çikolata |
     # | İstanbul | Adalar | BÜYÜKADA İSTANBUL M MİGROS | Sakız    |


