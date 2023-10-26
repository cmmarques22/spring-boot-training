package com.cmmarques22;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@ComponentScan(basePackages = "com.cmmarques22")
@EnableAutoConfiguration
@Configuration
@RestController
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        //System.out.println("Hello Springboot");
    }
        @GetMapping("/greet")
        public String greet() {
        return "Hello Spring";

    }
}
