# IntegrationSettingsApi

All URIs are relative to *https://apitryout.qtestnet.com/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addNewConnection**](IntegrationSettingsApi.md#addNewConnection) | **POST** /api/v3/projects/{projectId}/settings/integration/connections | Add a new Jira connection
[**addNewDefectMapping**](IntegrationSettingsApi.md#addNewDefectMapping) | **POST** /api/v3/projects/{projectId}/settings/integration/connections/{connectionId}/defect/mappings | Add a defect mapping to a Jira connection
[**addNewReleaseMapping**](IntegrationSettingsApi.md#addNewReleaseMapping) | **POST** /api/v3/projects/{projectId}/settings/integration/connections/{connectionId}/release/mappings | Add a new Jira release mapping to a Jira connection
[**addNewRequirementMapping**](IntegrationSettingsApi.md#addNewRequirementMapping) | **POST** /api/v3/projects/{projectId}/settings/integration/connections/{connectionId}/requirement/mappings | Add a requirement mapping to a Jira connection
[**configurePopulatingJiraUnlinkedDefects**](IntegrationSettingsApi.md#configurePopulatingJiraUnlinkedDefects) | **PUT** /api/v3/projects/{projectId}/settings/integration/connections/{connectionId}/defect | Enable or disable populating Jira Unlinked Defects of a Jira connection
[**configureReleaseMapping**](IntegrationSettingsApi.md#configureReleaseMapping) | **PUT** /api/v3/projects/{projectId}/settings/integration/connections/{connectionId}/release/mappings | Update a Release Mapping of a Jira connection
[**configureRequirementMapping**](IntegrationSettingsApi.md#configureRequirementMapping) | **PUT** /api/v3/projects/{projectId}/settings/integration/connections/{connectionId}/requirement/mappings | Update a requirement mapping of a Jira connection
[**deleteConnection**](IntegrationSettingsApi.md#deleteConnection) | **DELETE** /api/v3/projects/{projectId}/settings/integration/connections/{connectionId} | Delete a Jira connection
[**getAuthorizeURL**](IntegrationSettingsApi.md#getAuthorizeURL) | **GET** /api/v3/projects/{projectId}/settings/integration/connections/oauthAuthorizeURL | OAuth Authorize URL
[**getConnections**](IntegrationSettingsApi.md#getConnections) | **GET** /api/v3/projects/{projectId}/settings/integration/connections | Get all Jira connections of a project
[**getDefectMappings**](IntegrationSettingsApi.md#getDefectMappings) | **GET** /api/v3/projects/{projectId}/settings/integration/connections/{connectionId}/defect/mappings | Get Jira defect mappings of a Jira connection
[**getReleaseMappings**](IntegrationSettingsApi.md#getReleaseMappings) | **GET** /api/v3/projects/{projectId}/settings/integration/connections/{connectionId}/release/mappings | Get Jira release mappings of a Jira connection
[**refreshFieldSettings**](IntegrationSettingsApi.md#refreshFieldSettings) | **POST** /api/v3/projects/{projectId}/settings/integration/connections/{connectionId}/refreshFieldSettings | Trigger retrieving latest field settings from a JIRA connection
[**removeMapping**](IntegrationSettingsApi.md#removeMapping) | **DELETE** /api/v3/projects/{projectId}/settings/integration/connections/{connectionId}/{artifact}/mappings | Remove a Mapping of a Jira connection
[**retrieveAllRequirementMappingsOfConnection**](IntegrationSettingsApi.md#retrieveAllRequirementMappingsOfConnection) | **GET** /api/v3/projects/{projectId}/settings/integration/connections/{connectionId}/requirement/mappings | Get requirement mappings of a Jira connection
[**toggleReleaseIntegration**](IntegrationSettingsApi.md#toggleReleaseIntegration) | **PUT** /api/v3/projects/{projectId}/settings/integration/connections/{connectionId}/release | Enable or disable Release Integration feature of a Jira connection
[**toggleRequirementIntegration**](IntegrationSettingsApi.md#toggleRequirementIntegration) | **PUT** /api/v3/projects/{projectId}/settings/integration/connections/{connectionId}/requirement | Enable or disable a Requirement Integration feature of a Jira connection
[**triggerRetrievingDataForConnection**](IntegrationSettingsApi.md#triggerRetrievingDataForConnection) | **GET** /api/v3/projects/{projectId}/settings/integration/connections/{connectionId}/retrieve | Trigger data retrieval from an integrated Jira system
[**triggerRetrievingDefectDataForConnection**](IntegrationSettingsApi.md#triggerRetrievingDefectDataForConnection) | **POST** /api/v3/projects/{projectId}/settings/jira-integration/defect/retrieve | Trigger defect retrieval from an integrated Jira system
[**updateDefectMapping**](IntegrationSettingsApi.md#updateDefectMapping) | **PUT** /api/v3/projects/{projectId}/settings/integration/connections/{connectionId}/defect/mappings | Update a defect mapping of Jira connection
[**updateIntegrationConnectionStatus**](IntegrationSettingsApi.md#updateIntegrationConnectionStatus) | **PUT** /api/v3/projects/{projectId}/settings/integration/connections/{connectionId} | Activate or deactivate a Jira connection


<a name="addNewConnection"></a>
# **addNewConnection**
> NewIntegrationConnectionInfo addNewConnection(projectId, body)

Add a new Jira connection

Add a new Jira connection  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 9.7+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.IntegrationSettingsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

IntegrationSettingsApi apiInstance = new IntegrationSettingsApi();
Long projectId = 789L; // Long | ID of the project
IntegrationConnection body = new IntegrationConnection(); // IntegrationConnection | <em>external_system (required):</em> Input <em>Jira</em>  <em>connection_name (required):</em> Name of connection  <em>server_url (required):</em> your Jira server URL  <em>web_url:</em> Your Jira web URL (for Jira server only)  <em>authentication_type (required):</em> Input <em>Token</em> if you are using password or API token, or <em>OAuth</em> if you are using Jira OAuth for authentication  <em>username:</em> If <em>authentication_type=Token</em>, then input your Jira username. If <em>authentication_type=OAuth</em>, then input <em>apikey</em>  <em>password:</em> Input your Jira password or API token (only required if <em>authentication_type=Token</em>)  <em>jiraToken, jiraSecret</em> and <em>jiraVerifier</em> these are required if authentication_type=Oauth. You will need to use our API to <em>Get OAuth Authorize URL</em> described below to retrieve values for these fields.
try {
    NewIntegrationConnectionInfo result = apiInstance.addNewConnection(projectId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling IntegrationSettingsApi#addNewConnection");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **body** | [**IntegrationConnection**](IntegrationConnection.md)| &lt;em&gt;external_system (required):&lt;/em&gt; Input &lt;em&gt;Jira&lt;/em&gt;  &lt;em&gt;connection_name (required):&lt;/em&gt; Name of connection  &lt;em&gt;server_url (required):&lt;/em&gt; your Jira server URL  &lt;em&gt;web_url:&lt;/em&gt; Your Jira web URL (for Jira server only)  &lt;em&gt;authentication_type (required):&lt;/em&gt; Input &lt;em&gt;Token&lt;/em&gt; if you are using password or API token, or &lt;em&gt;OAuth&lt;/em&gt; if you are using Jira OAuth for authentication  &lt;em&gt;username:&lt;/em&gt; If &lt;em&gt;authentication_type&#x3D;Token&lt;/em&gt;, then input your Jira username. If &lt;em&gt;authentication_type&#x3D;OAuth&lt;/em&gt;, then input &lt;em&gt;apikey&lt;/em&gt;  &lt;em&gt;password:&lt;/em&gt; Input your Jira password or API token (only required if &lt;em&gt;authentication_type&#x3D;Token&lt;/em&gt;)  &lt;em&gt;jiraToken, jiraSecret&lt;/em&gt; and &lt;em&gt;jiraVerifier&lt;/em&gt; these are required if authentication_type&#x3D;Oauth. You will need to use our API to &lt;em&gt;Get OAuth Authorize URL&lt;/em&gt; described below to retrieve values for these fields. |

### Return type

[**NewIntegrationConnectionInfo**](NewIntegrationConnectionInfo.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="addNewDefectMapping"></a>
# **addNewDefectMapping**
> IntegrationAutoFillMappingVM addNewDefectMapping(projectId, connectionId, externalProjectId, externalIssueTypeId)

Add a defect mapping to a Jira connection

Add a defect mapping to a Jira connection  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 9.7+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.IntegrationSettingsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

IntegrationSettingsApi apiInstance = new IntegrationSettingsApi();
Long projectId = 789L; // Long | ID of the project
Long connectionId = 789L; // Long | ID of the Jira connection
String externalProjectId = "externalProjectId_example"; // String | ID of a Jira project. Use this to retrieve mappings with this Jira project only
String externalIssueTypeId = "externalIssueTypeId_example"; // String | ID of a Jira issue type. Use this to retrieve mappings with this Jira issue type only
try {
    IntegrationAutoFillMappingVM result = apiInstance.addNewDefectMapping(projectId, connectionId, externalProjectId, externalIssueTypeId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling IntegrationSettingsApi#addNewDefectMapping");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **connectionId** | **Long**| ID of the Jira connection |
 **externalProjectId** | **String**| ID of a Jira project. Use this to retrieve mappings with this Jira project only |
 **externalIssueTypeId** | **String**| ID of a Jira issue type. Use this to retrieve mappings with this Jira issue type only |

### Return type

[**IntegrationAutoFillMappingVM**](IntegrationAutoFillMappingVM.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="addNewReleaseMapping"></a>
# **addNewReleaseMapping**
> IntegrationReleaseMappingResponse addNewReleaseMapping(projectId, connectionId, externalProjectId, externalIssueTypeId)

Add a new Jira release mapping to a Jira connection

Add a new Jira release mapping to a Jira connection.   &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 9.7+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.IntegrationSettingsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

IntegrationSettingsApi apiInstance = new IntegrationSettingsApi();
Long projectId = 789L; // Long | ID of the project
Long connectionId = 789L; // Long | ID of the Jira connection
String externalProjectId = "externalProjectId_example"; // String | ID of a Jira project. You will need to make API calls to Jira to get its project IDs
String externalIssueTypeId = "externalIssueTypeId_example"; // String | valid values include: fixVersions, Sprint (<strong>case-sensitive</strong>)
try {
    IntegrationReleaseMappingResponse result = apiInstance.addNewReleaseMapping(projectId, connectionId, externalProjectId, externalIssueTypeId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling IntegrationSettingsApi#addNewReleaseMapping");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **connectionId** | **Long**| ID of the Jira connection |
 **externalProjectId** | **String**| ID of a Jira project. You will need to make API calls to Jira to get its project IDs |
 **externalIssueTypeId** | **String**| valid values include: fixVersions, Sprint (&lt;strong&gt;case-sensitive&lt;/strong&gt;) |

### Return type

[**IntegrationReleaseMappingResponse**](IntegrationReleaseMappingResponse.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="addNewRequirementMapping"></a>
# **addNewRequirementMapping**
> RequirementMapping addNewRequirementMapping(projectId, connectionId, externalProjectId, externalIssueTypeId)

Add a requirement mapping to a Jira connection

Add a requirement mapping to a Jira connection  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 9.7+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.IntegrationSettingsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

IntegrationSettingsApi apiInstance = new IntegrationSettingsApi();
Long projectId = 789L; // Long | ID of the project
Long connectionId = 789L; // Long | ID of the Jira connection
String externalProjectId = "externalProjectId_example"; // String | ID of a Jira project. You will need to make API calls to Jira to retrieve its project IDs
String externalIssueTypeId = "externalIssueTypeId_example"; // String | ID of a Jira issue type. You will need to make API calls to Jira to retrieve its issue type IDs
try {
    RequirementMapping result = apiInstance.addNewRequirementMapping(projectId, connectionId, externalProjectId, externalIssueTypeId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling IntegrationSettingsApi#addNewRequirementMapping");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **connectionId** | **Long**| ID of the Jira connection |
 **externalProjectId** | **String**| ID of a Jira project. You will need to make API calls to Jira to retrieve its project IDs |
 **externalIssueTypeId** | **String**| ID of a Jira issue type. You will need to make API calls to Jira to retrieve its issue type IDs |

### Return type

[**RequirementMapping**](RequirementMapping.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="configurePopulatingJiraUnlinkedDefects"></a>
# **configurePopulatingJiraUnlinkedDefects**
> configurePopulatingJiraUnlinkedDefects(projectId, connectionId, storeUnlinkedDefects)

Enable or disable populating Jira Unlinked Defects of a Jira connection

Enable or disable populating Jira Unlinked Defects of a Jira connection  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 9.7+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.IntegrationSettingsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

IntegrationSettingsApi apiInstance = new IntegrationSettingsApi();
Long projectId = 789L; // Long | ID of the project
Long connectionId = 789L; // Long | ID of the Jira connection
String storeUnlinkedDefects = "storeUnlinkedDefects_example"; // String | Input <em>true</em> to populate unlinked Jira Defects, or <em>false</em> to disable this feature
try {
    apiInstance.configurePopulatingJiraUnlinkedDefects(projectId, connectionId, storeUnlinkedDefects);
} catch (ApiException e) {
    System.err.println("Exception when calling IntegrationSettingsApi#configurePopulatingJiraUnlinkedDefects");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **connectionId** | **Long**| ID of the Jira connection |
 **storeUnlinkedDefects** | **String**| Input &lt;em&gt;true&lt;/em&gt; to populate unlinked Jira Defects, or &lt;em&gt;false&lt;/em&gt; to disable this feature | [optional]

### Return type

null (empty response body)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="configureReleaseMapping"></a>
# **configureReleaseMapping**
> IntegrationReleaseMappingResponse configureReleaseMapping(projectId, connectionId, externalProjectId, externalIssueTypeId, body)

Update a Release Mapping of a Jira connection

To configure a Release Mapping of a Jira connection.   &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 9.7+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.IntegrationSettingsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

IntegrationSettingsApi apiInstance = new IntegrationSettingsApi();
Long projectId = 789L; // Long | ID of the project
Long connectionId = 789L; // Long | ID of the Jira connection
String externalProjectId = "externalProjectId_example"; // String | ID of a Jira project
String externalIssueTypeId = "externalIssueTypeId_example"; // String | valid values include: fixVersions, Sprint (<strong>case-sensitive</strong>)   externalProjectId and externalIssueTypeId are used to identify a release mapping and cannot be modified
IntegrationReleaseConfigurationVM body = new IntegrationReleaseConfigurationVM(); // IntegrationReleaseConfigurationVM | <em>data_retrieval_options:</em> If <em>externalIssueTypeId=fixVersions</em>, valid values include: <strong>released, unreleased</strong>. If <em>externalIssueTypeId=fixVersions</em>, valid values include: <strong>active, future, completed</strong>  <em>auto_update_release_scope:</em> Select to automatically update scope of imported Releases in qTest. Valid values include: <b>True, False</b>
try {
    IntegrationReleaseMappingResponse result = apiInstance.configureReleaseMapping(projectId, connectionId, externalProjectId, externalIssueTypeId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling IntegrationSettingsApi#configureReleaseMapping");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **connectionId** | **Long**| ID of the Jira connection |
 **externalProjectId** | **String**| ID of a Jira project |
 **externalIssueTypeId** | **String**| valid values include: fixVersions, Sprint (&lt;strong&gt;case-sensitive&lt;/strong&gt;)   externalProjectId and externalIssueTypeId are used to identify a release mapping and cannot be modified |
 **body** | [**IntegrationReleaseConfigurationVM**](IntegrationReleaseConfigurationVM.md)| &lt;em&gt;data_retrieval_options:&lt;/em&gt; If &lt;em&gt;externalIssueTypeId&#x3D;fixVersions&lt;/em&gt;, valid values include: &lt;strong&gt;released, unreleased&lt;/strong&gt;. If &lt;em&gt;externalIssueTypeId&#x3D;fixVersions&lt;/em&gt;, valid values include: &lt;strong&gt;active, future, completed&lt;/strong&gt;  &lt;em&gt;auto_update_release_scope:&lt;/em&gt; Select to automatically update scope of imported Releases in qTest. Valid values include: &lt;b&gt;True, False&lt;/b&gt; |

### Return type

[**IntegrationReleaseMappingResponse**](IntegrationReleaseMappingResponse.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="configureRequirementMapping"></a>
# **configureRequirementMapping**
> RequirementMapping configureRequirementMapping(projectId, connectionId, externalProjectId, externalIssueTypeId, body)

Update a requirement mapping of a Jira connection

To configure a requirement mapping of a Jira connection  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 9.7+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.IntegrationSettingsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

IntegrationSettingsApi apiInstance = new IntegrationSettingsApi();
Long projectId = 789L; // Long | ID of the project
Long connectionId = 789L; // Long | ID of the Jira connection
String externalProjectId = "externalProjectId_example"; // String | ID of a Jira project
String externalIssueTypeId = "externalIssueTypeId_example"; // String | ID of a Jira issue type   externalProjectId and externalIssueTypeId are used to identify a release mapping and cannot be modified
RequirementMapping body = new RequirementMapping(); // RequirementMapping | <em>external_filter:</em> ID of a Jira filter whose Jira issues will be imported to qTest as Requirements.  <em>external_field_1_id</em> and <em>external_field_2_id:</em> <strong>Jira keys</strong> of 2 Jira fields that are used to organize imported Requirements  <em>active_external_fields:</em> <em>Jira keys</em> of Jira fields that will show up in qTest requirement page (Jira read-only properties panel). You can specify a list of Jira fields, <em>separated by comma without a following space</em>
try {
    RequirementMapping result = apiInstance.configureRequirementMapping(projectId, connectionId, externalProjectId, externalIssueTypeId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling IntegrationSettingsApi#configureRequirementMapping");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **connectionId** | **Long**| ID of the Jira connection |
 **externalProjectId** | **String**| ID of a Jira project |
 **externalIssueTypeId** | **String**| ID of a Jira issue type   externalProjectId and externalIssueTypeId are used to identify a release mapping and cannot be modified |
 **body** | [**RequirementMapping**](RequirementMapping.md)| &lt;em&gt;external_filter:&lt;/em&gt; ID of a Jira filter whose Jira issues will be imported to qTest as Requirements.  &lt;em&gt;external_field_1_id&lt;/em&gt; and &lt;em&gt;external_field_2_id:&lt;/em&gt; &lt;strong&gt;Jira keys&lt;/strong&gt; of 2 Jira fields that are used to organize imported Requirements  &lt;em&gt;active_external_fields:&lt;/em&gt; &lt;em&gt;Jira keys&lt;/em&gt; of Jira fields that will show up in qTest requirement page (Jira read-only properties panel). You can specify a list of Jira fields, &lt;em&gt;separated by comma without a following space&lt;/em&gt; |

### Return type

[**RequirementMapping**](RequirementMapping.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="deleteConnection"></a>
# **deleteConnection**
> deleteConnection(projectId, connectionId)

Delete a Jira connection

Delete a Jira connection  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 9.7+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.IntegrationSettingsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

IntegrationSettingsApi apiInstance = new IntegrationSettingsApi();
Long projectId = 789L; // Long | ID of the project
Long connectionId = 789L; // Long | ID of the Jira connection
try {
    apiInstance.deleteConnection(projectId, connectionId);
} catch (ApiException e) {
    System.err.println("Exception when calling IntegrationSettingsApi#deleteConnection");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **connectionId** | **Long**| ID of the Jira connection |

### Return type

null (empty response body)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getAuthorizeURL"></a>
# **getAuthorizeURL**
> TokenSecretVerifierHolder getAuthorizeURL(projectId, serverUrl)

OAuth Authorize URL

OAuth Authorize URL (for Jira Server or DC only).  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 9.7+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.IntegrationSettingsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

IntegrationSettingsApi apiInstance = new IntegrationSettingsApi();
Long projectId = 789L; // Long | this must be 0 (zero)
String serverUrl = "serverUrl_example"; // String | your Jira's Server URL
try {
    TokenSecretVerifierHolder result = apiInstance.getAuthorizeURL(projectId, serverUrl);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling IntegrationSettingsApi#getAuthorizeURL");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| this must be 0 (zero) |
 **serverUrl** | **String**| your Jira&#39;s Server URL |

### Return type

[**TokenSecretVerifierHolder**](TokenSecretVerifierHolder.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getConnections"></a>
# **getConnections**
> IntegrationConnectionVM getConnections(projectId)

Get all Jira connections of a project

Get all Jira connections of a project  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 9.7+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.IntegrationSettingsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

IntegrationSettingsApi apiInstance = new IntegrationSettingsApi();
Long projectId = 789L; // Long | ID of the project
try {
    IntegrationConnectionVM result = apiInstance.getConnections(projectId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling IntegrationSettingsApi#getConnections");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |

### Return type

[**IntegrationConnectionVM**](IntegrationConnectionVM.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getDefectMappings"></a>
# **getDefectMappings**
> IntegrationAutoFillMappingVM getDefectMappings(projectId, connectionId, externalProjectId, externalIssueTypeId)

Get Jira defect mappings of a Jira connection

Get Jira defect mappings of a Jira connection  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 9.7+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.IntegrationSettingsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

IntegrationSettingsApi apiInstance = new IntegrationSettingsApi();
Long projectId = 789L; // Long | ID of the project
Long connectionId = 789L; // Long | ID of the Jira connection
String externalProjectId = "externalProjectId_example"; // String | ID of a Jira project. Use this to retrieve mappings with this Jira project only
String externalIssueTypeId = "externalIssueTypeId_example"; // String | ID of a Jira issue type. Use this to retrieve mappings with this Jira issue type
try {
    IntegrationAutoFillMappingVM result = apiInstance.getDefectMappings(projectId, connectionId, externalProjectId, externalIssueTypeId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling IntegrationSettingsApi#getDefectMappings");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **connectionId** | **Long**| ID of the Jira connection |
 **externalProjectId** | **String**| ID of a Jira project. Use this to retrieve mappings with this Jira project only | [optional]
 **externalIssueTypeId** | **String**| ID of a Jira issue type. Use this to retrieve mappings with this Jira issue type | [optional]

### Return type

[**IntegrationAutoFillMappingVM**](IntegrationAutoFillMappingVM.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getReleaseMappings"></a>
# **getReleaseMappings**
> List&lt;IntegrationReleaseMappingResponse&gt; getReleaseMappings(projectId, connectionId, externalProjectId, externalIssueTypeId)

Get Jira release mappings of a Jira connection

Get Jira release mappings of a Jira connection  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 9.7+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.IntegrationSettingsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

IntegrationSettingsApi apiInstance = new IntegrationSettingsApi();
Long projectId = 789L; // Long | ID of the project
Long connectionId = 789L; // Long | ID of the Jira connection
String externalProjectId = "externalProjectId_example"; // String | ID of a Jira project. Use this to retrieve mappings with this Jira project only
String externalIssueTypeId = "externalIssueTypeId_example"; // String | Valid values include: fixVersions, Sprint (<strong>case-sensitive</strong>)
try {
    List<IntegrationReleaseMappingResponse> result = apiInstance.getReleaseMappings(projectId, connectionId, externalProjectId, externalIssueTypeId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling IntegrationSettingsApi#getReleaseMappings");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **connectionId** | **Long**| ID of the Jira connection |
 **externalProjectId** | **String**| ID of a Jira project. Use this to retrieve mappings with this Jira project only | [optional]
 **externalIssueTypeId** | **String**| Valid values include: fixVersions, Sprint (&lt;strong&gt;case-sensitive&lt;/strong&gt;) | [optional]

### Return type

[**List&lt;IntegrationReleaseMappingResponse&gt;**](IntegrationReleaseMappingResponse.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="refreshFieldSettings"></a>
# **refreshFieldSettings**
> List&lt;IntegrationFieldMapVM&gt; refreshFieldSettings(projectId, connectionId, artifact, mappingId)

Trigger retrieving latest field settings from a JIRA connection

Trigger retrieving the latest Defects/Requirements field settings from Jira  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 9.7+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.IntegrationSettingsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

IntegrationSettingsApi apiInstance = new IntegrationSettingsApi();
Long projectId = 789L; // Long | ID of the project
Long connectionId = 789L; // Long | ID of the Jira connection
String artifact = "artifact_example"; // String | Single value. Valid values include: <b>Defects, Requirements</b>
Long mappingId = 789L; // Long | ID of the mapping. Only required if <em>artifact=Requirements<em>
try {
    List<IntegrationFieldMapVM> result = apiInstance.refreshFieldSettings(projectId, connectionId, artifact, mappingId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling IntegrationSettingsApi#refreshFieldSettings");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **connectionId** | **Long**| ID of the Jira connection |
 **artifact** | **String**| Single value. Valid values include: &lt;b&gt;Defects, Requirements&lt;/b&gt; |
 **mappingId** | **Long**| ID of the mapping. Only required if &lt;em&gt;artifact&#x3D;Requirements&lt;em&gt; | [optional]

### Return type

[**List&lt;IntegrationFieldMapVM&gt;**](IntegrationFieldMapVM.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="removeMapping"></a>
# **removeMapping**
> removeMapping(projectId, connectionId, artifact, externalProjectId, externalIssueTypeId)

Remove a Mapping of a Jira connection

Remove a Mapping of a Jira connection  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 9.7+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.IntegrationSettingsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

IntegrationSettingsApi apiInstance = new IntegrationSettingsApi();
Long projectId = 789L; // Long | ID of the project
Long connectionId = 789L; // Long | ID of the Jira connection
String artifact = "artifact_example"; // String | Valid values can be: <b>Defect, Requirement, Release</b>
String externalProjectId = "externalProjectId_example"; // String | ID of a Jira project
String externalIssueTypeId = "externalIssueTypeId_example"; // String | ID of a Jira issue type.    externalProjectId and externalIssueTypeId are used to identify a mapping
try {
    apiInstance.removeMapping(projectId, connectionId, artifact, externalProjectId, externalIssueTypeId);
} catch (ApiException e) {
    System.err.println("Exception when calling IntegrationSettingsApi#removeMapping");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **connectionId** | **Long**| ID of the Jira connection |
 **artifact** | **String**| Valid values can be: &lt;b&gt;Defect, Requirement, Release&lt;/b&gt; |
 **externalProjectId** | **String**| ID of a Jira project |
 **externalIssueTypeId** | **String**| ID of a Jira issue type.    externalProjectId and externalIssueTypeId are used to identify a mapping |

### Return type

null (empty response body)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="retrieveAllRequirementMappingsOfConnection"></a>
# **retrieveAllRequirementMappingsOfConnection**
> List&lt;RequirementMapping&gt; retrieveAllRequirementMappingsOfConnection(projectId, connectionId, externalProjectId, externalIssueTypeId)

Get requirement mappings of a Jira connection

Get requirement mappings of a Jira connection  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 9.7+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.IntegrationSettingsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

IntegrationSettingsApi apiInstance = new IntegrationSettingsApi();
Long projectId = 789L; // Long | ID of the project
Long connectionId = 789L; // Long | ID of the Jira connection
String externalProjectId = "externalProjectId_example"; // String | ID of the Jira project. You will need to make API calls to Jira to get its project IDs
String externalIssueTypeId = "externalIssueTypeId_example"; // String | ID of the Jira issue type. You will need to make API calls to Jira to get its issue type IDs
try {
    List<RequirementMapping> result = apiInstance.retrieveAllRequirementMappingsOfConnection(projectId, connectionId, externalProjectId, externalIssueTypeId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling IntegrationSettingsApi#retrieveAllRequirementMappingsOfConnection");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **connectionId** | **Long**| ID of the Jira connection |
 **externalProjectId** | **String**| ID of the Jira project. You will need to make API calls to Jira to get its project IDs | [optional]
 **externalIssueTypeId** | **String**| ID of the Jira issue type. You will need to make API calls to Jira to get its issue type IDs | [optional]

### Return type

[**List&lt;RequirementMapping&gt;**](RequirementMapping.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="toggleReleaseIntegration"></a>
# **toggleReleaseIntegration**
> toggleReleaseIntegration(projectId, connectionId, active, autoFilterTestRun, mergeDuplicatedFixVersions)

Enable or disable Release Integration feature of a Jira connection

Enable or disable Release Integration feature  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 9.7+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.IntegrationSettingsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

IntegrationSettingsApi apiInstance = new IntegrationSettingsApi();
Long projectId = 789L; // Long | ID of the project
Long connectionId = 789L; // Long | ID of the Jira connection
String active = "active_example"; // String | Input <em>true</em> to enable Release integration, or <em>false</em> to disable it
String autoFilterTestRun = "autoFilterTestRun_example"; // String | select or deselect the checkbox <em>Auto-filter Test Runs on Jira iframe to match Fix Version/Sprint of Jira issue</em>. Valid values include: <b>True, False</b>
String mergeDuplicatedFixVersions = "mergeDuplicatedFixVersions_example"; // String | select or deselect the checkbox Merge all Jira Fix versions with existing qTest Releases that have the same name into a single Release and link to all Jira projects. Valid values include: <b>True, False</b>
try {
    apiInstance.toggleReleaseIntegration(projectId, connectionId, active, autoFilterTestRun, mergeDuplicatedFixVersions);
} catch (ApiException e) {
    System.err.println("Exception when calling IntegrationSettingsApi#toggleReleaseIntegration");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **connectionId** | **Long**| ID of the Jira connection |
 **active** | **String**| Input &lt;em&gt;true&lt;/em&gt; to enable Release integration, or &lt;em&gt;false&lt;/em&gt; to disable it | [optional]
 **autoFilterTestRun** | **String**| select or deselect the checkbox &lt;em&gt;Auto-filter Test Runs on Jira iframe to match Fix Version/Sprint of Jira issue&lt;/em&gt;. Valid values include: &lt;b&gt;True, False&lt;/b&gt; | [optional]
 **mergeDuplicatedFixVersions** | **String**| select or deselect the checkbox Merge all Jira Fix versions with existing qTest Releases that have the same name into a single Release and link to all Jira projects. Valid values include: &lt;b&gt;True, False&lt;/b&gt; | [optional]

### Return type

null (empty response body)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="toggleRequirementIntegration"></a>
# **toggleRequirementIntegration**
> toggleRequirementIntegration(projectId, connectionId, active)

Enable or disable a Requirement Integration feature of a Jira connection

Enable or disable a Requirement Integration feature of a Jira connection  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 9.7+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.IntegrationSettingsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

IntegrationSettingsApi apiInstance = new IntegrationSettingsApi();
Long projectId = 789L; // Long | ID of the project
Long connectionId = 789L; // Long | ID of the Jira connection
String active = "active_example"; // String | Input <em>true</em> to enable the feature, or <em>false</em> to disable it
try {
    apiInstance.toggleRequirementIntegration(projectId, connectionId, active);
} catch (ApiException e) {
    System.err.println("Exception when calling IntegrationSettingsApi#toggleRequirementIntegration");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **connectionId** | **Long**| ID of the Jira connection |
 **active** | **String**| Input &lt;em&gt;true&lt;/em&gt; to enable the feature, or &lt;em&gt;false&lt;/em&gt; to disable it | [optional]

### Return type

null (empty response body)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="triggerRetrievingDataForConnection"></a>
# **triggerRetrievingDataForConnection**
> QueueProcessingResponseFetchDataVM triggerRetrievingDataForConnection(projectId, connectionId, artifact)

Trigger data retrieval from an integrated Jira system

Trigger data retrieval from an integrated Jira system  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 9.7+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.IntegrationSettingsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

IntegrationSettingsApi apiInstance = new IntegrationSettingsApi();
Long projectId = 789L; // Long | ID of the project
Long connectionId = 789L; // Long | ID of the Jira connection
String artifact = "artifact_example"; // String | Valid values include: <b>Defects, Requirements, Releases</b>
try {
    QueueProcessingResponseFetchDataVM result = apiInstance.triggerRetrievingDataForConnection(projectId, connectionId, artifact);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling IntegrationSettingsApi#triggerRetrievingDataForConnection");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **connectionId** | **Long**| ID of the Jira connection |
 **artifact** | **String**| Valid values include: &lt;b&gt;Defects, Requirements, Releases&lt;/b&gt; |

### Return type

[**QueueProcessingResponseFetchDataVM**](QueueProcessingResponseFetchDataVM.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="triggerRetrievingDefectDataForConnection"></a>
# **triggerRetrievingDefectDataForConnection**
> QueueProcessingResponse triggerRetrievingDefectDataForConnection(projectId, body)

Trigger defect retrieval from an integrated Jira system



### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.IntegrationSettingsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

IntegrationSettingsApi apiInstance = new IntegrationSettingsApi();
Long projectId = 789L; // Long | ID of the project
List<String> body = Arrays.asList(new List<String>()); // List<String> | PID of Jira defects
try {
    QueueProcessingResponse result = apiInstance.triggerRetrievingDefectDataForConnection(projectId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling IntegrationSettingsApi#triggerRetrievingDefectDataForConnection");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **body** | **List&lt;String&gt;**| PID of Jira defects |

### Return type

[**QueueProcessingResponse**](QueueProcessingResponse.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="updateDefectMapping"></a>
# **updateDefectMapping**
> IntegrationAutoFillMappingVM updateDefectMapping(projectId, connectionId, externalProjectId, externalIssueTypeId, body)

Update a defect mapping of Jira connection

Update a defect mapping of Jira connection  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 9.7+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.IntegrationSettingsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

IntegrationSettingsApi apiInstance = new IntegrationSettingsApi();
Long projectId = 789L; // Long | ID of the project
Long connectionId = 789L; // Long | ID of the Jira connection
String externalProjectId = "externalProjectId_example"; // String | ID of a Jira project
String externalIssueTypeId = "externalIssueTypeId_example"; // String | ID of the Jira issue type   externalProjectId and externalIssueTypeId are used to identify a defect mapping and cannot be modified
IntegrationAutoFillMappingVM body = new IntegrationAutoFillMappingVM(); // IntegrationAutoFillMappingVM | <em>sendAttachmentToJira:</em> send test log and test step log attachments to linked Jira Defects. Valid values include: <b>True, False</b>  <em>configures:</em> Auto filling configuration for Defect submission to Jira. This is an array of JSON objects each of which consists of a Jira field Id (<em>externalFieldId</em>) and qTest fields (<em>qTestFieldIds</em>) to be auto filled to the Jira field<ul><li>You can only config auto fill for Jira text typed fields</li><li>You can auto fill multiple qTest fields to one Jira fields. Use <strong>comma without a following space</strong> to separate the fields</li><li>These following qTest fields can be configured to be auto filled to Jira fields (use these field names exactly as mentioned below instead of their IDs in qTestFieldIds): <em>Assigned To, Description, Environment, Execution Type, Planned End, Planned Start, Submitter, Target Release/Build, Test Case Version, Test Data Source, Name, Precondition, Test Case Description, Session URL, Session Description, Session Environment, Test Run URL</em></li></ul>
try {
    IntegrationAutoFillMappingVM result = apiInstance.updateDefectMapping(projectId, connectionId, externalProjectId, externalIssueTypeId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling IntegrationSettingsApi#updateDefectMapping");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **connectionId** | **Long**| ID of the Jira connection |
 **externalProjectId** | **String**| ID of a Jira project |
 **externalIssueTypeId** | **String**| ID of the Jira issue type   externalProjectId and externalIssueTypeId are used to identify a defect mapping and cannot be modified |
 **body** | [**IntegrationAutoFillMappingVM**](IntegrationAutoFillMappingVM.md)| &lt;em&gt;sendAttachmentToJira:&lt;/em&gt; send test log and test step log attachments to linked Jira Defects. Valid values include: &lt;b&gt;True, False&lt;/b&gt;  &lt;em&gt;configures:&lt;/em&gt; Auto filling configuration for Defect submission to Jira. This is an array of JSON objects each of which consists of a Jira field Id (&lt;em&gt;externalFieldId&lt;/em&gt;) and qTest fields (&lt;em&gt;qTestFieldIds&lt;/em&gt;) to be auto filled to the Jira field&lt;ul&gt;&lt;li&gt;You can only config auto fill for Jira text typed fields&lt;/li&gt;&lt;li&gt;You can auto fill multiple qTest fields to one Jira fields. Use &lt;strong&gt;comma without a following space&lt;/strong&gt; to separate the fields&lt;/li&gt;&lt;li&gt;These following qTest fields can be configured to be auto filled to Jira fields (use these field names exactly as mentioned below instead of their IDs in qTestFieldIds): &lt;em&gt;Assigned To, Description, Environment, Execution Type, Planned End, Planned Start, Submitter, Target Release/Build, Test Case Version, Test Data Source, Name, Precondition, Test Case Description, Session URL, Session Description, Session Environment, Test Run URL&lt;/em&gt;&lt;/li&gt;&lt;/ul&gt; |

### Return type

[**IntegrationAutoFillMappingVM**](IntegrationAutoFillMappingVM.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="updateIntegrationConnectionStatus"></a>
# **updateIntegrationConnectionStatus**
> updateIntegrationConnectionStatus(projectId, connectionId, active)

Activate or deactivate a Jira connection

Activate or deactivate a Jira connection  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 9.7+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.IntegrationSettingsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

IntegrationSettingsApi apiInstance = new IntegrationSettingsApi();
Long projectId = 789L; // Long | ID of the project
Long connectionId = 789L; // Long | ID of the Jira connection
String active = "active_example"; // String | Input <em>true</em> to activate a connection, or <em>false</em> to deactivate it
try {
    apiInstance.updateIntegrationConnectionStatus(projectId, connectionId, active);
} catch (ApiException e) {
    System.err.println("Exception when calling IntegrationSettingsApi#updateIntegrationConnectionStatus");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **connectionId** | **Long**| ID of the Jira connection |
 **active** | **String**| Input &lt;em&gt;true&lt;/em&gt; to activate a connection, or &lt;em&gt;false&lt;/em&gt; to deactivate it |

### Return type

null (empty response body)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

