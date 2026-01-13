package com.yiban.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.yiban.springcloud.common.CustomerBlockHandler;
import com.yiban.springcloud.entities.CommonResult;
import com.yiban.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud.controller
 * @className RateLimitController
 * @date 2026/1/12
 * @description
 */
@RestController
public class RateLimitController {

    /**
     * 按资源名称进行限流测试的方法
     * 该方法模拟了一个支付相关的API调用，返回一个包含支付信息的成功结果
     *
     * @return CommonResult<Payment> 返回一个通用结果对象，包含状态码、消息和支付实体
     */
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult<Payment> byResource() {
        return new CommonResult<>(200, "按资源名称限流测试OK", new Payment(2020L, "serial001"));
    }

    public CommonResult<Payment> handleException(BlockException exception) {
        return new CommonResult<>(444, exception.getClass().getCanonicalName() + "\t 服务不可用");
    }


    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class, //使用通用的限流处理类
            blockHandler = "handlerException2") //使用指定的限流处理方法
    public CommonResult<Payment> customerBlockHandler() {
        return new CommonResult<>(200, "按资源名称限流测试OK", new Payment(2020L, "serial002"));
    }

    private static Map<Long, Payment> paymentMap = new HashMap<>();

    static {
        paymentMap.put(1L, new Payment(1L, "serial001"));
        paymentMap.put(2L, new Payment(2L, "serial002"));
        paymentMap.put(3L, new Payment(3L, "serial003"));
    }

    /**
     * fallback用来
     *
     * @param id
     * @return
     */
    @GetMapping("/fallback/{id}")
    @SentinelResource(value = "fallback",
            fallback = "handlerFallback",
            blockHandler = "handlerBlock")
    public CommonResult<Payment> fallback(@PathVariable Long id) {
        if (id == 4) {
            throw new IllegalArgumentException("没有该id");
        }
        return new CommonResult<>(200, "查询成功", paymentMap.get(id));
    }

    /**
     * 对应上面的fallback方法
     * @param id
     * @param e
     * @return
     */
    public CommonResult<Payment> handlerFallback(Long id, Throwable e) {
        return new CommonResult<>(444, "异常处理信息：" + e.getMessage());
    }

    /**
     * 对应上面的blockHandler方法
     * @param id
     * @param e 这里的参数一定要是BlockException 否则sentinel无法识别
     * @return
     */
    public CommonResult<Payment> handlerBlock(Long id, BlockException e) {
        return new CommonResult<>(445, "触发流控限制");
    }
}
