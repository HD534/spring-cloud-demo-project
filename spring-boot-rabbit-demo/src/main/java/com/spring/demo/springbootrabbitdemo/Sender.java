package com.spring.demo.springbootrabbitdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Component
public class Sender implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback {

    private static final Logger LOG = LoggerFactory.getLogger(Sender.class);


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private MessageConverter messageConverter;

    @PostConstruct
    public void init() {
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnCallback(this);
        rabbitTemplate.setMessageConverter(messageConverter);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack) {
            LOG.debug("消息发送成功: {}", correlationData);
        } else {
            LOG.debug("消息发送失败: {}", cause);
        }

    }

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        LOG.debug("{} 发送失败", message.getMessageProperties().getCorrelationId().toString());

    }

    //发送消息，不需要实现任何接口，供外部调用。
    public void send(Todo todo){

        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());

        LOG.debug("开始发送消息 : {}", todo);

        Object topicExchange = rabbitTemplate.convertSendAndReceive("topicExchange", "key.1", todo, correlationId);

        LOG.debug("结束发送消息 : {}", todo);
        LOG.debug("消费者响应 : {}  消息处理完成",topicExchange);
    }

}
