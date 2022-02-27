
# HistoryQueryParams

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**objectType** | **String** |  | 
**fields** | **List&lt;String&gt;** |  |  [optional]
**query** | **String** | Specify a structured query to retrieve history of objects specified in attribute object_query above  Only these 2 criteria are supported:   created: it can be used for querying by updated date of the object.   Its values need to be in ISO Date format. Applicable operator include: &#x3D;, &lt;&gt;, &amp;lt;&#x3D; and &gt;&#x3D;   author:it can be used for querying by Id of the users who made the update. Applicable operators include: &#x3D; and &lt;&gt;  You can use operators and and or to combine an unlimited number of criteria above |  [optional]
**objectQuery** | **String** | Specify a structured query to search for qTest objects. Refer to attribute query in the request body of Query Objects API |  [optional]



