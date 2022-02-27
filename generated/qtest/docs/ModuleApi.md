# ModuleApi

All URIs are relative to *https://apitryout.qtestnet.com/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createModule**](ModuleApi.md#createModule) | **POST** /api/v3/projects/{projectId}/modules | Creates a Module
[**deleteModule**](ModuleApi.md#deleteModule) | **DELETE** /api/v3/projects/{projectId}/modules/{moduleId} | Deletes a Module
[**getModule**](ModuleApi.md#getModule) | **GET** /api/v3/projects/{projectId}/modules/{moduleId} | Gets a Module
[**getSubModulesOf**](ModuleApi.md#getSubModulesOf) | **GET** /api/v3/projects/{projectId}/modules | Gets multiple Modules
[**updateModule**](ModuleApi.md#updateModule) | **PUT** /api/v3/projects/{projectId}/modules/{moduleId} | Updates a Module


<a name="createModule"></a>
# **createModule**
> ModuleResource createModule(projectId, body, parentId)

Creates a Module

To create a Module under root or a sub-Module under a parent Module  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 4+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ModuleApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

ModuleApi apiInstance = new ModuleApi();
Long projectId = 789L; // Long | ID of the project
ModuleResource body = new ModuleResource(); // ModuleResource | <em>name (required):</em> the Module name  <em>shared:</em> Specify <em>shared=true</em> to share this Module to other projects. Only use it if Test Case Sharing feature is enabled in your project  <em>tosca_guid</em>: Tosca folder GUID. Use for creating Module and link with Tosca folder. This property must be provided along with <em>tosca_node_path</em>, or it will fail to create module.  <em>tosca_node_path</em>: Tosca folder node path. Use for creating Module and link with Tosca folder. This property must be provided along with <em>tosca_guid</em>, or it will fail to create module.
Long parentId = 789L; // Long | The parent Module which will contain the newly created one. If it is not specified, the newly created module is located under root  Use this parameter if your qTest Manager version is 6+. For older versions, use <em>parent_id</em> in the request body
try {
    ModuleResource result = apiInstance.createModule(projectId, body, parentId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ModuleApi#createModule");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **body** | [**ModuleResource**](ModuleResource.md)| &lt;em&gt;name (required):&lt;/em&gt; the Module name  &lt;em&gt;shared:&lt;/em&gt; Specify &lt;em&gt;shared&#x3D;true&lt;/em&gt; to share this Module to other projects. Only use it if Test Case Sharing feature is enabled in your project  &lt;em&gt;tosca_guid&lt;/em&gt;: Tosca folder GUID. Use for creating Module and link with Tosca folder. This property must be provided along with &lt;em&gt;tosca_node_path&lt;/em&gt;, or it will fail to create module.  &lt;em&gt;tosca_node_path&lt;/em&gt;: Tosca folder node path. Use for creating Module and link with Tosca folder. This property must be provided along with &lt;em&gt;tosca_guid&lt;/em&gt;, or it will fail to create module. |
 **parentId** | **Long**| The parent Module which will contain the newly created one. If it is not specified, the newly created module is located under root  Use this parameter if your qTest Manager version is 6+. For older versions, use &lt;em&gt;parent_id&lt;/em&gt; in the request body | [optional]

### Return type

[**ModuleResource**](ModuleResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="deleteModule"></a>
# **deleteModule**
> Message deleteModule(projectId, moduleId, force)

Deletes a Module

To delete a Module  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 6+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ModuleApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

ModuleApi apiInstance = new ModuleApi();
Long projectId = 789L; // Long | ID of the project
Long moduleId = 789L; // Long | ID of Module to delete
Boolean force = true; // Boolean | <em>force=true</em> - delete the Module and its children  force=false - default value. Only delete the Module if it contains no sub Modules or Test Cases
try {
    Message result = apiInstance.deleteModule(projectId, moduleId, force);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ModuleApi#deleteModule");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **moduleId** | **Long**| ID of Module to delete |
 **force** | **Boolean**| &lt;em&gt;force&#x3D;true&lt;/em&gt; - delete the Module and its children  force&#x3D;false - default value. Only delete the Module if it contains no sub Modules or Test Cases | [optional]

### Return type

[**Message**](Message.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getModule"></a>
# **getModule**
> ModuleResource getModule(projectId, moduleId, expand)

Gets a Module

To retrieve a Module  &lt;em&gt;qTest Manager version:&lt;/em&gt; 6+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ModuleApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

ModuleApi apiInstance = new ModuleApi();
Long projectId = 789L; // Long | ID of the project
Long moduleId = 789L; // Long | ID of the Module
String expand = "expand_example"; // String | Specify <em>expand=descendants</em> to include the Module's sub and grand-sub Modules in the response
try {
    ModuleResource result = apiInstance.getModule(projectId, moduleId, expand);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ModuleApi#getModule");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **moduleId** | **Long**| ID of the Module |
 **expand** | **String**| Specify &lt;em&gt;expand&#x3D;descendants&lt;/em&gt; to include the Module&#39;s sub and grand-sub Modules in the response | [optional]

### Return type

[**ModuleResource**](ModuleResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getSubModulesOf"></a>
# **getSubModulesOf**
> List&lt;ModuleResource&gt; getSubModulesOf(projectId, parentId, search, expand)

Gets multiple Modules

To search for Modules under root or sub-Modules under a parent Module  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 6+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ModuleApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

ModuleApi apiInstance = new ModuleApi();
Long projectId = 789L; // Long | ID of the project
Long parentId = 789L; // Long | ID of the parent Module. Leave it blank to retrieve Modules under root
String search = "search_example"; // String | The free-text to search for Modules by names. You can utilize this parameter to search for Modules. Leave it blank to retrieve all Modules under root or the parent Module
String expand = "expand_example"; // String | 
try {
    List<ModuleResource> result = apiInstance.getSubModulesOf(projectId, parentId, search, expand);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ModuleApi#getSubModulesOf");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **parentId** | **Long**| ID of the parent Module. Leave it blank to retrieve Modules under root | [optional]
 **search** | **String**| The free-text to search for Modules by names. You can utilize this parameter to search for Modules. Leave it blank to retrieve all Modules under root or the parent Module | [optional]
 **expand** | **String**|  | [optional] [enum: descendants]

### Return type

[**List&lt;ModuleResource&gt;**](ModuleResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="updateModule"></a>
# **updateModule**
> ModuleResource updateModule(projectId, moduleId, body, parentId)

Updates a Module

To update a Module or move it to another parent Module

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ModuleApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

ModuleApi apiInstance = new ModuleApi();
Long projectId = 789L; // Long | ID of the project
Long moduleId = 789L; // Long | ID of the Module
ModuleResource body = new ModuleResource(); // ModuleResource | The Module's update properties
Long parentId = 789L; // Long | ID of the parent Module which the Module will be moved to  <strong>Important:</strong> If you use this parameter, the request body will be ignored. That means the Module is being moved but it will not be updated with the properties specified in the request body
try {
    ModuleResource result = apiInstance.updateModule(projectId, moduleId, body, parentId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ModuleApi#updateModule");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **moduleId** | **Long**| ID of the Module |
 **body** | [**ModuleResource**](ModuleResource.md)| The Module&#39;s update properties |
 **parentId** | **Long**| ID of the parent Module which the Module will be moved to  &lt;strong&gt;Important:&lt;/strong&gt; If you use this parameter, the request body will be ignored. That means the Module is being moved but it will not be updated with the properties specified in the request body | [optional]

### Return type

[**ModuleResource**](ModuleResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

