#!/bin/bash

./gradlew build -x test
docker-compose up -d --build