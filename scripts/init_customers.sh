#!/usr/bin/env bash

curl -H "Content-Type: application/json" -d "{ \
  \"name\":\"Sherlock Holmes\", \
  \"emailAddress\":\"sherlock@carlease.com\", \
  \"houseNumber\":\"221b\", \
  \"street\":\"Baker Street\", \
  \"place\":\"London\", \
  \"zipCode\":\"NW1 6XE\", \
  \"phoneNumber\":\"555-1234\" \
}" http://localhost:8080/customer/api/customers/