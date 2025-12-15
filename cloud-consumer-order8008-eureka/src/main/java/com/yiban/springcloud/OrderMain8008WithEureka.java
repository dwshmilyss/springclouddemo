package com.yiban.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud
 * @className OrderMain8008
 * @date 2025/6/19
 * @description
 */
@SpringBootApplication
@Slf4j
@EnableEurekaClient
public class OrderMain8008WithEureka {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain8008WithEureka.class, args);
        log.info("OrderMain8008 启动成功");
    }
}
