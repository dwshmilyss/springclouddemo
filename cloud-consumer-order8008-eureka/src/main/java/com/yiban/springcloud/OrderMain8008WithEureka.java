package com.yiban.springcloud;

import com.yiban.myrule.MySelfRule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

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
//这里用我自定义的负载均衡策略，name字段代表要访问的微服务，configuration代表负载均衡策略类
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)
public class OrderMain8008WithEureka {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain8008WithEureka.class, args);
        log.info("OrderMain8008 启动成功");
    }
}
