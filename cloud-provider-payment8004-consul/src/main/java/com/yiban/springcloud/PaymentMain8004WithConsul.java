package com.yiban.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud
 * @className PaymentMain8004
 * @date 2025/7/3
 * @description
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain8004WithConsul {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004WithConsul.class, args);
    }

}
