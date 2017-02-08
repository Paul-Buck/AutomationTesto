Feature: ChromeTest

  @pear
  Scenario Outline: I Want to go to google
    Given I want "<ssite>"
    Then Im "<sch>" the site
    And Im select the BBC
    And Im again "<sch2>" the site
    Then Im select the first result, and get taken to the Pink Floyd page



    Examples:
      | ssite | sch  | sch2 |
      | http://www.google.com| BBC | Pink Floyd |


