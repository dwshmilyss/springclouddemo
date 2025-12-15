package com.yiban.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud
 * @className CloudProviderPayment8001Application
 * @date 2025/6/18
 * @description
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class Payment8001WithEureka {
    public static void main(String[] args) {
        SpringApplication.run(Payment8001WithEureka.class, args);
        System.out.println("启动成功");
    }
}
