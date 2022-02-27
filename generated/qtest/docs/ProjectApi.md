# ProjectApi

All URIs are relative to *https://apitryout.qtestnet.com/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createProject**](ProjectApi.md#createProject) | **POST** /api/v3/projects | Creates a Project
[**getCurrentProfile**](ProjectApi.md#getCurrentProfile) | **GET** /api/v3/projects/{projectId}/user-profiles/current | Gets current user Permissions in a Project
[**getProject**](ProjectApi.md#getProject) | **GET** /api/v3/projects/{projectId} | Gets a Project
[**getProjects**](ProjectApi.md#getProjects) | **GET** /api/v3/projects | Gets multiple Projects
[**getUsers**](ProjectApi.md#getUsers) | **GET** /api/v3/projects/{projectId}/users | Gets all Users in a Project
[**searchProjects**](ProjectApi.md#searchProjects) | **POST** /api/v3/projects/search | Search for projects
[**updateProject**](ProjectApi.md#updateProject) | **PUT** /api/v3/projects/{projectId} | Updates a Project


<a name="createProject"></a>
# **createProject**
> ProjectResource createProject(body)

Creates a Project

To create a new Project  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 4+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ProjectApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

ProjectApi apiInstance = new ProjectApi();
ProjectResource body = new ProjectResource(); // ProjectResource | Project created properties   <em>name:</em> name of project  <em>description:</em> description of project  <em>status_id:</em> status of project  <em>start_date:</em> start date of project, eg: 2019-06-17T05:09:13.178Z  <em>end_date:</em> end date of project, eg: 2019-06-27T05:09:13.178Z  <em>admins:</em> list assigned admin of project  <em>template_id (optional):</em> valid site template id of project. After creating a project, the valid site template filed will be applied for it  <em>uuid (optional):</em> uuid of project. User can provide any string value for uuid, then they can used it for searching projects.
try {
    ProjectResource result = apiInstance.createProject(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectApi#createProject");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ProjectResource**](ProjectResource.md)| Project created properties   &lt;em&gt;name:&lt;/em&gt; name of project  &lt;em&gt;description:&lt;/em&gt; description of project  &lt;em&gt;status_id:&lt;/em&gt; status of project  &lt;em&gt;start_date:&lt;/em&gt; start date of project, eg: 2019-06-17T05:09:13.178Z  &lt;em&gt;end_date:&lt;/em&gt; end date of project, eg: 2019-06-27T05:09:13.178Z  &lt;em&gt;admins:&lt;/em&gt; list assigned admin of project  &lt;em&gt;template_id (optional):&lt;/em&gt; valid site template id of project. After creating a project, the valid site template filed will be applied for it  &lt;em&gt;uuid (optional):&lt;/em&gt; uuid of project. User can provide any string value for uuid, then they can used it for searching projects. |

### Return type

[**ProjectResource**](ProjectResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getCurrentProfile"></a>
# **getCurrentProfile**
> UserProfile getCurrentProfile(projectId)

Gets current user Permissions in a Project

To retrieve your Permissions in a Project  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 4+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ProjectApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

ProjectApi apiInstance = new ProjectApi();
Long projectId = 789L; // Long | ID of the project
try {
    UserProfile result = apiInstance.getCurrentProfile(projectId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectApi#getCurrentProfile");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |

### Return type

[**UserProfile**](UserProfile.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getProject"></a>
# **getProject**
> ProjectResource getProject(projectId, expand)

Gets a Project

To retrieve a specific Project

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ProjectApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

ProjectApi apiInstance = new ProjectApi();
Long projectId = 789L; // Long | ID of the project
String expand = "expand_example"; // String | <em>expand=userprofile</em> - include the your profile and permissions within the project in the response
try {
    ProjectResource result = apiInstance.getProject(projectId, expand);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectApi#getProject");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **expand** | **String**| &lt;em&gt;expand&#x3D;userprofile&lt;/em&gt; - include the your profile and permissions within the project in the response | [optional] [enum: userprofile]

### Return type

[**ProjectResource**](ProjectResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getProjects"></a>
# **getProjects**
> List&lt;ProjectResource&gt; getProjects(expand, assigned, page, pageSize)

Gets multiple Projects

To retrieve all Projects which the requested qTest  Manager account can access to  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 4+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ProjectApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

ProjectApi apiInstance = new ProjectApi();
String expand = "expand_example"; // String | <em>expand=userprofile</em> - to include your profile and permissions in each project
Boolean assigned = true; // Boolean | <em>assigned=true</em> - default value. Only the projects which the requested user has access to  <em>assigned=false</em> - Users with admin profile can use this value to retrieve all projects, regardless of having access
Long page = 1L; // Long | By default, all projects are returned; but you can specify any page number to retrieve objects
Long pageSize = 100L; // Long | The result is paginated. By the default, the number of objects in each page is 100 if this is omitted. You can specify your custom number (up to 999) in this parameter
try {
    List<ProjectResource> result = apiInstance.getProjects(expand, assigned, page, pageSize);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectApi#getProjects");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **expand** | **String**| &lt;em&gt;expand&#x3D;userprofile&lt;/em&gt; - to include your profile and permissions in each project | [optional] [enum: userprofile]
 **assigned** | **Boolean**| &lt;em&gt;assigned&#x3D;true&lt;/em&gt; - default value. Only the projects which the requested user has access to  &lt;em&gt;assigned&#x3D;false&lt;/em&gt; - Users with admin profile can use this value to retrieve all projects, regardless of having access | [optional]
 **page** | **Long**| By default, all projects are returned; but you can specify any page number to retrieve objects | [optional] [default to 1]
 **pageSize** | **Long**| The result is paginated. By the default, the number of objects in each page is 100 if this is omitted. You can specify your custom number (up to 999) in this parameter | [optional] [default to 100]

### Return type

[**List&lt;ProjectResource&gt;**](ProjectResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getUsers"></a>
# **getUsers**
> List&lt;UserResource&gt; getUsers(projectId, inactive)

Gets all Users in a Project

To retrieve all members in a qTest Manager Project  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 8.4.2+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ProjectApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

ProjectApi apiInstance = new ProjectApi();
Long projectId = 789L; // Long | ID of the project
Boolean inactive = true; // Boolean | <em>inactive=false</em> - default value. Inactive users are excluded from the response  <em>inactive=true</em> - inactive users are included in the response
try {
    List<UserResource> result = apiInstance.getUsers(projectId, inactive);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectApi#getUsers");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **inactive** | **Boolean**| &lt;em&gt;inactive&#x3D;false&lt;/em&gt; - default value. Inactive users are excluded from the response  &lt;em&gt;inactive&#x3D;true&lt;/em&gt; - inactive users are included in the response | [optional]

### Return type

[**List&lt;UserResource&gt;**](UserResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="searchProjects"></a>
# **searchProjects**
> List&lt;ProjectResource&gt; searchProjects(body)

Search for projects



### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ProjectApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

ProjectApi apiInstance = new ProjectApi();
ProjectQueryParams body = new ProjectQueryParams(); // ProjectQueryParams | Project search condition properties   <em>uuid:</em> list of uuid for searching
try {
    List<ProjectResource> result = apiInstance.searchProjects(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectApi#searchProjects");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ProjectQueryParams**](ProjectQueryParams.md)| Project search condition properties   &lt;em&gt;uuid:&lt;/em&gt; list of uuid for searching |

### Return type

[**List&lt;ProjectResource&gt;**](ProjectResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="updateProject"></a>
# **updateProject**
> ProjectResource updateProject(projectId, body)

Updates a Project



### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ProjectApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

ProjectApi apiInstance = new ProjectApi();
Long projectId = 789L; // Long | ID of the project
ProjectUpdateResource body = new ProjectUpdateResource(); // ProjectUpdateResource | Project updated properties   <em>name (optional):</em> name of project  <em>description (optional):</em> description of project  <em>start_date (optional):</em> Start date of project, eg: 2019-06-17T05:09:13.178Z  <em>end_date (optional):</em> End date of project, eg: 2019-06-27T05:09:13.178Z  <em>admin_ids (optional):</em> list assigned admin ids of project  <em>uuid (optional):</em> uuid of project. User can provide any string value for uuid, then they can used it for searching projects.  <em>template_id (optional):</em> site template id of project. When changing site template id, the project will be removed from old site template id and the new site template will be applied to it.
try {
    ProjectResource result = apiInstance.updateProject(projectId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectApi#updateProject");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **body** | [**ProjectUpdateResource**](ProjectUpdateResource.md)| Project updated properties   &lt;em&gt;name (optional):&lt;/em&gt; name of project  &lt;em&gt;description (optional):&lt;/em&gt; description of project  &lt;em&gt;start_date (optional):&lt;/em&gt; Start date of project, eg: 2019-06-17T05:09:13.178Z  &lt;em&gt;end_date (optional):&lt;/em&gt; End date of project, eg: 2019-06-27T05:09:13.178Z  &lt;em&gt;admin_ids (optional):&lt;/em&gt; list assigned admin ids of project  &lt;em&gt;uuid (optional):&lt;/em&gt; uuid of project. User can provide any string value for uuid, then they can used it for searching projects.  &lt;em&gt;template_id (optional):&lt;/em&gt; site template id of project. When changing site template id, the project will be removed from old site template id and the new site template will be applied to it. |

### Return type

[**ProjectResource**](ProjectResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

