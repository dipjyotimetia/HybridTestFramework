package com.api.grpc;

import com.coffee.*;
import com.google.protobuf.Timestamp;
import io.grpc.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.UUID;

@Slf4j
public class CoffeeClient {

    CoffeeGrpc.CoffeeBlockingStub coffeeServiceStub;

    public CoffeeClient() {
        //ManagedChannel channel = ManagedChannelBuilder.forAddress("coffee-service-i6avjiaelq-ts.a.run.app", 8080).usePlaintext().build();
        ManagedChannel channel = Grpc.newChannelBuilder("coffee-service-i6avjiaelq-ts.a.run.app", TlsChannelCredentials.create()).build();
        coffeeServiceStub = CoffeeGrpc.newBlockingStub(channel);
    }

    public AddCoffeeResponse addCoffee() throws Exception {
        try {
            AddCoffeeRequest addCoffeeRequest = AddCoffeeRequest.newBuilder()
                    .setId(UUID.randomUUID().toString())
                    .setName("java")
                    .setFlavour("Java Grpc")
                    .setAroma("Hybrid")
                    .setCoffeeSize(CoffeeSize.SMALL)
                    .setDescription("New java coffee client")
                    .setLastUpdated(Timestamp.newBuilder().build())
                    .build();
            return coffeeServiceStub.addCoffee(addCoffeeRequest);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public UpdateCoffeeResponse updateCoffee() throws Exception {
        try {
            UpdateCoffeeRequest updateCoffeeRequest = UpdateCoffeeRequest.newBuilder()
                    .setName("Hello")
                    .setFlavour("Java Grpc")
                    .setAroma("Hybrid")
                    .setCoffeeSize(CoffeeSize.SMALL)
                    .setDescription("New java coffee client")
                    .setLastUpdated(Timestamp.newBuilder().build())
                    .build();
            return coffeeServiceStub.updateCoffee(updateCoffeeRequest);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public GetCoffeeResponse getCoffee() throws Exception {
        try {
            GetCoffeeRequest getCoffeeRequest = GetCoffeeRequest.newBuilder()
                    .setName("Hello")
                    .build();
            return coffeeServiceStub.getCoffee(getCoffeeRequest);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void listCoffee() {
        ListCoffeeRequest listCoffeeRequest = ListCoffeeRequest.newBuilder().build();
        Iterator<ListCoffeeResponse> coffeeGrpcIterator;
        try {
            coffeeGrpcIterator = coffeeServiceStub.listCoffee(listCoffeeRequest);
            if (coffeeGrpcIterator.hasNext()) {
                ListCoffeeResponse coffeeResponse = coffeeGrpcIterator.next();
                System.out.println(coffeeResponse.getCoffeeDescription(0));
            }
        } catch (StatusRuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
