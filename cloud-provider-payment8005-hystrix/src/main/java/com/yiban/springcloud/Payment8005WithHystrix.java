package com.yiban.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud
 * @className Payment8005WithHystrix
 * @date 2025/12/18
 * @description
 */
@SpringBootApplication
@Slf4j
@EnableEurekaClient
public class Payment8005WithHystrix {
    public static void main(String[] args) {
        SpringApplication.run(Payment8005WithHystrix.class, args);
    }

}
