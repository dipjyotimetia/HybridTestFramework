# TestStepApi

All URIs are relative to *https://sandbox.xpand-it.com/rest/raven/2.0/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**testTestKeyStepsGet**](TestStepApi.md#testTestKeyStepsGet) | **GET** /test/{testKey}/steps | 
[**testTestKeyStepsPost**](TestStepApi.md#testTestKeyStepsPost) | **POST** /test/{testKey}/steps | 
[**testTestKeyStepsStepIdAttachmentAttachmentIdDelete**](TestStepApi.md#testTestKeyStepsStepIdAttachmentAttachmentIdDelete) | **DELETE** /test/{testKey}/steps/{stepId}/attachment/{attachmentId} | 
[**testTestKeyStepsStepIdAttachmentsGet**](TestStepApi.md#testTestKeyStepsStepIdAttachmentsGet) | **GET** /test/{testKey}/steps/{stepId}/attachments | 
[**testTestKeyStepsStepIdDelete**](TestStepApi.md#testTestKeyStepsStepIdDelete) | **DELETE** /test/{testKey}/steps/{stepId} | 
[**testTestKeyStepsStepIdGet**](TestStepApi.md#testTestKeyStepsStepIdGet) | **GET** /test/{testKey}/steps/{stepId} | 
[**testTestKeyStepsStepIdPut**](TestStepApi.md#testTestKeyStepsStepIdPut) | **PUT** /test/{testKey}/steps/{stepId} | 


<a name="testTestKeyStepsGet"></a>
# **testTestKeyStepsGet**
> TestStepsResponse testTestKeyStepsGet(testKey)



Returns all the steps of a test issue given the key. The response contains for each step the corresponding id, index, fields and the attachments. &lt;br /&gt; &lt;br /&gt; The Test Step fields are identified by their name and can be of type _Data_ (Toggle, Number, Date and Date Time fields), _Option_ (Single Select, Multiple Select and Radio Button fields), _Wiki_ (Native fields, Single and Multiple Line fields). &lt;br /&gt; &lt;br /&gt; The value of step fields of type _Wiki_ have a raw and rendered value. _Option_ fields value will be an array containing the information of the selected options (the option id and its value).

### Example
```java
// Import classes:
import org.openapi.xray.invoker.ApiClient;
import org.openapi.xray.invoker.ApiException;
import org.openapi.xray.invoker.Configuration;
import org.openapi.xray.invoker.auth.*;
import org.openapi.xray.invoker.models.*;
import org.openapi.xray.api.TestStepApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.xpand-it.com/rest/raven/2.0/api");
    
    // Configure HTTP basic authorization: BasicAuth
    HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
    BasicAuth.setUsername("YOUR USERNAME");
    BasicAuth.setPassword("YOUR PASSWORD");

    TestStepApi apiInstance = new TestStepApi(defaultClient);
    String testKey = "testKey_example"; // String | The key of the test issue, e.g., CALC-562
    try {
      TestStepsResponse result = apiInstance.testTestKeyStepsGet(testKey);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TestStepApi#testTestKeyStepsGet");
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
 **testKey** | **String**| The key of the test issue, e.g., CALC-562 |

### Return type

[**TestStepsResponse**](TestStepsResponse.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Successful operation |  -  |
**400** | Bad Request. Occurs when there is some error in the request, for instance, the test with provided key does not exist or some field has an invalid value (e.g. Option \&quot;A\&quot; does not exist for an option field). |  -  |
**500** | Internal Server error |  -  |

<a name="testTestKeyStepsPost"></a>
# **testTestKeyStepsPost**
> CreateStepResponse testTestKeyStepsPost(testKey, createStepRequestBody)



Create a new test step. All step fields values are listed under _fields_ and identified by the name and a list of attachments to add to the step. The field values should follow a certain format according to the custom field type. &lt;br /&gt;&lt;br /&gt; - **Toggle Fields** values should be _\&quot;true\&quot;_, _\&quot;false\&quot;_, _\&quot;0\&quot;_ or _\&quot;1\&quot;_ &lt;br /&gt;&lt;br /&gt; - **Number Fields** values should be a string containing a number, e.g. _\&quot;320\&quot;_. Decimal Number are also accepted,for instance, \&quot;320.5\&quot;. The decimal places are always separated by a _\&quot;.\&quot;_ &lt;br /&gt; &lt;br /&gt; - **Single Select and Radio Button Fields** values should be a single string containing the option value, e.g. _\&quot;Option A\&quot;_. The value should be a valid option for that custom field. The values are not case sensitive. &lt;br /&gt;&lt;br /&gt; - **Multiple Select Fields** values should be an array of the string of option values, e.g. _[\&quot;Option A\&quot;, \&quot;Option B\&quot;]_. All the selected values should be valid for that custom field. The option values are not case sensitive. &lt;br /&gt;&lt;br /&gt; - **Date Fields** should follow the ISO format _yyyy-MM-dd_, where _yyyy_ represents the year, _MM_ the month in year and _dd_ the day in the month. For instance, a valid value would be _\&quot;2020-05-02\&quot;_. &lt;br /&gt;&lt;br /&gt; - **Date Time fields** should be in UTC following the ISO format _yyyy-MM-dd&#39;T&#39;HH:mm&#39;Z&#39;_. The date part follows the same date format, while _HH_ represents the hours (0-24), _mm_ the minutes in hour and _Z_ indicates the hour in UTC. For instance, a valid date time value would be _\&quot;2020-05-02T10:30Z\&quot;_. &lt;br /&gt;&lt;br /&gt; The remaining field types values do not required a specific validation. For instance, for a Single Line Custom field a valid value would be _\&quot;Perform Action B\&quot;_. &lt;br /&gt;&lt;br /&gt; If some value is not valid for a certain custom field type, an error will be return stating the field with the incorrect value. Furthermore, **all required step fields must be provided**.

### Example
```java
// Import classes:
import org.openapi.xray.invoker.ApiClient;
import org.openapi.xray.invoker.ApiException;
import org.openapi.xray.invoker.Configuration;
import org.openapi.xray.invoker.auth.*;
import org.openapi.xray.invoker.models.*;
import org.openapi.xray.api.TestStepApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.xpand-it.com/rest/raven/2.0/api");
    
    // Configure HTTP basic authorization: BasicAuth
    HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
    BasicAuth.setUsername("YOUR USERNAME");
    BasicAuth.setPassword("YOUR PASSWORD");

    TestStepApi apiInstance = new TestStepApi(defaultClient);
    String testKey = "testKey_example"; // String | The key of the test issue, e.g., CALC-562
    CreateStepRequestBody createStepRequestBody = new CreateStepRequestBody(); // CreateStepRequestBody | 
    try {
      CreateStepResponse result = apiInstance.testTestKeyStepsPost(testKey, createStepRequestBody);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TestStepApi#testTestKeyStepsPost");
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
 **testKey** | **String**| The key of the test issue, e.g., CALC-562 |
 **createStepRequestBody** | [**CreateStepRequestBody**](CreateStepRequestBody.md)|  |

### Return type

[**CreateStepResponse**](CreateStepResponse.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Successful operation. The response returns the id of the created steps as well as a list containing the attachments ids. Furthermore, the response contains a list of warning with some errors that may occur during the step creation, e.g., some attachment is not successfull created |  -  |
**400** | Bad Request |  -  |
**500** | Internal Server error |  -  |

<a name="testTestKeyStepsStepIdAttachmentAttachmentIdDelete"></a>
# **testTestKeyStepsStepIdAttachmentAttachmentIdDelete**
> testTestKeyStepsStepIdAttachmentAttachmentIdDelete(testKey, stepId, attachmentId)



Deletes a test step attachment, given the test key and step and attachment ids.

### Example
```java
// Import classes:
import org.openapi.xray.invoker.ApiClient;
import org.openapi.xray.invoker.ApiException;
import org.openapi.xray.invoker.Configuration;
import org.openapi.xray.invoker.auth.*;
import org.openapi.xray.invoker.models.*;
import org.openapi.xray.api.TestStepApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.xpand-it.com/rest/raven/2.0/api");
    
    // Configure HTTP basic authorization: BasicAuth
    HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
    BasicAuth.setUsername("YOUR USERNAME");
    BasicAuth.setPassword("YOUR PASSWORD");

    TestStepApi apiInstance = new TestStepApi(defaultClient);
    String testKey = "testKey_example"; // String | Test with key CALC-123 does not exist or is not a manual test.
    Integer stepId = 56; // Integer | The id of the test step
    Integer attachmentId = 56; // Integer | The id of the attachment
    try {
      apiInstance.testTestKeyStepsStepIdAttachmentAttachmentIdDelete(testKey, stepId, attachmentId);
    } catch (ApiException e) {
      System.err.println("Exception when calling TestStepApi#testTestKeyStepsStepIdAttachmentAttachmentIdDelete");
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
 **testKey** | **String**| Test with key CALC-123 does not exist or is not a manual test. |
 **stepId** | **Integer**| The id of the test step |
 **attachmentId** | **Integer**| The id of the attachment |

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
**400** | Bad Request |  -  |
**500** | Internal Server error |  -  |

<a name="testTestKeyStepsStepIdAttachmentsGet"></a>
# **testTestKeyStepsStepIdAttachmentsGet**
> List&lt;FileResponse&gt; testTestKeyStepsStepIdAttachmentsGet(testKey, stepId)



Returns all the attachments of a test step, given the test key and step id.

### Example
```java
// Import classes:
import org.openapi.xray.invoker.ApiClient;
import org.openapi.xray.invoker.ApiException;
import org.openapi.xray.invoker.Configuration;
import org.openapi.xray.invoker.auth.*;
import org.openapi.xray.invoker.models.*;
import org.openapi.xray.api.TestStepApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.xpand-it.com/rest/raven/2.0/api");
    
    // Configure HTTP basic authorization: BasicAuth
    HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
    BasicAuth.setUsername("YOUR USERNAME");
    BasicAuth.setPassword("YOUR PASSWORD");

    TestStepApi apiInstance = new TestStepApi(defaultClient);
    String testKey = "testKey_example"; // String | Test with key CALC-123 does not exist or is not a manual test.
    Integer stepId = 56; // Integer | The id of the test step
    try {
      List<FileResponse> result = apiInstance.testTestKeyStepsStepIdAttachmentsGet(testKey, stepId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TestStepApi#testTestKeyStepsStepIdAttachmentsGet");
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
 **testKey** | **String**| Test with key CALC-123 does not exist or is not a manual test. |
 **stepId** | **Integer**| The id of the test step |

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
**200** | Successful operation. Returns a body with the attachments information. |  -  |
**400** | Bad Request |  -  |
**500** | Internal Server error |  -  |

<a name="testTestKeyStepsStepIdDelete"></a>
# **testTestKeyStepsStepIdDelete**
> testTestKeyStepsStepIdDelete(testKey, stepId)



Deletes a test step given the test key and the step id.

### Example
```java
// Import classes:
import org.openapi.xray.invoker.ApiClient;
import org.openapi.xray.invoker.ApiException;
import org.openapi.xray.invoker.Configuration;
import org.openapi.xray.invoker.auth.*;
import org.openapi.xray.invoker.models.*;
import org.openapi.xray.api.TestStepApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.xpand-it.com/rest/raven/2.0/api");
    
    // Configure HTTP basic authorization: BasicAuth
    HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
    BasicAuth.setUsername("YOUR USERNAME");
    BasicAuth.setPassword("YOUR PASSWORD");

    TestStepApi apiInstance = new TestStepApi(defaultClient);
    String testKey = "testKey_example"; // String | The key of the test issue, e.g., CALC-562
    Integer stepId = 56; // Integer | The id of the test step
    try {
      apiInstance.testTestKeyStepsStepIdDelete(testKey, stepId);
    } catch (ApiException e) {
      System.err.println("Exception when calling TestStepApi#testTestKeyStepsStepIdDelete");
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
 **testKey** | **String**| The key of the test issue, e.g., CALC-562 |
 **stepId** | **Integer**| The id of the test step |

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
**400** | Bad Request |  -  |
**500** | Internal Server error |  -  |

<a name="testTestKeyStepsStepIdGet"></a>
# **testTestKeyStepsStepIdGet**
> StepResponse testTestKeyStepsStepIdGet(testKey, stepId)



Returns the values of a single test step, given the test key and the step id. The response follows the same format as the previous endpoints, containing the step id, index, fields and the attachments. &lt;br /&gt; &lt;br /&gt; The Test Step fields are identified by their name and can be of type _Data_ (Toggle, Number, Date and Date Time fields), _Option_ (Single Select, Multiple Select and Radio Button fields), _Wiki_ (Native fields, Single and Multiple Line fields). &lt;br /&gt; &lt;br /&gt; The value of step fields of type _Wiki_ have a raw and rendered value. _Option_ fields value will be an array containing the information of the selected options (the option id and its value).

### Example
```java
// Import classes:
import org.openapi.xray.invoker.ApiClient;
import org.openapi.xray.invoker.ApiException;
import org.openapi.xray.invoker.Configuration;
import org.openapi.xray.invoker.auth.*;
import org.openapi.xray.invoker.models.*;
import org.openapi.xray.api.TestStepApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.xpand-it.com/rest/raven/2.0/api");
    
    // Configure HTTP basic authorization: BasicAuth
    HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
    BasicAuth.setUsername("YOUR USERNAME");
    BasicAuth.setPassword("YOUR PASSWORD");

    TestStepApi apiInstance = new TestStepApi(defaultClient);
    String testKey = "testKey_example"; // String | The key of the test issue, e.g., CALC-562
    Integer stepId = 56; // Integer | The id of the test step
    try {
      StepResponse result = apiInstance.testTestKeyStepsStepIdGet(testKey, stepId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TestStepApi#testTestKeyStepsStepIdGet");
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
 **testKey** | **String**| The key of the test issue, e.g., CALC-562 |
 **stepId** | **Integer**| The id of the test step |

### Return type

[**StepResponse**](StepResponse.md)

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
**500** | Internal Server error |  -  |

<a name="testTestKeyStepsStepIdPut"></a>
# **testTestKeyStepsStepIdPut**
> CreateStepResponse testTestKeyStepsStepIdPut(testKey, stepId, updateStepRequestBody)



Updates the values of an existing test step, given the test key and step id. The user can update the field values and the attachments of a step. The values should follow a specific format similar to the step creation. &lt;br/&gt;&lt;br/&gt; - **Toggle Fields** values should be _\&quot;true\&quot;_, _\&quot;false\&quot;_, _\&quot;0\&quot;_ or _\&quot;1\&quot;_ &lt;br /&gt;&lt;br /&gt; - **Number Fields** values should be a string containing a number, e.g. _\&quot;320\&quot;_. Decimal Number are also accepted,for instance, \&quot;320.5\&quot;. The decimal places are always separated by a _\&quot;.\&quot;_ &lt;br /&gt; &lt;br /&gt; - **Single Select and Radio Button Fields** values should be a single string containing the option value, e.g. _\&quot;Option A\&quot;_. The value should be a valid option for that custom field. The values are not case sensitive. &lt;br /&gt;&lt;br /&gt; - **Multiple Select Fields** values should be an array of the string of option values, e.g. _[\&quot;Option A\&quot;, \&quot;Option B\&quot;]_. All the selected values should be valid for that custom field. The option values are not case sensitive. &lt;br /&gt;&lt;br /&gt; - **Date Fields** should follow the ISO format _yyyy-MM-dd_, where _yyyy_ represents the year, _MM_ the month in year and _dd_ the day in the month. For instance, a valid value would be _\&quot;2020-05-02\&quot;_. &lt;br /&gt;&lt;br /&gt; - **Date Time fields** should be in UTC following the ISO format _yyyy-MM-dd&#39;T&#39;HH:mm&#39;Z&#39;_. The date part follows the same date format, while _HH_ represents the hours (0-24), _mm_ the minutes in hour and _Z_ indicates the hour in UTC. For instance, a valid date time value would be _\&quot;2020-05-02T10:30Z\&quot;_. &lt;br /&gt;&lt;br /&gt; The remaining field types values do not required a specific validation. For instance, for a Single Line Custom field a valid value would be _\&quot;Perform Action B\&quot;_. &lt;br /&gt;&lt;br /&gt; If some value is not valid for a certain custom field type, an error will be return stating the field with the incorrect value. A field value can be deleted sending an empty value, such as _\&quot;\&quot;_ or _[]_, or by sending _null_. **It is not possible to delete the value of a required field.**

### Example
```java
// Import classes:
import org.openapi.xray.invoker.ApiClient;
import org.openapi.xray.invoker.ApiException;
import org.openapi.xray.invoker.Configuration;
import org.openapi.xray.invoker.auth.*;
import org.openapi.xray.invoker.models.*;
import org.openapi.xray.api.TestStepApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.xpand-it.com/rest/raven/2.0/api");
    
    // Configure HTTP basic authorization: BasicAuth
    HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
    BasicAuth.setUsername("YOUR USERNAME");
    BasicAuth.setPassword("YOUR PASSWORD");

    TestStepApi apiInstance = new TestStepApi(defaultClient);
    String testKey = "testKey_example"; // String | Test Key
    Integer stepId = 56; // Integer | The id of the test step
    UpdateStepRequestBody updateStepRequestBody = new UpdateStepRequestBody(); // UpdateStepRequestBody | 
    try {
      CreateStepResponse result = apiInstance.testTestKeyStepsStepIdPut(testKey, stepId, updateStepRequestBody);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TestStepApi#testTestKeyStepsStepIdPut");
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
 **testKey** | **String**| Test Key |
 **stepId** | **Integer**| The id of the test step |
 **updateStepRequestBody** | [**UpdateStepRequestBody**](UpdateStepRequestBody.md)|  |

### Return type

[**CreateStepResponse**](CreateStepResponse.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Successful operation |  -  |
**400** | Bad Request. Occurs when there is some error in the request, for instance, the test with provided key does not exist or some field has an invalid value (e.g. Option \&quot;A\&quot; does not exist for an option field). |  -  |
**500** | Internal Server error |  -  |

