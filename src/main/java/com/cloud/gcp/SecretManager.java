package com.cloud.gcp;

import com.google.cloud.secretmanager.v1.AccessSecretVersionResponse;
import com.google.cloud.secretmanager.v1.SecretManagerServiceClient;
import com.google.cloud.secretmanager.v1.SecretVersionName;

import java.io.IOException;

public class SecretManager {

    public String accessSecretVersion() throws IOException{
        try(SecretManagerServiceClient client = SecretManagerServiceClient.create()) {
            SecretVersionName secretVersionName= SecretVersionName.of("","","");
            AccessSecretVersionResponse response = client.accessSecretVersion(secretVersionName);
            return response.getPayload().getData().toStringUtf8();
        }
    }

}
