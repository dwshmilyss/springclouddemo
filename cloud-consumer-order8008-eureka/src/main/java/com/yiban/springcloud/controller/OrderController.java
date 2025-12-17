package com.yiban.springcloud.controller;

import com.yiban.springcloud.entities.CommonResult;
import com.yiban.springcloud.entities.Payment;
import com.yiban.springcloud.loadbalance.IMyLoadBalance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud.controller
 * @className OrderController
 * @date 2025/6/19
 * @description
 */
@RestController
@Slf4j
public class OrderController {
//    public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Resource
    RestTemplate restTemplate;

    //自己手写的负载均衡实现
    @Resource
    IMyLoadBalance myLoadBalance;

    @Resource
    DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id) {
        //getForObject：返回对象为响应体中数据转化的对象，一般都是JSON格式
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get2/{id}")
    public CommonResult<Payment> get2(@PathVariable("id") Long id) {
        //getForEntity：返回对象是ResponseEntity对象，包含响应中的一些重要信息，比如：响应头、状态码、响应体等
        ResponseEntity<CommonResult> responseEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            log.info(responseEntity.getStatusCode() + "\t" + responseEntity.getHeaders());
            return responseEntity.getBody();
        } else {
            return new CommonResult<>(444, "操作失败");
        }
    }

    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB() {
        //获取服务列表
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0) {
            return null;
        }
        //通过自定义的负载均衡策略选择一个实例
        ServiceInstance serviceInstance = myLoadBalance.getServiceInstance(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri + "/payment/lb", String.class);
    }
}
