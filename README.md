# Car Lease Application

### Prerequisites
- Bash capable shell
- JDK 11 installed and configured in $JAVA_HOME
- Maven
- Docker installed and running
- Docker Compose installed
- Curl command installed

### Build

In the root of this project, execute

`mvn clean package`

### Run

In the root of this project, execute

`sudo docker-compose down && sudo docker-compose up --build`

_You may not need to use sudo, depending on how your docker / user permissions are configured_

Please wait for the docker compose to complete starting, there may be some `netflix` errors as the services attempt to contact the discovery server, I did not use health checks for this demo

### Initialize

In the root of this project, execute the database init scripts:

- `./scripts/init_cars.sh`
- `./scripts/init_customers.sh`

This will post records to the customer and car databases, through the API Gateway.
    
If there are errors, once again, it takes some time (not more than a minute or two) for the services to be completely available.

### Test

Navigate to any of the Swagger pages

- http://localhost:8080/customer/swagger-ui/
- http://localhost:8080/car/swagger-ui/
- http://localhost:8080/lease/swagger-ui/

You can then execute calls against the APIs from there.

For the Lease Rate Calculation, you can enter the following:

- make = `BMW`
- model = `XM`
- body =
```json
    {
      "mileage":45000,
      "duration":60,
      "interestRate": 0.045
    }
```

You will notice that the netPrice value of `63000` is configured on the vehicle in the database.

### Accomplished

- You can maintain (read, add, change, and delete) basic customer attributes (API Only)
- You can maintain basic car attributes (API only)
- Calculation of the Lease Rate
- service-2-service communication happens in the LeaseServiceImpl Bean, where it looks up the car service API and fetches the value from there.

### Missing

I did not manage to get the OAuth working. I'm sure if I had another few hours I would have got it!

I would have used a keycloak server, and the spring boot security mechanisms, with the authentication happening on the edge of the API Gateway.

I also did not create a UI.

I did not unit test every single piece of code, I focused on the calculation itself and testing some of the API endpoints

Hardly any javadocs, sorry!

### Bonus Objectives

- It is containerized
- There is a swagger (I could have made this better with time)
- The data is persistent in a MySQL database (also, I chose MySQL, but in retrospect I should have used Mongo)

### How I do this in real life?

Currently, I do this on AWS, using the Cloud Development Kit on Cloud Formation. I avoid using long running wherever possible, preferring serverless solutions.

I would have liked to demo that, but one of the requirements was Spring Boot, and I have zero experience using it with AWS, but I'd love to learn!