package com.najkhan.javaNotesApi.Controller;

import com.najkhan.javaNotesApi.model.Downstream;
import com.najkhan.javaNotesApi.model.Status;
import com.najkhan.javaNotesApi.services.HealthCheckService;
import com.najkhan.javaNotesApi.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class HealthCheckController {

    @Autowired
    HealthCheckService healthCheckService;

    private final UsersService userService;

    public HealthCheckController(UsersService userService) {
        this.userService = userService;
    }

    @GetMapping("/health")
    public ResponseEntity<Map<Downstream, Status>> handleHealthCheck() {
        return ResponseEntity.ok(healthCheckService.getHealthCheckStatus());
    }
}
