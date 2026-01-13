package com.yiban.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud.service
 * @className FeignService
 * @date 2026/1/13
 * @description
 */
@FeignClient(value = "${service-url}", fallback = PaymentFallbackService.class)
public interface FeignService {
    @GetMapping("/payment/nacos/{id}")
    String getPayment(@PathVariable("id") Integer id);
}
