
# Client

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **Long** |  |  [optional]
**name** | **String** |  |  [optional]
**siteName** | **String** |  |  [optional]
**maxFailedLoginAttempt** | **Integer** |  |  [optional]
**passwordShelfLife** | **Integer** |  |  [optional]
**passwordHealthyPeriod** | **Integer** |  |  [optional]
**minimumUniquePasswordsSequenceLength** | **Integer** |  |  [optional]
**licenseBlobId** | **Long** |  |  [optional]
**sessionTimeoutEnabled** | **Boolean** |  |  [optional]
**sessionTimeoutMinute** | **Integer** |  |  [optional]
**terminateIdleEnabled** | **Boolean** |  |  [optional]
**terminateIdleMinute** | **Integer** |  |  [optional]
**dateFormat** | **String** |  |  [optional]
**rememberMeTimeoutEnabled** | **Boolean** |  |  [optional]
**rememberMeTimeoutDay** | **Integer** |  |  [optional]
**mailRecipients** | **String** |  |  [optional]
**useCustomPasswordPolicy** | **Boolean** |  |  [optional]
**minimumPasswordLength** | **Integer** |  |  [optional]
**passwordContainsCapitalLetters** | **Boolean** |  |  [optional]
**passwordContainsLowercaseLetters** | **Boolean** |  |  [optional]
**passwordContainsNumericChars** | **Boolean** |  |  [optional]
**passwordContainsSpecialChars** | **Boolean** |  |  [optional]
**searchStatus** | [**SearchStatusEnum**](#SearchStatusEnum) |  |  [optional]
**searchMigrationDuration** | **Long** |  |  [optional]
**trackingRequirementTestcaseVersionLink** | **Boolean** |  |  [optional]
**forOnPremise** | **Boolean** |  |  [optional]
**inactive** | **Boolean** |  |  [optional]
**forExplorer** | **Boolean** |  |  [optional]
**tdstenantId** | **String** |  |  [optional]


<a name="SearchStatusEnum"></a>
## Enum: SearchStatusEnum
Name | Value
---- | -----
ELASTICSEARCH | &quot;ELASTICSEARCH&quot;
REINDEXING | &quot;REINDEXING&quot;
ELASTICSEARCH_MIGRATED | &quot;ELASTICSEARCH_MIGRATED&quot;



