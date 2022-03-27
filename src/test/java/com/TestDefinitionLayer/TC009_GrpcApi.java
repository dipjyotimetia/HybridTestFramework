package com.TestDefinitionLayer;

import com.api.grpc.CoffeeClient;
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
