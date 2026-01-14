package com.yiban.springcloud.alibaba.dao;

import com.yiban.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface OrderDao {
    int deleteByPrimaryKey(Long id);

    /**
     * 创建订单
     * @param record
     * @return
     */
    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    /**
     * 修改订单状态 从0改为1
     */
    void updateOrderStatus(@Param("userId") Long userId, @Param("status") Integer status);
}