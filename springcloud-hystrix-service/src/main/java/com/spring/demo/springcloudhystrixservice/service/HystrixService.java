package com.spring.demo.springcloudhystrixservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class HystrixService {

    //1. use restTemplate
    /*
    private static final String CLIENT_URL = "http://spring-cloud-client/test";

    @Autowired
    RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    @HystrixCommand(fallbackMethod = "getStringValueFromClientFailed")
    public String getStringValueFromClient() throws InterruptedException {
        String clientResult = restTemplate.getForObject(CLIENT_URL, String.class);
        TimeUnit.SECONDS.sleep(5);
        return clientResult;
    }

    public String getStringValueFromClientFailed(){
        log.error("------------ method getStringValueFromClient failed... ------------");
        return "failed to get value from client";
    }


    */

    //2. use Feign
    @Autowired
    EurekaClient eurekaClient;

    public String getStringValueFromClient() throws InterruptedException {
        log.info("------------ start using Feign to easily call microservice API");
        String clientResult = eurekaClient.getClientValue();
//        TimeUnit.SECONDS.sleep(5);
        log.info("------------ end using Feign to easily call microservice API");
        return clientResult;
    }


}
