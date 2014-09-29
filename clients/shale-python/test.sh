#!/bin/bash

cleanup() {
    kill $(jobs -pr)

    # Workaround for bug in Flask in Python 2
    # https://github.com/mitsuhiko/flask/issues/988
    kill $(fuser -n tcp 5000 2> /dev/null)
}

trap "cleanup" EXIT

cd ../..

PATH="$PATH:$PWD/phantomjs/bin/"

sleep 1

java -jar selenium -role node \
  -nodeConfig nodeConfig.json \
  -port 5555 &

java -jar selenium -role node \
  -nodeConfig nodeConfig.json \
  -port 5554 &

lein run &

cd clients/shale-python

sleep 2
nosetests
STATUS=$?

exit $STATUS