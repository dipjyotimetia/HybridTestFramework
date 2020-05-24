/*
MIT License

Copyright (c) 2020 Dipjyoti Metia

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
package com.core;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class ApiActions<T> {
    private final Logger logger = LogManager.getLogger(ApiActions.class);

    /**
     * http request with parameter
     *
     * @param params jsonObject
     * @return returns httpRequest
     */
    private RequestSpecification httpRequestPost(JSONObject params) {
        return RestAssured
                .given()
                .filter(new AllureRestAssured())
                .with()
                .contentType(ContentType.JSON)
                .with()
                .body(params.toJSONString());
    }

    /**
     * http request with parameter
     *
     * @return returns httpRequest
     */
    private RequestSpecification httpRequest() {
        return RestAssured
                .given()
                .filter(new AllureRestAssured())
                .with()
                .contentType(ContentType.JSON);
    }

    /**
     * Set base uri
     *
     * @param baseURI baseUri
     */
    public void setBaseURI(String baseURI) {
        RestAssured.baseURI = baseURI;
    }

    /**
     * Set base path
     *
     * @param basePathTerm basepath
     */
    public void setBasePath(String basePathTerm) {
        RestAssured.basePath = basePathTerm;
    }

    /**
     * reset base uri
     */
    public void resetBaseURI() {
        RestAssured.baseURI = null;
    }

    /**
     * Reset base path
     */
    public void resetBasePath() {
        RestAssured.basePath = null;
    }

    /**
     * http post
     *
     * @param params params
     * @param path   endpoint
     * @return response
     */
    protected Response httpPost(JSONObject params, String path) {
        return httpRequestPost(params).request(Method.POST, path);
    }

    /**
     * http get
     *
     * @param path endpoint
     * @return response
     */
    protected Response httpGet(String path) {
        return httpRequest().request(Method.GET, path);
    }

    /**
     * http delete
     *
     * @param path endpoint
     * @return response
     */
    protected Response httpDelete(String path) {
        return httpRequest().request(Method.DELETE, path);
    }

    /**
     * http put
     *
     * @param params params
     * @param path   endpoint
     * @return response
     */
    protected Response httpPut(JSONObject params, String path) {
        return httpRequestPost(params).request(Method.PUT, path);
    }

    /**
     * Get Status code
     *
     * @param response response
     * @return status code
     */
    protected int getStatusCode(Response response) {
        return response.getStatusCode();
    }

    /**
     * Get Content Type
     *
     * @param response response
     * @return contentType
     */
    protected String getContentType(Response response) {
        return response.getContentType();
    }

    /**
     * Get headers
     *
     * @param response response
     * @param header   header
     * @return header value
     */
    private String getHeaders(Response response, String header) {
        return response.getHeaders().getValue(header);
    }

    /**
     * Response Body
     *
     * @param response response
     * @return responseBody
     */
    private ResponseBody responseBody(Response response) {
        return response.getBody();
    }

    /**
     * Get Body
     *
     * @param response response
     * @return preety Print
     */
    protected String getBody(Response response) {
        return responseBody(response).prettyPrint();
    }

    /**
     * JsonPath evaluator
     *
     * @param response response
     * @return jsonPath
     */
    protected T jsonPathEvaluator(Response response, String exp) {
        return response.jsonPath().get(exp);
    }

    protected String sysDateFormat() {
        try {
            DateFormat date = new SimpleDateFormat("dd-MM-yyyy");
            Date date1 = new Date();
            String abc1 = date.format(date1);
            return abc1;
        } catch (Exception e) {
            logger.error(e);
        }
        return null;
    }

    /**
     * Setup Mock data
     *
     * @param wireMockServer wireMockServer
     * @param endPoint       endpoint
     * @param mockData       mockData
     */
    protected void setupMockData(WireMockServer wireMockServer, String endPoint, String mockData) {
        wireMockServer.stubFor(WireMock.get(WireMock.urlEqualTo(endPoint))
                .willReturn(WireMock.aResponse().withHeader("Content-Type", "application/json")
                        .withStatus(200)
                        .withBodyFile(mockData)));
    }

    /**
     * SetupMockInvalid Request
     *
     * @param endPoint endpoint
     */
    protected void setupMockInvalidRequest(String endPoint) {
        WireMock.configureFor("127.0.0.1", 8082);
        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo(endPoint))
                .withHeader("Accept", WireMock.matching("text/plain"))
                .willReturn(WireMock.aResponse().
                        withStatus(503).
                        withHeader("Content-Type", "text/html").
                        withBody("Service Not Available"))
        );
    }

    /**
     * Setup Mock Delay Request
     *
     * @param endPoint endpoint
     */
    protected void setupMockDelayRequest(String endPoint) {
        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo(endPoint))
                .withHeader("Accept", WireMock.matching("application/json"))
                .willReturn(WireMock.aResponse().
                        withStatus(200).
                        withHeader("Content-Type", "application/json")
                        .withBody("{\"serviceStatus\": \"running\"}")
                        .withFixedDelay(2500))
        );
    }

    @Step("{0}")
    protected void log(String message) {
        logger.info(message);
    }
}
