package com.cloud.gcp;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class FireStore {
    FirestoreOptions options;
    Config config = new Config();

    public FireStore(String host, String projectID) {
        options = config.firestoreClient(host, projectID);
    }

    public QuerySnapshot addQuery() throws ExecutionException, InterruptedException {
        Firestore firestore = options.getService();
        CollectionReference users = firestore.collection("users");
        DocumentReference docRef = users.document("alovelace");
        Map<String, Object> data = new HashMap<>();
        data.put("first", "Ada");
        data.put("last", "Lovelace");
        ApiFuture<WriteResult> result = docRef.set(data);
        result.get();
        ApiFuture<QuerySnapshot> query = users.get();
        return query.get();
    }
}
