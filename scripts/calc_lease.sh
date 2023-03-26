#!/usr/bin/env bash

curl -H "Content-Type: application/json" -d "{ \
  \"mileage\":30, \
  \"duration\":1, \
  \"interestRate\": 14.5 \
}" http://localhost/lease/api/lease/car/BMW/XM/rate