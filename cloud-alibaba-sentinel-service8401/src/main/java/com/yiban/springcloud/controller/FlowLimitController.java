package com.yiban.springcloud.controller;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yiban.springcloud.service.CommonService;

import static java.lang.Thread.currentThread;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud.controller
 * @className FlowLimitController
 * @date 2026/1/6
 * @description
 */
@RestController
@Slf4j
public class FlowLimitController {

    @Autowired
    private CommonService commonService;

    @GetMapping("/testa")
//    @SentinelResource(value = "testa", blockHandler = "handleBlock")
    public String testA() {
        //用于测试流控规则中的线程模式
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        return "Entrance A -> " + commonService.commonService();
    }

    @GetMapping("/testb")
    public String testB() {
        log.info(currentThread().getName() + "\t" + "------testb");
        return "Entrance B -> " + commonService.commonService();
    }

    // 限流后的处理方法
    public String handleBlock(BlockException ex) {
        return "触发流控：当前资源执行线程已满！";
    }
}
