package com.yiban.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud.config
 * @className FeignConfig
 * @date 2025/12/18
 * @description
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
