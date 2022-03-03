package com.controller;

import com.pojo.GmsCatalog;
import com.pojo.MmsCoupons;
import com.service.CouponService;
import com.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * @author 肖宏武
 * @date 2020/4/14 - 21:54
 */
@Controller
public class CouponController {
    @Autowired
    @Qualifier("CouponServiceImpl")
    private CouponService couponService;

    //跳转到优惠卷管理页面
    @RequestMapping("/toCouponAdmin")
    public String toCouponPage(Model model) {
        List<MmsCoupons> validCoupons = couponService.findValidCoupons();
        model.addAttribute("validCoupon", validCoupons);
        return "couponsAdmin";
    }

    //领取优惠卷
    @RequestMapping("/toGetCouponPage")
    public String toGetCouponPage(Model model) {
        List<MmsCoupons> validCoupons = couponService.findValidCoupons();
        model.addAttribute("validCoupon", validCoupons);
        return "UserGetCoupon";
    }

    //跳转到添加优惠卷页面
    @RequestMapping("/toAddCouponPage")
    public String toAddCouponPage(Model model) {
        List<GmsCatalog> gmsCatalogs = couponService.selectCatalog();
        model.addAttribute("catalogs", gmsCatalogs);
        LocalDate localDate = LocalDate.now();
        model.addAttribute("localDate", localDate);
        return "addCoupon";
    }

    //获取有效卷
    @RequestMapping("/getValidCoupon")
    @ResponseBody
    public String getValidCoupon() {
        List<MmsCoupons> validCoupons = couponService.findValidCoupons();
        return JsonUtils.getJson(validCoupons);
    }

    //获取无有效卷
    @RequestMapping("/getUnValidCoupon")
    @ResponseBody
    public String getUnValidCoupon() {
        List<MmsCoupons> unValidCoupons = couponService.findUnValidCoupons();
        return JsonUtils.getJson(unValidCoupons);
    }

    //删除优惠卷
    @RequestMapping("/cancelCoupon")
    @ResponseBody
    public String cancelCoupon(int id, int state) {
        int i = couponService.deleteCoupon(id);
        if (i > 0) {
            if (state == 1) {
                List<MmsCoupons> validCoupons = couponService.findValidCoupons();
                return JsonUtils.getJson(validCoupons);
            }
            List<MmsCoupons> unValidCoupons = couponService.findUnValidCoupons();
            return JsonUtils.getJson(unValidCoupons);
        }
        return "false";
    }

    //发布优惠卷
    @RequestMapping("/insertCoupon")
    @ResponseBody
    public String insertCoupon(BigDecimal minPrice, BigDecimal discountPrice, String deadline, int count, int catalogId) {
        int i = couponService.insertCoupon(minPrice, discountPrice, deadline, count, catalogId);
        if (i > 0) {
            return "true";
        }
        return "false";
    }
}
