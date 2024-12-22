# HybridTestFramework

### Architecture

![Selenium](img/framework.png)

In the era of [cloud-native](https://docs.microsoft.com/en-us/dotnet/architecture/cloud-native/definition) solutions,
we often need to evolve existing testing frameworks to cater to multiple requirements. 
[HybridTestFramework](https://github.com/dipjyotimetia/HybridTestFramework) bridges legacy systems or those 
still transitioning to the cloud with modern cloud-native systems.  
Following a [testing pyramid](https://martinfowler.com/articles/practical-test-pyramid.html) approach,
the framework emphasizes API testing followed by Web UI. Future releases will focus even more on API and event-based testing.

### Framework Capabilities

* Cross-browser testing support (including BrowserStack).
* Docker-based Selenium grid (local or AWS DeviceFarm).
* Security testing powered by OWASP in Docker containers.
* REST and GraphQL testing with RestAssured.
* gRPC testing via gRPC Java library.
* Event-driven microservice testing (Kafka, Cloud Pub/Sub, AWS SNS).
* Visual regression testing with percy.io.
* Accessibility testing using axe-selenium.
* Stubbed API testing using WireMock.
* Integrated Elasticsearch logging for dashboards.
* Database testing support.
* Kubernetes support.

### GitHub Actions Execution

![image](img/githubAction.png)

### Allure Reporting

![image](img/allureReport.png)

### BrowserStack Dashboard

![image](img/browserStack.png)