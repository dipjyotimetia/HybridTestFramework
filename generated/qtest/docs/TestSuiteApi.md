# TestSuiteApi

All URIs are relative to *https://apitryout.qtestnet.com/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createTestSuite**](TestSuiteApi.md#createTestSuite) | **POST** /api/v3/projects/{projectId}/test-suites | Creates a Test Suite
[**deleteTestSuiteById**](TestSuiteApi.md#deleteTestSuiteById) | **DELETE** /api/v3/projects/{projectId}/test-suites/{testSuiteId} | Deletes a Test Suite
[**getListTestSuite**](TestSuiteApi.md#getListTestSuite) | **GET** /api/v3/projects/{projectId}/test-suites | Gets multiple Test Suite
[**getTestSuite**](TestSuiteApi.md#getTestSuite) | **GET** /api/v3/projects/{projectId}/test-suites/{testSuiteId} | Gets a Test Suite
[**updateTestSuite**](TestSuiteApi.md#updateTestSuite) | **PUT** /api/v3/projects/{projectId}/test-suites/{testSuiteId} | Updates a Test Suite


<a name="createTestSuite"></a>
# **createTestSuite**
> TestSuiteWithCustomFieldResource createTestSuite(projectId, body, parentId, parentType)

Creates a Test Suite

To create a new Test Suite  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 6+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestSuiteApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestSuiteApi apiInstance = new TestSuiteApi();
Long projectId = 789L; // Long | ID of the project
TestSuiteWithCustomFieldResource body = new TestSuiteWithCustomFieldResource(); // TestSuiteWithCustomFieldResource | The Test Suite's properties
Long parentId = 789L; // Long | ID of the Release or Test Cycle under which the newly created Test Suites are located. Input 0 (zero) to create Test Suites directly under root
String parentType = "parentType_example"; // String | Arifact type of the container. Valid values include <em>release</em>, <em>test-cycle</em> and <em>root</em>
try {
    TestSuiteWithCustomFieldResource result = apiInstance.createTestSuite(projectId, body, parentId, parentType);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestSuiteApi#createTestSuite");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **body** | [**TestSuiteWithCustomFieldResource**](TestSuiteWithCustomFieldResource.md)| The Test Suite&#39;s properties |
 **parentId** | **Long**| ID of the Release or Test Cycle under which the newly created Test Suites are located. Input 0 (zero) to create Test Suites directly under root | [optional]
 **parentType** | **String**| Arifact type of the container. Valid values include &lt;em&gt;release&lt;/em&gt;, &lt;em&gt;test-cycle&lt;/em&gt; and &lt;em&gt;root&lt;/em&gt; | [optional] [enum: root, release, test-cycle]

### Return type

[**TestSuiteWithCustomFieldResource**](TestSuiteWithCustomFieldResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="deleteTestSuiteById"></a>
# **deleteTestSuiteById**
> Object deleteTestSuiteById(projectId, testSuiteId)

Deletes a Test Suite

To delete a Test Suite  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 6+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestSuiteApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestSuiteApi apiInstance = new TestSuiteApi();
Long projectId = 789L; // Long | ID of the project
Long testSuiteId = 789L; // Long | ID of the Test Suite.
try {
    Object result = apiInstance.deleteTestSuiteById(projectId, testSuiteId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestSuiteApi#deleteTestSuiteById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **testSuiteId** | **Long**| ID of the Test Suite. |

### Return type

**Object**

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getListTestSuite"></a>
# **getListTestSuite**
> List&lt;TestSuiteWithCustomFieldResource&gt; getListTestSuite(projectId, parentId, parentType)

Gets multiple Test Suite

To retrieve Test Suites which located under a parent Release, Test Cycle or root  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 6+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestSuiteApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestSuiteApi apiInstance = new TestSuiteApi();
Long projectId = 789L; // Long | ID of the project
Long parentId = 789L; // Long | ID of the Release or Test Cycle under which the Test Suites are located. Input 0 (zero) to get Test Suites directly under root
String parentType = "parentType_example"; // String | Arifact type of the container. Valid values include <em>release</em>, <em>test-cycle</em> and <em>root</em>
try {
    List<TestSuiteWithCustomFieldResource> result = apiInstance.getListTestSuite(projectId, parentId, parentType);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestSuiteApi#getListTestSuite");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **parentId** | **Long**| ID of the Release or Test Cycle under which the Test Suites are located. Input 0 (zero) to get Test Suites directly under root | [optional]
 **parentType** | **String**| Arifact type of the container. Valid values include &lt;em&gt;release&lt;/em&gt;, &lt;em&gt;test-cycle&lt;/em&gt; and &lt;em&gt;root&lt;/em&gt; | [optional] [enum: root, release, test-cycle]

### Return type

[**List&lt;TestSuiteWithCustomFieldResource&gt;**](TestSuiteWithCustomFieldResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getTestSuite"></a>
# **getTestSuite**
> TestSuiteWithCustomFieldResource getTestSuite(projectId, testSuiteId)

Gets a Test Suite

To retrieve a Test Suite  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 6+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestSuiteApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestSuiteApi apiInstance = new TestSuiteApi();
Long projectId = 789L; // Long | ID of the project
Long testSuiteId = 789L; // Long | ID of the Test Suite
try {
    TestSuiteWithCustomFieldResource result = apiInstance.getTestSuite(projectId, testSuiteId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestSuiteApi#getTestSuite");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **testSuiteId** | **Long**| ID of the Test Suite |

### Return type

[**TestSuiteWithCustomFieldResource**](TestSuiteWithCustomFieldResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="updateTestSuite"></a>
# **updateTestSuite**
> TestSuiteWithCustomFieldResource updateTestSuite(projectId, testSuiteId, body, parentId, parentType, noEmail)

Updates a Test Suite

To update an existing Test Suite or to move it to other container  &lt;strong&gt;Important:&lt;/strong&gt; If you use the request parameters &lt;em&gt;parentId&lt;/em&gt; and &lt;em&gt;parentType&lt;/em&gt;, the request body will be ignore.   That means the Test Suite is being moved but it will not be updated with the properties specify in the request body

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestSuiteApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestSuiteApi apiInstance = new TestSuiteApi();
Long projectId = 789L; // Long | ID of the project
Long testSuiteId = 789L; // Long | ID of the Test Suite
TestSuiteWithCustomFieldResource body = new TestSuiteWithCustomFieldResource(); // TestSuiteWithCustomFieldResource | The Test Suite's updated properties
Long parentId = 789L; // Long | ID of the Release or Test Cycle which the Test Suite will be moved to. Input 0 (zero) to move the Test Suite to under root
String parentType = "parentType_example"; // String | Artifact type of the parent container. Valid values include <em>release</em>, <em>test-cycle</em> and <em>root</em>
Boolean noEmail = true; // Boolean | 
try {
    TestSuiteWithCustomFieldResource result = apiInstance.updateTestSuite(projectId, testSuiteId, body, parentId, parentType, noEmail);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestSuiteApi#updateTestSuite");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **testSuiteId** | **Long**| ID of the Test Suite |
 **body** | [**TestSuiteWithCustomFieldResource**](TestSuiteWithCustomFieldResource.md)| The Test Suite&#39;s updated properties |
 **parentId** | **Long**| ID of the Release or Test Cycle which the Test Suite will be moved to. Input 0 (zero) to move the Test Suite to under root | [optional]
 **parentType** | **String**| Artifact type of the parent container. Valid values include &lt;em&gt;release&lt;/em&gt;, &lt;em&gt;test-cycle&lt;/em&gt; and &lt;em&gt;root&lt;/em&gt; | [optional] [enum: root, release, test-cycle]
 **noEmail** | **Boolean**|  | [optional]

### Return type

[**TestSuiteWithCustomFieldResource**](TestSuiteWithCustomFieldResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

