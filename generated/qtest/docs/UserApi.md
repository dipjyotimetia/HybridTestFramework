# UserApi

All URIs are relative to *https://apitryout.qtestnet.com/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**assignToProject**](UserApi.md#assignToProject) | **POST** /api/v3/users/{userId}/projects | Assigns a User to a Project
[**assignUsersToProject**](UserApi.md#assignUsersToProject) | **POST** /api/v3/users/projects | Assigns multiple Users to a Project
[**createUser**](UserApi.md#createUser) | **POST** /api/v3/users | Invites a User
[**findByUserNameOrEmail**](UserApi.md#findByUserNameOrEmail) | **GET** /api/v3/users/search | Queries Users by Username
[**findUsersByProjectsName**](UserApi.md#findUsersByProjectsName) | **GET** /api/v3/search/user | Queries Users by Project Name
[**getAvatar**](UserApi.md#getAvatar) | **GET** /api/v3/users/{userId}/avatar | Gets a User&#39;s Avatar
[**getUserById**](UserApi.md#getUserById) | **GET** /api/v3/users/{userId} | Gets a User
[**reevaluateToken**](UserApi.md#reevaluateToken) | **GET** /api/v3/re-evaluation | Gets current user&#39;s information
[**removeAssociationUsersAndProjects**](UserApi.md#removeAssociationUsersAndProjects) | **PUT** /api/v3/users/projects | Remove association between users and projects
[**updateUser**](UserApi.md#updateUser) | **PUT** /api/v3/users/{userId} | Update user&#39;s information


<a name="assignToProject"></a>
# **assignToProject**
> AssignedProject assignToProject(userId, body)

Assigns a User to a Project

To assign a User to a Project

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.UserApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

UserApi apiInstance = new UserApi();
Long userId = 789L; // Long | ID of the user.
AssignedProject body = new AssignedProject(); // AssignedProject | The project ID and the assigned user profile in the project. If the profile is not provided, profile Developer is used by default
try {
    AssignedProject result = apiInstance.assignToProject(userId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#assignToProject");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Long**| ID of the user. |
 **body** | [**AssignedProject**](AssignedProject.md)| The project ID and the assigned user profile in the project. If the profile is not provided, profile Developer is used by default |

### Return type

[**AssignedProject**](AssignedProject.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="assignUsersToProject"></a>
# **assignUsersToProject**
> AssignedUsersProject assignUsersToProject(body)

Assigns multiple Users to a Project

To assign a list of Users to a Project  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 4+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.UserApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

UserApi apiInstance = new UserApi();
AssignedUsersProject body = new AssignedUsersProject(); // AssignedUsersProject | ID of the Project and an array of assigned Users' IDs. If the profile is not provided, Developer profile is used by default
try {
    AssignedUsersProject result = apiInstance.assignUsersToProject(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#assignUsersToProject");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**AssignedUsersProject**](AssignedUsersProject.md)| ID of the Project and an array of assigned Users&#39; IDs. If the profile is not provided, Developer profile is used by default |

### Return type

[**AssignedUsersProject**](AssignedUsersProject.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="createUser"></a>
# **createUser**
> UserResource createUser(body)

Invites a User

To invite a user to your qTest Manager instance and activate the account. If the password is omitted, the default \&quot;&lt;em&gt;admin123&lt;/em&gt;\&quot; will be used  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 4+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.UserApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

UserApi apiInstance = new UserApi();
UserResource body = new UserResource(); // UserResource | Invited user's information  <em>username (require)</em>: email of new user  <em>email</em>: recovery email of new user  <em>password</em>: password of new user. If the password is omitted, the default \"admin123\" will be used  <em>first_name (require)</em>: First name of new user  <em>last_name (require)</em>: Last name of new user  <em>user_group_ids</em>: List usergroup ids will be assigned for new user.  <em>send_activation_email</em>: activation email will be ignored if this is set to <strong>false</strong>. Default value is <strong>false</strong>  <em>external_auth_config_id</em>: auto assign this new user with External Authentication system by this providing config id here. If this value is provided, <em>\"external_user_name\"</em> need to have value, or it will failed to create.  <em>external_user_name</em>: external username that will be assigned to newly created qTest user   <em>include_default_groups</em>:Include default groups or not. Default value is <strong>false</strong>
try {
    UserResource result = apiInstance.createUser(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#createUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**UserResource**](UserResource.md)| Invited user&#39;s information  &lt;em&gt;username (require)&lt;/em&gt;: email of new user  &lt;em&gt;email&lt;/em&gt;: recovery email of new user  &lt;em&gt;password&lt;/em&gt;: password of new user. If the password is omitted, the default \&quot;admin123\&quot; will be used  &lt;em&gt;first_name (require)&lt;/em&gt;: First name of new user  &lt;em&gt;last_name (require)&lt;/em&gt;: Last name of new user  &lt;em&gt;user_group_ids&lt;/em&gt;: List usergroup ids will be assigned for new user.  &lt;em&gt;send_activation_email&lt;/em&gt;: activation email will be ignored if this is set to &lt;strong&gt;false&lt;/strong&gt;. Default value is &lt;strong&gt;false&lt;/strong&gt;  &lt;em&gt;external_auth_config_id&lt;/em&gt;: auto assign this new user with External Authentication system by this providing config id here. If this value is provided, &lt;em&gt;\&quot;external_user_name\&quot;&lt;/em&gt; need to have value, or it will failed to create.  &lt;em&gt;external_user_name&lt;/em&gt;: external username that will be assigned to newly created qTest user   &lt;em&gt;include_default_groups&lt;/em&gt;:Include default groups or not. Default value is &lt;strong&gt;false&lt;/strong&gt; |

### Return type

[**UserResource**](UserResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="findByUserNameOrEmail"></a>
# **findByUserNameOrEmail**
> SearchUserResourceExtensionResponse findByUserNameOrEmail(username, includeInactiveUsers, pagination, page, pageSize)

Queries Users by Username

To query for users by their username  &lt;strong&gt;qTest Manager version:&lt;/strong&gt; 8.4.2+

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.UserApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

UserApi apiInstance = new UserApi();
String username = "username_example"; // String | Login names (qTest login email, LDAP or SSO username) of users you want to query for. The API will return users which have been added to projects whose names contain the text specified in this parameter  <strong>IMPORTANT:</strong> Login name is case sensitive
Boolean includeInactiveUsers = true; // Boolean | <em>includeInactiveUsers=false</em> - default value. Inactive users are excluded from the response  <em>includeInactiveUsers=true</em> - inactive users are included in the response
Boolean pagination = true; // Boolean | <em>pagination=true</em> - default value. The result is paginated  <em>pagination=false</em> - the result is not paginated
Long page = 1L; // Long | By default the first page is returned but you can specify any page number to retrieve objects
Long pageSize = 100L; // Long | The result is paginated. By the default, the number of objects in each page is 100 if this is omitted. You can specify your custom number (up to 100) in this parameter.
try {
    SearchUserResourceExtensionResponse result = apiInstance.findByUserNameOrEmail(username, includeInactiveUsers, pagination, page, pageSize);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#findByUserNameOrEmail");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **String**| Login names (qTest login email, LDAP or SSO username) of users you want to query for. The API will return users which have been added to projects whose names contain the text specified in this parameter  &lt;strong&gt;IMPORTANT:&lt;/strong&gt; Login name is case sensitive | [optional]
 **includeInactiveUsers** | **Boolean**| &lt;em&gt;includeInactiveUsers&#x3D;false&lt;/em&gt; - default value. Inactive users are excluded from the response  &lt;em&gt;includeInactiveUsers&#x3D;true&lt;/em&gt; - inactive users are included in the response | [optional]
 **pagination** | **Boolean**| &lt;em&gt;pagination&#x3D;true&lt;/em&gt; - default value. The result is paginated  &lt;em&gt;pagination&#x3D;false&lt;/em&gt; - the result is not paginated | [optional]
 **page** | **Long**| By default the first page is returned but you can specify any page number to retrieve objects | [optional] [default to 1]
 **pageSize** | **Long**| The result is paginated. By the default, the number of objects in each page is 100 if this is omitted. You can specify your custom number (up to 100) in this parameter. | [optional] [default to 100]

### Return type

[**SearchUserResourceExtensionResponse**](SearchUserResourceExtensionResponse.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="findUsersByProjectsName"></a>
# **findUsersByProjectsName**
> SearchUserResponse findUsersByProjectsName(projectName, inactive, pagination, page, pageSize)

Queries Users by Project Name

To query for users by names of their assigned projects  - Admin users with &lt;em&gt;Manage Client Users&lt;/em&gt; permission can query users in any projects  - For other users: the API only returns users within projects to which the requesting user is assigned

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.UserApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

UserApi apiInstance = new UserApi();
String projectName = "projectName_example"; // String | Name of the project whose users you want to query for. The API will return users which have been added to projects whose names contain the text specified in this parameter  <strong>IMPORTANT:</strong> Project name is case sensitive
Boolean inactive = true; // Boolean | <em>inactive=false</em> - default value. Inactive users are excluded from the response  <em>inactive=true</em> - include inactive users
Boolean pagination = true; // Boolean | <em>pagination=true</em> - default value. The result is paginated  <em>pagination=false</em> - the result is not paginated
Long page = 1L; // Long | By default the first page is returned but you can specify any page number to retrieve objects
Long pageSize = 100L; // Long | The result is paginated. By the default, the number of objects in each page is 100 if this is omitted. You can specify your custom number (up to 999) in this parameter
try {
    SearchUserResponse result = apiInstance.findUsersByProjectsName(projectName, inactive, pagination, page, pageSize);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#findUsersByProjectsName");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectName** | **String**| Name of the project whose users you want to query for. The API will return users which have been added to projects whose names contain the text specified in this parameter  &lt;strong&gt;IMPORTANT:&lt;/strong&gt; Project name is case sensitive | [optional]
 **inactive** | **Boolean**| &lt;em&gt;inactive&#x3D;false&lt;/em&gt; - default value. Inactive users are excluded from the response  &lt;em&gt;inactive&#x3D;true&lt;/em&gt; - include inactive users | [optional] [default to true]
 **pagination** | **Boolean**| &lt;em&gt;pagination&#x3D;true&lt;/em&gt; - default value. The result is paginated  &lt;em&gt;pagination&#x3D;false&lt;/em&gt; - the result is not paginated | [optional] [default to true]
 **page** | **Long**| By default the first page is returned but you can specify any page number to retrieve objects | [optional] [default to 1]
 **pageSize** | **Long**| The result is paginated. By the default, the number of objects in each page is 100 if this is omitted. You can specify your custom number (up to 999) in this parameter | [optional] [default to 100]

### Return type

[**SearchUserResponse**](SearchUserResponse.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getAvatar"></a>
# **getAvatar**
> OutputStream getAvatar(userId)

Gets a User&#39;s Avatar

To retrieve a User&#39;s Avatar

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.UserApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

UserApi apiInstance = new UserApi();
Long userId = 789L; // Long | ID of the user.
try {
    OutputStream result = apiInstance.getAvatar(userId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#getAvatar");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Long**| ID of the user. |

### Return type

[**OutputStream**](OutputStream.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getUserById"></a>
# **getUserById**
> UserResource getUserById(userId)

Gets a User

To retrieve a User&#39;s information

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.UserApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

UserApi apiInstance = new UserApi();
Long userId = 789L; // Long | ID of the user.
try {
    UserResource result = apiInstance.getUserById(userId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#getUserById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Long**| ID of the user. |

### Return type

[**UserResource**](UserResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="reevaluateToken"></a>
# **reevaluateToken**
> LoggedUser reevaluateToken(includeInaccessibleApps)

Gets current user&#39;s information

To retrieve your information such as username, email, first name, and last name

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.UserApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

UserApi apiInstance = new UserApi();
Boolean includeInaccessibleApps = true; // Boolean | 
try {
    LoggedUser result = apiInstance.reevaluateToken(includeInaccessibleApps);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#reevaluateToken");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **includeInaccessibleApps** | **Boolean**|  | [optional]

### Return type

[**LoggedUser**](LoggedUser.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="removeAssociationUsersAndProjects"></a>
# **removeAssociationUsersAndProjects**
> Message removeAssociationUsersAndProjects(body)

Remove association between users and projects

To remove association between users and projects

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.UserApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

UserApi apiInstance = new UserApi();
List<ProjectWithUserIdsObject> body = Arrays.asList(new ProjectWithUserIdsObject()); // List<ProjectWithUserIdsObject> | An array of pairs project_id and user_ids   <em>project_id:</em> ID of the project  <em>user_ids: </em> List of User IDs which are being removed from the project
try {
    Message result = apiInstance.removeAssociationUsersAndProjects(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#removeAssociationUsersAndProjects");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**List&lt;ProjectWithUserIdsObject&gt;**](ProjectWithUserIdsObject.md)| An array of pairs project_id and user_ids   &lt;em&gt;project_id:&lt;/em&gt; ID of the project  &lt;em&gt;user_ids: &lt;/em&gt; List of User IDs which are being removed from the project |

### Return type

[**Message**](Message.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="updateUser"></a>
# **updateUser**
> UserResource updateUser(userId, body)

Update user&#39;s information

To update information of a user, like : recovery email, password, status...

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.UserApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

UserApi apiInstance = new UserApi();
Long userId = 789L; // Long | ID of the user.
UserUpdateResource body = new UserUpdateResource(); // UserUpdateResource | Update user's information  <em>email</em>: New recovery email of user  <em>password</em>: New password of user. Password have to map with password policy of current user's client  <em>first_name</em>: New first name of user  <em>last_name</em>: New last name of user  <em>user_group_ids</em>: List usergroup ids will be assigned for user (old usergroup ids will be replaced).  <em>external_auth_config_id</em>: New user's external authenticate id,it will auto assign this user with External Authentication system by this providing config id here. If this value is provided, <em>\"external_user_name\"</em> need to have value, or it will failed to update. For internal authentication system input : <strong>-1</strong>  <em>external_user_name</em>: external username that will be assigned to user (if LDAP external is specified, \"first_name\" and \"last_name\" will be fetch from LDAP system).  <em>status</em>: New status id of user. Status id must be <strong>1</strong> for Active or <strong>3</strong> for Inactive status.
try {
    UserResource result = apiInstance.updateUser(userId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#updateUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Long**| ID of the user. |
 **body** | [**UserUpdateResource**](UserUpdateResource.md)| Update user&#39;s information  &lt;em&gt;email&lt;/em&gt;: New recovery email of user  &lt;em&gt;password&lt;/em&gt;: New password of user. Password have to map with password policy of current user&#39;s client  &lt;em&gt;first_name&lt;/em&gt;: New first name of user  &lt;em&gt;last_name&lt;/em&gt;: New last name of user  &lt;em&gt;user_group_ids&lt;/em&gt;: List usergroup ids will be assigned for user (old usergroup ids will be replaced).  &lt;em&gt;external_auth_config_id&lt;/em&gt;: New user&#39;s external authenticate id,it will auto assign this user with External Authentication system by this providing config id here. If this value is provided, &lt;em&gt;\&quot;external_user_name\&quot;&lt;/em&gt; need to have value, or it will failed to update. For internal authentication system input : &lt;strong&gt;-1&lt;/strong&gt;  &lt;em&gt;external_user_name&lt;/em&gt;: external username that will be assigned to user (if LDAP external is specified, \&quot;first_name\&quot; and \&quot;last_name\&quot; will be fetch from LDAP system).  &lt;em&gt;status&lt;/em&gt;: New status id of user. Status id must be &lt;strong&gt;1&lt;/strong&gt; for Active or &lt;strong&gt;3&lt;/strong&gt; for Inactive status. |

### Return type

[**UserResource**](UserResource.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

