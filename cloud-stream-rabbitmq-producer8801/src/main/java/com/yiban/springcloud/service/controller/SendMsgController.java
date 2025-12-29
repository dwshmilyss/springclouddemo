package com.yiban.springcloud.service.controller;

import com.yiban.springcloud.service.IMessageProducer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud.service.controller
 * @className SendMsgController
 * @date 2025/12/29
 * @description
 */
@RestController
public class SendMsgController {
    @Resource
    private IMessageProducer messageProducer;
    @GetMapping("/sendMsg")
    public String sendMsg() {
        return messageProducer.send();
    }
}
