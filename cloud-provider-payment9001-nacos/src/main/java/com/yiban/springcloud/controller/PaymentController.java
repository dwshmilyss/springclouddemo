package com.yiban.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud.controller
 * @className PaymentController
 * @date 2025/12/30
 * @description
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
    @GetMapping("/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id) {
        return "nacos registry, serverPort: " + serverPort + "\t id: " + id;
    }
}
