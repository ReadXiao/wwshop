package com.mapper;

import com.pojo.MmsCoupons;
import com.pojo.UmsCoupon;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 肖宏武
 * @date 2020/5/1 - 19:38
 */
public interface UserCouponMapper {
    List<UmsCoupon> selectCouponByUserId(@Param("userId") int userId);

    int insertUserCoupon(Map map);

    int updateCouponsNum(@Param("num") int num, @Param("id") int id);

    List<UmsCoupon> findUserCouponByCouponsId(@Param("couponsId") int couponsId);

    int selectCouponNum(@Param("couponsId") int couponsId);
}
