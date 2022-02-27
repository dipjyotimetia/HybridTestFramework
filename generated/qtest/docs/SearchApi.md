# SearchApi

All URIs are relative to *https://apitryout.qtestnet.com/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**queryHistories**](SearchApi.md#queryHistories) | **POST** /api/v3/projects/{projectId}/histories | Queries objects&#39; histories
[**searchArtifact**](SearchApi.md#searchArtifact) | **POST** /api/v3/projects/{projectId}/search | Queries objects
[**searchCommentWithQuery**](SearchApi.md#searchCommentWithQuery) | **POST** /api/v3/projects/{projectId}/comments | Queries Comments


<a name="queryHistories"></a>
# **queryHistories**
> ArtifactHistoryResource queryHistories(projectId, body, pageSize, page)

Queries objects&#39; histories

To query histories of Requirements, Test Cases, Test Runs and &lt;em&gt;internal&lt;/em&gt; Defects  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 7.6+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SearchApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

SearchApi apiInstance = new SearchApi();
Long projectId = 789L; // Long | ID of the project
HistoryQueryParams body = new HistoryQueryParams(); // HistoryQueryParams | <em>object_type (required):</em> valid values include <em>requirements</em>, <em>test-cases</em>, <em>test-runs</em>, or <em>defects</em>  <em>fields:</em> specify which object fields you want to include in the response. If you omit it or specify an asterisk (*), all fields are included  <em>object_query:</em> specify a structured query to search for qTest objects. <br/>Refer to attribute <em>query</em> in the Request Body of <em>Queries Objects</em> API  <em>query:</em> specify a structured query to retrieve histories of objects specified in attribute <em>object_query</em> above. You can use operators <em>and</em> and <em>or</em> to combine multiple criteria. Only these 2 criteria are supported:  <br/>i) <em>created:</em> it can be used for querying by updated date of the object. Its values need to be in ISO Date format. Applicable operator include: =, <>, &lt;= and >=  <br/>ii) <em>author:</em> it can be used for querying by ID of the users who made the update. Applicable operators include: = and <>
Long pageSize = 100L; // Long | The result is paginated. By the default, the number of objects in each page is 100 if this is omitted. You can specify your custom number (up to 999) in this parameter
Long page = 1L; // Long | By default the first page is returned but you can specify any page number to retrieve objects
try {
    ArtifactHistoryResource result = apiInstance.queryHistories(projectId, body, pageSize, page);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SearchApi#queryHistories");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **body** | [**HistoryQueryParams**](HistoryQueryParams.md)| &lt;em&gt;object_type (required):&lt;/em&gt; valid values include &lt;em&gt;requirements&lt;/em&gt;, &lt;em&gt;test-cases&lt;/em&gt;, &lt;em&gt;test-runs&lt;/em&gt;, or &lt;em&gt;defects&lt;/em&gt;  &lt;em&gt;fields:&lt;/em&gt; specify which object fields you want to include in the response. If you omit it or specify an asterisk (*), all fields are included  &lt;em&gt;object_query:&lt;/em&gt; specify a structured query to search for qTest objects. &lt;br/&gt;Refer to attribute &lt;em&gt;query&lt;/em&gt; in the Request Body of &lt;em&gt;Queries Objects&lt;/em&gt; API  &lt;em&gt;query:&lt;/em&gt; specify a structured query to retrieve histories of objects specified in attribute &lt;em&gt;object_query&lt;/em&gt; above. You can use operators &lt;em&gt;and&lt;/em&gt; and &lt;em&gt;or&lt;/em&gt; to combine multiple criteria. Only these 2 criteria are supported:  &lt;br/&gt;i) &lt;em&gt;created:&lt;/em&gt; it can be used for querying by updated date of the object. Its values need to be in ISO Date format. Applicable operator include: &#x3D;, &lt;&gt;, &amp;lt;&#x3D; and &gt;&#x3D;  &lt;br/&gt;ii) &lt;em&gt;author:&lt;/em&gt; it can be used for querying by ID of the users who made the update. Applicable operators include: &#x3D; and &lt;&gt; |
 **pageSize** | **Long**| The result is paginated. By the default, the number of objects in each page is 100 if this is omitted. You can specify your custom number (up to 999) in this parameter | [optional] [default to 100]
 **page** | **Long**| By default the first page is returned but you can specify any page number to retrieve objects | [optional] [default to 1]

### Return type

[**ArtifactHistoryResource**](ArtifactHistoryResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="searchArtifact"></a>
# **searchArtifact**
> PagedResource searchArtifact(projectId, body, appendTestSteps, includeExternalProperties, pageSize, page)

Queries objects

This API mimics the Data Query function of qTest Manager web app. It provides the capability to query Requirements, Test Cases, Test Runs and &lt;em&gt;internal&lt;/em&gt; Defects

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SearchApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

SearchApi apiInstance = new SearchApi();
Long projectId = 789L; // Long | ID of the project
ArtifactSearchParams body = new ArtifactSearchParams(); // ArtifactSearchParams | <em>object_type (required):</em> Its value can be <em>releases</em>, <em>requirements</em>, <em>test-cases</em>, <em>test-runs</em>, <em>test-suites</em>, <em>test-cycles</em>, <em>test-logs</em>, <em>builds</em> or <em>defects</em>  <em>fields:</em> specify which object fields you want to include in the response. If you omit it or specify an asterisk (*), all fields are included  <em>query:</em> specify a structured query to search for qTest Manager objects. Basically, you can use the Query Summary text in qTest web app as in the below image for this attribute  <strong>IMPORTANT:</strong> When using Query Summary to specify the query, you will need to modify the Query Summary in some special cases as below:  - If there are spaces in the criteria name, put it between '' (single quotation marks)  - There need to be spaces between a criteria, operator and value  - You can use field name or field ID in the query  - You can use a value text or its ID in the query  - For date time typed fields: you will need to convert the values to ISO Date Time format  - Using operator \"IN\" to search for date time typed fields means system will search for the value within this range: inputted date time &lt;= value &lt;= inputted date time + 23h59m59s  - <em>Affected Release/Build:</em> if you want to query Defects by their affected release, use <em>Affected Release</em> instead. Otherwise, use <em>Affected Build</em>  - <em>Target Release/Build:</em> similarly, you will need to break it down to <em>Target Release</em> and <em>Target Build</em>  - <em>Fixed Release/Build:</em> similarly, you will need to break it down to <em>Fixed Release</em> and <em>Fixed Build</em>  - Subscriber: modify it to Subscribers and use user ID instead of username to query  - You will need to use object Id when querying using these fields: Id, Affected Release, Affected Build, Target Release, Target Build, Fixed Release and Fixed Build  - Modify operator <em>contains</em> to <em>~</em>, and modify operator <em>not contains</em> to <em>!~</em>. Eg: instead of <em>Name contains \"login\"</em>, change it to <em>Name ~ \"login\"</em>  - Modify operator <em>is not empty</em> to <strong>is 'not empty'</strong>. Eg: Name is 'not empty'  - For builds and test-cycles, you can query using Created Date or Last Modified Date. Eg: 'Created Date' > '2021-05-07T03:15:37.652Z'  - For test-logs, you can query using Execution Start Date or Execution End Date. Eg: 'Execution Start Date' > '2021-05-07T03:15:37.652Z'
Boolean appendTestSteps = true; // Boolean | 
Boolean includeExternalProperties = true; // Boolean | By default, Requirement external properties are not included in the response. Specify includeExternalProperties=true to include them.
Long pageSize = 100L; // Long | The result is paginated. By the default, the number of objects in each page is 100 if this is omitted. You can specify your custom number (up to 999) in this parameter
Long page = 1L; // Long | By default the first page is returned but you can specify any page number to retrieve objects
try {
    PagedResource result = apiInstance.searchArtifact(projectId, body, appendTestSteps, includeExternalProperties, pageSize, page);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SearchApi#searchArtifact");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **body** | [**ArtifactSearchParams**](ArtifactSearchParams.md)| &lt;em&gt;object_type (required):&lt;/em&gt; Its value can be &lt;em&gt;releases&lt;/em&gt;, &lt;em&gt;requirements&lt;/em&gt;, &lt;em&gt;test-cases&lt;/em&gt;, &lt;em&gt;test-runs&lt;/em&gt;, &lt;em&gt;test-suites&lt;/em&gt;, &lt;em&gt;test-cycles&lt;/em&gt;, &lt;em&gt;test-logs&lt;/em&gt;, &lt;em&gt;builds&lt;/em&gt; or &lt;em&gt;defects&lt;/em&gt;  &lt;em&gt;fields:&lt;/em&gt; specify which object fields you want to include in the response. If you omit it or specify an asterisk (*), all fields are included  &lt;em&gt;query:&lt;/em&gt; specify a structured query to search for qTest Manager objects. Basically, you can use the Query Summary text in qTest web app as in the below image for this attribute  &lt;strong&gt;IMPORTANT:&lt;/strong&gt; When using Query Summary to specify the query, you will need to modify the Query Summary in some special cases as below:  - If there are spaces in the criteria name, put it between &#39;&#39; (single quotation marks)  - There need to be spaces between a criteria, operator and value  - You can use field name or field ID in the query  - You can use a value text or its ID in the query  - For date time typed fields: you will need to convert the values to ISO Date Time format  - Using operator \&quot;IN\&quot; to search for date time typed fields means system will search for the value within this range: inputted date time &amp;lt;&#x3D; value &amp;lt;&#x3D; inputted date time + 23h59m59s  - &lt;em&gt;Affected Release/Build:&lt;/em&gt; if you want to query Defects by their affected release, use &lt;em&gt;Affected Release&lt;/em&gt; instead. Otherwise, use &lt;em&gt;Affected Build&lt;/em&gt;  - &lt;em&gt;Target Release/Build:&lt;/em&gt; similarly, you will need to break it down to &lt;em&gt;Target Release&lt;/em&gt; and &lt;em&gt;Target Build&lt;/em&gt;  - &lt;em&gt;Fixed Release/Build:&lt;/em&gt; similarly, you will need to break it down to &lt;em&gt;Fixed Release&lt;/em&gt; and &lt;em&gt;Fixed Build&lt;/em&gt;  - Subscriber: modify it to Subscribers and use user ID instead of username to query  - You will need to use object Id when querying using these fields: Id, Affected Release, Affected Build, Target Release, Target Build, Fixed Release and Fixed Build  - Modify operator &lt;em&gt;contains&lt;/em&gt; to &lt;em&gt;~&lt;/em&gt;, and modify operator &lt;em&gt;not contains&lt;/em&gt; to &lt;em&gt;!~&lt;/em&gt;. Eg: instead of &lt;em&gt;Name contains \&quot;login\&quot;&lt;/em&gt;, change it to &lt;em&gt;Name ~ \&quot;login\&quot;&lt;/em&gt;  - Modify operator &lt;em&gt;is not empty&lt;/em&gt; to &lt;strong&gt;is &#39;not empty&#39;&lt;/strong&gt;. Eg: Name is &#39;not empty&#39;  - For builds and test-cycles, you can query using Created Date or Last Modified Date. Eg: &#39;Created Date&#39; &gt; &#39;2021-05-07T03:15:37.652Z&#39;  - For test-logs, you can query using Execution Start Date or Execution End Date. Eg: &#39;Execution Start Date&#39; &gt; &#39;2021-05-07T03:15:37.652Z&#39; |
 **appendTestSteps** | **Boolean**|  | [optional]
 **includeExternalProperties** | **Boolean**| By default, Requirement external properties are not included in the response. Specify includeExternalProperties&#x3D;true to include them. | [optional]
 **pageSize** | **Long**| The result is paginated. By the default, the number of objects in each page is 100 if this is omitted. You can specify your custom number (up to 999) in this parameter | [optional] [default to 100]
 **page** | **Long**| By default the first page is returned but you can specify any page number to retrieve objects | [optional] [default to 1]

### Return type

[**PagedResource**](PagedResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="searchCommentWithQuery"></a>
# **searchCommentWithQuery**
> QueryCommentResource searchCommentWithQuery(projectId, body, page, pageSize)

Queries Comments

To search for comments  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 7.6+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SearchApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

SearchApi apiInstance = new SearchApi();
Long projectId = 789L; // Long | ID of the project
CommentQueryParams body = new CommentQueryParams(); // CommentQueryParams | <em>object_type (required):</em> valid values include requirements, test-cases, test-runs and defects  <em>object:</em> ID of the object from which you want to retrieve comments  <em>authors:</em> ID of the user who made the comments  <em>start:</em> This value needs to be in ISO Date format  <em>end:</em> This value needs to be in ISO Date format
Long page = 1L; // Long | By default the first page is returned but you can specify any page number to retrieve objects
Long pageSize = 100L; // Long | The result is paginated. By the default, the number of objects in each page is 100 if this is omitted. You can specify your custom number (up to 999) in this parameter
try {
    QueryCommentResource result = apiInstance.searchCommentWithQuery(projectId, body, page, pageSize);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SearchApi#searchCommentWithQuery");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **body** | [**CommentQueryParams**](CommentQueryParams.md)| &lt;em&gt;object_type (required):&lt;/em&gt; valid values include requirements, test-cases, test-runs and defects  &lt;em&gt;object:&lt;/em&gt; ID of the object from which you want to retrieve comments  &lt;em&gt;authors:&lt;/em&gt; ID of the user who made the comments  &lt;em&gt;start:&lt;/em&gt; This value needs to be in ISO Date format  &lt;em&gt;end:&lt;/em&gt; This value needs to be in ISO Date format |
 **page** | **Long**| By default the first page is returned but you can specify any page number to retrieve objects | [optional] [default to 1]
 **pageSize** | **Long**| The result is paginated. By the default, the number of objects in each page is 100 if this is omitted. You can specify your custom number (up to 999) in this parameter | [optional] [default to 100]

### Return type

[**QueryCommentResource**](QueryCommentResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

