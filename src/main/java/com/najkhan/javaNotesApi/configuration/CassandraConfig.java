package com.najkhan.javaNotesApi.configuration;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("cassandra")
public class CassandraConfig {
//    @Value(value = "${cassandra.host}")
    private  String host;
    private  String keyspace;
    private  String datacenter;
    private Integer port;

}
