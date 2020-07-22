# base image
FROM ubuntu:bionic-20200311

LABEL maintainer="HybridTestFramework dipjyotimetia@gmail.com"

ENV GRADLE_VERSION 6.5.1
ENV ALLURE_VERSION 2.13.5

# install packages
RUN apt-get -o Acquire::Check-Valid-Until=false update
RUN apt-get install -y openjdk-8-jdk vim wget curl zip unzip git python-pip python-dev build-essential

# Install Gradle
RUN wget https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip && \
    unzip gradle-${GRADLE_VERSION}-bin.zip && \
    mv gradle-${GRADLE_VERSION} /opt/ && \
    rm gradle-${GRADLE_VERSION}-bin.zip
ENV GRADLE_HOME /opt/gradle-${GRADLE_VERSION}
ENV PATH $PATH:$GRADLE_HOME/bin

RUN echo "export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64" >> ~/.bashrc

ENV JAVA_HOME="/usr/lib/jvm/java-8-openjdk-amd64/jre"
ENV PATH $JAVA_HOME/bin:$PATH

# Install allure
RUN curl -o allure-commandline-${ALLURE_VERSION}.tgz -Ls https://dl.bintray.com/qameta/maven/io/qameta/allure/allure-commandline/${ALLURE_VERSION}/allure-commandline-${ALLURE_VERSION}.tgz && \
    tar -zxvf allure-commandline-${ALLURE_VERSION}.tgz -C /opt/ && ln -s /opt/allure-${ALLURE_VERSION}/bin/allure /usr/bin/allure && allure --version

# Install Chrome
RUN wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
RUN dpkg -i google-chrome-stable_current_amd64.deb; apt-get -fy install

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

USER root
#
#COPY . .
#
#RUN gradle clean
#RUN gradle task e2e

#docker build -t hybridtestframework:1.0 .
#docker tag hybridtestframework:1.0 docker.pkg.github.com/dipjyotimetia/hybridtestframewrok/hybridtestframework:1.0
#docker push docker.pkg.github.com/dipjyotimetia/hybridtestframewrok/hybridtestframework:1.0
