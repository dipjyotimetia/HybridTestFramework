# swagger-java-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>io.swagger</groupId>
    <artifactId>swagger-java-client</artifactId>
    <version>11.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-java-client:11.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/swagger-java-client-11.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.AttachmentApi;

import java.io.File;
import java.util.*;

public class AttachmentApiExample {

    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        
        // Configure API key authorization: Authorization
        ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
        Authorization.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //Authorization.setApiKeyPrefix("Token");

        AttachmentApi apiInstance = new AttachmentApi();
        Long projectId = 789L; // Long | ID of the project
        Long blobHandleId = 789L; // Long | ID of the Attachment
        String objectType = "objectType_example"; // String | Valid values include releases, builds, requirements, test-cases, test-logs, test-steps, test-step-logs or defects  <strong>qTest Manager version:</strong> 4+
        Long objectId = 789L; // Long | ID of the object (Release, Build, Requirement, Test Case, Test Log, Test Step, Test Step Log or Defect)
        try {
            Message result = apiInstance.deleteByBlobHandleId(projectId, blobHandleId, objectType, objectId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AttachmentApi#deleteByBlobHandleId");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://apitryout.qtestnet.com/*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*AttachmentApi* | [**deleteByBlobHandleId**](docs/AttachmentApi.md#deleteByBlobHandleId) | **DELETE** /api/v3/projects/{projectId}/{objectType}/{objectId}/blob-handles/{blobHandleId} | Deletes an Attachment from an Object
*AttachmentApi* | [**getAttachment**](docs/AttachmentApi.md#getAttachment) | **GET** /api/v3/projects/{projectId}/{objectType}/{objectId}/attachments/{attachmentId} | Gets an Attachment of an Object
*AttachmentApi* | [**getAttachmentsOf**](docs/AttachmentApi.md#getAttachmentsOf) | **GET** /api/v3/projects/{projectId}/{objectType}/{objectId}/attachments | Gets all Attachments of an Object
*AttachmentApi* | [**search**](docs/AttachmentApi.md#search) | **GET** /api/v3/projects/{projectId}/attachments | Searches for Attachments
*AttachmentApi* | [**upload**](docs/AttachmentApi.md#upload) | **POST** /api/v3/projects/{projectId}/{objectType}/{objectId}/blob-handles | Uploads an Attachment to an Object
*AuthSystemsApi* | [**getAll**](docs/AuthSystemsApi.md#getAll) | **GET** /api/v3/auth-systems | Get multiple Authentication Systems
*AuthSystemsApi* | [**getAllLdapUsers**](docs/AuthSystemsApi.md#getAllLdapUsers) | **GET** /api/v3/auth-systems/ldap/{ldapAuthConfigId}/users | Get all LDAP users of an authentication LDAP config
*AuthSystemsApi* | [**importLDapUsers**](docs/AuthSystemsApi.md#importLDapUsers) | **POST** /api/v3/auth-systems/ldap/{ldapAuthConfigId}/import | Associate Manager users with LDAP users
*AutomationJobApi* | [**createSchedule**](docs/AutomationJobApi.md#createSchedule) | **POST** /api/v3/automation/jobs/schedule/create | Create a Schedule
*AutomationJobApi* | [**searchAutomationAgents**](docs/AutomationJobApi.md#searchAutomationAgents) | **POST** /api/v3/automation/automation-agents | Search automation agents
*BuildApi* | [**create**](docs/BuildApi.md#create) | **POST** /api/v3/projects/{projectId}/builds | Creates a Build
*BuildApi* | [**delete**](docs/BuildApi.md#delete) | **DELETE** /api/v3/projects/{projectId}/builds/{buildId} | Deletes a Build
*BuildApi* | [**get**](docs/BuildApi.md#get) | **GET** /api/v3/projects/{projectId}/builds/{buildId} | Gets a Build
*BuildApi* | [**getBuilds**](docs/BuildApi.md#getBuilds) | **GET** /api/v3/projects/{projectId}/builds | Gets multiple Builds
*BuildApi* | [**update**](docs/BuildApi.md#update) | **PUT** /api/v3/projects/{projectId}/builds/{buildId} | Updates a Build
*CommonApi* | [**editSystemField**](docs/CommonApi.md#editSystemField) | **POST** /api/v3/projects/{projectId}/settings/{objectType}/system-fields/{fieldId} | Edit System Field of an Object Type by the field
*CommonApi* | [**updateCustomFieldStatus**](docs/CommonApi.md#updateCustomFieldStatus) | **POST** /api/v3/projects/{projectId}/settings/{objectType}/custom-fields/active | Update active or inactive custom fields of an Object Type
*DefectApi* | [**addComment**](docs/DefectApi.md#addComment) | **POST** /api/v3/projects/{projectId}/defects/{idOrKey}/comments | Adds a Comment to a Defect
*DefectApi* | [**deleteComment**](docs/DefectApi.md#deleteComment) | **DELETE** /api/v3/projects/{projectId}/defects/{idOrKey}/comments/{commentId} | Deletes a Comment of a Defect
*DefectApi* | [**getComments**](docs/DefectApi.md#getComments) | **GET** /api/v3/projects/{projectId}/defects/{idOrKey}/comments | Gets all Comments of a Defect
*DefectApi* | [**getDefect**](docs/DefectApi.md#getDefect) | **GET** /api/v3/projects/{projectId}/defects/{defectId} | Gets a Defect
*DefectApi* | [**getDefectCommentById**](docs/DefectApi.md#getDefectCommentById) | **GET** /api/v3/projects/{projectId}/defects/{idOrKey}/comments/{commentId} | Gets a Comment of a Defect
*DefectApi* | [**getLastChanged**](docs/DefectApi.md#getLastChanged) | **GET** /api/v3/projects/{projectId}/defects/last-change | Gets recently updated Defects
*DefectApi* | [**submitDefect**](docs/DefectApi.md#submitDefect) | **POST** /api/v3/projects/{projectId}/defects | Submit a Defect
*DefectApi* | [**updateComment**](docs/DefectApi.md#updateComment) | **PUT** /api/v3/projects/{projectId}/defects/{idOrKey}/comments/{commentId} | Updates a Comment of a Defect
*DefectApi* | [**updateDefect**](docs/DefectApi.md#updateDefect) | **PUT** /api/v3/projects/{projectId}/defects/{defectId} | Updates a Defect
*FieldApi* | [**createCustomField**](docs/FieldApi.md#createCustomField) | **POST** /api/v3/projects/{projectId}/settings/{objectType}/fields | Creates a Custom Field of an Object Type
*FieldApi* | [**createCustomSiteField**](docs/FieldApi.md#createCustomSiteField) | **POST** /api/v3/fields/{objectType} | Creates a Custom Site Field of an Object Type
*FieldApi* | [**createProjectFieldAllowedValues**](docs/FieldApi.md#createProjectFieldAllowedValues) | **POST** /api/v3/projects/{projectId}/settings/{objectType}/fields/{fieldId}/allowed-values | Creates allowed values of a Project Field
*FieldApi* | [**createSiteFieldAllowedValues**](docs/FieldApi.md#createSiteFieldAllowedValues) | **POST** /api/v3/fields/{objectType}/{fieldId}/allowed-values | Creates allowed values of a Site Field
*FieldApi* | [**deleteCustomField**](docs/FieldApi.md#deleteCustomField) | **DELETE** /api/v3/projects/{projectId}/settings/{objectType}/fields/{fieldId} | Deletes a Custom Field of an Object Type
*FieldApi* | [**deleteCustomSiteField**](docs/FieldApi.md#deleteCustomSiteField) | **DELETE** /api/v3/fields/{objectType}/{fieldId} | Deletes a Custom Site Field of an Object Type
*FieldApi* | [**deleteProjectFieldValue**](docs/FieldApi.md#deleteProjectFieldValue) | **DELETE** /api/v3/projects/{projectId}/settings/{objectType}/fields/{fieldId}/allowed-values/{value} | Deletes an allowed value of a Project Field
*FieldApi* | [**deleteSiteFieldValue**](docs/FieldApi.md#deleteSiteFieldValue) | **DELETE** /api/v3/fields/{objectType}/{fieldId}/allowed-values/{value} | Deletes an allowed value of a Site Field
*FieldApi* | [**getAllSiteFields**](docs/FieldApi.md#getAllSiteFields) | **GET** /api/v3/fields/{objectType} | Gets all site field of an object type
*FieldApi* | [**getCustomField**](docs/FieldApi.md#getCustomField) | **GET** /api/v3/projects/{projectId}/settings/{objectType}/fields/{fieldId} | Gets a Custom Field of an Object Type
*FieldApi* | [**getCustomSiteField**](docs/FieldApi.md#getCustomSiteField) | **GET** /api/v3/fields/{objectType}/{fieldId} | Gets a Custom Site Field of an Object Type
*FieldApi* | [**getFields**](docs/FieldApi.md#getFields) | **GET** /api/v3/projects/{projectId}/settings/{objectType}/fields | Gets all Fields of an Object Type
*FieldApi* | [**getProjectFieldAllowedValues**](docs/FieldApi.md#getProjectFieldAllowedValues) | **GET** /api/v3/projects/{projectId}/settings/{objectType}/fields/{fieldId}/allowed-values | Gets all allowed values of a Project Field
*FieldApi* | [**getSiteFieldAllowedValues**](docs/FieldApi.md#getSiteFieldAllowedValues) | **GET** /api/v3/fields/{objectType}/{fieldId}/allowed-values | Gets all allowed values of a Site Field
*FieldApi* | [**updateCustomField**](docs/FieldApi.md#updateCustomField) | **PUT** /api/v3/projects/{projectId}/settings/{objectType}/fields/{fieldId} | Updates a Custom Field of an Object Type
*FieldApi* | [**updateCustomSiteField**](docs/FieldApi.md#updateCustomSiteField) | **PUT** /api/v3/fields/{objectType}/{fieldId} | Updates a Custom Site Field of an Object Type
*FieldApi* | [**updateProjectFieldAllowedValues**](docs/FieldApi.md#updateProjectFieldAllowedValues) | **PUT** /api/v3/projects/{projectId}/settings/{objectType}/fields/{fieldId}/allowed-values/{value} | Updates an allowed value of a Project Field
*FieldApi* | [**updateSiteFieldAllowedValues**](docs/FieldApi.md#updateSiteFieldAllowedValues) | **PUT** /api/v3/fields/{objectType}/{fieldId}/allowed-values/{value} | Updates an allowed value of a Site Field
*GroupsApi* | [**createCustomUserGroup**](docs/GroupsApi.md#createCustomUserGroup) | **POST** /api/v3/groups | Create custom UserGroup
*GroupsApi* | [**getAllUserGroups**](docs/GroupsApi.md#getAllUserGroups) | **GET** /api/v3/groups | Get multiple UserGroups
*IntegrationSettingsApi* | [**addNewConnection**](docs/IntegrationSettingsApi.md#addNewConnection) | **POST** /api/v3/projects/{projectId}/settings/integration/connections | Add a new Jira connection
*IntegrationSettingsApi* | [**addNewDefectMapping**](docs/IntegrationSettingsApi.md#addNewDefectMapping) | **POST** /api/v3/projects/{projectId}/settings/integration/connections/{connectionId}/defect/mappings | Add a defect mapping to a Jira connection
*IntegrationSettingsApi* | [**addNewReleaseMapping**](docs/IntegrationSettingsApi.md#addNewReleaseMapping) | **POST** /api/v3/projects/{projectId}/settings/integration/connections/{connectionId}/release/mappings | Add a new Jira release mapping to a Jira connection
*IntegrationSettingsApi* | [**addNewRequirementMapping**](docs/IntegrationSettingsApi.md#addNewRequirementMapping) | **POST** /api/v3/projects/{projectId}/settings/integration/connections/{connectionId}/requirement/mappings | Add a requirement mapping to a Jira connection
*IntegrationSettingsApi* | [**configurePopulatingJiraUnlinkedDefects**](docs/IntegrationSettingsApi.md#configurePopulatingJiraUnlinkedDefects) | **PUT** /api/v3/projects/{projectId}/settings/integration/connections/{connectionId}/defect | Enable or disable populating Jira Unlinked Defects of a Jira connection
*IntegrationSettingsApi* | [**configureReleaseMapping**](docs/IntegrationSettingsApi.md#configureReleaseMapping) | **PUT** /api/v3/projects/{projectId}/settings/integration/connections/{connectionId}/release/mappings | Update a Release Mapping of a Jira connection
*IntegrationSettingsApi* | [**configureRequirementMapping**](docs/IntegrationSettingsApi.md#configureRequirementMapping) | **PUT** /api/v3/projects/{projectId}/settings/integration/connections/{connectionId}/requirement/mappings | Update a requirement mapping of a Jira connection
*IntegrationSettingsApi* | [**deleteConnection**](docs/IntegrationSettingsApi.md#deleteConnection) | **DELETE** /api/v3/projects/{projectId}/settings/integration/connections/{connectionId} | Delete a Jira connection
*IntegrationSettingsApi* | [**getAuthorizeURL**](docs/IntegrationSettingsApi.md#getAuthorizeURL) | **GET** /api/v3/projects/{projectId}/settings/integration/connections/oauthAuthorizeURL | OAuth Authorize URL
*IntegrationSettingsApi* | [**getConnections**](docs/IntegrationSettingsApi.md#getConnections) | **GET** /api/v3/projects/{projectId}/settings/integration/connections | Get all Jira connections of a project
*IntegrationSettingsApi* | [**getDefectMappings**](docs/IntegrationSettingsApi.md#getDefectMappings) | **GET** /api/v3/projects/{projectId}/settings/integration/connections/{connectionId}/defect/mappings | Get Jira defect mappings of a Jira connection
*IntegrationSettingsApi* | [**getReleaseMappings**](docs/IntegrationSettingsApi.md#getReleaseMappings) | **GET** /api/v3/projects/{projectId}/settings/integration/connections/{connectionId}/release/mappings | Get Jira release mappings of a Jira connection
*IntegrationSettingsApi* | [**refreshFieldSettings**](docs/IntegrationSettingsApi.md#refreshFieldSettings) | **POST** /api/v3/projects/{projectId}/settings/integration/connections/{connectionId}/refreshFieldSettings | Trigger retrieving latest field settings from a JIRA connection
*IntegrationSettingsApi* | [**removeMapping**](docs/IntegrationSettingsApi.md#removeMapping) | **DELETE** /api/v3/projects/{projectId}/settings/integration/connections/{connectionId}/{artifact}/mappings | Remove a Mapping of a Jira connection
*IntegrationSettingsApi* | [**retrieveAllRequirementMappingsOfConnection**](docs/IntegrationSettingsApi.md#retrieveAllRequirementMappingsOfConnection) | **GET** /api/v3/projects/{projectId}/settings/integration/connections/{connectionId}/requirement/mappings | Get requirement mappings of a Jira connection
*IntegrationSettingsApi* | [**toggleReleaseIntegration**](docs/IntegrationSettingsApi.md#toggleReleaseIntegration) | **PUT** /api/v3/projects/{projectId}/settings/integration/connections/{connectionId}/release | Enable or disable Release Integration feature of a Jira connection
*IntegrationSettingsApi* | [**toggleRequirementIntegration**](docs/IntegrationSettingsApi.md#toggleRequirementIntegration) | **PUT** /api/v3/projects/{projectId}/settings/integration/connections/{connectionId}/requirement | Enable or disable a Requirement Integration feature of a Jira connection
*IntegrationSettingsApi* | [**triggerRetrievingDataForConnection**](docs/IntegrationSettingsApi.md#triggerRetrievingDataForConnection) | **GET** /api/v3/projects/{projectId}/settings/integration/connections/{connectionId}/retrieve | Trigger data retrieval from an integrated Jira system
*IntegrationSettingsApi* | [**triggerRetrievingDefectDataForConnection**](docs/IntegrationSettingsApi.md#triggerRetrievingDefectDataForConnection) | **POST** /api/v3/projects/{projectId}/settings/jira-integration/defect/retrieve | Trigger defect retrieval from an integrated Jira system
*IntegrationSettingsApi* | [**updateDefectMapping**](docs/IntegrationSettingsApi.md#updateDefectMapping) | **PUT** /api/v3/projects/{projectId}/settings/integration/connections/{connectionId}/defect/mappings | Update a defect mapping of Jira connection
*IntegrationSettingsApi* | [**updateIntegrationConnectionStatus**](docs/IntegrationSettingsApi.md#updateIntegrationConnectionStatus) | **PUT** /api/v3/projects/{projectId}/settings/integration/connections/{connectionId} | Activate or deactivate a Jira connection
*LoginApi* | [**postAccessToken**](docs/LoginApi.md#postAccessToken) | **POST** /oauth/token | Log in
*LoginApi* | [**tokenStatus**](docs/LoginApi.md#tokenStatus) | **GET** /oauth/status | Gets status of access token
*ModuleApi* | [**createModule**](docs/ModuleApi.md#createModule) | **POST** /api/v3/projects/{projectId}/modules | Creates a Module
*ModuleApi* | [**deleteModule**](docs/ModuleApi.md#deleteModule) | **DELETE** /api/v3/projects/{projectId}/modules/{moduleId} | Deletes a Module
*ModuleApi* | [**getModule**](docs/ModuleApi.md#getModule) | **GET** /api/v3/projects/{projectId}/modules/{moduleId} | Gets a Module
*ModuleApi* | [**getSubModulesOf**](docs/ModuleApi.md#getSubModulesOf) | **GET** /api/v3/projects/{projectId}/modules | Gets multiple Modules
*ModuleApi* | [**updateModule**](docs/ModuleApi.md#updateModule) | **PUT** /api/v3/projects/{projectId}/modules/{moduleId} | Updates a Module
*ObjectLinkApi* | [**find**](docs/ObjectLinkApi.md#find) | **GET** /api/v3/projects/{projectId}/linked-artifacts | Gets associated objects of given objects
*ObjectLinkApi* | [**linkArtifacts**](docs/ObjectLinkApi.md#linkArtifacts) | **POST** /api/v3/projects/{projectId}/{objectType}/{objectId}/link | Creates links between objects
*ObjectLinkApi* | [**linkArtifactsByPid**](docs/ObjectLinkApi.md#linkArtifactsByPid) | **POST** /api/v3/projects/{projectId}/{objectType}/{objectId}/{linkType} | Creates links between objects by pids
*ObjectLinkApi* | [**unlinkArtifacts**](docs/ObjectLinkApi.md#unlinkArtifacts) | **DELETE** /api/v3/projects/{projectId}/{objectType}/{objectId}/link | Removes links between objects
*ObjectLinkApi* | [**unlinkArtifactsByPid**](docs/ObjectLinkApi.md#unlinkArtifactsByPid) | **DELETE** /api/v3/projects/{projectId}/{objectType}/{objectId}/{linkType} | Removes links between objects by pids
*ProjectApi* | [**createProject**](docs/ProjectApi.md#createProject) | **POST** /api/v3/projects | Creates a Project
*ProjectApi* | [**getCurrentProfile**](docs/ProjectApi.md#getCurrentProfile) | **GET** /api/v3/projects/{projectId}/user-profiles/current | Gets current user Permissions in a Project
*ProjectApi* | [**getProject**](docs/ProjectApi.md#getProject) | **GET** /api/v3/projects/{projectId} | Gets a Project
*ProjectApi* | [**getProjects**](docs/ProjectApi.md#getProjects) | **GET** /api/v3/projects | Gets multiple Projects
*ProjectApi* | [**getUsers**](docs/ProjectApi.md#getUsers) | **GET** /api/v3/projects/{projectId}/users | Gets all Users in a Project
*ProjectApi* | [**searchProjects**](docs/ProjectApi.md#searchProjects) | **POST** /api/v3/projects/search | Search for projects
*ProjectApi* | [**updateProject**](docs/ProjectApi.md#updateProject) | **PUT** /api/v3/projects/{projectId} | Updates a Project
*ReleaseApi* | [**createRelease**](docs/ReleaseApi.md#createRelease) | **POST** /api/v3/projects/{projectId}/releases | Creates a Release
*ReleaseApi* | [**deleteReleaseById**](docs/ReleaseApi.md#deleteReleaseById) | **DELETE** /api/v3/projects/{projectId}/releases/{releaseId} | Delete a release
*ReleaseApi* | [**getAllReleases**](docs/ReleaseApi.md#getAllReleases) | **GET** /api/v3/projects/{projectId}/releases | Gets multiple Releases
*ReleaseApi* | [**getReleaseById**](docs/ReleaseApi.md#getReleaseById) | **GET** /api/v3/projects/{projectId}/releases/{releaseId} | Gets a Release
*ReleaseApi* | [**updateReleaseById**](docs/ReleaseApi.md#updateReleaseById) | **PUT** /api/v3/projects/{projectId}/releases/{releaseId} | Updates a Release
*RequirementApi* | [**addRequirementComment**](docs/RequirementApi.md#addRequirementComment) | **POST** /api/v3/projects/{projectId}/requirements/{idOrKey}/comments | Adds a Comment to a Requirement
*RequirementApi* | [**createRequirement**](docs/RequirementApi.md#createRequirement) | **POST** /api/v3/projects/{projectId}/requirements | Creates a Requirement
*RequirementApi* | [**deleteRequirementById**](docs/RequirementApi.md#deleteRequirementById) | **DELETE** /api/v3/projects/{projectId}/requirements/{requirementId} | Deletes a Requirement
*RequirementApi* | [**deleteRequirementCommentById**](docs/RequirementApi.md#deleteRequirementCommentById) | **DELETE** /api/v3/projects/{projectId}/requirements/{idOrKey}/comments/{commentId} | Deletes a Comment of a Requirement
*RequirementApi* | [**getAllRequirementComments**](docs/RequirementApi.md#getAllRequirementComments) | **GET** /api/v3/projects/{projectId}/requirements/{idOrKey}/comments | Gets all Comments of a Requirement
*RequirementApi* | [**getPublicTraceabilityMatrixReport**](docs/RequirementApi.md#getPublicTraceabilityMatrixReport) | **GET** /api/v3/projects/{projectId}/requirements/trace-matrix-report | Gets Requirement Traceability Matrix Report
*RequirementApi* | [**getRequirement**](docs/RequirementApi.md#getRequirement) | **GET** /api/v3/projects/{projectId}/requirements/{requirementId} | Gets a Requirement
*RequirementApi* | [**getRequirementCommentById**](docs/RequirementApi.md#getRequirementCommentById) | **GET** /api/v3/projects/{projectId}/requirements/{idOrKey}/comments/{commentId} | Gets a Comment of a Requirement
*RequirementApi* | [**getRequirements**](docs/RequirementApi.md#getRequirements) | **GET** /api/v3/projects/{projectId}/requirements | Gets multiple Requirements
*RequirementApi* | [**updateRequirement**](docs/RequirementApi.md#updateRequirement) | **PUT** /api/v3/projects/{projectId}/requirements/{requirementId} | Updates a Requirement
*RequirementApi* | [**updateRequirementCommentById**](docs/RequirementApi.md#updateRequirementCommentById) | **PUT** /api/v3/projects/{projectId}/requirements/{idOrKey}/comments/{commentId} | Updates a Comment of a Requirement
*SearchApi* | [**queryHistories**](docs/SearchApi.md#queryHistories) | **POST** /api/v3/projects/{projectId}/histories | Queries objects&#39; histories
*SearchApi* | [**searchArtifact**](docs/SearchApi.md#searchArtifact) | **POST** /api/v3/projects/{projectId}/search | Queries objects
*SearchApi* | [**searchCommentWithQuery**](docs/SearchApi.md#searchCommentWithQuery) | **POST** /api/v3/projects/{projectId}/comments | Queries Comments
*SiteTemplatesApi* | [**addProjects**](docs/SiteTemplatesApi.md#addProjects) | **POST** /api/v3/site-templates/{templateId}/projects | Apply template to existing projects.
*SiteTemplatesApi* | [**getAllSiteTemplates**](docs/SiteTemplatesApi.md#getAllSiteTemplates) | **GET** /api/v3/site-templates | Get all site-templates
*SiteTemplatesApi* | [**removeProjectTemplates**](docs/SiteTemplatesApi.md#removeProjectTemplates) | **DELETE** /api/v3/site-templates/{templateId}/projects | Remove projects from a site template.
*TestCaseApi* | [**addTestCaseComment**](docs/TestCaseApi.md#addTestCaseComment) | **POST** /api/v3/projects/{projectId}/test-cases/{idOrKey}/comments | Adds a Comment to a Test Case
*TestCaseApi* | [**addTestStep**](docs/TestCaseApi.md#addTestStep) | **POST** /api/v3/projects/{projectId}/test-cases/{testCaseId}/test-steps | Creates a Test Step
*TestCaseApi* | [**approveTestCase**](docs/TestCaseApi.md#approveTestCase) | **PUT** /api/v3/projects/{projectId}/test-cases/{testCaseId}/approve | Approves a Test Case
*TestCaseApi* | [**approveTestCaseByVera**](docs/TestCaseApi.md#approveTestCaseByVera) | **PUT** /api/v3/projects/{projectId}/test-cases/{testCaseId}/vera/approve | test-case.vera.approve
*TestCaseApi* | [**createTestCase**](docs/TestCaseApi.md#createTestCase) | **POST** /api/v3/projects/{projectId}/test-cases | Creates a Test Case
*TestCaseApi* | [**deleteTestCase**](docs/TestCaseApi.md#deleteTestCase) | **DELETE** /api/v3/projects/{projectId}/test-cases/{testCaseId} | Deletes a Test Case
*TestCaseApi* | [**deleteTestCaseComment**](docs/TestCaseApi.md#deleteTestCaseComment) | **DELETE** /api/v3/projects/{projectId}/test-cases/{idOrKey}/comments/{commentId} | Deletes a Comment of a Test Case
*TestCaseApi* | [**deleteTestStep**](docs/TestCaseApi.md#deleteTestStep) | **DELETE** /api/v3/projects/{projectId}/test-cases/{testCaseId}/test-steps/{stepId} | Deletes a Test Step
*TestCaseApi* | [**getTestCase**](docs/TestCaseApi.md#getTestCase) | **GET** /api/v3/projects/{projectId}/test-cases/{testCaseIdOrPid} | Gets a Test Case
*TestCaseApi* | [**getTestCaseCommentById**](docs/TestCaseApi.md#getTestCaseCommentById) | **GET** /api/v3/projects/{projectId}/test-cases/{idOrKey}/comments/{commentId} | Gets a Comment of a Test Case
*TestCaseApi* | [**getTestCaseComments**](docs/TestCaseApi.md#getTestCaseComments) | **GET** /api/v3/projects/{projectId}/test-cases/{idOrKey}/comments | Gets all Comments of a Test Case
*TestCaseApi* | [**getTestCaseVersionById**](docs/TestCaseApi.md#getTestCaseVersionById) | **GET** /api/v3/projects/{projectId}/test-cases/{testCaseId}/versions/{versionId} | Gets a version of a Test Case
*TestCaseApi* | [**getTestCases**](docs/TestCaseApi.md#getTestCases) | **GET** /api/v3/projects/{projectId}/test-cases | Gets multiple Test Cases
*TestCaseApi* | [**getTestStep**](docs/TestCaseApi.md#getTestStep) | **GET** /api/v3/projects/{projectId}/test-cases/{testCaseId}/test-steps/{stepId} | Gets a Test Step
*TestCaseApi* | [**getTestSteps**](docs/TestCaseApi.md#getTestSteps) | **GET** /api/v3/projects/{projectId}/test-cases/{testCaseId}/test-steps | Gets Test Steps of a Test Case
*TestCaseApi* | [**getTestStepsByVersion**](docs/TestCaseApi.md#getTestStepsByVersion) | **GET** /api/v3/projects/{projectId}/test-cases/{testCaseId}/versions/{versionId}/test-steps | Gets Test Steps of a Test Case version
*TestCaseApi* | [**getVersions**](docs/TestCaseApi.md#getVersions) | **GET** /api/v3/projects/{projectId}/test-cases/{testCaseId}/versions | Gets all versions of a Test Case
*TestCaseApi* | [**updateMultipleTestCases**](docs/TestCaseApi.md#updateMultipleTestCases) | **PUT** /api/v3/projects/{projectId}/test-cases/update/testcases | Updates multiple test cases
*TestCaseApi* | [**updateTestCase**](docs/TestCaseApi.md#updateTestCase) | **PUT** /api/v3/projects/{projectId}/test-cases/{testCaseId} | Updates a Test Case
*TestCaseApi* | [**updateTestCaseComment**](docs/TestCaseApi.md#updateTestCaseComment) | **PUT** /api/v3/projects/{projectId}/test-cases/{idOrKey}/comments/{commentId} | Updates a Comment of a Test Case
*TestCaseApi* | [**updateTestStep**](docs/TestCaseApi.md#updateTestStep) | **PUT** /api/v3/projects/{projectId}/test-cases/{testCaseId}/test-steps/{stepId} | Update a Test Step
*TestCycleApi* | [**createCycle**](docs/TestCycleApi.md#createCycle) | **POST** /api/v3/projects/{projectId}/test-cycles | Create a Test Cycle
*TestCycleApi* | [**deleteCycle**](docs/TestCycleApi.md#deleteCycle) | **DELETE** /api/v3/projects/{projectId}/test-cycles/{testCycleId} | Deletes a Test Cycle
*TestCycleApi* | [**getTestCycle**](docs/TestCycleApi.md#getTestCycle) | **GET** /api/v3/projects/{projectId}/test-cycles/{testCycleId} | Gets a Test Cycle
*TestCycleApi* | [**getTestCycles**](docs/TestCycleApi.md#getTestCycles) | **GET** /api/v3/projects/{projectId}/test-cycles | Gets multiple Test Cycles
*TestCycleApi* | [**updateCycle**](docs/TestCycleApi.md#updateCycle) | **PUT** /api/v3/projects/{projectId}/test-cycles/{testCycleId} | Updates a Test Cycle
*TestLogApi* | [**getLastRunLog**](docs/TestLogApi.md#getLastRunLog) | **GET** /api/v3/projects/{projectId}/test-runs/{testRunId}/test-logs/last-run | Gets the latest Test Log of a Test Run
*TestLogApi* | [**getTestLog**](docs/TestLogApi.md#getTestLog) | **GET** /api/v3/projects/{projectId}/test-runs/{testRunId}/test-logs/{id} | Gets a Test Log of a Test Run
*TestLogApi* | [**getTestLogsList**](docs/TestLogApi.md#getTestLogsList) | **GET** /api/v3/projects/{projectId}/test-runs/{testRunId}/test-logs | Gets all Test Logs of a Test Run
*TestLogApi* | [**modifyAutomationLog**](docs/TestLogApi.md#modifyAutomationLog) | **PUT** /api/v3/projects/{projectId}/test-runs/{testRunId}/auto-test-logs/{id} | Modify an Automation Test Log
*TestLogApi* | [**modifyTestLog**](docs/TestLogApi.md#modifyTestLog) | **PUT** /api/v3/projects/{projectId}/test-runs/{testRunId}/test-logs/{id} | Modify a Manual Test Log
*TestLogApi* | [**submitAutomationLog**](docs/TestLogApi.md#submitAutomationLog) | **POST** /api/v3/projects/{projectId}/test-runs/{testRunId}/auto-test-logs | Submits an Automation Test Log
*TestLogApi* | [**submitAutomationTestLogs**](docs/TestLogApi.md#submitAutomationTestLogs) | **POST** /api/v3.1/projects/{projectId}/test-runs/{testRunId}/auto-test-logs | Submits multiple test results
*TestLogApi* | [**submitAutomationTestLogsWithTreeStructure**](docs/TestLogApi.md#submitAutomationTestLogsWithTreeStructure) | **POST** /api/v3/projects/{projectId}/auto-test-logs | Submits multiple test results and specifies Test Design and Test Execution tree structures
*TestLogApi* | [**submitTestLog**](docs/TestLogApi.md#submitTestLog) | **POST** /api/v3/projects/{projectId}/test-runs/{testRunId}/test-logs | Submits a Manual Test Log
*TestLogApi* | [**track**](docs/TestLogApi.md#track) | **GET** /api/v3/projects/queue-processing/{id} | Gets a Batch Test Log Submission job&#39;s state
*TestRunApi* | [**addTestRunComment**](docs/TestRunApi.md#addTestRunComment) | **POST** /api/v3/projects/{projectId}/test-runs/{idOrKey}/comments | Adds a Comment to a Test Run
*TestRunApi* | [**addTestRunWithParameters**](docs/TestRunApi.md#addTestRunWithParameters) | **POST** /api/v3/projects/{projectId}/test-runs/assign-parameter-values/manually | Create multiple Test Runs with Parameter values manual
*TestRunApi* | [**addTestRunWithParametersDataset**](docs/TestRunApi.md#addTestRunWithParametersDataset) | **POST** /api/v3/projects/{projectId}/test-runs/assign-parameter-values/dataset | Create multiple Test Runs with Parameter values from dataset.
*TestRunApi* | [**addTestRunWithParametersRandomize**](docs/TestRunApi.md#addTestRunWithParametersRandomize) | **POST** /api/v3/projects/{projectId}/test-runs/assign-parameter-values/randomize | Create multiple Test Runs with Parameter values random from selection combine type.
*TestRunApi* | [**createTestRun**](docs/TestRunApi.md#createTestRun) | **POST** /api/v3/projects/{projectId}/test-runs | Creates a Test Run
*TestRunApi* | [**deleteCommentById**](docs/TestRunApi.md#deleteCommentById) | **DELETE** /api/v3/projects/{projectId}/test-runs/{idOrKey}/comments/{commentId} | Deletes a Comment of a Test Run
*TestRunApi* | [**deleteTestRunById**](docs/TestRunApi.md#deleteTestRunById) | **DELETE** /api/v3/projects/{projectId}/test-runs/{testRunId} | Deletes a Test Run
*TestRunApi* | [**getOf**](docs/TestRunApi.md#getOf) | **GET** /api/v3/projects/{projectId}/test-runs | Gets multiple Test Runs
*TestRunApi* | [**getStatusValuable**](docs/TestRunApi.md#getStatusValuable) | **GET** /api/v3/projects/{projectId}/test-runs/execution-statuses | Gets Test Run statuses
*TestRunApi* | [**getSubhierachy**](docs/TestRunApi.md#getSubhierachy) | **GET** /api/v3/projects/{projectId}/test-runs/subhierarchy | Gets a Sub Hierarchy
*TestRunApi* | [**getTestRunById**](docs/TestRunApi.md#getTestRunById) | **GET** /api/v3/projects/{projectId}/test-runs/{testRunId} | Gets a Test Run
*TestRunApi* | [**getTestRunCommentById**](docs/TestRunApi.md#getTestRunCommentById) | **GET** /api/v3/projects/{projectId}/test-runs/{idOrKey}/comments/{commentId} | Gets a Comment from a Test Run
*TestRunApi* | [**getTestRunComments**](docs/TestRunApi.md#getTestRunComments) | **GET** /api/v3/projects/{projectId}/test-runs/{idOrKey}/comments | Gets all Comments of a Test Run
*TestRunApi* | [**updateCommentById**](docs/TestRunApi.md#updateCommentById) | **PUT** /api/v3/projects/{projectId}/test-runs/{idOrKey}/comments/{commentId} | Updates a Comment of a Test Run
*TestRunApi* | [**updateTestRunById**](docs/TestRunApi.md#updateTestRunById) | **PUT** /api/v3/projects/{projectId}/test-runs/{testRunId} | Updates a Test Run
*TestSuiteApi* | [**createTestSuite**](docs/TestSuiteApi.md#createTestSuite) | **POST** /api/v3/projects/{projectId}/test-suites | Creates a Test Suite
*TestSuiteApi* | [**deleteTestSuiteById**](docs/TestSuiteApi.md#deleteTestSuiteById) | **DELETE** /api/v3/projects/{projectId}/test-suites/{testSuiteId} | Deletes a Test Suite
*TestSuiteApi* | [**getListTestSuite**](docs/TestSuiteApi.md#getListTestSuite) | **GET** /api/v3/projects/{projectId}/test-suites | Gets multiple Test Suite
*TestSuiteApi* | [**getTestSuite**](docs/TestSuiteApi.md#getTestSuite) | **GET** /api/v3/projects/{projectId}/test-suites/{testSuiteId} | Gets a Test Suite
*TestSuiteApi* | [**updateTestSuite**](docs/TestSuiteApi.md#updateTestSuite) | **PUT** /api/v3/projects/{projectId}/test-suites/{testSuiteId} | Updates a Test Suite
*ToscaApi* | [**notifyTestEventImport**](docs/ToscaApi.md#notifyTestEventImport) | **POST** /api/v3/projects/{projectId}/tosca/import/test-event | Import Tosca TestEvent objects
*UserApi* | [**assignToProject**](docs/UserApi.md#assignToProject) | **POST** /api/v3/users/{userId}/projects | Assigns a User to a Project
*UserApi* | [**assignUsersToProject**](docs/UserApi.md#assignUsersToProject) | **POST** /api/v3/users/projects | Assigns multiple Users to a Project
*UserApi* | [**createUser**](docs/UserApi.md#createUser) | **POST** /api/v3/users | Invites a User
*UserApi* | [**findByUserNameOrEmail**](docs/UserApi.md#findByUserNameOrEmail) | **GET** /api/v3/users/search | Queries Users by Username
*UserApi* | [**findUsersByProjectsName**](docs/UserApi.md#findUsersByProjectsName) | **GET** /api/v3/search/user | Queries Users by Project Name
*UserApi* | [**getAvatar**](docs/UserApi.md#getAvatar) | **GET** /api/v3/users/{userId}/avatar | Gets a User&#39;s Avatar
*UserApi* | [**getUserById**](docs/UserApi.md#getUserById) | **GET** /api/v3/users/{userId} | Gets a User
*UserApi* | [**reevaluateToken**](docs/UserApi.md#reevaluateToken) | **GET** /api/v3/re-evaluation | Gets current user&#39;s information
*UserApi* | [**removeAssociationUsersAndProjects**](docs/UserApi.md#removeAssociationUsersAndProjects) | **PUT** /api/v3/users/projects | Remove association between users and projects
*UserApi* | [**updateUser**](docs/UserApi.md#updateUser) | **PUT** /api/v3/users/{userId} | Update user&#39;s information
*UserProfileApi* | [**batchAssignUserProfileInClient**](docs/UserProfileApi.md#batchAssignUserProfileInClient) | **POST** /api/v3/user-profiles/batch-assign-users | Assigns multiple Users to a Profile
*UserProfileApi* | [**batchAssignUserProfileInProject**](docs/UserProfileApi.md#batchAssignUserProfileInProject) | **POST** /api/v3/user-profiles/{projectId}/batch-assign-users | Assigns multiple Users to a Profile in a Project
*UserProfileApi* | [**getCurrent**](docs/UserProfileApi.md#getCurrent) | **GET** /api/v3/admin-profiles/current | Gets current User&#39;s Admin Profile
*UserProfileApi* | [**getProfilesOfCurrentUser**](docs/UserProfileApi.md#getProfilesOfCurrentUser) | **GET** /api/v3/user-profiles/current | Gets current User&#39;s Profiles in different Projects
*UserProfileApi* | [**getUserProfiles**](docs/UserProfileApi.md#getUserProfiles) | **GET** /api/v3/user-profiles | Gets available Profiles
*WebhookApi* | [**createWebhook**](docs/WebhookApi.md#createWebhook) | **POST** /api/v3/webhooks | Registers a webhook
*WebhookApi* | [**deleteWebhookById**](docs/WebhookApi.md#deleteWebhookById) | **DELETE** /api/v3/webhooks/{webhookId} | Deletes a webhook
*WebhookApi* | [**getAllEventNames**](docs/WebhookApi.md#getAllEventNames) | **GET** /api/v3/webhooks/events | Get list of webhook event names
*WebhookApi* | [**getAllWebhooks**](docs/WebhookApi.md#getAllWebhooks) | **GET** /api/v3/webhooks | Gets list of all registered webhooks
*WebhookApi* | [**getWebhookById**](docs/WebhookApi.md#getWebhookById) | **GET** /api/v3/webhooks/{webhookId} | Gets a webhook
*WebhookApi* | [**updateWebhook**](docs/WebhookApi.md#updateWebhook) | **PUT** /api/v3/webhooks/{webhookId} | Updates a webhook


## Documentation for Models

 - [AdminProfile](docs/AdminProfile.md)
 - [AllowedValueInputResource](docs/AllowedValueInputResource.md)
 - [AllowedValueResource](docs/AllowedValueResource.md)
 - [AllowedValueResponseResource](docs/AllowedValueResponseResource.md)
 - [AppDetail](docs/AppDetail.md)
 - [ApplyTemplateQueryObject](docs/ApplyTemplateQueryObject.md)
 - [ArtifactHistoryResource](docs/ArtifactHistoryResource.md)
 - [ArtifactSearchParams](docs/ArtifactSearchParams.md)
 - [AssignedProject](docs/AssignedProject.md)
 - [AssignedUsersProject](docs/AssignedUsersProject.md)
 - [AttachmentAuthor](docs/AttachmentAuthor.md)
 - [AttachmentResource](docs/AttachmentResource.md)
 - [AuthSystemResponse](docs/AuthSystemResponse.md)
 - [AuthorityVM](docs/AuthorityVM.md)
 - [AutoFillConfigurationVM](docs/AutoFillConfigurationVM.md)
 - [AutomationArtifactSearchParams](docs/AutomationArtifactSearchParams.md)
 - [AutomationFailLinkedDefectResponse](docs/AutomationFailLinkedDefectResponse.md)
 - [AutomationLinkedDefectResponse](docs/AutomationLinkedDefectResponse.md)
 - [AutomationObjectTree](docs/AutomationObjectTree.md)
 - [AutomationRequest](docs/AutomationRequest.md)
 - [AutomationScheduleCreationAPI](docs/AutomationScheduleCreationAPI.md)
 - [AutomationStepLog](docs/AutomationStepLog.md)
 - [AutomationTestLog](docs/AutomationTestLog.md)
 - [AutomationTestLogResource](docs/AutomationTestLogResource.md)
 - [AutomationTestLogResourceResponse](docs/AutomationTestLogResourceResponse.md)
 - [AutomationTestStepLog](docs/AutomationTestStepLog.md)
 - [BuildPermission](docs/BuildPermission.md)
 - [BuildResource](docs/BuildResource.md)
 - [Client](docs/Client.md)
 - [CommentQueryParams](docs/CommentQueryParams.md)
 - [CommentResource](docs/CommentResource.md)
 - [CustomFieldTemplate](docs/CustomFieldTemplate.md)
 - [Defect](docs/Defect.md)
 - [DefectComment](docs/DefectComment.md)
 - [DefectFieldMapping](docs/DefectFieldMapping.md)
 - [DefectMapping](docs/DefectMapping.md)
 - [DefectPermission](docs/DefectPermission.md)
 - [DefectResource](docs/DefectResource.md)
 - [DefectTrackingSystem](docs/DefectTrackingSystem.md)
 - [ErrorMessage](docs/ErrorMessage.md)
 - [ExternalPropertyResource](docs/ExternalPropertyResource.md)
 - [FieldInputResource](docs/FieldInputResource.md)
 - [FieldResource](docs/FieldResource.md)
 - [HistoryChange](docs/HistoryChange.md)
 - [HistoryQueryParams](docs/HistoryQueryParams.md)
 - [HistoryResource](docs/HistoryResource.md)
 - [IntegrationAutoFillMappingVM](docs/IntegrationAutoFillMappingVM.md)
 - [IntegrationConnection](docs/IntegrationConnection.md)
 - [IntegrationConnectionVM](docs/IntegrationConnectionVM.md)
 - [IntegrationFieldMapVM](docs/IntegrationFieldMapVM.md)
 - [IntegrationReleaseConfigurationVM](docs/IntegrationReleaseConfigurationVM.md)
 - [IntegrationReleaseConfigurationValues](docs/IntegrationReleaseConfigurationValues.md)
 - [IntegrationReleaseMappingResponse](docs/IntegrationReleaseMappingResponse.md)
 - [LDAPUsersResponse](docs/LDAPUsersResponse.md)
 - [LdapConfigDetailResponse](docs/LdapConfigDetailResponse.md)
 - [LdapUserResource](docs/LdapUserResource.md)
 - [LdapUserVM](docs/LdapUserVM.md)
 - [Link](docs/Link.md)
 - [LinkedArtifact](docs/LinkedArtifact.md)
 - [LinkedArtifactContainer](docs/LinkedArtifactContainer.md)
 - [LinkedDefect](docs/LinkedDefect.md)
 - [LinkedDefectContainer](docs/LinkedDefectContainer.md)
 - [LinkedDefectResource](docs/LinkedDefectResource.md)
 - [LinkedObject](docs/LinkedObject.md)
 - [LoggedUser](docs/LoggedUser.md)
 - [LookUp](docs/LookUp.md)
 - [ManualTestLogResource](docs/ManualTestLogResource.md)
 - [Message](docs/Message.md)
 - [ModulePermission](docs/ModulePermission.md)
 - [ModuleResource](docs/ModuleResource.md)
 - [NewIntegrationConnectionInfo](docs/NewIntegrationConnectionInfo.md)
 - [OAuthResponse](docs/OAuthResponse.md)
 - [OAuthTokenStatusVM](docs/OAuthTokenStatusVM.md)
 - [OutputStream](docs/OutputStream.md)
 - [PagedResource](docs/PagedResource.md)
 - [PagedResourceAttachmentResource](docs/PagedResourceAttachmentResource.md)
 - [PagedResourceCommentResource](docs/PagedResourceCommentResource.md)
 - [ParameterInfo](docs/ParameterInfo.md)
 - [ParameterTestStepResource](docs/ParameterTestStepResource.md)
 - [ParameterVM](docs/ParameterVM.md)
 - [ParameterValueVM](docs/ParameterValueVM.md)
 - [ParameterizationText](docs/ParameterizationText.md)
 - [Profile](docs/Profile.md)
 - [Project](docs/Project.md)
 - [ProjectAdminPermission](docs/ProjectAdminPermission.md)
 - [ProjectModule](docs/ProjectModule.md)
 - [ProjectQueryParams](docs/ProjectQueryParams.md)
 - [ProjectResource](docs/ProjectResource.md)
 - [ProjectSettingPermission](docs/ProjectSettingPermission.md)
 - [ProjectUpdateResource](docs/ProjectUpdateResource.md)
 - [ProjectUsersProfile](docs/ProjectUsersProfile.md)
 - [ProjectWithUserIdsObject](docs/ProjectWithUserIdsObject.md)
 - [PropertyResource](docs/PropertyResource.md)
 - [QueryCommentResource](docs/QueryCommentResource.md)
 - [QueueProcessingResponse](docs/QueueProcessingResponse.md)
 - [QueueProcessingResponseFetchDataVM](docs/QueueProcessingResponseFetchDataVM.md)
 - [QueueProcessingResponseTestRunDataVM](docs/QueueProcessingResponseTestRunDataVM.md)
 - [ReleasePermission](docs/ReleasePermission.md)
 - [ReleaseWithCustomFieldResource](docs/ReleaseWithCustomFieldResource.md)
 - [ReportPermission](docs/ReportPermission.md)
 - [RequirementMapping](docs/RequirementMapping.md)
 - [RequirementPermission](docs/RequirementPermission.md)
 - [RequirementResource](docs/RequirementResource.md)
 - [ResourceSupport](docs/ResourceSupport.md)
 - [ResponseWrapper](docs/ResponseWrapper.md)
 - [SSOSamlConfigDetailResponse](docs/SSOSamlConfigDetailResponse.md)
 - [SchedulePermission](docs/SchedulePermission.md)
 - [SearchUserResource](docs/SearchUserResource.md)
 - [SearchUserResourceExtensionResponse](docs/SearchUserResourceExtensionResponse.md)
 - [SearchUserResponse](docs/SearchUserResponse.md)
 - [SessionManagerPermission](docs/SessionManagerPermission.md)
 - [ShortTestLogResource](docs/ShortTestLogResource.md)
 - [SiteTemplateResponse](docs/SiteTemplateResponse.md)
 - [SiteUsersProfile](docs/SiteUsersProfile.md)
 - [StatusResource](docs/StatusResource.md)
 - [TUAConfigDetailResponse](docs/TUAConfigDetailResponse.md)
 - [TestCasePermission](docs/TestCasePermission.md)
 - [TestCaseResultDefect](docs/TestCaseResultDefect.md)
 - [TestCaseWithCustomFieldResource](docs/TestCaseWithCustomFieldResource.md)
 - [TestCaseWithParameterResource](docs/TestCaseWithParameterResource.md)
 - [TestCycle](docs/TestCycle.md)
 - [TestCyclePermission](docs/TestCyclePermission.md)
 - [TestCycleResource](docs/TestCycleResource.md)
 - [TestLogListResource](docs/TestLogListResource.md)
 - [TestLogResource](docs/TestLogResource.md)
 - [TestParameter](docs/TestParameter.md)
 - [TestRunListResource](docs/TestRunListResource.md)
 - [TestRunPermission](docs/TestRunPermission.md)
 - [TestRunWithCustomFieldResource](docs/TestRunWithCustomFieldResource.md)
 - [TestRunWithParameterCreateByDatasetResource](docs/TestRunWithParameterCreateByDatasetResource.md)
 - [TestRunWithParameterCreateManualResource](docs/TestRunWithParameterCreateManualResource.md)
 - [TestRunWithParameterCreateRandomResource](docs/TestRunWithParameterCreateRandomResource.md)
 - [TestStepInformationVM](docs/TestStepInformationVM.md)
 - [TestStepLogResource](docs/TestStepLogResource.md)
 - [TestStepResource](docs/TestStepResource.md)
 - [TestStepWithParameterResource](docs/TestStepWithParameterResource.md)
 - [TestSuite](docs/TestSuite.md)
 - [TestSuitePermission](docs/TestSuitePermission.md)
 - [TestSuiteWithCustomFieldResource](docs/TestSuiteWithCustomFieldResource.md)
 - [TokenSecretVerifierHolder](docs/TokenSecretVerifierHolder.md)
 - [ToscaExecutionEntryResource](docs/ToscaExecutionEntryResource.md)
 - [ToscaTestCaseResource](docs/ToscaTestCaseResource.md)
 - [ToscaTestCycleResource](docs/ToscaTestCycleResource.md)
 - [TraceabilityRequirement](docs/TraceabilityRequirement.md)
 - [UserGroupResource](docs/UserGroupResource.md)
 - [UserInfoVM](docs/UserInfoVM.md)
 - [UserProfile](docs/UserProfile.md)
 - [UserProfileResponse](docs/UserProfileResponse.md)
 - [UserResource](docs/UserResource.md)
 - [UserResourceExtension](docs/UserResourceExtension.md)
 - [UserUpdateResource](docs/UserUpdateResource.md)
 - [WebhookRequest](docs/WebhookRequest.md)
 - [WebhookVM](docs/WebhookVM.md)


## Documentation for Authorization

Authentication schemes defined for the API:
### Authorization

- **Type**: API key
- **API key parameter name**: Authorization
- **Location**: HTTP header


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author



