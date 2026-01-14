package com.yiban.springcloud.alibaba.service;

import com.yiban.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Param;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud.alibaba.service
 * @interfaceName OrderService
 * @date 2026/1/14
 * @description
 */
public interface OrderService {
    void create(Order order);
}
