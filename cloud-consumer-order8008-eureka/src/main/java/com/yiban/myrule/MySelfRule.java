package com.yiban.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author david.duan
 * @packageName com.yiban.myrule
 * @className MySelfRule
 * @date 2025/12/17
 * @description
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule() {
        //默认是轮询，这个改为随机
        return new RandomRule();
    }
}
