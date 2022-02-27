
# UserGroupResource

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **Long** |  |  [optional]
**name** | **String** | Name of UserGroup |  [optional]
**description** | **String** | Description of UserGroup |  [optional]
**totalUser** | **Long** | The total user of UserGroup |  [optional]
**isSystem** | **Boolean** |  |  [optional]
**isDefault** | **Boolean** | Set this UserGroup as default group for new user |  [optional]
**authorities** | [**List&lt;AuthorityVM&gt;**](AuthorityVM.md) |  |  [optional]
**users** | [**List&lt;UserInfoVM&gt;**](UserInfoVM.md) |  |  [optional]
**userIds** | **List&lt;Long&gt;** | List of userId will be assign to this group after created |  [optional]
**authorityNames** | **List&lt;String&gt;** | List of authorities for this UserGroup. Values can be: [ ROLE_ADMINCONFIGURATION, ROLE_ADMININFORMATION, ROLE_INSIGHTSEDITOR, ROLE_INSIGHTSEDITOR, ROLE_LAUNCHACCESS, ROLE_PROFILEADMIN, ROLE_PROFILEVIEWER, ROLE_PROJECTARCHIVER, ROLE_PROJECTCREATOR, ROLE_PROJECTUPDATER, ROLE_PROJECTVIEWER, ROLE_PULSEACCESS, ROLE_SITELEVELFIELD, ROLE_USERADMIN, ROLE_USERGROUPMANAGER, ROLE_ANALYTICSVIEWER ] |  [optional]



