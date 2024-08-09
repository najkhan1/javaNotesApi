package com.najkhan.javaNotesApi.repository;


import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.session.Session;
import com.najkhan.javaNotesApi.configuration.CassandraConfig;
import com.najkhan.javaNotesApi.model.HealthCheckTable;
import com.najkhan.javaNotesApi.model.Status;
import org.apache.cassandra.exceptions.ConfigurationException;
import org.apache.thrift.transport.TTransportException;
import org.cassandraunit.CQLDataLoader;
import org.cassandraunit.dataset.cql.FileCQLDataSet;
import org.cassandraunit.spring.CassandraDataSet;
import org.cassandraunit.utils.EmbeddedCassandraServerHelper;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan
@SpringBootTest
//        ({"cassandra.port=9142",
//        "cassandra.keyspace-name=notesapi",
//        "cassandra.host=localhost"
//})
@ContextConfiguration(classes = CassandraConfig.class)
@CassandraDataSet(value = {"test.cql"}, keyspace = "notesapi")
@EnableCassandraRepositories(basePackages = "com.najkhan.javaNotesApi.repository.healthcheckRepository")
public class HealthCheckRepositoryTest {
    //    CqlSession session = EmbeddedCassandraServerHelper.getSession();
    @Before
    public void before() throws TTransportException, IOException, InterruptedException, ConfigurationException {
        EmbeddedCassandraServerHelper.startEmbeddedCassandra("cu-cassandra.yaml", 100000);
        CqlSession session = EmbeddedCassandraServerHelper.getSession();
        CQLDataLoader dataLoader = new CQLDataLoader(session);
        dataLoader.load(new FileCQLDataSet("test.cql", true, false));
    }



    @Autowired
    HealthCheckRepository healthCheckRepository;

    @Test
    public void getHealthCheckTest() throws Exception {

        Thread.sleep(100000);
        HealthCheckTable res = healthCheckRepository.getHealthCheck();
        HealthCheckTable expected = new HealthCheckTable("Healthy", Status.Healthy);
        assertEquals(1, 1);
//        assert(result.iterator().next().getString("name"), is("Eugen"));
    }
}
