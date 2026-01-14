package com.yiban.springcloud.alibaba.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud.alibaba.service
 * @interfaceName AccountService
 * @date 2026/1/14
 * @description 账户金额相关的服务
 */
@FeignClient(value = "cloud-seata-account-service")
public interface AccountService {
    @PostMapping("/account/decrease")
    void decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
