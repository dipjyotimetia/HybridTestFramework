# HybridTestFramework

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/2ffd9c97725645c2bcda860988dc0baf)](https://www.codacy.com/gh/dipjyotimetia/HybridTestFramework/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=dipjyotimetia/HybridTestFramework&amp;utm_campaign=Badge_Grade)
[![This project is using Percy.io for visual regression testing.](https://percy.io/static/images/percy-badge.svg)](https://percy.io/CypressTest/Selenium)
[![CI](https://github.com/dipjyotimetia/HybridTestFramework/actions/workflows/gradle.yml/badge.svg)](https://github.com/dipjyotimetia/HybridTestFramework/actions/workflows/gradle.yml)
[![Discord Chat](https://www.vectorlogo.zone/logos/discordapp/discordapp-ar21.svg)](https://discord.gg/eE3gjXqXHx)   
[![SupportedBy JetBrains](https://github.com/TestautoDev/Tricks-And-Tips/blob/master/jetbrains.svg)](https://www.jetbrains.com/?from=HybridTestFramework)

In the era of [cloud-native](https://docs.microsoft.com/en-us/dotnet/architecture/cloud-native/definition) world we
cannot stick to a particular framework, however due to projects requirement we often need to evolve the existing testing
solution in such a way so that it can cater multiple testing requirement,
hence [HybridTestFramework](https://github.com/dipjyotimetia/HybridTestFramework) is targeting to create a bridge
between the kind of legacy systems
or the systems which are still in a transition phase of migrate to cloud with super cool cloud-native systems.
Ita comprehensive and versatile testing framework designed to cover various aspects of software testing.
Its purpose is to help developers and testers streamline their testing process and ensure the highest quality in their
applications.

<img src="docs/img/framework.png" width="900">

### Framework Capabilities

* Cross browser testing support.
* Added browserstack support for CrossBrowser testing.
* Running tests in docker containers selenium grid.
* Running tests in AWS DeviceFarm selenium grid.
* Running tests in selenium server in docker containers.
* Security testing using OWASP, running in docker container.
* Rest Api and GraphQL testing support powered by RestAssured.
* gRPC api testing support using native gRPC=java library.
* Event driven microservice testing based on pubsub model.
* Support for Kafka, Cloud Pubsub, AWS SNS testing and continue evolving.
* Visual regression testing using percy.io.
* Accessibility testing using axe-selenium.
* Stubbed api testing using WireMock.
* Logging integration with ElasticSearch for Kibana dashboard visualization
* Database testing support.
* Kubernetes support.

### Setup & Tools

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

### Getting Started

```shell script
git clone 
cd 
# import project from intellij as a gradle project
gradle clean
gradle build
gradle task api
gradle task web
gradle task mobile
gradle allureReport
gradle allureServe
```

### Write your first user journey

Create new class and name as the TC00*_E2E_TEST-***

- Provide jira link in @Link
- Provide all the api components as @Feature
- Provide test severity and description
- Write test
- Use CatchBlock in try/catch section

### Spin-up chrome, firefox, selenium hub and OWASP proxy server

```shell script
docker-compose up -d
```

### Complete infrastructure creation for local run

```shell script
docker-compose -f docker-compose-infra up -d
```

### Spin-up four additional node-chrome/firefox instances linked to the hub

```shell script
docker-compose scale chrome=5
docker-compose scale firefox=5
```

### Spin-up kafka instances

```shell
docker-compose -f docker-compose-kafka.yml up
docker-compose -f docker-compose-kafka.yml down --rmi all
```

### Spin-up selenium hub in kubernetes instance

```shell
kubectl apply -f selenium-k8s-deploy-svc.yaml
kubectl apply -f https://raw.githubusercontent.com/kubernetes/dashboard/v2.5.0/aio/deploy/recommended.yaml
kubectl proxy
kubectl describe secret -n kube-system | grep deployment -A 12
## To delete deployments
kubectl delete deployment selenium-node-firefox
kubectl delete deployment selenium-node-chrome
kubectl delete deployment selenium-hub
```

navigate
to `http://localhost:8001/api/v1/namespaces/kubernetes-dashboard/services/https:kubernetes-dashboard:/proxy/`   
<img src="https://github.com/dipjyotimetia/HybridTestFramework/blob/master/docs/img/kubernetes.png" width="800">

### Browserstack Execution Gif

![browserstack](https://github.com/dipjyotimetia/HybridTestFramework/blob/master/docs/gif/videogif.gif)
