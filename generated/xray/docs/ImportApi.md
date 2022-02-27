# ImportApi

All URIs are relative to *https://sandbox.xpand-it.com/rest/raven/2.0/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**postImportExecution**](ImportApi.md#postImportExecution) | **POST** /import/execution | 
[**postImportExecutionMultipart**](ImportApi.md#postImportExecutionMultipart) | **POST** /import/execution/multipart | 


<a name="postImportExecution"></a>
# **postImportExecution**
> RestApiSuccessResponse postImportExecution(xrayJsonImportExecution)



Endpoint used to import Test results in the Xray JSON format. &lt;br&gt;&lt;/br&gt; Updating an existing Test Run using Xray format REST API will reset all dataset related fields. This means that all current iteration data and dataset present in the Test Run will be replaced with the new information given in the REST API request.

### Example
```java
// Import classes:
import org.openapi.xray.invoker.ApiClient;
import org.openapi.xray.invoker.ApiException;
import org.openapi.xray.invoker.Configuration;
import org.openapi.xray.invoker.auth.*;
import org.openapi.xray.invoker.models.*;
import org.openapi.xray.api.ImportApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.xpand-it.com/rest/raven/2.0/api");
    
    // Configure HTTP basic authorization: BasicAuth
    HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
    BasicAuth.setUsername("YOUR USERNAME");
    BasicAuth.setPassword("YOUR PASSWORD");

    ImportApi apiInstance = new ImportApi(defaultClient);
    XrayJsonImportExecution xrayJsonImportExecution = new XrayJsonImportExecution(); // XrayJsonImportExecution | 
    try {
      RestApiSuccessResponse result = apiInstance.postImportExecution(xrayJsonImportExecution);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ImportApi#postImportExecution");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **xrayJsonImportExecution** | [**XrayJsonImportExecution**](XrayJsonImportExecution.md)|  | [optional]

### Return type

[**RestApiSuccessResponse**](RestApiSuccessResponse.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Successful operation |  -  |
**400** | Bad Request |  -  |

<a name="postImportExecutionMultipart"></a>
# **postImportExecutionMultipart**
> RestApiSuccessResponse postImportExecutionMultipart(result, info)



Endpoint used to import Test results in the Xray JSON format with Test Execution issue data.  &lt;br&gt;&lt;/br&gt; Updating an existing Test Run using Xray format REST API will reset all dataset related fields. This means that all current iteration data and dataset present in the Test Run will be replaced with the new information given in the REST API request.

### Example
```java
// Import classes:
import org.openapi.xray.invoker.ApiClient;
import org.openapi.xray.invoker.ApiException;
import org.openapi.xray.invoker.Configuration;
import org.openapi.xray.invoker.auth.*;
import org.openapi.xray.invoker.models.*;
import org.openapi.xray.api.ImportApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.xpand-it.com/rest/raven/2.0/api");
    
    // Configure HTTP basic authorization: BasicAuth
    HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
    BasicAuth.setUsername("YOUR USERNAME");
    BasicAuth.setPassword("YOUR PASSWORD");

    ImportApi apiInstance = new ImportApi(defaultClient);
    File result = new File("/path/to/file"); // File | The Xray JSON file, same as described in the `POST /import/execution` ([link](https://docs.getxray.app/display/XRAY420/v2.0#/Import/post-import-execution)). This file **must** be of type `application/json`.  <details> <summary>Example 1 (Create new Test Execution issue)</summary>  ``` {   \\\"info\\\": {     \\\"summary\\\": \\\"Execution of automated tests for release v1.3\\\",     \\\"description\\\": \\\"This execution is automatically created when importing execution results from an external source\\\",     \\\"version\\\": \\\"v1.3\\\",     \\\"user\\\": \\\"admin\\\",     \\\"revision\\\": \\\"1.0.42134\\\",     \\\"startDate\\\": \\\"2014-08-30T11:47:35+01:00\\\",     \\\"finishDate\\\": \\\"2014-08-30T11:53:00+01:00\\\",     \\\"testPlanKey\\\": \\\"DEMO-100\\\",     \\\"testEnvironments\\\": [       \\\"iOS\\\",       \\\"Android\\\"     ]   },   \\\"tests\\\": [     {       \\\"testKey\\\": \\\"DEMO-6\\\",       \\\"start\\\": \\\"2014-08-30T11:47:35+01:00\\\",       \\\"finish\\\": \\\"2014-08-30T11:50:56+01:00\\\",       \\\"comment\\\": \\\"Successful execution\\\",       \\\"status\\\": \\\"PASS\\\"     },     {       \\\"testKey\\\": \\\"DEMO-7\\\",       \\\"start\\\": \\\"2014-08-30T11:51:00+01:00\\\",       \\\"finish\\\": \\\"2014-08-30T11:52:30+01:00\\\",       \\\"comment\\\": \\\"Execution failed. Example #5 FAIL.\\\",       \\\"status\\\": \\\"FAIL\\\",       \\\"customFields\\\": [         {           \\\"id\\\": 321,           \\\"value\\\": [             \\\"option A\\\",             \\\"option B\\\"           ]         }       ],       \\\"evidences\\\": [         {           \\\"data\\\": \\\"iVBORw0KGgoAAAANSUhEUgAABkIAAAO9CAYAAADezXv6AAAAEn(...base64 file enconding)\\\",           \\\"filename\\\": \\\"image21.jpg\\\",           \\\"contentType\\\": \\\"image/jpeg\\\"         }       ],       \\\"examples\\\": [         \\\"PASS\\\",         \\\"PASS\\\",         \\\"PASS\\\",         \\\"PASS\\\",         \\\"FAIL\\\"       ],       \\\"steps\\\": [         {           \\\"status\\\": \\\"PASS\\\",           \\\"comment\\\": \\\"Coment on Test Step Result 1\\\",           \\\"evidences\\\": [             {               \\\"data\\\": \\\"iVBORw0KGgoAAAANSUhEUgAABkIAAAO9CAYAAADezXv6AAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAAEn(...base64 file enconding)\\\",               \\\"filename\\\": \\\"image22.jpg\\\",               \\\"contentType\\\": \\\"image/jpeg\\\"             }           ],           \\\"actualResult\\\": \\\"Actual result on Test Step 1\\\"         }       ],       \\\"defects\\\": [         \\\"DEMO-10\\\",         \\\"DEMO-11\\\"       ]     }   ] } ``` </details>  <details> <summary>Example 2 (Update Existing Test Execution)</summary>  ``` {     \\\"testExecutionKey\\\": \\\"DEMO-1206\\\",     \\\"tests\\\" : [         {             \\\"testKey\\\" : \\\"DEMO-6\\\",             \\\"start\\\" : \\\"2014-08-30T11:47:35+01:00\\\",             \\\"finish\\\" : \\\"2014-08-30T11:50:56+01:00\\\",             \\\"comment\\\" : \\\"Successful execution\\\",             \\\"status\\\" : \\\"PASS\\\"         }      ] } ``` </details>  
    File info = new File("/path/to/file"); // File | Should follow the same format as the \\\"fields\\\" part, described in the [official Jira REST API](https://docs.atlassian.com/software/jira/docs/api/REST/latest/#api/2/issue-createIssue). This file **must** be of type `application/json`.  <details> <summary>Example 1 (Fields for a new Test Execution)</summary>  ``` {     \\\"fields\\\": {         \\\"project\\\": {             \\\"id\\\": \\\"10402\\\"         },         \\\"summary\\\": \\\"Brand new Test execution\\\",         \\\"issuetype\\\": {             \\\"id\\\": \\\"10007\\\"         },         \\\"components\\\" : [             {             \\\"name\\\":\\\"Interface\\\"             },             {             \\\"name\\\":\\\"Core\\\"             }         ],         \\\"customfield_10032\\\" : [             \\\"TES-38\\\"         ]     } } ``` </details>  <details> <summary>Example 2 (Fields for updating a Test Execution)</summary>  ``` {     \\\"fields\\\": {         \\\"customfield_10032\\\" : [             \\\"a_label\\\"         ],         \\\"description\\\": \\\"update the issue description\\\"     } } ```  </details>  
    try {
      RestApiSuccessResponse result = apiInstance.postImportExecutionMultipart(result, info);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ImportApi#postImportExecutionMultipart");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **result** | **File**| The Xray JSON file, same as described in the &#x60;POST /import/execution&#x60; ([link](https://docs.getxray.app/display/XRAY420/v2.0#/Import/post-import-execution)). This file **must** be of type &#x60;application/json&#x60;.  &lt;details&gt; &lt;summary&gt;Example 1 (Create new Test Execution issue)&lt;/summary&gt;  &#x60;&#x60;&#x60; {   \\\&quot;info\\\&quot;: {     \\\&quot;summary\\\&quot;: \\\&quot;Execution of automated tests for release v1.3\\\&quot;,     \\\&quot;description\\\&quot;: \\\&quot;This execution is automatically created when importing execution results from an external source\\\&quot;,     \\\&quot;version\\\&quot;: \\\&quot;v1.3\\\&quot;,     \\\&quot;user\\\&quot;: \\\&quot;admin\\\&quot;,     \\\&quot;revision\\\&quot;: \\\&quot;1.0.42134\\\&quot;,     \\\&quot;startDate\\\&quot;: \\\&quot;2014-08-30T11:47:35+01:00\\\&quot;,     \\\&quot;finishDate\\\&quot;: \\\&quot;2014-08-30T11:53:00+01:00\\\&quot;,     \\\&quot;testPlanKey\\\&quot;: \\\&quot;DEMO-100\\\&quot;,     \\\&quot;testEnvironments\\\&quot;: [       \\\&quot;iOS\\\&quot;,       \\\&quot;Android\\\&quot;     ]   },   \\\&quot;tests\\\&quot;: [     {       \\\&quot;testKey\\\&quot;: \\\&quot;DEMO-6\\\&quot;,       \\\&quot;start\\\&quot;: \\\&quot;2014-08-30T11:47:35+01:00\\\&quot;,       \\\&quot;finish\\\&quot;: \\\&quot;2014-08-30T11:50:56+01:00\\\&quot;,       \\\&quot;comment\\\&quot;: \\\&quot;Successful execution\\\&quot;,       \\\&quot;status\\\&quot;: \\\&quot;PASS\\\&quot;     },     {       \\\&quot;testKey\\\&quot;: \\\&quot;DEMO-7\\\&quot;,       \\\&quot;start\\\&quot;: \\\&quot;2014-08-30T11:51:00+01:00\\\&quot;,       \\\&quot;finish\\\&quot;: \\\&quot;2014-08-30T11:52:30+01:00\\\&quot;,       \\\&quot;comment\\\&quot;: \\\&quot;Execution failed. Example #5 FAIL.\\\&quot;,       \\\&quot;status\\\&quot;: \\\&quot;FAIL\\\&quot;,       \\\&quot;customFields\\\&quot;: [         {           \\\&quot;id\\\&quot;: 321,           \\\&quot;value\\\&quot;: [             \\\&quot;option A\\\&quot;,             \\\&quot;option B\\\&quot;           ]         }       ],       \\\&quot;evidences\\\&quot;: [         {           \\\&quot;data\\\&quot;: \\\&quot;iVBORw0KGgoAAAANSUhEUgAABkIAAAO9CAYAAADezXv6AAAAEn(...base64 file enconding)\\\&quot;,           \\\&quot;filename\\\&quot;: \\\&quot;image21.jpg\\\&quot;,           \\\&quot;contentType\\\&quot;: \\\&quot;image/jpeg\\\&quot;         }       ],       \\\&quot;examples\\\&quot;: [         \\\&quot;PASS\\\&quot;,         \\\&quot;PASS\\\&quot;,         \\\&quot;PASS\\\&quot;,         \\\&quot;PASS\\\&quot;,         \\\&quot;FAIL\\\&quot;       ],       \\\&quot;steps\\\&quot;: [         {           \\\&quot;status\\\&quot;: \\\&quot;PASS\\\&quot;,           \\\&quot;comment\\\&quot;: \\\&quot;Coment on Test Step Result 1\\\&quot;,           \\\&quot;evidences\\\&quot;: [             {               \\\&quot;data\\\&quot;: \\\&quot;iVBORw0KGgoAAAANSUhEUgAABkIAAAO9CAYAAADezXv6AAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAAEn(...base64 file enconding)\\\&quot;,               \\\&quot;filename\\\&quot;: \\\&quot;image22.jpg\\\&quot;,               \\\&quot;contentType\\\&quot;: \\\&quot;image/jpeg\\\&quot;             }           ],           \\\&quot;actualResult\\\&quot;: \\\&quot;Actual result on Test Step 1\\\&quot;         }       ],       \\\&quot;defects\\\&quot;: [         \\\&quot;DEMO-10\\\&quot;,         \\\&quot;DEMO-11\\\&quot;       ]     }   ] } &#x60;&#x60;&#x60; &lt;/details&gt;  &lt;details&gt; &lt;summary&gt;Example 2 (Update Existing Test Execution)&lt;/summary&gt;  &#x60;&#x60;&#x60; {     \\\&quot;testExecutionKey\\\&quot;: \\\&quot;DEMO-1206\\\&quot;,     \\\&quot;tests\\\&quot; : [         {             \\\&quot;testKey\\\&quot; : \\\&quot;DEMO-6\\\&quot;,             \\\&quot;start\\\&quot; : \\\&quot;2014-08-30T11:47:35+01:00\\\&quot;,             \\\&quot;finish\\\&quot; : \\\&quot;2014-08-30T11:50:56+01:00\\\&quot;,             \\\&quot;comment\\\&quot; : \\\&quot;Successful execution\\\&quot;,             \\\&quot;status\\\&quot; : \\\&quot;PASS\\\&quot;         }      ] } &#x60;&#x60;&#x60; &lt;/details&gt;   |
 **info** | **File**| Should follow the same format as the \\\&quot;fields\\\&quot; part, described in the [official Jira REST API](https://docs.atlassian.com/software/jira/docs/api/REST/latest/#api/2/issue-createIssue). This file **must** be of type &#x60;application/json&#x60;.  &lt;details&gt; &lt;summary&gt;Example 1 (Fields for a new Test Execution)&lt;/summary&gt;  &#x60;&#x60;&#x60; {     \\\&quot;fields\\\&quot;: {         \\\&quot;project\\\&quot;: {             \\\&quot;id\\\&quot;: \\\&quot;10402\\\&quot;         },         \\\&quot;summary\\\&quot;: \\\&quot;Brand new Test execution\\\&quot;,         \\\&quot;issuetype\\\&quot;: {             \\\&quot;id\\\&quot;: \\\&quot;10007\\\&quot;         },         \\\&quot;components\\\&quot; : [             {             \\\&quot;name\\\&quot;:\\\&quot;Interface\\\&quot;             },             {             \\\&quot;name\\\&quot;:\\\&quot;Core\\\&quot;             }         ],         \\\&quot;customfield_10032\\\&quot; : [             \\\&quot;TES-38\\\&quot;         ]     } } &#x60;&#x60;&#x60; &lt;/details&gt;  &lt;details&gt; &lt;summary&gt;Example 2 (Fields for updating a Test Execution)&lt;/summary&gt;  &#x60;&#x60;&#x60; {     \\\&quot;fields\\\&quot;: {         \\\&quot;customfield_10032\\\&quot; : [             \\\&quot;a_label\\\&quot;         ],         \\\&quot;description\\\&quot;: \\\&quot;update the issue description\\\&quot;     } } &#x60;&#x60;&#x60;  &lt;/details&gt;   |

### Return type

[**RestApiSuccessResponse**](RestApiSuccessResponse.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Successful operation |  -  |
**400** | Bad Request |  -  |

