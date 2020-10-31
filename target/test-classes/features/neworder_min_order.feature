@NewOrder

Feature: Testing min_order feature in buy sell requests by boundary analysis
  As a trader, user must be able to place orders with min_amount is less or equal to amount

  Scenario Outline: As a trader i must be place a buy order min_amount less or equal to amount
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
#    When user sends the new buy order post request
#    Then user verifies the status code is "200"



    Examples:
      | apikey | nonce | client_order_id | symbol | amount | min_amount | price | side | type           | options             | stop_price | accountname | apisecret |
      | apikey | 0     |                 | btcusd | 12     | 5          | 13450 | buy  | exchange limit | immediate-or-cancel |            |             | apisecret |
      | apikey | 0     |                 | btcusd | 8      | 6          | 13450 | buy  | exchange limit | immediate-or-cancel |            |             | apisecret |
      | apikey | 0     |                 | btcusd | 6      | 6          | 13450 | buy  | exchange limit | immediate-or-cancel |            |             | apisecret |

  @Negative @NewOrder @BuyOrder
  Scenario Outline: As a trader i should not be able to place a buy order with min_amount larger than amount

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
      | apikey | nonce | client_order_id | symbol | amount | min_amount | price | side | type           | options             | stop_price | accountname | apisecret | statuscode |
      | apikey | 0     |                 | btcusd | 12     | 15         | 13450 | buy  | exchange limit | immediate-or-cancel |            |             | apisecret | 400        |
