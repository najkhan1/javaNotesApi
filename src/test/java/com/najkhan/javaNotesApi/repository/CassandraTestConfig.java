//package com.najkhan.javaNotesApi.repository;
//
////import com.datastax.driver.core.Session;
//
//
//import com.datastax.oss.driver.api.core.CqlSession;
//import org.cassandraunit.CQLDataLoader;
//import org.cassandraunit.dataset.cql.FileCQLDataSet;
//import org.cassandraunit.utils.EmbeddedCassandraServerHelper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
//
////import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
//@Configuration
//@PropertySource("classpath:application.properties")
//public class CassandraTestConfig extends AbstractCassandraConfiguration {
//    @Value("${service.cassandra.keyspace}")
//    public String keyspace;
//    private Logger logger = LoggerFactory.getLogger(CassandraTestConfig.class);
//
//    @Bean
//    public CqlSession cluster() {
//        try {
//            EmbeddedCassandraServerHelper.startEmbeddedCassandra(EmbeddedCassandraServerHelper.DEFAULT_CASSANDRA_YML_FILE, 1000000L);
//            CqlSession session = EmbeddedCassandraServerHelper.getSession();
//            CQLDataLoader dataLoader = new CQLDataLoader(session);
//            dataLoader.load(new FileCQLDataSet("test.cql", false, false, getKeyspaceName()));
//        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
//            throw new RuntimeException("Can't start Embedded Cassandra", e);
//        }
//        return super.getRequiredSession();
//    }
//
//    @Override
//    protected String getKeyspaceName() {
//        return keyspace;
//    }
//
//    @Override
//    protected int getPort() {
//        return 9142;
//    }
//}
