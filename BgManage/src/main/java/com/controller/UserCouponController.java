package com.controller;

import com.pojo.MmsCoupons;
import com.pojo.UmsCoupon;
import com.pojo.UmsUserInfo;
import com.service.UserCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 肖宏武
 * @date 2020/5/1 - 20:06
 */
@Controller
public class UserCouponController {
    @Autowired
    @Qualifier("UserCouponServiceImpl")
    private UserCouponService userCouponService;

    @RequestMapping("/toMyCoupon")
    @ResponseBody
    public String toMyCoupon(HttpServletRequest request){
        HttpSession session = request.getSession();
        UmsUserInfo userInfo = (UmsUserInfo) session.getAttribute("userInfo");
        if(userInfo==null){
            return "false";
        }else {
            return "true";
        }
    }

    @RequestMapping("/toMyCouponPage")
    public String toGetCouponPage(Model model,HttpServletRequest request) {
        HttpSession session = request.getSession();
        UmsUserInfo userInfo = (UmsUserInfo) session.getAttribute("userInfo");
        int userId = userInfo.getId();
        List<UmsCoupon> validCoupons = userCouponService.selectCouponByUserId(userId);
        model.addAttribute("validCoupon", validCoupons);
        return "UserMyCoupon";
    }

    @RequestMapping("/insertIntoCoupon")
    @ResponseBody
    public String insertIntoCoupon(String minPrice, String discountPrice, Date deadline, int catalogId,int couponsId,HttpServletRequest request){
        HttpSession session = request.getSession();
        UmsUserInfo userInfo = (UmsUserInfo) session.getAttribute("userInfo");
        int userId = userInfo.getId();
        Map map = new HashMap();
        map.put("userId",userId);
        map.put("couponsId",couponsId);
        map.put("minPrice",minPrice);
        map.put("discountPrice",discountPrice);
        map.put("deadline",deadline);
        map.put("catalogId",catalogId);
        List<UmsCoupon> coupons = userCouponService.findUserCouponByCouponsId(couponsId);
        if (coupons.size()>0){
            return "already";
        }else {
            int count = userCouponService.selectCouponNum(couponsId);
            if (count<=0){
                return "none";
            }else{
                int i = userCouponService.insertUserCoupon(map);
                int num = count-1;
                int i1 = userCouponService.updateCouponsNum(num, couponsId);
                if (i>0){
                    return "true";
                }else {
                    return "false";
                }
            }
        }
    }
}
