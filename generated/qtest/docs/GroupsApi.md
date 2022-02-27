# GroupsApi

All URIs are relative to *https://apitryout.qtestnet.com/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createCustomUserGroup**](GroupsApi.md#createCustomUserGroup) | **POST** /api/v3/groups | Create custom UserGroup
[**getAllUserGroups**](GroupsApi.md#getAllUserGroups) | **GET** /api/v3/groups | Get multiple UserGroups


<a name="createCustomUserGroup"></a>
# **createCustomUserGroup**
> UserGroupResource createCustomUserGroup(body)

Create custom UserGroup

To create new custom UserGroup

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GroupsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

GroupsApi apiInstance = new GroupsApi();
UserGroupResource body = new UserGroupResource(); // UserGroupResource | <em>name (required):</em> Name of UserGroup  <em>description:</em> Description of UserGroup  <em>is_default:</em> Set this UserGroup as default group for new user  <em>user_ids:</em> List of userId will be assign to this group after created  <em>authority_names:</em> List of authorities for this UserGroup. Values can be: [ ROLE_ADMINCONFIGURATION, ROLE_ADMININFORMATION, ROLE_INSIGHTSEDITOR, ROLE_INSIGHTSEDITOR, ROLE_LAUNCHACCESS, ROLE_PROFILEADMIN, ROLE_PROFILEVIEWER, ROLE_PROJECTARCHIVER, ROLE_PROJECTCREATOR, ROLE_PROJECTUPDATER, ROLE_PROJECTVIEWER, ROLE_PULSEACCESS, ROLE_SITELEVELFIELD, ROLE_USERADMIN, ROLE_USERGROUPMANAGER, ROLE_ANALYTICSVIEWER ]
try {
    UserGroupResource result = apiInstance.createCustomUserGroup(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GroupsApi#createCustomUserGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**UserGroupResource**](UserGroupResource.md)| &lt;em&gt;name (required):&lt;/em&gt; Name of UserGroup  &lt;em&gt;description:&lt;/em&gt; Description of UserGroup  &lt;em&gt;is_default:&lt;/em&gt; Set this UserGroup as default group for new user  &lt;em&gt;user_ids:&lt;/em&gt; List of userId will be assign to this group after created  &lt;em&gt;authority_names:&lt;/em&gt; List of authorities for this UserGroup. Values can be: [ ROLE_ADMINCONFIGURATION, ROLE_ADMININFORMATION, ROLE_INSIGHTSEDITOR, ROLE_INSIGHTSEDITOR, ROLE_LAUNCHACCESS, ROLE_PROFILEADMIN, ROLE_PROFILEVIEWER, ROLE_PROJECTARCHIVER, ROLE_PROJECTCREATOR, ROLE_PROJECTUPDATER, ROLE_PROJECTVIEWER, ROLE_PULSEACCESS, ROLE_SITELEVELFIELD, ROLE_USERADMIN, ROLE_USERGROUPMANAGER, ROLE_ANALYTICSVIEWER ] |

### Return type

[**UserGroupResource**](UserGroupResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getAllUserGroups"></a>
# **getAllUserGroups**
> List&lt;UserGroupResource&gt; getAllUserGroups()

Get multiple UserGroups

To get multiple UserGroups

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GroupsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

GroupsApi apiInstance = new GroupsApi();
try {
    List<UserGroupResource> result = apiInstance.getAllUserGroups();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GroupsApi#getAllUserGroups");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;UserGroupResource&gt;**](UserGroupResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

