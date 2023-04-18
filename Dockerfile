# Use the official Ubuntu image as the base image
FROM ubuntu:bionic-20230308

# Set the maintainer information
LABEL maintainer="HybridTestFramework dipjyotimetia@gmail.com"

# Define environment variables
ENV GRADLE_VERSION 8.1
ENV ALLURE_VERSION 2.21.0
ENV JAVA_HOME="/usr/lib/jvm/openjdk-17-jdk-amd64"
ENV PATH $JAVA_HOME/bin:$PATH

# Update the package list and install necessary packages
RUN apt-get -o Acquire::Check-Valid-Until=false update && \
    apt-get install -y openjdk-17-jdk vim wget curl zip unzip git python-pip python-dev build-essential

# Install Gradle
RUN wget https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip && \
    unzip gradle-${GRADLE_VERSION}-bin.zip && \
    mv gradle-${GRADLE_VERSION} /opt/ && \
    rm gradle-${GRADLE_VERSION}-bin.zip

ENV GRADLE_HOME /opt/gradle-${GRADLE_VERSION}
ENV PATH $PATH:$GRADLE_HOME/bin

# Install Allure
RUN curl -o allure-commandline-${ALLURE_VERSION}.tgz -Ls https://repo.maven.apache.org/maven2/io/qameta/allure/allure-commandline/${ALLURE_VERSION}/allure-commandline-${ALLURE_VERSION}.tgz && \
    tar -zxvf allure-commandline-${ALLURE_VERSION}.tgz -C /opt/ && \
    ln -s /opt/allure-${ALLURE_VERSION}/bin/allure /usr/bin/allure && \
    allure --version && \
    rm allure-commandline-${ALLURE_VERSION}.tgz

# Install Chrome
RUN wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb && \
    dpkg -i google-chrome-stable_current_amd64.deb || apt-get -fy install && \
    rm google-chrome-stable_current_amd64.deb

# Install Firefox
ARG FIREFOX_VERSION=latest
RUN FIREFOX_DOWNLOAD_URL=$(if [ $FIREFOX_VERSION = "latest" ] || [ $FIREFOX_VERSION = "nightly-latest" ] || [ $FIREFOX_VERSION = "devedition-latest" ]; then echo "https://download.mozilla.org/?product=firefox-$FIREFOX_VERSION-ssl&os=linux64&lang=en-US"; else echo "https://download-installer.cdn.mozilla.net/pub/firefox/releases/$FIREFOX_VERSION/linux-x86_64/en-US/firefox-$FIREFOX_VERSION.tar.bz2"; fi) \
  && apt-get update -qqy \
  && apt-get -qqy --no-install-recommends install firefox libavcodec-extra \
  && rm -rf /var/lib/apt/lists/* /var/cache/apt/* \
  && wget --no-verbose -O /tmp/firefox.tar.bz2 $FIREFOX_DOWNLOAD_URL \
  && apt-get -y purge firefox \
  && rm -rf /opt/firefox \
  && tar -C /opt -xjf /tmp/firefox.tar.bz2 \
  && rm /tmp/firefox.tar.bz2 \
  && mv /opt/firefox /opt/firefox-$FIREFOX_VERSION \
  && ln -fs /opt/firefox-$FIREFOX_VERSION/firefox /usr/bin/firefox

# Set the working directory
WORKDIR /app

# Copy the files and directories to the working directory
COPY . .
ADD ./scripts ./scripts
RUN chmod +x /app/gradlew
RUN chmod +x /app/scripts/**
RUN gradle wrapper

ENTRYPOINT ["./scripts/start.sh"]