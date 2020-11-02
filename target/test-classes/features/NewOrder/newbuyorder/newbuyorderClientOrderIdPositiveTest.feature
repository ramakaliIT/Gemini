
@NewOrder @NewBuyOrder @client_order_id  @Positive
Feature:testing the client order id boundary values in neworder module

  Background:user enters standard new buy order datas

    #this initiliaze, request,cache, content-type parameters automatically filled
    Given user enters new order fixed valid datas

  Scenario Outline:TC_00004_user should be able to place places a successful order than places another order with the same client order id
    Then user enters a valid APIKey "<apikey>"

      #This function gets a symbol randomly from the list of available symbols
    Then user enters a valid symbol "<symbol>"
    Then user enters a valid nonce <nonce>
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
    Then system creates payload and signatures
    When user posts the new buy order request
    Then user verifies status code is <successfulstatuscode>

      # user creates a new nonce but do not change the previous client_order_id
    Then user enters a valid nonce <nonce>
    Then system creates payload and signatures
    When user posts the new buy order request
    Then user verifies status code is <successfulstatuscode>

    Examples:

        # client_order_id, nonce--> "none" means no entry , empty or 0 means automatic generation
        # apikey,apisecret -- > write "none" to leave empty, noway to leave blank---------- no try-catch block inserted

      | apikey | symbol | nonce | order_id | amount | min_amount | price | side | type           | options             | accountname | apisecret | successfulstatuscode |
      | apikey | random | 0     |          | 10     | 8          | 500   | buy  | exchange limit | immediate-or-cancel | primary     | apisecret | 200                  |
      | apikey | random | 0     |          | 8      | 5          | 250   | buy  | exchange limit |                     | primary     | apisecret | 200                  |
      | apikey | random | 0     |          | 6      | 4          | 125   | buy  | exchange limit | fill-or-kill        | primary     | apisecret | 200                  |
