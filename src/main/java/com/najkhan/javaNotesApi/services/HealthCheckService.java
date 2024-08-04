package com.najkhan.javaNotesApi.services;

import com.najkhan.javaNotesApi.model.Status;
import com.najkhan.javaNotesApi.model.Downstream;
import com.najkhan.javaNotesApi.repository.HealthCheckRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Log4j2
@Service
public class HealthCheckService {
    @Autowired
    HealthCheckRepository healthCheckRepository;

    public Map<Downstream, Status> getHealthCheckStatus() {
        Map<Downstream, Status> dependencies = new HashMap<Downstream, Status>();
        try {
            dependencies.put(Downstream.Cassandra, healthCheckRepository.getHealthCheck().getStatus()
            );
        } catch (Exception e) {
            log.error("Cassandra is unhealthy exception: {}", e.getMessage());
            dependencies.put(Downstream.Cassandra, Status.Unhealthy);
        }
        return dependencies;
    }


}
