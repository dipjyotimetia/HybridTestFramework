
# AutomationTestLogResource

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**links** | [**List&lt;Link&gt;**](Link.md) |  |  [optional]
**id** | **Long** |  |  [optional]
**testCaseVersionId** | **Long** | ID of the Test Case Version |  [optional]
**exeStartDate** | [**DateTime**](DateTime.md) | Execution start date | 
**exeEndDate** | [**DateTime**](DateTime.md) | Execution end date | 
**note** | **String** | Note |  [optional]
**attachments** | [**List&lt;AttachmentResource&gt;**](AttachmentResource.md) | Test Log attachments |  [optional]
**name** | **String** | Test Run&#39;s name |  [optional]
**plannedExeTime** | **Long** |  |  [optional]
**actualExeTime** | **Long** |  |  [optional]
**buildNumber** | **String** | Jenkins jobs build number |  [optional]
**buildUrl** | **String** | Jenkins jobs build URL |  [optional]
**properties** | [**List&lt;PropertyResource&gt;**](PropertyResource.md) |  |  [optional]
**systemName** | **String** |  |  [optional]
**status** | **String** | Test Log status |  [optional]
**order** | **Long** |  |  [optional]
**testStepLogs** | [**List&lt;AutomationTestStepLog&gt;**](AutomationTestStepLog.md) | Arrays of Test Step Log |  [optional]
**moduleNames** | **List&lt;String&gt;** | Arrays of Modules |  [optional]
**agentIds** | **List&lt;Long&gt;** |  |  [optional]
**automationContent** | **String** | Test Case&#39;s automation content |  [optional]
**defectPids** | **List&lt;String&gt;** | Defect pids |  [optional]
**toscaGuid** | **String** | GUID of Tosca test case. |  [optional]
**toscaNodePath** | **String** | Node Path of Tosca test case. |  [optional]



