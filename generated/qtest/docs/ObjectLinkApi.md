# ObjectLinkApi

All URIs are relative to *https://apitryout.qtestnet.com/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**find**](ObjectLinkApi.md#find) | **GET** /api/v3/projects/{projectId}/linked-artifacts | Gets associated objects of given objects
[**linkArtifacts**](ObjectLinkApi.md#linkArtifacts) | **POST** /api/v3/projects/{projectId}/{objectType}/{objectId}/link | Creates links between objects
[**linkArtifactsByPid**](ObjectLinkApi.md#linkArtifactsByPid) | **POST** /api/v3/projects/{projectId}/{objectType}/{objectId}/{linkType} | Creates links between objects by pids
[**unlinkArtifacts**](ObjectLinkApi.md#unlinkArtifacts) | **DELETE** /api/v3/projects/{projectId}/{objectType}/{objectId}/link | Removes links between objects
[**unlinkArtifactsByPid**](ObjectLinkApi.md#unlinkArtifactsByPid) | **DELETE** /api/v3/projects/{projectId}/{objectType}/{objectId}/{linkType} | Removes links between objects by pids


<a name="find"></a>
# **find**
> List&lt;LinkedArtifactContainer&gt; find(projectId, type, ids, pids, trofSharedprojects)

Gets associated objects of given objects

To retrieve associated objects of given objects  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 7.5+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ObjectLinkApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

ObjectLinkApi apiInstance = new ObjectLinkApi();
Long projectId = 789L; // Long | ID of the project
String type = "type_example"; // String | Valid values include <em>releases</em>, <em>builds</em>, <em>requirements</em>,<em>test-cases</em>, <em>test-runs</em>, <em>test-logs</em>, <em>test-steps</em> or <em>defects</em>
List<Long> ids = Arrays.asList(56L); // List<Long> | IDs of objects whose links you want to retrieve
List<String> pids = Arrays.asList("pids_example"); // List<String> | In case of <em>type=defects</em>, you can specify a list of external defect id in this parameters.  It cannot be used for other types
Boolean trofSharedprojects = true; // Boolean | 
try {
    List<LinkedArtifactContainer> result = apiInstance.find(projectId, type, ids, pids, trofSharedprojects);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ObjectLinkApi#find");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **type** | **String**| Valid values include &lt;em&gt;releases&lt;/em&gt;, &lt;em&gt;builds&lt;/em&gt;, &lt;em&gt;requirements&lt;/em&gt;,&lt;em&gt;test-cases&lt;/em&gt;, &lt;em&gt;test-runs&lt;/em&gt;, &lt;em&gt;test-logs&lt;/em&gt;, &lt;em&gt;test-steps&lt;/em&gt; or &lt;em&gt;defects&lt;/em&gt; | [enum: releases, builds, requirements, test-cases, test-runs, test-logs, test-steps, defects]
 **ids** | [**List&lt;Long&gt;**](Long.md)| IDs of objects whose links you want to retrieve | [optional]
 **pids** | [**List&lt;String&gt;**](String.md)| In case of &lt;em&gt;type&#x3D;defects&lt;/em&gt;, you can specify a list of external defect id in this parameters.  It cannot be used for other types | [optional]
 **trofSharedprojects** | **Boolean**|  | [optional]

### Return type

[**List&lt;LinkedArtifactContainer&gt;**](LinkedArtifactContainer.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="linkArtifacts"></a>
# **linkArtifacts**
> List&lt;LinkedArtifactContainer&gt; linkArtifacts(projectId, objectType, type, body, objectId)

Creates links between objects

To add associated objects to another object

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ObjectLinkApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

ObjectLinkApi apiInstance = new ObjectLinkApi();
Long projectId = 789L; // Long | ID of the project
String objectType = "objectType_example"; // String | The object type of the source object. Valid values include requirements, builds, test-steps, test-logs, releases
String type = "type_example"; // String | The object type of the associated objects which are being added to the source object.   Valid values include releases, builds, requirements, test-cases, test-runs, test-logs, test-steps or defects
List<Long> body = Arrays.asList(new List<Long>()); // List<Long> | A JSONArray of associated object IDs which are being added to the source object  Notes:  When creating link between Test Case and Requirement, please make sure that:  - The Test Case is not routed for VERA approval  - Data migration for Test Case version when turning on Test Case Settings to track Test Case - Requirement Link per version is completed
Long objectId = 789L; // Long | ID of the source object
try {
    List<LinkedArtifactContainer> result = apiInstance.linkArtifacts(projectId, objectType, type, body, objectId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ObjectLinkApi#linkArtifacts");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **objectType** | **String**| The object type of the source object. Valid values include requirements, builds, test-steps, test-logs, releases | [enum: releases, builds, requirements, test-logs, test-steps]
 **type** | **String**| The object type of the associated objects which are being added to the source object.   Valid values include releases, builds, requirements, test-cases, test-runs, test-logs, test-steps or defects | [enum: releases, builds, requirements, test-cases, test-runs, test-logs, test-steps, defects]
 **body** | **List&lt;Long&gt;**| A JSONArray of associated object IDs which are being added to the source object  Notes:  When creating link between Test Case and Requirement, please make sure that:  - The Test Case is not routed for VERA approval  - Data migration for Test Case version when turning on Test Case Settings to track Test Case - Requirement Link per version is completed |
 **objectId** | **Long**| ID of the source object |

### Return type

[**List&lt;LinkedArtifactContainer&gt;**](LinkedArtifactContainer.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="linkArtifactsByPid"></a>
# **linkArtifactsByPid**
> List&lt;LinkedDefectContainer&gt; linkArtifactsByPid(projectId, objectType, linkType, body, objectId)

Creates links between objects by pids

To add associated objects to another object by pids

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ObjectLinkApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

ObjectLinkApi apiInstance = new ObjectLinkApi();
Long projectId = 789L; // Long | ID of the project
String objectType = "objectType_example"; // String | The object type of the source object. Valid values include test-steps, test-logs
String linkType = "linkType_example"; // String | The object type of the associated objects which are being added to the source object.   Valid value: defects
List<String> body = Arrays.asList(new List<String>()); // List<String> | A JSONArray of associated object PIDs which are being added to the source object
Long objectId = 789L; // Long | 
try {
    List<LinkedDefectContainer> result = apiInstance.linkArtifactsByPid(projectId, objectType, linkType, body, objectId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ObjectLinkApi#linkArtifactsByPid");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **objectType** | **String**| The object type of the source object. Valid values include test-steps, test-logs | [enum: releases, builds, requirements, test-logs, test-steps]
 **linkType** | **String**| The object type of the associated objects which are being added to the source object.   Valid value: defects | [enum: releases, builds, requirements, test-cases, test-runs, test-logs, test-steps, defects]
 **body** | **List&lt;String&gt;**| A JSONArray of associated object PIDs which are being added to the source object |
 **objectId** | **Long**|  |

### Return type

[**List&lt;LinkedDefectContainer&gt;**](LinkedDefectContainer.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="unlinkArtifacts"></a>
# **unlinkArtifacts**
> Object unlinkArtifacts(projectId, objectType, type, body, objectId)

Removes links between objects

To remove associated objects from another object

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ObjectLinkApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

ObjectLinkApi apiInstance = new ObjectLinkApi();
Long projectId = 789L; // Long | ID of the project
String objectType = "objectType_example"; // String | The object type of the source object. Valid values include requirements, builds, test-steps, test-logs, releases
String type = "type_example"; // String | The object type of the associated objects which are being added to the source object.   Valid values include releases, builds, requirements, test-cases, test-runs, test-logs, test-steps or defects
List<Long> body = Arrays.asList(new List<Long>()); // List<Long> | A JSONArray of associated object IDs which are being removed from the source object  Notes:  When removing link between Test Case and Requirement, please make sure that:  - The Test Case is not routed for VERA approval  - Data migration for Test Case version when turning on Test Case Settings to track Test Case - Requirement Link per version is completed
Long objectId = 789L; // Long | ID of the source object
try {
    Object result = apiInstance.unlinkArtifacts(projectId, objectType, type, body, objectId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ObjectLinkApi#unlinkArtifacts");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **objectType** | **String**| The object type of the source object. Valid values include requirements, builds, test-steps, test-logs, releases | [enum: releases, builds, requirements, test-logs, test-steps]
 **type** | **String**| The object type of the associated objects which are being added to the source object.   Valid values include releases, builds, requirements, test-cases, test-runs, test-logs, test-steps or defects | [enum: releases, builds, requirements, test-cases, test-runs, test-logs, test-steps, defects]
 **body** | **List&lt;Long&gt;**| A JSONArray of associated object IDs which are being removed from the source object  Notes:  When removing link between Test Case and Requirement, please make sure that:  - The Test Case is not routed for VERA approval  - Data migration for Test Case version when turning on Test Case Settings to track Test Case - Requirement Link per version is completed |
 **objectId** | **Long**| ID of the source object |

### Return type

**Object**

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="unlinkArtifactsByPid"></a>
# **unlinkArtifactsByPid**
> List&lt;String&gt; unlinkArtifactsByPid(projectId, objectType, linkType, body, objectId)

Removes links between objects by pids

To removes links between objects by pids

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ObjectLinkApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

ObjectLinkApi apiInstance = new ObjectLinkApi();
Long projectId = 789L; // Long | ID of the project
String objectType = "objectType_example"; // String | The object type of the source object. Valid values include test-steps, test-logs
String linkType = "linkType_example"; // String | The object type of the associated objects which are being added to the source object.   Valid value: defects
List<String> body = Arrays.asList(new List<String>()); // List<String> | A JSONArray of associated object PIDs which are being added to the source object
Long objectId = 789L; // Long | 
try {
    List<String> result = apiInstance.unlinkArtifactsByPid(projectId, objectType, linkType, body, objectId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ObjectLinkApi#unlinkArtifactsByPid");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **objectType** | **String**| The object type of the source object. Valid values include test-steps, test-logs | [enum: releases, builds, requirements, test-logs, test-steps]
 **linkType** | **String**| The object type of the associated objects which are being added to the source object.   Valid value: defects | [enum: releases, builds, requirements, test-cases, test-runs, test-logs, test-steps, defects]
 **body** | **List&lt;String&gt;**| A JSONArray of associated object PIDs which are being added to the source object |
 **objectId** | **Long**|  |

### Return type

**List&lt;String&gt;**

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

