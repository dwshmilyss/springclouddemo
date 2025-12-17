package com.yiban.springcloud.loadbalance;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud.loadbalance
 * @interfaceName IMyLoadBalance
 * @date 2025/12/17
 * @description
 */
public interface IMyLoadBalance {
    ServiceInstance getServiceInstance(List<ServiceInstance> serviceInstanceList);
}
