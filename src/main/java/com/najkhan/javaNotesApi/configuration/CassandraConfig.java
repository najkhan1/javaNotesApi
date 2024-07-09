package com.najkhan.javaNotesApi.configuration;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@RequiredArgsConstructor
@ConfigurationProperties("cassandra")
public class CassandraConfig {
    private final String host;
    private final String keyspace;
    private final String datacenter;
}
