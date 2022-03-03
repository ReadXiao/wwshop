package com.controller;

import com.pojo.*;
import com.service.UserGoodsDetailService;
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
 * @date 2020/4/26 - 20:09
 */
@Controller
public class UserGoodsDetailController {
    @Autowired
    @Qualifier("UserGoodsDetailServiceImpl")
    private UserGoodsDetailService userGoodsDetailService;

    @RequestMapping("/detailGoods")
    public String toGoodsDetail(String spuId, Model model, HttpServletRequest request){
        GmsSpu spuById = userGoodsDetailService.findSpuById(spuId);
        List<GmsSku> skuBySpuId = userGoodsDetailService.findSkuBySpuId(spuId);
        List<UmsComment> commentBySpuId = userGoodsDetailService.findCommentBySpuId(spuId);
        HttpSession session = request.getSession();
        UmsUserInfo userInfo = (UmsUserInfo) session.getAttribute("userInfo");
        List<GmsDetailPics> detailPics = userGoodsDetailService.findDetailPics(spuId);
        model.addAttribute("goodsSpu",spuById);
        model.addAttribute("goodsSku",skuBySpuId);
        model.addAttribute("goodsComment",commentBySpuId);
        model.addAttribute("userInfo",userInfo);
        model.addAttribute("detailPics",detailPics);
        return "userGoodsDetail";
    }

    //添加购物车
    @RequestMapping("/addCar")
    @ResponseBody
    public String addCar(String spuId,int skuId,int catalogId,String goodsName,String skuPrice,String discountPrice,String goodsAttrs,int goodsNum,HttpServletRequest request) {
        HttpSession session = request.getSession();
        Map map = new HashMap();
        Map idsMap = new HashMap();
        UmsUserInfo userInfo = (UmsUserInfo) session.getAttribute("userInfo");
        if (userInfo != null) {
            int userId = userInfo.getId();
            idsMap.put("spuId", spuId);
            idsMap.put("skuId", skuId);
            Addcar carGoods = userGoodsDetailService.findGoodsBySpuIdAndSkuId(idsMap);
            if (carGoods != null) {
                goodsNum += carGoods.getGoodsAmount();
                int num = userGoodsDetailService.findGoodsNum(spuId, skuId);
                if (goodsNum >= num) {
                    goodsNum = num;
                    idsMap.put("goodsNum", goodsNum);
                    int i = userGoodsDetailService.updateGoodsNum(idsMap);
                    if (i > 0) {
                        return "true";
                    } else {
                        return "false";
                    }
                } else {
                    idsMap.put("goodsNum", goodsNum);
                    int i = userGoodsDetailService.updateGoodsNum(idsMap);
                    if (i > 0) {
                        return "true";
                    } else {
                        return "false";
                    }
                }
            } else {
                map.put("spuId", spuId);
                map.put("skuId", skuId);
                map.put("userId", userId);
                map.put("goodsName", goodsName);
                map.put("skuPrice", skuPrice);
                map.put("discountPrice", discountPrice);
                map.put("goodsAttrs", goodsAttrs);
                map.put("goodsAmount", goodsNum);
                map.put("catalogId",catalogId);
                int i = userGoodsDetailService.insertAddCar(map);
                if (i > 0) {
                    return "true";
                } else {
                    return "false";
                }
            }
        }

            return "none";
        }

    @RequestMapping("/checkNum")
    @ResponseBody
    public String checkSkuNum(String spuId,int skuId,int goodsNum){
        int num = userGoodsDetailService.findGoodsNum(spuId, skuId);
        if (num<=goodsNum){
            return "false";
        }else {
            return "true";
        }

    }

}
