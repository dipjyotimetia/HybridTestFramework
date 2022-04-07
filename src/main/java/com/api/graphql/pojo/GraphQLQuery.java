package com.api.graphql.pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GraphQLQuery {
    private String query;
    private Object variables;
}