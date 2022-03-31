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

import com.api.rest.ApiActions;
import com.api.rest.pojo.Booking;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.qameta.allure.*;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

@Link("https://jira.cloud.com")
@Feature("RestApi")
@Slf4j
public class TC003_ApiTest extends ApiActions {

//    @Severity(SeverityLevel.CRITICAL)
//    @Test(description = "E2E test for all beers")
//    @Description("Get Treding Coints")
//    @Story("Test CryptoCoins")
//    public void TestTradings() {
//        setBaseURI("https://api.coingecko.com");
//
//        Response response = httpGet("/api/v3/search/trending");
//        Assert.assertEquals(getStatusCode(response) /*actual value*/, 200 /*expected value*/, "Correct status code returned");
//        String name = (String) jsonPathEvaluator(response, "coins.[0].item.name");
//        String price = (String) jsonPathEvaluator(response, "coins.[0].item.price_btc");
//        log("Name: " + name);
//        log("Price: " + price);
//    }
//
//    @Severity(SeverityLevel.CRITICAL)
//    @Test(description = "E2E test for random beers")
//    @Description("Get Random Beers")
//    @Story("Test CryptoCoins")
//    public void TestGlobalCurrencies() {
//        setBaseURI("https://api.coingecko.com");
//
//        Response response = httpGet("/api/v3/global");
//        Assert.assertEquals(getStatusCode(response) /*actual value*/, 200 /*expected value*/, "Correct status code returned");
//        //logger.info("Response Body is =>  " + getBody(response));
//        String activeCurrencies = (String) jsonPathEvaluator(response, "$.data.active_cryptocurrencies");
//        String totalMarkets = (String) jsonPathEvaluator(response, "$.data.markets");
//        String btcVolume = (String) jsonPathEvaluator(response, "$.data.total_volume.btc");
//        log("ActiveCurrencies: " + activeCurrencies);
//        log("TotalMarkets: " + totalMarkets);
//        log("BTCVolume: " + btcVolume);
//    }
//
//    @Severity(SeverityLevel.CRITICAL)
//    @Test(description = "E2E test for single beers")
//    @Description("Get Single Beers")
//    @Story("Test CryptoCoins")
//    public void TestExchangeInfo() {
//        setBaseURI("https://api.binance.com");
//
//        Response response = httpGet("/api/v3/exchangeInfo?symbol=BNBBTC");
//        String[] permission = new String[]{"SPOT", "MARGIN"};
//        String[] orderType = new String[]{"LIMIT", "LIMIT_MAKER", "MARKET", "STOP_LOSS_LIMIT", "TAKE_PROFIT_LIMIT"};
//
//        Assert.assertEquals(getStatusCode(response) /*actual value*/, 200 /*expected value*/, "Correct status code returned");
//        Assert.assertEquals(jsonPathEvaluator(response, "$.symbols[0].symbol"), "BNBBTC");
//        Assert.assertEquals(jsonPathEvaluator(response, "$.symbols[0].permissions"), permission);
//        Assert.assertEquals(jsonPathEvaluator(response, "$.symbols[0].orderTypes"), orderType);
//    }
//
//    @Severity(SeverityLevel.CRITICAL)
//    @Test(description = "E2E test for all users")
//    @Description("Get All Users")
//    @Story("Test Users")
//    public void AllUsers() {
//        setBaseURI("https://reqres.in");
//
//        Response response = httpGet("/api/users?page=1");
//        Assert.assertEquals(getStatusCode(response) /*actual value*/, 200 /*expected value*/, "Correct status code returned");
//        String email = (String) jsonPathEvaluator(response, "$.data[0].email");
//        String avatar = (String) jsonPathEvaluator(response, "$.data[0].avatar");
//        log("Email: " + email);
//        log("Avatar: " + avatar);
//    }
//
//    @Severity(SeverityLevel.CRITICAL)
//    @Test(description = "E2E test for all banks")
//    @Description("Get All Banks")
//    @Story("Test OpenBanking")
//    public void AllBanks() {
//        RestAssured.baseURI = "https://apisandbox.openbankproject.com";
//
//        Response response = httpGet("/obp/v1.2.1/banks");
//        Assert.assertEquals(getStatusCode(response) /*actual value*/, 200 /*expected value*/, "Correct status code returned");
//        //logger.info("Response Body is =>  " + getBody(response));
//        String website = (String) jsonPathEvaluator(response, "$.banks[0].website");
//        String id = (String) jsonPathEvaluator(response, "$.banks[0].id");
//        String fullName = (String) jsonPathEvaluator(response, "$.banks[0].full_name");
//        log("Website: " + website);
//        log("Id: " + id);
//        log("fullName: " + fullName);
//    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "E2E test for all banks")
    @Description("Get All Banks")
    @Story("Test OpenBanking")
    public void RestBrokers() {
        setBaseURI("https://restful-booker.herokuapp.com");

        ObjectMapper om = new ObjectMapper();
        ObjectWriter root = om.writerFor(Booking.class);

        Response response = httpPost(root, "/booking");
        Assert.assertEquals(getStatusCode(response) /*actual value*/, 200 /*expected value*/, "Correct status code returned");
        //logger.info("Response Body is =>  " + getBody(response));
    }

}
