package com.yiban.springcloud.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Service;

/**
 * @author david.duan
 * @packageName service
 * @className CommonService
 * @date 2026/1/7
 * @description
 */
@Service
public class CommonService {
    // 使用注解定义资源，这是链路流控的核心
    @SentinelResource(value = "commonResource", blockHandler = "handleBlock")
    public String commonService() {
        return "Common Service Processed";
    }

    public String handleBlock(BlockException ex) {
        return "Common Service Blocked by Link Rule!";
    }
}
