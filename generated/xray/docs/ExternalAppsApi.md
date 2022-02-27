# ExternalAppsApi

All URIs are relative to *https://sandbox.xpand-it.com/rest/raven/2.0/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**xraylicenseGet**](ExternalAppsApi.md#xraylicenseGet) | **GET** /xraylicense | 


<a name="xraylicenseGet"></a>
# **xraylicenseGet**
> XrayLicenseStatus xraylicenseGet()



Returns information about the Xray license, including its status and type.

### Example
```java
// Import classes:
import org.openapi.xray.invoker.ApiClient;
import org.openapi.xray.invoker.ApiException;
import org.openapi.xray.invoker.Configuration;
import org.openapi.xray.invoker.auth.*;
import org.openapi.xray.invoker.models.*;
import org.openapi.xray.api.ExternalAppsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.xpand-it.com/rest/raven/2.0/api");
    
    // Configure HTTP basic authorization: BasicAuth
    HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
    BasicAuth.setUsername("YOUR USERNAME");
    BasicAuth.setPassword("YOUR PASSWORD");

    ExternalAppsApi apiInstance = new ExternalAppsApi(defaultClient);
    try {
      XrayLicenseStatus result = apiInstance.xraylicenseGet();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ExternalAppsApi#xraylicenseGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**XrayLicenseStatus**](XrayLicenseStatus.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Successful operation |  -  |
**500** | Internal Server Error |  -  |

