package com.eventing;

import lombok.Builder;
import lombok.Data;

import java.util.Properties;

@Data
@Builder
public class Config {
    private String Topic;
    private String Brokers;
    private String BootstrapURL;
    private String Partition;
    private String SchemaRegistry;
    private String GroupID;
    private Properties Properties;
    private String Data;
}
