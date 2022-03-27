package com.movie.moviecontroller;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.45.0)",
    comments = "Source: moviecontroller/moviecontroller.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MovieControllerServiceGrpc {

  private MovieControllerServiceGrpc() {}

  public static final String SERVICE_NAME = "moviecontroller.MovieControllerService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.movie.moviecontroller.MovieRequest,
      com.movie.moviecontroller.MovieResponse> getGetMovieMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getMovie",
      requestType = com.movie.moviecontroller.MovieRequest.class,
      responseType = com.movie.moviecontroller.MovieResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.movie.moviecontroller.MovieRequest,
      com.movie.moviecontroller.MovieResponse> getGetMovieMethod() {
    io.grpc.MethodDescriptor<com.movie.moviecontroller.MovieRequest, com.movie.moviecontroller.MovieResponse> getGetMovieMethod;
    if ((getGetMovieMethod = MovieControllerServiceGrpc.getGetMovieMethod) == null) {
      synchronized (MovieControllerServiceGrpc.class) {
        if ((getGetMovieMethod = MovieControllerServiceGrpc.getGetMovieMethod) == null) {
          MovieControllerServiceGrpc.getGetMovieMethod = getGetMovieMethod =
              io.grpc.MethodDescriptor.<com.movie.moviecontroller.MovieRequest, com.movie.moviecontroller.MovieResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getMovie"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.movie.moviecontroller.MovieRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.movie.moviecontroller.MovieResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MovieControllerServiceMethodDescriptorSupplier("getMovie"))
              .build();
        }
      }
    }
    return getGetMovieMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MovieControllerServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MovieControllerServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MovieControllerServiceStub>() {
        @java.lang.Override
        public MovieControllerServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MovieControllerServiceStub(channel, callOptions);
        }
      };
    return MovieControllerServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MovieControllerServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MovieControllerServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MovieControllerServiceBlockingStub>() {
        @java.lang.Override
        public MovieControllerServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MovieControllerServiceBlockingStub(channel, callOptions);
        }
      };
    return MovieControllerServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MovieControllerServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MovieControllerServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MovieControllerServiceFutureStub>() {
        @java.lang.Override
        public MovieControllerServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MovieControllerServiceFutureStub(channel, callOptions);
        }
      };
    return MovieControllerServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class MovieControllerServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * unary rpc call to retrieve a movie
     * </pre>
     */
    public void getMovie(com.movie.moviecontroller.MovieRequest request,
        io.grpc.stub.StreamObserver<com.movie.moviecontroller.MovieResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMovieMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetMovieMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.movie.moviecontroller.MovieRequest,
                com.movie.moviecontroller.MovieResponse>(
                  this, METHODID_GET_MOVIE)))
          .build();
    }
  }

  /**
   */
  public static final class MovieControllerServiceStub extends io.grpc.stub.AbstractAsyncStub<MovieControllerServiceStub> {
    private MovieControllerServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MovieControllerServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MovieControllerServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * unary rpc call to retrieve a movie
     * </pre>
     */
    public void getMovie(com.movie.moviecontroller.MovieRequest request,
        io.grpc.stub.StreamObserver<com.movie.moviecontroller.MovieResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMovieMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class MovieControllerServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<MovieControllerServiceBlockingStub> {
    private MovieControllerServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MovieControllerServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MovieControllerServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * unary rpc call to retrieve a movie
     * </pre>
     */
    public com.movie.moviecontroller.MovieResponse getMovie(com.movie.moviecontroller.MovieRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMovieMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class MovieControllerServiceFutureStub extends io.grpc.stub.AbstractFutureStub<MovieControllerServiceFutureStub> {
    private MovieControllerServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MovieControllerServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MovieControllerServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * unary rpc call to retrieve a movie
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.movie.moviecontroller.MovieResponse> getMovie(
        com.movie.moviecontroller.MovieRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMovieMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_MOVIE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MovieControllerServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MovieControllerServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_MOVIE:
          serviceImpl.getMovie((com.movie.moviecontroller.MovieRequest) request,
              (io.grpc.stub.StreamObserver<com.movie.moviecontroller.MovieResponse>) responseObserver);
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

  private static abstract class MovieControllerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MovieControllerServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.movie.moviecontroller.Moviecontroller.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MovieControllerService");
    }
  }

  private static final class MovieControllerServiceFileDescriptorSupplier
      extends MovieControllerServiceBaseDescriptorSupplier {
    MovieControllerServiceFileDescriptorSupplier() {}
  }

  private static final class MovieControllerServiceMethodDescriptorSupplier
      extends MovieControllerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MovieControllerServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (MovieControllerServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MovieControllerServiceFileDescriptorSupplier())
              .addMethod(getGetMovieMethod())
              .build();
        }
      }
    }
    return result;
  }
}
