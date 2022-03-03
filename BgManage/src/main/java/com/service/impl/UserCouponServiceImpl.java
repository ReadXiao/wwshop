package com.service.impl;

import com.mapper.UserCouponMapper;
import com.pojo.MmsCoupons;
import com.pojo.UmsCoupon;
import com.service.UserCouponService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 肖宏武
 * @date 2020/5/1 - 19:39
 */
public class UserCouponServiceImpl implements UserCouponService {
    private UserCouponMapper userCouponMapper;

    public void setUserCouponMapper(UserCouponMapper userCouponMapper) {
        this.userCouponMapper = userCouponMapper;
    }

    @Override
    public List<UmsCoupon> selectCouponByUserId(@Param("userId") int userId) {
        return userCouponMapper.selectCouponByUserId(userId);
    }

    @Override
    public int insertUserCoupon(Map map) {
        return userCouponMapper.insertUserCoupon(map);
    }

    @Override
    public int updateCouponsNum(@Param("num") int num, @Param("id") int id) {
        return userCouponMapper.updateCouponsNum(num,id);
    }

    @Override
    public List<UmsCoupon> findUserCouponByCouponsId(@Param("couponsId") int couponsId) {
        return userCouponMapper.findUserCouponByCouponsId(couponsId);
    }

    @Override
    public int selectCouponNum(@Param("couponsId") int couponsId) {
        return userCouponMapper.selectCouponNum(couponsId);
    }
}
