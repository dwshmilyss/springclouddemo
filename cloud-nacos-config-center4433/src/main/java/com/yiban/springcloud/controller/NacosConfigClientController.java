package com.yiban.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud.controller
 * @className NacosConfigClientController
 * @date 2026/1/4
 * @description
 */
@RestController
@RefreshScope
public class NacosConfigClientController {
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/info")
    public String getConfigInfo() {
        return configInfo;
    }
}
