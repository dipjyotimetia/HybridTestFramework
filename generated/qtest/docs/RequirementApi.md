# RequirementApi

All URIs are relative to *https://apitryout.qtestnet.com/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addRequirementComment**](RequirementApi.md#addRequirementComment) | **POST** /api/v3/projects/{projectId}/requirements/{idOrKey}/comments | Adds a Comment to a Requirement
[**createRequirement**](RequirementApi.md#createRequirement) | **POST** /api/v3/projects/{projectId}/requirements | Creates a Requirement
[**deleteRequirementById**](RequirementApi.md#deleteRequirementById) | **DELETE** /api/v3/projects/{projectId}/requirements/{requirementId} | Deletes a Requirement
[**deleteRequirementCommentById**](RequirementApi.md#deleteRequirementCommentById) | **DELETE** /api/v3/projects/{projectId}/requirements/{idOrKey}/comments/{commentId} | Deletes a Comment of a Requirement
[**getAllRequirementComments**](RequirementApi.md#getAllRequirementComments) | **GET** /api/v3/projects/{projectId}/requirements/{idOrKey}/comments | Gets all Comments of a Requirement
[**getPublicTraceabilityMatrixReport**](RequirementApi.md#getPublicTraceabilityMatrixReport) | **GET** /api/v3/projects/{projectId}/requirements/trace-matrix-report | Gets Requirement Traceability Matrix Report
[**getRequirement**](RequirementApi.md#getRequirement) | **GET** /api/v3/projects/{projectId}/requirements/{requirementId} | Gets a Requirement
[**getRequirementCommentById**](RequirementApi.md#getRequirementCommentById) | **GET** /api/v3/projects/{projectId}/requirements/{idOrKey}/comments/{commentId} | Gets a Comment of a Requirement
[**getRequirements**](RequirementApi.md#getRequirements) | **GET** /api/v3/projects/{projectId}/requirements | Gets multiple Requirements
[**updateRequirement**](RequirementApi.md#updateRequirement) | **PUT** /api/v3/projects/{projectId}/requirements/{requirementId} | Updates a Requirement
[**updateRequirementCommentById**](RequirementApi.md#updateRequirementCommentById) | **PUT** /api/v3/projects/{projectId}/requirements/{idOrKey}/comments/{commentId} | Updates a Comment of a Requirement


<a name="addRequirementComment"></a>
# **addRequirementComment**
> CommentResource addRequirementComment(projectId, idOrKey, body)

Adds a Comment to a Requirement

To add a comment to a Requirement  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 7.5+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.RequirementApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

RequirementApi apiInstance = new RequirementApi();
Long projectId = 789L; // Long | ID of the project
String idOrKey = "idOrKey_example"; // String | PID or ID of the Requirement.
CommentResource body = new CommentResource(); // CommentResource | The comment's properties and its content
try {
    CommentResource result = apiInstance.addRequirementComment(projectId, idOrKey, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RequirementApi#addRequirementComment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **idOrKey** | **String**| PID or ID of the Requirement. |
 **body** | [**CommentResource**](CommentResource.md)| The comment&#39;s properties and its content |

### Return type

[**CommentResource**](CommentResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="createRequirement"></a>
# **createRequirement**
> RequirementResource createRequirement(projectId, body, parentId)

Creates a Requirement

To create a new Requirement  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 4+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.RequirementApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

RequirementApi apiInstance = new RequirementApi();
Long projectId = 789L; // Long | ID of the project
RequirementResource body = new RequirementResource(); // RequirementResource | <p><em>name *:</em> Requirement name</p><p><em>properties:</em> An array of field-value pairs</p>
Long parentId = 789L; // Long | ID of the parent Module under which the Requirement will be located
try {
    RequirementResource result = apiInstance.createRequirement(projectId, body, parentId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RequirementApi#createRequirement");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **body** | [**RequirementResource**](RequirementResource.md)| &lt;p&gt;&lt;em&gt;name *:&lt;/em&gt; Requirement name&lt;/p&gt;&lt;p&gt;&lt;em&gt;properties:&lt;/em&gt; An array of field-value pairs&lt;/p&gt; |
 **parentId** | **Long**| ID of the parent Module under which the Requirement will be located | [optional]

### Return type

[**RequirementResource**](RequirementResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="deleteRequirementById"></a>
# **deleteRequirementById**
> Object deleteRequirementById(projectId, requirementId)

Deletes a Requirement

To delete a Requirement  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 6+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.RequirementApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

RequirementApi apiInstance = new RequirementApi();
Long projectId = 789L; // Long | ID of the project
Long requirementId = 789L; // Long | ID of the Requirement which needs to be deleted.
try {
    Object result = apiInstance.deleteRequirementById(projectId, requirementId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RequirementApi#deleteRequirementById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **requirementId** | **Long**| ID of the Requirement which needs to be deleted. |

### Return type

**Object**

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="deleteRequirementCommentById"></a>
# **deleteRequirementCommentById**
> Object deleteRequirementCommentById(projectId, idOrKey, commentId)

Deletes a Comment of a Requirement

To delete a comment of a Requirement  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 7.5+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.RequirementApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

RequirementApi apiInstance = new RequirementApi();
Long projectId = 789L; // Long | ID of the project
String idOrKey = "idOrKey_example"; // String | PID or ID of the Requirement whose comment you want to delete
Long commentId = 789L; // Long | The comment's ID
try {
    Object result = apiInstance.deleteRequirementCommentById(projectId, idOrKey, commentId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RequirementApi#deleteRequirementCommentById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **idOrKey** | **String**| PID or ID of the Requirement whose comment you want to delete |
 **commentId** | **Long**| The comment&#39;s ID |

### Return type

**Object**

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getAllRequirementComments"></a>
# **getAllRequirementComments**
> PagedResourceCommentResource getAllRequirementComments(projectId, idOrKey)

Gets all Comments of a Requirement

To retrieve all comments of a Requirement  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 7.6+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.RequirementApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

RequirementApi apiInstance = new RequirementApi();
Long projectId = 789L; // Long | ID of the project
String idOrKey = "idOrKey_example"; // String | PID or ID of the Requirement whose comments you want to retrieve
try {
    PagedResourceCommentResource result = apiInstance.getAllRequirementComments(projectId, idOrKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RequirementApi#getAllRequirementComments");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **idOrKey** | **String**| PID or ID of the Requirement whose comments you want to retrieve |

### Return type

[**PagedResourceCommentResource**](PagedResourceCommentResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getPublicTraceabilityMatrixReport"></a>
# **getPublicTraceabilityMatrixReport**
> List&lt;TraceabilityRequirement&gt; getPublicTraceabilityMatrixReport(projectId, page, size, fieldIds)

Gets Requirement Traceability Matrix Report

To retrieve a report of Requirements with their covering Test Cases

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.RequirementApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

RequirementApi apiInstance = new RequirementApi();
Long projectId = 789L; // Long | ID of the project
Long page = 1L; // Long | By default the first page is returned but you can specify any page number to retrieve requirements.
Integer size = 20; // Integer | The result is paginated. By default, the number of requirements in each page is 20.  You can specify your custom number in this parameter and the maximum number is 999.
String fieldIds = "fieldIds_example"; // String | ID(s) of requirement fields (system or custom fields) which you would like to retrieve.  They are separated by commas.
try {
    List<TraceabilityRequirement> result = apiInstance.getPublicTraceabilityMatrixReport(projectId, page, size, fieldIds);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RequirementApi#getPublicTraceabilityMatrixReport");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **page** | **Long**| By default the first page is returned but you can specify any page number to retrieve requirements. | [optional] [default to 1]
 **size** | **Integer**| The result is paginated. By default, the number of requirements in each page is 20.  You can specify your custom number in this parameter and the maximum number is 999. | [optional] [default to 20]
 **fieldIds** | **String**| ID(s) of requirement fields (system or custom fields) which you would like to retrieve.  They are separated by commas. | [optional]

### Return type

[**List&lt;TraceabilityRequirement&gt;**](TraceabilityRequirement.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getRequirement"></a>
# **getRequirement**
> RequirementResource getRequirement(projectId, requirementId, includeExternalProperties)

Gets a Requirement

To retrieve a Requirement  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 6+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.RequirementApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

RequirementApi apiInstance = new RequirementApi();
Long projectId = 789L; // Long | ID of the project
Long requirementId = 789L; // Long | ID of the Requirement which you want to retrieve.
Boolean includeExternalProperties = true; // Boolean | By default, Requirement external properties are not included in the response. Specify includeExternalProperties=true to include them.
try {
    RequirementResource result = apiInstance.getRequirement(projectId, requirementId, includeExternalProperties);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RequirementApi#getRequirement");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **requirementId** | **Long**| ID of the Requirement which you want to retrieve. |
 **includeExternalProperties** | **Boolean**| By default, Requirement external properties are not included in the response. Specify includeExternalProperties&#x3D;true to include them. | [optional]

### Return type

[**RequirementResource**](RequirementResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getRequirementCommentById"></a>
# **getRequirementCommentById**
> CommentResource getRequirementCommentById(projectId, idOrKey, commentId)

Gets a Comment of a Requirement

To retrieve a comment of a Requirement  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 7.5+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.RequirementApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

RequirementApi apiInstance = new RequirementApi();
Long projectId = 789L; // Long | ID of the project
String idOrKey = "idOrKey_example"; // String | PID or ID of the Requirement whose comment you want to delete
Long commentId = 789L; // Long | The comment's ID
try {
    CommentResource result = apiInstance.getRequirementCommentById(projectId, idOrKey, commentId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RequirementApi#getRequirementCommentById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **idOrKey** | **String**| PID or ID of the Requirement whose comment you want to delete |
 **commentId** | **Long**| The comment&#39;s ID |

### Return type

[**CommentResource**](CommentResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getRequirements"></a>
# **getRequirements**
> List&lt;RequirementResource&gt; getRequirements(projectId, parentId, page, size, includeExternalProperties)

Gets multiple Requirements

To retrieve all Requirements or Requirements under a specific Module

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.RequirementApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

RequirementApi apiInstance = new RequirementApi();
Long projectId = 789L; // Long | ID of the project
Long parentId = 789L; // Long | Specify the parent Module's ID to retrieve all of its Requirements which are located directly under the parent Module
Long page = 1L; // Long | By default the first page is returned but you can specify any page number to retrieve requirements.
Integer size = 56; // Integer | The result is paginated. By the default, the number of requirements in each page is 20.  You can specify your custom number in this parameter.
Boolean includeExternalProperties = true; // Boolean | By default, Requirement external properties are not included in the response. Specify includeExternalProperties=true to include them.
try {
    List<RequirementResource> result = apiInstance.getRequirements(projectId, parentId, page, size, includeExternalProperties);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RequirementApi#getRequirements");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **parentId** | **Long**| Specify the parent Module&#39;s ID to retrieve all of its Requirements which are located directly under the parent Module | [optional]
 **page** | **Long**| By default the first page is returned but you can specify any page number to retrieve requirements. | [optional] [default to 1]
 **size** | **Integer**| The result is paginated. By the default, the number of requirements in each page is 20.  You can specify your custom number in this parameter. | [optional]
 **includeExternalProperties** | **Boolean**| By default, Requirement external properties are not included in the response. Specify includeExternalProperties&#x3D;true to include them. | [optional]

### Return type

[**List&lt;RequirementResource&gt;**](RequirementResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="updateRequirement"></a>
# **updateRequirement**
> RequirementResource updateRequirement(projectId, requirementId, body, parentId)

Updates a Requirement

To update properties of an Requirement or to move it to other parent Module

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.RequirementApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

RequirementApi apiInstance = new RequirementApi();
Long projectId = 789L; // Long | ID of the project
Long requirementId = 789L; // Long | ID of the Requirement which needs to be updated.
RequirementResource body = new RequirementResource(); // RequirementResource | <strong>name: *</strong> Requirement name.  <strong>properties:</strong> An array of field-value pairs
Long parentId = 789L; // Long | ID of the parent Module to which the Requirement will be moved to
try {
    RequirementResource result = apiInstance.updateRequirement(projectId, requirementId, body, parentId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RequirementApi#updateRequirement");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **requirementId** | **Long**| ID of the Requirement which needs to be updated. |
 **body** | [**RequirementResource**](RequirementResource.md)| &lt;strong&gt;name: *&lt;/strong&gt; Requirement name.  &lt;strong&gt;properties:&lt;/strong&gt; An array of field-value pairs |
 **parentId** | **Long**| ID of the parent Module to which the Requirement will be moved to | [optional]

### Return type

[**RequirementResource**](RequirementResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="updateRequirementCommentById"></a>
# **updateRequirementCommentById**
> CommentResource updateRequirementCommentById(projectId, idOrKey, commentId, body)

Updates a Comment of a Requirement

To modify a comment of a Requirement  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 7.5+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.RequirementApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

RequirementApi apiInstance = new RequirementApi();
Long projectId = 789L; // Long | ID of the project
String idOrKey = "idOrKey_example"; // String | PID or ID of the Requirement whose comment you want to update
Long commentId = 789L; // Long | The comment's ID
CommentResource body = new CommentResource(); // CommentResource | The comment's updated content
try {
    CommentResource result = apiInstance.updateRequirementCommentById(projectId, idOrKey, commentId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RequirementApi#updateRequirementCommentById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **idOrKey** | **String**| PID or ID of the Requirement whose comment you want to update |
 **commentId** | **Long**| The comment&#39;s ID |
 **body** | [**CommentResource**](CommentResource.md)| The comment&#39;s updated content |

### Return type

[**CommentResource**](CommentResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

