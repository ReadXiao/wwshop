package com.service.impl;

import com.mapper.OrderMapper;
import com.pojo.OmsOrderDetail;
import com.pojo.OmsOrderInfo;
import com.pojo.UmsAddress;
import com.service.OrderService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 肖宏武
 * @date 2020/4/19 - 18:17
 */
public class OrderServiceImpl implements OrderService {
    private OrderMapper orderMapper;

    public void setOrderMapper(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }


    @Override
    public List<OmsOrderInfo> selectOrdersByState(@Param("state") int state) {
        return orderMapper.selectOrdersByState(state);
    }

    @Override
    public int updateOrderState(@Param("id")String id) {
        return orderMapper.updateOrderState(id);
    }

    @Override
    public int updateOrderDetailsState(@Param("orderId") String orderId) {
        return orderMapper.updateOrderDetailsState(orderId);
    }

    @Override
    public List<OmsOrderDetail> selectOrderDetailsById(@Param("orderId") String orderId) {
        return orderMapper.selectOrderDetailsById(orderId);
    }

    @Override
    public UmsAddress selectAddressById(@Param("id") int id) {
        return orderMapper.selectAddressById(id);
    }

    @Override
    public List<OmsOrderInfo> findOrderByUserName(@Param("username") String username, @Param("state") int state) {
        return orderMapper.findOrderByUserName(username,state);
    }

    @Override
    public int sendOrder(String orderId) {
        return orderMapper.sendOrder(orderId);
    }
}
