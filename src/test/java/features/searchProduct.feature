Feature: Search and Place the order for Product

  Scenario: Search Experience for product search in both home and Offer page
    Given User is on GreenCart Landing Page
    When User searched with shortname "Tom" and extracted actual name of product
    Then User searched for "Tom" shortname in offer page
    And validate product name in offers page matches with Landing Page