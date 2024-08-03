package com.najkhan.javaNotesApi.Controller;

import com.najkhan.javaNotesApi.model.Downstream;
import com.najkhan.javaNotesApi.model.Status;
import com.najkhan.javaNotesApi.model.Users;
import com.najkhan.javaNotesApi.repository.HealthCheckTRepository;
import com.najkhan.javaNotesApi.repository.HealthCheckTable;
import com.najkhan.javaNotesApi.services.HealthCheckService;
import com.najkhan.javaNotesApi.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @GetMapping("/hello")
    public ResponseEntity<String> helloWorld() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String currentUser = authentication.getName();
        return ResponseEntity.ok("hello world");
    }

}
