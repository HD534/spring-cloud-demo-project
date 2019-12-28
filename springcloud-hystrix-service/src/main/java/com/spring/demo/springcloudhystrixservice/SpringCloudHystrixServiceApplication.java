package com.spring.demo.springcloudhystrixservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableCircuitBreaker
@EnableHystrixDashboard
@SpringBootApplication
@EnableFeignClients
public class SpringCloudHystrixServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudHystrixServiceApplication.class, args);
    }

}
