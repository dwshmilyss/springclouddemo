package com.yiban.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud
 * @className CloudHystrixMonitor9001
 * @date 2025/12/22
 * @description hystrix监控
 * 监控地址：http://localhost:9001/hystrix
 * 被监控的地址(cloud-provider-payment8005-hystrix)：http://localhost:8005/hystrix.stream
 * 测试的时候：
 * http://localhost:8005/payment/hystrix/circuit/31  先快访问这个正确的请求地址N次，这时候通过监控页面可以看到熔断器closed
 * http://localhost:8005/payment/hystrix/circuit/-31  再访问这个错误的请求地址N次，这时候通过监控页面可以看到熔断器open
 * 最后再访问正确的请求，可以看看若干次后熔断器会自动关闭
 */
@SpringBootApplication
@EnableHystrixDashboard
public class CloudHystrixMonitor9001 {
    public static void main(String[] args) {
        SpringApplication.run(CloudHystrixMonitor9001.class, args);
    }
}
