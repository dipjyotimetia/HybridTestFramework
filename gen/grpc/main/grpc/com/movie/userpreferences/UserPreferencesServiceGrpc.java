package com.movie.userpreferences;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.45.0)",
    comments = "Source: userpreferences/userpreferences.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class UserPreferencesServiceGrpc {

  private UserPreferencesServiceGrpc() {}

  public static final String SERVICE_NAME = "userpreferences.UserPreferencesService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.movie.userpreferences.UserPreferencesRequest,
      com.movie.userpreferences.UserPreferencesResponse> getGetShortlistedMoviesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getShortlistedMovies",
      requestType = com.movie.userpreferences.UserPreferencesRequest.class,
      responseType = com.movie.userpreferences.UserPreferencesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.movie.userpreferences.UserPreferencesRequest,
      com.movie.userpreferences.UserPreferencesResponse> getGetShortlistedMoviesMethod() {
    io.grpc.MethodDescriptor<com.movie.userpreferences.UserPreferencesRequest, com.movie.userpreferences.UserPreferencesResponse> getGetShortlistedMoviesMethod;
    if ((getGetShortlistedMoviesMethod = UserPreferencesServiceGrpc.getGetShortlistedMoviesMethod) == null) {
      synchronized (UserPreferencesServiceGrpc.class) {
        if ((getGetShortlistedMoviesMethod = UserPreferencesServiceGrpc.getGetShortlistedMoviesMethod) == null) {
          UserPreferencesServiceGrpc.getGetShortlistedMoviesMethod = getGetShortlistedMoviesMethod =
              io.grpc.MethodDescriptor.<com.movie.userpreferences.UserPreferencesRequest, com.movie.userpreferences.UserPreferencesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getShortlistedMovies"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.movie.userpreferences.UserPreferencesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.movie.userpreferences.UserPreferencesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserPreferencesServiceMethodDescriptorSupplier("getShortlistedMovies"))
              .build();
        }
      }
    }
    return getGetShortlistedMoviesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserPreferencesServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserPreferencesServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserPreferencesServiceStub>() {
        @java.lang.Override
        public UserPreferencesServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserPreferencesServiceStub(channel, callOptions);
        }
      };
    return UserPreferencesServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserPreferencesServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserPreferencesServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserPreferencesServiceBlockingStub>() {
        @java.lang.Override
        public UserPreferencesServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserPreferencesServiceBlockingStub(channel, callOptions);
        }
      };
    return UserPreferencesServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserPreferencesServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserPreferencesServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserPreferencesServiceFutureStub>() {
        @java.lang.Override
        public UserPreferencesServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserPreferencesServiceFutureStub(channel, callOptions);
        }
      };
    return UserPreferencesServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class UserPreferencesServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Bidirectional streaming rpc call to receive a stream of movies shortlisted based on user preferences
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.movie.userpreferences.UserPreferencesRequest> getShortlistedMovies(
        io.grpc.stub.StreamObserver<com.movie.userpreferences.UserPreferencesResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getGetShortlistedMoviesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetShortlistedMoviesMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                com.movie.userpreferences.UserPreferencesRequest,
                com.movie.userpreferences.UserPreferencesResponse>(
                  this, METHODID_GET_SHORTLISTED_MOVIES)))
          .build();
    }
  }

  /**
   */
  public static final class UserPreferencesServiceStub extends io.grpc.stub.AbstractAsyncStub<UserPreferencesServiceStub> {
    private UserPreferencesServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserPreferencesServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserPreferencesServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Bidirectional streaming rpc call to receive a stream of movies shortlisted based on user preferences
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.movie.userpreferences.UserPreferencesRequest> getShortlistedMovies(
        io.grpc.stub.StreamObserver<com.movie.userpreferences.UserPreferencesResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getGetShortlistedMoviesMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class UserPreferencesServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<UserPreferencesServiceBlockingStub> {
    private UserPreferencesServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserPreferencesServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserPreferencesServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class UserPreferencesServiceFutureStub extends io.grpc.stub.AbstractFutureStub<UserPreferencesServiceFutureStub> {
    private UserPreferencesServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserPreferencesServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserPreferencesServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GET_SHORTLISTED_MOVIES = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UserPreferencesServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UserPreferencesServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_SHORTLISTED_MOVIES:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getShortlistedMovies(
              (io.grpc.stub.StreamObserver<com.movie.userpreferences.UserPreferencesResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class UserPreferencesServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserPreferencesServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.movie.userpreferences.Userpreferences.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UserPreferencesService");
    }
  }

  private static final class UserPreferencesServiceFileDescriptorSupplier
      extends UserPreferencesServiceBaseDescriptorSupplier {
    UserPreferencesServiceFileDescriptorSupplier() {}
  }

  private static final class UserPreferencesServiceMethodDescriptorSupplier
      extends UserPreferencesServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UserPreferencesServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (UserPreferencesServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserPreferencesServiceFileDescriptorSupplier())
              .addMethod(getGetShortlistedMoviesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
