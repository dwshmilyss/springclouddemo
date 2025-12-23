package com.yiban.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud.config
 * @className GatewayConfig
 * @date 2025/12/22
 * @description 以代码的方式实现路由转发，但是貌似现在baidu不行了
 */
@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        //这个不行，写法没错，但是百度已经没有对应的地址了
//        return builder.routes()
//                .route("path_route_atguigu", r -> r.path("/guonei")
//                        .uri("https://news.baidu.com/guonei"))
//                .route("path_route_atguigu2", r -> r.path("/guoji")
//                        .uri("https://news.baidu.com/guoji"))
//                .build();
        //这个也不行，可能跟代理有关
//        return builder.routes()
//                // spring-cloud
//                .route("spring_cloud_route", r -> r
//                        .path("/cloud/**")
//                        .filters(f -> f.rewritePath("/cloud(?<segment>/?.*)", "/projects/spring-cloud${segment}"))
//                        .uri("https://spring.io")
//                )
//                // spring-boot
//                .route("spring_boot_route", r -> r
//                        .path("/boot/**")
//                        .filters(f -> f.rewritePath("/boot(?<segment>/?.*)", "/projects/spring-boot${segment}"))
//                        .uri("https://spring.io")
//                )
//                .build();


        return builder.routes()
                .route("example_route", r -> r
                        .path("/example/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("https://www.example.com")
                )
                .build();
    }
}
