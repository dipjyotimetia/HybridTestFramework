# ToscaApi

All URIs are relative to *https://apitryout.qtestnet.com/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**notifyTestEventImport**](ToscaApi.md#notifyTestEventImport) | **POST** /api/v3/projects/{projectId}/tosca/import/test-event | Import Tosca TestEvent objects


<a name="notifyTestEventImport"></a>
# **notifyTestEventImport**
> QueueProcessingResponse notifyTestEventImport(projectId, body)

Import Tosca TestEvent objects

To export TestEvent objects from Tosca to qTest

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ToscaApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

ToscaApi apiInstance = new ToscaApi();
Long projectId = 789L; // Long | ID of the project
List<ToscaTestCycleResource> body = Arrays.asList(new ToscaTestCycleResource()); // List<ToscaTestCycleResource> | An array of hierarchy Tosca objects  <em>toscaUniqueId (required):</em> Unique ID of the Tosca object  <em>name (required):</em> Name of the Tosca object  <em>description:</em> Description of the Tosca object  <em>toscaObjectType (required):</em> Type of the Tosca object: TestEvent, ExecutionList (contained inTestEvent), ExecutionEntry Folder(contained in Execution List). Object is TestEvent type is always on the root of body array and doesn't contain ExecutionEntry objects   <em>toscaNodePath (required):</em> Node path of the Tosca object  <em>testCycles:</em> The array of TestEvent or ExecutionList or ExecutionEntry Folder objects  <em>testRuns:</em> The array of ExecutionEntry objects in testCycle property  <em>associatedToscaTestCase:</em> Testcase object that associated with testRun object
try {
    QueueProcessingResponse result = apiInstance.notifyTestEventImport(projectId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ToscaApi#notifyTestEventImport");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **body** | [**List&lt;ToscaTestCycleResource&gt;**](ToscaTestCycleResource.md)| An array of hierarchy Tosca objects  &lt;em&gt;toscaUniqueId (required):&lt;/em&gt; Unique ID of the Tosca object  &lt;em&gt;name (required):&lt;/em&gt; Name of the Tosca object  &lt;em&gt;description:&lt;/em&gt; Description of the Tosca object  &lt;em&gt;toscaObjectType (required):&lt;/em&gt; Type of the Tosca object: TestEvent, ExecutionList (contained inTestEvent), ExecutionEntry Folder(contained in Execution List). Object is TestEvent type is always on the root of body array and doesn&#39;t contain ExecutionEntry objects   &lt;em&gt;toscaNodePath (required):&lt;/em&gt; Node path of the Tosca object  &lt;em&gt;testCycles:&lt;/em&gt; The array of TestEvent or ExecutionList or ExecutionEntry Folder objects  &lt;em&gt;testRuns:&lt;/em&gt; The array of ExecutionEntry objects in testCycle property  &lt;em&gt;associatedToscaTestCase:&lt;/em&gt; Testcase object that associated with testRun object |

### Return type

[**QueueProcessingResponse**](QueueProcessingResponse.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

