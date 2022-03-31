package com.api.graphql;

import com.api.rest.ApiActions;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.JSONObject;

import static org.hamcrest.Matchers.equalTo;

public class GraphActions extends ApiActions {

    /**
     * GraphqlTOJson
     *
     * @param payload
     * @return
     */
    public String graphqlToJson(String payload) {
        JSONObject json = new JSONObject();
        json.put("query", payload);
        return json.toString();
    }

    /**
     * Graph Response
     *
     * @param host
     * @param query
     * @param queryPath
     * @param validator
     */
    public void graphResponse(String host, Object query, String queryPath, String validator) {
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
