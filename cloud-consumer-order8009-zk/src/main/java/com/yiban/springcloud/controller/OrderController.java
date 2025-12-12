package com.yiban.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud.controller
 * @className OrderController
 * @date 2025/7/2
 * @description
 */
@RestController
@Slf4j
public class OrderController {
    public static final String PAYMENT_ZK_URL = "http://cloud-provider-payment-zk";
    @Resource
    RestTemplate restTemplate;

    @GetMapping(value = "consumer/payment/zk")
    public String paymentInfo() {
        return restTemplate.getForObject(PAYMENT_ZK_URL + "/payment/zk", String.class);
    }
}
