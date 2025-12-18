package com.yiban.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud
 * @className OrderMain8012WithFeignAndHystrix
 * @date 2025/12/18
 * @description
 */
@SpringBootApplication
@EnableFeignClients
public class OrderMain8012WithFeignAndHystrix {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain8012WithFeignAndHystrix.class, args);
    }
}
