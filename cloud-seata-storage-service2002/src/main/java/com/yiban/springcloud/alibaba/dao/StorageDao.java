package com.yiban.springcloud.alibaba.dao;

import com.yiban.springcloud.alibaba.domain.Storage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud.alibaba.dao
 * @interfaceName StorageDao
 * @date 2026/1/14
 * @description
 */
@Mapper
@Repository
public interface StorageDao {
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
    void insert(Storage storage);
}
