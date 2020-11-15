#!/bin/sh
./gradlew build
docker build . -t micronaut-api
echo
echo
echo "To run the docker container execute:"
echo "    $ docker run -p 8080:8080 micronaut-api"
