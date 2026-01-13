package com.yiban.springcloud.common;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.yiban.springcloud.entities.CommonResult;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud.common
 * @className CustomerBlockHandler
 * @date 2026/1/12
 * @description 通用的限流兜底类
 */
public class CustomerBlockHandler {
    public static CommonResult handlerException1(BlockException exception) {
        return new CommonResult(444, "自定义限流处理信息......CustomerBlockHandler------1");
    }

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(444, "自定义限流处理信息......CustomerBlockHandler------2");
    }
}
