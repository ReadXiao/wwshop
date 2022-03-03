package com.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pojo.*;
import com.service.UserGoodsCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 肖宏武
 * @date 2020/4/30 - 22:56
 */
@Controller
public class UserGoodsCarController {
    @Autowired
    @Qualifier("UserGoodsCarServiceImpl")
    private UserGoodsCarService userGoodsCarService;

    @RequestMapping("/toAddCar")
    @ResponseBody
    public String toAddCar(HttpServletRequest request) {
        HttpSession session = request.getSession();
        UmsUserInfo userInfo = (UmsUserInfo) session.getAttribute("userInfo");
        if (userInfo == null) {
            return "unLogin";
        }
        return "true";
    }

    @RequestMapping("/toAddCarPage")
    public String toAddCarPage(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        UmsUserInfo userInfo = (UmsUserInfo) session.getAttribute("userInfo");
        if (userInfo == null) {
            return "redirect:userLogin.jsp";
        } else {
            int userId = userInfo.getId();
            List<Addcar> allAddCar = userGoodsCarService.findAllAddCarByUserId(userId);
            model.addAttribute("allGoodsCar", allAddCar);
            model.addAttribute("userInfo", userInfo);
            return "UserGoodsCar";
        }
    }

    @RequestMapping("/reduceNum")
    @ResponseBody
    public String reduceNum(String spuId, int skuId, int goodsNum) {
        int i = userGoodsCarService.reduceAddCar(spuId, skuId, goodsNum);
        if (i > 0) {
            return "true";
        } else {
            return "false";
        }
    }

    @RequestMapping("/addNum")
    @ResponseBody
    public String addNum(String spuId, int skuId, int goodsNum) {
        int i = userGoodsCarService.selectGoodsAmount(spuId, skuId);
        if (i < goodsNum) {
            return "all";
        } else {
            int i1 = userGoodsCarService.addAddCar(spuId, skuId, goodsNum);
            if (i1 > 0) {
                return "true";
            } else {
                return "false";
            }
        }
    }

    @RequestMapping("/deleteCar")
    @ResponseBody
    public String deleteAddCar(int addCarId) {
        int i = userGoodsCarService.deleteAddCarById(addCarId);
        if (i > 0) {
            return "true";
        } else {
            return "false";
        }
    }

    //生成订单
    @RequestMapping("/addOrderFromCar")
    @ResponseBody
    public String insertOrder(String orderDetailJson, String orderInfoJson) {
        OmsOrderInfo omsOrderInfo = JSON.parseObject(orderInfoJson, OmsOrderInfo.class);
        List<OmsOrderDetail> omsOrderDetails = JSON.parseArray(orderDetailJson, OmsOrderDetail.class);
        int i1 = userGoodsCarService.insertOrderInfo(omsOrderInfo);
        int i = userGoodsCarService.insertOrderDetail(omsOrderDetails);
        if (i1 > 0 && i > 0) {
            return "true";
        }
        return "false";
    }

    //跳往支付页面
    @RequestMapping("/toPayPage")
    public String toPayPage(String orderId, int userId, Model model) {
        List<OmsOrderDetail> omsOrderDetails = userGoodsCarService.selectOrderDetailByOrderId(orderId);
        List<UmsAddress> umsAddresses = userGoodsCarService.selectAddressByUserId(userId);
        List<UmsCoupon> umsCoupons = userGoodsCarService.selectCouponByUserId(userId);
        float v = userGoodsCarService.selectTotalPrice(orderId);
        model.addAttribute("userId", userId);
        model.addAttribute("orderId", orderId);
        model.addAttribute("addresses", umsAddresses);
        model.addAttribute("orderDetails", omsOrderDetails);
        model.addAttribute("userCoupons", umsCoupons);
        model.addAttribute("totalPrice", v);
        return "userPayPage";
    }

    @RequestMapping("/insertAddress")
    @ResponseBody
    public String insertAddress(int addressId, int userId, String addressValue, String consignee, String telPhone) {
        int i = userGoodsCarService.insertAddress(addressId, userId, addressValue, telPhone, consignee);
        if (i > 0) {
            return "true";
        } else {
            return "false";
        }
    }

    @RequestMapping("/updateAddress")
    @ResponseBody
    public String updateAddress(int addressId, String addressValue, String telPhone, String consignee) {
        int i = userGoodsCarService.updateAddress(addressId, addressValue, telPhone, consignee);
        if (i > 0) {
            return "true";
        } else {
            return "false";
        }
    }

    @RequestMapping("/payOrder")
    @ResponseBody
    public String payOrder(String orderId, int userCouponId) {
        int i = userGoodsCarService.updateOrderInfoState(orderId);
        int i1 = userGoodsCarService.updateOrderDetailState(orderId);
        int i2 = userGoodsCarService.deleteCouponById(userCouponId);
        if (i > 0 && i1 > 0 && i2 > 0) {
            return "true";
        }else {
            return "false";
        }
    }
}
