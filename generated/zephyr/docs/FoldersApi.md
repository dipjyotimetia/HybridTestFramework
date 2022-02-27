# FoldersApi

All URIs are relative to *https://api.zephyrscale.smartbear.com/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createFolder**](FoldersApi.md#createFolder) | **POST** /folders | Create folder
[**getFolder**](FoldersApi.md#getFolder) | **GET** /folders/{folderId} | Get folder
[**listFolders**](FoldersApi.md#listFolders) | **GET** /folders | Get folders


<a name="createFolder"></a>
# **createFolder**
> CreatedResource createFolder(folderInput)

Create folder

Creates a folder.

### Example
```java
// Import classes:
import org.openapi.zephyr.invoker.ApiClient;
import org.openapi.zephyr.invoker.ApiException;
import org.openapi.zephyr.invoker.Configuration;
import org.openapi.zephyr.invoker.auth.*;
import org.openapi.zephyr.invoker.models.*;
import org.openapi.zephyr.api.FoldersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.zephyrscale.smartbear.com/v2");
    
    // Configure API key authorization: AccessToken
    ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
    AccessToken.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AccessToken.setApiKeyPrefix("Token");

    FoldersApi apiInstance = new FoldersApi(defaultClient);
    FolderInput folderInput = new FolderInput(); // FolderInput | FolderInput
    try {
      CreatedResource result = apiInstance.createFolder(folderInput);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FoldersApi#createFolder");
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
 **folderInput** | [**FolderInput**](FolderInput.md)| FolderInput |

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

<a name="getFolder"></a>
# **getFolder**
> Folder getFolder(folderId)

Get folder

Returns a folder for the given ID.

### Example
```java
// Import classes:
import org.openapi.zephyr.invoker.ApiClient;
import org.openapi.zephyr.invoker.ApiException;
import org.openapi.zephyr.invoker.Configuration;
import org.openapi.zephyr.invoker.auth.*;
import org.openapi.zephyr.invoker.models.*;
import org.openapi.zephyr.api.FoldersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.zephyrscale.smartbear.com/v2");
    
    // Configure API key authorization: AccessToken
    ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
    AccessToken.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AccessToken.setApiKeyPrefix("Token");

    FoldersApi apiInstance = new FoldersApi(defaultClient);
    Long folderId = 56L; // Long | Folder ID
    try {
      Folder result = apiInstance.getFolder(folderId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FoldersApi#getFolder");
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
 **folderId** | **Long**| Folder ID |

### Return type

[**Folder**](Folder.md)

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

<a name="listFolders"></a>
# **listFolders**
> FolderList listFolders(maxResults, startAt, projectKey, folderType)

Get folders

Returns all folder.

### Example
```java
// Import classes:
import org.openapi.zephyr.invoker.ApiClient;
import org.openapi.zephyr.invoker.ApiException;
import org.openapi.zephyr.invoker.Configuration;
import org.openapi.zephyr.invoker.auth.*;
import org.openapi.zephyr.invoker.models.*;
import org.openapi.zephyr.api.FoldersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.zephyrscale.smartbear.com/v2");
    
    // Configure API key authorization: AccessToken
    ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
    AccessToken.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AccessToken.setApiKeyPrefix("Token");

    FoldersApi apiInstance = new FoldersApi(defaultClient);
    Long maxResults = 10L; // Long | A hint as to the maximum number of results to return in each call. Note that the server reserves the right to impose a maxResults limit that is lower than the value that a client provides, due to lack or resources or any other condition. When this happens, your results will be truncated. Callers should always check the returned maxResults to determine the value that is effectively being used.
    Long startAt = 0L; // Long | Zero-indexed starting position. Should be a multiple of maxResults.
    String projectKey = "projectKey_example"; // String | Jira project key filter
    String folderType = "folderType_example"; // String | Folder type filter. Either `\"TEST_CASE\"`, `\"TEST_PLAN\"` or `\"TEST_CYCLE\"`
    try {
      FolderList result = apiInstance.listFolders(maxResults, startAt, projectKey, folderType);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FoldersApi#listFolders");
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
 **maxResults** | **Long**| A hint as to the maximum number of results to return in each call. Note that the server reserves the right to impose a maxResults limit that is lower than the value that a client provides, due to lack or resources or any other condition. When this happens, your results will be truncated. Callers should always check the returned maxResults to determine the value that is effectively being used. | [optional] [default to 10]
 **startAt** | **Long**| Zero-indexed starting position. Should be a multiple of maxResults. | [optional] [default to 0]
 **projectKey** | **String**| Jira project key filter | [optional]
 **folderType** | **String**| Folder type filter. Either &#x60;\&quot;TEST_CASE\&quot;&#x60;, &#x60;\&quot;TEST_PLAN\&quot;&#x60; or &#x60;\&quot;TEST_CYCLE\&quot;&#x60; | [optional]

### Return type

[**FolderList**](FolderList.md)

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

