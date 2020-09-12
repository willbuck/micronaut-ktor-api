#!/bin/sh
docker docker build -t micronaut-api-jvm -f Dockerfile.jvm .
echo
echo
echo "To run the docker container execute:"
echo "    $ docker run -p 8080:8080 micronaut-api"