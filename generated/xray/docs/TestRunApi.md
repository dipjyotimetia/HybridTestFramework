# TestRunApi

All URIs are relative to *https://sandbox.xpand-it.com/rest/raven/2.0/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getTestruns**](TestRunApi.md#getTestruns) | **GET** /testruns | 
[**testrunGet**](TestRunApi.md#testrunGet) | **GET** /testrun | 
[**testrunIdCustomfieldCustomFieldIdGet**](TestRunApi.md#testrunIdCustomfieldCustomFieldIdGet) | **GET** /testrun/{id}/customfield/{customFieldId} | 
[**testrunIdCustomfieldCustomFieldIdPut**](TestRunApi.md#testrunIdCustomfieldCustomFieldIdPut) | **PUT** /testrun/{id}/customfield/{customFieldId} | 
[**testrunIdGet**](TestRunApi.md#testrunIdGet) | **GET** /testrun/{id} | 
[**testrunIdIterationIterationIdGet**](TestRunApi.md#testrunIdIterationIterationIdGet) | **GET** /testrun/{id}/iteration/{iterationId} | 
[**testrunIdIterationIterationIdPut**](TestRunApi.md#testrunIdIterationIterationIdPut) | **PUT** /testrun/{id}/iteration/{iterationId} | 
[**testrunIdIterationIterationIdStepGet**](TestRunApi.md#testrunIdIterationIterationIdStepGet) | **GET** /testrun/{id}/iteration/{iterationId}/step | 
[**testrunIdIterationIterationIdStepStepResultIdAttachmentAttachmentIdDelete**](TestRunApi.md#testrunIdIterationIterationIdStepStepResultIdAttachmentAttachmentIdDelete) | **DELETE** /testrun/{id}/iteration/{iterationId}/step/{stepResultId}/attachment/{attachmentId} | 
[**testrunIdIterationIterationIdStepStepResultIdAttachmentDelete**](TestRunApi.md#testrunIdIterationIterationIdStepStepResultIdAttachmentDelete) | **DELETE** /testrun/{id}/iteration/{iterationId}/step/{stepResultId}/attachment | 
[**testrunIdIterationIterationIdStepStepResultIdAttachmentGet**](TestRunApi.md#testrunIdIterationIterationIdStepStepResultIdAttachmentGet) | **GET** /testrun/{id}/iteration/{iterationId}/step/{stepResultId}/attachment | 
[**testrunIdIterationIterationIdStepStepResultIdAttachmentPost**](TestRunApi.md#testrunIdIterationIterationIdStepStepResultIdAttachmentPost) | **POST** /testrun/{id}/iteration/{iterationId}/step/{stepResultId}/attachment | 
[**testrunIdIterationIterationIdStepStepResultIdGet**](TestRunApi.md#testrunIdIterationIterationIdStepStepResultIdGet) | **GET** /testrun/{id}/iteration/{iterationId}/step/{stepResultId} | 
[**testrunIdIterationIterationIdStepStepResultIdPut**](TestRunApi.md#testrunIdIterationIterationIdStepStepResultIdPut) | **PUT** /testrun/{id}/iteration/{iterationId}/step/{stepResultId} | 
[**testrunIdIterationIterationIdStepStepResultIdStatusGet**](TestRunApi.md#testrunIdIterationIterationIdStepStepResultIdStatusGet) | **GET** /testrun/{id}/iteration/{iterationId}/step/{stepResultId}/status | 
[**testrunIdIterationIterationIdStepStepResultIdStatusPut**](TestRunApi.md#testrunIdIterationIterationIdStepStepResultIdStatusPut) | **PUT** /testrun/{id}/iteration/{iterationId}/step/{stepResultId}/status | 
[**testrunIdPut**](TestRunApi.md#testrunIdPut) | **PUT** /testrun/{id} | 


<a name="getTestruns"></a>
# **getTestruns**
> Set&lt;InlineResponse2001&gt; getTestruns(testExecKey, testKey, testPlanKey, includeTestFields, savedFilterId, limit, page)



Retrieves all the Test Runs from a given context. With this endpoint you can obtain all the Test Runs (paginated) in one of the following contexts: - In a Test Execution issue. A Test issue key can be used in order to return a single TestRun from the Test Execution issue - In a Test Plan issue - In a JQL filter that returns several Test Execution issue  In case the Test Run has iterations, steps will not appear. However, if the Test has parameters but executed one time, it will show the steps and the parameters info. &lt;br/&gt;

### Example
```java
// Import classes:
import org.openapi.xray.invoker.ApiClient;
import org.openapi.xray.invoker.ApiException;
import org.openapi.xray.invoker.Configuration;
import org.openapi.xray.invoker.auth.*;
import org.openapi.xray.invoker.models.*;
import org.openapi.xray.api.TestRunApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.xpand-it.com/rest/raven/2.0/api");
    
    // Configure HTTP basic authorization: BasicAuth
    HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
    BasicAuth.setUsername("YOUR USERNAME");
    BasicAuth.setPassword("YOUR PASSWORD");

    TestRunApi apiInstance = new TestRunApi(defaultClient);
    String testExecKey = "testExecKey_example"; // String | The Test Execution issue key
    String testKey = "testKey_example"; // String | The Test issue key (may only be used when using the \"testExecKey\"  param)
    String testPlanKey = "testPlanKey_example"; // String | The Test Plan issue key
    String includeTestFields = "includeTestFields_example"; // String | List of custom fields of the Test issue to be return in the responde (several custom fields can be requested by separating them with ',')
    String savedFilterId = "savedFilterId_example"; // String | The Jira JQL filter ID or name containing Test Executions issues
    Integer limit = 56; // Integer | The number of maximum Test Runs to be returned
    Integer page = 56; // Integer | The number of the results page
    try {
      Set<InlineResponse2001> result = apiInstance.getTestruns(testExecKey, testKey, testPlanKey, includeTestFields, savedFilterId, limit, page);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TestRunApi#getTestruns");
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
 **testExecKey** | **String**| The Test Execution issue key | [optional]
 **testKey** | **String**| The Test issue key (may only be used when using the \&quot;testExecKey\&quot;  param) | [optional]
 **testPlanKey** | **String**| The Test Plan issue key | [optional]
 **includeTestFields** | **String**| List of custom fields of the Test issue to be return in the responde (several custom fields can be requested by separating them with &#39;,&#39;) | [optional]
 **savedFilterId** | **String**| The Jira JQL filter ID or name containing Test Executions issues | [optional]
 **limit** | **Integer**| The number of maximum Test Runs to be returned | [optional]
 **page** | **Integer**| The number of the results page | [optional]

### Return type

[**Set&lt;InlineResponse2001&gt;**](InlineResponse2001.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |
**400** | Bad Request |  -  |
**500** | Internal Server Error |  -  |

<a name="testrunGet"></a>
# **testrunGet**
> TestRunResponse testrunGet(testExecIssueKey, testIssueKey)



Retrieves a Test Run given the Test Execution and Test keys. &lt;br/&gt; The response will contain all information related to a Test Run, e.g., status, created and finish dates, step results, test environments, defects, Test Run Custom fields, and so on. &lt;br/&gt;  In case the Test Run has iterations, steps will not appear. However, if it has parameters but executed one time, it will show the steps and the parameters info. &lt;br/&gt;

### Example
```java
// Import classes:
import org.openapi.xray.invoker.ApiClient;
import org.openapi.xray.invoker.ApiException;
import org.openapi.xray.invoker.Configuration;
import org.openapi.xray.invoker.auth.*;
import org.openapi.xray.invoker.models.*;
import org.openapi.xray.api.TestRunApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.xpand-it.com/rest/raven/2.0/api");
    
    // Configure HTTP basic authorization: BasicAuth
    HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
    BasicAuth.setUsername("YOUR USERNAME");
    BasicAuth.setPassword("YOUR PASSWORD");

    TestRunApi apiInstance = new TestRunApi(defaultClient);
    String testExecIssueKey = "testExecIssueKey_example"; // String | The key of the Test Execution
    String testIssueKey = "testIssueKey_example"; // String | The key of the Test
    try {
      TestRunResponse result = apiInstance.testrunGet(testExecIssueKey, testIssueKey);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TestRunApi#testrunGet");
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
 **testExecIssueKey** | **String**| The key of the Test Execution |
 **testIssueKey** | **String**| The key of the Test |

### Return type

[**TestRunResponse**](TestRunResponse.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Successful operation. Returns a body containg the Test Run information. |  -  |
**400** | Bad Request |  -  |
**500** | Internal Server error |  -  |

<a name="testrunIdCustomfieldCustomFieldIdGet"></a>
# **testrunIdCustomfieldCustomFieldIdGet**
> TestRunCustomFieldResponse testrunIdCustomfieldCustomFieldIdGet(id, customFieldId)



Retrieves a Test Run Custom Field, given the Test Run and the Test Run Custom Field ids.

### Example
```java
// Import classes:
import org.openapi.xray.invoker.ApiClient;
import org.openapi.xray.invoker.ApiException;
import org.openapi.xray.invoker.Configuration;
import org.openapi.xray.invoker.auth.*;
import org.openapi.xray.invoker.models.*;
import org.openapi.xray.api.TestRunApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.xpand-it.com/rest/raven/2.0/api");
    
    // Configure HTTP basic authorization: BasicAuth
    HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
    BasicAuth.setUsername("YOUR USERNAME");
    BasicAuth.setPassword("YOUR PASSWORD");

    TestRunApi apiInstance = new TestRunApi(defaultClient);
    String id = "id_example"; // String | The id of the Test Run
    String customFieldId = "customFieldId_example"; // String | The id of the Test Run Custom Field
    try {
      TestRunCustomFieldResponse result = apiInstance.testrunIdCustomfieldCustomFieldIdGet(id, customFieldId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TestRunApi#testrunIdCustomfieldCustomFieldIdGet");
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
 **id** | **String**| The id of the Test Run |
 **customFieldId** | **String**| The id of the Test Run Custom Field |

### Return type

[**TestRunCustomFieldResponse**](TestRunCustomFieldResponse.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Successful operation. Returns the value of the custom field for the given Test Run. |  -  |
**400** | Bad Request |  -  |
**500** | Internal Server Error |  -  |

<a name="testrunIdCustomfieldCustomFieldIdPut"></a>
# **testrunIdCustomfieldCustomFieldIdPut**
> testrunIdCustomfieldCustomFieldIdPut(id, customFieldId, UNKNOWN_BASE_TYPE)



Updates the value of a test run custom field, given the Test Run and the Test Run Custom Field ids. The custom field value should be a valid value according to the field type. &lt;br/&gt;&lt;br/&gt; - **Toggle Fields** values should be _\&quot;true\&quot;_, _\&quot;false\&quot;_, _\&quot;0\&quot;_ or _\&quot;1\&quot;_ &lt;br /&gt;&lt;br /&gt; - **Number Fields** values should be a string containing a number, e.g. _\&quot;320\&quot;_. Decimal Number are also accepted,for instance, \&quot;320.5\&quot;. The decimal places are always separated by a _\&quot;.\&quot;_  &lt;br /&gt; &lt;br /&gt; - **Single Select and Radio Button Fields** values should be a single string containing the option value, e.g. _\&quot;Option A\&quot;_. The value should be a valid option for that custom field. The values are not case sensitive. &lt;br /&gt;&lt;br /&gt; - **Multiple Select Fields** values should be an array of the string of option values, e.g. _[\&quot;Option A\&quot;, \&quot;Option B\&quot;]_. All the selected values should be valid for that custom field. The option values are not case sensitive. &lt;br /&gt;&lt;br /&gt; - **Date Fields** should follow the ISO format _yyyy-MM-dd_, where _yyyy_ represents the year, _MM_ the month in year and _dd_ the day in the month. For instance, a valid value would be _\&quot;2020-05-02\&quot;_. &lt;br /&gt;&lt;br /&gt; - **Date Time fields** should be in UTC following the ISO format _yyyy-MM-dd&#39;T&#39;HH:mm&#39;Z&#39;_. The date part follows the same date format, while _HH_ represents the hours (0-24), _mm_ the minutes in hour and _Z_ indicates the hour in UTC. For instance, a valid date time value would be _\&quot;2020-05-02T10:30Z\&quot;_. &lt;br /&gt;&lt;br /&gt; An error will be returned when there are invalid custom field values. It is also possible to delete a Test Run custom field value by providing a _null_ or empty value (e.g., _\&quot;\&quot;_ or _[]_). **It is not possible to delete a value of a required Test Run Custom Field value.** &lt;br/&gt;

### Example
```java
// Import classes:
import org.openapi.xray.invoker.ApiClient;
import org.openapi.xray.invoker.ApiException;
import org.openapi.xray.invoker.Configuration;
import org.openapi.xray.invoker.auth.*;
import org.openapi.xray.invoker.models.*;
import org.openapi.xray.api.TestRunApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.xpand-it.com/rest/raven/2.0/api");
    
    // Configure HTTP basic authorization: BasicAuth
    HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
    BasicAuth.setUsername("YOUR USERNAME");
    BasicAuth.setPassword("YOUR PASSWORD");

    TestRunApi apiInstance = new TestRunApi(defaultClient);
    String id = "id_example"; // String | The id of the Test Run
    String customFieldId = "customFieldId_example"; // String | The id of the Test Run Custom Field
    UNKNOWN_BASE_TYPE UNKNOWN_BASE_TYPE = new UNKNOWN_BASE_TYPE(); // UNKNOWN_BASE_TYPE | 
    try {
      apiInstance.testrunIdCustomfieldCustomFieldIdPut(id, customFieldId, UNKNOWN_BASE_TYPE);
    } catch (ApiException e) {
      System.err.println("Exception when calling TestRunApi#testrunIdCustomfieldCustomFieldIdPut");
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
 **id** | **String**| The id of the Test Run |
 **customFieldId** | **String**| The id of the Test Run Custom Field |
 **UNKNOWN_BASE_TYPE** | [**UNKNOWN_BASE_TYPE**](UNKNOWN_BASE_TYPE.md)|  |

### Return type

null (empty response body)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**204** | Successful operation |  -  |
**400** | Bad Request |  -  |
**500** | Internal Server Error |  -  |

<a name="testrunIdGet"></a>
# **testrunIdGet**
> TestRunResponse testrunIdGet(id)



Retrieves a Test Run given the Test Execution and Test keys. &lt;br/&gt; The response will contain all information related to a Test Run, e.g., status, created and finish dates, step results, test environments, defects, Test Run Custom fields, and so on. &lt;br/&gt;  In case the Test Run has iterations, steps will not appear. However, if it has parameters but executed one time, it will show the steps and the parameters info. &lt;br/&gt;

### Example
```java
// Import classes:
import org.openapi.xray.invoker.ApiClient;
import org.openapi.xray.invoker.ApiException;
import org.openapi.xray.invoker.Configuration;
import org.openapi.xray.invoker.auth.*;
import org.openapi.xray.invoker.models.*;
import org.openapi.xray.api.TestRunApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.xpand-it.com/rest/raven/2.0/api");
    
    // Configure HTTP basic authorization: BasicAuth
    HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
    BasicAuth.setUsername("YOUR USERNAME");
    BasicAuth.setPassword("YOUR PASSWORD");

    TestRunApi apiInstance = new TestRunApi(defaultClient);
    String id = "id_example"; // String | The id of the Test Run
    try {
      TestRunResponse result = apiInstance.testrunIdGet(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TestRunApi#testrunIdGet");
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
 **id** | **String**| The id of the Test Run |

### Return type

[**TestRunResponse**](TestRunResponse.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Successful operation |  -  |
**400** | Bad Request |  -  |
**500** | Internal Server Error |  -  |

<a name="testrunIdIterationIterationIdGet"></a>
# **testrunIdIterationIterationIdGet**
> TestRunIterationInformation testrunIdIterationIterationIdGet(id, iterationId)



Retrieves an iteration given the Test Run id and the id of the iteration. &lt;br/&gt; The response will contain all the information regarding the iteration (status, parameters, and the steps). The steps will appear with the parameters converted to their value if the resolved dataset does not have a parameter referenced on a  step it will be displayed like ${parameter_name}. &lt;br/&gt;

### Example
```java
// Import classes:
import org.openapi.xray.invoker.ApiClient;
import org.openapi.xray.invoker.ApiException;
import org.openapi.xray.invoker.Configuration;
import org.openapi.xray.invoker.auth.*;
import org.openapi.xray.invoker.models.*;
import org.openapi.xray.api.TestRunApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.xpand-it.com/rest/raven/2.0/api");
    
    // Configure HTTP basic authorization: BasicAuth
    HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
    BasicAuth.setUsername("YOUR USERNAME");
    BasicAuth.setPassword("YOUR PASSWORD");

    TestRunApi apiInstance = new TestRunApi(defaultClient);
    String id = "id_example"; // String | The id of the Test Run
    String iterationId = "iterationId_example"; // String | The id of the iteration
    try {
      TestRunIterationInformation result = apiInstance.testrunIdIterationIterationIdGet(id, iterationId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TestRunApi#testrunIdIterationIterationIdGet");
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
 **id** | **String**| The id of the Test Run |
 **iterationId** | **String**| The id of the iteration |

### Return type

[**TestRunIterationInformation**](TestRunIterationInformation.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Successful operation |  -  |
**400** | Bad Request |  -  |
**500** | Internal Server Error |  -  |

<a name="testrunIdIterationIterationIdPut"></a>
# **testrunIdIterationIterationIdPut**
> UpdateIterationResponse testrunIdIterationIterationIdPut(id, iterationId, updateIteration)



Update all values from an iteration in a Test Run.&lt;br/&gt; The user can update the iteration status and the Test Step results of that iteration.

### Example
```java
// Import classes:
import org.openapi.xray.invoker.ApiClient;
import org.openapi.xray.invoker.ApiException;
import org.openapi.xray.invoker.Configuration;
import org.openapi.xray.invoker.auth.*;
import org.openapi.xray.invoker.models.*;
import org.openapi.xray.api.TestRunApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.xpand-it.com/rest/raven/2.0/api");
    
    // Configure HTTP basic authorization: BasicAuth
    HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
    BasicAuth.setUsername("YOUR USERNAME");
    BasicAuth.setPassword("YOUR PASSWORD");

    TestRunApi apiInstance = new TestRunApi(defaultClient);
    String id = "id_example"; // String | The id of the Test Run
    String iterationId = "iterationId_example"; // String | The id of the iteration
    UpdateIteration updateIteration = new UpdateIteration(); // UpdateIteration | 
    try {
      UpdateIterationResponse result = apiInstance.testrunIdIterationIterationIdPut(id, iterationId, updateIteration);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TestRunApi#testrunIdIterationIterationIdPut");
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
 **id** | **String**| The id of the Test Run |
 **iterationId** | **String**| The id of the iteration |
 **updateIteration** | [**UpdateIteration**](UpdateIteration.md)|  |

### Return type

[**UpdateIterationResponse**](UpdateIterationResponse.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Successful operation |  -  |
**400** | Bad Request |  -  |
**500** | Internal Server Error |  -  |

<a name="testrunIdIterationIterationIdStepGet"></a>
# **testrunIdIterationIterationIdStepGet**
> List&lt;StepResult&gt; testrunIdIterationIterationIdStepGet(id, iterationId)



Retrieves all Test Step results for the given iteration.

### Example
```java
// Import classes:
import org.openapi.xray.invoker.ApiClient;
import org.openapi.xray.invoker.ApiException;
import org.openapi.xray.invoker.Configuration;
import org.openapi.xray.invoker.auth.*;
import org.openapi.xray.invoker.models.*;
import org.openapi.xray.api.TestRunApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.xpand-it.com/rest/raven/2.0/api");
    
    // Configure HTTP basic authorization: BasicAuth
    HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
    BasicAuth.setUsername("YOUR USERNAME");
    BasicAuth.setPassword("YOUR PASSWORD");

    TestRunApi apiInstance = new TestRunApi(defaultClient);
    String id = "id_example"; // String | The id of the Test Run
    String iterationId = "iterationId_example"; // String | The id of the iteration
    try {
      List<StepResult> result = apiInstance.testrunIdIterationIterationIdStepGet(id, iterationId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TestRunApi#testrunIdIterationIterationIdStepGet");
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
 **id** | **String**| The id of the Test Run |
 **iterationId** | **String**| The id of the iteration |

### Return type

[**List&lt;StepResult&gt;**](StepResult.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Successful operation |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |

<a name="testrunIdIterationIterationIdStepStepResultIdAttachmentAttachmentIdDelete"></a>
# **testrunIdIterationIterationIdStepStepResultIdAttachmentAttachmentIdDelete**
> testrunIdIterationIterationIdStepStepResultIdAttachmentAttachmentIdDelete(id, iterationId, stepResultId, attachmentId)



Remove an evidence from a Test Step result within an iteration.

### Example
```java
// Import classes:
import org.openapi.xray.invoker.ApiClient;
import org.openapi.xray.invoker.ApiException;
import org.openapi.xray.invoker.Configuration;
import org.openapi.xray.invoker.auth.*;
import org.openapi.xray.invoker.models.*;
import org.openapi.xray.api.TestRunApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.xpand-it.com/rest/raven/2.0/api");
    
    // Configure HTTP basic authorization: BasicAuth
    HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
    BasicAuth.setUsername("YOUR USERNAME");
    BasicAuth.setPassword("YOUR PASSWORD");

    TestRunApi apiInstance = new TestRunApi(defaultClient);
    String id = "id_example"; // String | The id of the Test Run
    String iterationId = "iterationId_example"; // String | The id of the iteration
    String stepResultId = "stepResultId_example"; // String | The id of the Test Step result
    String attachmentId = "attachmentId_example"; // String | The id of the attachment to be deleted
    try {
      apiInstance.testrunIdIterationIterationIdStepStepResultIdAttachmentAttachmentIdDelete(id, iterationId, stepResultId, attachmentId);
    } catch (ApiException e) {
      System.err.println("Exception when calling TestRunApi#testrunIdIterationIterationIdStepStepResultIdAttachmentAttachmentIdDelete");
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
 **id** | **String**| The id of the Test Run |
 **iterationId** | **String**| The id of the iteration |
 **stepResultId** | **String**| The id of the Test Step result |
 **attachmentId** | **String**| The id of the attachment to be deleted |

### Return type

null (empty response body)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**204** | Successful operation. No content is returned. |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |

<a name="testrunIdIterationIterationIdStepStepResultIdAttachmentDelete"></a>
# **testrunIdIterationIterationIdStepStepResultIdAttachmentDelete**
> testrunIdIterationIterationIdStepStepResultIdAttachmentDelete(id, iterationId, stepResultId, filename)



Remove all evidences with the same filename from the Test step result within an iteration.

### Example
```java
// Import classes:
import org.openapi.xray.invoker.ApiClient;
import org.openapi.xray.invoker.ApiException;
import org.openapi.xray.invoker.Configuration;
import org.openapi.xray.invoker.auth.*;
import org.openapi.xray.invoker.models.*;
import org.openapi.xray.api.TestRunApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.xpand-it.com/rest/raven/2.0/api");
    
    // Configure HTTP basic authorization: BasicAuth
    HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
    BasicAuth.setUsername("YOUR USERNAME");
    BasicAuth.setPassword("YOUR PASSWORD");

    TestRunApi apiInstance = new TestRunApi(defaultClient);
    String id = "id_example"; // String | The id of the Test Run
    String iterationId = "iterationId_example"; // String | The id of the iteration
    String stepResultId = "stepResultId_example"; // String | The id of the Test Step result
    String filename = "filename_example"; // String | The name of the attachment to be deleted
    try {
      apiInstance.testrunIdIterationIterationIdStepStepResultIdAttachmentDelete(id, iterationId, stepResultId, filename);
    } catch (ApiException e) {
      System.err.println("Exception when calling TestRunApi#testrunIdIterationIterationIdStepStepResultIdAttachmentDelete");
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
 **id** | **String**| The id of the Test Run |
 **iterationId** | **String**| The id of the iteration |
 **stepResultId** | **String**| The id of the Test Step result |
 **filename** | **String**| The name of the attachment to be deleted |

### Return type

null (empty response body)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**204** | Successful operation. No content is returned. |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |

<a name="testrunIdIterationIterationIdStepStepResultIdAttachmentGet"></a>
# **testrunIdIterationIterationIdStepStepResultIdAttachmentGet**
> List&lt;FileResponse&gt; testrunIdIterationIterationIdStepStepResultIdAttachmentGet(id, iterationId, stepResultId)



Return a json that contains an array with all the execution evidences the Test Step has within an iteration.

### Example
```java
// Import classes:
import org.openapi.xray.invoker.ApiClient;
import org.openapi.xray.invoker.ApiException;
import org.openapi.xray.invoker.Configuration;
import org.openapi.xray.invoker.auth.*;
import org.openapi.xray.invoker.models.*;
import org.openapi.xray.api.TestRunApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.xpand-it.com/rest/raven/2.0/api");
    
    // Configure HTTP basic authorization: BasicAuth
    HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
    BasicAuth.setUsername("YOUR USERNAME");
    BasicAuth.setPassword("YOUR PASSWORD");

    TestRunApi apiInstance = new TestRunApi(defaultClient);
    String id = "id_example"; // String | The id of the Test Run
    String iterationId = "iterationId_example"; // String | The id of the iteration
    String stepResultId = "stepResultId_example"; // String | The id of the Test Step result
    try {
      List<FileResponse> result = apiInstance.testrunIdIterationIterationIdStepStepResultIdAttachmentGet(id, iterationId, stepResultId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TestRunApi#testrunIdIterationIterationIdStepStepResultIdAttachmentGet");
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
 **id** | **String**| The id of the Test Run |
 **iterationId** | **String**| The id of the iteration |
 **stepResultId** | **String**| The id of the Test Step result |

### Return type

[**List&lt;FileResponse&gt;**](FileResponse.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Successful operation |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |

<a name="testrunIdIterationIterationIdStepStepResultIdAttachmentPost"></a>
# **testrunIdIterationIterationIdStepStepResultIdAttachmentPost**
> testrunIdIterationIterationIdStepStepResultIdAttachmentPost(id, iterationId, stepResultId, testStepResultEvidenceInput)



Add a new evidence to the Test Step result within an iteration.

### Example
```java
// Import classes:
import org.openapi.xray.invoker.ApiClient;
import org.openapi.xray.invoker.ApiException;
import org.openapi.xray.invoker.Configuration;
import org.openapi.xray.invoker.auth.*;
import org.openapi.xray.invoker.models.*;
import org.openapi.xray.api.TestRunApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.xpand-it.com/rest/raven/2.0/api");
    
    // Configure HTTP basic authorization: BasicAuth
    HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
    BasicAuth.setUsername("YOUR USERNAME");
    BasicAuth.setPassword("YOUR PASSWORD");

    TestRunApi apiInstance = new TestRunApi(defaultClient);
    String id = "id_example"; // String | The id of the Test Run
    String iterationId = "iterationId_example"; // String | The id of the iteration
    String stepResultId = "stepResultId_example"; // String | The id of the Test Step result
    TestStepResultEvidenceInput testStepResultEvidenceInput = new TestStepResultEvidenceInput(); // TestStepResultEvidenceInput | 
    try {
      apiInstance.testrunIdIterationIterationIdStepStepResultIdAttachmentPost(id, iterationId, stepResultId, testStepResultEvidenceInput);
    } catch (ApiException e) {
      System.err.println("Exception when calling TestRunApi#testrunIdIterationIterationIdStepStepResultIdAttachmentPost");
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
 **id** | **String**| The id of the Test Run |
 **iterationId** | **String**| The id of the iteration |
 **stepResultId** | **String**| The id of the Test Step result |
 **testStepResultEvidenceInput** | [**TestStepResultEvidenceInput**](TestStepResultEvidenceInput.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**204** | Successful operation. No content is returned. |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |

<a name="testrunIdIterationIterationIdStepStepResultIdGet"></a>
# **testrunIdIterationIterationIdStepStepResultIdGet**
> StepResult testrunIdIterationIterationIdStepStepResultIdGet(id, iterationId, stepResultId)



Retrieves all the information for the given Test Step result within an iteration.

### Example
```java
// Import classes:
import org.openapi.xray.invoker.ApiClient;
import org.openapi.xray.invoker.ApiException;
import org.openapi.xray.invoker.Configuration;
import org.openapi.xray.invoker.auth.*;
import org.openapi.xray.invoker.models.*;
import org.openapi.xray.api.TestRunApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.xpand-it.com/rest/raven/2.0/api");
    
    // Configure HTTP basic authorization: BasicAuth
    HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
    BasicAuth.setUsername("YOUR USERNAME");
    BasicAuth.setPassword("YOUR PASSWORD");

    TestRunApi apiInstance = new TestRunApi(defaultClient);
    String id = "id_example"; // String | The id of the Test Run
    String iterationId = "iterationId_example"; // String | The id of the iteration
    String stepResultId = "stepResultId_example"; // String | The id of the Test Step result
    try {
      StepResult result = apiInstance.testrunIdIterationIterationIdStepStepResultIdGet(id, iterationId, stepResultId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TestRunApi#testrunIdIterationIterationIdStepStepResultIdGet");
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
 **id** | **String**| The id of the Test Run |
 **iterationId** | **String**| The id of the iteration |
 **stepResultId** | **String**| The id of the Test Step result |

### Return type

[**StepResult**](StepResult.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Successful operation |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |

<a name="testrunIdIterationIterationIdStepStepResultIdPut"></a>
# **testrunIdIterationIterationIdStepStepResultIdPut**
> StepResultsResponse testrunIdIterationIterationIdStepStepResultIdPut(id, iterationId, stepResultId, updateStepResult)



Updates the Test Step result within an iteration.

### Example
```java
// Import classes:
import org.openapi.xray.invoker.ApiClient;
import org.openapi.xray.invoker.ApiException;
import org.openapi.xray.invoker.Configuration;
import org.openapi.xray.invoker.auth.*;
import org.openapi.xray.invoker.models.*;
import org.openapi.xray.api.TestRunApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.xpand-it.com/rest/raven/2.0/api");
    
    // Configure HTTP basic authorization: BasicAuth
    HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
    BasicAuth.setUsername("YOUR USERNAME");
    BasicAuth.setPassword("YOUR PASSWORD");

    TestRunApi apiInstance = new TestRunApi(defaultClient);
    String id = "id_example"; // String | The id of the Test Run
    String iterationId = "iterationId_example"; // String | The id of the iteration
    String stepResultId = "stepResultId_example"; // String | The id of the Test Step result
    UpdateStepResult updateStepResult = new UpdateStepResult(); // UpdateStepResult | 
    try {
      StepResultsResponse result = apiInstance.testrunIdIterationIterationIdStepStepResultIdPut(id, iterationId, stepResultId, updateStepResult);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TestRunApi#testrunIdIterationIterationIdStepStepResultIdPut");
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
 **id** | **String**| The id of the Test Run |
 **iterationId** | **String**| The id of the iteration |
 **stepResultId** | **String**| The id of the Test Step result |
 **updateStepResult** | [**UpdateStepResult**](UpdateStepResult.md)|  |

### Return type

[**StepResultsResponse**](StepResultsResponse.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Successful operation |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |

<a name="testrunIdIterationIterationIdStepStepResultIdStatusGet"></a>
# **testrunIdIterationIterationIdStepStepResultIdStatusGet**
> InlineResponse200 testrunIdIterationIterationIdStepStepResultIdStatusGet(id, iterationId, stepResultId)



Retrieves the Test Step status of a Test Step Result within an iteration.

### Example
```java
// Import classes:
import org.openapi.xray.invoker.ApiClient;
import org.openapi.xray.invoker.ApiException;
import org.openapi.xray.invoker.Configuration;
import org.openapi.xray.invoker.auth.*;
import org.openapi.xray.invoker.models.*;
import org.openapi.xray.api.TestRunApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.xpand-it.com/rest/raven/2.0/api");
    
    // Configure HTTP basic authorization: BasicAuth
    HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
    BasicAuth.setUsername("YOUR USERNAME");
    BasicAuth.setPassword("YOUR PASSWORD");

    TestRunApi apiInstance = new TestRunApi(defaultClient);
    String id = "id_example"; // String | The id of the Test Run
    String iterationId = "iterationId_example"; // String | The id of the iteration
    String stepResultId = "stepResultId_example"; // String | The id of the Test Step result
    try {
      InlineResponse200 result = apiInstance.testrunIdIterationIterationIdStepStepResultIdStatusGet(id, iterationId, stepResultId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TestRunApi#testrunIdIterationIterationIdStepStepResultIdStatusGet");
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
 **id** | **String**| The id of the Test Run |
 **iterationId** | **String**| The id of the iteration |
 **stepResultId** | **String**| The id of the Test Step result |

### Return type

[**InlineResponse200**](InlineResponse200.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Successful operation |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |

<a name="testrunIdIterationIterationIdStepStepResultIdStatusPut"></a>
# **testrunIdIterationIterationIdStepStepResultIdStatusPut**
> testrunIdIterationIterationIdStepStepResultIdStatusPut(id, iterationId, stepResultId, status)



Updates the Test Step status within an iteration.

### Example
```java
// Import classes:
import org.openapi.xray.invoker.ApiClient;
import org.openapi.xray.invoker.ApiException;
import org.openapi.xray.invoker.Configuration;
import org.openapi.xray.invoker.auth.*;
import org.openapi.xray.invoker.models.*;
import org.openapi.xray.api.TestRunApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.xpand-it.com/rest/raven/2.0/api");
    
    // Configure HTTP basic authorization: BasicAuth
    HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
    BasicAuth.setUsername("YOUR USERNAME");
    BasicAuth.setPassword("YOUR PASSWORD");

    TestRunApi apiInstance = new TestRunApi(defaultClient);
    String id = "id_example"; // String | The id of the Test Run
    String iterationId = "iterationId_example"; // String | The id of the iteration
    String stepResultId = "stepResultId_example"; // String | The id of the Test Step result
    String status = "status_example"; // String | The status we want the test step to have
    try {
      apiInstance.testrunIdIterationIterationIdStepStepResultIdStatusPut(id, iterationId, stepResultId, status);
    } catch (ApiException e) {
      System.err.println("Exception when calling TestRunApi#testrunIdIterationIterationIdStepStepResultIdStatusPut");
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
 **id** | **String**| The id of the Test Run |
 **iterationId** | **String**| The id of the iteration |
 **stepResultId** | **String**| The id of the Test Step result |
 **status** | **String**| The status we want the test step to have |

### Return type

null (empty response body)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**204** | Successful operation. No content is returned. |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |

<a name="testrunIdPut"></a>
# **testrunIdPut**
> UpdateTestRunResponse testrunIdPut(id, updateTestRun)



Update all the values of a Test Run.&lt;br/&gt; The user can update the values of the overall status, step results, assignee, test environments, add defects and evidences and so on. &lt;br/&gt; &lt;br/&gt; To update the value of a Test Run custom field, the id of the field must be provided as well as a valid value for that custom field type. &lt;br/&gt;&lt;br/&gt; - **Toggle Fields** values should be _\&quot;true\&quot;_, _\&quot;false\&quot;_, _\&quot;0\&quot;_ or _\&quot;1\&quot;_ &lt;br /&gt;&lt;br /&gt; - **Number Fields** values should be a string containing a number, e.g. _\&quot;320\&quot;_. Decimal Number are also accepted,for instance, \&quot;320.5\&quot;. The decimal places are always separated by a _\&quot;.\&quot;_  &lt;br /&gt; &lt;br /&gt; - **Single Select and Radio Button Fields** values should be a single string containing the option value, e.g. _\&quot;Option A\&quot;_. The value should be a valid option for that custom field. The values are not case sensitive. &lt;br /&gt;&lt;br /&gt; - **Multiple Select Fields** values should be an array of the string of option values, e.g. _[\&quot;Option A\&quot;, \&quot;Option B\&quot;]_. All the selected values should be valid for that custom field. The option values are not case sensitive. &lt;br /&gt;&lt;br /&gt; - **Date Fields** should follow the ISO format _yyyy-MM-dd_, where _yyyy_ represents the year, _MM_ the month in year and _dd_ the day in the month. For instance, a valid value would be _\&quot;2020-05-02\&quot;_. &lt;br /&gt;&lt;br /&gt; - **Date Time fields** should be in UTC following the ISO format _yyyy-MM-dd&#39;T&#39;HH:mm&#39;Z&#39;_. The date part follows the same date format, while _HH_ represents the hours (0-24), _mm_ the minutes in hour and _Z_ indicates the hour in UTC. For instance, a valid date time value would be _\&quot;2020-05-02T10:30Z\&quot;_. &lt;br /&gt;&lt;br /&gt; An error will be returned when there are invalid custom field values. It is also possible to delete a Test Run custom field value by providing a _null_ or empty value (e.g., _\&quot;\&quot;_ or _[]_). **It is not possible to delete a value of a required Test Run Custom Field value.** &lt;br/&gt; Also, **it is not possible to change the Test Run to a final status when there are required Test Run custom fields with empty values.** &lt;br/&gt; &lt;br/&gt; In the case of a Test Run of a manual Test type, it is possible to update the steps only if there are zero or one iterations. If there are multiple iterations, it is not possible to update the steps through this endpoint, only the iterations.

### Example
```java
// Import classes:
import org.openapi.xray.invoker.ApiClient;
import org.openapi.xray.invoker.ApiException;
import org.openapi.xray.invoker.Configuration;
import org.openapi.xray.invoker.auth.*;
import org.openapi.xray.invoker.models.*;
import org.openapi.xray.api.TestRunApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.xpand-it.com/rest/raven/2.0/api");
    
    // Configure HTTP basic authorization: BasicAuth
    HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
    BasicAuth.setUsername("YOUR USERNAME");
    BasicAuth.setPassword("YOUR PASSWORD");

    TestRunApi apiInstance = new TestRunApi(defaultClient);
    String id = "id_example"; // String | The id of the Test Run
    UpdateTestRun updateTestRun = new UpdateTestRun(); // UpdateTestRun | 
    try {
      UpdateTestRunResponse result = apiInstance.testrunIdPut(id, updateTestRun);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TestRunApi#testrunIdPut");
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
 **id** | **String**| The id of the Test Run |
 **updateTestRun** | [**UpdateTestRun**](UpdateTestRun.md)|  |

### Return type

[**UpdateTestRunResponse**](UpdateTestRunResponse.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Successful operation |  -  |
**400** | Bad Request. Occurs when there is some error in the request, for instance, some custom field has an invalid value, or the user does not have permissions to execute the Test Run. |  -  |
**500** | Internal Server error |  -  |

