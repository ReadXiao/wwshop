package com.service;

import com.pojo.OmsOrderDetail;
import com.pojo.OmsOrderInfo;
import com.pojo.UmsAddress;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 肖宏武
 * @date 2020/4/19 - 18:16
 */
public interface OrderService {
    List<OmsOrderInfo> selectOrdersByState(@Param("state") int state);

    int updateOrderState(@Param("id") String id);

    int updateOrderDetailsState(@Param("orderId") String orderId);

    List<OmsOrderDetail> selectOrderDetailsById(@Param("orderId") String orderId);

    UmsAddress selectAddressById(@Param("id") int id);

    List<OmsOrderInfo> findOrderByUserName(@Param("username") String username, @Param("state") int state);

    int sendOrder(@Param("orderId") String orderId);
}
