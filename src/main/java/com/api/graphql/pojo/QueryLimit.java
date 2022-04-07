package com.api.graphql.pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QueryLimit {
    private int limit;
}