package com.najkhan.javaNotesApi.services;

import com.najkhan.javaNotesApi.model.Status;
import com.najkhan.javaNotesApi.model.Downstream;
import com.najkhan.javaNotesApi.repository.HealthCheckRepository;
import com.najkhan.javaNotesApi.services.interfaces.HealthCheckServiceInterface;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Log4j2
@Service
public class HealthCheckService implements HealthCheckServiceInterface {
    @Autowired
    HealthCheckRepository healthCheckRepository;

    @Override
    public Map<Downstream, Status> getHealthCheckStatus() {
        Map<Downstream, Status> dependencies = new HashMap<Downstream, Status>();
        try {
            Status healthCheckStatus = healthCheckRepository.getHealthCheck().getStatus();
            log.info("health check status {}", healthCheckStatus);
            dependencies.put(Downstream.Cassandra, healthCheckStatus
            );
        } catch (Exception e) {
            log.error("Cassandra is unhealthy exception: {}", e.fillInStackTrace());
            dependencies.put(Downstream.Cassandra, Status.Unhealthy);
        }
        return dependencies;
    }


}
