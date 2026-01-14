package com.yiban.springcloud.alibaba.controller;

import com.yiban.springcloud.alibaba.domain.Account;
import com.yiban.springcloud.alibaba.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud.alibaba
 * @className AccountController
 * @date 2026/1/14
 * @description
 */
@RestController
@Slf4j
public class AccountController {
    @Resource
    private AccountService accountService;

    @RequestMapping("/account/decrease")
    public void decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money) {
        accountService.decrease(userId, money);
    }

    @RequestMapping("/account/create")
    public void create(@RequestBody Account account) {
        accountService.create(account);
    }
}
