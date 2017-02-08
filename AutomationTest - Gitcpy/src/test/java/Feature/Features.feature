Feature: Test

  @pinkFloyd
  Scenario Outline: I Want to search google for the BBC, go to the BBC website, search Pink Floyd and go to the Pink Floyd page
    Given I go to "<website>"
    Then I "<search>" the site
    And I select the BBC
    And I again "<search2>" the site
    Then I select the first result, and get taken to the Pink Floyd page


    Examples:
      | website | search  | search2 |
      | http://www.google.com | BBC | Pink Floyd |


  @strawBerry
  Scenario Outline: I Want to go to bbc
    Given I want "<ssite>"


    Examples:
      | ssite |
      | http://www.bbc.co.uk |
