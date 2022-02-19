FROM golang:alpine as builder

RUN apk update && apk upgrade && apk add --no-cache curl git

RUN curl -s https://raw.githubusercontent.com/eficode/wait-for/master/wait-for -o /usr/bin/wait-for
RUN chmod +x /usr/bin/wait-for

###############################################################################

FROM google/cloud-sdk:alpine
ENV PUBSUB_PROJECT_ID local-pubsub
ARG CLOUDSDK_CORE_DISABLE_PROMPTS=1

COPY --from=builder /usr/bin/wait-for /usr/bin
COPY                pubsub.sh            /pubsub.sh

RUN apk --update add openjdk8-jre netcat-openbsd
RUN gcloud components install pubsub-emulator

EXPOSE 8085

CMD /pubsub.sh