#!/bin/bash

#Start web test
./gradlew task web

#Start mobile test
./gradlew task mobile

#Start api test
./gradlew task api