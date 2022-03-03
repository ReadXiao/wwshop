package com.service.impl;

import com.mapper.CouponMapper;
import com.pojo.GmsCatalog;
import com.pojo.MmsCoupons;
import com.service.CouponService;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author 肖宏武
 * @date 2020/4/14 - 21:52
 */
public class CouponServiceImpl implements CouponService {
    private CouponMapper couponMapper;

    public void setCouponMapper(CouponMapper couponMapper) {
        this.couponMapper = couponMapper;
    }

    public List<MmsCoupons> findValidCoupons() {
        return couponMapper.findValidCoupons();
    }

    public List<MmsCoupons> findUnValidCoupons() {
        return couponMapper.findUnValidCoupons();
    }

    public int deleteCoupon(int id) {
        return couponMapper.deleteCoupon(id);
    }

    public List<GmsCatalog> selectCatalog() {
        return couponMapper.selectCatalog();
    }
    public int insertCoupon(@Param("minPrice") BigDecimal minPrice, @Param("discountPrice") BigDecimal discountPrice, @Param("deadline") String deadline, @Param("count") int count, @Param("catalogId") int catalogId){
        return couponMapper.insertCoupon(minPrice,discountPrice,deadline,count,catalogId);
    }
}
