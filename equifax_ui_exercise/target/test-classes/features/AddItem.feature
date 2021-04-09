Feature: As a user I want to be able to add item to user cart

  Background:
    Given user is on the home page
    When user search "qa testing for beginners" by using search box
    And user should be able to see title as a "Amazon.com : qa testing for beginners"

  Scenario: Adding an item
    And user clicks on the "1"st item on the listed items
    And user clicks on the add to cart button
    Then user should be able to see same price in the cart page
