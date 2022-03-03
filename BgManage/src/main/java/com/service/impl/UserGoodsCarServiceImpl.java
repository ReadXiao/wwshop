package com.service.impl;

import com.mapper.UserGoodsCarMapper;
import com.pojo.*;
import com.service.UserGoodsCarService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 肖宏武
 * @date 2020/4/30 - 22:50
 */
public class UserGoodsCarServiceImpl implements UserGoodsCarService {
    private UserGoodsCarMapper userGoodsCarMapper;

    public void setUserGoodsCarMapper(UserGoodsCarMapper userGoodsCarMapper) {
        this.userGoodsCarMapper = userGoodsCarMapper;
    }

    @Override
    public List<Addcar> findAllAddCarByUserId(@Param("userId") int userId) {
        return userGoodsCarMapper.findAllAddCarByUserId(userId);
    }

    @Override
    public int reduceAddCar(@Param("spuId") String spuId, @Param("skuId") int skuId, @Param("goodsAmount") int goodsAmount) {
        return userGoodsCarMapper.reduceAddCar(spuId, skuId, goodsAmount);
    }

    @Override
    public int addAddCar(@Param("spuId") String spuId, @Param("skuId") int skuId, @Param("goodsAmount") int goodsAmount) {
        return userGoodsCarMapper.addAddCar(spuId, skuId, goodsAmount);
    }

    @Override
    public int selectGoodsAmount(@Param("spuId") String spuId, @Param("skuId") int skuId) {
        return userGoodsCarMapper.selectGoodsAmount(spuId, skuId);
    }

    @Override
    public int deleteAddCarById(@Param("id") int id) {
        return userGoodsCarMapper.deleteAddCarById(id);
    }

    @Override
    public int insertOrderInfo(OmsOrderInfo omsOrderInfo) {
        return userGoodsCarMapper.insertOrderInfo(omsOrderInfo);
    }

    @Override
    public int insertOrderDetail(List<OmsOrderDetail> omsOrderDetails) {
        return userGoodsCarMapper.insertOrderDetail(omsOrderDetails);
    }

    @Override
    public List<OmsOrderDetail> selectOrderDetailByOrderId(@Param("orderId") String orderId) {
        return userGoodsCarMapper.selectOrderDetailByOrderId(orderId);
    }

    @Override
    public List<UmsAddress> selectAddressByUserId(@Param("userId") int userId) {
        return userGoodsCarMapper.selectAddressByUserId(userId);
    }

    @Override
    public List<UmsCoupon> selectCouponByUserId(@Param("userId") int userId) {
        return userGoodsCarMapper.selectCouponByUserId(userId);
    }

    @Override
    public int updateAddress(@Param("addressId") int addressId,@Param("addressValue") String addressValue,@Param("telPhone") String telPhone,@Param("consignee") String consignee) {
        return userGoodsCarMapper.updateAddress(addressId, addressValue, telPhone, consignee);
    }

    @Override
    public int insertAddress(@Param("addressId") int addressId,@Param("userId") int userId,@Param("addressValue") String addressValue,@Param("telPhone") String telPhone,@Param("consignee") String consignee) {
        return userGoodsCarMapper.insertAddress(addressId,userId, addressValue, telPhone, consignee);
    }

    @Override
    public float selectTotalPrice(@Param("orderId") String orderId) {
        return userGoodsCarMapper.selectTotalPrice(orderId);
    }

    @Override
    public int updateOrderInfoState(@Param("orderId") String orderId) {
        return userGoodsCarMapper.updateOrderInfoState(orderId);
    }

    @Override
    public int updateOrderDetailState(@Param("orderId") String orderId) {
        return userGoodsCarMapper.updateOrderDetailState(orderId);
    }

    @Override
    public int deleteCouponById(@Param("id") int id) {
        return userGoodsCarMapper.deleteCouponById(id);
    }
}
