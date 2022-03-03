package com.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pojo.GmsCatalogAttr;
import com.pojo.GmsSku;
import com.pojo.GmsSpu;
import com.service.SkuService;
import com.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author 肖宏武
 * @date 2020/4/8 - 19:43
 */
@Controller
public class SkuController {
    @Autowired
    @Qualifier("SkuServiceImpl")
    private SkuService skuService;

    //跳转到属性管理页面
    @RequestMapping("/attrAdmin")
    public String findAllSkuBySpuId(String id, Model model){
        List<GmsSku> allSku = skuService.findSkuBySpuId(id);
        String json = JsonUtils.getJson(allSku);
        model.addAttribute("json",json);
        return "goodsAttrs";
    }

    //下架商品
    @RequestMapping("/deleteGoods")
    public String updateState(String spuId,int id,Model model){
        int state = 1;
        skuService.updateState(spuId, id,state);
        int i = skuService.selectSkuCount(spuId);
        int i1 = skuService.selectSkuDeCount(spuId, state);
        if(i == i1){
            skuService.updateSpuState(spuId,state);
        }
        List<GmsSku> allSku = skuService.findSkuBySpuId(spuId);
        String json = JsonUtils.getJson(allSku);
        model.addAttribute("json",json);
        return "goodsAttrs";
    }

    //跳转到修改商品信息页面
    @RequestMapping("/upAttr")
    public String toUpdatePage(String spuId,int id,Model model){
        GmsSku gmsSku = skuService.selectSku(spuId, id);
        System.out.println(gmsSku);
        model.addAttribute("skuPrice",gmsSku.getSkuPrice());
        model.addAttribute("discountPrice",gmsSku.getDiscountPrice());
        model.addAttribute("amount",gmsSku.getAmount());
        model.addAttribute("id",gmsSku.getId());
        model.addAttribute("spuId",gmsSku.getSpuId());
        return "updateAttr";
    }

    //修改商品信息
    @RequestMapping("/updateAttr")
    @ResponseBody
    public String updateAttr(String skuPrice,String discountPrice,String amount,String id,String spuId){
        int i = skuService.updateAttr(skuPrice, discountPrice, amount, id, spuId);
        if(i>0){
            return spuId;
        }else {
            return "false";
        }
    }

    //将商品重新上架
    @RequestMapping("/insertGoods")
    public String insertGoods(String spuId,int id,Model model){
        int state = 0;
        skuService.insertState(spuId, id,state);
        skuService.insertSpuState(spuId,state);
        List<GmsSku> allSku = skuService.findSkuBySpuId(spuId);
        String json = JsonUtils.getJson(allSku);
        model.addAttribute("json",json);
        return "goodsAttrs";
    }

    //跳转到添加商品sku页面
    @RequestMapping("/toAddSku")
    public String toAddSkuPage(String spuId,Model model){
        GmsSpu gmsSpu = skuService.selectCatalogIdBySpu(spuId);
        System.out.println(gmsSpu.getCatalogId());
        List<GmsCatalogAttr> attrs = skuService.findAttrsByCatalogId(gmsSpu.getCatalogId());
        System.out.println(attrs);
        model.addAttribute("attrs",attrs);
        model.addAttribute("goodsName",gmsSpu.getGoodsName());
        model.addAttribute("goodsId",gmsSpu.getId());
        return "addSku";
    }

    //上传商品
    @RequestMapping("/uploadSku")
    @ResponseBody
    public String uploadGoods(String spuId,String attrs, String skuPic, String skuPrice, String discountPrice, String amount) {
        Map skuMap = new HashMap();
        JSONArray skuAttrs = JSON.parseArray(attrs);
        String attrValues = "";
        int i2 = 0;
        for (int i = 0; i < skuAttrs.size(); i++) {
            Map spuAttrMap = new HashMap();
            JSONObject obj = skuAttrs.getJSONObject(i);
            String attrId = obj.getString("attrId");
            String attrValue = obj.getString("attrValue");
            spuAttrMap.put("spuId", spuId);
            spuAttrMap.put("attrId", attrId);
            spuAttrMap.put("attrValue", attrValue);
            attrValues += "+" + attrValue;
            i2 += skuService.insertGoodsSpuAttr(spuAttrMap);
        }
        attrValues = attrValues.substring(1);

        JSONArray skuImgs = JSON.parseArray(skuPic);
        for (int i = 0; i < skuImgs.size(); i++) {
            JSONObject obj = skuImgs.getJSONObject(i);
            String skuImg = obj.getString("img");
            skuMap.put("skuPic", skuImg);
        }

        skuMap.put("spuId", spuId);
        skuMap.put("attrValues", attrValues);
        skuMap.put("skuPrice", skuPrice);
        skuMap.put("discountPrice", discountPrice);
        skuMap.put("amount", amount);
        int i4 = skuService.insertGoodsSku(skuMap);

        if (i2 + i4 < skuAttrs.size() + skuImgs.size()){
            return "error";
        }
        return "success";
    }

}
