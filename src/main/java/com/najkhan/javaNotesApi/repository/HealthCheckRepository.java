package com.najkhan.javaNotesApi.repository;

import com.najkhan.javaNotesApi.model.HealthCheckTable;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthCheckRepository extends CassandraRepository<HealthCheckTable,Integer> {

    @Query("SELECT * FROM healthcheck where id = 'Healthy'")
    HealthCheckTable getHealthCheck() throws Exception;
}

