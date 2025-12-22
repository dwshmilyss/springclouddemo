package com.yiban.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud
 * @className GatewayMain9527
 * @date 2025/12/22
 * @description
 */
@SpringBootApplication
@EnableEurekaClient
@Slf4j
public class GatewayMain9527 {
    public static void main(String[] args) {
        SpringApplication.run(GatewayMain9527.class, args);
    }
}
