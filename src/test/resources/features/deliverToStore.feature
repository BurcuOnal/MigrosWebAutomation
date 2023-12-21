@UserStory1

Feature: Migros Deliver To Store Test

  @TestCase1
  Scenario: Test Case 1: Choose delivery option as from store (Happy Path)
    Given User go to website
    And  User close the popUps
    When User click choose deliver location button
    When User click take it from the store button
    When User chose delivery city as "İstanbul"
    When User chose delivery town as "Kartal"
    When User chose delivery store as " ANATOLİUM İSTANBUL MM MİGROS "
    Then Check the store name on home page
    Then Close the tap

  @TestCase2
  Scenario: Test Case 2: Choose delivery option as from store (Leave store option empty)
    Given User go to website
    And  User close the popUps
    When User click choose deliver location button
    When User click take it from the store button
    When User chose delivery city as "İstanbul"
    When User chose delivery town as "Kartal"
    When User leave delivery store empty
    Then Check the warning text appears
    Then Close the tap
