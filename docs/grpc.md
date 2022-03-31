# gRPC testing

### Write your first gRPC testing

First get the proto file from the server and put it in `contract\proto` folder
then the compilation will auto generate the required code.

```protobuf
syntax = "proto3";

package greet;
option go_package = "greetpb";
option java_multiple_files = true;
option java_outer_classname = "GreetProto";
option java_package = "com.greet";

service GreetService{
  // Unary
  rpc Greet(GreetRequest) returns (GreetResponse) {};
}

message Greeting {
  string first_name = 1;
  string last_name = 2;
}

message GreetRequest {
  Greeting greeting = 1;
}

message GreetResponse {
  string result = 1;
}
```

Create the client code for the rpc connection, then use the client to write the test

```java
   CoffeeGrpc.CoffeeBlockingStub coffeeServiceStub;

    public CoffeeClient() throws IOException {
        ManagedChannel channel = channel("coffee-service-i6avjiaelq-ts.a.run.app", ChannelType.TLS, AuthType.TLS);
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
            return null;
        }
}
```

```java

private final CoffeeClient coffeeClient;

public TC009_GrpcApi() throws IOException {
    coffeeClient = new CoffeeClient();
}

@Test
public void updateCoffee() throws Exception {
        UpdateCoffeeResponse bookResponse = coffeeClient.updateCoffee();
        Assert.assertEquals(bookResponse.getMessage(), "Coffee Details Updated");
}
        
```