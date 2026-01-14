package com.yiban.springcloud.alibaba.controller;

import com.yiban.springcloud.alibaba.domain.Storage;
import com.yiban.springcloud.alibaba.service.StorageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud.alibaba.controller
 * @className StorageController
 * @date 2026/1/14
 * @description
 */
@RestController
public class StorageController {
    @Resource
    private StorageService storageService;

    @RequestMapping("/storage/decrease")
    public void decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count) {
        storageService.decrease(productId, count);
    }

    @RequestMapping("/storage/create")
    public void create(@RequestBody Storage storage) {
        storageService.create(storage);
    }
}
