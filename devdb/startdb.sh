#!/bin/bash

docker run --rm \
	--env POSTGRES_USER=frankenstein \
	--env POSTGRES_PASSWORD=asdfasdf \
	--env POSTGRES_DB=frankenstein \
	-p 15234:5432 \
	postgres:9.6
