package com.movie.moviestore;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.45.0)",
    comments = "Source: moviestore/moviestore.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MovieStoreServiceGrpc {

  private MovieStoreServiceGrpc() {}

  public static final String SERVICE_NAME = "moviestore.MovieStoreService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.movie.moviestore.MovieStoreRequest,
      com.movie.moviestore.MovieStoreResponse> getGetMoviesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getMovies",
      requestType = com.movie.moviestore.MovieStoreRequest.class,
      responseType = com.movie.moviestore.MovieStoreResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.movie.moviestore.MovieStoreRequest,
      com.movie.moviestore.MovieStoreResponse> getGetMoviesMethod() {
    io.grpc.MethodDescriptor<com.movie.moviestore.MovieStoreRequest, com.movie.moviestore.MovieStoreResponse> getGetMoviesMethod;
    if ((getGetMoviesMethod = MovieStoreServiceGrpc.getGetMoviesMethod) == null) {
      synchronized (MovieStoreServiceGrpc.class) {
        if ((getGetMoviesMethod = MovieStoreServiceGrpc.getGetMoviesMethod) == null) {
          MovieStoreServiceGrpc.getGetMoviesMethod = getGetMoviesMethod =
              io.grpc.MethodDescriptor.<com.movie.moviestore.MovieStoreRequest, com.movie.moviestore.MovieStoreResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getMovies"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.movie.moviestore.MovieStoreRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.movie.moviestore.MovieStoreResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MovieStoreServiceMethodDescriptorSupplier("getMovies"))
              .build();
        }
      }
    }
    return getGetMoviesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MovieStoreServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MovieStoreServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MovieStoreServiceStub>() {
        @java.lang.Override
        public MovieStoreServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MovieStoreServiceStub(channel, callOptions);
        }
      };
    return MovieStoreServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MovieStoreServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MovieStoreServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MovieStoreServiceBlockingStub>() {
        @java.lang.Override
        public MovieStoreServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MovieStoreServiceBlockingStub(channel, callOptions);
        }
      };
    return MovieStoreServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MovieStoreServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MovieStoreServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MovieStoreServiceFutureStub>() {
        @java.lang.Override
        public MovieStoreServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MovieStoreServiceFutureStub(channel, callOptions);
        }
      };
    return MovieStoreServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class MovieStoreServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * server streaming rpc call to receive a stream of movies
     * </pre>
     */
    public void getMovies(com.movie.moviestore.MovieStoreRequest request,
        io.grpc.stub.StreamObserver<com.movie.moviestore.MovieStoreResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMoviesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetMoviesMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.movie.moviestore.MovieStoreRequest,
                com.movie.moviestore.MovieStoreResponse>(
                  this, METHODID_GET_MOVIES)))
          .build();
    }
  }

  /**
   */
  public static final class MovieStoreServiceStub extends io.grpc.stub.AbstractAsyncStub<MovieStoreServiceStub> {
    private MovieStoreServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MovieStoreServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MovieStoreServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * server streaming rpc call to receive a stream of movies
     * </pre>
     */
    public void getMovies(com.movie.moviestore.MovieStoreRequest request,
        io.grpc.stub.StreamObserver<com.movie.moviestore.MovieStoreResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetMoviesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class MovieStoreServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<MovieStoreServiceBlockingStub> {
    private MovieStoreServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MovieStoreServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MovieStoreServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * server streaming rpc call to receive a stream of movies
     * </pre>
     */
    public java.util.Iterator<com.movie.moviestore.MovieStoreResponse> getMovies(
        com.movie.moviestore.MovieStoreRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetMoviesMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class MovieStoreServiceFutureStub extends io.grpc.stub.AbstractFutureStub<MovieStoreServiceFutureStub> {
    private MovieStoreServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MovieStoreServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MovieStoreServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GET_MOVIES = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MovieStoreServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MovieStoreServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_MOVIES:
          serviceImpl.getMovies((com.movie.moviestore.MovieStoreRequest) request,
              (io.grpc.stub.StreamObserver<com.movie.moviestore.MovieStoreResponse>) responseObserver);
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

  private static abstract class MovieStoreServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MovieStoreServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.movie.moviestore.Moviestore.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MovieStoreService");
    }
  }

  private static final class MovieStoreServiceFileDescriptorSupplier
      extends MovieStoreServiceBaseDescriptorSupplier {
    MovieStoreServiceFileDescriptorSupplier() {}
  }

  private static final class MovieStoreServiceMethodDescriptorSupplier
      extends MovieStoreServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MovieStoreServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (MovieStoreServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MovieStoreServiceFileDescriptorSupplier())
              .addMethod(getGetMoviesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
