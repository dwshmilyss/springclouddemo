package com.yiban.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud.config
 * @className ApplicationContextConfig
 * @date 2025/6/19
 * @description
 */
@Configuration
public class ApplicationContextConfig {
    @Bean("restTemplate")
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
