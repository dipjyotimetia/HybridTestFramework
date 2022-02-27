# TestCyclesApi

All URIs are relative to *https://api.zephyrscale.smartbear.com/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createTestCycle**](TestCyclesApi.md#createTestCycle) | **POST** /testcycles | Create a Test Cycle
[**createTestCycleIssueLink**](TestCyclesApi.md#createTestCycleIssueLink) | **POST** /testcycles/{testCycleIdOrKey}/links/issues | Create issue links
[**createTestCycleWebLink**](TestCyclesApi.md#createTestCycleWebLink) | **POST** /testcycles/{testCycleIdOrKey}/links/weblinks | Create web links
[**getTestCycle**](TestCyclesApi.md#getTestCycle) | **GET** /testcycles/{testCycleIdOrKey} | Get test cycle
[**getTestCycleLinks**](TestCyclesApi.md#getTestCycleLinks) | **GET** /testcycles/{testCycleIdOrKey}/links | Get links
[**listTestCycles**](TestCyclesApi.md#listTestCycles) | **GET** /testcycles | Get all Test Cycles
[**updateTestCycle**](TestCyclesApi.md#updateTestCycle) | **PUT** /testcycles/{testCycleIdOrKey} | Update test cycle


<a name="createTestCycle"></a>
# **createTestCycle**
> KeyedCreatedResource createTestCycle(testCycleInput)

Create a Test Cycle

Creates a Test Cycle. All required test cycle custom fields should be present in the request.

### Example
```java
// Import classes:
import org.openapi.zephyr.invoker.ApiClient;
import org.openapi.zephyr.invoker.ApiException;
import org.openapi.zephyr.invoker.Configuration;
import org.openapi.zephyr.invoker.auth.*;
import org.openapi.zephyr.invoker.models.*;
import org.openapi.zephyr.api.TestCyclesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.zephyrscale.smartbear.com/v2");
    
    // Configure API key authorization: AccessToken
    ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
    AccessToken.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AccessToken.setApiKeyPrefix("Token");

    TestCyclesApi apiInstance = new TestCyclesApi(defaultClient);
    TestCycleInput testCycleInput = new TestCycleInput(); // TestCycleInput | Test Cycle Input
    try {
      KeyedCreatedResource result = apiInstance.createTestCycle(testCycleInput);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TestCyclesApi#createTestCycle");
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
 **testCycleInput** | [**TestCycleInput**](TestCycleInput.md)| Test Cycle Input |

### Return type

[**KeyedCreatedResource**](KeyedCreatedResource.md)

### Authorization

[AccessToken](../README.md#AccessToken)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Created |  * Access-Control-Allow-Headers -  <br>  * Access-Control-Allow-Methods -  <br>  * Access-Control-Allow-Origin -  <br>  |
**0** | An error has occurred. Please check the code and the error message. |  * Access-Control-Allow-Headers -  <br>  * Access-Control-Allow-Methods -  <br>  * Access-Control-Allow-Origin -  <br>  |

<a name="createTestCycleIssueLink"></a>
# **createTestCycleIssueLink**
> createTestCycleIssueLink(testCycleIdOrKey, issueLinkInput)

Create issue links

Creates a link between a test cycle and a Jira issue.

### Example
```java
// Import classes:
import org.openapi.zephyr.invoker.ApiClient;
import org.openapi.zephyr.invoker.ApiException;
import org.openapi.zephyr.invoker.Configuration;
import org.openapi.zephyr.invoker.auth.*;
import org.openapi.zephyr.invoker.models.*;
import org.openapi.zephyr.api.TestCyclesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.zephyrscale.smartbear.com/v2");
    
    // Configure API key authorization: AccessToken
    ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
    AccessToken.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AccessToken.setApiKeyPrefix("Token");

    TestCyclesApi apiInstance = new TestCyclesApi(defaultClient);
    String testCycleIdOrKey = "testCycleIdOrKey_example"; // String | The ID or key of the test cycle. Test cycle keys are of the format [A-Z]+-R[0-9]+
    IssueLinkInput issueLinkInput = new IssueLinkInput(); // IssueLinkInput | Issue Link Input
    try {
      apiInstance.createTestCycleIssueLink(testCycleIdOrKey, issueLinkInput);
    } catch (ApiException e) {
      System.err.println("Exception when calling TestCyclesApi#createTestCycleIssueLink");
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
 **testCycleIdOrKey** | **String**| The ID or key of the test cycle. Test cycle keys are of the format [A-Z]+-R[0-9]+ |
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

<a name="createTestCycleWebLink"></a>
# **createTestCycleWebLink**
> createTestCycleWebLink(testCycleIdOrKey, webLinkInput)

Create web links

Creates a link between a test cycle and a generic URL.

### Example
```java
// Import classes:
import org.openapi.zephyr.invoker.ApiClient;
import org.openapi.zephyr.invoker.ApiException;
import org.openapi.zephyr.invoker.Configuration;
import org.openapi.zephyr.invoker.auth.*;
import org.openapi.zephyr.invoker.models.*;
import org.openapi.zephyr.api.TestCyclesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.zephyrscale.smartbear.com/v2");
    
    // Configure API key authorization: AccessToken
    ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
    AccessToken.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AccessToken.setApiKeyPrefix("Token");

    TestCyclesApi apiInstance = new TestCyclesApi(defaultClient);
    String testCycleIdOrKey = "testCycleIdOrKey_example"; // String | The ID or key of the test cycle. Test cycle keys are of the format [A-Z]+-R[0-9]+
    WebLinkInput webLinkInput = new WebLinkInput(); // WebLinkInput | Web Link Input
    try {
      apiInstance.createTestCycleWebLink(testCycleIdOrKey, webLinkInput);
    } catch (ApiException e) {
      System.err.println("Exception when calling TestCyclesApi#createTestCycleWebLink");
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
 **testCycleIdOrKey** | **String**| The ID or key of the test cycle. Test cycle keys are of the format [A-Z]+-R[0-9]+ |
 **webLinkInput** | [**WebLinkInput**](WebLinkInput.md)| Web Link Input |

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

<a name="getTestCycle"></a>
# **getTestCycle**
> TestCycle getTestCycle(testCycleIdOrKey)

Get test cycle

Returns a test cycle for the given key.

### Example
```java
// Import classes:
import org.openapi.zephyr.invoker.ApiClient;
import org.openapi.zephyr.invoker.ApiException;
import org.openapi.zephyr.invoker.Configuration;
import org.openapi.zephyr.invoker.auth.*;
import org.openapi.zephyr.invoker.models.*;
import org.openapi.zephyr.api.TestCyclesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.zephyrscale.smartbear.com/v2");
    
    // Configure API key authorization: AccessToken
    ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
    AccessToken.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AccessToken.setApiKeyPrefix("Token");

    TestCyclesApi apiInstance = new TestCyclesApi(defaultClient);
    String testCycleIdOrKey = "testCycleIdOrKey_example"; // String | The ID or key of the test cycle. Test cycle keys are of the format [A-Z]+-R[0-9]+
    try {
      TestCycle result = apiInstance.getTestCycle(testCycleIdOrKey);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TestCyclesApi#getTestCycle");
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
 **testCycleIdOrKey** | **String**| The ID or key of the test cycle. Test cycle keys are of the format [A-Z]+-R[0-9]+ |

### Return type

[**TestCycle**](TestCycle.md)

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

<a name="getTestCycleLinks"></a>
# **getTestCycleLinks**
> TestCycleLinkList getTestCycleLinks(testCycleIdOrKey)

Get links

Returns links for a test cycle with specified key.

### Example
```java
// Import classes:
import org.openapi.zephyr.invoker.ApiClient;
import org.openapi.zephyr.invoker.ApiException;
import org.openapi.zephyr.invoker.Configuration;
import org.openapi.zephyr.invoker.auth.*;
import org.openapi.zephyr.invoker.models.*;
import org.openapi.zephyr.api.TestCyclesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.zephyrscale.smartbear.com/v2");
    
    // Configure API key authorization: AccessToken
    ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
    AccessToken.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AccessToken.setApiKeyPrefix("Token");

    TestCyclesApi apiInstance = new TestCyclesApi(defaultClient);
    String testCycleIdOrKey = "testCycleIdOrKey_example"; // String | The ID or key of the test cycle. Test cycle keys are of the format [A-Z]+-R[0-9]+
    try {
      TestCycleLinkList result = apiInstance.getTestCycleLinks(testCycleIdOrKey);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TestCyclesApi#getTestCycleLinks");
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
 **testCycleIdOrKey** | **String**| The ID or key of the test cycle. Test cycle keys are of the format [A-Z]+-R[0-9]+ |

### Return type

[**TestCycleLinkList**](TestCycleLinkList.md)

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

<a name="listTestCycles"></a>
# **listTestCycles**
> TestCycleList listTestCycles(projectKey, folderId, maxResults, startAt)

Get all Test Cycles

Returns all test cycles. Query parameters can be used to filter by project and folder.

### Example
```java
// Import classes:
import org.openapi.zephyr.invoker.ApiClient;
import org.openapi.zephyr.invoker.ApiException;
import org.openapi.zephyr.invoker.Configuration;
import org.openapi.zephyr.invoker.auth.*;
import org.openapi.zephyr.invoker.models.*;
import org.openapi.zephyr.api.TestCyclesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.zephyrscale.smartbear.com/v2");
    
    // Configure API key authorization: AccessToken
    ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
    AccessToken.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AccessToken.setApiKeyPrefix("Token");

    TestCyclesApi apiInstance = new TestCyclesApi(defaultClient);
    String projectKey = "projectKey_example"; // String | Jira project key filter
    Long folderId = 56L; // Long | Folder ID filter
    Long maxResults = 10L; // Long | A hint as to the maximum number of results to return in each call. Note that the server reserves the right to impose a maxResults limit that is lower than the value that a client provides, due to lack or resources or any other condition. When this happens, your results will be truncated. Callers should always check the returned maxResults to determine the value that is effectively being used.
    Long startAt = 0L; // Long | Zero-indexed starting position. Should be a multiple of maxResults.
    try {
      TestCycleList result = apiInstance.listTestCycles(projectKey, folderId, maxResults, startAt);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TestCyclesApi#listTestCycles");
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
 **folderId** | **Long**| Folder ID filter | [optional]
 **maxResults** | **Long**| A hint as to the maximum number of results to return in each call. Note that the server reserves the right to impose a maxResults limit that is lower than the value that a client provides, due to lack or resources or any other condition. When this happens, your results will be truncated. Callers should always check the returned maxResults to determine the value that is effectively being used. | [optional] [default to 10]
 **startAt** | **Long**| Zero-indexed starting position. Should be a multiple of maxResults. | [optional] [default to 0]

### Return type

[**TestCycleList**](TestCycleList.md)

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

<a name="updateTestCycle"></a>
# **updateTestCycle**
> updateTestCycle(testCycleIdOrKey, testCycle)

Update test cycle

Updates an existing test cycle. If the project has test cycle custom fields, all custom fields should be present in the request. To leave any of them blank, please set them null if they are not required custom fields. 

### Example
```java
// Import classes:
import org.openapi.zephyr.invoker.ApiClient;
import org.openapi.zephyr.invoker.ApiException;
import org.openapi.zephyr.invoker.Configuration;
import org.openapi.zephyr.invoker.auth.*;
import org.openapi.zephyr.invoker.models.*;
import org.openapi.zephyr.api.TestCyclesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.zephyrscale.smartbear.com/v2");
    
    // Configure API key authorization: AccessToken
    ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
    AccessToken.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AccessToken.setApiKeyPrefix("Token");

    TestCyclesApi apiInstance = new TestCyclesApi(defaultClient);
    String testCycleIdOrKey = "testCycleIdOrKey_example"; // String | The ID or key of the test cycle. Test cycle keys are of the format [A-Z]+-R[0-9]+
    TestCycle testCycle = new TestCycle(); // TestCycle | Test Cycle Update
    try {
      apiInstance.updateTestCycle(testCycleIdOrKey, testCycle);
    } catch (ApiException e) {
      System.err.println("Exception when calling TestCyclesApi#updateTestCycle");
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
 **testCycleIdOrKey** | **String**| The ID or key of the test cycle. Test cycle keys are of the format [A-Z]+-R[0-9]+ |
 **testCycle** | [**TestCycle**](TestCycle.md)| Test Cycle Update |

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
**200** | OK |  * Access-Control-Allow-Headers -  <br>  * Access-Control-Allow-Methods -  <br>  * Access-Control-Allow-Origin -  <br>  * location - URL of the created link <br>  |
**0** | An error has occurred. Please check the code and the error message. |  * Access-Control-Allow-Headers -  <br>  * Access-Control-Allow-Methods -  <br>  * Access-Control-Allow-Origin -  <br>  |

