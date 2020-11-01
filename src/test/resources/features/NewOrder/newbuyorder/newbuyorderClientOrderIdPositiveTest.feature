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
Then user verifies status code is <failedstatuscode>, reason is "<reason>" and message is "<message>"

Examples:
          # Client_O_I, nonce--> "none" no means no entry , no value means automatic generation
        # apikey,apisecret -- > write "none" to leave empty, noway to leave blank----------
| apikey | symbol | nonce | order_id | amount | min_amount | price | side | type           | options             | accountname | apisecret | successfulstatuscode | failedstatuscode | reason       | message           |
| apikey | random | 0     |          | 17     | 8          | 13650 | buy  | exchange limit | immediate-or-cancel | primary     | apisecret | 200                  | 200              | InvalidNonce | has not increased |
| apikey | random | 0     |          | 38     | 7          | 13650 | buy  | exchange limit |                     | primary     | apisecret | 200                  | 200              | InvalidNonce | has not increased |
| apikey | random | 0     |          | 29     | 10         | 13650 | buy  | exchange limit | fill-0r-kill        | primary     | apisecret | 200                  | 200              | InvalidNonce | has not increased |
