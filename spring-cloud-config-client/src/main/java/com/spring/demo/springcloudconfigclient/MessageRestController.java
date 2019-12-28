package com.spring.demo.springcloudconfigclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class MessageRestController {

    @Value("${user.role}")
    private String message;

    @RequestMapping("/msg")
    String getMessage() {
        return this.message;
    }

}
