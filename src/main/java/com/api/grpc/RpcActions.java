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

package com.api.grpc;

import com.google.auth.oauth2.GoogleCredentials;
import io.grpc.*;
import io.grpc.auth.MoreCallCredentials;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;

@Slf4j
public class RpcActions {
    /**
     * Returns channel credentials for the given authentication type.
     *
     * @param authType the authentication type
     * @return channel credentials
     * @throws IOException if an error occurs while retrieving the channel credentials
     */
    public ChannelCredentials credentials(AuthType authType) throws IOException {
        ChannelCredentials credentials = null;
        switch (authType) {
            case TLS -> credentials = TlsChannelCredentials.create();
            case Insecure -> credentials = InsecureChannelCredentials.create();
            case TLS_CA -> credentials = TlsChannelCredentials.newBuilder()
                    .trustManager(new File("roots.pem"))
                    .build();
            case GOOGLE -> credentials = CompositeChannelCredentials
                    .create(TlsChannelCredentials.create(), MoreCallCredentials.from(GoogleCredentials.getApplicationDefault()));
            default -> log.error("required a valid input parameter");
        }
        return credentials;
    }

    /**
     * Returns a managed channel to the given target URL, using the given channel type and authentication type.
     *
     * @param targetURL the target URL
     * @param channelType the channel type
     * @param authType the authentication type
     * @return a managed channel to the given target URL
     * @throws IOException if an error occurs while creating the managed channel
     */
    public ManagedChannel channel(String targetURL, ChannelType channelType, AuthType authType) throws IOException {
        ManagedChannel channel = null;
        switch (channelType) {
            case LOCALHOST -> channel = ManagedChannelBuilder.forTarget(targetURL).usePlaintext().build();
            case TLS -> channel = Grpc.newChannelBuilder(targetURL, credentials(authType)).build();
            default -> log.error("required a valid input parameter");
        }
        return channel;
    }

    /**
     * Authentication types.
     */
    public enum AuthType {
        /**
         * Transport layer security (TLS) authentication.
         */
        TLS,
        /**
         * Insecure authentication.
         */
        Insecure,
        /**
         * TLS authentication with a custom certificate authority (CA).
         */
        TLS_CA,
        /**
         * Google Cloud Platform authentication.
         */
        GOOGLE
    }

    /**
     * Channel types.
     */
    public enum ChannelType {
        /**
         * A channel that connects to a localhost service.
         */
        LOCALHOST,
        /**
         * A channel that uses TLS encryption to connect to a remote service.
         */
        TLS
    }
}
