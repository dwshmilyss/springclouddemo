package com.yiban.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud.service
 * @className PaymentFallbackService
 * @date 2026/1/13
 * @description
 */
@Component
public class PaymentFallbackService implements FeignService{

    @Override
    public String getPayment(Integer id) {
        return "服务器忙，请稍后再试！！！";
    }
}
