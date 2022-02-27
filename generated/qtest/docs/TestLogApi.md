# TestLogApi

All URIs are relative to *https://apitryout.qtestnet.com/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getLastRunLog**](TestLogApi.md#getLastRunLog) | **GET** /api/v3/projects/{projectId}/test-runs/{testRunId}/test-logs/last-run | Gets the latest Test Log of a Test Run
[**getTestLog**](TestLogApi.md#getTestLog) | **GET** /api/v3/projects/{projectId}/test-runs/{testRunId}/test-logs/{id} | Gets a Test Log of a Test Run
[**getTestLogsList**](TestLogApi.md#getTestLogsList) | **GET** /api/v3/projects/{projectId}/test-runs/{testRunId}/test-logs | Gets all Test Logs of a Test Run
[**modifyAutomationLog**](TestLogApi.md#modifyAutomationLog) | **PUT** /api/v3/projects/{projectId}/test-runs/{testRunId}/auto-test-logs/{id} | Modify an Automation Test Log
[**modifyTestLog**](TestLogApi.md#modifyTestLog) | **PUT** /api/v3/projects/{projectId}/test-runs/{testRunId}/test-logs/{id} | Modify a Manual Test Log
[**submitAutomationLog**](TestLogApi.md#submitAutomationLog) | **POST** /api/v3/projects/{projectId}/test-runs/{testRunId}/auto-test-logs | Submits an Automation Test Log
[**submitAutomationTestLogs**](TestLogApi.md#submitAutomationTestLogs) | **POST** /api/v3.1/projects/{projectId}/test-runs/{testRunId}/auto-test-logs | Submits multiple test results
[**submitAutomationTestLogsWithTreeStructure**](TestLogApi.md#submitAutomationTestLogsWithTreeStructure) | **POST** /api/v3/projects/{projectId}/auto-test-logs | Submits multiple test results and specifies Test Design and Test Execution tree structures
[**submitTestLog**](TestLogApi.md#submitTestLog) | **POST** /api/v3/projects/{projectId}/test-runs/{testRunId}/test-logs | Submits a Manual Test Log
[**track**](TestLogApi.md#track) | **GET** /api/v3/projects/queue-processing/{id} | Gets a Batch Test Log Submission job&#39;s state


<a name="getLastRunLog"></a>
# **getLastRunLog**
> TestLogResource getLastRunLog(projectId, testRunId, expand)

Gets the latest Test Log of a Test Run

To retrieve a Test Run&#39;s latest test result  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 4+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestLogApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestLogApi apiInstance = new TestLogApi();
Long projectId = 789L; // Long | ID of the project
Long testRunId = 789L; // Long | ID of the Test Run
String expand = "expand_example"; // String | Valid values include:   i)<em>testcase</em> - to expand the associated Test Case and its Test Steps in the response;   ii) <em>teststeplog.teststep</em> - to expand results of each Test Steps in the response
try {
    TestLogResource result = apiInstance.getLastRunLog(projectId, testRunId, expand);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestLogApi#getLastRunLog");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **testRunId** | **Long**| ID of the Test Run |
 **expand** | **String**| Valid values include:   i)&lt;em&gt;testcase&lt;/em&gt; - to expand the associated Test Case and its Test Steps in the response;   ii) &lt;em&gt;teststeplog.teststep&lt;/em&gt; - to expand results of each Test Steps in the response | [optional]

### Return type

[**TestLogResource**](TestLogResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getTestLog"></a>
# **getTestLog**
> TestLogResource getTestLog(projectId, id, testRunId)

Gets a Test Log of a Test Run

To retrieve a specific Test Log of a Test Run

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestLogApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestLogApi apiInstance = new TestLogApi();
Long projectId = 789L; // Long | ID of the project
Long id = 789L; // Long | ID of the Test Log
Long testRunId = 789L; // Long | ID of the Test Run
try {
    TestLogResource result = apiInstance.getTestLog(projectId, id, testRunId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestLogApi#getTestLog");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **id** | **Long**| ID of the Test Log |
 **testRunId** | **Long**| ID of the Test Run |

### Return type

[**TestLogResource**](TestLogResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getTestLogsList"></a>
# **getTestLogsList**
> TestLogListResource getTestLogsList(projectId, testRunId, pageSize, page)

Gets all Test Logs of a Test Run

To retrieve all Test Logs of a Test Run  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 7.6

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestLogApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestLogApi apiInstance = new TestLogApi();
Long projectId = 789L; // Long | ID of the project
Long testRunId = 789L; // Long | ID of the Test Run
Long pageSize = 100L; // Long | The result is paginated. By the default, the number of objects in each page is 100 if this is omitted. You can specify your custom number (up to 999) in this parameter
Long page = 1L; // Long | By default the first page is returned but you can specify any page number to retrieve objects
try {
    TestLogListResource result = apiInstance.getTestLogsList(projectId, testRunId, pageSize, page);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestLogApi#getTestLogsList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **testRunId** | **Long**| ID of the Test Run |
 **pageSize** | **Long**| The result is paginated. By the default, the number of objects in each page is 100 if this is omitted. You can specify your custom number (up to 999) in this parameter | [optional] [default to 100]
 **page** | **Long**| By default the first page is returned but you can specify any page number to retrieve objects | [optional] [default to 1]

### Return type

[**TestLogListResource**](TestLogListResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="modifyAutomationLog"></a>
# **modifyAutomationLog**
> Object modifyAutomationLog(projectId, body, testRunId, id, encodeNote)

Modify an Automation Test Log

To modify test result of a &lt;em&gt;automation&lt;/em&gt; Test Run  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 9.1.5+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestLogApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestLogApi apiInstance = new TestLogApi();
Long projectId = 789L; // Long | ID of the project
AutomationTestLog body = new AutomationTestLog(); // AutomationTestLog | <em>status (required):</em> automation status values which are mapped in qTest Manager's Automation Settings  <em>exe_start_date (required):</em> the execution's starting time  <em>exe_end_date (required):</em> the execution's ending time  <em>note:</em> execution note  <em>properties:</em> array of fields and values of the Test Log that need to be updated  <em>test_step_logs:</em> a JSONArray of TestStepLog objects  <strong>NOTE:</strong> <ul><li>You can only modify test logs which were submitted by you. The project admin can modify any test logs within his project</li><li>Test Step order is required in the test_step_logs array. You cannot specify a different order from the original submitted test log</li><li>You cannot modify Test Step Description and Expected Result</li><li>You cannot modify the following fields: Test Case Version, Automation Content, CI Tools, Build Number and Build URL</li></ul>
Long testRunId = 789L; // Long | ID of the Test Run
Long id = 789L; // Long | id
Boolean encodeNote = true; // Boolean | encodeNote
try {
    Object result = apiInstance.modifyAutomationLog(projectId, body, testRunId, id, encodeNote);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestLogApi#modifyAutomationLog");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **body** | [**AutomationTestLog**](AutomationTestLog.md)| &lt;em&gt;status (required):&lt;/em&gt; automation status values which are mapped in qTest Manager&#39;s Automation Settings  &lt;em&gt;exe_start_date (required):&lt;/em&gt; the execution&#39;s starting time  &lt;em&gt;exe_end_date (required):&lt;/em&gt; the execution&#39;s ending time  &lt;em&gt;note:&lt;/em&gt; execution note  &lt;em&gt;properties:&lt;/em&gt; array of fields and values of the Test Log that need to be updated  &lt;em&gt;test_step_logs:&lt;/em&gt; a JSONArray of TestStepLog objects  &lt;strong&gt;NOTE:&lt;/strong&gt; &lt;ul&gt;&lt;li&gt;You can only modify test logs which were submitted by you. The project admin can modify any test logs within his project&lt;/li&gt;&lt;li&gt;Test Step order is required in the test_step_logs array. You cannot specify a different order from the original submitted test log&lt;/li&gt;&lt;li&gt;You cannot modify Test Step Description and Expected Result&lt;/li&gt;&lt;li&gt;You cannot modify the following fields: Test Case Version, Automation Content, CI Tools, Build Number and Build URL&lt;/li&gt;&lt;/ul&gt; |
 **testRunId** | **Long**| ID of the Test Run |
 **id** | **Long**| id |
 **encodeNote** | **Boolean**| encodeNote | [optional]

### Return type

**Object**

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="modifyTestLog"></a>
# **modifyTestLog**
> TestLogResource modifyTestLog(projectId, body, testRunId, id)

Modify a Manual Test Log

To modify test result of an &lt;em&gt;manual&lt;/em&gt; Test Run  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 9.1.5+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestLogApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestLogApi apiInstance = new TestLogApi();
Long projectId = 789L; // Long | ID of the project
TestLogResource body = new TestLogResource(); // TestLogResource | <em>status (required):</em> Status of the Test Log as defined in the project�??s Field Settings  <em>exe_start_date (required):</em> the execution's starting time  <em>exe_end_date (required):</em> the execution's ending time  <em>note:</em> execution note  <em>properties:</em> array of fields and values of the Test Log that need to be updated  <em>test_step_logs:</em> a JSONArray of TestStepLog objects  <strong>NOTE:</strong> <ul><li>You can only modify test logs which were submitted by you. The project admin can modify any test logs within his project</li><li>Test Step order is required in the test_step_logs array. You cannot specify a different order from the original submitted test log</li><li>You cannot modify Test Step Description and Expected Result</li><li>You cannot modify the following fields: Test Case Version, CI Tools, Build Number and Build URL</li></ul>
Long testRunId = 789L; // Long | ID of the Test Run
Long id = 789L; // Long | id
try {
    TestLogResource result = apiInstance.modifyTestLog(projectId, body, testRunId, id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestLogApi#modifyTestLog");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **body** | [**TestLogResource**](TestLogResource.md)| &lt;em&gt;status (required):&lt;/em&gt; Status of the Test Log as defined in the project�??s Field Settings  &lt;em&gt;exe_start_date (required):&lt;/em&gt; the execution&#39;s starting time  &lt;em&gt;exe_end_date (required):&lt;/em&gt; the execution&#39;s ending time  &lt;em&gt;note:&lt;/em&gt; execution note  &lt;em&gt;properties:&lt;/em&gt; array of fields and values of the Test Log that need to be updated  &lt;em&gt;test_step_logs:&lt;/em&gt; a JSONArray of TestStepLog objects  &lt;strong&gt;NOTE:&lt;/strong&gt; &lt;ul&gt;&lt;li&gt;You can only modify test logs which were submitted by you. The project admin can modify any test logs within his project&lt;/li&gt;&lt;li&gt;Test Step order is required in the test_step_logs array. You cannot specify a different order from the original submitted test log&lt;/li&gt;&lt;li&gt;You cannot modify Test Step Description and Expected Result&lt;/li&gt;&lt;li&gt;You cannot modify the following fields: Test Case Version, CI Tools, Build Number and Build URL&lt;/li&gt;&lt;/ul&gt; |
 **testRunId** | **Long**| ID of the Test Run |
 **id** | **Long**| id |

### Return type

[**TestLogResource**](TestLogResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="submitAutomationLog"></a>
# **submitAutomationLog**
> AutomationTestLogResourceResponse submitAutomationLog(projectId, body, testRunId, suitePerDay, suiteDate, encodeNote, forceUpdateVersion, agentId, userId)

Submits an Automation Test Log

To submit test result of an Automation Test Run  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 4+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestLogApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestLogApi apiInstance = new TestLogApi();
Long projectId = 789L; // Long | ID of the project
AutomationTestLogResource body = new AutomationTestLogResource(); // AutomationTestLogResource | <em>status (required):</em> automation status values which are mapped in qTest Manager's Automation Settings  <em>exe_start_date (required):</em> the execution's starting time  <em>exe_end_date (required)</em> the execution's ending time  <em>name (required)</em> name of the Test Run or Test Case  <em>automation_content (required):</em> a string that uniquely identifies an Automation Test Case  <em>attachments:</em> a JSONArray of Attachment objects  <em>note:</em> execution note  <em>test_case_version_id:</em> ID of the associated Test Case's version  <em>test_step_logs:</em> a JSONArray of TestStepLog objects  <em>tosca_guid</em>: GUID of Tosca test case. Use for creating Tosca Test Case  <em>tosca_node_path</em>: Node Path of Tosca test case. Use for creating Tosca Test Case  <em>tosca_guid</em> and <em>tosca_node_path</em> are optional but must be specified in pair
Long testRunId = 789L; // Long | ID of the Test Run  1/ If it is greater than 0 (zero), test result will be submitted to the specific Test Run  If it is 0 (zero), test result will be submitted to a new Test Run
String suitePerDay = "suitePerDay_example"; // String | <em>suitePerDay=true</em> - the newly created Test Run will be located under a Test Suite named under the execution date specified in parameter <em>suiteDate</em>, eg: <em>Automation 2014-12-09</em>  <em>suitePerDay=false</em> - the newly created Test Run will be located under <em>Automation Test Suite</em>  <strong>IMPORTANT:</strong> In case you update an existing Test Run, its Test Suite remains unchanged
String suiteDate = "suiteDate_example"; // String | It is required if <em>suitePerDay</em> is true. Its format is <em>\"yyyymmdd\"</em>.   The newly created Test Run will be located under a Test Suite named \"Automation yyyy-mm-dd\", eg: Automation 2014-12-09
Boolean encodeNote = true; // Boolean | Specify if the Test Log's Notes are in HTML format  <em>encodeNote=true</em> - default value. Notes are not in HTML format  <em>encodeNote=false:</em> Notes are in HTML format
Boolean forceUpdateVersion = true; // Boolean | 
String agentId = "agentId_example"; // String | 
String userId = "userId_example"; // String | 
try {
    AutomationTestLogResourceResponse result = apiInstance.submitAutomationLog(projectId, body, testRunId, suitePerDay, suiteDate, encodeNote, forceUpdateVersion, agentId, userId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestLogApi#submitAutomationLog");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **body** | [**AutomationTestLogResource**](AutomationTestLogResource.md)| &lt;em&gt;status (required):&lt;/em&gt; automation status values which are mapped in qTest Manager&#39;s Automation Settings  &lt;em&gt;exe_start_date (required):&lt;/em&gt; the execution&#39;s starting time  &lt;em&gt;exe_end_date (required)&lt;/em&gt; the execution&#39;s ending time  &lt;em&gt;name (required)&lt;/em&gt; name of the Test Run or Test Case  &lt;em&gt;automation_content (required):&lt;/em&gt; a string that uniquely identifies an Automation Test Case  &lt;em&gt;attachments:&lt;/em&gt; a JSONArray of Attachment objects  &lt;em&gt;note:&lt;/em&gt; execution note  &lt;em&gt;test_case_version_id:&lt;/em&gt; ID of the associated Test Case&#39;s version  &lt;em&gt;test_step_logs:&lt;/em&gt; a JSONArray of TestStepLog objects  &lt;em&gt;tosca_guid&lt;/em&gt;: GUID of Tosca test case. Use for creating Tosca Test Case  &lt;em&gt;tosca_node_path&lt;/em&gt;: Node Path of Tosca test case. Use for creating Tosca Test Case  &lt;em&gt;tosca_guid&lt;/em&gt; and &lt;em&gt;tosca_node_path&lt;/em&gt; are optional but must be specified in pair |
 **testRunId** | **Long**| ID of the Test Run  1/ If it is greater than 0 (zero), test result will be submitted to the specific Test Run  If it is 0 (zero), test result will be submitted to a new Test Run |
 **suitePerDay** | **String**| &lt;em&gt;suitePerDay&#x3D;true&lt;/em&gt; - the newly created Test Run will be located under a Test Suite named under the execution date specified in parameter &lt;em&gt;suiteDate&lt;/em&gt;, eg: &lt;em&gt;Automation 2014-12-09&lt;/em&gt;  &lt;em&gt;suitePerDay&#x3D;false&lt;/em&gt; - the newly created Test Run will be located under &lt;em&gt;Automation Test Suite&lt;/em&gt;  &lt;strong&gt;IMPORTANT:&lt;/strong&gt; In case you update an existing Test Run, its Test Suite remains unchanged | [optional]
 **suiteDate** | **String**| It is required if &lt;em&gt;suitePerDay&lt;/em&gt; is true. Its format is &lt;em&gt;\&quot;yyyymmdd\&quot;&lt;/em&gt;.   The newly created Test Run will be located under a Test Suite named \&quot;Automation yyyy-mm-dd\&quot;, eg: Automation 2014-12-09 | [optional]
 **encodeNote** | **Boolean**| Specify if the Test Log&#39;s Notes are in HTML format  &lt;em&gt;encodeNote&#x3D;true&lt;/em&gt; - default value. Notes are not in HTML format  &lt;em&gt;encodeNote&#x3D;false:&lt;/em&gt; Notes are in HTML format | [optional]
 **forceUpdateVersion** | **Boolean**|  | [optional]
 **agentId** | **String**|  | [optional]
 **userId** | **String**|  | [optional]

### Return type

[**AutomationTestLogResourceResponse**](AutomationTestLogResourceResponse.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="submitAutomationTestLogs"></a>
# **submitAutomationTestLogs**
> QueueProcessingResponse submitAutomationTestLogs(projectId, body, type, testRunId, escapeXml, userId)

Submits multiple test results

To submit Automation Test Logs of multiple Test Runs  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 8.0.2+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestLogApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestLogApi apiInstance = new TestLogApi();
Long projectId = 789L; // Long | ID of the project
AutomationRequest body = new AutomationRequest(); // AutomationRequest | <em>test_suite:</em> ID of the Test Suite where the submitted Test Runs will be located  <em>parent_module:</em> In case there has been no Test Case associated with the submitted Test Run, a new automation Test Case will be created. The new Test Cases are located under a module named <em>Automation</em>. If you specify an ID for parent_module, the <em>Automation</em> module will be located under the specified module. Otherwise, the <em>Automation</em> module is located directly under root  <em>execution_date (required):</em> Execution date in <em>YYYY-mm-dd</em> format  <em>test_logs (required):</em> The array of TestLog objects. The below are TestLog attributes  <em>status (required):</em> The automation result values that were mapped with Test Run Result in qTest automation settings  <em>exe_start_date (required):</em> Execution start time  <em>exe_end_date (required):</em> Execution end time  <em>name (required):</em> Test Run name  <em>automation_content (required):</em> An XML formatted string that contains the class test/ group test/ package test  <em>attachments:</em> An array of the Attachment objects  <em>note:</em> Test Log note  <em>test_step_logs:</em> An of TestStepLog objects. You can specify Test Steps' order in the requrest. It must be continous series of numbers, starting from zero, or it will throw an error. The order will be used when the Test Case is created or updated in qTest. If the order is omitted, Test Steps will be alphabetically sorted when creating or updating Test Case  <em>tosca_guid</em>: GUID of Tosca test case. Use for creating Tosca Test Case  <em>tosca_node_path</em>: Node Path of Tosca test case. Use for creating Tosca Test Case  <em>tosca_guid</em> and <em>tosca_node_path</em> are optional but must be specified in pair
String type = "type_example"; // String | Always input <em>automation</em> for this parameter
Long testRunId = 789L; // Long | This should always be <strong>0 (zero)</strong> or else it will throw an exception
Boolean escapeXml = false; // Boolean | <em>escapeXml=true</em> - default value. &gt and &lt in <em>Automation Content</em> field are encoded  <em>escapeXml=false</em> - the Automation Content field is not encoded
String userId = "userId_example"; // String | 
try {
    QueueProcessingResponse result = apiInstance.submitAutomationTestLogs(projectId, body, type, testRunId, escapeXml, userId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestLogApi#submitAutomationTestLogs");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **body** | [**AutomationRequest**](AutomationRequest.md)| &lt;em&gt;test_suite:&lt;/em&gt; ID of the Test Suite where the submitted Test Runs will be located  &lt;em&gt;parent_module:&lt;/em&gt; In case there has been no Test Case associated with the submitted Test Run, a new automation Test Case will be created. The new Test Cases are located under a module named &lt;em&gt;Automation&lt;/em&gt;. If you specify an ID for parent_module, the &lt;em&gt;Automation&lt;/em&gt; module will be located under the specified module. Otherwise, the &lt;em&gt;Automation&lt;/em&gt; module is located directly under root  &lt;em&gt;execution_date (required):&lt;/em&gt; Execution date in &lt;em&gt;YYYY-mm-dd&lt;/em&gt; format  &lt;em&gt;test_logs (required):&lt;/em&gt; The array of TestLog objects. The below are TestLog attributes  &lt;em&gt;status (required):&lt;/em&gt; The automation result values that were mapped with Test Run Result in qTest automation settings  &lt;em&gt;exe_start_date (required):&lt;/em&gt; Execution start time  &lt;em&gt;exe_end_date (required):&lt;/em&gt; Execution end time  &lt;em&gt;name (required):&lt;/em&gt; Test Run name  &lt;em&gt;automation_content (required):&lt;/em&gt; An XML formatted string that contains the class test/ group test/ package test  &lt;em&gt;attachments:&lt;/em&gt; An array of the Attachment objects  &lt;em&gt;note:&lt;/em&gt; Test Log note  &lt;em&gt;test_step_logs:&lt;/em&gt; An of TestStepLog objects. You can specify Test Steps&#39; order in the requrest. It must be continous series of numbers, starting from zero, or it will throw an error. The order will be used when the Test Case is created or updated in qTest. If the order is omitted, Test Steps will be alphabetically sorted when creating or updating Test Case  &lt;em&gt;tosca_guid&lt;/em&gt;: GUID of Tosca test case. Use for creating Tosca Test Case  &lt;em&gt;tosca_node_path&lt;/em&gt;: Node Path of Tosca test case. Use for creating Tosca Test Case  &lt;em&gt;tosca_guid&lt;/em&gt; and &lt;em&gt;tosca_node_path&lt;/em&gt; are optional but must be specified in pair |
 **type** | **String**| Always input &lt;em&gt;automation&lt;/em&gt; for this parameter | [enum: automation]
 **testRunId** | **Long**| This should always be &lt;strong&gt;0 (zero)&lt;/strong&gt; or else it will throw an exception |
 **escapeXml** | **Boolean**| &lt;em&gt;escapeXml&#x3D;true&lt;/em&gt; - default value. &amp;gt and &amp;lt in &lt;em&gt;Automation Content&lt;/em&gt; field are encoded  &lt;em&gt;escapeXml&#x3D;false&lt;/em&gt; - the Automation Content field is not encoded | [optional] [default to false]
 **userId** | **String**|  | [optional]

### Return type

[**QueueProcessingResponse**](QueueProcessingResponse.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="submitAutomationTestLogsWithTreeStructure"></a>
# **submitAutomationTestLogsWithTreeStructure**
> QueueProcessingResponse submitAutomationTestLogsWithTreeStructure(projectId, body, type, escapeXml, userId)

Submits multiple test results and specifies Test Design and Test Execution tree structures

This is the extended version of this API &lt;strong&gt;POST /api/v3.1/projects/{projectId}/test-runs/{testRunId}/auto-test-logs&lt;/strong&gt;. It allows submitting multiple test logs in one API request, and creating Test Cases and Test Runs in hierarchical structure which is specified in the request body  &lt;strong&gt;Important:&lt;/strong&gt; This API does not update names and locations of existing Test Cases and Test Runs

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestLogApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestLogApi apiInstance = new TestLogApi();
Long projectId = 789L; // Long | ID of the project
AutomationRequest body = new AutomationRequest(); // AutomationRequest | <em>test_cycle (required):</em> PID or ID of the parent Test Cycle in qTest Manager where submitted Test Runs will be located  <em>test_logs (required):</em> The array of TestLog objects. The below are TestLog attributes  <strong>TestLog attributes:</strong>  - <em>test_case_version_id:</em> ID of the associated Test Case's version. In case the Test Run has not existed, this field should not be included or it will cause an error  - <em>status (required):</em> The automation result values that were mapped with Test Run Result in qTest automation settings  - <em>exe_start_date (required):</em> Execution start time  - <em>exe_end_date (required):</em> Execution end time  - <em>module_names (required):</em> an array of folder names which will be used when creating hierarchical structure in Test Design and Test Execution trees. In Test Design tree, the first folder will be created as a Module directly under the tree root. Other folders will be created as sub-Modules under their preceding folders in the array. In Test Execution tree, the first folder will be created as a Test Cycle directly under the parent Test Cycle which is specified in the API request. Other folders will be created as sub Test Cycles under their preceding folders in the array. If there is a folder in the tree with matching name and location, the API will not create a duplicate one  - <em>name (required):</em> It will be used when <em>creating</em> Test Cases and Test Runs as their names. It will not be used for updating Test Case and Test Run names  - <em>automation_content (required):</em> Specify a unique string to each Test Case. It acts as Test Case fingerprint. Before adding a Test Log, qTest Manager will look up Automation Content of existing Test Cases. If it can find an existing Test Case, the Test Log will be associated with that Test Case. Otherwise, a new Test Case will be created with the submitted Test Log. It is also be used when creating Test Runs. If qTest Manager finds an existing Test Run with matching Automation Content and location in Test Execution tree, it will not create a duplicate one. If there is an existing Test Run with matching Automation Content but it is located in different Test Cycles, qTest Manager will create a new Test Run in the specified folder  - <em>attachments:</em> an array of the Attachment objects  - <em>test_step_logs:</em> an array of TestStepLog objects. You can specify Test Steps' order in the request. It must be continous series of numbers, starting from zero, or it will throw an error. The order will be used when the Test Case is created or updated in qTest. If the order is omitted, Test Steps will be alphabetically sorted when creating or updating Test Case  - <em>tosca_guid</em>: GUID of Tosca test case. Use for creating Tosca Test Case  - <em>tosca_node_path</em>: Node Path of Tosca test case. Use for creating Tosca Test Case  - <em>tosca_guid</em> and <em>tosca_node_path</em> are optional but must be specified in pair  <strong>Test Step Log attributes</strong>  - <em>description (required):</em> Description of the Test Step  - <em>expected_result (required):</em> Expected result of the Test Step  - <em>actual_result (required):</em> Actual result of the Test Step  - <em>status (required):</em> The automation result values that were mapped with Test Run Result in qTest automation settings  - <em>order:</em> Specify the order of Test Steps. It must be continous series of numbers, starting from zero, or it will throw an error. The order will be used when the Test Case is created or updated in qTest. If the order is omitted, Test Steps will be alphabetically sorted when creating or updating Test Case  - <em>exe_date:</em> Execution date
String type = "type_example"; // String | always use <em>type=automation</em> for this parameter
Boolean escapeXml = true; // Boolean | <em>escapeXml=true</em> - default value. &gt and &lt in <em>Automation Content</em> field are encoded  <em>escapeXml=false</em> - the Automation Content field is not encoded
String userId = "userId_example"; // String | 
try {
    QueueProcessingResponse result = apiInstance.submitAutomationTestLogsWithTreeStructure(projectId, body, type, escapeXml, userId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestLogApi#submitAutomationTestLogsWithTreeStructure");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **body** | [**AutomationRequest**](AutomationRequest.md)| &lt;em&gt;test_cycle (required):&lt;/em&gt; PID or ID of the parent Test Cycle in qTest Manager where submitted Test Runs will be located  &lt;em&gt;test_logs (required):&lt;/em&gt; The array of TestLog objects. The below are TestLog attributes  &lt;strong&gt;TestLog attributes:&lt;/strong&gt;  - &lt;em&gt;test_case_version_id:&lt;/em&gt; ID of the associated Test Case&#39;s version. In case the Test Run has not existed, this field should not be included or it will cause an error  - &lt;em&gt;status (required):&lt;/em&gt; The automation result values that were mapped with Test Run Result in qTest automation settings  - &lt;em&gt;exe_start_date (required):&lt;/em&gt; Execution start time  - &lt;em&gt;exe_end_date (required):&lt;/em&gt; Execution end time  - &lt;em&gt;module_names (required):&lt;/em&gt; an array of folder names which will be used when creating hierarchical structure in Test Design and Test Execution trees. In Test Design tree, the first folder will be created as a Module directly under the tree root. Other folders will be created as sub-Modules under their preceding folders in the array. In Test Execution tree, the first folder will be created as a Test Cycle directly under the parent Test Cycle which is specified in the API request. Other folders will be created as sub Test Cycles under their preceding folders in the array. If there is a folder in the tree with matching name and location, the API will not create a duplicate one  - &lt;em&gt;name (required):&lt;/em&gt; It will be used when &lt;em&gt;creating&lt;/em&gt; Test Cases and Test Runs as their names. It will not be used for updating Test Case and Test Run names  - &lt;em&gt;automation_content (required):&lt;/em&gt; Specify a unique string to each Test Case. It acts as Test Case fingerprint. Before adding a Test Log, qTest Manager will look up Automation Content of existing Test Cases. If it can find an existing Test Case, the Test Log will be associated with that Test Case. Otherwise, a new Test Case will be created with the submitted Test Log. It is also be used when creating Test Runs. If qTest Manager finds an existing Test Run with matching Automation Content and location in Test Execution tree, it will not create a duplicate one. If there is an existing Test Run with matching Automation Content but it is located in different Test Cycles, qTest Manager will create a new Test Run in the specified folder  - &lt;em&gt;attachments:&lt;/em&gt; an array of the Attachment objects  - &lt;em&gt;test_step_logs:&lt;/em&gt; an array of TestStepLog objects. You can specify Test Steps&#39; order in the request. It must be continous series of numbers, starting from zero, or it will throw an error. The order will be used when the Test Case is created or updated in qTest. If the order is omitted, Test Steps will be alphabetically sorted when creating or updating Test Case  - &lt;em&gt;tosca_guid&lt;/em&gt;: GUID of Tosca test case. Use for creating Tosca Test Case  - &lt;em&gt;tosca_node_path&lt;/em&gt;: Node Path of Tosca test case. Use for creating Tosca Test Case  - &lt;em&gt;tosca_guid&lt;/em&gt; and &lt;em&gt;tosca_node_path&lt;/em&gt; are optional but must be specified in pair  &lt;strong&gt;Test Step Log attributes&lt;/strong&gt;  - &lt;em&gt;description (required):&lt;/em&gt; Description of the Test Step  - &lt;em&gt;expected_result (required):&lt;/em&gt; Expected result of the Test Step  - &lt;em&gt;actual_result (required):&lt;/em&gt; Actual result of the Test Step  - &lt;em&gt;status (required):&lt;/em&gt; The automation result values that were mapped with Test Run Result in qTest automation settings  - &lt;em&gt;order:&lt;/em&gt; Specify the order of Test Steps. It must be continous series of numbers, starting from zero, or it will throw an error. The order will be used when the Test Case is created or updated in qTest. If the order is omitted, Test Steps will be alphabetically sorted when creating or updating Test Case  - &lt;em&gt;exe_date:&lt;/em&gt; Execution date |
 **type** | **String**| always use &lt;em&gt;type&#x3D;automation&lt;/em&gt; for this parameter | [enum: automation]
 **escapeXml** | **Boolean**| &lt;em&gt;escapeXml&#x3D;true&lt;/em&gt; - default value. &amp;gt and &amp;lt in &lt;em&gt;Automation Content&lt;/em&gt; field are encoded  &lt;em&gt;escapeXml&#x3D;false&lt;/em&gt; - the Automation Content field is not encoded | [optional]
 **userId** | **String**|  | [optional]

### Return type

[**QueueProcessingResponse**](QueueProcessingResponse.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="submitTestLog"></a>
# **submitTestLog**
> TestLogResource submitTestLog(projectId, body, testRunId)

Submits a Manual Test Log

To submit test result of a &lt;em&gt;manual&lt;/em&gt; Test Run  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 4+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestLogApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestLogApi apiInstance = new TestLogApi();
Long projectId = 789L; // Long | ID of the project
ManualTestLogResource body = new ManualTestLogResource(); // ManualTestLogResource | <em>status (required):</em> Status of the Test Log as defined in the project's Field Settings  <em>test_case_version_id:</em> ID of the associated Test Case's version.    If it is omitted, the submitted Test Log will be associated with the Test Case's latest approved version  <em>exe_start_date (required):</em> time when the test is executed  <em>exe_end_date (required):</em> time when the test is finished  <em>attachments:</em> the Test Log's attachments  <em>test_step_logs:</em > If the associated Test Case is calling Test Steps from another Test Case, the \"called_test_case_id\" and \"parent_test_step_id\" must be included in the request body
Long testRunId = 789L; // Long | ID of the Test Run
try {
    TestLogResource result = apiInstance.submitTestLog(projectId, body, testRunId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestLogApi#submitTestLog");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **body** | [**ManualTestLogResource**](ManualTestLogResource.md)| &lt;em&gt;status (required):&lt;/em&gt; Status of the Test Log as defined in the project&#39;s Field Settings  &lt;em&gt;test_case_version_id:&lt;/em&gt; ID of the associated Test Case&#39;s version.    If it is omitted, the submitted Test Log will be associated with the Test Case&#39;s latest approved version  &lt;em&gt;exe_start_date (required):&lt;/em&gt; time when the test is executed  &lt;em&gt;exe_end_date (required):&lt;/em&gt; time when the test is finished  &lt;em&gt;attachments:&lt;/em&gt; the Test Log&#39;s attachments  &lt;em&gt;test_step_logs:&lt;/em &gt; If the associated Test Case is calling Test Steps from another Test Case, the \&quot;called_test_case_id\&quot; and \&quot;parent_test_step_id\&quot; must be included in the request body |
 **testRunId** | **Long**| ID of the Test Run |

### Return type

[**TestLogResource**](TestLogResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="track"></a>
# **track**
> QueueProcessingResponse track(id)

Gets a Batch Test Log Submission job&#39;s state

To check the state of a Batch Test Log Submission job.   When you submit test results to qTest Manager using:  &lt;strong&gt;POST /api/v3.1/projects/{projectId}/test-runs/{testRunId}/auto-test-logs?type&#x3D;automation&lt;/strong&gt;  or &lt;strong&gt;POST /api/v3/projects/{projectId}/auto-test-logs?type&#x3D;automation&lt;/strong&gt;, their response include a job ID.  You will need to use this API and the returned ID to check if the submission job has completed.  Job states include &lt;i&gt;IN_WAITING&lt;/i&gt;, &lt;i&gt;IN_PROCESSING&lt;/i&gt;, &lt;i&gt;FAILED&lt;/i&gt;, &lt;i&gt;PENDING&lt;/i&gt; and &lt;i&gt;SUCCESS&lt;/i&gt;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TestLogApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

TestLogApi apiInstance = new TestLogApi();
Long id = 789L; // Long | The ID of the submission job.   It is included in the response of these 2 APIs:  <strong>POST /api/v3.1/projects/{projectId}/test-runs/{testRunId}/auto-test-logs?type=automation</strong>   or <strong>POST /api/v3/projects/{projectId}/auto-test-logs?type=automation</strong>
try {
    QueueProcessingResponse result = apiInstance.track(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestLogApi#track");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| The ID of the submission job.   It is included in the response of these 2 APIs:  &lt;strong&gt;POST /api/v3.1/projects/{projectId}/test-runs/{testRunId}/auto-test-logs?type&#x3D;automation&lt;/strong&gt;   or &lt;strong&gt;POST /api/v3/projects/{projectId}/auto-test-logs?type&#x3D;automation&lt;/strong&gt; |

### Return type

[**QueueProcessingResponse**](QueueProcessingResponse.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

