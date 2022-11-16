package com.example.howtodoinjava.springhystrixschoolservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

//@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker
@SpringBootApplication
public class SpringHystrixMyMovieServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringHystrixMyMovieServiceApplication.class, args);
    }
}
