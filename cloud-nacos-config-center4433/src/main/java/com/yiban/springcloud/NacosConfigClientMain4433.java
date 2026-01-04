package com.yiban.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud
 * @className NacosConfigClientMain4433
 * @date 2026/1/4
 * @description
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfigClientMain4433 {
    public static void main(String[] args) {
        SpringApplication.run(NacosConfigClientMain4433.class, args);
    }

}
