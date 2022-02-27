
# CommentQueryParams

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**start** | [**DateTime**](DateTime.md) | StartDate with format: yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ or yyyy-MM-dd&#39;T&#39;HH:mm:ssZZ\&quot; |  [optional]
**end** | [**DateTime**](DateTime.md) | EndDate with format: yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ or yyyy-MM-dd&#39;T&#39;HH:mm:ssZZ\&quot; |  [optional]
**objectType** | **String** | Only support comments for object types: [requirements, defects, test-cases, test-runs] | 
**fields** | **List&lt;String&gt;** | Specify which object fields you want to include in the response. If you omit it or specify an asterisk (*), all fields are included |  [optional]
**object** | **Long** | Id of the object from which you want to retrieve comments |  [optional]
**author** | **Long** | Id of the user who made the comments |  [optional]



