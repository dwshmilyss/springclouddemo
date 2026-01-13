package com.yiban.springcloud.controller;

import com.yiban.springcloud.service.FeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud.controller
 * @className FeignController
 * @date 2026/1/13
 * @description
 */
@RestController
public class FeignController {
    @Resource
    private FeignService feignService;

    @GetMapping("/feign/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id) {
        return feignService.getPayment(id);
    }
}
