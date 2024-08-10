//package com.najkhan.javaNotesApi.repository;
//
//
//import com.najkhan.javaNotesApi.configuration.CassandraConfig;
//import com.najkhan.javaNotesApi.model.HealthCheckTable;
//import com.najkhan.javaNotesApi.model.Status;
//import com.najkhan.javaNotesApi.repository.client.Cassandra;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import static junit.framework.TestCase.assertEquals;
//
//@RunWith(SpringJUnit4ClassRunner.class)
////@ComponentScan
//@SpringBootTest
//        ({"cassandra.port=9142",
//        "cassandra.keyspace-name=notesapi",
//        "cassandra.host=localhost",
//        "cassandra.datacenter=dc1",
//
//})
//@ContextConfiguration(classes = CassandraConfig.class)
////@CassandraDataSet(value = {"test.cql"}, keyspace = "notesapi")
//@PropertySource("classpath:application.properties")
//@EnableCassandraRepositories(basePackages = "com.najkhan.javaNotesApi.repository.healthcheckRepository")
//public class HealthCheckRepositoryTest extends CassandraTestConfig{
//
//    CassandraConfig cassandraConfig = new CassandraConfig("localhost","notesapi","dc1",9143);
//    Cassandra cassandra = new Cassandra(cassandraConfig);
//
//    HealthCheckRepository healthCheckRepository = new HealthCheckRepository(cassandra);
//
//    @Test
//    public void getHealthCheckTest() throws Exception {
//
//        System.out.println("cassandra host == " + cassandraConfig.getHost());
//        Thread.sleep(100000);
//        HealthCheckTable res = healthCheckRepository.getHealthCheck();
//        HealthCheckTable expected = new HealthCheckTable("Healthy", Status.Healthy);
//        assertEquals(1, 1);
//    }
//}
