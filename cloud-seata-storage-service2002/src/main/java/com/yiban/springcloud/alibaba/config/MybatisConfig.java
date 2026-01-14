package com.yiban.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud.alibaba.config
 * @className MybatisConfig
 * @date 2026/1/14
 * @description
 */
@Configuration
@MapperScan("com.yiban.springcloud.alibaba.dao")
public class MybatisConfig {

}
