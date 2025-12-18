package com.yiban.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud.service
 * @interfaceName PaymentFeignHystrixService
 * @date 2025/12/18
 * @description
 */
@Service
@FeignClient(value = "CLOUD-PROVIDER-PAYMENT-HYSTRIX",fallback = PaymentFallBackService.class)
public interface PaymentFeignHystrixService {
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_timeout(@PathVariable("id") Integer id);
}
