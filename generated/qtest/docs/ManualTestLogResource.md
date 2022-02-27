
# ManualTestLogResource

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**submittedBy** | **String** |  |  [optional]
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
**status** | [**StatusResource**](StatusResource.md) |  | 
**resultNumber** | **Long** |  |  [optional]
**testStepLogs** | [**List&lt;TestStepLogResource&gt;**](TestStepLogResource.md) | Arrays of Test Step Log,   With called test steps, the \&quot;called_test_case_id\&quot; and \&quot;parent_test_step_id\&quot; must be included in request body. |  [optional]
**defects** | [**List&lt;LinkedDefectResource&gt;**](LinkedDefectResource.md) | Array of Defect |  [optional]



