package com.api.graphql.pojo;

import lombok.Data;

import java.util.UUID;

@Data
public class User {

    private UUID id;
    private String name;
    private String rocket;

    public User(UUID id, String name, String rocket) {
        this.id = id;
        this.name = name;
        this.rocket = rocket;
    }
}