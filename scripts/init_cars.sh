#!/usr/bin/env bash

curl -H "Content-Type: application/json" -d "{ \
  \"make\":\"BMW\", \
  \"model\":\"XM\", \
  \"version\":\"1.0\", \
  \"doorCount\":5, \
  \"co2Emissions\":90.0, \
  \"grossPrice\":61000, \
  \"nettPrice\":63000 \
}" http://localhost:8080/car/api/cars/