package com.api.grpc;

import com.google.auth.oauth2.GoogleCredentials;
import io.grpc.*;
import io.grpc.auth.MoreCallCredentials;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;

@Slf4j
public class Common {
    enum AuthType {
        TLS,
        Insecure,
        TLS_CA,
        GOOGLE
    }

    enum ChannelType {
        LOCALHOST,
        TLS
    }

    /**
     * Channel credentials
     *
     * @param authType authType
     * @return credentials
     * @throws IOException @exception
     */
    public ChannelCredentials credentials(AuthType authType) throws IOException {
        ChannelCredentials credentials = null;
        switch (authType) {
            case TLS:
                credentials = TlsChannelCredentials.create();
                break;
            case Insecure:
                credentials = InsecureChannelCredentials.create();
                break;
            case TLS_CA:
                credentials = TlsChannelCredentials.newBuilder()
                        .trustManager(new File("roots.pem"))
                        .build();
                break;
            case GOOGLE:
                credentials = CompositeChannelCredentials
                        .create(TlsChannelCredentials.create(), MoreCallCredentials.from(GoogleCredentials.getApplicationDefault()));
                break;
            default:
                log.error("required a valid input parameter");
                break;
        }
        return credentials;
    }

    /**
     * Channel
     *
     * @param targetURL   targetURL
     * @param channelType channelType
     * @param authType    authType
     * @return channel
     * @throws IOException @exception
     */
    public ManagedChannel channel(String targetURL, ChannelType channelType, AuthType authType) throws IOException {
        ManagedChannel channel = null;
        switch (channelType) {
            case LOCALHOST:
                channel = ManagedChannelBuilder.forTarget(targetURL).usePlaintext().build();
                break;
            case TLS:
                channel = Grpc.newChannelBuilder(targetURL, credentials(authType)).build();
                break;
            default:
                log.error("required a valid input parameter");
                break;
        }
        return channel;
    }
}
