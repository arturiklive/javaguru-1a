Feature: Purchasing 1 random item and verifying name and price

  Scenario:
    Given Go to "https://www.1a.lv/"
    And Make a search for product type "laptop"
    And Select brand "Asus"
    When Select one random product

    Then Verify if Product Page is opened
    And Add product to cart
    And Verify if purchase is succeed
    When Click to go to Cart Page

    Then Verify if Cart Page is opened
    When Click to go to Checkout Page

    Then Verify if Checkout Page is opened
    And In email field enter "tehnique111@inbox.lv"
    When Click to go to Shipping Page

    Then Verify if Shipping Page is opened
    And Select get product in Store
    And Select Store
    And Enter purchaser name "Arturs"
    And Enter purchaser lastname "Tehnique"
    And Enter purchaser phone "29999999"
    And Click to save data before going to Billing Page
    When Click to go to Billing Page

    Then Verify if Billing Page is opened
    And Select Pay in Store option

    Then Compare that expected product name in checkout section contains purchased actual product name
    Then Compare that expected product price in checkout section contains purchased actual product price
    Then Compare that expected total price in paying section contains actual product price