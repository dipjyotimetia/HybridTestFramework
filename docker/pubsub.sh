#!/bin/sh

# Start the PubSub client in the background. It will poll for an open PubSub
# emulator port and create its topics and subscriptions when it's up.
#
# After it's done, port 8085 will be open to facilitate the wait-for and
# wait-for-it scripts.
(/usr/bin/wait-for localhost:8085 -- env PUBSUB_EMULATOR_HOST=localhost:8085 /usr/bin/pubsubc -debug; nc -lkp 8086 >/dev/null) &

# Start the PubSub emulator in the foreground.
gcloud beta emulators pubsub start --host-port=0.0.0.0:8085 "$@"