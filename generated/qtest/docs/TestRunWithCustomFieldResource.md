
# TestRunWithCustomFieldResource

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**parentId** | **Long** |  |  [optional]
**parentType** | [**ParentTypeEnum**](#ParentTypeEnum) |  |  [optional]
**automation** | **String** |  |  [optional]
**created** | [**DateTime**](DateTime.md) |  |  [optional]
**testCaseId** | **Long** |  |  [optional]
**links** | [**List&lt;Link&gt;**](Link.md) |  |  [optional]
**id** | **Long** |  |  [optional]
**name** | **String** |  |  [optional]
**order** | **Integer** |  |  [optional]
**pid** | **String** |  |  [optional]
**createdDate** | [**DateTime**](DateTime.md) |  |  [optional]
**lastModifiedDate** | [**DateTime**](DateTime.md) |  |  [optional]
**properties** | [**List&lt;PropertyResource&gt;**](PropertyResource.md) |  | 
**testCase** | [**TestCaseWithCustomFieldResource**](TestCaseWithCustomFieldResource.md) |  | 
**latestTestLog** | [**ShortTestLogResource**](ShortTestLogResource.md) |  |  [optional]
**testCaseVersionId** | **Long** |  |  [optional]
**testCaseVersion** | **String** |  |  [optional]
**creatorId** | **Long** |  |  [optional]
**assignParameterValues** | [**List&lt;ParameterTestStepResource&gt;**](ParameterTestStepResource.md) |  |  [optional]
**toscaGuid** | **String** |  |  [optional]
**toscaNodePath** | **String** |  |  [optional]
**toscaWorkspaceUrl** | **String** |  |  [optional]
**toscaTesteventGuid** | **String** |  |  [optional]


<a name="ParentTypeEnum"></a>
## Enum: ParentTypeEnum
Name | Value
---- | -----
ROOT | &quot;root&quot;
RELEASE | &quot;release&quot;
TEST_CYCLE | &quot;test-cycle&quot;
TEST_SUITE | &quot;test-suite&quot;



