#!/usr/bin/env bash

curl -X POST http://localhost:3000/realms/carlease-realm/protocol/openid-connect/token \
  -H "Content-Type: application/x-www-form-urlencoded" \
  -d "client_id=carlease-app&username=customer1&password=customer123&grant_type=password"