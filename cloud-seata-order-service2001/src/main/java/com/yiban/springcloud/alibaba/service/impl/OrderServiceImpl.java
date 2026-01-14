package com.yiban.springcloud.alibaba.service.impl;

import com.yiban.springcloud.alibaba.dao.OrderDao;
import com.yiban.springcloud.alibaba.domain.Order;
import com.yiban.springcloud.alibaba.service.AccountService;
import com.yiban.springcloud.alibaba.service.OrderService;
import com.yiban.springcloud.alibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud.alibaba.service
 * @className OrderServiceImpl
 * @date 2026/1/14
 * @description
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;

    @Override
    @GlobalTransactional(name = "seata-create-order", rollbackFor = Exception.class)
    public void create(Order order) {
        //1. 创建订单
        log.info("创建订单,start -----");
        orderDao.insert(order);


        //2. 扣减库存
        log.info("扣减库存,start -----");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("扣减库存,end -----");

        //3. 扣减账户余额
        log.info("扣减账户余额,start -----");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("扣减账户余额,end -----");

        //4. 修改订单状态
        log.info("修改订单状态,start -----");
        orderDao.updateOrderStatus(order.getUserId(), 0);
        log.info("修改订单状态,end -----");

        log.info("创建订单,end -----");
    }

}
