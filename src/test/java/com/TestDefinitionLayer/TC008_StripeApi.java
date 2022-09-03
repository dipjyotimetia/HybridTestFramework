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

package com.TestDefinitionLayer;

import com.api.rest.ApiActions;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;


@Link("https://jira.cloud.com")
@Feature("Api1")
@Feature("Api2")
@Slf4j
public class TC008_StripeApi extends ApiActions {
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "E2E test for all Stripe Orders")
    @Description("Get All Orders")
    @Story("Test Orders")
    public void AllOrders() {
        RestAssured.baseURI = "http://localhost:12111";
        Header header = new Header("Authorization", "Bearer sk_test_123");
        Response response = httpGet("/v1/orders", header);
        Assert.assertEquals(getStatusCode(response) /*actual value*/, 200 /*expected value*/, "Correct status code returned");
//        log.info("Response Body is =>  " + getBody(response));
        //  System.out.println(response);
        int amount = (int) jsonPathEvaluator(response, "data[0].amount");
        String description = (String) jsonPathEvaluator(response, "data[0].items[0].description");
        log("Amount: " + amount);
        log("Description: " + description);
    }
}
