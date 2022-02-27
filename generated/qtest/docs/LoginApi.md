# LoginApi

All URIs are relative to *https://apitryout.qtestnet.com/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**postAccessToken**](LoginApi.md#postAccessToken) | **POST** /oauth/token | Log in
[**tokenStatus**](LoginApi.md#tokenStatus) | **GET** /oauth/status | Gets status of access token


<a name="postAccessToken"></a>
# **postAccessToken**
> OAuthResponse postAccessToken(grantType, username, password, refreshToken, authorization)

Log in

To authenticate the API client against qTest Manager and acquire authorized access token.    Note: Please choose parameter &lt;em&gt;content-type&#x3D;application/x-www-form-urlencoded&lt;/em&gt;

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.LoginApi;


LoginApi apiInstance = new LoginApi();
String grantType = "password"; // String | Use <em>grant_type=password</em> or <em>grant_type=refresh_token</em> to refresh access token
String username = "username_example"; // String | Your qTest Manager username
String password = "password_example"; // String | Your qTest Manager password
String refreshToken = "refreshToken_example"; // String | qTest refresh token to refresh access token associate with provided refresh token
String authorization = "authorization_example"; // String | Basic + [base64 string of \"<strong>your qTest site name and colon</strong>\"]  or Basic cXRlc3QtYXBpOg== [base64 string of \"<strong>qtest-api:</strong>\"] to use refresh token (grant_type = refresh_token)  Example: qTest Manager site is: apitryout.qtestnet.com then site name is: apitryout + ':', then Authorization is: Basic YXBpdHJ5b3V0Og==
try {
    OAuthResponse result = apiInstance.postAccessToken(grantType, username, password, refreshToken, authorization);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LoginApi#postAccessToken");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **grantType** | **String**| Use &lt;em&gt;grant_type&#x3D;password&lt;/em&gt; or &lt;em&gt;grant_type&#x3D;refresh_token&lt;/em&gt; to refresh access token | [optional] [default to password] [enum: password, refresh_token]
 **username** | **String**| Your qTest Manager username | [optional]
 **password** | **String**| Your qTest Manager password | [optional]
 **refreshToken** | **String**| qTest refresh token to refresh access token associate with provided refresh token | [optional]
 **authorization** | **String**| Basic + [base64 string of \&quot;&lt;strong&gt;your qTest site name and colon&lt;/strong&gt;\&quot;]  or Basic cXRlc3QtYXBpOg&#x3D;&#x3D; [base64 string of \&quot;&lt;strong&gt;qtest-api:&lt;/strong&gt;\&quot;] to use refresh token (grant_type &#x3D; refresh_token)  Example: qTest Manager site is: apitryout.qtestnet.com then site name is: apitryout + &#39;:&#39;, then Authorization is: Basic YXBpdHJ5b3V0Og&#x3D;&#x3D; | [optional]

### Return type

[**OAuthResponse**](OAuthResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: Not defined

<a name="tokenStatus"></a>
# **tokenStatus**
> OAuthTokenStatusVM tokenStatus(authorization)

Gets status of access token

Gets status of access token

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.LoginApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

LoginApi apiInstance = new LoginApi();
String authorization = "authorization_example"; // String | The qTest access token you want to check
try {
    OAuthTokenStatusVM result = apiInstance.tokenStatus(authorization);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LoginApi#tokenStatus");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| The qTest access token you want to check | [optional]

### Return type

[**OAuthTokenStatusVM**](OAuthTokenStatusVM.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

