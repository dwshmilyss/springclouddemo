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
    public static final String PAYMENT_CONSUL_URL = "http://cloud-provider-payment-consul";
    @Resource
    RestTemplate restTemplate;

    @GetMapping(value = "consumer/payment/consul")
    public String paymentInfo() {
        return restTemplate.getForObject(PAYMENT_CONSUL_URL + "/payment/consul", String.class);
    }
}
