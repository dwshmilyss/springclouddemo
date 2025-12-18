package com.yiban.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud.service
 * @className PaymentFallBackService
 * @date 2025/12/18
 * @description 统一的服务降级方法
 */
@Component
public class PaymentFallBackService implements PaymentFeignHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "----- PaymentFallBackService fallback method called with paymentInfo_OK";
    }

    @Override
    public String paymentInfo_timeout(Integer id) {
        return "----- PaymentFallBackService fallback method called with paymentInfo_timeout";
    }
}
