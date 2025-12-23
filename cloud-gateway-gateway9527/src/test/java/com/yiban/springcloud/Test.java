package com.yiban.springcloud;

import java.time.ZonedDateTime;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud
 * @className Test
 * @date 2025/12/23
 * @description
 */
public class Test {
    @org.junit.Test
    public void test1() {
        //打印当前的时间(带有时区的固定格式，用于predicates中的 before、after、between 3种断言)
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
    }
}
