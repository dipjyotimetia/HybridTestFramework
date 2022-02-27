# TestRepositoryApi

All URIs are relative to *https://sandbox.xpand-it.com/rest/raven/2.0/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**testrepositoryProjectKeyFoldersFolderIdGet**](TestRepositoryApi.md#testrepositoryProjectKeyFoldersFolderIdGet) | **GET** /testrepository/{projectKey}/folders/{folderId} | 


<a name="testrepositoryProjectKeyFoldersFolderIdGet"></a>
# **testrepositoryProjectKeyFoldersFolderIdGet**
> OneOfFolderRestBeanset testrepositoryProjectKeyFoldersFolderIdGet(projectKey, folderId)



Retrieves information about a given Test Repository folder. &lt;br/&gt; The response will contain all information related to that folder, e.g., id, name, tests count and direct children folder ids. &lt;br/&gt;

### Example
```java
// Import classes:
import org.openapi.xray.invoker.ApiClient;
import org.openapi.xray.invoker.ApiException;
import org.openapi.xray.invoker.Configuration;
import org.openapi.xray.invoker.auth.*;
import org.openapi.xray.invoker.models.*;
import org.openapi.xray.api.TestRepositoryApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.xpand-it.com/rest/raven/2.0/api");
    
    // Configure HTTP basic authorization: BasicAuth
    HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
    BasicAuth.setUsername("YOUR USERNAME");
    BasicAuth.setPassword("YOUR PASSWORD");

    TestRepositoryApi apiInstance = new TestRepositoryApi(defaultClient);
    String projectKey = "projectKey_example"; // String | The project key
    Integer folderId = 56; // Integer | The folder id.\"-1\" corresponds to the root folder of the Test Repository
    try {
      OneOfFolderRestBeanset result = apiInstance.testrepositoryProjectKeyFoldersFolderIdGet(projectKey, folderId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TestRepositoryApi#testrepositoryProjectKeyFoldersFolderIdGet");
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
 **projectKey** | **String**| The project key |
 **folderId** | **Integer**| The folder id.\&quot;-1\&quot; corresponds to the root folder of the Test Repository |

### Return type

[**OneOfFolderRestBeanset**](OneOfFolderRestBeanset.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Successful operation. Returns a CSV file with the dataset information. |  -  |
**400** | Bad Request |  -  |

