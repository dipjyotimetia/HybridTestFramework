# UserProfileApi

All URIs are relative to *https://apitryout.qtestnet.com/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**batchAssignUserProfileInClient**](UserProfileApi.md#batchAssignUserProfileInClient) | **POST** /api/v3/user-profiles/batch-assign-users | Assigns multiple Users to a Profile
[**batchAssignUserProfileInProject**](UserProfileApi.md#batchAssignUserProfileInProject) | **POST** /api/v3/user-profiles/{projectId}/batch-assign-users | Assigns multiple Users to a Profile in a Project
[**getCurrent**](UserProfileApi.md#getCurrent) | **GET** /api/v3/admin-profiles/current | Gets current User&#39;s Admin Profile
[**getProfilesOfCurrentUser**](UserProfileApi.md#getProfilesOfCurrentUser) | **GET** /api/v3/user-profiles/current | Gets current User&#39;s Profiles in different Projects
[**getUserProfiles**](UserProfileApi.md#getUserProfiles) | **GET** /api/v3/user-profiles | Gets available Profiles


<a name="batchAssignUserProfileInClient"></a>
# **batchAssignUserProfileInClient**
> List&lt;UserResourceExtension&gt; batchAssignUserProfileInClient(body)

Assigns multiple Users to a Profile

To batch assign users to a profile (Admin profile, User profile) (as in qTest Manager &lt;em&gt;admin panel&lt;/em&gt;). It requires that your qTest Manager profile is a site admin with &lt;em&gt;Manage Client Users&lt;/em&gt; permissions  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 8.4.2+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.UserProfileApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

UserProfileApi apiInstance = new UserProfileApi();
SiteUsersProfile body = new SiteUsersProfile(); // SiteUsersProfile | An array of user IDs and admin and/or normal user profile
try {
    List<UserResourceExtension> result = apiInstance.batchAssignUserProfileInClient(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserProfileApi#batchAssignUserProfileInClient");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**SiteUsersProfile**](SiteUsersProfile.md)| An array of user IDs and admin and/or normal user profile |

### Return type

[**List&lt;UserResourceExtension&gt;**](UserResourceExtension.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="batchAssignUserProfileInProject"></a>
# **batchAssignUserProfileInProject**
> List&lt;UserResourceExtension&gt; batchAssignUserProfileInProject(projectId, body)

Assigns multiple Users to a Profile in a Project

To change profile of assigned users (as a project&#39;s User Management page). It requires that your qTest Manager profile within the project is Project Admin  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 8.4.2+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.UserProfileApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

UserProfileApi apiInstance = new UserProfileApi();
Long projectId = 789L; // Long | ID of the project
ProjectUsersProfile body = new ProjectUsersProfile(); // ProjectUsersProfile | An array of user IDs and a user profile
try {
    List<UserResourceExtension> result = apiInstance.batchAssignUserProfileInProject(projectId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserProfileApi#batchAssignUserProfileInProject");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| ID of the project |
 **body** | [**ProjectUsersProfile**](ProjectUsersProfile.md)| An array of user IDs and a user profile |

### Return type

[**List&lt;UserResourceExtension&gt;**](UserResourceExtension.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getCurrent"></a>
# **getCurrent**
> AdminProfile getCurrent()

Gets current User&#39;s Admin Profile

To retrieve your Admin Profile  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 4+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.UserProfileApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

UserProfileApi apiInstance = new UserProfileApi();
try {
    AdminProfile result = apiInstance.getCurrent();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserProfileApi#getCurrent");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**AdminProfile**](AdminProfile.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getProfilesOfCurrentUser"></a>
# **getProfilesOfCurrentUser**
> List&lt;UserProfile&gt; getProfilesOfCurrentUser()

Gets current User&#39;s Profiles in different Projects

To retrieve your User Profiles in different Projects

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.UserProfileApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

UserProfileApi apiInstance = new UserProfileApi();
try {
    List<UserProfile> result = apiInstance.getProfilesOfCurrentUser();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserProfileApi#getProfilesOfCurrentUser");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;UserProfile&gt;**](UserProfile.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getUserProfiles"></a>
# **getUserProfiles**
> UserProfileResponse getUserProfiles(type)

Gets available Profiles

To retrieve all available profiles in your qTest Manager instance. It requires that your qTest Manager profile is a site admin with &lt;em&gt;View User Profiles&lt;/em&gt; permissions  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 8.4.2+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.UserProfileApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

UserProfileApi apiInstance = new UserProfileApi();
String type = "type_example"; // String | <em>type=admin</em> - to retrieve only admin profiles  <em>type=use</em> - to retrieve only normal user profiles  Omit this parameter to include both
try {
    UserProfileResponse result = apiInstance.getUserProfiles(type);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserProfileApi#getUserProfiles");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **type** | **String**| &lt;em&gt;type&#x3D;admin&lt;/em&gt; - to retrieve only admin profiles  &lt;em&gt;type&#x3D;use&lt;/em&gt; - to retrieve only normal user profiles  Omit this parameter to include both | [optional] [enum: admin, user]

### Return type

[**UserProfileResponse**](UserProfileResponse.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

