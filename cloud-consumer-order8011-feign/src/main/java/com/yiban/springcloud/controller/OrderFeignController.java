package com.yiban.springcloud.controller;

import com.yiban.springcloud.entities.CommonResult;
import com.yiban.springcloud.entities.Payment;
import com.yiban.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud.controller
 * @className OrderFeignController
 * @date 2025/12/17
 * @description
 */
@RestController
@Slf4j
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> paymentFeign(@PathVariable("id") Long id) {
        return paymentFeignService.selectOne(id);
    }

    @GetMapping("/consumer/payment/feign/timeout")
    public String feignTimeOut() {
        return paymentFeignService.getFeignTimeOut();
    }
}
