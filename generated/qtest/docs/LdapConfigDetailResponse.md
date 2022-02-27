
# LdapConfigDetailResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **Long** |  |  [optional]
**isActivated** | **Boolean** |  |  [optional]
**authType** | [**AuthTypeEnum**](#AuthTypeEnum) | Type of authentication system |  [optional]
**name** | **String** |  |  [optional]
**username** | **String** | Username of Ldap system |  [optional]
**url** | **String** | The url of Ldap system |  [optional]
**base** | **String** | Base of Ldap system |  [optional]
**baseSearch** | **String** | Base search of Ldap system |  [optional]
**searchFilter** | **String** | Search filter of Ldap system |  [optional]
**mappedUsername** | **String** | The mapped username field of Ldap system |  [optional]
**mappedFirstname** | **String** | The mapped firstname field of Ldap system |  [optional]
**mappedLastname** | **String** | The mapped lastname field of Ldap system |  [optional]
**mappedEmail** | **String** | The mapped email field of Ldap system |  [optional]
**isLdapSsl** | **Boolean** | Use SSL connect or not |  [optional]
**isActiveDirectory** | **Boolean** | Is active directory or not |  [optional]


<a name="AuthTypeEnum"></a>
## Enum: AuthTypeEnum
Name | Value
---- | -----
INTERNAL | &quot;INTERNAL&quot;
LDAP | &quot;LDAP&quot;
SSO_SAML2 | &quot;SSO_SAML2&quot;
TUA_OPENID | &quot;TUA_OPENID&quot;



