Feature: Purchasing 1 random item and verifying name and price

  Scenario:
    Given Go to "https://www.ss.com/lv/"
    And Click on Suņi, kucēni
    And Enter age "1"
    Then Validate if age has value "1" entered