package com.najkhan.javaNotesApi.repository.client;

import com.najkhan.javaNotesApi.configuration.CassandraConfig;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.CqlSessionFactoryBean;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableConfigurationProperties(CassandraConfig.class)
@EnableCassandraRepositories(basePackages = "com.najkhan.javaNotesApi.repository")
public class Cassandra {

    @Bean
    public CqlSessionFactoryBean session(CassandraConfig cassandraConfig) {

        CqlSessionFactoryBean session = new CqlSessionFactoryBean();
        session.setContactPoints(cassandraConfig.getHost());
        session.setPort(cassandraConfig.getPort());
        session.setKeyspaceName(cassandraConfig.getKeyspace());
        session.setLocalDatacenter(cassandraConfig.getDatacenter());

        return session;
    }
}
