
# SSOSamlConfigDetailResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **Long** |  |  [optional]
**isActivated** | **Boolean** |  |  [optional]
**authType** | [**AuthTypeEnum**](#AuthTypeEnum) | Type of authentication system |  [optional]
**name** | **String** |  |  [optional]
**metadataLink** | **String** | Metadata link of SSO system |  [optional]
**autoCreateUser** | **Boolean** | Auto create user or not |  [optional]
**metadataFilename** | **String** |  |  [optional]


<a name="AuthTypeEnum"></a>
## Enum: AuthTypeEnum
Name | Value
---- | -----
INTERNAL | &quot;INTERNAL&quot;
LDAP | &quot;LDAP&quot;
SSO_SAML2 | &quot;SSO_SAML2&quot;
TUA_OPENID | &quot;TUA_OPENID&quot;



