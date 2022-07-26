package com.api.grpc.client;

import com.api.grpc.RpcActions;
import com.coffee.*;
import com.google.protobuf.Timestamp;
import io.grpc.ManagedChannel;
import io.grpc.StatusRuntimeException;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Iterator;
import java.util.UUID;

@Slf4j
public class CoffeeClient extends RpcActions {

    CoffeeGrpc.CoffeeBlockingStub coffeeServiceStub;

    public CoffeeClient() throws IOException {
        ManagedChannel channel = channel("coffee-service-i6avjiaelq-ts.a.run.app", ChannelType.TLS, AuthType.TLS);
        coffeeServiceStub = CoffeeGrpc.newBlockingStub(channel);
    }

    public AddCoffeeResponse addCoffee() {
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
            log.error(e.getMessage());
            return null;
        }
    }

    public UpdateCoffeeResponse updateCoffee() {
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
            log.error(e.getMessage());
            return null;
        }
    }

    public GetCoffeeResponse getCoffee() throws Exception {
        try {
            GetCoffeeRequest getCoffeeRequest = GetCoffeeRequest.newBuilder()
                    .setName("Hello")
                    .build();
            return coffeeServiceStub.getCoffee(getCoffeeRequest);
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
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
