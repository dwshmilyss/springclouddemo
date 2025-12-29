package com.yiban.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.yiban.springcloud.service.IMessageProducer;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud.service.impl
 * @className MessageProducerImpl
 * @date 2025/12/29
 * @description
 */
@EnableBinding(Source.class)
public class MessageProducerImpl implements IMessageProducer {
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String uuid = IdUtil.simpleUUID();
        output.send(MessageBuilder.withPayload(uuid).build());
        System.out.println("uuid = " + uuid);
        return null;
    }
}
