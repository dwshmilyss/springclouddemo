package com.yiban.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author david.duan
 * @packageName com.yiban.springcloud.alibaba.domain
 * @className Storage
 * @date 2026/1/14
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage implements Serializable {
    private static final long serialVersionUID = -9057624857931731359L;
    private Long id;
    private Long productId;
    private Integer total;
    private Integer used;
    private Integer residue;
}
