package com.yiban.springcloud.alibaba.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * t_order
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {
    private Long id;

    private Long userId;

    private Long productId;

    private Integer count;

    private BigDecimal money;

    /**
     *  0:创建中 1:已完成
     */
    private Integer status;

    private static final long serialVersionUID = 1L;
}