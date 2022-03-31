package com.TestDefinitionLayer;

import com.api.rest.ApiActions;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;


@Link("https://jira.cloud.com")
@Feature("Api1")
@Feature("Api2")
@Slf4j
public class TC008_StripeApi extends ApiActions {
    private static final Logger logger = LogManager.getLogger(TC008_StripeApi.class);

    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "E2E test for all Stripe Orders")
    @Description("Get All Orders")
    @Story("Test Orders")
    public void AllOrders() {
        RestAssured.baseURI = "http://localhost:12111";
        Header header = new Header("Authorization", "Bearer sk_test_123");
        Response response = httpGet("/v1/orders", header);
        Assert.assertEquals(getStatusCode(response) /*actual value*/, 200 /*expected value*/, "Correct status code returned");
        logger.info("Response Body is =>  " + getBody(response));
        //  System.out.println(response);
        int amount = (int) jsonPathEvaluator(response, "data[0].amount");
        String description = (String) jsonPathEvaluator(response, "data[0].items[0].description");
        log("Amount: " + amount);
        log("Description: " + description);
    }
}
