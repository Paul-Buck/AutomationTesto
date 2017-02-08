Feature: Test3

  @banana
  Scenario Outline: Connect to website and search postcode
    Given I want to connect to "<webs>"
    When I click on Parcel Enquiry
    And I click on option postcode
    And I enter my postcode "<pst>"
    And I select parcel search
    Then I see a list of parcels


    Examples:
      | webs | pst |
      | http://Paul.Buck@e2ebeta.yodel.net/pls/apex/f?p=106:1:7610393181530 | CH448BE |
