package com.yiban.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud
 * @className OrderMain8011WithFeign
 * @date 2025/12/17
 * @description
 */
@SpringBootApplication
@EnableFeignClients
public class OrderMain8011WithFeign {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain8011WithFeign.class, args);
    }

}
