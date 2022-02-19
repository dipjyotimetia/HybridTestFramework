package com.cloud.gcp;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.rpc.FixedTransportChannelProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Config {
    /**
     * ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8085").usePlaintext().build();
     * TransportChannelProvider channelProvider =
     *          FixedTransportChannelProvider.create(GrpcTransportChannel.create(channel));
     * CredentialsProvider credentialsProvider = NoCredentialsProvider.create();
     */

    ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8085").usePlaintext().build();

    public TransportChannelProvider ChannelProvider() {
        return FixedTransportChannelProvider.create(GrpcTransportChannel.create(channel));
    }

    public NoCredentialsProvider CredentialProvider() {
        return NoCredentialsProvider.create();
    }
}
