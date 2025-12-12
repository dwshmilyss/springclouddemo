package com.yiban.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud
 * @className EurekaServer7001
 * @date 2025/6/19
 * @description
 */
@SpringBootApplication
@EnableEurekaServer
@Slf4j
public class EurekaServer7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7002.class, args);
        log.info("EurekaServer7002 启动成功");
    }

}
