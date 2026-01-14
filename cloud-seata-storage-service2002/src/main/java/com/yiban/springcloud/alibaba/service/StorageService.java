package com.yiban.springcloud.alibaba.service;

import com.yiban.springcloud.alibaba.domain.Storage;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud.alibaba.service
 * @interfaceName StorageService
 * @date 2026/1/14
 * @description
 */
public interface StorageService {
    void decrease(Long productId, Integer count);

    void create(Storage storage);
}
