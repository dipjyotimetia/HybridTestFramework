package com.pubsub;

import lombok.Builder;

import java.util.Properties;

@Builder
public class Config {
    private String Topic;
    private String Brokers;
    private String BootstrapURL;
    private String Partition;
    private String SchemaRegistry;
    private String GroupID;
    private Properties properties;
    private String data;
}
