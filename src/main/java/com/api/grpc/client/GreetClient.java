package com.api.grpc.client;

import com.api.grpc.RpcActions;
import com.greet.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Slf4j
public class GreetClient extends RpcActions {
    public ManagedChannel channel;
    GreetServiceGrpc.GreetServiceBlockingStub greetServiceStub;
    GreetServiceGrpc.GreetServiceStub asyncStub;

    public GreetClient() {
        channel = ManagedChannelBuilder.forTarget("localhost:50051").usePlaintext().build();
        greetServiceStub = GreetServiceGrpc.newBlockingStub(channel);
        asyncStub = GreetServiceGrpc.newStub(channel);
    }

    public List<LongGreetRequest> sendGreet() {
        List<LongGreetRequest> requests = new ArrayList<>();
        requests.add(LongGreetRequest.newBuilder()
                .setGreeting(Greeting.newBuilder()
                        .setFirstName("say1")
                        .setLastName("saylast1")).build());
        requests.add(LongGreetRequest.newBuilder()
                .setGreeting(Greeting.newBuilder()
                        .setFirstName("say2")
                        .setLastName("saylast2")).build());
        requests.add(LongGreetRequest.newBuilder()
                .setGreeting(Greeting.newBuilder()
                        .setFirstName("say3")
                        .setLastName("saylast3")).build());
        requests.add(LongGreetRequest.newBuilder()
                .setGreeting(Greeting.newBuilder()
                        .setFirstName("say4")
                        .setLastName("saylast4")).build());
        return requests;
    }

    public GreetEveryoneRequest[] sendGreetEveryone() {
        return new GreetEveryoneRequest[]{
                GreetEveryoneRequest.newBuilder()
                        .setGreeting(Greeting.newBuilder()
                                .setFirstName("")
                                .setLastName("")).build(),
                GreetEveryoneRequest.newBuilder()
                        .setGreeting(Greeting.newBuilder()
                                .setFirstName("")
                                .setLastName("")).build(),
                GreetEveryoneRequest.newBuilder()
                        .setGreeting(Greeting.newBuilder()
                                .setFirstName("")
                                .setLastName("")).build(),
                GreetEveryoneRequest.newBuilder()
                        .setGreeting(Greeting.newBuilder()
                                .setFirstName("")
                                .setLastName("")).build(),
        };
    }

    public LongGreetResponse longGreet() throws Exception {
        Random random = new Random();
        final CountDownLatch finishLatch = new CountDownLatch(1);

        StreamObserver<LongGreetResponse> responseStreamObserver = new StreamObserver<>() {
            @Override
            public void onNext(LongGreetResponse value) {
                log.info(value.getResult());
            }

            @Override
            public void onError(Throwable t) {
                finishLatch.countDown();
            }

            @Override
            public void onCompleted() {
                finishLatch.countDown();
            }
        };
        StreamObserver<LongGreetRequest> requestStreamObserver = asyncStub.longGreet(responseStreamObserver);
        try {
            for (int i = 0; i < sendGreet().size(); i++) {
                requestStreamObserver.onNext(sendGreet().get(i));
                Thread.sleep(random.nextInt(1000) + 500);
                if (finishLatch.getCount() == 0) {
                    // RPC completed or errored before we finished sending.
                    // Sending further requests won't error, but they will just be thrown away.
                    return null;
                }
            }
        } catch (RuntimeException e) {
            // Cancel RPC
            requestStreamObserver.onError(e);
            throw e;
        }
        // Mark the end of requests
        requestStreamObserver.onCompleted();
        // Receiving happens asynchronously
        if (!finishLatch.await(1, TimeUnit.MINUTES)) {
            log.warn("recordRoute can not finish within 1 minutes");
        }
        return null;
    }

    public CountDownLatch greetEveryone() {
        final CountDownLatch finishLatch = new CountDownLatch(1);
        StreamObserver<GreetEveryoneRequest> requestStreamObserver = asyncStub.greetEveryone(new StreamObserver<>() {
            @Override
            public void onNext(GreetEveryoneResponse value) {
                log.info(value.getResult());
            }

            @Override
            public void onError(Throwable t) {
                finishLatch.countDown();
            }

            @Override
            public void onCompleted() {
                finishLatch.countDown();
            }
        });

        try {
            for (GreetEveryoneRequest greetEveryoneRequest : sendGreetEveryone()) {
                requestStreamObserver.onNext(greetEveryoneRequest);
            }
        } catch (RuntimeException e) {
            requestStreamObserver.onError(e);
        }
        requestStreamObserver.onCompleted();
        return finishLatch;
    }
}
