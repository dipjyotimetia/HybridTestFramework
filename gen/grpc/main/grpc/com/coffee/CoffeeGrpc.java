package com.coffee;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.45.0)",
    comments = "Source: coffee.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CoffeeGrpc {

  private CoffeeGrpc() {}

  public static final String SERVICE_NAME = "coffee.Coffee";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.coffee.GetCoffeeRequest,
      com.coffee.GetCoffeeResponse> getGetCoffeeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCoffee",
      requestType = com.coffee.GetCoffeeRequest.class,
      responseType = com.coffee.GetCoffeeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.coffee.GetCoffeeRequest,
      com.coffee.GetCoffeeResponse> getGetCoffeeMethod() {
    io.grpc.MethodDescriptor<com.coffee.GetCoffeeRequest, com.coffee.GetCoffeeResponse> getGetCoffeeMethod;
    if ((getGetCoffeeMethod = CoffeeGrpc.getGetCoffeeMethod) == null) {
      synchronized (CoffeeGrpc.class) {
        if ((getGetCoffeeMethod = CoffeeGrpc.getGetCoffeeMethod) == null) {
          CoffeeGrpc.getGetCoffeeMethod = getGetCoffeeMethod =
              io.grpc.MethodDescriptor.<com.coffee.GetCoffeeRequest, com.coffee.GetCoffeeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCoffee"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.coffee.GetCoffeeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.coffee.GetCoffeeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CoffeeMethodDescriptorSupplier("GetCoffee"))
              .build();
        }
      }
    }
    return getGetCoffeeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.coffee.UpdateCoffeeRequest,
      com.coffee.UpdateCoffeeResponse> getUpdateCoffeeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCoffee",
      requestType = com.coffee.UpdateCoffeeRequest.class,
      responseType = com.coffee.UpdateCoffeeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.coffee.UpdateCoffeeRequest,
      com.coffee.UpdateCoffeeResponse> getUpdateCoffeeMethod() {
    io.grpc.MethodDescriptor<com.coffee.UpdateCoffeeRequest, com.coffee.UpdateCoffeeResponse> getUpdateCoffeeMethod;
    if ((getUpdateCoffeeMethod = CoffeeGrpc.getUpdateCoffeeMethod) == null) {
      synchronized (CoffeeGrpc.class) {
        if ((getUpdateCoffeeMethod = CoffeeGrpc.getUpdateCoffeeMethod) == null) {
          CoffeeGrpc.getUpdateCoffeeMethod = getUpdateCoffeeMethod =
              io.grpc.MethodDescriptor.<com.coffee.UpdateCoffeeRequest, com.coffee.UpdateCoffeeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCoffee"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.coffee.UpdateCoffeeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.coffee.UpdateCoffeeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CoffeeMethodDescriptorSupplier("UpdateCoffee"))
              .build();
        }
      }
    }
    return getUpdateCoffeeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.coffee.AddCoffeeRequest,
      com.coffee.AddCoffeeResponse> getAddCoffeeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddCoffee",
      requestType = com.coffee.AddCoffeeRequest.class,
      responseType = com.coffee.AddCoffeeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.coffee.AddCoffeeRequest,
      com.coffee.AddCoffeeResponse> getAddCoffeeMethod() {
    io.grpc.MethodDescriptor<com.coffee.AddCoffeeRequest, com.coffee.AddCoffeeResponse> getAddCoffeeMethod;
    if ((getAddCoffeeMethod = CoffeeGrpc.getAddCoffeeMethod) == null) {
      synchronized (CoffeeGrpc.class) {
        if ((getAddCoffeeMethod = CoffeeGrpc.getAddCoffeeMethod) == null) {
          CoffeeGrpc.getAddCoffeeMethod = getAddCoffeeMethod =
              io.grpc.MethodDescriptor.<com.coffee.AddCoffeeRequest, com.coffee.AddCoffeeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddCoffee"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.coffee.AddCoffeeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.coffee.AddCoffeeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CoffeeMethodDescriptorSupplier("AddCoffee"))
              .build();
        }
      }
    }
    return getAddCoffeeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.coffee.ListCoffeeRequest,
      com.coffee.ListCoffeeResponse> getListCoffeeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCoffee",
      requestType = com.coffee.ListCoffeeRequest.class,
      responseType = com.coffee.ListCoffeeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.coffee.ListCoffeeRequest,
      com.coffee.ListCoffeeResponse> getListCoffeeMethod() {
    io.grpc.MethodDescriptor<com.coffee.ListCoffeeRequest, com.coffee.ListCoffeeResponse> getListCoffeeMethod;
    if ((getListCoffeeMethod = CoffeeGrpc.getListCoffeeMethod) == null) {
      synchronized (CoffeeGrpc.class) {
        if ((getListCoffeeMethod = CoffeeGrpc.getListCoffeeMethod) == null) {
          CoffeeGrpc.getListCoffeeMethod = getListCoffeeMethod =
              io.grpc.MethodDescriptor.<com.coffee.ListCoffeeRequest, com.coffee.ListCoffeeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListCoffee"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.coffee.ListCoffeeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.coffee.ListCoffeeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CoffeeMethodDescriptorSupplier("ListCoffee"))
              .build();
        }
      }
    }
    return getListCoffeeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CoffeeStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CoffeeStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CoffeeStub>() {
        @java.lang.Override
        public CoffeeStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CoffeeStub(channel, callOptions);
        }
      };
    return CoffeeStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CoffeeBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CoffeeBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CoffeeBlockingStub>() {
        @java.lang.Override
        public CoffeeBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CoffeeBlockingStub(channel, callOptions);
        }
      };
    return CoffeeBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CoffeeFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CoffeeFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CoffeeFutureStub>() {
        @java.lang.Override
        public CoffeeFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CoffeeFutureStub(channel, callOptions);
        }
      };
    return CoffeeFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class CoffeeImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Get coffee details
     * </pre>
     */
    public void getCoffee(com.coffee.GetCoffeeRequest request,
        io.grpc.stub.StreamObserver<com.coffee.GetCoffeeResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCoffeeMethod(), responseObserver);
    }

    /**
     * <pre>
     * Update coffee details
     * </pre>
     */
    public void updateCoffee(com.coffee.UpdateCoffeeRequest request,
        io.grpc.stub.StreamObserver<com.coffee.UpdateCoffeeResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateCoffeeMethod(), responseObserver);
    }

    /**
     * <pre>
     * Add coffee details
     * </pre>
     */
    public void addCoffee(com.coffee.AddCoffeeRequest request,
        io.grpc.stub.StreamObserver<com.coffee.AddCoffeeResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddCoffeeMethod(), responseObserver);
    }

    /**
     * <pre>
     * List coffee details
     * </pre>
     */
    public void listCoffee(com.coffee.ListCoffeeRequest request,
        io.grpc.stub.StreamObserver<com.coffee.ListCoffeeResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListCoffeeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetCoffeeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.coffee.GetCoffeeRequest,
                com.coffee.GetCoffeeResponse>(
                  this, METHODID_GET_COFFEE)))
          .addMethod(
            getUpdateCoffeeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.coffee.UpdateCoffeeRequest,
                com.coffee.UpdateCoffeeResponse>(
                  this, METHODID_UPDATE_COFFEE)))
          .addMethod(
            getAddCoffeeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.coffee.AddCoffeeRequest,
                com.coffee.AddCoffeeResponse>(
                  this, METHODID_ADD_COFFEE)))
          .addMethod(
            getListCoffeeMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.coffee.ListCoffeeRequest,
                com.coffee.ListCoffeeResponse>(
                  this, METHODID_LIST_COFFEE)))
          .build();
    }
  }

  /**
   */
  public static final class CoffeeStub extends io.grpc.stub.AbstractAsyncStub<CoffeeStub> {
    private CoffeeStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CoffeeStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CoffeeStub(channel, callOptions);
    }

    /**
     * <pre>
     * Get coffee details
     * </pre>
     */
    public void getCoffee(com.coffee.GetCoffeeRequest request,
        io.grpc.stub.StreamObserver<com.coffee.GetCoffeeResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCoffeeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Update coffee details
     * </pre>
     */
    public void updateCoffee(com.coffee.UpdateCoffeeRequest request,
        io.grpc.stub.StreamObserver<com.coffee.UpdateCoffeeResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCoffeeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Add coffee details
     * </pre>
     */
    public void addCoffee(com.coffee.AddCoffeeRequest request,
        io.grpc.stub.StreamObserver<com.coffee.AddCoffeeResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddCoffeeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * List coffee details
     * </pre>
     */
    public void listCoffee(com.coffee.ListCoffeeRequest request,
        io.grpc.stub.StreamObserver<com.coffee.ListCoffeeResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getListCoffeeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CoffeeBlockingStub extends io.grpc.stub.AbstractBlockingStub<CoffeeBlockingStub> {
    private CoffeeBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CoffeeBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CoffeeBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Get coffee details
     * </pre>
     */
    public com.coffee.GetCoffeeResponse getCoffee(com.coffee.GetCoffeeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCoffeeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Update coffee details
     * </pre>
     */
    public com.coffee.UpdateCoffeeResponse updateCoffee(com.coffee.UpdateCoffeeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCoffeeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Add coffee details
     * </pre>
     */
    public com.coffee.AddCoffeeResponse addCoffee(com.coffee.AddCoffeeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddCoffeeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * List coffee details
     * </pre>
     */
    public java.util.Iterator<com.coffee.ListCoffeeResponse> listCoffee(
        com.coffee.ListCoffeeRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getListCoffeeMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CoffeeFutureStub extends io.grpc.stub.AbstractFutureStub<CoffeeFutureStub> {
    private CoffeeFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CoffeeFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CoffeeFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Get coffee details
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coffee.GetCoffeeResponse> getCoffee(
        com.coffee.GetCoffeeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCoffeeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Update coffee details
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coffee.UpdateCoffeeResponse> updateCoffee(
        com.coffee.UpdateCoffeeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCoffeeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Add coffee details
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coffee.AddCoffeeResponse> addCoffee(
        com.coffee.AddCoffeeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddCoffeeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_COFFEE = 0;
  private static final int METHODID_UPDATE_COFFEE = 1;
  private static final int METHODID_ADD_COFFEE = 2;
  private static final int METHODID_LIST_COFFEE = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CoffeeImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CoffeeImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_COFFEE:
          serviceImpl.getCoffee((com.coffee.GetCoffeeRequest) request,
              (io.grpc.stub.StreamObserver<com.coffee.GetCoffeeResponse>) responseObserver);
          break;
        case METHODID_UPDATE_COFFEE:
          serviceImpl.updateCoffee((com.coffee.UpdateCoffeeRequest) request,
              (io.grpc.stub.StreamObserver<com.coffee.UpdateCoffeeResponse>) responseObserver);
          break;
        case METHODID_ADD_COFFEE:
          serviceImpl.addCoffee((com.coffee.AddCoffeeRequest) request,
              (io.grpc.stub.StreamObserver<com.coffee.AddCoffeeResponse>) responseObserver);
          break;
        case METHODID_LIST_COFFEE:
          serviceImpl.listCoffee((com.coffee.ListCoffeeRequest) request,
              (io.grpc.stub.StreamObserver<com.coffee.ListCoffeeResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CoffeeBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CoffeeBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.coffee.CoffeeProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Coffee");
    }
  }

  private static final class CoffeeFileDescriptorSupplier
      extends CoffeeBaseDescriptorSupplier {
    CoffeeFileDescriptorSupplier() {}
  }

  private static final class CoffeeMethodDescriptorSupplier
      extends CoffeeBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CoffeeMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CoffeeGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CoffeeFileDescriptorSupplier())
              .addMethod(getGetCoffeeMethod())
              .addMethod(getUpdateCoffeeMethod())
              .addMethod(getAddCoffeeMethod())
              .addMethod(getListCoffeeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
