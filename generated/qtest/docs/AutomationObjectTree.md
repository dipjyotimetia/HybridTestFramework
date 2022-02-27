
# AutomationObjectTree

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**artifactType** | [**ArtifactTypeEnum**](#ArtifactTypeEnum) |  |  [optional]
**targetReleaseId** | **Long** |  |  [optional]
**targetBuildId** | **Long** |  |  [optional]
**parent** | [**AutomationObjectTree**](AutomationObjectTree.md) |  |  [optional]
**eventType** | [**EventTypeEnum**](#EventTypeEnum) |  |  [optional]
**type** | **String** |  |  [optional]
**id** | **Long** |  |  [optional]
**name** | **String** |  |  [optional]
**order** | **Integer** |  |  [optional]
**children** | **List&lt;String&gt;** |  |  [optional]


<a name="ArtifactTypeEnum"></a>
## Enum: ArtifactTypeEnum
Name | Value
---- | -----
INVALID | &quot;INVALID&quot;
ROOT | &quot;ROOT&quot;
TEST_CASE | &quot;TEST_CASE&quot;
TEST_CYCLE | &quot;TEST_CYCLE&quot;
TEST_SUITE | &quot;TEST_SUITE&quot;
TEST_CASE_RUN | &quot;TEST_CASE_RUN&quot;
RELEASE | &quot;RELEASE&quot;


<a name="EventTypeEnum"></a>
## Enum: EventTypeEnum
Name | Value
---- | -----
CREATED | &quot;CREATED&quot;
UPDATED | &quot;UPDATED&quot;
DELETED | &quot;DELETED&quot;



