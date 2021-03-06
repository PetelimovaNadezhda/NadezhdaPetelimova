Feature: Different Elements Cucumber Test

  Scenario: Different Elements Page Test
    Given I am on Home Page
    And I login as user 'PITER CHAILOVSKII'
    Then User name should be as for user 'PITER CHAILOVSKII'
    And Interface HomePage should have all needed elements
    When I click on Service button in the Left section and check drop down Support, Dates, Complex Table, Simple Table, User Table, Table with pages, Different elements, Performance
    And I click on Service button in the Header and check drop down Support, Dates, Complex Table, Simple Table, User Table, Table with pages, Different elements, Performance
    And I click on 'Different elements' button in Service dropdown
    Then Different Elements page is opened and interface Different Elements should have all needed elements
    And Sections is displayed
    When I select in the checkboxes 'WATER'
    Then log update: 'WATER' is 'TRUE'
    When I select in the checkboxes 'WIND'
    Then log update: 'WIND' is 'TRUE'
    When I select in the radio 'SELEN'
    Then log update: 'SELEN' is 'METAL'
    When I select in the dropdown 'YELLOW'
    Then log update: 'YELLOW' is 'COLOR'
    When I unselect in the checkboxes 'WIND'
    Then log update: 'WIND' is 'FALSE'
    When I unselect in the checkboxes 'WATER'
    Then log update: 'WATER' is 'FALSE'




