# ReleaseApi

All URIs are relative to *https://apitryout.qtestnet.com/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createRelease**](ReleaseApi.md#createRelease) | **POST** /api/v3/projects/{projectId}/releases | Creates a Release
[**deleteReleaseById**](ReleaseApi.md#deleteReleaseById) | **DELETE** /api/v3/projects/{projectId}/releases/{releaseId} | Delete a release
[**getAllReleases**](ReleaseApi.md#getAllReleases) | **GET** /api/v3/projects/{projectId}/releases | Gets multiple Releases
[**getReleaseById**](ReleaseApi.md#getReleaseById) | **GET** /api/v3/projects/{projectId}/releases/{releaseId} | Gets a Release
[**updateReleaseById**](ReleaseApi.md#updateReleaseById) | **PUT** /api/v3/projects/{projectId}/releases/{releaseId} | Updates a Release


<a name="createRelease"></a>
# **createRelease**
> ReleaseWithCustomFieldResource createRelease(projectId, body)

Creates a Release

To create a Release  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 4+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ReleaseApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

ReleaseApi apiInstance = new ReleaseApi();
Long projectId = 789L; // Long | ID of the project
ReleaseWithCustomFieldResource body = new ReleaseWithCustomFieldResource(); // ReleaseWithCustomFieldResource | The Release's properties
try {
    ReleaseWithCustomFieldResource result = apiInstance.createRelease(projectId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ReleaseApi#createRelease");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **body** | [**ReleaseWithCustomFieldResource**](ReleaseWithCustomFieldResource.md)| The Release&#39;s properties |

### Return type

[**ReleaseWithCustomFieldResource**](ReleaseWithCustomFieldResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="deleteReleaseById"></a>
# **deleteReleaseById**
> Object deleteReleaseById(projectId, releaseId)

Delete a release

To delete a Release

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ReleaseApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

ReleaseApi apiInstance = new ReleaseApi();
Long projectId = 789L; // Long | ID of the project
Long releaseId = 789L; // Long | ID of the Release which needs to be deleted  <strong>qTest Manager version:</strong> 6+
try {
    Object result = apiInstance.deleteReleaseById(projectId, releaseId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ReleaseApi#deleteReleaseById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **releaseId** | **Long**| ID of the Release which needs to be deleted  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 6+ |

### Return type

**Object**

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getAllReleases"></a>
# **getAllReleases**
> List&lt;ReleaseWithCustomFieldResource&gt; getAllReleases(projectId, includeClosed)

Gets multiple Releases

To retrieve Releases in a project  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 4+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ReleaseApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

ReleaseApi apiInstance = new ReleaseApi();
Long projectId = 789L; // Long | ID of the project
Boolean includeClosed = true; // Boolean | <em>includeClosed=false</em> - default value. <em>Closed</em> Releases are excluded from the response  <em>includeClosed=false</em> - Closed Release are included in the response
try {
    List<ReleaseWithCustomFieldResource> result = apiInstance.getAllReleases(projectId, includeClosed);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ReleaseApi#getAllReleases");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **includeClosed** | **Boolean**| &lt;em&gt;includeClosed&#x3D;false&lt;/em&gt; - default value. &lt;em&gt;Closed&lt;/em&gt; Releases are excluded from the response  &lt;em&gt;includeClosed&#x3D;false&lt;/em&gt; - Closed Release are included in the response | [optional]

### Return type

[**List&lt;ReleaseWithCustomFieldResource&gt;**](ReleaseWithCustomFieldResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getReleaseById"></a>
# **getReleaseById**
> ReleaseWithCustomFieldResource getReleaseById(projectId, releaseId)

Gets a Release

To retrieve a Release  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 4+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ReleaseApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

ReleaseApi apiInstance = new ReleaseApi();
Long projectId = 789L; // Long | ID of the project
Long releaseId = 789L; // Long | ID of the Release
try {
    ReleaseWithCustomFieldResource result = apiInstance.getReleaseById(projectId, releaseId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ReleaseApi#getReleaseById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **releaseId** | **Long**| ID of the Release |

### Return type

[**ReleaseWithCustomFieldResource**](ReleaseWithCustomFieldResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="updateReleaseById"></a>
# **updateReleaseById**
> ReleaseWithCustomFieldResource updateReleaseById(projectId, releaseId, body)

Updates a Release

To update a Release  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 6+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ReleaseApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

ReleaseApi apiInstance = new ReleaseApi();
Long projectId = 789L; // Long | ID of the project
Long releaseId = 789L; // Long | ID of the Release which needs to be updated
ReleaseWithCustomFieldResource body = new ReleaseWithCustomFieldResource(); // ReleaseWithCustomFieldResource | The Release's updated properties
try {
    ReleaseWithCustomFieldResource result = apiInstance.updateReleaseById(projectId, releaseId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ReleaseApi#updateReleaseById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **releaseId** | **Long**| ID of the Release which needs to be updated |
 **body** | [**ReleaseWithCustomFieldResource**](ReleaseWithCustomFieldResource.md)| The Release&#39;s updated properties |

### Return type

[**ReleaseWithCustomFieldResource**](ReleaseWithCustomFieldResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

