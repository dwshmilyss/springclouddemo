package com.yiban.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud.service
 * @className PaymentService
 * @date 2025/12/18
 * @description
 */
@Service
public class PaymentService {
    public String paymentInfo_OK(Integer id) {
        return "线程池: "+ Thread.currentThread().getName()+",paymentInfo_OK, id : " + id +"哈哈！！！" ;
    }

    public String paymentInfo_timeout(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int timeNum = 3;
        return "线程池: "+ Thread.currentThread().getName()+",paymentInfo_timeout, id : " + id +"哈哈！！！" + "耗时(秒):" + timeNum;
    }
}
