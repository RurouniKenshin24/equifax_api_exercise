Feature: As a user I want to be able to checkout item that in the user cart

  Background:
    Given user is on the home page
    When user search "qa testing for beginners" by using search box
    And user should be able to see title as a "Amazon.com : qa testing for beginners"

  Scenario: Checkout item
    And user clicks on the "1"st item on the listed items
    And user should be able to see same price in the item page
    And user clicks on the add to cart button
    And user should be able to see same price in the cart page
    And user clicks on the proceed to checkout button
    Then user should be able to see same price in the checkout page
