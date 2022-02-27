# DefectApi

All URIs are relative to *https://apitryout.qtestnet.com/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addComment**](DefectApi.md#addComment) | **POST** /api/v3/projects/{projectId}/defects/{idOrKey}/comments | Adds a Comment to a Defect
[**deleteComment**](DefectApi.md#deleteComment) | **DELETE** /api/v3/projects/{projectId}/defects/{idOrKey}/comments/{commentId} | Deletes a Comment of a Defect
[**getComments**](DefectApi.md#getComments) | **GET** /api/v3/projects/{projectId}/defects/{idOrKey}/comments | Gets all Comments of a Defect
[**getDefect**](DefectApi.md#getDefect) | **GET** /api/v3/projects/{projectId}/defects/{defectId} | Gets a Defect
[**getDefectCommentById**](DefectApi.md#getDefectCommentById) | **GET** /api/v3/projects/{projectId}/defects/{idOrKey}/comments/{commentId} | Gets a Comment of a Defect
[**getLastChanged**](DefectApi.md#getLastChanged) | **GET** /api/v3/projects/{projectId}/defects/last-change | Gets recently updated Defects
[**submitDefect**](DefectApi.md#submitDefect) | **POST** /api/v3/projects/{projectId}/defects | Submit a Defect
[**updateComment**](DefectApi.md#updateComment) | **PUT** /api/v3/projects/{projectId}/defects/{idOrKey}/comments/{commentId} | Updates a Comment of a Defect
[**updateDefect**](DefectApi.md#updateDefect) | **PUT** /api/v3/projects/{projectId}/defects/{defectId} | Updates a Defect


<a name="addComment"></a>
# **addComment**
> CommentResource addComment(projectId, idOrKey, body)

Adds a Comment to a Defect

To add a Comment to a Defect  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 7.5+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.DefectApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

DefectApi apiInstance = new DefectApi();
Long projectId = 789L; // Long | ID of the project
String idOrKey = "idOrKey_example"; // String | PID or ID of the Defect
CommentResource body = new CommentResource(); // CommentResource | The Comment's content
try {
    CommentResource result = apiInstance.addComment(projectId, idOrKey, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefectApi#addComment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **idOrKey** | **String**| PID or ID of the Defect |
 **body** | [**CommentResource**](CommentResource.md)| The Comment&#39;s content |

### Return type

[**CommentResource**](CommentResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="deleteComment"></a>
# **deleteComment**
> Object deleteComment(projectId, idOrKey, commentId)

Deletes a Comment of a Defect

To delete a specific Comment of a Defect  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 7.5+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.DefectApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

DefectApi apiInstance = new DefectApi();
Long projectId = 789L; // Long | ID of the project
String idOrKey = "idOrKey_example"; // String | PID or ID of the Defect whose Comment you want to delete
Long commentId = 789L; // Long | ID of the comment.
try {
    Object result = apiInstance.deleteComment(projectId, idOrKey, commentId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefectApi#deleteComment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **idOrKey** | **String**| PID or ID of the Defect whose Comment you want to delete |
 **commentId** | **Long**| ID of the comment. |

### Return type

**Object**

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getComments"></a>
# **getComments**
> PagedResourceCommentResource getComments(projectId, idOrKey, page, pageSize)

Gets all Comments of a Defect

To retrieve all Comments of a Defect  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 7.5+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.DefectApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

DefectApi apiInstance = new DefectApi();
Long projectId = 789L; // Long | ID of the project
String idOrKey = "idOrKey_example"; // String | PID or ID of the Defect whose comments you want to retrieve
Long page = 1L; // Long | By default the first page is returned but you can specify any page number to retrieve objects
Long pageSize = 100L; // Long | The result is paginated. By the default, the number of objects in each page is 100 if this is omitted. You can specify your custom number (up to 999) in this parameter
try {
    PagedResourceCommentResource result = apiInstance.getComments(projectId, idOrKey, page, pageSize);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefectApi#getComments");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **idOrKey** | **String**| PID or ID of the Defect whose comments you want to retrieve |
 **page** | **Long**| By default the first page is returned but you can specify any page number to retrieve objects | [optional] [default to 1]
 **pageSize** | **Long**| The result is paginated. By the default, the number of objects in each page is 100 if this is omitted. You can specify your custom number (up to 999) in this parameter | [optional] [default to 100]

### Return type

[**PagedResourceCommentResource**](PagedResourceCommentResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getDefect"></a>
# **getDefect**
> DefectResource getDefect(projectId, defectId)

Gets a Defect

To retrieve a Defect  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 6+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.DefectApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

DefectApi apiInstance = new DefectApi();
Long projectId = 789L; // Long | ID of the project
String defectId = "defectId_example"; // String | ID of the defect.
try {
    DefectResource result = apiInstance.getDefect(projectId, defectId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefectApi#getDefect");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **defectId** | **String**| ID of the defect. |

### Return type

[**DefectResource**](DefectResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getDefectCommentById"></a>
# **getDefectCommentById**
> CommentResource getDefectCommentById(projectId, idOrKey, commentId)

Gets a Comment of a Defect

To retrieve a specific Comment of a Defect  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 7.5+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.DefectApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

DefectApi apiInstance = new DefectApi();
Long projectId = 789L; // Long | ID of the project
String idOrKey = "idOrKey_example"; // String | PID or ID of the Defect whose comment you want to retrieve
Long commentId = 789L; // Long | ID of the comment
try {
    CommentResource result = apiInstance.getDefectCommentById(projectId, idOrKey, commentId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefectApi#getDefectCommentById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **idOrKey** | **String**| PID or ID of the Defect whose comment you want to retrieve |
 **commentId** | **Long**| ID of the comment |

### Return type

[**CommentResource**](CommentResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getLastChanged"></a>
# **getLastChanged**
> List&lt;DefectResource&gt; getLastChanged(projectId, startTime, endTime, size, page)

Gets recently updated Defects

To retrieve Defects which have been recently updated after a specified time

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.DefectApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

DefectApi apiInstance = new DefectApi();
Long projectId = 789L; // Long | ID of the project
String startTime = "startTime_example"; // String | The specified time since when the Defects have been updated. It needs to be URL encoded: <em>yyyy-MM-dd'T'HH:mm:ss.SSSZ</em> or <em>yyyy-MM-dd'T'HH:mm:ssZZ</em>
String endTime = "endTime_example"; // String | Do not support at this time. Use the current time only.
Integer size = 100; // Integer | The result is paginated. By the default, the number of objects in each page is 100. You can specify your custom number in this parameter. The maximum page size is 999.
Long page = 1L; // Long | By default the first page is returned but you can specify any page number to retrieve objects
try {
    List<DefectResource> result = apiInstance.getLastChanged(projectId, startTime, endTime, size, page);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefectApi#getLastChanged");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **startTime** | **String**| The specified time since when the Defects have been updated. It needs to be URL encoded: &lt;em&gt;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&lt;/em&gt; or &lt;em&gt;yyyy-MM-dd&#39;T&#39;HH:mm:ssZZ&lt;/em&gt; |
 **endTime** | **String**| Do not support at this time. Use the current time only. | [optional]
 **size** | **Integer**| The result is paginated. By the default, the number of objects in each page is 100. You can specify your custom number in this parameter. The maximum page size is 999. | [optional] [default to 100]
 **page** | **Long**| By default the first page is returned but you can specify any page number to retrieve objects | [optional] [default to 1]

### Return type

[**List&lt;DefectResource&gt;**](DefectResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="submitDefect"></a>
# **submitDefect**
> DefectResource submitDefect(projectId, body)

Submit a Defect

To submit an internal Defect

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.DefectApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

DefectApi apiInstance = new DefectApi();
Long projectId = 789L; // Long | ID of the project
DefectResource body = new DefectResource(); // DefectResource | <em>properties:</em> a JSONArray of field-value pairs  <em>attachments:</em> a JSONArray of Attachment objects
try {
    DefectResource result = apiInstance.submitDefect(projectId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefectApi#submitDefect");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **body** | [**DefectResource**](DefectResource.md)| &lt;em&gt;properties:&lt;/em&gt; a JSONArray of field-value pairs  &lt;em&gt;attachments:&lt;/em&gt; a JSONArray of Attachment objects |

### Return type

[**DefectResource**](DefectResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="updateComment"></a>
# **updateComment**
> CommentResource updateComment(projectId, idOrKey, commentId, body)

Updates a Comment of a Defect

To update a specific Comment of a Defect  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 7.5+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.DefectApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

DefectApi apiInstance = new DefectApi();
Long projectId = 789L; // Long | ID of the project
String idOrKey = "idOrKey_example"; // String | PID or ID of the defect whose comment you want to update
Long commentId = 789L; // Long | ID of the comment
CommentResource body = new CommentResource(); // CommentResource | Given resource to update a comment.
try {
    CommentResource result = apiInstance.updateComment(projectId, idOrKey, commentId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefectApi#updateComment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **idOrKey** | **String**| PID or ID of the defect whose comment you want to update |
 **commentId** | **Long**| ID of the comment |
 **body** | [**CommentResource**](CommentResource.md)| Given resource to update a comment. |

### Return type

[**CommentResource**](CommentResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="updateDefect"></a>
# **updateDefect**
> DefectResource updateDefect(projectId, defectId, body)

Updates a Defect

To update a Defect  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 6+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.DefectApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

DefectApi apiInstance = new DefectApi();
Long projectId = 789L; // Long | ID of the project
Long defectId = 789L; // Long | ID of the Defect which needs to be updated.
DefectResource body = new DefectResource(); // DefectResource | The Defect's updated properties
try {
    DefectResource result = apiInstance.updateDefect(projectId, defectId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefectApi#updateDefect");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **defectId** | **Long**| ID of the Defect which needs to be updated. |
 **body** | [**DefectResource**](DefectResource.md)| The Defect&#39;s updated properties |

### Return type

[**DefectResource**](DefectResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

