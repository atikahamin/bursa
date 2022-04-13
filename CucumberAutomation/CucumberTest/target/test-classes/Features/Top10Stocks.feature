Feature: Print Top 10 Stocks

  Scenario: Verify Login Successful with valid Credentials
    Given Browser is open
    And User launch Bursa Webpage
    When User successfully navigated to homepage
    Then Output the top 10 stocks
