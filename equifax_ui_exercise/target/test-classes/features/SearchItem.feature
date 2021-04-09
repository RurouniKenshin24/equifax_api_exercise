Feature: As a user I want to be able to search item what I want

  Background:
    Given user is on the home page
    When user search "qa testing for beginners" by using search box
    And user should be able to see title as a "Amazon.com : qa testing for beginners"

  Scenario: Searching an item
    And user clicks on the "1"st item on the listed items
    Then user should be able to see same price in the item page