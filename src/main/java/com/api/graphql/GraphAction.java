package com.api.graphql;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.JSONObject;

import static org.hamcrest.Matchers.equalTo;

public class GraphAction {

    public String GraphqlToJson(String payload) {
        JSONObject json = new JSONObject();
        json.put("query", payload);
        return json.toString();
    }

    public void GraphResponse(String host, Object query, String queryPath, String validator) {
        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(query)
                .when()
                .post(host)
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .body(queryPath, equalTo(validator))
                .log()
                .body();
    }

}
