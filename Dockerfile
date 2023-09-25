# Use the latest Ubuntu image as the base image
FROM ubuntu:jammy

# Set the maintainer information
LABEL maintainer="HybridTestFramework dipjyotimetia@gmail.com"

# Set the default user
USER appuser

# Define environment variables
ENV GRADLE_VERSION 8.3
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
RUN apt-get update -qqy \
  && apt-get install -qqy --no-install-recommends firefox libavcodec-extra \
  && rm -rf /var/lib/apt/lists/* /var/cache/apt/*

# Set the working directory
WORKDIR /app

# Copy the files and directories to the working directory
COPY . .
ADD ./scripts ./scripts
RUN chmod +x /app/gradlew
RUN chmod +x /app/scripts/**
RUN gradle wrapper

ENTRYPOINT ["./scripts/start.sh"]