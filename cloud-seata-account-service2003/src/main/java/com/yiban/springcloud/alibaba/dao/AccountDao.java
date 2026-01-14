package com.yiban.springcloud.alibaba.dao;

import com.yiban.springcloud.alibaba.domain.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud.alibaba.dao
 * @interfaceName AccountDao
 * @date 2026/1/14
 * @description
 */
@Mapper
@Repository
public interface AccountDao {

    void insert(Account account);

    /**
     * 扣减账户余额
     */
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
