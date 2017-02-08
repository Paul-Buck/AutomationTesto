Feature: Test2

  @orange
  Scenario Outline: I want to go to the Yodel home page and enter a Postcode only to verify I can not search for parcels without a tracking ID
    Given I go to Yodel "<web>"
    Then I Enter In a "<Postcode>"
    And I select Search
    Then I should be given a validation prompt message


    Examples:

    | web | Postcode |
    | https://www.yodel.co.uk/ | CH448BE |