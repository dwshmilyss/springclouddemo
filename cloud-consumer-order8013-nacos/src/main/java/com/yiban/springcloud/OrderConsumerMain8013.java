package com.yiban.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud
 * @className OrderConsumerMain8013
 * @date 2025/12/30
 * @description
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsumerMain8013 {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsumerMain8013.class, args);
    }

}
