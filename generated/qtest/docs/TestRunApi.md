# TestRunApi

All URIs are relative to *https://apitryout.qtestnet.com/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addTestRunComment**](TestRunApi.md#addTestRunComment) | **POST** /api/v3/projects/{projectId}/test-runs/{idOrKey}/comments | Adds a Comment to a Test Run
[**addTestRunWithParameters**](TestRunApi.md#addTestRunWithParameters) | **POST** /api/v3/projects/{projectId}/test-runs/assign-parameter-values/manually | Create multiple Test Runs with Parameter values manual
[**addTestRunWithParametersDataset**](TestRunApi.md#addTestRunWithParametersDataset) | **POST** /api/v3/projects/{projectId}/test-runs/assign-parameter-values/dataset | Create multiple Test Runs with Parameter values from dataset.
[**addTestRunWithParametersRandomize**](TestRunApi.md#addTestRunWithParametersRandomize) | **POST** /api/v3/projects/{projectId}/test-runs/assign-parameter-values/randomize | Create multiple Test Runs with Parameter values random from selection combine type.
[**createTestRun**](TestRunApi.md#createTestRun) | **POST** /api/v3/projects/{projectId}/test-runs | Creates a Test Run
[**deleteCommentById**](TestRunApi.md#deleteCommentById) | **DELETE** /api/v3/projects/{projectId}/test-runs/{idOrKey}/comments/{commentId} | Deletes a Comment of a Test Run
[**deleteTestRunById**](TestRunApi.md#deleteTestRunById) | **DELETE** /api/v3/projects/{projectId}/test-runs/{testRunId} | Deletes a Test Run
[**getOf**](TestRunApi.md#getOf) | **GET** /api/v3/projects/{projectId}/test-runs | Gets multiple Test Runs
[**getStatusValuable**](TestRunApi.md#getStatusValuable) | **GET** /api/v3/projects/{projectId}/test-runs/execution-statuses | Gets Test Run statuses
[**getSubhierachy**](TestRunApi.md#getSubhierachy) | **GET** /api/v3/projects/{projectId}/test-runs/subhierarchy | Gets a Sub Hierarchy
[**getTestRunById**](TestRunApi.md#getTestRunById) | **GET** /api/v3/projects/{projectId}/test-runs/{testRunId} | Gets a Test Run
[**getTestRunCommentById**](TestRunApi.md#getTestRunCommentById) | **GET** /api/v3/projects/{projectId}/test-runs/{idOrKey}/comments/{commentId} | Gets a Comment from a Test Run
[**getTestRunComments**](TestRunApi.md#getTestRunComments) | **GET** /api/v3/projects/{projectId}/test-runs/{idOrKey}/comments | Gets all Comments of a Test Run
[**updateCommentById**](TestRunApi.md#updateCommentById) | **PUT** /api/v3/projects/{projectId}/test-runs/{idOrKey}/comments/{commentId} | Updates a Comment of a Test Run
[**updateTestRunById**](TestRunApi.md#updateTestRunById) | **PUT** /api/v3/projects/{projectId}/test-runs/{testRunId} | Updates a Test Run


<a name="addTestRunComment"></a>
# **addTestRunComment**
> CommentResource addTestRunComment(projectId, idOrKey, body)

Adds a Comment to a Test Run

To add a Comment to a Test Run  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 7.5+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestRunApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestRunApi apiInstance = new TestRunApi();
Long projectId = 789L; // Long | ID of the project
String idOrKey = "idOrKey_example"; // String | The PID or ID of the Test Run.
CommentResource body = new CommentResource(); // CommentResource | The Comment's content
try {
    CommentResource result = apiInstance.addTestRunComment(projectId, idOrKey, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestRunApi#addTestRunComment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **idOrKey** | **String**| The PID or ID of the Test Run. |
 **body** | [**CommentResource**](CommentResource.md)| The Comment&#39;s content |

### Return type

[**CommentResource**](CommentResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="addTestRunWithParameters"></a>
# **addTestRunWithParameters**
> QueueProcessingResponseTestRunDataVM addTestRunWithParameters(projectId, body, parentId, parentType)

Create multiple Test Runs with Parameter values manual

To create multiple Test Runs with parameter values under root or a container (Release, Test Cycle or Test Suite). Maximum number of test runs can be created is 100.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestRunApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestRunApi apiInstance = new TestRunApi();
Long projectId = 789L; // Long | ID of the project
TestRunWithParameterCreateManualResource body = new TestRunWithParameterCreateManualResource(); // TestRunWithParameterCreateManualResource | The Test Run's properties, its associated Test Case and list of Test runs   <em>name (optional):</em> All test runs will be created with the same name if provided. If not provided, test run name = test case name + [increased number, starting from 1]   <em>properties (optional):</em> All test runs will be created with the same property list if provided. If not provided, default property values will be used.   <strong>test_case attributes:</strong>  <em>id (required):</em> id of testcase   <em>test_case_version_id (optional):</em> Version ID of Testcase. If not specify, latest value will be used. For shared test case, only accept approved version   <em>test_runs (required):</em> list of test runs will be created by this API. For each test run, it will have list of test steps (by providing test step id) and their parameter_values for each step.   <strong>You no need to specify <em>combined_type</em> and <em>number_of_combinations</em> in this api.<strong>
Long parentId = 789L; // Long | ID of the container  Input 0 (zero) to get Test Runs directly under root
String parentType = "parentType_example"; // String | Type of the container. Valid values include <em>root</em>, <em>release</em>, <em>test-cycle</em>, and <em>test-suite</em>
try {
    QueueProcessingResponseTestRunDataVM result = apiInstance.addTestRunWithParameters(projectId, body, parentId, parentType);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestRunApi#addTestRunWithParameters");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **body** | [**TestRunWithParameterCreateManualResource**](TestRunWithParameterCreateManualResource.md)| The Test Run&#39;s properties, its associated Test Case and list of Test runs   &lt;em&gt;name (optional):&lt;/em&gt; All test runs will be created with the same name if provided. If not provided, test run name &#x3D; test case name + [increased number, starting from 1]   &lt;em&gt;properties (optional):&lt;/em&gt; All test runs will be created with the same property list if provided. If not provided, default property values will be used.   &lt;strong&gt;test_case attributes:&lt;/strong&gt;  &lt;em&gt;id (required):&lt;/em&gt; id of testcase   &lt;em&gt;test_case_version_id (optional):&lt;/em&gt; Version ID of Testcase. If not specify, latest value will be used. For shared test case, only accept approved version   &lt;em&gt;test_runs (required):&lt;/em&gt; list of test runs will be created by this API. For each test run, it will have list of test steps (by providing test step id) and their parameter_values for each step.   &lt;strong&gt;You no need to specify &lt;em&gt;combined_type&lt;/em&gt; and &lt;em&gt;number_of_combinations&lt;/em&gt; in this api.&lt;strong&gt; |
 **parentId** | **Long**| ID of the container  Input 0 (zero) to get Test Runs directly under root | [optional]
 **parentType** | **String**| Type of the container. Valid values include &lt;em&gt;root&lt;/em&gt;, &lt;em&gt;release&lt;/em&gt;, &lt;em&gt;test-cycle&lt;/em&gt;, and &lt;em&gt;test-suite&lt;/em&gt; | [optional] [enum: root, release, test-cycle, test-suite]

### Return type

[**QueueProcessingResponseTestRunDataVM**](QueueProcessingResponseTestRunDataVM.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="addTestRunWithParametersDataset"></a>
# **addTestRunWithParametersDataset**
> QueueProcessingResponseTestRunDataVM addTestRunWithParametersDataset(projectId, body, parentId, parentType)

Create multiple Test Runs with Parameter values from dataset.

To create multiple Test Runs with parameter values under root or a container (Release, Test Cycle or Test Suite). Number of test runs can be created depend on number_of_rows property and it should not more than 100.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestRunApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestRunApi apiInstance = new TestRunApi();
Long projectId = 789L; // Long | ID of the project
TestRunWithParameterCreateByDatasetResource body = new TestRunWithParameterCreateByDatasetResource(); // TestRunWithParameterCreateByDatasetResource | The Test Run's properties, its associated Test Case and specific data set   <em>name (optional):</em> All test runs will be created with the same name if provided. If not provided, test run name = test case name + [increased number, starting from 1]   <em>properties (optional):</em> All test runs will be created with the same property list if provided. If not provided, default property values will be used.   <strong>test_case attributes:</strong>  <em>id (required):</em> id of testcase   <em>test_case_version_id (optional):</em> Version ID of Testcase. If not specify, latest value will be used. For shared test case, only accept approved version   <em>dataset_id:</em> Dataset id use for generate test runs. Dataset must be active and contains all parameters inside all test case steps. Dataset has at least 1 data row.   <em>from_row:</em> Must be less or equal max rows in dataset.   <em>number_of_rows:</em> number of test run can be create must be less or equal ((max rows - from_row) +1) and must be less than <em>100</em>.
Long parentId = 789L; // Long | ID of the container  Input 0 (zero) to get Test Runs directly under root
String parentType = "parentType_example"; // String | Type of the container. Valid values include <em>root</em>, <em>release</em>, <em>test-cycle</em>, and <em>test-suite</em>
try {
    QueueProcessingResponseTestRunDataVM result = apiInstance.addTestRunWithParametersDataset(projectId, body, parentId, parentType);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestRunApi#addTestRunWithParametersDataset");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **body** | [**TestRunWithParameterCreateByDatasetResource**](TestRunWithParameterCreateByDatasetResource.md)| The Test Run&#39;s properties, its associated Test Case and specific data set   &lt;em&gt;name (optional):&lt;/em&gt; All test runs will be created with the same name if provided. If not provided, test run name &#x3D; test case name + [increased number, starting from 1]   &lt;em&gt;properties (optional):&lt;/em&gt; All test runs will be created with the same property list if provided. If not provided, default property values will be used.   &lt;strong&gt;test_case attributes:&lt;/strong&gt;  &lt;em&gt;id (required):&lt;/em&gt; id of testcase   &lt;em&gt;test_case_version_id (optional):&lt;/em&gt; Version ID of Testcase. If not specify, latest value will be used. For shared test case, only accept approved version   &lt;em&gt;dataset_id:&lt;/em&gt; Dataset id use for generate test runs. Dataset must be active and contains all parameters inside all test case steps. Dataset has at least 1 data row.   &lt;em&gt;from_row:&lt;/em&gt; Must be less or equal max rows in dataset.   &lt;em&gt;number_of_rows:&lt;/em&gt; number of test run can be create must be less or equal ((max rows - from_row) +1) and must be less than &lt;em&gt;100&lt;/em&gt;. |
 **parentId** | **Long**| ID of the container  Input 0 (zero) to get Test Runs directly under root | [optional]
 **parentType** | **String**| Type of the container. Valid values include &lt;em&gt;root&lt;/em&gt;, &lt;em&gt;release&lt;/em&gt;, &lt;em&gt;test-cycle&lt;/em&gt;, and &lt;em&gt;test-suite&lt;/em&gt; | [optional] [enum: root, release, test-cycle, test-suite]

### Return type

[**QueueProcessingResponseTestRunDataVM**](QueueProcessingResponseTestRunDataVM.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="addTestRunWithParametersRandomize"></a>
# **addTestRunWithParametersRandomize**
> QueueProcessingResponseTestRunDataVM addTestRunWithParametersRandomize(projectId, body, parentId, parentType)

Create multiple Test Runs with Parameter values random from selection combine type.

To create multiple Test Runs with parameter values under root or a container (Release, Test Cycle or Test Suite). Maximum number of test runs can be created depend on combine type.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestRunApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestRunApi apiInstance = new TestRunApi();
Long projectId = 789L; // Long | ID of the project
TestRunWithParameterCreateRandomResource body = new TestRunWithParameterCreateRandomResource(); // TestRunWithParameterCreateRandomResource | The Test Run's properties, its associated Test Case and combine type, number of combination   <em>name (optional):</em> All test runs will be created with the same name if provided. If not provided, test run name = test case name + [increased number, starting from 1]   <em>properties (optional):</em> All test runs will be created with the same property list if provided. If not provided, default property values will be used.   <strong>test_case attributes:</strong>  <em>id (required):</em> id of testcase   <em>test_case_version_id (optional):</em> Version ID of Testcase. If not specify, latest value will be used. For shared test case, only accept approved version   <em>combined_type:</em> combine type for generate test runs with random test run value. Values can specify for this property are: <strong>1</strong> (for unique_value ) OR <strong>0</strong> (for unique_data ).   <em>number_of_combinations:</em> number of test run can be create must be less or equal max possible created combinations based on selected combination_type and must less than <em>100</em>.
Long parentId = 789L; // Long | ID of the container  Input 0 (zero) to get Test Runs directly under root
String parentType = "parentType_example"; // String | Type of the container. Valid values include <em>root</em>, <em>release</em>, <em>test-cycle</em>, and <em>test-suite</em>
try {
    QueueProcessingResponseTestRunDataVM result = apiInstance.addTestRunWithParametersRandomize(projectId, body, parentId, parentType);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestRunApi#addTestRunWithParametersRandomize");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **body** | [**TestRunWithParameterCreateRandomResource**](TestRunWithParameterCreateRandomResource.md)| The Test Run&#39;s properties, its associated Test Case and combine type, number of combination   &lt;em&gt;name (optional):&lt;/em&gt; All test runs will be created with the same name if provided. If not provided, test run name &#x3D; test case name + [increased number, starting from 1]   &lt;em&gt;properties (optional):&lt;/em&gt; All test runs will be created with the same property list if provided. If not provided, default property values will be used.   &lt;strong&gt;test_case attributes:&lt;/strong&gt;  &lt;em&gt;id (required):&lt;/em&gt; id of testcase   &lt;em&gt;test_case_version_id (optional):&lt;/em&gt; Version ID of Testcase. If not specify, latest value will be used. For shared test case, only accept approved version   &lt;em&gt;combined_type:&lt;/em&gt; combine type for generate test runs with random test run value. Values can specify for this property are: &lt;strong&gt;1&lt;/strong&gt; (for unique_value ) OR &lt;strong&gt;0&lt;/strong&gt; (for unique_data ).   &lt;em&gt;number_of_combinations:&lt;/em&gt; number of test run can be create must be less or equal max possible created combinations based on selected combination_type and must less than &lt;em&gt;100&lt;/em&gt;. |
 **parentId** | **Long**| ID of the container  Input 0 (zero) to get Test Runs directly under root | [optional]
 **parentType** | **String**| Type of the container. Valid values include &lt;em&gt;root&lt;/em&gt;, &lt;em&gt;release&lt;/em&gt;, &lt;em&gt;test-cycle&lt;/em&gt;, and &lt;em&gt;test-suite&lt;/em&gt; | [optional] [enum: root, release, test-cycle, test-suite]

### Return type

[**QueueProcessingResponseTestRunDataVM**](QueueProcessingResponseTestRunDataVM.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="createTestRun"></a>
# **createTestRun**
> TestRunWithCustomFieldResource createTestRun(projectId, body, parentId, parentType)

Creates a Test Run

To create a Test Run under root or a container (Release, Test Cycle or Test Suite)  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 6+You can optionally specify a parent in the request parameter to create its test runs.  The associated Test Case is specified in the request body

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestRunApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestRunApi apiInstance = new TestRunApi();
Long projectId = 789L; // Long | ID of the project
TestRunWithCustomFieldResource body = new TestRunWithCustomFieldResource(); // TestRunWithCustomFieldResource | The Test Run's properties and its associated Test Case
Long parentId = 789L; // Long | ID of the container  Input 0 (zero) to get Test Runs directly under root
String parentType = "parentType_example"; // String | Type of the container. Valid values include <em>root</em>, <em>release</em>, <em>test-cycle</em>, and <em>test-suite</em>
try {
    TestRunWithCustomFieldResource result = apiInstance.createTestRun(projectId, body, parentId, parentType);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestRunApi#createTestRun");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **body** | [**TestRunWithCustomFieldResource**](TestRunWithCustomFieldResource.md)| The Test Run&#39;s properties and its associated Test Case |
 **parentId** | **Long**| ID of the container  Input 0 (zero) to get Test Runs directly under root | [optional]
 **parentType** | **String**| Type of the container. Valid values include &lt;em&gt;root&lt;/em&gt;, &lt;em&gt;release&lt;/em&gt;, &lt;em&gt;test-cycle&lt;/em&gt;, and &lt;em&gt;test-suite&lt;/em&gt; | [optional] [enum: root, release, test-cycle, test-suite]

### Return type

[**TestRunWithCustomFieldResource**](TestRunWithCustomFieldResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="deleteCommentById"></a>
# **deleteCommentById**
> Object deleteCommentById(projectId, idOrKey, commentId)

Deletes a Comment of a Test Run

To delete a Comment of a Test Run  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 7.5+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestRunApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestRunApi apiInstance = new TestRunApi();
Long projectId = 789L; // Long | ID of the project
String idOrKey = "idOrKey_example"; // String | PID or ID of the Test Run.
Long commentId = 789L; // Long | ID of the comment which you want to delete.
try {
    Object result = apiInstance.deleteCommentById(projectId, idOrKey, commentId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestRunApi#deleteCommentById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **idOrKey** | **String**| PID or ID of the Test Run. |
 **commentId** | **Long**| ID of the comment which you want to delete. |

### Return type

**Object**

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="deleteTestRunById"></a>
# **deleteTestRunById**
> Message deleteTestRunById(projectId, testRunId)

Deletes a Test Run

To delete a Test Run  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 6+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestRunApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestRunApi apiInstance = new TestRunApi();
Long projectId = 789L; // Long | ID of the project
Long testRunId = 789L; // Long | ID of the Test Run
try {
    Message result = apiInstance.deleteTestRunById(projectId, testRunId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestRunApi#deleteTestRunById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **testRunId** | **Long**| ID of the Test Run |

### Return type

[**Message**](Message.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getOf"></a>
# **getOf**
> TestRunListResource getOf(projectId, parentId, parentType, expand, includeToscaProperties, page, pageSize)

Gets multiple Test Runs

To retrieve all Test Runs under root or under a container (Release, Test Cycle or Test Suite)  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 6+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestRunApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestRunApi apiInstance = new TestRunApi();
Long projectId = 789L; // Long | ID of the project
Long parentId = 789L; // Long | ID of the container (Release, Test Cycle or Test Suite)  Input 0 (zero) to retrieve Test Runs directly under root
String parentType = "parentType_example"; // String | Type of the container. Valid values include <em>root</em>, <em>release</em>, <em>test-cycle</em> and <em>test-suite</em>
String expand = "expand_example"; // String | Specify <em>expand=descendants</em> to include all Test Runs which are directly or indirectly under the container
Boolean includeToscaProperties = true; // Boolean | By default, Tosca properties of Test Run (imported from Tosca) are not included in the response. Specify includeToscaProperties=true to include them.   <em>(tosca_guid, tosca_node_path, tosca_workspace_url, tosca_testevent_guid)</em>
Long page = 1L; // Long | By default the first page is returned but you can specify any page number to retrieve objects
Long pageSize = 100L; // Long | The result is paginated. By the default, the number of objects in each page is 100 if this is omitted. You can specify your custom number (up to 999) in this parameter
try {
    TestRunListResource result = apiInstance.getOf(projectId, parentId, parentType, expand, includeToscaProperties, page, pageSize);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestRunApi#getOf");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **parentId** | **Long**| ID of the container (Release, Test Cycle or Test Suite)  Input 0 (zero) to retrieve Test Runs directly under root | [optional]
 **parentType** | **String**| Type of the container. Valid values include &lt;em&gt;root&lt;/em&gt;, &lt;em&gt;release&lt;/em&gt;, &lt;em&gt;test-cycle&lt;/em&gt; and &lt;em&gt;test-suite&lt;/em&gt; | [optional] [enum: root, release, test-cycle, test-suite]
 **expand** | **String**| Specify &lt;em&gt;expand&#x3D;descendants&lt;/em&gt; to include all Test Runs which are directly or indirectly under the container | [optional]
 **includeToscaProperties** | **Boolean**| By default, Tosca properties of Test Run (imported from Tosca) are not included in the response. Specify includeToscaProperties&#x3D;true to include them.   &lt;em&gt;(tosca_guid, tosca_node_path, tosca_workspace_url, tosca_testevent_guid)&lt;/em&gt; | [optional]
 **page** | **Long**| By default the first page is returned but you can specify any page number to retrieve objects | [optional] [default to 1]
 **pageSize** | **Long**| The result is paginated. By the default, the number of objects in each page is 100 if this is omitted. You can specify your custom number (up to 999) in this parameter | [optional] [default to 100]

### Return type

[**TestRunListResource**](TestRunListResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getStatusValuable"></a>
# **getStatusValuable**
> List&lt;StatusResource&gt; getStatusValuable(projectId)

Gets Test Run statuses

Gets Test Run statuses

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestRunApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestRunApi apiInstance = new TestRunApi();
Long projectId = 789L; // Long | ID of the project
try {
    List<StatusResource> result = apiInstance.getStatusValuable(projectId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestRunApi#getStatusValuable");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |

### Return type

[**List&lt;StatusResource&gt;**](StatusResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getSubhierachy"></a>
# **getSubhierachy**
> AutomationObjectTree getSubhierachy(projectId, parentType, parentId)

Gets a Sub Hierarchy

To retrieve a Sub Hierarchy of a container (root, release, test-cycle)   &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 9.3.4+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestRunApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestRunApi apiInstance = new TestRunApi();
Long projectId = 789L; // Long | ID of the project
String parentType = "parentType_example"; // String | parentType
Long parentId = 789L; // Long | parentId
try {
    AutomationObjectTree result = apiInstance.getSubhierachy(projectId, parentType, parentId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestRunApi#getSubhierachy");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **parentType** | **String**| parentType | [optional]
 **parentId** | **Long**| parentId | [optional]

### Return type

[**AutomationObjectTree**](AutomationObjectTree.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getTestRunById"></a>
# **getTestRunById**
> TestRunWithCustomFieldResource getTestRunById(projectId, testRunId, expand, includeToscaProperties)

Gets a Test Run

To retrieve a Test Run  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 4+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestRunApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestRunApi apiInstance = new TestRunApi();
Long projectId = 789L; // Long | ID of the project
Long testRunId = 789L; // Long | ID of the Test Run.
String expand = "expand_example"; // String | Valid values include:   i)<em>testcase</em> - to expand the associated Test Case in the response;   ii) <em>testcase.teststep</em> - to expand the associated Test Case and its Test Steps in the response
Boolean includeToscaProperties = true; // Boolean | By default, Tosca properties of Test Run (imported from Tosca) are not included in the response. Specify includeToscaProperties=true to include them.   <em>(tosca_guid, tosca_node_path, tosca_workspace_url, tosca_testevent_guid)</em>
try {
    TestRunWithCustomFieldResource result = apiInstance.getTestRunById(projectId, testRunId, expand, includeToscaProperties);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestRunApi#getTestRunById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **testRunId** | **Long**| ID of the Test Run. |
 **expand** | **String**| Valid values include:   i)&lt;em&gt;testcase&lt;/em&gt; - to expand the associated Test Case in the response;   ii) &lt;em&gt;testcase.teststep&lt;/em&gt; - to expand the associated Test Case and its Test Steps in the response | [optional]
 **includeToscaProperties** | **Boolean**| By default, Tosca properties of Test Run (imported from Tosca) are not included in the response. Specify includeToscaProperties&#x3D;true to include them.   &lt;em&gt;(tosca_guid, tosca_node_path, tosca_workspace_url, tosca_testevent_guid)&lt;/em&gt; | [optional]

### Return type

[**TestRunWithCustomFieldResource**](TestRunWithCustomFieldResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getTestRunCommentById"></a>
# **getTestRunCommentById**
> CommentResource getTestRunCommentById(projectId, idOrKey, commentId)

Gets a Comment from a Test Run

To retrieve a specific Comment from a Test Run  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 7.5+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestRunApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestRunApi apiInstance = new TestRunApi();
Long projectId = 789L; // Long | ID of the project
String idOrKey = "idOrKey_example"; // String | PID or ID of the Test Run.
Long commentId = 789L; // Long | ID of the Comment
try {
    CommentResource result = apiInstance.getTestRunCommentById(projectId, idOrKey, commentId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestRunApi#getTestRunCommentById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **idOrKey** | **String**| PID or ID of the Test Run. |
 **commentId** | **Long**| ID of the Comment |

### Return type

[**CommentResource**](CommentResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getTestRunComments"></a>
# **getTestRunComments**
> PagedResourceCommentResource getTestRunComments(projectId, idOrKey)

Gets all Comments of a Test Run

To retrieve all Comments of a Test Run  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 7.5+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestRunApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestRunApi apiInstance = new TestRunApi();
Long projectId = 789L; // Long | ID of the project
String idOrKey = "idOrKey_example"; // String | PID or ID of the Test Run
try {
    PagedResourceCommentResource result = apiInstance.getTestRunComments(projectId, idOrKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestRunApi#getTestRunComments");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **idOrKey** | **String**| PID or ID of the Test Run |

### Return type

[**PagedResourceCommentResource**](PagedResourceCommentResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="updateCommentById"></a>
# **updateCommentById**
> CommentResource updateCommentById(projectId, idOrKey, commentId, body)

Updates a Comment of a Test Run

To update a Comment of a Test Run  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 7.5+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestRunApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestRunApi apiInstance = new TestRunApi();
Long projectId = 789L; // Long | ID of the project
String idOrKey = "idOrKey_example"; // String | PID or ID of the Test Run
Long commentId = 789L; // Long | ID of the comment which you want to update.
CommentResource body = new CommentResource(); // CommentResource | The Comment's updated content
try {
    CommentResource result = apiInstance.updateCommentById(projectId, idOrKey, commentId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestRunApi#updateCommentById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **idOrKey** | **String**| PID or ID of the Test Run |
 **commentId** | **Long**| ID of the comment which you want to update. |
 **body** | [**CommentResource**](CommentResource.md)| The Comment&#39;s updated content |

### Return type

[**CommentResource**](CommentResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="updateTestRunById"></a>
# **updateTestRunById**
> TestRunWithCustomFieldResource updateTestRunById(projectId, testRunId, body, parentId, parentType)

Updates a Test Run

To update a Test Run or move it to another container  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 6+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestRunApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestRunApi apiInstance = new TestRunApi();
Long projectId = 789L; // Long | ID of the project
Long testRunId = 789L; // Long | ID of the Test Run.
TestRunWithCustomFieldResource body = new TestRunWithCustomFieldResource(); // TestRunWithCustomFieldResource | The Test Run's updated properties
Long parentId = 789L; // Long | ID of the container (Release, Test Cycle or Test Suite)  Input 0 (zero) to move the test run to under root  <strong>Important:</strong> If you use the request parameters, the request body will be ignored. That means the test run is being moved but it will not be updated with the properties specify in the request body
String parentType = "parentType_example"; // String | Type of the container. Valid values include <em>root</em>, <em>release</em>, <em>test-cycle</em> and <em>test-suite</em>
try {
    TestRunWithCustomFieldResource result = apiInstance.updateTestRunById(projectId, testRunId, body, parentId, parentType);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestRunApi#updateTestRunById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **testRunId** | **Long**| ID of the Test Run. |
 **body** | [**TestRunWithCustomFieldResource**](TestRunWithCustomFieldResource.md)| The Test Run&#39;s updated properties |
 **parentId** | **Long**| ID of the container (Release, Test Cycle or Test Suite)  Input 0 (zero) to move the test run to under root  &lt;strong&gt;Important:&lt;/strong&gt; If you use the request parameters, the request body will be ignored. That means the test run is being moved but it will not be updated with the properties specify in the request body | [optional]
 **parentType** | **String**| Type of the container. Valid values include &lt;em&gt;root&lt;/em&gt;, &lt;em&gt;release&lt;/em&gt;, &lt;em&gt;test-cycle&lt;/em&gt; and &lt;em&gt;test-suite&lt;/em&gt; | [optional] [enum: root, release, test-cycle, test-suite]

### Return type

[**TestRunWithCustomFieldResource**](TestRunWithCustomFieldResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

