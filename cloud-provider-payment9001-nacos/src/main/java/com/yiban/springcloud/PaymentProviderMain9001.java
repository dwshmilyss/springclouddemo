package com.yiban.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud
 * @className PaymentProviderMain9001
 * @date 2025/12/30
 * @description
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentProviderMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentProviderMain9001.class, args);
    }

}
