package com.yiban.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud
 * @className OrderMain8009
 * @date 2025/7/2
 * @description
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderMain8009 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain8009.class, args);
    }

}
