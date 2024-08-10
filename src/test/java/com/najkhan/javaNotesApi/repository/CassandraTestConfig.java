//package com.najkhan.javaNotesApi.repository;
//
////import com.datastax.driver.core.Session;
//
//
//import com.datastax.oss.driver.api.core.CqlSession;
//import org.apache.cassandra.exceptions.ConfigurationException;
//import org.apache.thrift.transport.TTransportException;
//import org.cassandraunit.CQLDataLoader;
//import org.cassandraunit.dataset.cql.FileCQLDataSet;
//import org.cassandraunit.utils.EmbeddedCassandraServerHelper;
//import org.junit.Before;
//import org.junit.jupiter.api.BeforeAll;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
//
//import java.io.IOException;
//
////import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
//@Configuration
////@PropertySource("classpath:application.properties")
//public class CassandraTestConfig {
//    @Value("${cassandra.keyspace}")
//    public static String keyspace;
//    private static Logger logger = LoggerFactory.getLogger(CassandraTestConfig.class);
//
//    @Before
//    public void before() throws TTransportException, IOException, InterruptedException, ConfigurationException {
//        EmbeddedCassandraServerHelper.startEmbeddedCassandra("cu-cassandra.yaml", 100000);
//        CqlSession session = EmbeddedCassandraServerHelper.getSession();
//        CQLDataLoader dataLoader = new CQLDataLoader(session);
//        dataLoader.load(new FileCQLDataSet("test.cql", false, false, getKeyspaceNameStatic()));
//    }
//
//    protected static String getKeyspaceNameStatic() {
//        return keyspace;
//    }
//
//
//}
