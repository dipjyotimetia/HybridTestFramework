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
    public enum AuthType {
        TLS,
        Insecure,
        TLS_CA,
        GOOGLE
    }

    public enum ChannelType {
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
