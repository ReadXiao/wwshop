package com.service;

import com.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 肖宏武
 * @date 2020/4/30 - 22:50
 */
public interface UserGoodsCarService {
    List<Addcar> findAllAddCarByUserId(@Param("userId") int userId);

    int reduceAddCar(@Param("spuId") String spuId, @Param("skuId") int skuId, @Param("goodsAmount") int goodsAmount);

    int addAddCar(@Param("spuId") String spuId, @Param("skuId") int skuId, @Param("goodsAmount") int goodsAmount);

    int selectGoodsAmount(@Param("spuId") String spuId, @Param("skuId") int skuId);

    int deleteAddCarById(@Param("id") int id);

    int insertOrderInfo(OmsOrderInfo omsOrderInfo);

    int insertOrderDetail(List<OmsOrderDetail> omsOrderDetails);

    List<OmsOrderDetail> selectOrderDetailByOrderId(@Param("orderId") String orderId);

    List<UmsAddress> selectAddressByUserId(@Param("userId") int userId);

    List<UmsCoupon> selectCouponByUserId(@Param("userId") int userId);

    int updateAddress(@Param("addressId") int addressId,@Param("addressValue") String addressValue,@Param("telPhone") String telPhone,@Param("consignee") String consignee);

    int insertAddress(@Param("addressId") int addressId,@Param("userId") int userId,@Param("addressValue") String addressValue,@Param("telPhone") String telPhone,@Param("consignee") String consignee);

    float selectTotalPrice(@Param("orderId") String orderId);

    int updateOrderInfoState(@Param("orderId") String orderId);

    int updateOrderDetailState(@Param("orderId") String orderId);

    int deleteCouponById(@Param("id") int id);
}
