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
