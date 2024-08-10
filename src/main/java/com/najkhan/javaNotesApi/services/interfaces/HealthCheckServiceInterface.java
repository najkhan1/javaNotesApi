package com.najkhan.javaNotesApi.services.interfaces;

import com.najkhan.javaNotesApi.model.Downstream;
import com.najkhan.javaNotesApi.model.Status;

import java.util.Map;

public interface HealthCheckServiceInterface {
    public Map<Downstream, Status> getHealthCheckStatus();
}
