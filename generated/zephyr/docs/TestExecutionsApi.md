# TestExecutionsApi

All URIs are relative to *https://api.zephyrscale.smartbear.com/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createTestExecution**](TestExecutionsApi.md#createTestExecution) | **POST** /testexecutions | Create test execution
[**createTestExecutionIssueLink**](TestExecutionsApi.md#createTestExecutionIssueLink) | **POST** /testexecutions/{testExecutionIdOrKey}/links/issues | Create issue links
[**getTestExecution**](TestExecutionsApi.md#getTestExecution) | **GET** /testexecutions/{testExecutionIdOrKey} | Get test execution
[**listTestExecutionLinks**](TestExecutionsApi.md#listTestExecutionLinks) | **GET** /testexecutions/{testExecutionIdOrKey}/links | Get links
[**listTestExecutions**](TestExecutionsApi.md#listTestExecutions) | **GET** /testexecutions | Get test executions


<a name="createTestExecution"></a>
# **createTestExecution**
> createTestExecution(testExecutionInput)

Create test execution

Creates a test execution. All required test execution custom fields should be present in the request.

### Example
```java
// Import classes:
import org.openapi.zephyr.invoker.ApiClient;
import org.openapi.zephyr.invoker.ApiException;
import org.openapi.zephyr.invoker.Configuration;
import org.openapi.zephyr.invoker.auth.*;
import org.openapi.zephyr.invoker.models.*;
import org.openapi.zephyr.api.TestExecutionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.zephyrscale.smartbear.com/v2");
    
    // Configure API key authorization: AccessToken
    ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
    AccessToken.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AccessToken.setApiKeyPrefix("Token");

    TestExecutionsApi apiInstance = new TestExecutionsApi(defaultClient);
    TestExecutionInput testExecutionInput = new TestExecutionInput(); // TestExecutionInput | Web Link Input
    try {
      apiInstance.createTestExecution(testExecutionInput);
    } catch (ApiException e) {
      System.err.println("Exception when calling TestExecutionsApi#createTestExecution");
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
 **testExecutionInput** | [**TestExecutionInput**](TestExecutionInput.md)| Web Link Input |

### Return type

null (empty response body)

### Authorization

[AccessToken](../README.md#AccessToken)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Created |  * Access-Control-Allow-Headers -  <br>  * Access-Control-Allow-Methods -  <br>  * Access-Control-Allow-Origin -  <br>  * location - URL of the created link <br>  |
**0** | An error has occurred. Please check the code and the error message. |  * Access-Control-Allow-Headers -  <br>  * Access-Control-Allow-Methods -  <br>  * Access-Control-Allow-Origin -  <br>  |

<a name="createTestExecutionIssueLink"></a>
# **createTestExecutionIssueLink**
> createTestExecutionIssueLink(testExecutionIdOrKey, issueLinkInput)

Create issue links

Creates a link between a test execution and a Jira issue.

### Example
```java
// Import classes:
import org.openapi.zephyr.invoker.ApiClient;
import org.openapi.zephyr.invoker.ApiException;
import org.openapi.zephyr.invoker.Configuration;
import org.openapi.zephyr.invoker.auth.*;
import org.openapi.zephyr.invoker.models.*;
import org.openapi.zephyr.api.TestExecutionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.zephyrscale.smartbear.com/v2");
    
    // Configure API key authorization: AccessToken
    ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
    AccessToken.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AccessToken.setApiKeyPrefix("Token");

    TestExecutionsApi apiInstance = new TestExecutionsApi(defaultClient);
    String testExecutionIdOrKey = "testExecutionIdOrKey_example"; // String | The ID or key of the test execution. Test execution keys are of the format [A-Z]+-E[0-9]+
    IssueLinkInput issueLinkInput = new IssueLinkInput(); // IssueLinkInput | Issue Link Input
    try {
      apiInstance.createTestExecutionIssueLink(testExecutionIdOrKey, issueLinkInput);
    } catch (ApiException e) {
      System.err.println("Exception when calling TestExecutionsApi#createTestExecutionIssueLink");
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
 **testExecutionIdOrKey** | **String**| The ID or key of the test execution. Test execution keys are of the format [A-Z]+-E[0-9]+ |
 **issueLinkInput** | [**IssueLinkInput**](IssueLinkInput.md)| Issue Link Input |

### Return type

null (empty response body)

### Authorization

[AccessToken](../README.md#AccessToken)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Created |  * Access-Control-Allow-Headers -  <br>  * Access-Control-Allow-Methods -  <br>  * Access-Control-Allow-Origin -  <br>  * location - URL of the created link <br>  |
**0** | An error has occurred. Please check the code and the error message. |  * Access-Control-Allow-Headers -  <br>  * Access-Control-Allow-Methods -  <br>  * Access-Control-Allow-Origin -  <br>  |

<a name="getTestExecution"></a>
# **getTestExecution**
> TestExecution getTestExecution(testExecutionIdOrKey, includeStepLinks)

Get test execution

Returns a test execution for the given ID.

### Example
```java
// Import classes:
import org.openapi.zephyr.invoker.ApiClient;
import org.openapi.zephyr.invoker.ApiException;
import org.openapi.zephyr.invoker.Configuration;
import org.openapi.zephyr.invoker.auth.*;
import org.openapi.zephyr.invoker.models.*;
import org.openapi.zephyr.api.TestExecutionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.zephyrscale.smartbear.com/v2");
    
    // Configure API key authorization: AccessToken
    ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
    AccessToken.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AccessToken.setApiKeyPrefix("Token");

    TestExecutionsApi apiInstance = new TestExecutionsApi(defaultClient);
    String testExecutionIdOrKey = "testExecutionIdOrKey_example"; // String | The ID or key of the test execution. Test execution keys are of the format [A-Z]+-E[0-9]+
    Boolean includeStepLinks = false; // Boolean | If true, execution step issue links will be included in the response
    try {
      TestExecution result = apiInstance.getTestExecution(testExecutionIdOrKey, includeStepLinks);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TestExecutionsApi#getTestExecution");
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
 **testExecutionIdOrKey** | **String**| The ID or key of the test execution. Test execution keys are of the format [A-Z]+-E[0-9]+ |
 **includeStepLinks** | **Boolean**| If true, execution step issue links will be included in the response | [optional] [default to false]

### Return type

[**TestExecution**](TestExecution.md)

### Authorization

[AccessToken](../README.md#AccessToken)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  * Access-Control-Allow-Headers -  <br>  * Access-Control-Allow-Methods -  <br>  * Access-Control-Allow-Origin -  <br>  |
**0** | An error has occurred. Please check the code and the error message. |  * Access-Control-Allow-Headers -  <br>  * Access-Control-Allow-Methods -  <br>  * Access-Control-Allow-Origin -  <br>  |

<a name="listTestExecutionLinks"></a>
# **listTestExecutionLinks**
> TestExecutionLinkList listTestExecutionLinks(testExecutionIdOrKey)

Get links

Returns links for a test execution with specified ID.

### Example
```java
// Import classes:
import org.openapi.zephyr.invoker.ApiClient;
import org.openapi.zephyr.invoker.ApiException;
import org.openapi.zephyr.invoker.Configuration;
import org.openapi.zephyr.invoker.auth.*;
import org.openapi.zephyr.invoker.models.*;
import org.openapi.zephyr.api.TestExecutionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.zephyrscale.smartbear.com/v2");
    
    // Configure API key authorization: AccessToken
    ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
    AccessToken.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AccessToken.setApiKeyPrefix("Token");

    TestExecutionsApi apiInstance = new TestExecutionsApi(defaultClient);
    String testExecutionIdOrKey = "testExecutionIdOrKey_example"; // String | The ID or key of the test execution. Test execution keys are of the format [A-Z]+-E[0-9]+
    try {
      TestExecutionLinkList result = apiInstance.listTestExecutionLinks(testExecutionIdOrKey);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TestExecutionsApi#listTestExecutionLinks");
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
 **testExecutionIdOrKey** | **String**| The ID or key of the test execution. Test execution keys are of the format [A-Z]+-E[0-9]+ |

### Return type

[**TestExecutionLinkList**](TestExecutionLinkList.md)

### Authorization

[AccessToken](../README.md#AccessToken)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  * Access-Control-Allow-Headers -  <br>  * Access-Control-Allow-Methods -  <br>  * Access-Control-Allow-Origin -  <br>  |
**0** | An error has occurred. Please check the code and the error message. |  * Access-Control-Allow-Headers -  <br>  * Access-Control-Allow-Methods -  <br>  * Access-Control-Allow-Origin -  <br>  |

<a name="listTestExecutions"></a>
# **listTestExecutions**
> TestExecutionList listTestExecutions(projectKey, testCycle, testCase, actualEndDateAfter, actualEndDateBefore, includeStepLinks, maxResults, startAt)

Get test executions

Returns all test executions. Query parameters can be used to filter by project and folder.

### Example
```java
// Import classes:
import org.openapi.zephyr.invoker.ApiClient;
import org.openapi.zephyr.invoker.ApiException;
import org.openapi.zephyr.invoker.Configuration;
import org.openapi.zephyr.invoker.auth.*;
import org.openapi.zephyr.invoker.models.*;
import org.openapi.zephyr.api.TestExecutionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.zephyrscale.smartbear.com/v2");
    
    // Configure API key authorization: AccessToken
    ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
    AccessToken.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AccessToken.setApiKeyPrefix("Token");

    TestExecutionsApi apiInstance = new TestExecutionsApi(defaultClient);
    String projectKey = "projectKey_example"; // String | Jira project key filter
    String testCycle = "testCycle_example"; // String | Test cycle key filter.
    String testCase = "testCase_example"; // String | Test case key filter.
    OffsetDateTime actualEndDateAfter = OffsetDateTime.now(); // OffsetDateTime | Filter for 'Actual End Date' after the given time. Format: yyyy-MM-dd'T'HH:mm:ss'Z'
    OffsetDateTime actualEndDateBefore = OffsetDateTime.now(); // OffsetDateTime | Filter for 'Actual End Date' before the given time. Format: yyyy-MM-dd'T'HH:mm:ss'Z'
    Boolean includeStepLinks = false; // Boolean | If true, execution step issue links will be included in the response
    Long maxResults = 10L; // Long | A hint as to the maximum number of results to return in each call. Note that the server reserves the right to impose a maxResults limit that is lower than the value that a client provides, due to lack or resources or any other condition. When this happens, your results will be truncated. Callers should always check the returned maxResults to determine the value that is effectively being used.
    Long startAt = 0L; // Long | Zero-indexed starting position. Should be a multiple of maxResults.
    try {
      TestExecutionList result = apiInstance.listTestExecutions(projectKey, testCycle, testCase, actualEndDateAfter, actualEndDateBefore, includeStepLinks, maxResults, startAt);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TestExecutionsApi#listTestExecutions");
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
 **projectKey** | **String**| Jira project key filter | [optional]
 **testCycle** | **String**| Test cycle key filter. | [optional]
 **testCase** | **String**| Test case key filter. | [optional]
 **actualEndDateAfter** | **OffsetDateTime**| Filter for &#39;Actual End Date&#39; after the given time. Format: yyyy-MM-dd&#39;T&#39;HH:mm:ss&#39;Z&#39; | [optional]
 **actualEndDateBefore** | **OffsetDateTime**| Filter for &#39;Actual End Date&#39; before the given time. Format: yyyy-MM-dd&#39;T&#39;HH:mm:ss&#39;Z&#39; | [optional]
 **includeStepLinks** | **Boolean**| If true, execution step issue links will be included in the response | [optional] [default to false]
 **maxResults** | **Long**| A hint as to the maximum number of results to return in each call. Note that the server reserves the right to impose a maxResults limit that is lower than the value that a client provides, due to lack or resources or any other condition. When this happens, your results will be truncated. Callers should always check the returned maxResults to determine the value that is effectively being used. | [optional] [default to 10]
 **startAt** | **Long**| Zero-indexed starting position. Should be a multiple of maxResults. | [optional] [default to 0]

### Return type

[**TestExecutionList**](TestExecutionList.md)

### Authorization

[AccessToken](../README.md#AccessToken)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  * Access-Control-Allow-Headers -  <br>  * Access-Control-Allow-Methods -  <br>  * Access-Control-Allow-Origin -  <br>  |
**0** | An error has occurred. Please check the code and the error message. |  * Access-Control-Allow-Headers -  <br>  * Access-Control-Allow-Methods -  <br>  * Access-Control-Allow-Origin -  <br>  |

