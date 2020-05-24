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

package com.TestDefinitionLayer;

import com.core.ApiActions;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

@Link("https://jira.cloud.com")
@Feature("Api1")
@Feature("Api2")
public class TC003_ApiTest<T> extends ApiActions<T> {
    private static final Logger logger = LogManager.getLogger(TC003_ApiTest.class);

    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "E2E test for all beers")
    @Description("Get All Beers")
    @Story("Test Beers")
    public void AllBeers() {
        RestAssured.baseURI = "https://api.punkapi.com";

        Response response = httpGet("/v2/beers");
        Assert.assertEquals(getStatusCode(response) /*actual value*/, 200 /*expected value*/, "Correct status code returned");
        //logger.info("Response Body is =>  " + getBody(response));
        T tagLine = jsonPathEvaluator(response, "$[0].tagline");
        T description = jsonPathEvaluator(response, "$[0].description");
        log("Tag Line: " + tagLine);
        log("Description: " + description);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "E2E test for random beers")
    @Description("Get Random Beers")
    @Story("Test Beers")
    public void RandomBeers() {
        RestAssured.baseURI = "https://api.punkapi.com";

        Response response = httpGet("/v2/beers/random");
        Assert.assertEquals(getStatusCode(response) /*actual value*/, 200 /*expected value*/, "Correct status code returned");
        //logger.info("Response Body is =>  " + getBody(response));
        T tagLine = jsonPathEvaluator(response, "$[0].tagline");
        T description = jsonPathEvaluator(response, "$[0].description");
        log("Tag Line: " + tagLine);
        log("Description: " + description);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "E2E test for single beers")
    @Description("Get Single Beers")
    @Story("Test Beers")
    public void SingleBeer() {
        RestAssured.baseURI = "https://api.punkapi.com";

        Response response = httpGet("/v2/beers/1");
        Assert.assertEquals(getStatusCode(response) /*actual value*/, 200 /*expected value*/, "Correct status code returned");
        //logger.info("Response Body is =>  " + getBody(response));
        T tagLine = jsonPathEvaluator(response, "$[0].tagline");
        T description = jsonPathEvaluator(response, "$[0].description");
        log("Tag Line: " + tagLine);
        log("Description: " + description);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "E2E test for brewery")
    @Description("Get All Brewery")
    @Story("Test Beers")
    public void Brewery() {
        RestAssured.baseURI = "https://api.openbrewerydb.org";

        Response response = httpGet("/breweries");
        Assert.assertEquals(getStatusCode(response) /*actual value*/, 200 /*expected value*/, "Correct status code returned");
        //logger.info("Response Body is =>  " + getBody(response));
        T name = jsonPathEvaluator(response, "$[0].name");
        T webSite = jsonPathEvaluator(response, "$[0].website_url");
        log("Name: " + name);
        log("WebSite: " + webSite);
    }

}
