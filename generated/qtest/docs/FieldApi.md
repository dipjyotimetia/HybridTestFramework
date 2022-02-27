# FieldApi

All URIs are relative to *https://apitryout.qtestnet.com/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createCustomField**](FieldApi.md#createCustomField) | **POST** /api/v3/projects/{projectId}/settings/{objectType}/fields | Creates a Custom Field of an Object Type
[**createCustomSiteField**](FieldApi.md#createCustomSiteField) | **POST** /api/v3/fields/{objectType} | Creates a Custom Site Field of an Object Type
[**createProjectFieldAllowedValues**](FieldApi.md#createProjectFieldAllowedValues) | **POST** /api/v3/projects/{projectId}/settings/{objectType}/fields/{fieldId}/allowed-values | Creates allowed values of a Project Field
[**createSiteFieldAllowedValues**](FieldApi.md#createSiteFieldAllowedValues) | **POST** /api/v3/fields/{objectType}/{fieldId}/allowed-values | Creates allowed values of a Site Field
[**deleteCustomField**](FieldApi.md#deleteCustomField) | **DELETE** /api/v3/projects/{projectId}/settings/{objectType}/fields/{fieldId} | Deletes a Custom Field of an Object Type
[**deleteCustomSiteField**](FieldApi.md#deleteCustomSiteField) | **DELETE** /api/v3/fields/{objectType}/{fieldId} | Deletes a Custom Site Field of an Object Type
[**deleteProjectFieldValue**](FieldApi.md#deleteProjectFieldValue) | **DELETE** /api/v3/projects/{projectId}/settings/{objectType}/fields/{fieldId}/allowed-values/{value} | Deletes an allowed value of a Project Field
[**deleteSiteFieldValue**](FieldApi.md#deleteSiteFieldValue) | **DELETE** /api/v3/fields/{objectType}/{fieldId}/allowed-values/{value} | Deletes an allowed value of a Site Field
[**getAllSiteFields**](FieldApi.md#getAllSiteFields) | **GET** /api/v3/fields/{objectType} | Gets all site field of an object type
[**getCustomField**](FieldApi.md#getCustomField) | **GET** /api/v3/projects/{projectId}/settings/{objectType}/fields/{fieldId} | Gets a Custom Field of an Object Type
[**getCustomSiteField**](FieldApi.md#getCustomSiteField) | **GET** /api/v3/fields/{objectType}/{fieldId} | Gets a Custom Site Field of an Object Type
[**getFields**](FieldApi.md#getFields) | **GET** /api/v3/projects/{projectId}/settings/{objectType}/fields | Gets all Fields of an Object Type
[**getProjectFieldAllowedValues**](FieldApi.md#getProjectFieldAllowedValues) | **GET** /api/v3/projects/{projectId}/settings/{objectType}/fields/{fieldId}/allowed-values | Gets all allowed values of a Project Field
[**getSiteFieldAllowedValues**](FieldApi.md#getSiteFieldAllowedValues) | **GET** /api/v3/fields/{objectType}/{fieldId}/allowed-values | Gets all allowed values of a Site Field
[**updateCustomField**](FieldApi.md#updateCustomField) | **PUT** /api/v3/projects/{projectId}/settings/{objectType}/fields/{fieldId} | Updates a Custom Field of an Object Type
[**updateCustomSiteField**](FieldApi.md#updateCustomSiteField) | **PUT** /api/v3/fields/{objectType}/{fieldId} | Updates a Custom Site Field of an Object Type
[**updateProjectFieldAllowedValues**](FieldApi.md#updateProjectFieldAllowedValues) | **PUT** /api/v3/projects/{projectId}/settings/{objectType}/fields/{fieldId}/allowed-values/{value} | Updates an allowed value of a Project Field
[**updateSiteFieldAllowedValues**](FieldApi.md#updateSiteFieldAllowedValues) | **PUT** /api/v3/fields/{objectType}/{fieldId}/allowed-values/{value} | Updates an allowed value of a Site Field


<a name="createCustomField"></a>
# **createCustomField**
> FieldResource createCustomField(projectId, body, objectType)

Creates a Custom Field of an Object Type

To create a new custom Field for Release, Build, Requirement, Test Case, Test Suite, Test Run, or Defect

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.FieldApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

FieldApi apiInstance = new FieldApi();
Long projectId = 789L; // Long | ID of the project
FieldResource body = new FieldResource(); // FieldResource | The field's properties and values  <strong>data_type (required):</strong> specify the field type. Its valid values include  - 1 - Text box  - 2 - Text area  - 3 - Combo box  - 4 - Date picker  - 5 - User list  - 6 - Rich text editor  - 7 - Number  - 8 - Check box  - 9 - Date time picker  - 12 - URL  - 17 - Multiple selection combobox  In case you are creating a multiple picklist typed field (data_type's value is 8 or 17), you will need to specify <em>multiple=true</em>  In case you are creating a picklist typed field, you can specify the field's values in the <em>allowed_values</em> array
String objectType = "objectType_example"; // String | Valid values include releases, builds, requirements, test-cases, defects, test-suites and test-runs
try {
    FieldResource result = apiInstance.createCustomField(projectId, body, objectType);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FieldApi#createCustomField");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **body** | [**FieldResource**](FieldResource.md)| The field&#39;s properties and values  &lt;strong&gt;data_type (required):&lt;/strong&gt; specify the field type. Its valid values include  - 1 - Text box  - 2 - Text area  - 3 - Combo box  - 4 - Date picker  - 5 - User list  - 6 - Rich text editor  - 7 - Number  - 8 - Check box  - 9 - Date time picker  - 12 - URL  - 17 - Multiple selection combobox  In case you are creating a multiple picklist typed field (data_type&#39;s value is 8 or 17), you will need to specify &lt;em&gt;multiple&#x3D;true&lt;/em&gt;  In case you are creating a picklist typed field, you can specify the field&#39;s values in the &lt;em&gt;allowed_values&lt;/em&gt; array |
 **objectType** | **String**| Valid values include releases, builds, requirements, test-cases, defects, test-suites and test-runs | [enum: requirements, test-cases, defects, test-runs, test-suites, releases, builds]

### Return type

[**FieldResource**](FieldResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="createCustomSiteField"></a>
# **createCustomSiteField**
> FieldResource createCustomSiteField(objectType, body)

Creates a Custom Site Field of an Object Type

To create a new Site Field for Release, Build, Requirement, Test Case, Test Suite, Test Run, or Defect

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.FieldApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

FieldApi apiInstance = new FieldApi();
String objectType = "objectType_example"; // String | Valid values include releases, builds, requirements, test-cases, defects, test-suites and test-runs
FieldInputResource body = new FieldInputResource(); // FieldInputResource | The Site field's properties and values  <strong>label (required)</strong>: specify display name of the field  <strong>data_type (required)</strong>: specify the field type. Its valid values include  - 1 - Text box  - 2 - Text area  - 3 - Combo box  - 4 - Date picker  - 5 - User list  - 6 - Rich text editor  - 7 - Number  - 8 - Check box  - 9 - Date time picker  - 12 - URL  - 17 - Multiple selection combobox  In case you are creating a multiple picklist typed field (data_type's value is 8 or 17), you will need to specify <em>multiple=true</em>  In case you are creating a picklist typed field, you can specify the field's values in the <em>allowed_values array</em>  Order is not applicable when creating new field
try {
    FieldResource result = apiInstance.createCustomSiteField(objectType, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FieldApi#createCustomSiteField");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **objectType** | **String**| Valid values include releases, builds, requirements, test-cases, defects, test-suites and test-runs | [enum: requirements, test-cases, defects, test-runs, test-suites, releases, builds]
 **body** | [**FieldInputResource**](FieldInputResource.md)| The Site field&#39;s properties and values  &lt;strong&gt;label (required)&lt;/strong&gt;: specify display name of the field  &lt;strong&gt;data_type (required)&lt;/strong&gt;: specify the field type. Its valid values include  - 1 - Text box  - 2 - Text area  - 3 - Combo box  - 4 - Date picker  - 5 - User list  - 6 - Rich text editor  - 7 - Number  - 8 - Check box  - 9 - Date time picker  - 12 - URL  - 17 - Multiple selection combobox  In case you are creating a multiple picklist typed field (data_type&#39;s value is 8 or 17), you will need to specify &lt;em&gt;multiple&#x3D;true&lt;/em&gt;  In case you are creating a picklist typed field, you can specify the field&#39;s values in the &lt;em&gt;allowed_values array&lt;/em&gt;  Order is not applicable when creating new field |

### Return type

[**FieldResource**](FieldResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="createProjectFieldAllowedValues"></a>
# **createProjectFieldAllowedValues**
> AllowedValueResponseResource createProjectFieldAllowedValues(projectId, objectType, fieldId, body)

Creates allowed values of a Project Field

Creates maximum 100 allowed values of a Project Field with Combo box/Multi selection combo box/Check box data type

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.FieldApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

FieldApi apiInstance = new FieldApi();
Long projectId = 789L; // Long | ID of the project
String objectType = "objectType_example"; // String | Valid values include releases, builds, requirements, test-cases, defects, test-suites and test-runs
Long fieldId = 789L; // Long | ID of the field
List<AllowedValueResource> body = Arrays.asList(new AllowedValueResource()); // List<AllowedValueResource> | 
try {
    AllowedValueResponseResource result = apiInstance.createProjectFieldAllowedValues(projectId, objectType, fieldId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FieldApi#createProjectFieldAllowedValues");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **objectType** | **String**| Valid values include releases, builds, requirements, test-cases, defects, test-suites and test-runs | [enum: requirements, test-cases, defects, test-runs, test-suites, releases, builds]
 **fieldId** | **Long**| ID of the field |
 **body** | [**List&lt;AllowedValueResource&gt;**](AllowedValueResource.md)|  |

### Return type

[**AllowedValueResponseResource**](AllowedValueResponseResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="createSiteFieldAllowedValues"></a>
# **createSiteFieldAllowedValues**
> AllowedValueResponseResource createSiteFieldAllowedValues(objectType, fieldId, body)

Creates allowed values of a Site Field

Creates maximum 100 allowed values of a Site Field with Combo box/Multi selection combo box/Check box data type

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.FieldApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

FieldApi apiInstance = new FieldApi();
String objectType = "objectType_example"; // String | Valid values include releases, builds, requirements, test-cases, defects, test-suites and test-runs
Long fieldId = 789L; // Long | ID of the field
List<AllowedValueResource> body = Arrays.asList(new AllowedValueResource()); // List<AllowedValueResource> | 
try {
    AllowedValueResponseResource result = apiInstance.createSiteFieldAllowedValues(objectType, fieldId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FieldApi#createSiteFieldAllowedValues");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **objectType** | **String**| Valid values include releases, builds, requirements, test-cases, defects, test-suites and test-runs | [enum: requirements, test-cases, defects, test-runs, test-suites, releases, builds]
 **fieldId** | **Long**| ID of the field |
 **body** | [**List&lt;AllowedValueResource&gt;**](AllowedValueResource.md)|  |

### Return type

[**AllowedValueResponseResource**](AllowedValueResponseResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="deleteCustomField"></a>
# **deleteCustomField**
> Object deleteCustomField(projectId, objectType, fieldId)

Deletes a Custom Field of an Object Type

To delete a custom field (at project level) for Release, Build, Requirement, Test Case, Test Suite, Test Run, or Defect

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.FieldApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

FieldApi apiInstance = new FieldApi();
Long projectId = 789L; // Long | ID of the project
String objectType = "objectType_example"; // String | Valid values include releases, builds, requirements, test-cases, defects, test-suites and test-runs
Long fieldId = 789L; // Long | ID of the custom field
try {
    Object result = apiInstance.deleteCustomField(projectId, objectType, fieldId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FieldApi#deleteCustomField");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **objectType** | **String**| Valid values include releases, builds, requirements, test-cases, defects, test-suites and test-runs | [enum: requirements, test-cases, defects, test-runs, test-suites, releases, builds]
 **fieldId** | **Long**| ID of the custom field |

### Return type

**Object**

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="deleteCustomSiteField"></a>
# **deleteCustomSiteField**
> Object deleteCustomSiteField(objectType, fieldId)

Deletes a Custom Site Field of an Object Type

To delete a custom field (at site level) for Release, Build, Requirement, Test Case, Test Suite, Test Run, or Defect

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.FieldApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

FieldApi apiInstance = new FieldApi();
String objectType = "objectType_example"; // String | Valid values include releases, builds, requirements, test-cases, defects, test-suites and test-runs
Long fieldId = 789L; // Long | ID of the custom field
try {
    Object result = apiInstance.deleteCustomSiteField(objectType, fieldId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FieldApi#deleteCustomSiteField");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **objectType** | **String**| Valid values include releases, builds, requirements, test-cases, defects, test-suites and test-runs | [enum: requirements, test-cases, defects, test-runs, test-suites, releases, builds]
 **fieldId** | **Long**| ID of the custom field |

### Return type

**Object**

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="deleteProjectFieldValue"></a>
# **deleteProjectFieldValue**
> Object deleteProjectFieldValue(projectId, objectType, fieldId, value)

Deletes an allowed value of a Project Field

To delete an allowed value of a Field (at project level) with Combo box/Multi selection combo box/Check box data type

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.FieldApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

FieldApi apiInstance = new FieldApi();
Long projectId = 789L; // Long | ID of the project
String objectType = "objectType_example"; // String | Valid values include releases, builds, requirements, test-cases, defects, test-suites and test-runs
Long fieldId = 789L; // Long | ID of the field
Long value = 789L; // Long | ID (property \"value\") of allowed value
try {
    Object result = apiInstance.deleteProjectFieldValue(projectId, objectType, fieldId, value);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FieldApi#deleteProjectFieldValue");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **objectType** | **String**| Valid values include releases, builds, requirements, test-cases, defects, test-suites and test-runs | [enum: requirements, test-cases, defects, test-runs, test-suites, releases, builds]
 **fieldId** | **Long**| ID of the field |
 **value** | **Long**| ID (property \&quot;value\&quot;) of allowed value |

### Return type

**Object**

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="deleteSiteFieldValue"></a>
# **deleteSiteFieldValue**
> Object deleteSiteFieldValue(objectType, fieldId, value)

Deletes an allowed value of a Site Field

To delete an allowed value of a Site Field with Combo box/Multi selection combo box/Check box data type

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.FieldApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

FieldApi apiInstance = new FieldApi();
String objectType = "objectType_example"; // String | Valid values include releases, builds, requirements, test-cases, defects, test-suites and test-runs
Long fieldId = 789L; // Long | ID of the field
Long value = 789L; // Long | ID (property \"value\") of allowed value
try {
    Object result = apiInstance.deleteSiteFieldValue(objectType, fieldId, value);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FieldApi#deleteSiteFieldValue");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **objectType** | **String**| Valid values include releases, builds, requirements, test-cases, defects, test-suites and test-runs | [enum: requirements, test-cases, defects, test-runs, test-suites, releases, builds]
 **fieldId** | **Long**| ID of the field |
 **value** | **Long**| ID (property \&quot;value\&quot;) of allowed value |

### Return type

**Object**

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getAllSiteFields"></a>
# **getAllSiteFields**
> List&lt;FieldResource&gt; getAllSiteFields(objectType, page, pageSize)

Gets all site field of an object type

To get all fields (at site level) for Release, Build, Requirement, Test Case, Test Suite, Test Run, or Defect

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.FieldApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

FieldApi apiInstance = new FieldApi();
String objectType = "objectType_example"; // String | Valid values include releases, builds, requirements, test-cases, defects, test-suites and test-runs
Long page = 1L; // Long | By default the first page is returned but you can specify any page number to retrieve objects
Long pageSize = 100L; // Long | The result is paginated. By the default, the number of objects in each page is 100 if this is omitted. You can specify your custom number (up to 999) in this parameter
try {
    List<FieldResource> result = apiInstance.getAllSiteFields(objectType, page, pageSize);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FieldApi#getAllSiteFields");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **objectType** | **String**| Valid values include releases, builds, requirements, test-cases, defects, test-suites and test-runs | [enum: requirements, test-cases, defects, test-runs, test-suites, releases, builds]
 **page** | **Long**| By default the first page is returned but you can specify any page number to retrieve objects | [optional] [default to 1]
 **pageSize** | **Long**| The result is paginated. By the default, the number of objects in each page is 100 if this is omitted. You can specify your custom number (up to 999) in this parameter | [optional] [default to 100]

### Return type

[**List&lt;FieldResource&gt;**](FieldResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getCustomField"></a>
# **getCustomField**
> FieldResource getCustomField(projectId, objectType, fieldId)

Gets a Custom Field of an Object Type

To get a custom field (at project level) for Release, Build, Requirement, Test Case, Test Suite, Test Run, or Defect

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.FieldApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

FieldApi apiInstance = new FieldApi();
Long projectId = 789L; // Long | ID of the project
String objectType = "objectType_example"; // String | Valid values include releases, builds, requirements, test-cases, defects, test-suites and test-runs
Long fieldId = 789L; // Long | ID of the custom field
try {
    FieldResource result = apiInstance.getCustomField(projectId, objectType, fieldId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FieldApi#getCustomField");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **objectType** | **String**| Valid values include releases, builds, requirements, test-cases, defects, test-suites and test-runs | [enum: requirements, test-cases, defects, test-runs, test-suites, releases, builds]
 **fieldId** | **Long**| ID of the custom field |

### Return type

[**FieldResource**](FieldResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getCustomSiteField"></a>
# **getCustomSiteField**
> FieldResource getCustomSiteField(objectType, fieldId)

Gets a Custom Site Field of an Object Type

To get a custom field (at site level) for Release, Build, Requirement, Test Case, Test Suite, Test Run, or Defect

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.FieldApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

FieldApi apiInstance = new FieldApi();
String objectType = "objectType_example"; // String | Valid values include releases, builds, requirements, test-cases, defects, test-suites and test-runs
Long fieldId = 789L; // Long | ID of the custom field
try {
    FieldResource result = apiInstance.getCustomSiteField(objectType, fieldId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FieldApi#getCustomSiteField");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **objectType** | **String**| Valid values include releases, builds, requirements, test-cases, defects, test-suites and test-runs | [enum: requirements, test-cases, defects, test-runs, test-suites, releases, builds]
 **fieldId** | **Long**| ID of the custom field |

### Return type

[**FieldResource**](FieldResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getFields"></a>
# **getFields**
> List&lt;FieldResource&gt; getFields(projectId, objectType, includeInactive)

Gets all Fields of an Object Type

To retrieve Fields of an Object Type  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 4+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.FieldApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

FieldApi apiInstance = new FieldApi();
Long projectId = 789L; // Long | ID of the project
String objectType = "objectType_example"; // String | Valid values include releases, builds, requirements, test-cases, defects, test-suites and test-runs
Boolean includeInactive = true; // Boolean | By default inactive Fields are excluded from the response. Specify <em>includeInactive=true</em> to include inactive fields
try {
    List<FieldResource> result = apiInstance.getFields(projectId, objectType, includeInactive);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FieldApi#getFields");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **objectType** | **String**| Valid values include releases, builds, requirements, test-cases, defects, test-suites and test-runs | [enum: requirements, test-cases, defects, test-runs, test-suites, releases, builds]
 **includeInactive** | **Boolean**| By default inactive Fields are excluded from the response. Specify &lt;em&gt;includeInactive&#x3D;true&lt;/em&gt; to include inactive fields | [optional]

### Return type

[**List&lt;FieldResource&gt;**](FieldResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getProjectFieldAllowedValues"></a>
# **getProjectFieldAllowedValues**
> List&lt;AllowedValueResource&gt; getProjectFieldAllowedValues(projectId, objectType, fieldId, page, pageSize)

Gets all allowed values of a Project Field

To get all allowed values of a Project Field with Combo box/Multi selection combo box/Check box/User list data type

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.FieldApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

FieldApi apiInstance = new FieldApi();
Long projectId = 789L; // Long | ID of the project
String objectType = "objectType_example"; // String | Valid values include releases, builds, requirements, test-cases, defects, test-suites and test-runs
Long fieldId = 789L; // Long | ID of the field
Long page = 1L; // Long | By default the first page is returned but you can specify any page number to retrieve objects
Long pageSize = 100L; // Long | The result is paginated. By the default, the number of objects in each page is 100 if this is omitted. You can specify your custom number (up to 999) in this parameter
try {
    List<AllowedValueResource> result = apiInstance.getProjectFieldAllowedValues(projectId, objectType, fieldId, page, pageSize);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FieldApi#getProjectFieldAllowedValues");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **objectType** | **String**| Valid values include releases, builds, requirements, test-cases, defects, test-suites and test-runs | [enum: requirements, test-cases, defects, test-runs, test-suites, releases, builds]
 **fieldId** | **Long**| ID of the field |
 **page** | **Long**| By default the first page is returned but you can specify any page number to retrieve objects | [optional] [default to 1]
 **pageSize** | **Long**| The result is paginated. By the default, the number of objects in each page is 100 if this is omitted. You can specify your custom number (up to 999) in this parameter | [optional] [default to 100]

### Return type

[**List&lt;AllowedValueResource&gt;**](AllowedValueResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getSiteFieldAllowedValues"></a>
# **getSiteFieldAllowedValues**
> List&lt;AllowedValueResource&gt; getSiteFieldAllowedValues(objectType, fieldId, page, pageSize)

Gets all allowed values of a Site Field

To get all allowed values of a Site Field with Combo box/Multi selection combo box/Check box/User list data type

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.FieldApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

FieldApi apiInstance = new FieldApi();
String objectType = "objectType_example"; // String | Valid values include releases, builds, requirements, test-cases, defects, test-suites and test-runs
Long fieldId = 789L; // Long | ID of the field
Long page = 1L; // Long | By default the first page is returned but you can specify any page number to retrieve objects
Long pageSize = 100L; // Long | The result is paginated. By the default, the number of objects in each page is 100 if this is omitted. You can specify your custom number (up to 999) in this parameter
try {
    List<AllowedValueResource> result = apiInstance.getSiteFieldAllowedValues(objectType, fieldId, page, pageSize);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FieldApi#getSiteFieldAllowedValues");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **objectType** | **String**| Valid values include releases, builds, requirements, test-cases, defects, test-suites and test-runs | [enum: requirements, test-cases, defects, test-runs, test-suites, releases, builds]
 **fieldId** | **Long**| ID of the field |
 **page** | **Long**| By default the first page is returned but you can specify any page number to retrieve objects | [optional] [default to 1]
 **pageSize** | **Long**| The result is paginated. By the default, the number of objects in each page is 100 if this is omitted. You can specify your custom number (up to 999) in this parameter | [optional] [default to 100]

### Return type

[**List&lt;AllowedValueResource&gt;**](AllowedValueResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="updateCustomField"></a>
# **updateCustomField**
> FieldResource updateCustomField(projectId, objectType, fieldId, body)

Updates a Custom Field of an Object Type

To update a custom field (at project level) for Release, Build, Requirement, Test Case, Test Suite, Test Run, or Defect

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.FieldApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

FieldApi apiInstance = new FieldApi();
Long projectId = 789L; // Long | ID of the project
String objectType = "objectType_example"; // String | Valid values include releases, builds, requirements, test-cases, defects, test-suites and test-runs
Long fieldId = 789L; // Long | ID of the custom field
FieldInputResource body = new FieldInputResource(); // FieldInputResource | The Field's updated properties & values  Notes:  - Not allow to update <strong>data_type</strong>  - To delete a value of a Combo box/Checkbox or Multiple selection combo box, exclude that value out of \"allowed_values\"  - To add more allowed_values for Project Field, refer [here](#/field/createProjectFieldAllowedValues)   - To update list allowed_values of Project Field, refer [here](#/field/updateProjectFieldAllowedValues)
try {
    FieldResource result = apiInstance.updateCustomField(projectId, objectType, fieldId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FieldApi#updateCustomField");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **objectType** | **String**| Valid values include releases, builds, requirements, test-cases, defects, test-suites and test-runs | [enum: requirements, test-cases, defects, test-runs, test-suites, releases, builds]
 **fieldId** | **Long**| ID of the custom field |
 **body** | [**FieldInputResource**](FieldInputResource.md)| The Field&#39;s updated properties &amp; values  Notes:  - Not allow to update &lt;strong&gt;data_type&lt;/strong&gt;  - To delete a value of a Combo box/Checkbox or Multiple selection combo box, exclude that value out of \&quot;allowed_values\&quot;  - To add more allowed_values for Project Field, refer [here](#/field/createProjectFieldAllowedValues)   - To update list allowed_values of Project Field, refer [here](#/field/updateProjectFieldAllowedValues) |

### Return type

[**FieldResource**](FieldResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="updateCustomSiteField"></a>
# **updateCustomSiteField**
> FieldResource updateCustomSiteField(objectType, fieldId, body)

Updates a Custom Site Field of an Object Type

To update a custom field (at site level) for Release, Build, Requirement, Test Case, Test Suite, Test Run, or Defect

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.FieldApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

FieldApi apiInstance = new FieldApi();
String objectType = "objectType_example"; // String | Valid values include releases, builds, requirements, test-cases, defects, test-suites and test-runs
Long fieldId = 789L; // Long | ID of the custom field
FieldInputResource body = new FieldInputResource(); // FieldInputResource | The Site Field's updated properties & values  Notes:  - Not allow to update <strong>data_type</strong>  - To delete a value of a Combo box/Checkbox or Multiple selection combo box, exclude that value out of \"allowed_values\"  - To add more allowed_values for Site Field, refer [here](#/field/createSiteFieldAllowedValues)  - To update list allowed_values of Site Field, refer [here](#/field/updateSiteFieldAllowedValues)
try {
    FieldResource result = apiInstance.updateCustomSiteField(objectType, fieldId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FieldApi#updateCustomSiteField");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **objectType** | **String**| Valid values include releases, builds, requirements, test-cases, defects, test-suites and test-runs | [enum: requirements, test-cases, defects, test-runs, test-suites, releases, builds]
 **fieldId** | **Long**| ID of the custom field |
 **body** | [**FieldInputResource**](FieldInputResource.md)| The Site Field&#39;s updated properties &amp; values  Notes:  - Not allow to update &lt;strong&gt;data_type&lt;/strong&gt;  - To delete a value of a Combo box/Checkbox or Multiple selection combo box, exclude that value out of \&quot;allowed_values\&quot;  - To add more allowed_values for Site Field, refer [here](#/field/createSiteFieldAllowedValues)  - To update list allowed_values of Site Field, refer [here](#/field/updateSiteFieldAllowedValues) |

### Return type

[**FieldResource**](FieldResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="updateProjectFieldAllowedValues"></a>
# **updateProjectFieldAllowedValues**
> Object updateProjectFieldAllowedValues(projectId, objectType, fieldId, value, body)

Updates an allowed value of a Project Field

Update allowed values of a Project Field with Combo box/Multi selection combo box/Check box data type

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.FieldApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

FieldApi apiInstance = new FieldApi();
Long projectId = 789L; // Long | ID of the project
String objectType = "objectType_example"; // String | Valid values include releases, builds, requirements, test-cases, defects, test-suites and test-runs
Long fieldId = 789L; // Long | ID of the field
Long value = 789L; // Long | ID (property \"value\") of allowed value
AllowedValueInputResource body = new AllowedValueInputResource(); // AllowedValueInputResource | 
try {
    Object result = apiInstance.updateProjectFieldAllowedValues(projectId, objectType, fieldId, value, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FieldApi#updateProjectFieldAllowedValues");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **objectType** | **String**| Valid values include releases, builds, requirements, test-cases, defects, test-suites and test-runs | [enum: requirements, test-cases, defects, test-runs, test-suites, releases, builds]
 **fieldId** | **Long**| ID of the field |
 **value** | **Long**| ID (property \&quot;value\&quot;) of allowed value |
 **body** | [**AllowedValueInputResource**](AllowedValueInputResource.md)|  |

### Return type

**Object**

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="updateSiteFieldAllowedValues"></a>
# **updateSiteFieldAllowedValues**
> ResourceSupport updateSiteFieldAllowedValues(objectType, fieldId, value, body)

Updates an allowed value of a Site Field

Update allowed values of a Site Field with Combo box/Multi selection combo box/Check box data type

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.FieldApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

FieldApi apiInstance = new FieldApi();
String objectType = "objectType_example"; // String | Valid values include releases, builds, requirements, test-cases, defects, test-suites and test-runs
Long fieldId = 789L; // Long | ID of the field
Long value = 789L; // Long | ID (property \"value\") of allowed value
AllowedValueInputResource body = new AllowedValueInputResource(); // AllowedValueInputResource | 
try {
    ResourceSupport result = apiInstance.updateSiteFieldAllowedValues(objectType, fieldId, value, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FieldApi#updateSiteFieldAllowedValues");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **objectType** | **String**| Valid values include releases, builds, requirements, test-cases, defects, test-suites and test-runs | [enum: requirements, test-cases, defects, test-runs, test-suites, releases, builds]
 **fieldId** | **Long**| ID of the field |
 **value** | **Long**| ID (property \&quot;value\&quot;) of allowed value |
 **body** | [**AllowedValueInputResource**](AllowedValueInputResource.md)|  |

### Return type

[**ResourceSupport**](ResourceSupport.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

