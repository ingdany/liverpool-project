Feature: FilterCategories

  @SmokeTest
  Scenario: Return Dior Scents
    Given I am on the Liverpool home page
    When I click on the Categories menu
    And Place the Cursor in the "Belleza" option
    And Click on the "Perfumes Hombre" option
    And Selecting "Dior" brand
    Then I should see a "Dior" product