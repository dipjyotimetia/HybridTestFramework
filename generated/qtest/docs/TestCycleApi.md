# TestCycleApi

All URIs are relative to *https://apitryout.qtestnet.com/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createCycle**](TestCycleApi.md#createCycle) | **POST** /api/v3/projects/{projectId}/test-cycles | Create a Test Cycle
[**deleteCycle**](TestCycleApi.md#deleteCycle) | **DELETE** /api/v3/projects/{projectId}/test-cycles/{testCycleId} | Deletes a Test Cycle
[**getTestCycle**](TestCycleApi.md#getTestCycle) | **GET** /api/v3/projects/{projectId}/test-cycles/{testCycleId} | Gets a Test Cycle
[**getTestCycles**](TestCycleApi.md#getTestCycles) | **GET** /api/v3/projects/{projectId}/test-cycles | Gets multiple Test Cycles
[**updateCycle**](TestCycleApi.md#updateCycle) | **PUT** /api/v3/projects/{projectId}/test-cycles/{testCycleId} | Updates a Test Cycle


<a name="createCycle"></a>
# **createCycle**
> TestCycleResource createCycle(projectId, body, parentId, parentType)

Create a Test Cycle

To create a Test Cycle  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 6+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestCycleApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestCycleApi apiInstance = new TestCycleApi();
Long projectId = 789L; // Long | ID of the project
TestCycleResource body = new TestCycleResource(); // TestCycleResource | Given resource to create a test cycle.
Long parentId = 789L; // Long | ID of the Release or Test Cycle under which the newly created Test Cycle will be located.   Use 0 (zero) to create the Test Cycle under the root
String parentType = "parentType_example"; // String | The artifact type of the parent folder. Valid values include <em>release</em>, <em>test-cycle</em> or <em>root</em>
try {
    TestCycleResource result = apiInstance.createCycle(projectId, body, parentId, parentType);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestCycleApi#createCycle");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **body** | [**TestCycleResource**](TestCycleResource.md)| Given resource to create a test cycle. |
 **parentId** | **Long**| ID of the Release or Test Cycle under which the newly created Test Cycle will be located.   Use 0 (zero) to create the Test Cycle under the root | [optional]
 **parentType** | **String**| The artifact type of the parent folder. Valid values include &lt;em&gt;release&lt;/em&gt;, &lt;em&gt;test-cycle&lt;/em&gt; or &lt;em&gt;root&lt;/em&gt; | [optional] [enum: root, release, test-cycle]

### Return type

[**TestCycleResource**](TestCycleResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="deleteCycle"></a>
# **deleteCycle**
> Message deleteCycle(projectId, testCycleId, force)

Deletes a Test Cycle

To delete a Test Cycle  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 6+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestCycleApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestCycleApi apiInstance = new TestCycleApi();
Long projectId = 789L; // Long | ID of the project
Long testCycleId = 789L; // Long | ID of the Test Cycle which needs to be deleted.
Boolean force = true; // Boolean | The Test Cycle can only be deleted if it contains no children. Specify <em>force=true</em> to delete the Test Cycle and its children
try {
    Message result = apiInstance.deleteCycle(projectId, testCycleId, force);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestCycleApi#deleteCycle");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **testCycleId** | **Long**| ID of the Test Cycle which needs to be deleted. |
 **force** | **Boolean**| The Test Cycle can only be deleted if it contains no children. Specify &lt;em&gt;force&#x3D;true&lt;/em&gt; to delete the Test Cycle and its children | [optional]

### Return type

[**Message**](Message.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getTestCycle"></a>
# **getTestCycle**
> TestCycleResource getTestCycle(projectId, testCycleId, expand)

Gets a Test Cycle

To retrieve a Test Cycle  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 6+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestCycleApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestCycleApi apiInstance = new TestCycleApi();
Long projectId = 789L; // Long | ID of the project
Long testCycleId = 789L; // Long | ID of the Test Cycle which you want to retrieve.
String expand = "expand_example"; // String | Specify <em>expand=descendants</em> to include its sub and grand-sub Test Cycles and Test Suites in the response
try {
    TestCycleResource result = apiInstance.getTestCycle(projectId, testCycleId, expand);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestCycleApi#getTestCycle");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **testCycleId** | **Long**| ID of the Test Cycle which you want to retrieve. |
 **expand** | **String**| Specify &lt;em&gt;expand&#x3D;descendants&lt;/em&gt; to include its sub and grand-sub Test Cycles and Test Suites in the response | [optional]

### Return type

[**TestCycleResource**](TestCycleResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getTestCycles"></a>
# **getTestCycles**
> List&lt;TestCycleResource&gt; getTestCycles(projectId, parentId, parentType, expand, tosca)

Gets multiple Test Cycles

To retrieve Test Cycles which are located directly under root or a Release/Test Cycle

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestCycleApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestCycleApi apiInstance = new TestCycleApi();
Long projectId = 789L; // Long | ID of the project
Long parentId = 789L; // Long | ID of the Release or Test Cycle which directly contains the Test Cycles you are retrieving. Input 0 (zero) to get Test Cycles directly under root
String parentType = "parentType_example"; // String | The artifact type of the parent folder. Valid values include <em>release</em>, <em>test-cycle</em> or <em>root</em>
String expand = "expand_example"; // String | Specify <em>expand=descendants</em> to retrieve the Test Cycles' sub and grand-sub Cycles/Suites
Boolean tosca = true; // Boolean | tosca
try {
    List<TestCycleResource> result = apiInstance.getTestCycles(projectId, parentId, parentType, expand, tosca);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestCycleApi#getTestCycles");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **parentId** | **Long**| ID of the Release or Test Cycle which directly contains the Test Cycles you are retrieving. Input 0 (zero) to get Test Cycles directly under root | [optional]
 **parentType** | **String**| The artifact type of the parent folder. Valid values include &lt;em&gt;release&lt;/em&gt;, &lt;em&gt;test-cycle&lt;/em&gt; or &lt;em&gt;root&lt;/em&gt; | [optional] [enum: root, release, test-cycle]
 **expand** | **String**| Specify &lt;em&gt;expand&#x3D;descendants&lt;/em&gt; to retrieve the Test Cycles&#39; sub and grand-sub Cycles/Suites | [optional] [enum: descendants]
 **tosca** | **Boolean**| tosca | [optional]

### Return type

[**List&lt;TestCycleResource&gt;**](TestCycleResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="updateCycle"></a>
# **updateCycle**
> TestCycleResource updateCycle(projectId, testCycleId, body, parentId, parentType)

Updates a Test Cycle

To update a Test Cycle or move it to another container  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 6+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestCycleApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestCycleApi apiInstance = new TestCycleApi();
Long projectId = 789L; // Long | ID of the project
Long testCycleId = 789L; // Long | ID of the Test Cycle which needs to be updated.
TestCycleResource body = new TestCycleResource(); // TestCycleResource | The Test Cycle's updated properties
Long parentId = 789L; // Long | ID of a Release or parent Test Cycle which the updated Test Cycle will be moved to. Input 0 (zero) to move the Test Cycle to under root
String parentType = "parentType_example"; // String | The artifact type of the parent folder to which the Test Cycle will be moved to. Valid values include <em>release</em>, <em>test-cycle</em> or <em>root</em>
try {
    TestCycleResource result = apiInstance.updateCycle(projectId, testCycleId, body, parentId, parentType);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestCycleApi#updateCycle");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **testCycleId** | **Long**| ID of the Test Cycle which needs to be updated. |
 **body** | [**TestCycleResource**](TestCycleResource.md)| The Test Cycle&#39;s updated properties |
 **parentId** | **Long**| ID of a Release or parent Test Cycle which the updated Test Cycle will be moved to. Input 0 (zero) to move the Test Cycle to under root | [optional]
 **parentType** | **String**| The artifact type of the parent folder to which the Test Cycle will be moved to. Valid values include &lt;em&gt;release&lt;/em&gt;, &lt;em&gt;test-cycle&lt;/em&gt; or &lt;em&gt;root&lt;/em&gt; | [optional] [enum: root, release, test-cycle]

### Return type

[**TestCycleResource**](TestCycleResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

