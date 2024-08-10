package com.najkhan.javaNotesApi.configuration;


import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("cassandra")
public class CassandraConfig {
    private  String host;
    private  String keyspace;
    private  String datacenter;
    private Integer port;

    public CassandraConfig(){}

    public CassandraConfig(String host, String keyspace, String datacenter, Integer port) {
        this.host = host;
        this.keyspace = keyspace;
        this.datacenter = datacenter;
        this.port = port;
    }
}
