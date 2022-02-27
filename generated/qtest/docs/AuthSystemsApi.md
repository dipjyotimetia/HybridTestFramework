# AuthSystemsApi

All URIs are relative to *https://apitryout.qtestnet.com/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getAll**](AuthSystemsApi.md#getAll) | **GET** /api/v3/auth-systems | Get multiple Authentication Systems
[**getAllLdapUsers**](AuthSystemsApi.md#getAllLdapUsers) | **GET** /api/v3/auth-systems/ldap/{ldapAuthConfigId}/users | Get all LDAP users of an authentication LDAP config
[**importLDapUsers**](AuthSystemsApi.md#importLDapUsers) | **POST** /api/v3/auth-systems/ldap/{ldapAuthConfigId}/import | Associate Manager users with LDAP users


<a name="getAll"></a>
# **getAll**
> AuthSystemResponse getAll()

Get multiple Authentication Systems

To get multiple Authentication Systems

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AuthSystemsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

AuthSystemsApi apiInstance = new AuthSystemsApi();
try {
    AuthSystemResponse result = apiInstance.getAll();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthSystemsApi#getAll");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**AuthSystemResponse**](AuthSystemResponse.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getAllLdapUsers"></a>
# **getAllLdapUsers**
> LDAPUsersResponse getAllLdapUsers(ldapAuthConfigId, pageSize, page)

Get all LDAP users of an authentication LDAP config

Get all LDAP users of an authentication LDAP config with pagination supported. Users are mapped with qTest users won&#39;t be returned.  If &lt;strong&gt;pageSize&lt;/strong&gt; and &lt;strong&gt;page&lt;/strong&gt; is omitted, all users will be returned without any default paging data.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AuthSystemsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

AuthSystemsApi apiInstance = new AuthSystemsApi();
Long ldapAuthConfigId = 789L; // Long | Id of the Authentication config
Long pageSize = 100L; // Long | Number of of item count per page. If this <strong>pageSize</strong> and <strong>page</strong> is omitted, all users will be returned without any default paging data.
Long page = 1L; // Long | Page number that you want to get the result. If this <strong>pageSize</strong> and <strong>page</strong> is omitted, all users will be returned without any default paging data.
try {
    LDAPUsersResponse result = apiInstance.getAllLdapUsers(ldapAuthConfigId, pageSize, page);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthSystemsApi#getAllLdapUsers");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ldapAuthConfigId** | **Long**| Id of the Authentication config |
 **pageSize** | **Long**| Number of of item count per page. If this &lt;strong&gt;pageSize&lt;/strong&gt; and &lt;strong&gt;page&lt;/strong&gt; is omitted, all users will be returned without any default paging data. | [optional] [default to 100]
 **page** | **Long**| Page number that you want to get the result. If this &lt;strong&gt;pageSize&lt;/strong&gt; and &lt;strong&gt;page&lt;/strong&gt; is omitted, all users will be returned without any default paging data. | [optional] [default to 1]

### Return type

[**LDAPUsersResponse**](LDAPUsersResponse.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="importLDapUsers"></a>
# **importLDapUsers**
> ResponseWrapper importLDapUsers(ldapAuthConfigId, body, mergeUser)

Associate Manager users with LDAP users

Associate Manager users with LDAP users authentication LDAP config

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AuthSystemsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

AuthSystemsApi apiInstance = new AuthSystemsApi();
Long ldapAuthConfigId = 789L; // Long | Id of the Authentication config
List<LdapUserResource> body = Arrays.asList(new LdapUserResource()); // List<LdapUserResource> | 
Boolean mergeUser = true; // Boolean | Option to merge LDAP account to qTest account if qTest email already exists in qTest (support true/false value, <strong>default = false</strong>)
try {
    ResponseWrapper result = apiInstance.importLDapUsers(ldapAuthConfigId, body, mergeUser);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthSystemsApi#importLDapUsers");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ldapAuthConfigId** | **Long**| Id of the Authentication config |
 **body** | [**List&lt;LdapUserResource&gt;**](LdapUserResource.md)|  |
 **mergeUser** | **Boolean**| Option to merge LDAP account to qTest account if qTest email already exists in qTest (support true/false value, &lt;strong&gt;default &#x3D; false&lt;/strong&gt;) | [optional]

### Return type

[**ResponseWrapper**](ResponseWrapper.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

