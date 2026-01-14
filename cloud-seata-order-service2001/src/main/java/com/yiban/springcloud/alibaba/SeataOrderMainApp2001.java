package com.yiban.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud.alibaba
 * @className SeataOrderMainApp2001
 * @date 2026/1/14
 * @description
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}) //取消数据源的自动创建
@EnableFeignClients
@EnableDiscoveryClient
public class SeataOrderMainApp2001 {
    public static void main(String[] args) {
        SpringApplication.run(SeataOrderMainApp2001.class, args);
    }

}
