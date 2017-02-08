Feature: WhereAreMyDrivers

  @Cheese
  Scenario Outline: I want to go to the E2E yodel site, select where are my drivers, select warrington, and view the drivers returned
    Given I would like to go to "<wete>"
    When I select Where are my drivers
    And I select drivers
    Then I should see drivers


    Examples:
    | wete |
    | http://Paul.Buck@e2ebeta.yodel.net/pls/apex/f?p=106:1:7610393181530 |