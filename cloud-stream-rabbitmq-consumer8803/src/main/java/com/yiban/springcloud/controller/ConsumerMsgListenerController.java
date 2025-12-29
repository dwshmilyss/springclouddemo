package com.yiban.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud.controller
 * @className ConsumerMsgListenerController
 * @date 2025/12/29
 * @description
 */
@Component
@EnableBinding(Sink.class)
public class ConsumerMsgListenerController {
    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void getMsg(Message<String> message) {
        System.out.println("消费者1号，serverPort: " + serverPort + "\t" + "接收到的消息：" + message.getPayload());
    }
}
