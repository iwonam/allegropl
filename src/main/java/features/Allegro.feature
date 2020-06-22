Feature: Searching Allegro.pl and clicking the first promoted item

  Scenario: Searching allegro.pl scenario
    Given Open Chrome and go to Allegro
    When Enter the search phrase "iPhone"
    And Click the search button
    Then Sort the search result
    Then Filter the search result
    Then Click on the first promoted item
    Then Check the item name