
@NewOrder @NewBuyOrder @Nonce  @Negative
Feature:US_0001_User cant place a successful new buy order with invalid nonce and invalid client_order_id credentials
    # this scenario

  Background:user enters standard new buy order datas

     #this initiliaze, request,cache, content-type parameters automatically filled
    Given user enters new order fixed valid datas

    #This is a boundary value test for nonce
  Scenario Outline:TC_0002_user places a successful order than fails to attemp another order with the old nonce
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

    #This function automatically converts response body to ResponseBodyNewBuyOrder class/object under Pojos
    When user posts the new buy order request
    Then user verifies status code is <successfulstatuscode>

    Then user enters a valid client order id "<order_id>"
    Then system creates payload and signatures
    When user posts the new buy order request
    #This functions automatically converts response result, reason and error message to ResponseError class under pojos
    Then user verifies status code is <failedstatuscode>, reason is "<reason>" and message is "<message>"


    Examples:
        # Client_O_I, nonce--> "none" no means no entry , no value means automatic generation
        # apikey,apisecret -- > write "none" to leave empty, noway to leave blank----------
      | apikey | symbol | nonce | order_id | amount | min_amount | price | side | type           | options             | accountname | apisecret | successfulstatuscode | failedstatuscode | reason       | message           |
      | apikey | btcusd | 0     |          | 17     | 8          | 13650 | buy  | exchange limit | immediate-or-cancel | primary     | apisecret | 200                  | 400              | InvalidNonce | has not increased |
      | apikey | random | 0     |          | 13     | 5          | 13650 | buy  | exchange limit |                     | primary     | apisecret | 200                  | 400              | InvalidNonce | has not increased |


    #------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  @NewOrder @NewBuyOrder @Nonce  @Negative
  Scenario Outline:TC_00003_user places a successful order than fails to attemp another order with a smaller nonce
    Then user enters a valid APIKey "<apikey>"
      #This function gets a symbol randomly from the list of available symbols
    Then user enters a valid symbol "<symbol>"
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
    #This functions automatically converts response result, reason and error message to ResponseError class under pojos
    Then user verifies status code is <successfulstatuscode>
    Then user enters a valid client order id "<order_id>"
    Then user enters a smaller nonce than previous
    Then system creates payload and signatures
    When user posts the new buy order request
    Then user verifies status code is <failedstatuscode>, reason is "<reason>" and message is "<message>"


    Examples:
          # Client_O_I, nonce--> "none" no means no entry , no value means automatic generation
        # apikey,apisecret -- > write "none" to leave empty, noway to leave blank----------
      | apikey | symbol | nonce | order_id | amount | min_amount | price | side | type           | options           | accountname | apisecret | successfulstatuscode | failedstatuscode | reason       | message           |
      | apikey | btcusd | 0     |          | 17     | 8          | 13650 | buy  | exchange limit | immediate-or-cancel | primary     | apisecret | 200                  | 400              | InvalidNonce | has not increased |
      | apikey | random | 0     |          | 38     | 7          | 13650 | buy  | exchange limit |                     | primary     | apisecret | 200                  | 400              | InvalidNonce | has not increased |
      | apikey | random | 0     |          | 29     | 10         | 13650 | buy  | exchange limit | immediate-or-cancel | primary     | apisecret | 200                  | 400              | InvalidNonce | has not increased |


#------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
