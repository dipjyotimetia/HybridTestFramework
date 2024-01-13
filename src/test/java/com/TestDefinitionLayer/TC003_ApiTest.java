/*
MIT License

Copyright (c) 2023 Dipjyoti Metia

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
import com.api.rest.pojo.Bookingdates;
import com.api.rest.pojo.Trades;
import io.qameta.allure.*;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

@Link("https://jira.cloud.com")
@Feature("RestApi")
@Slf4j
public class TC003_ApiTest extends ApiActions {
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "E2E test for Booking System", priority = 1)
    @Description("Make Booking")
    @Story("Test Booking")
    public void TestAddBooking() {
        setBaseURI("https://restful-booker.herokuapp.com");

        Bookingdates bookingdates = Bookingdates.builder()
                .checkin("2018-01-01")
                .checkout("2019-01-01")
                .build();

        Booking booking = Booking.builder()
                .firstname("Jim")
                .lastname("Brown")
                .totalprice(111)
                .depositpaid(true)
                .bookingdates(bookingdates)
                .additionalneeds("Breakfast")
                .build();

        Response response = httpPost(booking, "/booking");
        Assert.assertEquals(getStatusCode(response) /*actual value*/, 200 /*expected value*/, "Correct status code returned");
    }
}
