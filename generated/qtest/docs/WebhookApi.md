# WebhookApi

All URIs are relative to *https://apitryout.qtestnet.com/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createWebhook**](WebhookApi.md#createWebhook) | **POST** /api/v3/webhooks | Registers a webhook
[**deleteWebhookById**](WebhookApi.md#deleteWebhookById) | **DELETE** /api/v3/webhooks/{webhookId} | Deletes a webhook
[**getAllEventNames**](WebhookApi.md#getAllEventNames) | **GET** /api/v3/webhooks/events | Get list of webhook event names
[**getAllWebhooks**](WebhookApi.md#getAllWebhooks) | **GET** /api/v3/webhooks | Gets list of all registered webhooks
[**getWebhookById**](WebhookApi.md#getWebhookById) | **GET** /api/v3/webhooks/{webhookId} | Gets a webhook
[**updateWebhook**](WebhookApi.md#updateWebhook) | **PUT** /api/v3/webhooks/{webhookId} | Updates a webhook


<a name="createWebhook"></a>
# **createWebhook**
> WebhookVM createWebhook(body)

Registers a webhook

To register a webhook

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.WebhookApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

WebhookApi apiInstance = new WebhookApi();
WebhookRequest body = new WebhookRequest(); // WebhookRequest | <em>name (required):</em> name of the webhook  <em>URL (required):</em> where the callback should be sent  <em>secretkey (required):</em> secretkey is used to ensure that POST requests sent to the URL are from qTest  <em>responseType (optional):</em> content-type of the callback message. Allow values: \"text\" for <b>text/plain</b>, \"json\" for <b>application/json</b>. Default value is \"text\"  <em>events (required):</em> list event(s) to register. Its valid values include  - testcase_created  - testcase_updated  - testcase_deleted  - testcase_approved  - testrun_created  - testrun_updated  - testrun_deleted  - testlog_submitted  - testlog_modified  - project_created  - project_updated  - defect_submitted  - defect_modified  - requirement_created  - requirement_updated  - requirement_deleted
try {
    WebhookVM result = apiInstance.createWebhook(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling WebhookApi#createWebhook");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**WebhookRequest**](WebhookRequest.md)| &lt;em&gt;name (required):&lt;/em&gt; name of the webhook  &lt;em&gt;URL (required):&lt;/em&gt; where the callback should be sent  &lt;em&gt;secretkey (required):&lt;/em&gt; secretkey is used to ensure that POST requests sent to the URL are from qTest  &lt;em&gt;responseType (optional):&lt;/em&gt; content-type of the callback message. Allow values: \&quot;text\&quot; for &lt;b&gt;text/plain&lt;/b&gt;, \&quot;json\&quot; for &lt;b&gt;application/json&lt;/b&gt;. Default value is \&quot;text\&quot;  &lt;em&gt;events (required):&lt;/em&gt; list event(s) to register. Its valid values include  - testcase_created  - testcase_updated  - testcase_deleted  - testcase_approved  - testrun_created  - testrun_updated  - testrun_deleted  - testlog_submitted  - testlog_modified  - project_created  - project_updated  - defect_submitted  - defect_modified  - requirement_created  - requirement_updated  - requirement_deleted |

### Return type

[**WebhookVM**](WebhookVM.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="deleteWebhookById"></a>
# **deleteWebhookById**
> Object deleteWebhookById(webhookId)

Deletes a webhook

To delete a registered webhook

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.WebhookApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

WebhookApi apiInstance = new WebhookApi();
String webhookId = "webhookId_example"; // String | ID of the webhook
try {
    Object result = apiInstance.deleteWebhookById(webhookId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling WebhookApi#deleteWebhookById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **webhookId** | **String**| ID of the webhook |

### Return type

**Object**

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getAllEventNames"></a>
# **getAllEventNames**
> List&lt;String&gt; getAllEventNames()

Get list of webhook event names

To retrieve list of all available event names for webhook registering

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.WebhookApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

WebhookApi apiInstance = new WebhookApi();
try {
    List<String> result = apiInstance.getAllEventNames();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling WebhookApi#getAllEventNames");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**List&lt;String&gt;**

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getAllWebhooks"></a>
# **getAllWebhooks**
> List&lt;WebhookVM&gt; getAllWebhooks()

Gets list of all registered webhooks

To retrieve list of all registered webhooks

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.WebhookApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

WebhookApi apiInstance = new WebhookApi();
try {
    List<WebhookVM> result = apiInstance.getAllWebhooks();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling WebhookApi#getAllWebhooks");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;WebhookVM&gt;**](WebhookVM.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getWebhookById"></a>
# **getWebhookById**
> WebhookVM getWebhookById(webhookId)

Gets a webhook

To retrieve details of a registered webhook

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.WebhookApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

WebhookApi apiInstance = new WebhookApi();
String webhookId = "webhookId_example"; // String | ID of the webhook
try {
    WebhookVM result = apiInstance.getWebhookById(webhookId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling WebhookApi#getWebhookById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **webhookId** | **String**| ID of the webhook |

### Return type

[**WebhookVM**](WebhookVM.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="updateWebhook"></a>
# **updateWebhook**
> WebhookVM updateWebhook(webhookId, body)

Updates a webhook



### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.WebhookApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

WebhookApi apiInstance = new WebhookApi();
String webhookId = "webhookId_example"; // String | ID of the webhook
WebhookRequest body = new WebhookRequest(); // WebhookRequest | Update webhook's information  <em>name:</em> New name of the webhook  <em>URL:</em> New URL of the webhook  <em>secretkey:</em> New secret key of the webhook  <em>responseType:</em> New content-type of the callback message. Allow values: \"text\" for <b>text/plain</b>, \"json\" for <b>application/json</b>  <em>events (required):</em> New list event(s) to register. Its valid values include  - testcase_created  - testcase_updated  - testcase_deleted  - testcase_approved  - testrun_created  - testrun_updated  - testrun_deleted  - testlog_submitted  - testlog_modified  - project_created  - project_updated  - defect_submitted  - defect_modified  - requirement_created  - requirement_updated  - requirement_deleted
try {
    WebhookVM result = apiInstance.updateWebhook(webhookId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling WebhookApi#updateWebhook");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **webhookId** | **String**| ID of the webhook |
 **body** | [**WebhookRequest**](WebhookRequest.md)| Update webhook&#39;s information  &lt;em&gt;name:&lt;/em&gt; New name of the webhook  &lt;em&gt;URL:&lt;/em&gt; New URL of the webhook  &lt;em&gt;secretkey:&lt;/em&gt; New secret key of the webhook  &lt;em&gt;responseType:&lt;/em&gt; New content-type of the callback message. Allow values: \&quot;text\&quot; for &lt;b&gt;text/plain&lt;/b&gt;, \&quot;json\&quot; for &lt;b&gt;application/json&lt;/b&gt;  &lt;em&gt;events (required):&lt;/em&gt; New list event(s) to register. Its valid values include  - testcase_created  - testcase_updated  - testcase_deleted  - testcase_approved  - testrun_created  - testrun_updated  - testrun_deleted  - testlog_submitted  - testlog_modified  - project_created  - project_updated  - defect_submitted  - defect_modified  - requirement_created  - requirement_updated  - requirement_deleted |

### Return type

[**WebhookVM**](WebhookVM.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

