package com.yiban.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud
 * @className PaymentMain8003
 * @date 2025/7/2
 * @description
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentMain8003 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8003.class, args);
    }

}
