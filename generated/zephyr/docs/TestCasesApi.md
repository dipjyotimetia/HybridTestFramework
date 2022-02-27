# TestCasesApi

All URIs are relative to *https://api.zephyrscale.smartbear.com/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createTestCase**](TestCasesApi.md#createTestCase) | **POST** /testcases | Create test case
[**createTestCaseIssueLinks**](TestCasesApi.md#createTestCaseIssueLinks) | **POST** /testcases/{testCaseKey}/links/issues | Create issue links
[**createTestCaseTestScript**](TestCasesApi.md#createTestCaseTestScript) | **POST** /testcases/{testCaseKey}/testscript | Create test script
[**createTestCaseTestSteps**](TestCasesApi.md#createTestCaseTestSteps) | **POST** /testcases/{testCaseKey}/teststeps | Post test steps
[**createTestCaseWebLinks**](TestCasesApi.md#createTestCaseWebLinks) | **POST** /testcases/{testCaseKey}/links/weblinks | Create web links
[**getTestCase**](TestCasesApi.md#getTestCase) | **GET** /testcases/{testCaseKey} | Get test case
[**getTestCaseLinks**](TestCasesApi.md#getTestCaseLinks) | **GET** /testcases/{testCaseKey}/links | Get links
[**getTestCaseTestScript**](TestCasesApi.md#getTestCaseTestScript) | **GET** /testcases/{testCaseKey}/testscript | Get test script
[**getTestCaseTestSteps**](TestCasesApi.md#getTestCaseTestSteps) | **GET** /testcases/{testCaseKey}/teststeps | Get test steps
[**getTestCaseVersion**](TestCasesApi.md#getTestCaseVersion) | **GET** /testcases/{testCaseKey}/versions/{version} | Get version
[**listTestCaseVersions**](TestCasesApi.md#listTestCaseVersions) | **GET** /testcases/{testCaseKey}/versions | Get versions
[**listTestCases**](TestCasesApi.md#listTestCases) | **GET** /testcases | Get test cases
[**updateTestCase**](TestCasesApi.md#updateTestCase) | **PUT** /testcases/{testCaseKey} | Update test case


<a name="createTestCase"></a>
# **createTestCase**
> KeyedCreatedResource createTestCase(testCaseInput)

Create test case

Creates a test case. Fields &#x60;priorityName&#x60; and &#x60;statusName&#x60; will be set to default values if not informed. Default values are usually “Normal” for &#x60;priorityName&#x60; and “Draft” for &#x60;statusName&#x60;. All required test case custom fields should be present in the request. 

### Example
```java
// Import classes:
import org.openapi.zephyr.invoker.ApiClient;
import org.openapi.zephyr.invoker.ApiException;
import org.openapi.zephyr.invoker.Configuration;
import org.openapi.zephyr.invoker.auth.*;
import org.openapi.zephyr.invoker.models.*;
import org.openapi.zephyr.api.TestCasesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.zephyrscale.smartbear.com/v2");
    
    // Configure API key authorization: AccessToken
    ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
    AccessToken.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AccessToken.setApiKeyPrefix("Token");

    TestCasesApi apiInstance = new TestCasesApi(defaultClient);
    TestCaseInput testCaseInput = new TestCaseInput(); // TestCaseInput | Test Case Input
    try {
      KeyedCreatedResource result = apiInstance.createTestCase(testCaseInput);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TestCasesApi#createTestCase");
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
 **testCaseInput** | [**TestCaseInput**](TestCaseInput.md)| Test Case Input |

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

<a name="createTestCaseIssueLinks"></a>
# **createTestCaseIssueLinks**
> CreatedResource createTestCaseIssueLinks(testCaseKey, issueLinkInput)

Create issue links

Creates a link between a test case and a Jira issue.

### Example
```java
// Import classes:
import org.openapi.zephyr.invoker.ApiClient;
import org.openapi.zephyr.invoker.ApiException;
import org.openapi.zephyr.invoker.Configuration;
import org.openapi.zephyr.invoker.auth.*;
import org.openapi.zephyr.invoker.models.*;
import org.openapi.zephyr.api.TestCasesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.zephyrscale.smartbear.com/v2");
    
    // Configure API key authorization: AccessToken
    ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
    AccessToken.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AccessToken.setApiKeyPrefix("Token");

    TestCasesApi apiInstance = new TestCasesApi(defaultClient);
    String testCaseKey = "testCaseKey_example"; // String | The key of the test case. Test case keys are of the format [A-Z]+-T[0-9]+
    IssueLinkInput issueLinkInput = new IssueLinkInput(); // IssueLinkInput | Issue Link Input
    try {
      CreatedResource result = apiInstance.createTestCaseIssueLinks(testCaseKey, issueLinkInput);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TestCasesApi#createTestCaseIssueLinks");
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
 **testCaseKey** | **String**| The key of the test case. Test case keys are of the format [A-Z]+-T[0-9]+ |
 **issueLinkInput** | [**IssueLinkInput**](IssueLinkInput.md)| Issue Link Input |

### Return type

[**CreatedResource**](CreatedResource.md)

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

<a name="createTestCaseTestScript"></a>
# **createTestCaseTestScript**
> CreatedResource createTestCaseTestScript(testCaseKey, testScriptInput)

Create test script

Creates or updates the test script for a test case. If the test case currently has a sequence of test steps assigned to it, these will be implicitly removed.

### Example
```java
// Import classes:
import org.openapi.zephyr.invoker.ApiClient;
import org.openapi.zephyr.invoker.ApiException;
import org.openapi.zephyr.invoker.Configuration;
import org.openapi.zephyr.invoker.auth.*;
import org.openapi.zephyr.invoker.models.*;
import org.openapi.zephyr.api.TestCasesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.zephyrscale.smartbear.com/v2");
    
    // Configure API key authorization: AccessToken
    ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
    AccessToken.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AccessToken.setApiKeyPrefix("Token");

    TestCasesApi apiInstance = new TestCasesApi(defaultClient);
    String testCaseKey = "testCaseKey_example"; // String | The key of the test case. Test case keys are of the format [A-Z]+-T[0-9]+
    TestScriptInput testScriptInput = new TestScriptInput(); // TestScriptInput | Test Script Input
    try {
      CreatedResource result = apiInstance.createTestCaseTestScript(testCaseKey, testScriptInput);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TestCasesApi#createTestCaseTestScript");
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
 **testCaseKey** | **String**| The key of the test case. Test case keys are of the format [A-Z]+-T[0-9]+ |
 **testScriptInput** | [**TestScriptInput**](TestScriptInput.md)| Test Script Input |

### Return type

[**CreatedResource**](CreatedResource.md)

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

<a name="createTestCaseTestSteps"></a>
# **createTestCaseTestSteps**
> CreatedResource createTestCaseTestSteps(testCaseKey, testStepsInput)

Post test steps

Assigns a series of test steps to a test case, appending them to any existing sequence of test steps. A maximum of 100 steps can be posted per request. Consumers should not attempt to parallelize this operation, as the order of the steps is defined by the input order. If this endpoint is called on a test case that already has a plain text or BDD test script, that test script will implicitly be removed. All required step custom fields should be present in the request. 

### Example
```java
// Import classes:
import org.openapi.zephyr.invoker.ApiClient;
import org.openapi.zephyr.invoker.ApiException;
import org.openapi.zephyr.invoker.Configuration;
import org.openapi.zephyr.invoker.auth.*;
import org.openapi.zephyr.invoker.models.*;
import org.openapi.zephyr.api.TestCasesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.zephyrscale.smartbear.com/v2");
    
    // Configure API key authorization: AccessToken
    ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
    AccessToken.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AccessToken.setApiKeyPrefix("Token");

    TestCasesApi apiInstance = new TestCasesApi(defaultClient);
    String testCaseKey = "testCaseKey_example"; // String | The key of the test case. Test case keys are of the format [A-Z]+-T[0-9]+
    TestStepsInput testStepsInput = new TestStepsInput(); // TestStepsInput | Test Step Input
    try {
      CreatedResource result = apiInstance.createTestCaseTestSteps(testCaseKey, testStepsInput);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TestCasesApi#createTestCaseTestSteps");
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
 **testCaseKey** | **String**| The key of the test case. Test case keys are of the format [A-Z]+-T[0-9]+ |
 **testStepsInput** | [**TestStepsInput**](TestStepsInput.md)| Test Step Input |

### Return type

[**CreatedResource**](CreatedResource.md)

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

<a name="createTestCaseWebLinks"></a>
# **createTestCaseWebLinks**
> CreatedResource createTestCaseWebLinks(testCaseKey, webLinkInput)

Create web links

Creates a link between a test case and a generic URL.

### Example
```java
// Import classes:
import org.openapi.zephyr.invoker.ApiClient;
import org.openapi.zephyr.invoker.ApiException;
import org.openapi.zephyr.invoker.Configuration;
import org.openapi.zephyr.invoker.auth.*;
import org.openapi.zephyr.invoker.models.*;
import org.openapi.zephyr.api.TestCasesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.zephyrscale.smartbear.com/v2");
    
    // Configure API key authorization: AccessToken
    ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
    AccessToken.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AccessToken.setApiKeyPrefix("Token");

    TestCasesApi apiInstance = new TestCasesApi(defaultClient);
    String testCaseKey = "testCaseKey_example"; // String | The key of the test case. Test case keys are of the format [A-Z]+-T[0-9]+
    WebLinkInput webLinkInput = new WebLinkInput(); // WebLinkInput | Web Link Input
    try {
      CreatedResource result = apiInstance.createTestCaseWebLinks(testCaseKey, webLinkInput);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TestCasesApi#createTestCaseWebLinks");
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
 **testCaseKey** | **String**| The key of the test case. Test case keys are of the format [A-Z]+-T[0-9]+ |
 **webLinkInput** | [**WebLinkInput**](WebLinkInput.md)| Web Link Input |

### Return type

[**CreatedResource**](CreatedResource.md)

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

<a name="getTestCase"></a>
# **getTestCase**
> TestCase getTestCase(testCaseKey)

Get test case

Returns a test case for the given key.

### Example
```java
// Import classes:
import org.openapi.zephyr.invoker.ApiClient;
import org.openapi.zephyr.invoker.ApiException;
import org.openapi.zephyr.invoker.Configuration;
import org.openapi.zephyr.invoker.auth.*;
import org.openapi.zephyr.invoker.models.*;
import org.openapi.zephyr.api.TestCasesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.zephyrscale.smartbear.com/v2");
    
    // Configure API key authorization: AccessToken
    ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
    AccessToken.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AccessToken.setApiKeyPrefix("Token");

    TestCasesApi apiInstance = new TestCasesApi(defaultClient);
    String testCaseKey = "testCaseKey_example"; // String | The key of the test case. Test case keys are of the format [A-Z]+-T[0-9]+
    try {
      TestCase result = apiInstance.getTestCase(testCaseKey);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TestCasesApi#getTestCase");
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
 **testCaseKey** | **String**| The key of the test case. Test case keys are of the format [A-Z]+-T[0-9]+ |

### Return type

[**TestCase**](TestCase.md)

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

<a name="getTestCaseLinks"></a>
# **getTestCaseLinks**
> TestCaseLinkList getTestCaseLinks(testCaseKey)

Get links

Returns links for a test case with specified key.

### Example
```java
// Import classes:
import org.openapi.zephyr.invoker.ApiClient;
import org.openapi.zephyr.invoker.ApiException;
import org.openapi.zephyr.invoker.Configuration;
import org.openapi.zephyr.invoker.auth.*;
import org.openapi.zephyr.invoker.models.*;
import org.openapi.zephyr.api.TestCasesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.zephyrscale.smartbear.com/v2");
    
    // Configure API key authorization: AccessToken
    ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
    AccessToken.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AccessToken.setApiKeyPrefix("Token");

    TestCasesApi apiInstance = new TestCasesApi(defaultClient);
    String testCaseKey = "testCaseKey_example"; // String | The key of the test case. Test case keys are of the format [A-Z]+-T[0-9]+
    try {
      TestCaseLinkList result = apiInstance.getTestCaseLinks(testCaseKey);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TestCasesApi#getTestCaseLinks");
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
 **testCaseKey** | **String**| The key of the test case. Test case keys are of the format [A-Z]+-T[0-9]+ |

### Return type

[**TestCaseLinkList**](TestCaseLinkList.md)

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

<a name="getTestCaseTestScript"></a>
# **getTestCaseTestScript**
> TestScript getTestCaseTestScript(testCaseKey)

Get test script

Returns the test script for the given test case

### Example
```java
// Import classes:
import org.openapi.zephyr.invoker.ApiClient;
import org.openapi.zephyr.invoker.ApiException;
import org.openapi.zephyr.invoker.Configuration;
import org.openapi.zephyr.invoker.auth.*;
import org.openapi.zephyr.invoker.models.*;
import org.openapi.zephyr.api.TestCasesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.zephyrscale.smartbear.com/v2");
    
    // Configure API key authorization: AccessToken
    ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
    AccessToken.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AccessToken.setApiKeyPrefix("Token");

    TestCasesApi apiInstance = new TestCasesApi(defaultClient);
    String testCaseKey = "testCaseKey_example"; // String | The key of the test case. Test case keys are of the format [A-Z]+-T[0-9]+
    try {
      TestScript result = apiInstance.getTestCaseTestScript(testCaseKey);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TestCasesApi#getTestCaseTestScript");
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
 **testCaseKey** | **String**| The key of the test case. Test case keys are of the format [A-Z]+-T[0-9]+ |

### Return type

[**TestScript**](TestScript.md)

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

<a name="getTestCaseTestSteps"></a>
# **getTestCaseTestSteps**
> TestStepsList getTestCaseTestSteps(testCaseKey, maxResults, startAt)

Get test steps

Returns the test steps for the given test case. Provides a paged response, with 100 items per page.

### Example
```java
// Import classes:
import org.openapi.zephyr.invoker.ApiClient;
import org.openapi.zephyr.invoker.ApiException;
import org.openapi.zephyr.invoker.Configuration;
import org.openapi.zephyr.invoker.auth.*;
import org.openapi.zephyr.invoker.models.*;
import org.openapi.zephyr.api.TestCasesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.zephyrscale.smartbear.com/v2");
    
    // Configure API key authorization: AccessToken
    ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
    AccessToken.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AccessToken.setApiKeyPrefix("Token");

    TestCasesApi apiInstance = new TestCasesApi(defaultClient);
    String testCaseKey = "testCaseKey_example"; // String | The key of the test case. Test case keys are of the format [A-Z]+-T[0-9]+
    Long maxResults = 10L; // Long | A hint as to the maximum number of results to return in each call. Note that the server reserves the right to impose a maxResults limit that is lower than the value that a client provides, due to lack or resources or any other condition. When this happens, your results will be truncated. Callers should always check the returned maxResults to determine the value that is effectively being used.
    Long startAt = 0L; // Long | Zero-indexed starting position. Should be a multiple of maxResults.
    try {
      TestStepsList result = apiInstance.getTestCaseTestSteps(testCaseKey, maxResults, startAt);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TestCasesApi#getTestCaseTestSteps");
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
 **testCaseKey** | **String**| The key of the test case. Test case keys are of the format [A-Z]+-T[0-9]+ |
 **maxResults** | **Long**| A hint as to the maximum number of results to return in each call. Note that the server reserves the right to impose a maxResults limit that is lower than the value that a client provides, due to lack or resources or any other condition. When this happens, your results will be truncated. Callers should always check the returned maxResults to determine the value that is effectively being used. | [optional] [default to 10]
 **startAt** | **Long**| Zero-indexed starting position. Should be a multiple of maxResults. | [optional] [default to 0]

### Return type

[**TestStepsList**](TestStepsList.md)

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

<a name="getTestCaseVersion"></a>
# **getTestCaseVersion**
> TestCase getTestCaseVersion(testCaseKey, version)

Get version

Retrieves a specific version of a test case.

### Example
```java
// Import classes:
import org.openapi.zephyr.invoker.ApiClient;
import org.openapi.zephyr.invoker.ApiException;
import org.openapi.zephyr.invoker.Configuration;
import org.openapi.zephyr.invoker.auth.*;
import org.openapi.zephyr.invoker.models.*;
import org.openapi.zephyr.api.TestCasesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.zephyrscale.smartbear.com/v2");
    
    // Configure API key authorization: AccessToken
    ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
    AccessToken.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AccessToken.setApiKeyPrefix("Token");

    TestCasesApi apiInstance = new TestCasesApi(defaultClient);
    String testCaseKey = "testCaseKey_example"; // String | The key of the test case. Test case keys are of the format [A-Z]+-T[0-9]+
    Long version = 56L; // Long | Version of the test case to retrieve.
    try {
      TestCase result = apiInstance.getTestCaseVersion(testCaseKey, version);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TestCasesApi#getTestCaseVersion");
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
 **testCaseKey** | **String**| The key of the test case. Test case keys are of the format [A-Z]+-T[0-9]+ |
 **version** | **Long**| Version of the test case to retrieve. |

### Return type

[**TestCase**](TestCase.md)

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

<a name="listTestCaseVersions"></a>
# **listTestCaseVersions**
> TestCaseVersionLinkList listTestCaseVersions(testCaseKey, maxResults, startAt)

Get versions

Returns all test case versions for a test case with specified key. Response is ordered by most recent first.

### Example
```java
// Import classes:
import org.openapi.zephyr.invoker.ApiClient;
import org.openapi.zephyr.invoker.ApiException;
import org.openapi.zephyr.invoker.Configuration;
import org.openapi.zephyr.invoker.auth.*;
import org.openapi.zephyr.invoker.models.*;
import org.openapi.zephyr.api.TestCasesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.zephyrscale.smartbear.com/v2");
    
    // Configure API key authorization: AccessToken
    ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
    AccessToken.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AccessToken.setApiKeyPrefix("Token");

    TestCasesApi apiInstance = new TestCasesApi(defaultClient);
    String testCaseKey = "testCaseKey_example"; // String | The key of the test case. Test case keys are of the format [A-Z]+-T[0-9]+
    Long maxResults = 10L; // Long | A hint as to the maximum number of results to return in each call. Note that the server reserves the right to impose a maxResults limit that is lower than the value that a client provides, due to lack or resources or any other condition. When this happens, your results will be truncated. Callers should always check the returned maxResults to determine the value that is effectively being used.
    Long startAt = 0L; // Long | Zero-indexed starting position. Should be a multiple of maxResults.
    try {
      TestCaseVersionLinkList result = apiInstance.listTestCaseVersions(testCaseKey, maxResults, startAt);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TestCasesApi#listTestCaseVersions");
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
 **testCaseKey** | **String**| The key of the test case. Test case keys are of the format [A-Z]+-T[0-9]+ |
 **maxResults** | **Long**| A hint as to the maximum number of results to return in each call. Note that the server reserves the right to impose a maxResults limit that is lower than the value that a client provides, due to lack or resources or any other condition. When this happens, your results will be truncated. Callers should always check the returned maxResults to determine the value that is effectively being used. | [optional] [default to 10]
 **startAt** | **Long**| Zero-indexed starting position. Should be a multiple of maxResults. | [optional] [default to 0]

### Return type

[**TestCaseVersionLinkList**](TestCaseVersionLinkList.md)

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

<a name="listTestCases"></a>
# **listTestCases**
> TestCaseList listTestCases(projectKey, folderId, maxResults, startAt)

Get test cases

Retrieves all test cases. Query parameters can be used to filter the results.

### Example
```java
// Import classes:
import org.openapi.zephyr.invoker.ApiClient;
import org.openapi.zephyr.invoker.ApiException;
import org.openapi.zephyr.invoker.Configuration;
import org.openapi.zephyr.invoker.auth.*;
import org.openapi.zephyr.invoker.models.*;
import org.openapi.zephyr.api.TestCasesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.zephyrscale.smartbear.com/v2");
    
    // Configure API key authorization: AccessToken
    ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
    AccessToken.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AccessToken.setApiKeyPrefix("Token");

    TestCasesApi apiInstance = new TestCasesApi(defaultClient);
    String projectKey = "projectKey_example"; // String | Jira project key filter
    Long folderId = 56L; // Long | Folder ID filter
    Long maxResults = 10L; // Long | A hint as to the maximum number of results to return in each call. Note that the server reserves the right to impose a maxResults limit that is lower than the value that a client provides, due to lack or resources or any other condition. When this happens, your results will be truncated. Callers should always check the returned maxResults to determine the value that is effectively being used.
    Long startAt = 0L; // Long | Zero-indexed starting position. Should be a multiple of maxResults.
    try {
      TestCaseList result = apiInstance.listTestCases(projectKey, folderId, maxResults, startAt);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TestCasesApi#listTestCases");
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

[**TestCaseList**](TestCaseList.md)

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

<a name="updateTestCase"></a>
# **updateTestCase**
> updateTestCase(testCaseKey, testCase)

Update test case

Updates an existing test case. If the project has test case custom fields, all custom fields should be present in the request. To leave any of them blank, please set them null if they are not required custom fields. 

### Example
```java
// Import classes:
import org.openapi.zephyr.invoker.ApiClient;
import org.openapi.zephyr.invoker.ApiException;
import org.openapi.zephyr.invoker.Configuration;
import org.openapi.zephyr.invoker.auth.*;
import org.openapi.zephyr.invoker.models.*;
import org.openapi.zephyr.api.TestCasesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.zephyrscale.smartbear.com/v2");
    
    // Configure API key authorization: AccessToken
    ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
    AccessToken.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AccessToken.setApiKeyPrefix("Token");

    TestCasesApi apiInstance = new TestCasesApi(defaultClient);
    String testCaseKey = "testCaseKey_example"; // String | The key of the test case. Test case keys are of the format [A-Z]+-T[0-9]+
    TestCase testCase = new TestCase(); // TestCase | Test Case Update
    try {
      apiInstance.updateTestCase(testCaseKey, testCase);
    } catch (ApiException e) {
      System.err.println("Exception when calling TestCasesApi#updateTestCase");
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
 **testCaseKey** | **String**| The key of the test case. Test case keys are of the format [A-Z]+-T[0-9]+ |
 **testCase** | [**TestCase**](TestCase.md)| Test Case Update |

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
**200** | OK |  * Access-Control-Allow-Headers -  <br>  * Access-Control-Allow-Methods -  <br>  * Access-Control-Allow-Origin -  <br>  |
**0** | An error has occurred. Please check the code and the error message. |  * Access-Control-Allow-Headers -  <br>  * Access-Control-Allow-Methods -  <br>  * Access-Control-Allow-Origin -  <br>  |

