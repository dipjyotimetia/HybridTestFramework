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
public class TC004_OpenBankTest<T> extends ApiActions<T> {
    private static final Logger logger = LogManager.getLogger(TC004_OpenBankTest.class);

    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "E2E test for all users")
    @Description("Get All Beers")
    @Story("Test Bank")
    public void AllUsers() {
        RestAssured.baseURI = "https://reqres.in";

        Response response = httpGet("/api/users?page=1");
        Assert.assertEquals(getStatusCode(response) /*actual value*/, 200 /*expected value*/, "Correct status code returned");
        logger.info("Response Body is =>  " + getBody(response));
        T email = jsonPathEvaluator(response, "$.data[0].email");
        T avatar = jsonPathEvaluator(response, "$.data[0].avatar");
        log("Email: " + email);
        log("Avatar: " + avatar);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "E2E test for all banks")
    @Description("Get All Banks")
    @Story("Test Beers")
    public void AllBanks() {
        RestAssured.baseURI = "https://apisandbox.openbankproject.com";

        Response response = httpGet("/obp/v1.2.1/banks");
        Assert.assertEquals(getStatusCode(response) /*actual value*/, 200 /*expected value*/, "Correct status code returned");
        logger.info("Response Body is =>  " + getBody(response));
        T website = jsonPathEvaluator(response, "$.banks[0].website");
        T id = jsonPathEvaluator(response, "$.banks[0].id");
        T fullName = jsonPathEvaluator(response, "$.banks[0].full_name");
        log("Website: " + website);
        log("Id: " + id);
        log("fullName: " + fullName);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "E2E test for all bank branches")
    @Description("Get All Branches")
    @Story("Test Beers")
    public void AllBranches() {
        RestAssured.baseURI = "https://apis-bank-test.apigee.net";

        Response response = httpGet("/apis/v2.0.1/locations/branches");
        Assert.assertEquals(getStatusCode(response) /*actual value*/, 200 /*expected value*/, "Correct status code returned");
        logger.info("Response Body is =>  " + getBody(response));
    }
}
