# AutomationsApi

All URIs are relative to *https://api.zephyrscale.smartbear.com/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createCucumberExecutions**](AutomationsApi.md#createCucumberExecutions) | **POST** /automations/executions/cucumber | Cucumber format
[**createCustomExecutions**](AutomationsApi.md#createCustomExecutions) | **POST** /automations/executions/custom | Custom format
[**createJUnitExecutions**](AutomationsApi.md#createJUnitExecutions) | **POST** /automations/executions/junit | JUnit XML format
[**retrieveBDDTestCases**](AutomationsApi.md#retrieveBDDTestCases) | **GET** /automations/testcases | Retrieve a zip file containing Cucumber Feature Files that matches the query passed as parameter.


<a name="createCucumberExecutions"></a>
# **createCucumberExecutions**
> AutomationResult createCucumberExecutions(projectKey, contentLength, _file, autoCreateTestCases, testCycle)

Cucumber format

Create results using the Cucumber results format.

### Example
```java
// Import classes:
import org.openapi.zephyr.invoker.ApiClient;
import org.openapi.zephyr.invoker.ApiException;
import org.openapi.zephyr.invoker.Configuration;
import org.openapi.zephyr.invoker.auth.*;
import org.openapi.zephyr.invoker.models.*;
import org.openapi.zephyr.api.AutomationsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.zephyrscale.smartbear.com/v2");
    
    // Configure API key authorization: AccessToken
    ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
    AccessToken.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AccessToken.setApiKeyPrefix("Token");

    AutomationsApi apiInstance = new AutomationsApi(defaultClient);
    String projectKey = "projectKey_example"; // String | Jira project key filter
    Integer contentLength = 56; // Integer | The content-length header indicates the size of the message body, in bytes. https://datatracker.ietf.org/doc/html/rfc7230#section-3.3.2
    File _file = new File("/path/to/file"); // File | 
    Boolean autoCreateTestCases = false; // Boolean | Indicate if test cases should be created if non existent.
    AutomationTestCycleInput testCycle = new AutomationTestCycleInput(); // AutomationTestCycleInput | 
    try {
      AutomationResult result = apiInstance.createCucumberExecutions(projectKey, contentLength, _file, autoCreateTestCases, testCycle);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AutomationsApi#createCucumberExecutions");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectKey** | **String**| Jira project key filter |
 **contentLength** | **Integer**| The content-length header indicates the size of the message body, in bytes. https://datatracker.ietf.org/doc/html/rfc7230#section-3.3.2 |
 **_file** | **File**|  |
 **autoCreateTestCases** | **Boolean**| Indicate if test cases should be created if non existent. | [optional] [default to false]
 **testCycle** | [**AutomationTestCycleInput**](AutomationTestCycleInput.md)|  | [optional]

### Return type

[**AutomationResult**](AutomationResult.md)

### Authorization

[AccessToken](../README.md#AccessToken)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  * Access-Control-Allow-Headers -  <br>  * Access-Control-Allow-Methods -  <br>  * Access-Control-Allow-Origin -  <br>  |
**0** | An error has occurred. Please check the code and the error message. |  * Access-Control-Allow-Headers -  <br>  * Access-Control-Allow-Methods -  <br>  * Access-Control-Allow-Origin -  <br>  |

<a name="createCustomExecutions"></a>
# **createCustomExecutions**
> AutomationResult createCustomExecutions(projectKey, contentLength, _file, autoCreateTestCases, testCycle)

Custom format

Create results using Zephyr Scale&#39;s custom results format.

### Example
```java
// Import classes:
import org.openapi.zephyr.invoker.ApiClient;
import org.openapi.zephyr.invoker.ApiException;
import org.openapi.zephyr.invoker.Configuration;
import org.openapi.zephyr.invoker.auth.*;
import org.openapi.zephyr.invoker.models.*;
import org.openapi.zephyr.api.AutomationsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.zephyrscale.smartbear.com/v2");
    
    // Configure API key authorization: AccessToken
    ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
    AccessToken.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AccessToken.setApiKeyPrefix("Token");

    AutomationsApi apiInstance = new AutomationsApi(defaultClient);
    String projectKey = "projectKey_example"; // String | Jira project key filter
    Integer contentLength = 56; // Integer | The content-length header indicates the size of the message body, in bytes. https://datatracker.ietf.org/doc/html/rfc7230#section-3.3.2
    File _file = new File("/path/to/file"); // File | 
    Boolean autoCreateTestCases = false; // Boolean | Indicate if test cases should be created if non existent.
    AutomationTestCycleInput testCycle = new AutomationTestCycleInput(); // AutomationTestCycleInput | 
    try {
      AutomationResult result = apiInstance.createCustomExecutions(projectKey, contentLength, _file, autoCreateTestCases, testCycle);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AutomationsApi#createCustomExecutions");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectKey** | **String**| Jira project key filter |
 **contentLength** | **Integer**| The content-length header indicates the size of the message body, in bytes. https://datatracker.ietf.org/doc/html/rfc7230#section-3.3.2 |
 **_file** | **File**|  |
 **autoCreateTestCases** | **Boolean**| Indicate if test cases should be created if non existent. | [optional] [default to false]
 **testCycle** | [**AutomationTestCycleInput**](AutomationTestCycleInput.md)|  | [optional]

### Return type

[**AutomationResult**](AutomationResult.md)

### Authorization

[AccessToken](../README.md#AccessToken)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  * Access-Control-Allow-Headers -  <br>  * Access-Control-Allow-Methods -  <br>  * Access-Control-Allow-Origin -  <br>  |
**0** | An error has occurred. Please check the code and the error message. |  * Access-Control-Allow-Headers -  <br>  * Access-Control-Allow-Methods -  <br>  * Access-Control-Allow-Origin -  <br>  |

<a name="createJUnitExecutions"></a>
# **createJUnitExecutions**
> AutomationResult createJUnitExecutions(projectKey, contentLength, _file, autoCreateTestCases, testCycle)

JUnit XML format

Create results using the JUnit XML results format. Optionally, you can send a &#x60;testCycle&#x60; part in your form data to customize the created test cycle.

### Example
```java
// Import classes:
import org.openapi.zephyr.invoker.ApiClient;
import org.openapi.zephyr.invoker.ApiException;
import org.openapi.zephyr.invoker.Configuration;
import org.openapi.zephyr.invoker.auth.*;
import org.openapi.zephyr.invoker.models.*;
import org.openapi.zephyr.api.AutomationsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.zephyrscale.smartbear.com/v2");
    
    // Configure API key authorization: AccessToken
    ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
    AccessToken.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AccessToken.setApiKeyPrefix("Token");

    AutomationsApi apiInstance = new AutomationsApi(defaultClient);
    String projectKey = "projectKey_example"; // String | Jira project key filter
    Integer contentLength = 56; // Integer | The content-length header indicates the size of the message body, in bytes. https://datatracker.ietf.org/doc/html/rfc7230#section-3.3.2
    File _file = new File("/path/to/file"); // File | 
    Boolean autoCreateTestCases = false; // Boolean | Indicate if test cases should be created if non existent.
    AutomationTestCycleInput testCycle = new AutomationTestCycleInput(); // AutomationTestCycleInput | 
    try {
      AutomationResult result = apiInstance.createJUnitExecutions(projectKey, contentLength, _file, autoCreateTestCases, testCycle);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AutomationsApi#createJUnitExecutions");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectKey** | **String**| Jira project key filter |
 **contentLength** | **Integer**| The content-length header indicates the size of the message body, in bytes. https://datatracker.ietf.org/doc/html/rfc7230#section-3.3.2 |
 **_file** | **File**|  |
 **autoCreateTestCases** | **Boolean**| Indicate if test cases should be created if non existent. | [optional] [default to false]
 **testCycle** | [**AutomationTestCycleInput**](AutomationTestCycleInput.md)|  | [optional]

### Return type

[**AutomationResult**](AutomationResult.md)

### Authorization

[AccessToken](../README.md#AccessToken)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  * Access-Control-Allow-Headers -  <br>  * Access-Control-Allow-Methods -  <br>  * Access-Control-Allow-Origin -  <br>  |
**0** | An error has occurred. Please check the code and the error message. |  * Access-Control-Allow-Headers -  <br>  * Access-Control-Allow-Methods -  <br>  * Access-Control-Allow-Origin -  <br>  |

<a name="retrieveBDDTestCases"></a>
# **retrieveBDDTestCases**
> File retrieveBDDTestCases(projectKey, accept)

Retrieve a zip file containing Cucumber Feature Files that matches the query passed as parameter.

### Example
```java
// Import classes:
import org.openapi.zephyr.invoker.ApiClient;
import org.openapi.zephyr.invoker.ApiException;
import org.openapi.zephyr.invoker.Configuration;
import org.openapi.zephyr.invoker.auth.*;
import org.openapi.zephyr.invoker.models.*;
import org.openapi.zephyr.api.AutomationsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.zephyrscale.smartbear.com/v2");
    
    // Configure API key authorization: AccessToken
    ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
    AccessToken.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AccessToken.setApiKeyPrefix("Token");

    AutomationsApi apiInstance = new AutomationsApi(defaultClient);
    String projectKey = "projectKey_example"; // String | Jira project key filter
    String accept = "application/zip"; // String | 
    try {
      File result = apiInstance.retrieveBDDTestCases(projectKey, accept);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AutomationsApi#retrieveBDDTestCases");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectKey** | **String**| Jira project key filter |
 **accept** | **String**|  | [enum: application/zip]

### Return type

[**File**](File.md)

### Authorization

[AccessToken](../README.md#AccessToken)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/zip, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | A Zip file containing BDD feature files |  * Access-Control-Allow-Headers -  <br>  * Access-Control-Allow-Methods -  <br>  * Access-Control-Allow-Origin -  <br>  |
**0** | An error has occurred. Please check the code and the error message. |  * Access-Control-Allow-Headers -  <br>  * Access-Control-Allow-Methods -  <br>  * Access-Control-Allow-Origin -  <br>  |

