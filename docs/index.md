# HybridTestFramework

### Architecture
![Selenium](https://github.com/dipjyotimetia/HybridTestFramework/blob/master/docs/screens/selenium.png)

### Supported Platforms
This framework supports WebUi automation across a variety of browsers like Chrome, Firefox, IE, no only limited to this but extended to test rest api, security and visual testing.

### Capabilities
* Cross browser testing support
* Added browserstack support for CrossBrowser testing
* Running tests in docker containers selenium grid
* Running tests in AWS DeviceFarm selenium grid
* Running tests in selenium server in docker containers
* Security testing using OWASP, running in docker container
* Api testing support using RestAssured
* Visual regression testing using percy.io
* Accessibility testing using axe-selenium
* Stubbed api testing using WireMock
* Can send logs to ElasticSearch for kibana dashboard visualization
* Database testing support(Coming Soon...)
* Kubernetes support(Coming soon...)

### Setup & Tools
* Install intellij
  https://www.jetbrains.com/idea/download/
* Install docker desktop
  https://www.docker.com/products/docker-desktop
* Java JDK_11  
  https://adoptopenjdk.net/ or any latest version.
* Gradle
  https://gradle.org/next-steps/?version=6.4&format=bin
* Allure
  https://github.com/allure-framework/allure2/archive/2.13.3.zip
* Set Environment variables
    * JAVA_HOME: Pointing to the Java SDK folder\bin
    * GRADLE_HOME: Pointing to Gradle directory\bin.
    * ALLURE_HOME: Pointing to allure directory\bin.

### Getting Started
```shell script
$ git clone 
$ cd 
$ import project from intellij as a gradle project
$ gradle clean
$ gradle build
$ gradle task E2E
$ gradle allureReport
$ gradle allureServe
```

### Write your first user journey
Create new class and name as the TC00*_E2E_TEST-***
- Provide jira link in @Link
- Provide all the api components as @Feature
- Provide test severity and description
- Write test
- Use CatchBlock in try/catch section

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
    <property name="dynamic.classpath" value="true" />
</component>
```    

### JenkinsExecution
![image](https://github.com/dipjyotimetia/HybridTestFramework/blob/master/docs/screens/jenkinsExecution.png)

### GridServer 2.0
![image](https://github.com/dipjyotimetia/HybridTestFramework/blob/master/docs/screens/seleniumGrid.png)

### Allure Reporting
![image](https://github.com/dipjyotimetia/HybridTestFramework/blob/master/docs/screens/allureReport.png)

### Gradle Report
![image](https://github.com/dipjyotimetia/HybridTestFramework/blob/master/docs/screens/gradleReport.png)

### TestResults
![image](https://github.com/dipjyotimetia/HybridTestFramework/blob/master/docs/screens/testResults.png)

### BrowserStack Dashboard
![image](https://github.com/dipjyotimetia/HybridTestFramework/blob/master/docs/screens/browserStack.png)

### LogsView
![image](https://github.com/dipjyotimetia/HybridTestFramework/blob/master/docs/screens/logs.png)      
