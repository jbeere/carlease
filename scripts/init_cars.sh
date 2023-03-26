#!/usr/bin/env bash

curl -H "Content-Type: application/json" -d "{ \
  \"make\":\"BMW\", \
  \"model\":\"XM\", \
  \"version\":\"1.0\", \
  \"doorCount\":5, \
  \"co2Emissions\":90.0, \
  \"grossPrice\":150000, \
  \"nettPrice\":200000 \
}" http://localhost/car/api/cars/