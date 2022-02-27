# SiteTemplatesApi

All URIs are relative to *https://apitryout.qtestnet.com/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addProjects**](SiteTemplatesApi.md#addProjects) | **POST** /api/v3/site-templates/{templateId}/projects | Apply template to existing projects.
[**getAllSiteTemplates**](SiteTemplatesApi.md#getAllSiteTemplates) | **GET** /api/v3/site-templates | Get all site-templates
[**removeProjectTemplates**](SiteTemplatesApi.md#removeProjectTemplates) | **DELETE** /api/v3/site-templates/{templateId}/projects | Remove projects from a site template.


<a name="addProjects"></a>
# **addProjects**
> List&lt;ProjectResource&gt; addProjects(templateId, body)

Apply template to existing projects.

To apply template to existing projects.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SiteTemplatesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

SiteTemplatesApi apiInstance = new SiteTemplatesApi();
Long templateId = 789L; // Long | Template id which you want to apply to existing projects.
ApplyTemplateQueryObject body = new ApplyTemplateQueryObject(); // ApplyTemplateQueryObject | <em>project_ids:</em>List of Project IDs  <em>create_new_site_field_values:</em> Option to allow user to decide if they want to create new values to the site fields or keep the value private to the project when there are \"unique values in project fields that do not exist in site fields\" (default: true).
try {
    List<ProjectResource> result = apiInstance.addProjects(templateId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SiteTemplatesApi#addProjects");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **templateId** | **Long**| Template id which you want to apply to existing projects. |
 **body** | [**ApplyTemplateQueryObject**](ApplyTemplateQueryObject.md)| &lt;em&gt;project_ids:&lt;/em&gt;List of Project IDs  &lt;em&gt;create_new_site_field_values:&lt;/em&gt; Option to allow user to decide if they want to create new values to the site fields or keep the value private to the project when there are \&quot;unique values in project fields that do not exist in site fields\&quot; (default: true). |

### Return type

[**List&lt;ProjectResource&gt;**](ProjectResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getAllSiteTemplates"></a>
# **getAllSiteTemplates**
> List&lt;SiteTemplateResponse&gt; getAllSiteTemplates()

Get all site-templates

To retrieve all site-templates

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SiteTemplatesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

SiteTemplatesApi apiInstance = new SiteTemplatesApi();
try {
    List<SiteTemplateResponse> result = apiInstance.getAllSiteTemplates();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SiteTemplatesApi#getAllSiteTemplates");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;SiteTemplateResponse&gt;**](SiteTemplateResponse.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="removeProjectTemplates"></a>
# **removeProjectTemplates**
> List&lt;ProjectResource&gt; removeProjectTemplates(templateId, body)

Remove projects from a site template.

To remove projects from a site template.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SiteTemplatesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

SiteTemplatesApi apiInstance = new SiteTemplatesApi();
Long templateId = 789L; // Long | Template id which you want to detach it's projects. If <strong>0</strong> (unassigned template id) is placing here, remove all site templates associated to provided project ids list.
List<Long> body = Arrays.asList(new List<Long>()); // List<Long> | Array of project ids that you want to detach from site template.
try {
    List<ProjectResource> result = apiInstance.removeProjectTemplates(templateId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SiteTemplatesApi#removeProjectTemplates");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **templateId** | **Long**| Template id which you want to detach it&#39;s projects. If &lt;strong&gt;0&lt;/strong&gt; (unassigned template id) is placing here, remove all site templates associated to provided project ids list. |
 **body** | **List&lt;Long&gt;**| Array of project ids that you want to detach from site template. |

### Return type

[**List&lt;ProjectResource&gt;**](ProjectResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

