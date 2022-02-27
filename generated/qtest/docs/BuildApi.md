# BuildApi

All URIs are relative to *https://apitryout.qtestnet.com/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**create**](BuildApi.md#create) | **POST** /api/v3/projects/{projectId}/builds | Creates a Build
[**delete**](BuildApi.md#delete) | **DELETE** /api/v3/projects/{projectId}/builds/{buildId} | Deletes a Build
[**get**](BuildApi.md#get) | **GET** /api/v3/projects/{projectId}/builds/{buildId} | Gets a Build
[**getBuilds**](BuildApi.md#getBuilds) | **GET** /api/v3/projects/{projectId}/builds | Gets multiple Builds
[**update**](BuildApi.md#update) | **PUT** /api/v3/projects/{projectId}/builds/{buildId} | Updates a Build


<a name="create"></a>
# **create**
> BuildResource create(projectId, body)

Creates a Build

To create a Build under a parent Release  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 4+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.BuildApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

BuildApi apiInstance = new BuildApi();
Long projectId = 789L; // Long | ID of the project
BuildResource body = new BuildResource(); // BuildResource | <em>name (required):</em> Build name  <em>release (required):</em> The parent Release under which the Build will be located  <em>properties:</em> An array of field-value pairs
try {
    BuildResource result = apiInstance.create(projectId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BuildApi#create");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **body** | [**BuildResource**](BuildResource.md)| &lt;em&gt;name (required):&lt;/em&gt; Build name  &lt;em&gt;release (required):&lt;/em&gt; The parent Release under which the Build will be located  &lt;em&gt;properties:&lt;/em&gt; An array of field-value pairs |

### Return type

[**BuildResource**](BuildResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="delete"></a>
# **delete**
> Object delete(projectId, buildId)

Deletes a Build

To delete a Build  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 6+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.BuildApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

BuildApi apiInstance = new BuildApi();
Long projectId = 789L; // Long | ID of the project
Long buildId = 789L; // Long | ID of the Build to delete
try {
    Object result = apiInstance.delete(projectId, buildId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BuildApi#delete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **buildId** | **Long**| ID of the Build to delete |

### Return type

**Object**

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="get"></a>
# **get**
> BuildResource get(projectId, buildId)

Gets a Build

To retrieve a Build&lt;strong&gt;qTest Manager version:&lt;/strong&gt; 6+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.BuildApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

BuildApi apiInstance = new BuildApi();
Long projectId = 789L; // Long | ID of the project
Long buildId = 789L; // Long | ID of the Build
try {
    BuildResource result = apiInstance.get(projectId, buildId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BuildApi#get");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **buildId** | **Long**| ID of the Build |

### Return type

[**BuildResource**](BuildResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getBuilds"></a>
# **getBuilds**
> List&lt;BuildResource&gt; getBuilds(projectId, releaseId)

Gets multiple Builds

To retrieve all Builds under a Release  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 6+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.BuildApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

BuildApi apiInstance = new BuildApi();
Long projectId = 789L; // Long | ID of the project
Long releaseId = 789L; // Long | ID of the parent Release
try {
    List<BuildResource> result = apiInstance.getBuilds(projectId, releaseId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BuildApi#getBuilds");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **releaseId** | **Long**| ID of the parent Release |

### Return type

[**List&lt;BuildResource&gt;**](BuildResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="update"></a>
# **update**
> BuildResource update(projectId, buildId, body)

Updates a Build

To update a Build  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 6+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.BuildApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

BuildApi apiInstance = new BuildApi();
Long projectId = 789L; // Long | ID of the project
Long buildId = 789L; // Long | ID of the Build
BuildResource body = new BuildResource(); // BuildResource | The Build's updated properties
try {
    BuildResource result = apiInstance.update(projectId, buildId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BuildApi#update");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **buildId** | **Long**| ID of the Build |
 **body** | [**BuildResource**](BuildResource.md)| The Build&#39;s updated properties |

### Return type

[**BuildResource**](BuildResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

