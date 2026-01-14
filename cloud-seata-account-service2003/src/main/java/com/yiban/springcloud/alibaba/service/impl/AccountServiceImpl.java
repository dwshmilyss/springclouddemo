package com.yiban.springcloud.alibaba.service.impl;

import com.yiban.springcloud.alibaba.dao.AccountDao;
import com.yiban.springcloud.alibaba.domain.Account;
import com.yiban.springcloud.alibaba.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud.alibaba.service.impl
 * @className AccountServiceImpl
 * @date 2026/1/14
 * @description
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        //TODO 模拟调用出错，因为Feign默认的调用时间是1秒，这里设置超时时间为20秒肯定会报错
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        accountDao.decrease(userId, money);
    }

    @Override
    public void create(Account account) {
        accountDao.insert(account);
    }
}
