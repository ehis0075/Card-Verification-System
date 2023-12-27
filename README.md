                        #Card Verification Microservice

This Spring Boot microservice is designed to provide users with information about their credit/debit card details.
The service utilizes a third-party API (https://binlist.net) to gather information about card schemes, validity,
and associated banks.

Features

    1. Card Verification Endpoint
         Endpoint: GET http://localhost:8080/card-scheme/verify/{bin}
         Description: Verify the card details for a given card number.
       
    2. Number of Hits Statistics Endpoint
         Endpoint: GET http://localhost:8080/card-scheme/stats?start={start}&limit={limit}
         Description: Retrieve statistics on the number of hits for different card numbers.

    3. User sign up Endpoint
         Endpoint: GET http://localhost:8080//api/v1/customers/create
         Description: to create a customer

