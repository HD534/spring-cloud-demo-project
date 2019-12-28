package com.spring.demo.springcloudhystrixservice.controller;

import com.spring.demo.springcloudhystrixservice.service.HystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hystrix")
public class HystrixController {

    @Autowired
    HystrixService hystrixService;

    @GetMapping("value")
    public String getValue() throws InterruptedException {
        return hystrixService.getStringValueFromClient();
    }

}
