package com.yiban.springcloud.alibaba.controller;

import com.yiban.springcloud.alibaba.domain.CommonResult;
import com.yiban.springcloud.alibaba.domain.Order;
import com.yiban.springcloud.alibaba.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud.alibaba.controller
 * @className OrderController
 * @date 2026/1/14
 * @description
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(@RequestBody Order order){
        orderService.create(order);
        return new CommonResult(200, "订单创建成功");
    }
}
