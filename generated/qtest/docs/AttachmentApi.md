# AttachmentApi

All URIs are relative to *https://apitryout.qtestnet.com/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteByBlobHandleId**](AttachmentApi.md#deleteByBlobHandleId) | **DELETE** /api/v3/projects/{projectId}/{objectType}/{objectId}/blob-handles/{blobHandleId} | Deletes an Attachment from an Object
[**getAttachment**](AttachmentApi.md#getAttachment) | **GET** /api/v3/projects/{projectId}/{objectType}/{objectId}/attachments/{attachmentId} | Gets an Attachment of an Object
[**getAttachmentsOf**](AttachmentApi.md#getAttachmentsOf) | **GET** /api/v3/projects/{projectId}/{objectType}/{objectId}/attachments | Gets all Attachments of an Object
[**search**](AttachmentApi.md#search) | **GET** /api/v3/projects/{projectId}/attachments | Searches for Attachments
[**upload**](AttachmentApi.md#upload) | **POST** /api/v3/projects/{projectId}/{objectType}/{objectId}/blob-handles | Uploads an Attachment to an Object


<a name="deleteByBlobHandleId"></a>
# **deleteByBlobHandleId**
> Message deleteByBlobHandleId(projectId, blobHandleId, objectType, objectId)

Deletes an Attachment from an Object

To delete an Attachment from a Release, Build, Requirement, Test Case, Test Log, Test Step, Test Step Log or Defect  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 7.5+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AttachmentApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

AttachmentApi apiInstance = new AttachmentApi();
Long projectId = 789L; // Long | ID of the project
Long blobHandleId = 789L; // Long | ID of the Attachment
String objectType = "objectType_example"; // String | Valid values include releases, builds, requirements, test-cases, test-logs, test-steps, test-step-logs or defects  <strong>qTest Manager version:</strong> 4+
Long objectId = 789L; // Long | ID of the object (Release, Build, Requirement, Test Case, Test Log, Test Step, Test Step Log or Defect)
try {
    Message result = apiInstance.deleteByBlobHandleId(projectId, blobHandleId, objectType, objectId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AttachmentApi#deleteByBlobHandleId");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **blobHandleId** | **Long**| ID of the Attachment |
 **objectType** | **String**| Valid values include releases, builds, requirements, test-cases, test-logs, test-steps, test-step-logs or defects  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 4+ | [enum: releases, builds, requirements, test-cases, test-logs, test-steps, test-step-logs, defects]
 **objectId** | **Long**| ID of the object (Release, Build, Requirement, Test Case, Test Log, Test Step, Test Step Log or Defect) |

### Return type

[**Message**](Message.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getAttachment"></a>
# **getAttachment**
> OutputStream getAttachment(projectId, attachmentId, objectType, objectId, forceDownload)

Gets an Attachment of an Object

To retrieve an Attachment from a Release, Build, Requirement, Test Case, Test Log, Test Step, Test Step Log or Defect

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AttachmentApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

AttachmentApi apiInstance = new AttachmentApi();
Long projectId = 789L; // Long | ID of the project
Long attachmentId = 789L; // Long | ID of attachment
String objectType = "objectType_example"; // String | Valid values include <em>release</em>, <em>build</em>, <em>requirements</em>, <em>test-cases</em>, <em>test-logs</em>, <em>test-steps</em>, <em>test-step-logs</em> or <em>defects</em>
Long objectId = 789L; // Long | ID of the object (Release, Build, Requirement, Test Case, Test Log, Test Step Test Step Log or Defect)
String forceDownload = "false"; // String | Input true to download attachments which have not been scanned for malware/virus successfully. By default, its value is false
try {
    OutputStream result = apiInstance.getAttachment(projectId, attachmentId, objectType, objectId, forceDownload);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AttachmentApi#getAttachment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **attachmentId** | **Long**| ID of attachment |
 **objectType** | **String**| Valid values include &lt;em&gt;release&lt;/em&gt;, &lt;em&gt;build&lt;/em&gt;, &lt;em&gt;requirements&lt;/em&gt;, &lt;em&gt;test-cases&lt;/em&gt;, &lt;em&gt;test-logs&lt;/em&gt;, &lt;em&gt;test-steps&lt;/em&gt;, &lt;em&gt;test-step-logs&lt;/em&gt; or &lt;em&gt;defects&lt;/em&gt; | [enum: releases, builds, requirements, test-cases, test-logs, test-steps, test-step-logs, defects]
 **objectId** | **Long**| ID of the object (Release, Build, Requirement, Test Case, Test Log, Test Step Test Step Log or Defect) |
 **forceDownload** | **String**| Input true to download attachments which have not been scanned for malware/virus successfully. By default, its value is false | [optional] [default to false]

### Return type

[**OutputStream**](OutputStream.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getAttachmentsOf"></a>
# **getAttachmentsOf**
> List&lt;AttachmentResource&gt; getAttachmentsOf(projectId, objectType, objectId)

Gets all Attachments of an Object

To retrieve all Attachments of a Release, Build, Requirement, Test Case, Test Log, Test Step, Test Step Log or Defect

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AttachmentApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

AttachmentApi apiInstance = new AttachmentApi();
Long projectId = 789L; // Long | ID of the project
String objectType = "objectType_example"; // String | Valid values include <em>release</em>, <em>build</em>, <em>requirements</em>, <em>test-cases</em>, <em>test-logs</em>, <em>test-steps</em>, <em>test-step-logs</em> or <em>defects</em>
Long objectId = 789L; // Long | ID of the object (Release, Build, Requirement, Test Case, Test Log, Test Step, Test Step Log or Defect)
try {
    List<AttachmentResource> result = apiInstance.getAttachmentsOf(projectId, objectType, objectId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AttachmentApi#getAttachmentsOf");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **objectType** | **String**| Valid values include &lt;em&gt;release&lt;/em&gt;, &lt;em&gt;build&lt;/em&gt;, &lt;em&gt;requirements&lt;/em&gt;, &lt;em&gt;test-cases&lt;/em&gt;, &lt;em&gt;test-logs&lt;/em&gt;, &lt;em&gt;test-steps&lt;/em&gt;, &lt;em&gt;test-step-logs&lt;/em&gt; or &lt;em&gt;defects&lt;/em&gt; | [enum: releases, builds, requirements, test-cases, test-logs, test-steps, test-step-logs, defects]
 **objectId** | **Long**| ID of the object (Release, Build, Requirement, Test Case, Test Log, Test Step, Test Step Log or Defect) |

### Return type

[**List&lt;AttachmentResource&gt;**](AttachmentResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="search"></a>
# **search**
> PagedResourceAttachmentResource search(projectId, type, ids, author, createdDate, pageSize, page)

Searches for Attachments

To query for attachments of &lt;em&gt;Releases&lt;/em&gt;, &lt;em&gt;Builds&lt;/em&gt;, &lt;em&gt;Requirements&lt;/em&gt;, &lt;em&gt;Test Cases&lt;/em&gt;, &lt;em&gt;Test Logs&lt;/em&gt;, &lt;em&gt;Test Steps&lt;/em&gt; or &lt;em&gt;Defects&lt;/em&gt;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AttachmentApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

AttachmentApi apiInstance = new AttachmentApi();
Long projectId = 789L; // Long | ID of the project
String type = "type_example"; // String | Its valid values include <em>releases</em>, <em>builds</em>, <em>requirements</em>, <em>test-cases</em>, <em>test-steps</em>, <em>test-logs</em> or <em>defects</em>
List<Long> ids = Arrays.asList(56L); // List<Long> | List of object IDs (of the same type as specified in the parameter above), separated by commas
Long author = 789L; // Long | ID of the user who created the attachment
String createdDate = "createdDate_example"; // String | Its format is: <strong>{operator} {createdDate in timestamp or UTC}</strong>  The <em>operator</em> can be one of the following values:  <b>lt</b>: less than the given date  <b>gt</b>: greater than given date  <b>eq</b>: equal to the given date  <b>le</b>: less than or equal to the given date  <b>ge</b>: greater then or equal to the given date
Long pageSize = 100L; // Long | The result is paginated. By the default, the number of objects in each page is 100 if this is omitted. You can specify your custom number (up to 999) in this parameter
Long page = 1L; // Long | By default, the first page is returned but you can specify any page number to retrieve attachments
try {
    PagedResourceAttachmentResource result = apiInstance.search(projectId, type, ids, author, createdDate, pageSize, page);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AttachmentApi#search");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **type** | **String**| Its valid values include &lt;em&gt;releases&lt;/em&gt;, &lt;em&gt;builds&lt;/em&gt;, &lt;em&gt;requirements&lt;/em&gt;, &lt;em&gt;test-cases&lt;/em&gt;, &lt;em&gt;test-steps&lt;/em&gt;, &lt;em&gt;test-logs&lt;/em&gt; or &lt;em&gt;defects&lt;/em&gt; | [enum: releases, builds, requirements, test-cases, test-steps, test-logs, defects]
 **ids** | [**List&lt;Long&gt;**](Long.md)| List of object IDs (of the same type as specified in the parameter above), separated by commas | [optional]
 **author** | **Long**| ID of the user who created the attachment | [optional]
 **createdDate** | **String**| Its format is: &lt;strong&gt;{operator} {createdDate in timestamp or UTC}&lt;/strong&gt;  The &lt;em&gt;operator&lt;/em&gt; can be one of the following values:  &lt;b&gt;lt&lt;/b&gt;: less than the given date  &lt;b&gt;gt&lt;/b&gt;: greater than given date  &lt;b&gt;eq&lt;/b&gt;: equal to the given date  &lt;b&gt;le&lt;/b&gt;: less than or equal to the given date  &lt;b&gt;ge&lt;/b&gt;: greater then or equal to the given date | [optional]
 **pageSize** | **Long**| The result is paginated. By the default, the number of objects in each page is 100 if this is omitted. You can specify your custom number (up to 999) in this parameter | [optional] [default to 100]
 **page** | **Long**| By default, the first page is returned but you can specify any page number to retrieve attachments | [optional] [default to 1]

### Return type

[**PagedResourceAttachmentResource**](PagedResourceAttachmentResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="upload"></a>
# **upload**
> AttachmentResource upload(projectId, objectType, objectId, fileName, contentType, body)

Uploads an Attachment to an Object

To upload an Attachment to a Release, Build, Requirement, Test Case, Test Log, Test Step, Test Step Log or Defect

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AttachmentApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

AttachmentApi apiInstance = new AttachmentApi();
Long projectId = 789L; // Long | ID of the project
String objectType = "objectType_example"; // String | Valid values include releases, builds, requirements, test-cases, test-logs, test-steps, test-step-logs or defects  <strong>qTest Manager version:</strong> 4+
Long objectId = 789L; // Long | ID of the object (Release, Build, Requirement, Test Case, Test Log, Test Step, Test Step Log or Defect)
String fileName = "fileName_example"; // String | 
String contentType = "contentType_example"; // String | 
byte[] body = BINARY_DATA_HERE; // byte[] | 
try {
    AttachmentResource result = apiInstance.upload(projectId, objectType, objectId, fileName, contentType, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AttachmentApi#upload");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **objectType** | **String**| Valid values include releases, builds, requirements, test-cases, test-logs, test-steps, test-step-logs or defects  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 4+ | [enum: releases, builds, requirements, test-cases, test-logs, test-steps, test-step-logs, defects]
 **objectId** | **Long**| ID of the object (Release, Build, Requirement, Test Case, Test Log, Test Step, Test Step Log or Defect) |
 **fileName** | **String**|  |
 **contentType** | **String**|  |
 **body** | **byte[]**|  |

### Return type

[**AttachmentResource**](AttachmentResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

