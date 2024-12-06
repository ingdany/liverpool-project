Feature: ValidateItem

  @SmokeTest
  Scenario: Validate the Item and Price for the selected product
    Given I am on the Liverpool home page
    When I search for product "playstation"
    And I select the first product "PS5"
    Then I should see the product title "PS5"
    And I should see the product price