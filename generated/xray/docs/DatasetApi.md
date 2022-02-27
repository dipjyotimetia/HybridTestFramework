# DatasetApi

All URIs are relative to *https://sandbox.xpand-it.com/rest/raven/2.0/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**datasetExportGet**](DatasetApi.md#datasetExportGet) | **GET** /dataset/export | 


<a name="datasetExportGet"></a>
# **datasetExportGet**
> String datasetExportGet(testIssueId, testIssueKey, contextIssueId, contextIssueKey, resolved)



Retrieves a CSV file with the dataset information. &lt;br/&gt; The response will contain all information related to the dataset, e.g., parameters and values. &lt;br/&gt;

### Example
```java
// Import classes:
import org.openapi.xray.invoker.ApiClient;
import org.openapi.xray.invoker.ApiException;
import org.openapi.xray.invoker.Configuration;
import org.openapi.xray.invoker.auth.*;
import org.openapi.xray.invoker.models.*;
import org.openapi.xray.api.DatasetApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.xpand-it.com/rest/raven/2.0/api");
    
    // Configure HTTP basic authorization: BasicAuth
    HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
    BasicAuth.setUsername("YOUR USERNAME");
    BasicAuth.setPassword("YOUR PASSWORD");

    DatasetApi apiInstance = new DatasetApi(defaultClient);
    String testIssueId = "testIssueId_example"; // String | The id of the test issue
    String testIssueKey = "testIssueKey_example"; // String | The key of the test issue
    String contextIssueId = "contextIssueId_example"; // String | The id of the context issue (Test Plan or Test Execution)
    String contextIssueKey = "contextIssueKey_example"; // String | The key of the context issue (Test Plan or Test Execution)
    String resolved = "resolved_example"; // String | A flag indicating of the dataset must be resolved or not for a given level (true by default)
    try {
      String result = apiInstance.datasetExportGet(testIssueId, testIssueKey, contextIssueId, contextIssueKey, resolved);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DatasetApi#datasetExportGet");
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
 **testIssueId** | **String**| The id of the test issue | [optional]
 **testIssueKey** | **String**| The key of the test issue | [optional]
 **contextIssueId** | **String**| The id of the context issue (Test Plan or Test Execution) | [optional]
 **contextIssueKey** | **String**| The key of the context issue (Test Plan or Test Execution) | [optional]
 **resolved** | **String**| A flag indicating of the dataset must be resolved or not for a given level (true by default) | [optional]

### Return type

**String**

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/csv, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Successful operation. Returns a CSV file with the dataset information. |  -  |
**400** | Bad Request |  -  |
**403** | Forbidden |  -  |
**404** | Not found |  -  |
**500** | Internal Server error |  -  |

