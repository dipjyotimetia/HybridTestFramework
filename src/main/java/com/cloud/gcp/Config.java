package com.cloud.gcp;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.rpc.FixedTransportChannelProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.NoCredentials;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.pubsub.v1.SubscriptionAdminSettings;
import com.google.cloud.pubsub.v1.TopicAdminSettings;
import io.grpc.ManagedChannel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Config {
    public TransportChannelProvider channelProvider(ManagedChannel channel) {
        return FixedTransportChannelProvider.create(GrpcTransportChannel.create(channel));
    }

    public NoCredentialsProvider credentialProvider() {
        return NoCredentialsProvider.create();
    }

    public FirestoreOptions firestoreClient(String host, String projectID) {
        return FirestoreOptions.getDefaultInstance().toBuilder()
                .setHost(host)
                .setCredentials(NoCredentials.getInstance())
                .setProjectId(projectID)
                .build();
    }

    public SubscriptionAdminSettings subscriptionAdminSettings(TransportChannelProvider channelProvider, NoCredentialsProvider credentialsProvider) {
        try {
            return SubscriptionAdminSettings.newBuilder()
                    .setTransportChannelProvider(channelProvider)
                    .setCredentialsProvider(credentialsProvider)
                    .build();
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    public TopicAdminSettings topicAdminSettings(TransportChannelProvider channelProvider, NoCredentialsProvider credentialsProvider) {
        try {
            return TopicAdminSettings.newBuilder()
                    .setTransportChannelProvider(channelProvider)
                    .setCredentialsProvider(credentialsProvider)
                    .build();
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }
}
