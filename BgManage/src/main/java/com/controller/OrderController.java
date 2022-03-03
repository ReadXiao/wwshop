package com.controller;

import com.pojo.OmsOrderDetail;
import com.pojo.OmsOrderInfo;
import com.pojo.UmsAddress;
import com.service.OrderService;
import com.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 肖宏武
 * @date 2020/4/19 - 18:24
 */
@Controller
public class OrderController {
    @Autowired
    @Qualifier("OrderServiceImpl")
    private OrderService orderService;

    @RequestMapping("/toOrderAdmin")
    public String toOrderInfoPage(Model model) {
        int state = 0;
        List<OmsOrderInfo> omsOrderInfos = orderService.selectOrdersByState(state);
        model.addAttribute("orderInfos", JsonUtils.getJson(omsOrderInfos));
        return "orderInfo";
    }

    @RequestMapping("/toOrderInfoDetail")
    public String toOrderInfoDetail(String orderId, int state, int addressId, Model model) {
        List<OmsOrderDetail> omsOrderDetails = orderService.selectOrderDetailsById(orderId);
        UmsAddress umsAddress = orderService.selectAddressById(addressId);
        model.addAttribute("orderDetails", omsOrderDetails);
        model.addAttribute("umsAddress", umsAddress);
        model.addAttribute("state", state);
        model.addAttribute("orderId", orderId);
        return "orderInfoDetail";
    }

    @RequestMapping("/findUnPayOrder")
    @ResponseBody
    public String findUnPayOrder(int state) {
        List<OmsOrderInfo> omsOrderInfos = orderService.selectOrdersByState(state);
        return JsonUtils.getJson(omsOrderInfos);
    }

    @RequestMapping("/findUnSendOrder")
    @ResponseBody
    public String findUnSendOrder(int state) {
        List<OmsOrderInfo> omsOrderInfos = orderService.selectOrdersByState(state);
        return JsonUtils.getJson(omsOrderInfos);
    }

    @RequestMapping("/findUnReceiveOrder")
    @ResponseBody
    public String findUnReceiveOrder(int state) {
        List<OmsOrderInfo> omsOrderInfos = orderService.selectOrdersByState(state);
        return JsonUtils.getJson(omsOrderInfos);
    }

    @RequestMapping("/findAlreadyOrder")
    @ResponseBody
    public String findAlreadyOrder(int state) {
        List<OmsOrderInfo> omsOrderInfos = orderService.selectOrdersByState(state);
        return JsonUtils.getJson(omsOrderInfos);
    }

    @RequestMapping("/findOrderByUserName")
    @ResponseBody
    public String findOrderByUserName(String username, int state) {
        List<OmsOrderInfo> orderByUserName = orderService.findOrderByUserName(username, state);
        return JsonUtils.getJson(orderByUserName);
    }

    @RequestMapping("/sendOrder")
    @ResponseBody
    public String sendOrder(String orderId) {
        int i = orderService.sendOrder(orderId);
        if (i > 0) {
            int i1 = orderService.updateOrderDetailsState(orderId);
            if(i1>0){
                return "true";
            }
            return "false";
        }
        return "false";
    }
}
