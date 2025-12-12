package com.yiban.springcloud.com.yiban.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud.com.yiban.springcloud.controller
 * @className PaymentController
 * @date 2025/7/2
 * @description
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/payment/zk")
    public String paymentzk() {
        return "springcloud with zookeeper : " + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
