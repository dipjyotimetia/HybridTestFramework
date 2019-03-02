FROM java:8

RUN  \
  export DEBIAN_FRONTEND=noninteractive && \
  sed -i 's/# \(.*multiverse$\)/\1/g' /etc/apt/sources.list && \
  apt-get update && \
  apt-get -y upgrade && \
  apt-get install -y vim wget curl git python-pip python-dev build-essential

RUN wget -q https://services.gradle.org/distributions/gradle-4.10-bin.zip \
    && unzip gradle-4.10-bin.zip -d /opt \
    && rm gradle-4.10-bin.zip

RUN pip install --upgrade pip \
        && apt-get update \
	&& apt-get install -y git x11vnc

ENV GRADLE_HOME /opt/gradle-4.10
ENV PATH $PATH:/opt/gradle-4.10/bin

RUN echo "export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64" >> ~/.bashrc

ENV JAVA_HOME="/usr/lib/jvm/java-8-openjdk-amd64/jre"
ENV PATH $JAVA_HOME/bin:$PATH

COPY /src /app/src
COPY /Driver /app/Driver
COPY /gradle /app/gradle
COPY /Reports /app/Reports
COPY /build.gradle /app/build.gradle
COPY /docker-compose.yml /app/docker-compose.yml
COPY /gradle.properties /app/gradle.properties
COPY /settings.gradle /app/settings.gradle

WORKDIR /app

EXPOSE 5920

#RUN gradle build
RUN gradle task e2e