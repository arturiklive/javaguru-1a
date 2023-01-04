Feature: Purchasing 1 random item and verifying name and price

  Scenario:
    Given Go to "https://www.1a.lv/"
    And Make a search for product type "laptop"
    And Select brand "Asus"
    And Get random link and select one product

    When Verify if Product Page is opened
    Then Get product name
    And Get product price
    And Add product to cart
    And Verify if purchase is succeed
    And Click to go to Cart Page

    When Verify if Cart Page is opened
    Then Get product name in Cart
    And Get product price in Cart
    And Click to go to Checkout Page

    When Verify if Checkout Page is opened
    Then In email field enter "tehnique111@inbox.lv"
    And Click to go to Shipping Page

    When Verify if Shipping Page is opened
    Then Select get product in Store
    And Select Store
    And Enter purchaser name "Arturs"
    And Enter purchaser lastname "Tehnique"
    And Enter purchaser phone "29999999"
    And Click to save data before going to Billing Page
    And Click to go to Billing Page

    When Verify if Billing Page is opened
    Then Select Pay in Store option
    And Get total price

    Then Compare that expected product name in checkout section contains purchased actual product name
    Then Compare that expected product price in checkout section contains purchased actual product price
    Then Compare that expected total price in paying section contains actual product price