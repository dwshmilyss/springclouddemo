package com.yiban.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.yiban.springcloud.service.CommonService;

import java.util.concurrent.TimeUnit;

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

    /**
     * 测试流控规则
     * @return
     */
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

    /**
     * 测试流控规则
     * @return
     */
    @GetMapping("/testb")
    public String testB() {
        log.info(currentThread().getName() + "\t" + "------testb");
        return "Entrance B -> " + commonService.commonService();
    }

    // 限流后的处理方法
    public String handleBlock(BlockException ex) {
        return "触发流控：当前资源执行线程已满！";
    }

    /**
     * 测试降级规则 RT(平均响应时间)
     * @return
     */
    @GetMapping("/testc")
    public String testC() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "------- testC";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "handleHotKey") //这里一定要加上blockHandler，不然被限流的时候就会弹出错误页面，对用户不友好
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        return "------testHotKey";

    }

    // 限流后的处理方法
    public String handleHotKey(String p1, String p2,BlockException ex) {
        return "触发流控：热点key已经超载！p1 = " + p1 + "\t p2 = " + p2;
    }
}
