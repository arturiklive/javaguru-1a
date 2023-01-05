# javaguru-1a
QA Automatization project
- Java
- Selenium
- Cucumber

Main Task: Purchasing 1 random product and verifying name and price at billing step
Test steps:

1) Go to "https://www.1a.lv/"
2) Make a search for product type "laptop"
3) Select brand "Asus"
4) Select one random product

5) Verify if Product Page is opened
6) Add product to cart
7) Verify if purchase is succeed
8) Click to go to Cart Page

9) Verify if Cart Page is opened
10) Click to go to Checkout Page

11) Verify if Checkout Page is opened
12) In email field enter e-mail
13) Click to go to Shipping Page

14) Verify if Shipping Page is opened
15) Select get product in Store
16) Select Store for receiving product
17) Enter purchaser name
18) Enter purchaser lastname
19) Enter purchaser phone number
20) Click to save data before going to Billing Page
21) Click to go to Billing Page

22) Verify if Billing Page is opened
23) Select Pay in Store option

24) Compare that expected product name in checkout section contains purchased actual product name
25) Compare that expected product price in checkout section contains purchased actual product price
26) Compare that expected total price in paying section contains actual product price
