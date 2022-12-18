# inditex-test
Backend technical test Inditex 

Microservice developed with SpringBoot + OpenApi 3. This microservice has an h2 embeded database and consume that with JPA.

Only have one endpoint, this endpoint has the functionality of filter information from database, using a scoring generated by sales and sizes of clothes.

Tests implemented with Mockito and Junit 5.



Curl example for test on local deploy: 

curl -X 'GET' \
  'http://localhost:8080/clothes' \
  -H 'accept: application/json'
