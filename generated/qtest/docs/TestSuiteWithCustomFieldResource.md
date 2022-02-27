
# TestSuiteWithCustomFieldResource

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**parentId** | **Long** |  |  [optional]
**parentType** | [**ParentTypeEnum**](#ParentTypeEnum) |  |  [optional]
**links** | [**List&lt;Link&gt;**](Link.md) |  |  [optional]
**id** | **Long** |  |  [optional]
**name** | **String** |  |  [optional]
**order** | **Integer** |  |  [optional]
**pid** | **String** |  |  [optional]
**createdDate** | [**DateTime**](DateTime.md) |  |  [optional]
**lastModifiedDate** | [**DateTime**](DateTime.md) |  |  [optional]
**properties** | [**List&lt;PropertyResource&gt;**](PropertyResource.md) |  | 
**webUrl** | **String** |  |  [optional]
**targetReleaseId** | **Long** |  |  [optional]
**targetBuildId** | **Long** |  |  [optional]


<a name="ParentTypeEnum"></a>
## Enum: ParentTypeEnum
Name | Value
---- | -----
ROOT | &quot;root&quot;
RELEASE | &quot;release&quot;
TEST_CYCLE | &quot;test-cycle&quot;



