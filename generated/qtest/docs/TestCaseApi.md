# TestCaseApi

All URIs are relative to *https://apitryout.qtestnet.com/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addTestCaseComment**](TestCaseApi.md#addTestCaseComment) | **POST** /api/v3/projects/{projectId}/test-cases/{idOrKey}/comments | Adds a Comment to a Test Case
[**addTestStep**](TestCaseApi.md#addTestStep) | **POST** /api/v3/projects/{projectId}/test-cases/{testCaseId}/test-steps | Creates a Test Step
[**approveTestCase**](TestCaseApi.md#approveTestCase) | **PUT** /api/v3/projects/{projectId}/test-cases/{testCaseId}/approve | Approves a Test Case
[**approveTestCaseByVera**](TestCaseApi.md#approveTestCaseByVera) | **PUT** /api/v3/projects/{projectId}/test-cases/{testCaseId}/vera/approve | test-case.vera.approve
[**createTestCase**](TestCaseApi.md#createTestCase) | **POST** /api/v3/projects/{projectId}/test-cases | Creates a Test Case
[**deleteTestCase**](TestCaseApi.md#deleteTestCase) | **DELETE** /api/v3/projects/{projectId}/test-cases/{testCaseId} | Deletes a Test Case
[**deleteTestCaseComment**](TestCaseApi.md#deleteTestCaseComment) | **DELETE** /api/v3/projects/{projectId}/test-cases/{idOrKey}/comments/{commentId} | Deletes a Comment of a Test Case
[**deleteTestStep**](TestCaseApi.md#deleteTestStep) | **DELETE** /api/v3/projects/{projectId}/test-cases/{testCaseId}/test-steps/{stepId} | Deletes a Test Step
[**getTestCase**](TestCaseApi.md#getTestCase) | **GET** /api/v3/projects/{projectId}/test-cases/{testCaseIdOrPid} | Gets a Test Case
[**getTestCaseCommentById**](TestCaseApi.md#getTestCaseCommentById) | **GET** /api/v3/projects/{projectId}/test-cases/{idOrKey}/comments/{commentId} | Gets a Comment of a Test Case
[**getTestCaseComments**](TestCaseApi.md#getTestCaseComments) | **GET** /api/v3/projects/{projectId}/test-cases/{idOrKey}/comments | Gets all Comments of a Test Case
[**getTestCaseVersionById**](TestCaseApi.md#getTestCaseVersionById) | **GET** /api/v3/projects/{projectId}/test-cases/{testCaseId}/versions/{versionId} | Gets a version of a Test Case
[**getTestCases**](TestCaseApi.md#getTestCases) | **GET** /api/v3/projects/{projectId}/test-cases | Gets multiple Test Cases
[**getTestStep**](TestCaseApi.md#getTestStep) | **GET** /api/v3/projects/{projectId}/test-cases/{testCaseId}/test-steps/{stepId} | Gets a Test Step
[**getTestSteps**](TestCaseApi.md#getTestSteps) | **GET** /api/v3/projects/{projectId}/test-cases/{testCaseId}/test-steps | Gets Test Steps of a Test Case
[**getTestStepsByVersion**](TestCaseApi.md#getTestStepsByVersion) | **GET** /api/v3/projects/{projectId}/test-cases/{testCaseId}/versions/{versionId}/test-steps | Gets Test Steps of a Test Case version
[**getVersions**](TestCaseApi.md#getVersions) | **GET** /api/v3/projects/{projectId}/test-cases/{testCaseId}/versions | Gets all versions of a Test Case
[**updateMultipleTestCases**](TestCaseApi.md#updateMultipleTestCases) | **PUT** /api/v3/projects/{projectId}/test-cases/update/testcases | Updates multiple test cases
[**updateTestCase**](TestCaseApi.md#updateTestCase) | **PUT** /api/v3/projects/{projectId}/test-cases/{testCaseId} | Updates a Test Case
[**updateTestCaseComment**](TestCaseApi.md#updateTestCaseComment) | **PUT** /api/v3/projects/{projectId}/test-cases/{idOrKey}/comments/{commentId} | Updates a Comment of a Test Case
[**updateTestStep**](TestCaseApi.md#updateTestStep) | **PUT** /api/v3/projects/{projectId}/test-cases/{testCaseId}/test-steps/{stepId} | Update a Test Step


<a name="addTestCaseComment"></a>
# **addTestCaseComment**
> CommentResource addTestCaseComment(projectId, idOrKey, body)

Adds a Comment to a Test Case

To add a Comment to a Test Case  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 7.5+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestCaseApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestCaseApi apiInstance = new TestCaseApi();
Long projectId = 789L; // Long | ID of the project
String idOrKey = "idOrKey_example"; // String | PID or ID of the Test Case
CommentResource body = new CommentResource(); // CommentResource | The comment's properties and its content
try {
    CommentResource result = apiInstance.addTestCaseComment(projectId, idOrKey, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestCaseApi#addTestCaseComment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **idOrKey** | **String**| PID or ID of the Test Case |
 **body** | [**CommentResource**](CommentResource.md)| The comment&#39;s properties and its content |

### Return type

[**CommentResource**](CommentResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="addTestStep"></a>
# **addTestStep**
> TestStepResource addTestStep(projectId, testCaseId, body, showParamIdentifier)

Creates a Test Step

To add a Test Step to a Test Case&#39;s latest version  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 6+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestCaseApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestCaseApi apiInstance = new TestCaseApi();
Long projectId = 789L; // Long | ID of the project
Long testCaseId = 789L; // Long | ID of the Test Case
TestStepResource body = new TestStepResource(); // TestStepResource | Given resource to add a test step.  Support create test step with Parameters by inputting parameters identifier in teststep's <em>description</em> with sample like below. Parameters will be automatically added to current project.  &nbsp;&nbsp;&nbsp;&nbsp;    { &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;      \"description\": \"Description [~param1] with [~param2].\" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;      ... &nbsp;&nbsp;&nbsp;&nbsp;    {
Boolean showParamIdentifier = true; // Boolean | By default, Parameters in Test Steps are displayed in ID number mode (like \"<strong>[~123]</strong>\"). Input <strong><em>showParamIdentifier=true</em></strong> to change to Identifier text mode. Result should be like \"<strong>[~myIdentifier]</strong>\".
try {
    TestStepResource result = apiInstance.addTestStep(projectId, testCaseId, body, showParamIdentifier);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestCaseApi#addTestStep");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **testCaseId** | **Long**| ID of the Test Case |
 **body** | [**TestStepResource**](TestStepResource.md)| Given resource to add a test step.  Support create test step with Parameters by inputting parameters identifier in teststep&#39;s &lt;em&gt;description&lt;/em&gt; with sample like below. Parameters will be automatically added to current project.  &amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;    { &amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;      \&quot;description\&quot;: \&quot;Description [~param1] with [~param2].\&quot; &amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;      ... &amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;    { |
 **showParamIdentifier** | **Boolean**| By default, Parameters in Test Steps are displayed in ID number mode (like \&quot;&lt;strong&gt;[~123]&lt;/strong&gt;\&quot;). Input &lt;strong&gt;&lt;em&gt;showParamIdentifier&#x3D;true&lt;/em&gt;&lt;/strong&gt; to change to Identifier text mode. Result should be like \&quot;&lt;strong&gt;[~myIdentifier]&lt;/strong&gt;\&quot;. | [optional]

### Return type

[**TestStepResource**](TestStepResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="approveTestCase"></a>
# **approveTestCase**
> TestCaseWithCustomFieldResource approveTestCase(projectId, testCaseId)

Approves a Test Case

To approve a Test Case  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 7.4+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestCaseApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestCaseApi apiInstance = new TestCaseApi();
Long projectId = 789L; // Long | ID of the project
Long testCaseId = 789L; // Long | ID of the Test Case
try {
    TestCaseWithCustomFieldResource result = apiInstance.approveTestCase(projectId, testCaseId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestCaseApi#approveTestCase");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **testCaseId** | **Long**| ID of the Test Case |

### Return type

[**TestCaseWithCustomFieldResource**](TestCaseWithCustomFieldResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="approveTestCaseByVera"></a>
# **approveTestCaseByVera**
> TestCaseWithCustomFieldResource approveTestCaseByVera(projectId, testCaseId)

test-case.vera.approve



### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestCaseApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestCaseApi apiInstance = new TestCaseApi();
Long projectId = 789L; // Long | ID of the project
Long testCaseId = 789L; // Long | ID of the Test Case
try {
    TestCaseWithCustomFieldResource result = apiInstance.approveTestCaseByVera(projectId, testCaseId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestCaseApi#approveTestCaseByVera");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **testCaseId** | **Long**| ID of the Test Case |

### Return type

[**TestCaseWithCustomFieldResource**](TestCaseWithCustomFieldResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="createTestCase"></a>
# **createTestCase**
> TestCaseWithCustomFieldResource createTestCase(projectId, body, agentId, showParamIdentifier)

Creates a Test Case

To create a Test Case  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 4+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestCaseApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestCaseApi apiInstance = new TestCaseApi();
Long projectId = 789L; // Long | ID of the project
TestCaseWithCustomFieldResource body = new TestCaseWithCustomFieldResource(); // TestCaseWithCustomFieldResource | Test Case properties, Test Steps, Attachments and other information to create a Test Case.  If <em>parent_id</em> is omitted, the Test Case will be created under \"Created via API\" Module.  <em>tosca_guid</em>: GUID of Tosca test case. Use for creating Tosca Test Case.  <em>tosca_node_path</em>: Node Path of Tosca test case. Use for creating Tosca Test Case.  <em>tosca_guid</em> and <em>tosca_node_path</em> are optional but must be specified in pair  Support create test case with Parameters by inputting parameters identifier in teststep's <em>description</em> with sample like below. Parameters will be automatically added to current project.  &nbsp;&nbsp;&nbsp;&nbsp;    { &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;      \"description\": \"Description [~param1] with [~param2].\" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;      ... &nbsp;&nbsp;&nbsp;&nbsp;    {
String agentId = "agentId_example"; // String | 
Boolean showParamIdentifier = true; // Boolean | By default, Parameters in Test Steps are displayed in ID number mode (like \"<strong>[~123]</strong>\"). Input <strong><em>showParamIdentifier=true</em></strong> to change to Identifier text mode. Result should be like \"<strong>[~myIdentifier]</strong>\".
try {
    TestCaseWithCustomFieldResource result = apiInstance.createTestCase(projectId, body, agentId, showParamIdentifier);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestCaseApi#createTestCase");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **body** | [**TestCaseWithCustomFieldResource**](TestCaseWithCustomFieldResource.md)| Test Case properties, Test Steps, Attachments and other information to create a Test Case.  If &lt;em&gt;parent_id&lt;/em&gt; is omitted, the Test Case will be created under \&quot;Created via API\&quot; Module.  &lt;em&gt;tosca_guid&lt;/em&gt;: GUID of Tosca test case. Use for creating Tosca Test Case.  &lt;em&gt;tosca_node_path&lt;/em&gt;: Node Path of Tosca test case. Use for creating Tosca Test Case.  &lt;em&gt;tosca_guid&lt;/em&gt; and &lt;em&gt;tosca_node_path&lt;/em&gt; are optional but must be specified in pair  Support create test case with Parameters by inputting parameters identifier in teststep&#39;s &lt;em&gt;description&lt;/em&gt; with sample like below. Parameters will be automatically added to current project.  &amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;    { &amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;      \&quot;description\&quot;: \&quot;Description [~param1] with [~param2].\&quot; &amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;      ... &amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;    { |
 **agentId** | **String**|  | [optional]
 **showParamIdentifier** | **Boolean**| By default, Parameters in Test Steps are displayed in ID number mode (like \&quot;&lt;strong&gt;[~123]&lt;/strong&gt;\&quot;). Input &lt;strong&gt;&lt;em&gt;showParamIdentifier&#x3D;true&lt;/em&gt;&lt;/strong&gt; to change to Identifier text mode. Result should be like \&quot;&lt;strong&gt;[~myIdentifier]&lt;/strong&gt;\&quot;. | [optional]

### Return type

[**TestCaseWithCustomFieldResource**](TestCaseWithCustomFieldResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="deleteTestCase"></a>
# **deleteTestCase**
> deleteTestCase(projectId, testCaseId)

Deletes a Test Case

To delete Test Case  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 6+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestCaseApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestCaseApi apiInstance = new TestCaseApi();
Long projectId = 789L; // Long | ID of the project
Long testCaseId = 789L; // Long | ID of the Test Case which needs to be deleted.
try {
    apiInstance.deleteTestCase(projectId, testCaseId);
} catch (ApiException e) {
    System.err.println("Exception when calling TestCaseApi#deleteTestCase");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **testCaseId** | **Long**| ID of the Test Case which needs to be deleted. |

### Return type

null (empty response body)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="deleteTestCaseComment"></a>
# **deleteTestCaseComment**
> deleteTestCaseComment(projectId, idOrKey, commentId)

Deletes a Comment of a Test Case

To delete a comment of a Test Case  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 7.5+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestCaseApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestCaseApi apiInstance = new TestCaseApi();
Long projectId = 789L; // Long | ID of the project
String idOrKey = "idOrKey_example"; // String | PID or ID of the Test Case
Long commentId = 789L; // Long | ID of the comment.
try {
    apiInstance.deleteTestCaseComment(projectId, idOrKey, commentId);
} catch (ApiException e) {
    System.err.println("Exception when calling TestCaseApi#deleteTestCaseComment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **idOrKey** | **String**| PID or ID of the Test Case |
 **commentId** | **Long**| ID of the comment. |

### Return type

null (empty response body)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="deleteTestStep"></a>
# **deleteTestStep**
> deleteTestStep(projectId, testCaseId, stepId, updateVersion)

Deletes a Test Step

To delete a test step of a Test Case  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 6+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestCaseApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestCaseApi apiInstance = new TestCaseApi();
Long projectId = 789L; // Long | ID of the project
Long testCaseId = 789L; // Long | ID of the Test Case
Long stepId = 789L; // Long | ID of the Test Step
Boolean updateVersion = true; // Boolean | If you specify updateVersion=true, the test case version will be updated when the test step deleted.
try {
    apiInstance.deleteTestStep(projectId, testCaseId, stepId, updateVersion);
} catch (ApiException e) {
    System.err.println("Exception when calling TestCaseApi#deleteTestStep");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **testCaseId** | **Long**| ID of the Test Case |
 **stepId** | **Long**| ID of the Test Step |
 **updateVersion** | **Boolean**| If you specify updateVersion&#x3D;true, the test case version will be updated when the test step deleted. | [optional]

### Return type

null (empty response body)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getTestCase"></a>
# **getTestCase**
> TestCaseWithCustomFieldResource getTestCase(projectId, testCaseIdOrPid, versionId, expand, showParamIdentifier)

Gets a Test Case

To retrieve a Test Case  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 6+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestCaseApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestCaseApi apiInstance = new TestCaseApi();
Long projectId = 789L; // Long | ID of the project
String testCaseIdOrPid = "testCaseIdOrPid_example"; // String | ID of the Test Case Or Pid of the test case
Long versionId = 789L; // Long | ID of the Test Case version
String expand = "expand_example"; // String | By default, Test Steps are excluded from the response. Specify <em>expand=teststep</em> to include Test Steps
Boolean showParamIdentifier = true; // Boolean | By default, Parameters in Test Steps are displayed in ID number mode (like \"<strong>[~123]</strong>\"). Input <strong><em>showParamIdentifier=true</em></strong> to change to Identifier text mode. Result should be like \"<strong>[~myIdentifier]</strong>\".
try {
    TestCaseWithCustomFieldResource result = apiInstance.getTestCase(projectId, testCaseIdOrPid, versionId, expand, showParamIdentifier);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestCaseApi#getTestCase");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **testCaseIdOrPid** | **String**| ID of the Test Case Or Pid of the test case |
 **versionId** | **Long**| ID of the Test Case version | [optional]
 **expand** | **String**| By default, Test Steps are excluded from the response. Specify &lt;em&gt;expand&#x3D;teststep&lt;/em&gt; to include Test Steps | [optional]
 **showParamIdentifier** | **Boolean**| By default, Parameters in Test Steps are displayed in ID number mode (like \&quot;&lt;strong&gt;[~123]&lt;/strong&gt;\&quot;). Input &lt;strong&gt;&lt;em&gt;showParamIdentifier&#x3D;true&lt;/em&gt;&lt;/strong&gt; to change to Identifier text mode. Result should be like \&quot;&lt;strong&gt;[~myIdentifier]&lt;/strong&gt;\&quot;. | [optional]

### Return type

[**TestCaseWithCustomFieldResource**](TestCaseWithCustomFieldResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getTestCaseCommentById"></a>
# **getTestCaseCommentById**
> CommentResource getTestCaseCommentById(projectId, idOrKey, commentId)

Gets a Comment of a Test Case

To retrieve a comment of a Test Case  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 7.5+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestCaseApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestCaseApi apiInstance = new TestCaseApi();
Long projectId = 789L; // Long | ID of the project
String idOrKey = "idOrKey_example"; // String | PID or ID of the Test Case
Long commentId = 789L; // Long | ID of the comment.
try {
    CommentResource result = apiInstance.getTestCaseCommentById(projectId, idOrKey, commentId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestCaseApi#getTestCaseCommentById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **idOrKey** | **String**| PID or ID of the Test Case |
 **commentId** | **Long**| ID of the comment. |

### Return type

[**CommentResource**](CommentResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getTestCaseComments"></a>
# **getTestCaseComments**
> PagedResourceCommentResource getTestCaseComments(projectId, idOrKey, page, pageSize)

Gets all Comments of a Test Case

To retrieve all comments of a Test Case  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 7.5+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestCaseApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestCaseApi apiInstance = new TestCaseApi();
Long projectId = 789L; // Long | ID of the project
String idOrKey = "idOrKey_example"; // String | PID or ID of the Test Case whose comments you want to retrieve
Long page = 1L; // Long | By default the first page is returned but you can specify any page number to retrieve objects
Long pageSize = 100L; // Long | The result is paginated. By the default, the number of objects in each page is 100 if this is omitted. You can specify your custom number (up to 999) in this parameter
try {
    PagedResourceCommentResource result = apiInstance.getTestCaseComments(projectId, idOrKey, page, pageSize);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestCaseApi#getTestCaseComments");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **idOrKey** | **String**| PID or ID of the Test Case whose comments you want to retrieve |
 **page** | **Long**| By default the first page is returned but you can specify any page number to retrieve objects | [optional] [default to 1]
 **pageSize** | **Long**| The result is paginated. By the default, the number of objects in each page is 100 if this is omitted. You can specify your custom number (up to 999) in this parameter | [optional] [default to 100]

### Return type

[**PagedResourceCommentResource**](PagedResourceCommentResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getTestCaseVersionById"></a>
# **getTestCaseVersionById**
> TestCaseWithCustomFieldResource getTestCaseVersionById(projectId, testCaseId, versionId, showParamIdentifier)

Gets a version of a Test Case

To retrieve a specific version of a Test Case  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 4+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestCaseApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestCaseApi apiInstance = new TestCaseApi();
Long projectId = 789L; // Long | ID of the project
Long testCaseId = 789L; // Long | ID of the Test Case
Long versionId = 789L; // Long | ID of the Test Case version
Boolean showParamIdentifier = true; // Boolean | By default, Parameters in Test Steps are displayed in ID number mode (like \"<strong>[~123]</strong>\"). Input <strong><em>showParamIdentifier=true</em></strong> to change to Identifier text mode. Result should be like \"<strong>[~myIdentifier]</strong>\".
try {
    TestCaseWithCustomFieldResource result = apiInstance.getTestCaseVersionById(projectId, testCaseId, versionId, showParamIdentifier);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestCaseApi#getTestCaseVersionById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **testCaseId** | **Long**| ID of the Test Case |
 **versionId** | **Long**| ID of the Test Case version |
 **showParamIdentifier** | **Boolean**| By default, Parameters in Test Steps are displayed in ID number mode (like \&quot;&lt;strong&gt;[~123]&lt;/strong&gt;\&quot;). Input &lt;strong&gt;&lt;em&gt;showParamIdentifier&#x3D;true&lt;/em&gt;&lt;/strong&gt; to change to Identifier text mode. Result should be like \&quot;&lt;strong&gt;[~myIdentifier]&lt;/strong&gt;\&quot;. | [optional]

### Return type

[**TestCaseWithCustomFieldResource**](TestCaseWithCustomFieldResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getTestCases"></a>
# **getTestCases**
> List&lt;TestCaseWithCustomFieldResource&gt; getTestCases(projectId, page, size, parentId, expandProps, expandSteps, showParamIdentifier)

Gets multiple Test Cases

To retrieve all Test Cases or Test Cases which are located directly under a Module

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestCaseApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestCaseApi apiInstance = new TestCaseApi();
Long projectId = 789L; // Long | ID of the project
Long page = 1L; // Long | By default the first page is returned. However, you can specify any page number to retrieve test cases.
Integer size = 20; // Integer | The result is paginated. By the default, the number of requirements in each page is 20.  You can specify your custom number in this parameter.
Long parentId = 789L; // Long | Module ID
Boolean expandProps = true; // Boolean | By default, Test Case properties are included in the response. specify <em>expandProps=false</em> to exclude them
Boolean expandSteps = true; // Boolean | By default, Test Steps are excluded from the response body. Input <em>expandSteps=true</em> to include Test Steps
Boolean showParamIdentifier = true; // Boolean | By default, Parameters in Test Steps are displayed in ID number mode (like \"<strong>[~123]</strong>\"). Input <strong><em>showParamIdentifier=true</em></strong> to change to Identifier text mode. Result should be like \"<strong>[~myIdentifier]</strong>\".
try {
    List<TestCaseWithCustomFieldResource> result = apiInstance.getTestCases(projectId, page, size, parentId, expandProps, expandSteps, showParamIdentifier);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestCaseApi#getTestCases");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **page** | **Long**| By default the first page is returned. However, you can specify any page number to retrieve test cases. | [default to 1]
 **size** | **Integer**| The result is paginated. By the default, the number of requirements in each page is 20.  You can specify your custom number in this parameter. | [default to 20]
 **parentId** | **Long**| Module ID | [optional]
 **expandProps** | **Boolean**| By default, Test Case properties are included in the response. specify &lt;em&gt;expandProps&#x3D;false&lt;/em&gt; to exclude them | [optional]
 **expandSteps** | **Boolean**| By default, Test Steps are excluded from the response body. Input &lt;em&gt;expandSteps&#x3D;true&lt;/em&gt; to include Test Steps | [optional]
 **showParamIdentifier** | **Boolean**| By default, Parameters in Test Steps are displayed in ID number mode (like \&quot;&lt;strong&gt;[~123]&lt;/strong&gt;\&quot;). Input &lt;strong&gt;&lt;em&gt;showParamIdentifier&#x3D;true&lt;/em&gt;&lt;/strong&gt; to change to Identifier text mode. Result should be like \&quot;&lt;strong&gt;[~myIdentifier]&lt;/strong&gt;\&quot;. | [optional]

### Return type

[**List&lt;TestCaseWithCustomFieldResource&gt;**](TestCaseWithCustomFieldResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getTestStep"></a>
# **getTestStep**
> TestStepResource getTestStep(projectId, testCaseId, stepId, showParamIdentifier)

Gets a Test Step

To retrieve a Test Step of a Test Case&#39;s latest version  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 6+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestCaseApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestCaseApi apiInstance = new TestCaseApi();
Long projectId = 789L; // Long | ID of the project
Long testCaseId = 789L; // Long | ID of the Test Case
Long stepId = 789L; // Long | ID of the test step.
Boolean showParamIdentifier = true; // Boolean | By default, Parameters in Test Steps are displayed in ID number mode (like \"<strong>[~123]</strong>\"). Input <strong><em>showParamIdentifier=true</em></strong> to change to Identifier text mode. Result should be like \"<strong>[~myIdentifier]</strong>\".
try {
    TestStepResource result = apiInstance.getTestStep(projectId, testCaseId, stepId, showParamIdentifier);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestCaseApi#getTestStep");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **testCaseId** | **Long**| ID of the Test Case |
 **stepId** | **Long**| ID of the test step. |
 **showParamIdentifier** | **Boolean**| By default, Parameters in Test Steps are displayed in ID number mode (like \&quot;&lt;strong&gt;[~123]&lt;/strong&gt;\&quot;). Input &lt;strong&gt;&lt;em&gt;showParamIdentifier&#x3D;true&lt;/em&gt;&lt;/strong&gt; to change to Identifier text mode. Result should be like \&quot;&lt;strong&gt;[~myIdentifier]&lt;/strong&gt;\&quot;. | [optional]

### Return type

[**TestStepResource**](TestStepResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getTestSteps"></a>
# **getTestSteps**
> List&lt;TestStepResource&gt; getTestSteps(projectId, testCaseId, showParamIdentifier)

Gets Test Steps of a Test Case

To retrieve all Test Steps of a Test Case&#39;s latest version  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 6+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestCaseApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestCaseApi apiInstance = new TestCaseApi();
Long projectId = 789L; // Long | ID of the project
Long testCaseId = 789L; // Long | ID of the Test Case
Boolean showParamIdentifier = true; // Boolean | By default, Parameters in Test Steps are displayed in ID number mode (like \"<strong>[~123]</strong>\"). Input <strong><em>showParamIdentifier=true</em></strong> to change to Identifier text mode. Result should be like \"<strong>[~myIdentifier]</strong>\".
try {
    List<TestStepResource> result = apiInstance.getTestSteps(projectId, testCaseId, showParamIdentifier);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestCaseApi#getTestSteps");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **testCaseId** | **Long**| ID of the Test Case |
 **showParamIdentifier** | **Boolean**| By default, Parameters in Test Steps are displayed in ID number mode (like \&quot;&lt;strong&gt;[~123]&lt;/strong&gt;\&quot;). Input &lt;strong&gt;&lt;em&gt;showParamIdentifier&#x3D;true&lt;/em&gt;&lt;/strong&gt; to change to Identifier text mode. Result should be like \&quot;&lt;strong&gt;[~myIdentifier]&lt;/strong&gt;\&quot;. | [optional]

### Return type

[**List&lt;TestStepResource&gt;**](TestStepResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getTestStepsByVersion"></a>
# **getTestStepsByVersion**
> List&lt;TestStepResource&gt; getTestStepsByVersion(projectId, testCaseId, versionId, expand, showParamIdentifier)

Gets Test Steps of a Test Case version

To retrieve all Test Steps of a specific Test Case version

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestCaseApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestCaseApi apiInstance = new TestCaseApi();
Long projectId = 789L; // Long | ID of the project
Long testCaseId = 789L; // Long | ID of the Test Case
Long versionId = 789L; // Long | ID of the Test Case version
String expand = "expand_example"; // String | Specify <em>expand=calledteststep</em> to include Test Steps of the called Test Cases
Boolean showParamIdentifier = true; // Boolean | By default, Parameters in Test Steps are displayed in ID number mode (like \"<strong>[~123]</strong>\"). Input <strong><em>showParamIdentifier=true</em></strong> to change to Identifier text mode. Result should be like \"<strong>[~myIdentifier]</strong>\".
try {
    List<TestStepResource> result = apiInstance.getTestStepsByVersion(projectId, testCaseId, versionId, expand, showParamIdentifier);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestCaseApi#getTestStepsByVersion");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **testCaseId** | **Long**| ID of the Test Case |
 **versionId** | **Long**| ID of the Test Case version |
 **expand** | **String**| Specify &lt;em&gt;expand&#x3D;calledteststep&lt;/em&gt; to include Test Steps of the called Test Cases | [optional] [enum: calledteststep]
 **showParamIdentifier** | **Boolean**| By default, Parameters in Test Steps are displayed in ID number mode (like \&quot;&lt;strong&gt;[~123]&lt;/strong&gt;\&quot;). Input &lt;strong&gt;&lt;em&gt;showParamIdentifier&#x3D;true&lt;/em&gt;&lt;/strong&gt; to change to Identifier text mode. Result should be like \&quot;&lt;strong&gt;[~myIdentifier]&lt;/strong&gt;\&quot;. | [optional]

### Return type

[**List&lt;TestStepResource&gt;**](TestStepResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getVersions"></a>
# **getVersions**
> List&lt;TestCaseWithCustomFieldResource&gt; getVersions(projectId, testCaseId, showParamIdentifier)

Gets all versions of a Test Case

To retrieve all versions of a Test Case  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 7.4+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestCaseApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestCaseApi apiInstance = new TestCaseApi();
Long projectId = 789L; // Long | ID of the project
Long testCaseId = 789L; // Long | ID of the test case
Boolean showParamIdentifier = true; // Boolean | By default, Parameters in Test Steps are displayed in ID number mode (like \"<strong>[~123]</strong>\"). Input <strong><em>showParamIdentifier=true</em></strong> to change to Identifier text mode. Result should be like \"<strong>[~myIdentifier]</strong>\".
try {
    List<TestCaseWithCustomFieldResource> result = apiInstance.getVersions(projectId, testCaseId, showParamIdentifier);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestCaseApi#getVersions");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **testCaseId** | **Long**| ID of the test case |
 **showParamIdentifier** | **Boolean**| By default, Parameters in Test Steps are displayed in ID number mode (like \&quot;&lt;strong&gt;[~123]&lt;/strong&gt;\&quot;). Input &lt;strong&gt;&lt;em&gt;showParamIdentifier&#x3D;true&lt;/em&gt;&lt;/strong&gt; to change to Identifier text mode. Result should be like \&quot;&lt;strong&gt;[~myIdentifier]&lt;/strong&gt;\&quot;. | [optional]

### Return type

[**List&lt;TestCaseWithCustomFieldResource&gt;**](TestCaseWithCustomFieldResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="updateMultipleTestCases"></a>
# **updateMultipleTestCases**
> TestCaseWithCustomFieldResource updateMultipleTestCases(projectId, body, showParamIdentifier)

Updates multiple test cases

To update multiple Test Cases  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 6+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestCaseApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestCaseApi apiInstance = new TestCaseApi();
Long projectId = 789L; // Long | ID of the project
Object body = null; // Object | 
Boolean showParamIdentifier = true; // Boolean | showParamIdentifier
try {
    TestCaseWithCustomFieldResource result = apiInstance.updateMultipleTestCases(projectId, body, showParamIdentifier);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestCaseApi#updateMultipleTestCases");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **body** | **Object**|  |
 **showParamIdentifier** | **Boolean**| showParamIdentifier | [optional]

### Return type

[**TestCaseWithCustomFieldResource**](TestCaseWithCustomFieldResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="updateTestCase"></a>
# **updateTestCase**
> TestCaseWithCustomFieldResource updateTestCase(projectId, testCaseId, body, showParamIdentifier)

Updates a Test Case

To update a Test Case  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 6+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestCaseApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestCaseApi apiInstance = new TestCaseApi();
Long projectId = 789L; // Long | ID of the project
Long testCaseId = 789L; // Long | ID of the Test Case which needs to be updated.
TestCaseWithCustomFieldResource body = new TestCaseWithCustomFieldResource(); // TestCaseWithCustomFieldResource | Test Case properties, Test Steps and other information to update the Test Case.  Support update test case with Parameters by inputting parameters identifier in teststep's <em>description</em> with sample like below. Parameters will be automatically added to current project.  &nbsp;&nbsp;&nbsp;&nbsp;    { &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;      \"description\": \"Description [~param1] with [~param2].\" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;      ... &nbsp;&nbsp;&nbsp;&nbsp;    {
Boolean showParamIdentifier = true; // Boolean | By default, Parameters in Test Steps are displayed in ID number mode (like \"<strong>[~123]</strong>\"). Input <strong><em>showParamIdentifier=true</em></strong> to change to Identifier text mode. Result should be like \"<strong>[~myIdentifier]</strong>\".
try {
    TestCaseWithCustomFieldResource result = apiInstance.updateTestCase(projectId, testCaseId, body, showParamIdentifier);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestCaseApi#updateTestCase");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **testCaseId** | **Long**| ID of the Test Case which needs to be updated. |
 **body** | [**TestCaseWithCustomFieldResource**](TestCaseWithCustomFieldResource.md)| Test Case properties, Test Steps and other information to update the Test Case.  Support update test case with Parameters by inputting parameters identifier in teststep&#39;s &lt;em&gt;description&lt;/em&gt; with sample like below. Parameters will be automatically added to current project.  &amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;    { &amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;      \&quot;description\&quot;: \&quot;Description [~param1] with [~param2].\&quot; &amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;      ... &amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;    { |
 **showParamIdentifier** | **Boolean**| By default, Parameters in Test Steps are displayed in ID number mode (like \&quot;&lt;strong&gt;[~123]&lt;/strong&gt;\&quot;). Input &lt;strong&gt;&lt;em&gt;showParamIdentifier&#x3D;true&lt;/em&gt;&lt;/strong&gt; to change to Identifier text mode. Result should be like \&quot;&lt;strong&gt;[~myIdentifier]&lt;/strong&gt;\&quot;. | [optional]

### Return type

[**TestCaseWithCustomFieldResource**](TestCaseWithCustomFieldResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="updateTestCaseComment"></a>
# **updateTestCaseComment**
> CommentResource updateTestCaseComment(projectId, idOrKey, commentId, body)

Updates a Comment of a Test Case

To modify a comment of a Test Case  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 7.5+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestCaseApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestCaseApi apiInstance = new TestCaseApi();
Long projectId = 789L; // Long | ID of the project
String idOrKey = "idOrKey_example"; // String | PID or ID of the Test Case
Long commentId = 789L; // Long | ID of the comment.
CommentResource body = new CommentResource(); // CommentResource | The comment's updated content
try {
    CommentResource result = apiInstance.updateTestCaseComment(projectId, idOrKey, commentId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestCaseApi#updateTestCaseComment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **idOrKey** | **String**| PID or ID of the Test Case |
 **commentId** | **Long**| ID of the comment. |
 **body** | [**CommentResource**](CommentResource.md)| The comment&#39;s updated content |

### Return type

[**CommentResource**](CommentResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="updateTestStep"></a>
# **updateTestStep**
> TestStepResource updateTestStep(projectId, testCaseId, stepId, body, showParamIdentifier)

Update a Test Step

To update a Test Step of a Test Case&#39;s latest version  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 6+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestCaseApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestCaseApi apiInstance = new TestCaseApi();
Long projectId = 789L; // Long | ID of the project
Long testCaseId = 789L; // Long | ID of the Test Case
Long stepId = 789L; // Long | ID of the Test Step
TestStepResource body = new TestStepResource(); // TestStepResource | Updated content of the Test Step  Support update test step with Parameters by inputting parameters identifier in teststep's <em>description</em> with sample like below. Parameters will be automatically added to current project.  &nbsp;&nbsp;&nbsp;&nbsp;    { &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;      \"description\": \"Description [~param1] with [~param2].\" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;      ... &nbsp;&nbsp;&nbsp;&nbsp;    {
Boolean showParamIdentifier = true; // Boolean | By default, Parameters in Test Steps are displayed in ID number mode (like \"<strong>[~123]</strong>\"). Input <strong><em>showParamIdentifier=true</em></strong> to change to Identifier text mode. Result should be like \"<strong>[~myIdentifier]</strong>\".
try {
    TestStepResource result = apiInstance.updateTestStep(projectId, testCaseId, stepId, body, showParamIdentifier);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestCaseApi#updateTestStep");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **testCaseId** | **Long**| ID of the Test Case |
 **stepId** | **Long**| ID of the Test Step |
 **body** | [**TestStepResource**](TestStepResource.md)| Updated content of the Test Step  Support update test step with Parameters by inputting parameters identifier in teststep&#39;s &lt;em&gt;description&lt;/em&gt; with sample like below. Parameters will be automatically added to current project.  &amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;    { &amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;      \&quot;description\&quot;: \&quot;Description [~param1] with [~param2].\&quot; &amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;      ... &amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;    { |
 **showParamIdentifier** | **Boolean**| By default, Parameters in Test Steps are displayed in ID number mode (like \&quot;&lt;strong&gt;[~123]&lt;/strong&gt;\&quot;). Input &lt;strong&gt;&lt;em&gt;showParamIdentifier&#x3D;true&lt;/em&gt;&lt;/strong&gt; to change to Identifier text mode. Result should be like \&quot;&lt;strong&gt;[~myIdentifier]&lt;/strong&gt;\&quot;. | [optional]

### Return type

[**TestStepResource**](TestStepResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

