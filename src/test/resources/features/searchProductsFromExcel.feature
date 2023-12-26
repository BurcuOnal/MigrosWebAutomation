@ExcelDeneme
Feature: Migros Deliver To Store Search Products Test from excelfile

  Scenario : Delivery option from store search for products data from excel
    Given User go to website
    And  User close the popUps
    When User click choose deliver location button
    When User click take it from the store button
    When enter info from "Sayfa1" excel file
    Then Close the tap