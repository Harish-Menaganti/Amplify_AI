Feature: Add products to cart and checkout on Amazon.in

Scenario: Add products to cart and checkout using Cash on Delivery
    Given Open a web browser
    When Navigate to the Amazon.in website
    Then Verify that the user is on the Amazon.in website
    When Log in to the user's account
    And Search for a product and add it to the cart
    And Click on the cart icon to view the items in the cart
    Then Verify that the items are added to the cart
    When Click on the "Checkout" button
    Then Verify that the user is on the checkout page
    And Select the "Cash on Delivery" option as the payment method
    Then Verify that the payment method is set to "Cash on Delivery"
    And Verify that a confirmation message for selecting "Cash on Delivery" is displayed
    And Close the web browser