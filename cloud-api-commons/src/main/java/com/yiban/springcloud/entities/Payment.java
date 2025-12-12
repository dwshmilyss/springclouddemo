package com.yiban.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud.entites
 * @className Payment
 * @date 2025/6/18
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Payment {
    private Long id;
    private String serial;
}
