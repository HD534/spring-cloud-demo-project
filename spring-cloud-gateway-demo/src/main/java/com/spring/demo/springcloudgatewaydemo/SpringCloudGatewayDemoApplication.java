package com.spring.demo.springcloudgatewaydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * EnableZuulProxy to enable this application as a gateway
 * EnableEurekaClient to register to Eureka Server
 */
@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class SpringCloudGatewayDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudGatewayDemoApplication.class, args);
    }

}
