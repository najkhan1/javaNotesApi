package com.najkhan.javaNotesApi.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

public interface HealthCheckTRepository extends CassandraRepository<HealthCheckTable,Integer> {

    @Query("SELECT * FROM healthcheck where id = 'Healthy'")
    HealthCheckTable getHealthCheck() throws Exception;
}

