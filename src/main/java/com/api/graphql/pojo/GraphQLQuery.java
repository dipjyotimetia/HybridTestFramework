package com.api.graphql.pojo;

import lombok.Data;

@Data
public class GraphQLQuery {
    private String query;
    private Object variables;
}