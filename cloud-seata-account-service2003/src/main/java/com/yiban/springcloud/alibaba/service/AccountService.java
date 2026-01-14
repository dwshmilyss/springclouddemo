package com.yiban.springcloud.alibaba.service;

import com.yiban.springcloud.alibaba.domain.Account;

import java.math.BigDecimal;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud.alibaba.service
 * @interfaceName AccountService
 * @date 2026/1/14
 * @description
 */
public interface AccountService {
    void decrease(Long userId, BigDecimal money);

    void create(Account account);
}
