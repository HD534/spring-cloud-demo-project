package com.spring.demo.springcloudhystrixservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//config the application name
@FeignClient(value = "spring-cloud-client", fallback = EurekaClient.EurekaClientFallback.class)
public interface EurekaClient {

    @RequestMapping(method = RequestMethod.GET, value = "test")
    String getClientValue();

    @Component
    class EurekaClientFallback implements EurekaClient {

        @Override
        public String getClientValue() {
            return "failed to get client value";
        }
    }

}
