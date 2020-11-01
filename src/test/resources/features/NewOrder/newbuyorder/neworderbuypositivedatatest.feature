
 @Positive
Feature:Users should be able to place buy orders with valid credentials
  admins new buy order,new buy margin order but traders only new buy order

  Background:user enters standard new buy order datas
    #this initiliaze, request:endpoint, cache, content-type
    Given user enters new order fixed valid datas
  @NewBuyOrders @Positive
  Scenario Outline:TC_00001_As an admin, i must be able to place a buy order  with valid credentials

    Then user enters a valid APIKey "<apikey>"
    #This function gets a symbol randomly from the list of available symbols
    Then user enters a valid symbol "<symbol>"
    #This function generates nonce automatically if it is empty
    Then user enters a valid nonce <nonce>
    #This function generates client order id automatically if it is empty
    Then user enters a valid client order id "<order_id>"
    Then user enters a valid amount "<amount>"
    Then user enters a valid min_amount "<min_amount>"
    Then user enters a valid price "<price>"
    Then user enters a valid side "<side>"
    Then user enters a valid type "<type>"
    # this transfer the option to payload. if string is set to random it selects from option list automatically
    Then user enters a valid option "<options>"
    Then user enters a valid accountname "<accountname>"
    Then user enters a valid APISecret "<apisecret>"
    #This function calculates and loads payloads, base64 coding and HmacSha384 coding automatically
    Then system creates payload and signatures
    When user posts the new buy order request
    #This functions automatically converts response to ResponsenewBuyBody.class
    Then user verifies status code is <statuscode>

    Examples:
        # Client_O_I, nonce--> "none" no means no entry , no value means automatic generation
        # apikey,apisecret -- > write "none" to leave empty, noway to leave blank----------
      | apikey | symbol | nonce | order_id | amount | min_amount | price | side | type           | options             | accountname | apisecret | statuscode |
      | apikey | random |   0    |          | 17     | 8          | 13650 | buy  | exchange limit | immediate-or-cancel | primary     | apisecret | 200        |
      | apikey | random |    0   |          | 13     | 5          | 13650 | buy  | exchange limit |                     | primary     | apisecret | 200        |


