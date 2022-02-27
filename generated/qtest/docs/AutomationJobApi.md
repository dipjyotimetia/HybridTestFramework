# AutomationJobApi

All URIs are relative to *https://apitryout.qtestnet.com/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createSchedule**](AutomationJobApi.md#createSchedule) | **POST** /api/v3/automation/jobs/schedule/create | Create a Schedule
[**searchAutomationAgents**](AutomationJobApi.md#searchAutomationAgents) | **POST** /api/v3/automation/automation-agents | Search automation agents


<a name="createSchedule"></a>
# **createSchedule**
> Long createSchedule(body)

Create a Schedule

To create a new Schedule which will be executed immediately  &lt;strong&gt;NOTE:&lt;/strong&gt; Try It Out function will not work for this API  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 6+\&quot;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AutomationJobApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

AutomationJobApi apiInstance = new AutomationJobApi();
AutomationScheduleCreationAPI body = new AutomationScheduleCreationAPI(); // AutomationScheduleCreationAPI | 
try {
    Long result = apiInstance.createSchedule(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AutomationJobApi#createSchedule");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**AutomationScheduleCreationAPI**](AutomationScheduleCreationAPI.md)|  |

### Return type

**Long**

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="searchAutomationAgents"></a>
# **searchAutomationAgents**
> PagedResource searchAutomationAgents(body, pageSize, page)

Search automation agents

To search automation agents in projects that user is assigned to   &lt;em&gt;fields:&lt;/em&gt; specify which property of Automation Agent you want to include in the response. If you omit it or specify an asterisk (*), all of following fields are included: id, name, project_id, host_id, framework, active, configuration   &lt;em&gt;query:&lt;/em&gt; specify a structured query (criteria, operator and value) with one or multiple clauses to search for Automation Agents. Following are supporting criteria  | Criteria | Operators | Value | |-----|-----|-------| | name, framework   |  &lt;&gt;, ~, is empty, &#x3D;, !~, is not empty   | string     |  |host_name | &lt;&gt;, ~, &#x3D;, !~ | string |  | id, project_id, host_id | &lt;&gt;, &gt;, &lt;, &lt;&#x3D;, &gt;&#x3D;, &#x3D;| id   | active | &#x3D; | active, inactive  

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AutomationJobApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

AutomationJobApi apiInstance = new AutomationJobApi();
AutomationArtifactSearchParams body = new AutomationArtifactSearchParams(); // AutomationArtifactSearchParams | 
Long pageSize = 100L; // Long | The result is paginated. By the default, the number of objects in each page is 100 if this is omitted. You can specify your custom number (up to 999) in this parameter
Long page = 1L; // Long | By default the first page is returned but you can specify any page number to retrieve objects
try {
    PagedResource result = apiInstance.searchAutomationAgents(body, pageSize, page);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AutomationJobApi#searchAutomationAgents");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**AutomationArtifactSearchParams**](AutomationArtifactSearchParams.md)|  |
 **pageSize** | **Long**| The result is paginated. By the default, the number of objects in each page is 100 if this is omitted. You can specify your custom number (up to 999) in this parameter | [optional] [default to 100]
 **page** | **Long**| By default the first page is returned but you can specify any page number to retrieve objects | [optional] [default to 1]

### Return type

[**PagedResource**](PagedResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

