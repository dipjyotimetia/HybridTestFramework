/*
MIT License
Copyright (c) 2021 Dipjyoti Metia
Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */

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
     * @param payload payload
     * @return jsonBody
     */
    public String graphqlToJson(String payload) {
        JSONObject json = new JSONObject();
        json.put("query", payload);
        return json.toString();
    }

    /**
     * Graph Response
     *
     * @param host      host
     * @param query     graph query
     * @param queryPath queryPath
     * @param validator validator
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
