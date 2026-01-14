package com.yiban.springcloud.alibaba.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud.alibaba.service
 * @interfaceName StorageService
 * @date 2026/1/14
 * @description 库存相关的微服务逻辑
 */
@FeignClient(value = "cloud-seata-storage-service")
public interface StorageService {
    @PostMapping("/storage/decrease")
    void decrease(@RequestParam(value = "productId") Long productId, @RequestParam(value = "count") Integer count);
}
