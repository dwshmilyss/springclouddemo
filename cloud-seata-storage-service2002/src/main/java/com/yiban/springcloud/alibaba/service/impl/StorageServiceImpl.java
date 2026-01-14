package com.yiban.springcloud.alibaba.service.impl;

import com.yiban.springcloud.alibaba.dao.StorageDao;
import com.yiban.springcloud.alibaba.domain.Storage;
import com.yiban.springcloud.alibaba.service.StorageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud.alibaba.service.impl
 * @className StorageServiceImpl
 * @date 2026/1/14
 * @description
 */
@Service
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageDao storageDao;
    @Override
    public void decrease(Long productId, Integer count) {
        storageDao.decrease(productId, count);
    }

    @Override
    public void create(Storage storage) {
        storageDao.insert(storage);
    }
}
