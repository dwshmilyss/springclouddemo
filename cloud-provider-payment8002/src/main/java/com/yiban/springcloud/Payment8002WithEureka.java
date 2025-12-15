package com.yiban.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud
 * @className CloudProviderPayment8002
 * @date 2025/6/20
 * @description
 */
@SpringBootApplication
@EnableEurekaClient
@Slf4j
public class Payment8002WithEureka {
    public static void main(String[] args) {
        SpringApplication.run(Payment8002WithEureka.class, args);
        log.info("CloudProviderPayment8002 启动成功");
    }

}
