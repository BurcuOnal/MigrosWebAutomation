@UserStory1

Feature: Migros Deliver To Store Test




  @TestCase1FromStore
  Scenario: Test Case 1: Choose delivery option as from store
    Given User go to website
    And  User close the popUps
    When User click choose deliver location button
    When User click take it from the store button
    When User chose delivery city as "İstanbul"
    When User chose delivery town as "Kartal"
    When User chose delivery store as " ANATOLİUM İSTANBUL MM MİGROS "

  @TestCase2AddBasket
  Scenario: Test Case 2: Add product to the basket when delivery option from store
