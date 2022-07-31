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

import com.api.grpc.client.CoffeeClient;
import com.coffee.CoffeeSize;
import com.coffee.GetCoffeeResponse;
import com.coffee.UpdateCoffeeResponse;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

@Slf4j
public class TC009_GrpcApi {
    private final CoffeeClient coffeeClient;

    public TC009_GrpcApi() throws IOException {
        coffeeClient = new CoffeeClient();
    }

    @Test
    public void getCoffee() throws Exception {
        GetCoffeeResponse bookResponse = coffeeClient.getCoffee();
        Assert.assertEquals(bookResponse.getCoffeeDescription(0).getName(), "Hello");
        Assert.assertEquals(bookResponse.getCoffeeDescription(0).getFlavour(), "Java Grpc");
        Assert.assertEquals(bookResponse.getCoffeeDescription(0).getAroma(), "Hybrid");
        Assert.assertEquals(bookResponse.getCoffeeDescription(0).getCoffeeSize(), CoffeeSize.SMALL);
    }

    @Test
    public void updateCoffee() throws Exception {
        UpdateCoffeeResponse bookResponse = coffeeClient.updateCoffee();
        Assert.assertEquals(bookResponse.getMessage(), "Coffee Details Updated");
    }

    @Test
    public void listCoffee() {
        coffeeClient.listCoffee();
    }

//    @Test
//    public void GreetEveryone() throws InterruptedException {
//        try {
//            CountDownLatch response = greetClient.GreetEveryone();
//            if (!response.await(1, TimeUnit.MINUTES)) {
//                System.out.println("greet can not finish within 1 minutes");
//            }
//        }
//        finally {
//            greetClient.channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
//        }
//    }
}
