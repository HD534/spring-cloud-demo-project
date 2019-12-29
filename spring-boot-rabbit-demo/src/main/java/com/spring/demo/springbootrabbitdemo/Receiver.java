package com.spring.demo.springbootrabbitdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Receiver {

    private static final Logger LOG = LoggerFactory.getLogger(Receiver.class);

    @Autowired
    private MessageConverter messageConverter;


    @PostConstruct
    public void init() {
    }


    @RabbitListener(queues = "hello.queue1")
    public Todo processMessage1(Todo msg) {
        LOG.debug("{}  接收到来自hello.queue1队列的消息：{}", Thread.currentThread().getName(), msg);
        return msg;
    }

    @RabbitListener(queues = "hello.queue2")
    public void processMessage2(Todo msg) {
        LOG.debug("{}  接收到来自hello.queue2队列的消息：{} ", Thread.currentThread().getName(), msg);
    }

}
