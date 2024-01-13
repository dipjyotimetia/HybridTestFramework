# Project Setup

* Install IntelliJ IDEA
  https://www.jetbrains.com/idea/download/
* Install docker desktop
  https://www.docker.com/products/docker-desktop
* Java JDK_17  
  https://adoptium.net/temurin/releases/?version=17
* Gradle
  https://gradle.org/next-steps/?version=8.5&format=bin
* Allure
  https://github.com/allure-framework/allure2/archive/2.25.0.zip
* Set Environment variables
    * JAVA_HOME: Pointing to the Java SDK folder\bin
    * GRADLE_HOME: Pointing to Gradle directory\bin.
    * ALLURE_HOME: Pointing to allure directory\bin.

## Java 17 JDK Installation and config

* Download Java 17 JDK from [here](https://adoptium.net/temurin/releases/?version=17)
* Install downloaded Java 17 JDK.
* System Properties -> Environment Variables -> System Variables -> New -> `JAVA_HOME` and Value
  as `C:\Program Files\Eclipse Adoptium\jdk-17.0.9` (path where JDK is installed)
* System Properties -> Environment Variables -> System Variables -> Select `Path` and Edit -> Add `%JAVA_HOME%\bin`
* Once Environment variables are configured, open command prompt and run `java -v` and `echo $JAVA_HOME` to check
  whether java version installed is returned. e.g <br/>
  `$ java -version`<br/>
  `$ openjdk 17.0.9 2023-10-17<br/>
  OpenJDK Runtime Environment Temurin-17.0.9+9 (build 17.0.9+9)<br/>
  OpenJDK 64-Bit Server VM Temurin-17.0.9+9 (build 17.0.9+9, mixed mode, sharing)`

## Recommended IDE

* Please install Community Edition of `IntelliJ IDEA`
  from [here](https://www.jetbrains.com/idea/download/#section=windows)

### Getting Started

```shell script
$ git clone 
$ cd 
$ import project from intellij as a gradle project
$ gradle clean
$ gradle build
$ gradle task web
$ gradle task mobile
$ gradle allureReport
$ gradle allureServe
```

### Spawns chrome, firefox, selenium hub and OWASP proxy server

```shell script
$ docker-compose up -d
```

### Complete infrastructure creation for local run

```shell script
$ $ docker-compose -f docker-compose-infra up -d
```

### Spawns four additional node-chrome/firefox instances linked to the hub

```shell script
$ docker-compose scale chrome=5
$ docker-compose scale firefox=5
```

Error Handle for dynamic classpath error in intellij:
Search and modify the below line in .idea workspace.xml

```xml

<component name="PropertiesComponent">
    <property name="dynamic.classpath" value="true"/>
</component>
``` 

### Security ZAP Testing

[OWASP ZAP](https://www.owasp.org/index.php/OWASP_Zed_Attack_Proxy_Project)
Download it from [Github](https://github.com/zaproxy/zaproxy/wiki/Downloads)

- Run it
- Configure proxy: Tools -> Options -> Local Proxies. Set port to 8888
- Get API key from your ZAP instance: Tools -> Options -> API

Vulnerable application - system under test

- Install docker and run docker service
- Run bodgeit docker container (or any app)
- Make sure it's running on http://localhost:8080/bodgeit/

Selenium traffic will go through ZAP proxy in order to capture all traffic. It's not exactly necessary for the bodgeit
shop, but in real-world applications spider would struggle to find URLs requiring logged in access.
