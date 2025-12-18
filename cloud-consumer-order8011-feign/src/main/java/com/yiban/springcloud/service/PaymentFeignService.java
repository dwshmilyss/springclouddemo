package com.yiban.springcloud.service;

import com.yiban.springcloud.entities.CommonResult;
import com.yiban.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud.service
 * @className PaymentFeignService
 * @date 2025/12/17
 * @description
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    /**
     * 绑定CLOUD-PAYMENT-SERVICE的PaymentController接口
     * @param id
     * @return
     */
    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> selectOne(@PathVariable("id") Long id);

    /**
     * Feign调用的时长默认是1s，这里测试超时报异常
     * 调用的是 CLOUD-PAYMENT-SERVICE 的 /payment/feign/timeout 接口
     * @return
     */
    @GetMapping("/payment/feign/timeout")
    public String getFeignTimeOut();
}
