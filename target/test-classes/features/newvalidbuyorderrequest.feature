Feature:As a trader, user creates a successful new buy order request

  Scenario Outline:as a trader, user creates a successful new buy order request
    Given user enters valid fixed new buy order payload parameters
    Given user enters valid fixed new buy order header parameters
    Then user enters trader apikey "<apikey>" header parameter
    Then user enters a valid nonce <nonce>
    Then user enters a valid client_order_id "<client_order_id>"
    Then user enters a valid symbol "<symbol>"
    Then user enters a valid amount "<amount>"
    Then user enters a valid min_amount "<min_amount>"
    Then user enters a valid price "<price>"
    Then user enters a valid side as "<side>"
    Then user enters a valid type "<type>"
    Then user enters a valid option "<options>"
    Then user enters a valid stop_price "<stop_price>"
    Then user enters a valid account_name "<accountname>"
    Then user calculates and enters payload base64 header parameter
    Then user calculates and enters hmacsha384 parameter "<apisecret>"
    When user sends the new buy order post request
    Then user verifies the status code is <statuscode>


    Examples:
      | apikey | nonce | client_order_id | symbol | amount | min_amount | price | side | type           | options             | stop_price | accountname | apisecret |statuscode|
      | apikey |   0   |                 | btcusd | 8      | 5          | 13450 | buy  | exchange limit | immediate-or-cancel |            |             | apisecret | 200|


