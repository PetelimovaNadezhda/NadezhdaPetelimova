Feature: Simple Cucumber Test

  Scenario: Login verification
    Given I open EPAM JDI site
    And I login as user 'PITER'
    Then User name should be as for user 'PITER'
    And Interface HomePage should have all needed elements
    When I click on 'Service' button in the Left section and check drop down
    And I click on 'Service' button in the Header and check drop down
    And I click on 'Different Elements' button in Service dropdown
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




