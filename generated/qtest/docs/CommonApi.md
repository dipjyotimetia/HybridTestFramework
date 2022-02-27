# CommonApi

All URIs are relative to *https://apitryout.qtestnet.com/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**editSystemField**](CommonApi.md#editSystemField) | **POST** /api/v3/projects/{projectId}/settings/{objectType}/system-fields/{fieldId} | Edit System Field of an Object Type by the field
[**updateCustomFieldStatus**](CommonApi.md#updateCustomFieldStatus) | **POST** /api/v3/projects/{projectId}/settings/{objectType}/custom-fields/active | Update active or inactive custom fields of an Object Type


<a name="editSystemField"></a>
# **editSystemField**
> FieldResource editSystemField(projectId, fieldId, body, objectType)

Edit System Field of an Object Type by the field

To edit System Field of an Object Type by the field

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.CommonApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

CommonApi apiInstance = new CommonApi();
Long projectId = 789L; // Long | ID of the project
Long fieldId = 789L; // Long | ID of the field.
FieldResource body = new FieldResource(); // FieldResource | Given resource to edit a system field.
String objectType = "objectType_example"; // String | Valid values include releases, builds, requirements, test-cases, defects, test-suites and test-runs
try {
    FieldResource result = apiInstance.editSystemField(projectId, fieldId, body, objectType);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CommonApi#editSystemField");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **fieldId** | **Long**| ID of the field. |
 **body** | [**FieldResource**](FieldResource.md)| Given resource to edit a system field. |
 **objectType** | **String**| Valid values include releases, builds, requirements, test-cases, defects, test-suites and test-runs | [enum: requirements, test-cases, defects, test-runs, test-suites, releases, builds]

### Return type

[**FieldResource**](FieldResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="updateCustomFieldStatus"></a>
# **updateCustomFieldStatus**
> List&lt;FieldResource&gt; updateCustomFieldStatus(projectId, objectType, body)

Update active or inactive custom fields of an Object Type

To update active or inactive custom fields of an Object Type

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.CommonApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

CommonApi apiInstance = new CommonApi();
Long projectId = 789L; // Long | ID of the project
String objectType = "objectType_example"; // String | Valid values include releases, builds, requirements, test-cases, defects, test-suites and test-runs
List<FieldResource> body = Arrays.asList(new FieldResource()); // List<FieldResource> | Given resource to update custom fields.
try {
    List<FieldResource> result = apiInstance.updateCustomFieldStatus(projectId, objectType, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CommonApi#updateCustomFieldStatus");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **objectType** | **String**| Valid values include releases, builds, requirements, test-cases, defects, test-suites and test-runs | [enum: requirements, test-cases, defects, test-runs, test-suites, releases, builds]
 **body** | [**List&lt;FieldResource&gt;**](FieldResource.md)| Given resource to update custom fields. |

### Return type

[**List&lt;FieldResource&gt;**](FieldResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

