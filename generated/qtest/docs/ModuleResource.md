
# ModuleResource

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**links** | [**List&lt;Link&gt;**](Link.md) |  |  [optional]
**id** | **Long** | ID of the Module |  [optional]
**name** | **String** | Name of the Module |  [optional]
**order** | **Integer** | Display order of the Module |  [optional]
**pid** | **String** | PID of the Module |  [optional]
**createdDate** | [**DateTime**](DateTime.md) |  |  [optional]
**lastModifiedDate** | [**DateTime**](DateTime.md) |  |  [optional]
**parentId** | **Long** | Parent Module of the Module |  [optional]
**description** | **String** | Description of the Module |  [optional]
**shared** | **Boolean** | Is shared or not |  [optional]
**projectsSharedTo** | **List&lt;Long&gt;** |  |  [optional]
**children** | [**List&lt;ModuleResource&gt;**](ModuleResource.md) | Arrays of child module |  [optional]
**recursive** | **Boolean** |  |  [optional]
**toscaGuid** | **String** | Tosca folder GUID. Use for creating Module and link with Tosca folder. |  [optional]
**toscaNodePath** | **String** | Tosca folder node path. Use for creating Module and link with Tosca folder. |  [optional]



