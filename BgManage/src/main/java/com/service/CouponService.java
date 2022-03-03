package com.service;

import com.pojo.GmsCatalog;
import com.pojo.MmsCoupons;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author 肖宏武
 * @date 2020/4/14 - 21:53
 */
public interface CouponService {
    List<MmsCoupons> findValidCoupons();

    List<MmsCoupons> findUnValidCoupons();

    int deleteCoupon(int id);

    List<GmsCatalog> selectCatalog();

    int insertCoupon(@Param("minPrice") BigDecimal minPrice, @Param("discountPrice") BigDecimal discountPrice, @Param("deadline") String deadline, @Param("count") int count, @Param("catalogId") int catalogId);
}
