# HybridTestFramewrok
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/2ffd9c97725645c2bcda860988dc0baf)](https://www.codacy.com/app/dipjyotimetia/HybridTestFramewrok?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=TestautoDev/HybridTestFramewrok&amp;utm_campaign=Badge_Grade)

[![CircleCI](https://circleci.com/gh/TestautoDev/HybridTestFramewrok/tree/master.svg?style=svg)](https://circleci.com/gh/TestautoDev/HybridTestFramewrok/tree/master)

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

Selenium traffic will go through ZAP proxy in order to capture all traffic. It's not exactly necessary for the bodgeit shop, but in real-world applications spider would struggle to find URLs requiring logged in access.

Report:
<img src="https://github.com/dipjyotimetia/screenshots/blob/master/security/zapReport.png" width="300">

```
$ docker-compose up -d
```
Scaling up Chrome nodes
```
$ docker-compose scale chrome=5
```

### Spawns four additional node-chrome instances linked to the hub
Scaling up Firefox nodes  

```
$ docker-compose scale firefox=5
```  

### Spawns four additional node-firefox instances linked to the hub   
