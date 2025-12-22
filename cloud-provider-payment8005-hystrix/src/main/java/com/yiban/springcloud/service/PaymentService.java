package com.yiban.springcloud.service;

import cn.hutool.core.util.IdUtil;
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
     * 全局fallback方法，配合注解 @DefaultProperties(defaultFallback = "paymentInfo_global_fallback") 一起使用
     * @return
     */
    public String paymentInfo_global_fallback() {
        return "系统繁忙，请稍后再试，全局兜底方法" ;
    }

    //============上面是服务降级，下面开始服务熔断=================
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),//失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("*****id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + serialNumber;
    }

    /**
     * 即使是熔断，也需要有一个兜底的方法
     */
    public String paymentCircuitBreaker_fallback(Integer id) {
        return "id 不能为负数，请稍后再试，id: " + id;
    }
}
