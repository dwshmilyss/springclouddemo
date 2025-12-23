package com.yiban.springcloud.filter;

import cn.hutool.core.util.StrUtil;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud.filter
 * @className MyGlobalFilter
 * @date 2025/12/23
 * @description 自定义的全局的过滤器，逻辑很简单，就是判断一下url中是否有uname,如果有则通过(http://localhost:9527/payment/lb?uname=aaa)，没有则拦截
 * 一般不用Gateway官方提供的过滤器，因为逻辑比较单一，都是自己写自己的逻辑，比如：增加日期，鉴权等
 */
@Component
public class MyGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        //如果请求中没有uname参数
        if (StrUtil.isEmpty(uname)) {
            System.out.println("URL中没有找到uname参数，请求被拦截。");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        //正常的请求就放行
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
