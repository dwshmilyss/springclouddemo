package com.yiban.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
@DefaultProperties(defaultFallback = "paymentInfo_global_fallback")
public class PaymentService {
    public String paymentInfo_OK(Integer id) {
        return "线程池: "+ Thread.currentThread().getName()+",paymentInfo_OK, id : " + id +"哈哈！！！" ;
    }
//指定的fallback方法
//    @HystrixCommand(fallbackMethod = "paymentInfo_timeoutHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "13000") //设置3秒钟的超时时间，即超时了就调用paymentInfo_timeoutHandler方法
//    })
    //使用全局配置的fallback方法
    @HystrixCommand
    public String paymentInfo_timeout(Integer id) {
//        int tmp = 10 / 0;//模拟异常，也会走到兜底的方法 paymentInfo_timeoutHandler
        /*
        上面注解中设置了正常的业务处理时间是3s,但是这个故意设置了5s，超时了，就会调用paymentInfo_timeoutHandler方法
         */
        int timeNum = 5;
        try {
            TimeUnit.SECONDS.sleep(timeNum);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "线程池: "+ Thread.currentThread().getName()+",paymentInfo_timeout, id : " + id +"哈哈！！！" + "耗时(秒):" + timeNum;
    }

    /**
     * 兜底方法
     * @param id
     * @return
     */
    public String paymentInfo_timeoutHandler(Integer id) {
        return "线程池: "+ Thread.currentThread().getName()+",系统繁忙，请稍后再试, id : " + id +"，服务端兜底方法" ;
    }

    /**
     * 全局fallback方法
     * @return
     */
    public String paymentInfo_global_fallback() {
        return "系统繁忙，请稍后再试，全局兜底方法" ;
    }

}
