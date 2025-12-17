package com.yiban.springcloud.loadbalance;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud.loadbalance
 * @className MyLoadBalanceImpl
 * @date 2025/12/17
 * @description
 */
@Component
@Slf4j
public class MyLoadBalanceImpl implements IMyLoadBalance{
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private final int getAndIncrement(List<ServiceInstance> serviceInstanceList) {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = (current + 1) % serviceInstanceList.size();
        } while (!this.atomicInteger.compareAndSet(current, next));
        log.info("第几次访问，次数：{}，welecome，Port：{}" ,next,serviceInstanceList.get(next).getPort());
        return next;
    }

    @Override
    public ServiceInstance getServiceInstance(List<ServiceInstance> serviceInstanceList) {
        int index = getAndIncrement(serviceInstanceList);
        return serviceInstanceList.get(index);
    }
}
