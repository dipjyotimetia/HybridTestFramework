# ProjectApi

All URIs are relative to *https://sandbox.xpand-it.com/rest/raven/2.0/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**projectIdSettingsCustomfieldsTestrunsGet**](ProjectApi.md#projectIdSettingsCustomfieldsTestrunsGet) | **GET** /project/{id}/settings/customfields/testruns | 
[**projectIdSettingsCustomfieldsTeststepsGet**](ProjectApi.md#projectIdSettingsCustomfieldsTeststepsGet) | **GET** /project/{id}/settings/customfields/teststeps | 


<a name="projectIdSettingsCustomfieldsTestrunsGet"></a>
# **projectIdSettingsCustomfieldsTestrunsGet**
> List&lt;OneOfCustomFieldMetaInformationOptionCustomFieldMetaInformation&gt; projectIdSettingsCustomfieldsTestrunsGet(id)



Retrives the configuration of the Test Run custom fields for a project, given the project id. &lt;br/&gt;&lt;br/&gt; The response contains all information related to the custom fields, such as id, name, description, if the field is require and enable, and the test types the custom field is associated with. In the case of optional custom fields (Multiple and Single Select Fields and Radio Buttons), the list of the custom field options is also retrieved.

### Example
```java
// Import classes:
import org.openapi.xray.invoker.ApiClient;
import org.openapi.xray.invoker.ApiException;
import org.openapi.xray.invoker.Configuration;
import org.openapi.xray.invoker.auth.*;
import org.openapi.xray.invoker.models.*;
import org.openapi.xray.api.ProjectApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.xpand-it.com/rest/raven/2.0/api");
    
    // Configure HTTP basic authorization: BasicAuth
    HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
    BasicAuth.setUsername("YOUR USERNAME");
    BasicAuth.setPassword("YOUR PASSWORD");

    ProjectApi apiInstance = new ProjectApi(defaultClient);
    String id = "id_example"; // String | The id of the Project
    try {
      List<OneOfCustomFieldMetaInformationOptionCustomFieldMetaInformation> result = apiInstance.projectIdSettingsCustomfieldsTestrunsGet(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ProjectApi#projectIdSettingsCustomfieldsTestrunsGet");
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
 **id** | **String**| The id of the Project |

### Return type

[**List&lt;OneOfCustomFieldMetaInformationOptionCustomFieldMetaInformation&gt;**](OneOfCustomFieldMetaInformationOptionCustomFieldMetaInformation.md)

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

<a name="projectIdSettingsCustomfieldsTeststepsGet"></a>
# **projectIdSettingsCustomfieldsTeststepsGet**
> List&lt;OneOfStepCustomFieldMetaInformationStepOptionCustomFieldMetaInformation&gt; projectIdSettingsCustomfieldsTeststepsGet(id)



Retrives the configuration of the Test Step custom fields for a project, given the project id. &lt;br/&gt;&lt;br/&gt; The response contains all information related to the custom fields, such as id, name, description, if the field is require and enable. In the case of optional custom fields (Multiple and Single Select Fields and Radio Buttons), the list of the custom field options is also retrieved.

### Example
```java
// Import classes:
import org.openapi.xray.invoker.ApiClient;
import org.openapi.xray.invoker.ApiException;
import org.openapi.xray.invoker.Configuration;
import org.openapi.xray.invoker.auth.*;
import org.openapi.xray.invoker.models.*;
import org.openapi.xray.api.ProjectApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.xpand-it.com/rest/raven/2.0/api");
    
    // Configure HTTP basic authorization: BasicAuth
    HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
    BasicAuth.setUsername("YOUR USERNAME");
    BasicAuth.setPassword("YOUR PASSWORD");

    ProjectApi apiInstance = new ProjectApi(defaultClient);
    String id = "id_example"; // String | The id of the Project
    try {
      List<OneOfStepCustomFieldMetaInformationStepOptionCustomFieldMetaInformation> result = apiInstance.projectIdSettingsCustomfieldsTeststepsGet(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ProjectApi#projectIdSettingsCustomfieldsTeststepsGet");
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
 **id** | **String**| The id of the Project |

### Return type

[**List&lt;OneOfStepCustomFieldMetaInformationStepOptionCustomFieldMetaInformation&gt;**](OneOfStepCustomFieldMetaInformationStepOptionCustomFieldMetaInformation.md)

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

