# EnvironmentsApi

All URIs are relative to *https://api.zephyrscale.smartbear.com/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getEnvironment**](EnvironmentsApi.md#getEnvironment) | **GET** /environments/{environmentId} | Get environment
[**listEnvironments**](EnvironmentsApi.md#listEnvironments) | **GET** /environments | Get environments


<a name="getEnvironment"></a>
# **getEnvironment**
> Environment getEnvironment(environmentId)

Get environment

Returns an environment for the given ID.

### Example
```java
// Import classes:
import org.openapi.zephyr.invoker.ApiClient;
import org.openapi.zephyr.invoker.ApiException;
import org.openapi.zephyr.invoker.Configuration;
import org.openapi.zephyr.invoker.auth.*;
import org.openapi.zephyr.invoker.models.*;
import org.openapi.zephyr.api.EnvironmentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.zephyrscale.smartbear.com/v2");
    
    // Configure API key authorization: AccessToken
    ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
    AccessToken.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AccessToken.setApiKeyPrefix("Token");

    EnvironmentsApi apiInstance = new EnvironmentsApi(defaultClient);
    Long environmentId = 56L; // Long | 
    try {
      Environment result = apiInstance.getEnvironment(environmentId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling EnvironmentsApi#getEnvironment");
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
 **environmentId** | **Long**|  |

### Return type

[**Environment**](Environment.md)

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

<a name="listEnvironments"></a>
# **listEnvironments**
> EnvironmentList listEnvironments(projectKey, maxResults, startAt)

Get environments

Returns all environments.

### Example
```java
// Import classes:
import org.openapi.zephyr.invoker.ApiClient;
import org.openapi.zephyr.invoker.ApiException;
import org.openapi.zephyr.invoker.Configuration;
import org.openapi.zephyr.invoker.auth.*;
import org.openapi.zephyr.invoker.models.*;
import org.openapi.zephyr.api.EnvironmentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.zephyrscale.smartbear.com/v2");
    
    // Configure API key authorization: AccessToken
    ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
    AccessToken.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AccessToken.setApiKeyPrefix("Token");

    EnvironmentsApi apiInstance = new EnvironmentsApi(defaultClient);
    String projectKey = "projectKey_example"; // String | Jira project key filter
    Long maxResults = 10L; // Long | A hint as to the maximum number of results to return in each call. Note that the server reserves the right to impose a maxResults limit that is lower than the value that a client provides, due to lack or resources or any other condition. When this happens, your results will be truncated. Callers should always check the returned maxResults to determine the value that is effectively being used.
    Long startAt = 0L; // Long | Zero-indexed starting position. Should be a multiple of maxResults.
    try {
      EnvironmentList result = apiInstance.listEnvironments(projectKey, maxResults, startAt);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling EnvironmentsApi#listEnvironments");
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
 **maxResults** | **Long**| A hint as to the maximum number of results to return in each call. Note that the server reserves the right to impose a maxResults limit that is lower than the value that a client provides, due to lack or resources or any other condition. When this happens, your results will be truncated. Callers should always check the returned maxResults to determine the value that is effectively being used. | [optional] [default to 10]
 **startAt** | **Long**| Zero-indexed starting position. Should be a multiple of maxResults. | [optional] [default to 0]

### Return type

[**EnvironmentList**](EnvironmentList.md)

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

