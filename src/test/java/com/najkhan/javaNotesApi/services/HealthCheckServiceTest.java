package com.najkhan.javaNotesApi.services;

import com.najkhan.javaNotesApi.model.Downstream;
import com.najkhan.javaNotesApi.model.HealthCheckTable;
import com.najkhan.javaNotesApi.model.Status;
import com.najkhan.javaNotesApi.repository.HealthCheckRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
public class HealthCheckServiceTest {

    @Mock
    private HealthCheckRepository healthCheckRepository;

    @InjectMocks
    private HealthCheckService healthCheckService;

    @DisplayName("getHealthCheckStatusTest should return healthy status if cassandra is healthy")
    @Test
    public void givenCassandraIsHealthy_thenGetHealthCheckStatusTest_returnsMapWithCorrectDownstreamAndStatus() throws Exception {
        Mockito.when(healthCheckRepository.getHealthCheck()).thenReturn(new HealthCheckTable("Healthy", Status.Healthy));

        Map<Downstream, Status> cassandraStatus = healthCheckService.getHealthCheckStatus();

        Map<Downstream, Status> expected = new HashMap<>();
        expected.put(Downstream.Cassandra, Status.Healthy);

        Assertions.assertEquals(cassandraStatus, expected);
    }

    @DisplayName("getHealthCheckStatusTest should return Unhealthy status if cassandra is Unhealthy")
    @Test
    public void givenCassandraIsUnHealthy_thenGetHealthCheckStatusTest_returnsMapWithCorrectDownstreamAndStatus() throws Exception {
        Mockito.when(healthCheckRepository.getHealthCheck()).thenReturn(new HealthCheckTable("Healthy", Status.Unhealthy));

        Map<Downstream, Status> cassandraStatus = healthCheckService.getHealthCheckStatus();

        Map<Downstream, Status> expected = new HashMap<>();
        expected.put(Downstream.Cassandra, Status.Unhealthy);

        Assertions.assertEquals(cassandraStatus, expected);
    }

    @DisplayName("getHealthCheckStatusTest should return Unhealthy status if cassandra connection throw exception")
    @Test
    public void givenException_thenGetHealthCheckStatusTest_returnsMapWithCorrectDownstreamAndStatusUnhealthy() throws Exception {
        Mockito.when(healthCheckRepository.getHealthCheck()).thenThrow(new Exception("exception"));

        Map<Downstream, Status> cassandraStatus = healthCheckService.getHealthCheckStatus();

        Map<Downstream, Status> expected = new HashMap<>();
        expected.put(Downstream.Cassandra, Status.Unhealthy);

        Assertions.assertEquals(cassandraStatus, expected);
    }

}
