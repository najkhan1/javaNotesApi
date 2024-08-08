package com.najkhan.javaNotesApi.repository;


import com.datastax.oss.driver.api.core.CqlSession;
import com.najkhan.javaNotesApi.configuration.CassandraConfig;
import com.najkhan.javaNotesApi.model.HealthCheckTable;
import com.najkhan.javaNotesApi.model.Status;
import org.cassandraunit.spring.CassandraDataSet;
import org.cassandraunit.spring.CassandraUnitTestExecutionListener;
import org.cassandraunit.spring.EmbeddedCassandra;
import org.cassandraunit.utils.EmbeddedCassandraServerHelper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({CassandraUnitTestExecutionListener.class})
//@CassandraDataSet(value = "people.cql", keyspace = "people")
@EmbeddedCassandra
@SpringBootTest()
@ContextConfiguration(classes = CassandraConfig.class)
public class HealthCheckRepositoryTest {
    //CqlSession session = EmbeddedCassandraServerHelper.getSession();
    @Autowired
    HealthCheckRepository healthCheckRepository;

    @Test
    public void getHealthCheckTest() throws Exception {

        HealthCheckTable res = healthCheckRepository.getHealthCheck();
        HealthCheckTable expected = new HealthCheckTable("Healthy", Status.Healthy);
        Assert.assertSame(res,expected);
//        assert(result.iterator().next().getString("name"), is("Eugen"));
    }
}
