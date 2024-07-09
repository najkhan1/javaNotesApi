package com.najkhan.javaNotesApi.Controller;

import com.najkhan.javaNotesApi.model.Downstream;
import com.najkhan.javaNotesApi.model.Status;
import com.najkhan.javaNotesApi.repository.HealthCheckTRepository;
import com.najkhan.javaNotesApi.repository.HealthCheckTable;
import com.najkhan.javaNotesApi.services.HealthCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class HealthCheckController {

    @Autowired
    HealthCheckService healthCheckService;

    @GetMapping("/health")
    public ResponseEntity<Map<Downstream, Status>> handleHealthCheck() {
        return ResponseEntity.ok(healthCheckService.getHealthCheckStatus());
    }

    @GetMapping("/hello")
    public ResponseEntity<String> helloWorld() {
        return ResponseEntity.ok("hello world");
    }

}
