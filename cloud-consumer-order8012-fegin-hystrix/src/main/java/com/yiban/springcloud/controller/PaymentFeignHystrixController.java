package com.yiban.springcloud.controller;

import com.yiban.springcloud.service.PaymentFeignHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud.controller
 * @className PaymentFeignHystrixController
 * @date 2025/12/18
 * @description
 */
@RestController
@Slf4j
public class PaymentFeignHystrixController {
    @Resource
    private PaymentFeignHystrixService paymentFeignHystrixService;
    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        return paymentFeignHystrixService.paymentInfo_OK(id);
    }
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_timeout(@PathVariable("id") Integer id) {
        return paymentFeignHystrixService.paymentInfo_timeout(id);
    }
}
