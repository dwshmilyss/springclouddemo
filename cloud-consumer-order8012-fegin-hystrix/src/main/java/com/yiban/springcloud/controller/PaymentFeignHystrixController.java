package com.yiban.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
    @HystrixCommand(fallbackMethod = "paymentInfo_timeoutHandler",commandProperties = {
            //设置访问服务端1.5秒钟的超时时间(服务端API的执行时间看cloud-provider-payment8005-hystrix中的方法)，即超时了就调用paymentInfo_timeoutHandler方法
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })
    public String paymentInfo_timeout(@PathVariable("id") Integer id) {
        return paymentFeignHystrixService.paymentInfo_timeout(id);
    }

    public String paymentInfo_timeoutHandler(Integer id) {
        return "线程池: "+ Thread.currentThread().getName()+",系统繁忙，请稍后再试, id : " + id +"，消费端兜底方法" ;
    }
}
