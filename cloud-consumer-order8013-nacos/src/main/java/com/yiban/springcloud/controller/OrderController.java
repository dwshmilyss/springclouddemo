package com.yiban.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud.controller
 * @className OrderController
 * @date 2025/12/30
 * @description
 */
@RestController
public class OrderController {
    @Resource
    private RestTemplate restTemplate;

    @Value("${server-url.nacos-server-url}")
    private String serverURL;

    @GetMapping("/consumer/payment/nacos/{id}")
    public String payment(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(serverURL + "/payment/nacos/" + id, String.class);
    }
}
