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
 * @className RibbonController
 * @date 2026/1/13
 * @description nacos-discovery-client自带ribbon负载均衡
 */
@RestController
public class RibbonController {
    @Value("#{ '${service-protocol}' + '://' + '${service-url}' }")
    private String serviceURL;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/nacos/{id}")
    public String getServiceURL(@PathVariable Long id) {
        return restTemplate.getForObject(serviceURL + "/payment/nacos/" + id, String.class);
    }
}
