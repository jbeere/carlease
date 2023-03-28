#!/usr/bin/env bash

curl -H "Content-Type: application/json" -d "{ \
  \"mileage\":45000, \
  \"duration\":60, \
  \"interestRate\": 0.045 \
}" http://localhost:8080/lease/api/lease/car/BMW/XM/rate