Feature: ValidateResultsCount

    @SmokeTest
    Scenario: Get the Quantity of Sony 55 Inches
        Given I am on the Liverpool home page
        When I search for the product "smart tv"
        And I included filter price "Mas de $10000.0"
        And I included filter brand "SONY"
        And I filter the results by size "55 pulgadas"
        Then I should see the results count