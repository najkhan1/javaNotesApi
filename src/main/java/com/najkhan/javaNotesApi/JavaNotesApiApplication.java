package com.najkhan.javaNotesApi;

import com.najkhan.javaNotesApi.repository.HealthCheckTRepository;
import com.najkhan.javaNotesApi.repository.HealthCheckTable;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Log4j2
@SpringBootApplication
//        (exclude = {
//        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
//        org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class
//        }
//)
public class JavaNotesApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaNotesApiApplication.class, args);
    }
}


