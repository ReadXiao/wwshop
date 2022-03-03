package com.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pojo.GmsCatalog;
import com.pojo.GmsCatalogAttr;
import com.pojo.GmsSpu;
import com.pojo.UmsComment;
import com.service.GoodsAdminService;
import com.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author 肖宏武
 * @date 2020/3/29 - 13:48
 */
@Controller
public class GoodsAdminController {
    @Autowired
    @Qualifier("GoodsAdminServiceImpl")
    private GoodsAdminService goodsAdminService;

    //查询所有商品
    @RequestMapping("/getAllGoods")
    @ResponseBody
    public String getAllGoods() {
        List<GmsSpu> allGoods = goodsAdminService.findAllGoods();
        return JsonUtils.getJson(allGoods);
    }

    //跳转到添加商品页面
    @RequestMapping("/toAddGoods")
    public String toAddGoods(Model model) {
        List<GmsCatalog> allCatalog = goodsAdminService.findAllCatalog();
        model.addAttribute("allCatalog", JsonUtils.getJson(allCatalog));
        return "addGoods";
    }

    //跳转到商品管理页面
    @RequestMapping("/toGoodsAdmin")
    public String toGoodsAdmin() {
        List<GmsSpu> allGoods = goodsAdminService.findAllGoods();
        return "goodsAdmin";
    }

    //通过商品名查询商品
    @RequestMapping("/queryGoodsByName")
    @ResponseBody
    public String findGoodsByName(String goodsName, int state) {
        Map map = new HashMap();
        map.put("goodsName", goodsName);
        map.put("state", state);
        List<GmsSpu> goodsList = goodsAdminService.findGoodsByName(map);
        return JsonUtils.getJson(goodsList);
    }

    //联动类别属性
    @RequestMapping("/findAttrs")
    @ResponseBody
    public String findCatalogAttrById(int id) {
        List<GmsCatalogAttr> attrs = goodsAdminService.findAttrsByCatalogId(id);
        return JsonUtils.getJson(attrs);
    }

    //上传商品图片,没有实现回滚，如果在上传图片中途出现上传异常，前面上传的照片仍会存入服务器
    @RequestMapping("/uploadPic")
    @ResponseBody
    public String update2(@RequestParam(value = "file", required = false) MultipartFile[] file, HttpServletRequest request) throws IOException {

        List imgs = new ArrayList();
        for (MultipartFile multipartFile : file) {
            Map<String, String> modelMap = new HashMap<String, String>();
            if (!multipartFile.isEmpty()) {
                String path = "D:\\ideaWorkplace\\wwshop\\BgManage\\web\\img";// 文件的上传路径
                // 获取文件
                String fileName = multipartFile.getOriginalFilename();
                // 获得文件后缀名称
                String suffixName = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
                // 规范时间格式
                SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
                String fileNamenew = new Random().nextInt(9000) + sf.format(new Date());
                // 生成最新的文件名称
                String newFileName = fileNamenew + "." + suffixName;

                try {
                    // 指定的目录下
                    File dir = new File(path, newFileName);
                    // 如果文件夹不存在，自动创建该文件夹
                    if (!dir.exists()) {
                        dir.mkdirs();
                    }
                    // 将指定文件上传到指定的目录下
                    multipartFile.transferTo(dir);
                } catch (Exception e) {
                    e.printStackTrace();
                    return "false";
                }
                modelMap.put("img", "../../img/" + newFileName);
                imgs.add(modelMap);
            }
        }

        String json = JSON.toJSONString(imgs);
        return json;
    }

    //上传商品
    @RequestMapping("/uploadGoods")
    @ResponseBody
    public String uploadGoods(String catalogId, String goodsName, String spuPic, String spuPrice, String goodsDesc, String detailPics, String attrs, String skuPic, String skuPrice, String discountPrice, String amount) {
        Map spuMap = new HashMap();
        Map skuMap = new HashMap();
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString().replaceAll("-", "");

        JSONArray spuImgs = JSON.parseArray(spuPic);
        for (int i = 0; i < spuImgs.size(); i++) {
            JSONObject obj = spuImgs.getJSONObject(i);
            String spuImg = obj.getString("img");
            spuMap.put("spuPic", spuImg);
        }
        spuMap.put("id", id);
        spuMap.put("catalogId", catalogId);
        spuMap.put("goodsName", goodsName);
        spuMap.put("spuPrice", spuPrice);
        spuMap.put("goodsDesc", goodsDesc);
        int i1 = goodsAdminService.insertGoodsSpu(spuMap);

        JSONArray skuAttrs = JSON.parseArray(attrs);
        String attrValues = "";
        int i2 = 0;
        for (int i = 0; i < skuAttrs.size(); i++) {
            Map spuAttrMap = new HashMap();
            JSONObject obj = skuAttrs.getJSONObject(i);
            String attrId = obj.getString("attrId");
            String attrValue = obj.getString("attrValue");
            spuAttrMap.put("spuId", id);
            spuAttrMap.put("attrId", attrId);
            spuAttrMap.put("attrValue", attrValue);
            attrValues += "+" + attrValue;
            i2 += goodsAdminService.insertGoodsSpuAttr(spuAttrMap);
        }
        attrValues = attrValues.substring(1);

        int i3 = 0;
        JSONArray detailImgs = JSON.parseArray(detailPics);
        for (int i = 0; i < detailImgs.size(); i++) {
            Map detailPicsMap = new HashMap();
            JSONObject obj = detailImgs.getJSONObject(i);
            String picUrl = obj.getString("img");
            detailPicsMap.put("spuId", id);
            detailPicsMap.put("picUrl", picUrl);
            i3 += goodsAdminService.insertGoodsDetailPics(detailPicsMap);
        }

        JSONArray skuImgs = JSON.parseArray(skuPic);
        for (int i = 0; i < skuImgs.size(); i++) {
            JSONObject obj = skuImgs.getJSONObject(i);
            String skuImg = obj.getString("img");
            skuMap.put("skuPic", skuImg);
        }
        skuMap.put("spuId", id);
        skuMap.put("attrValues", attrValues);
        skuMap.put("skuPrice", skuPrice);
        skuMap.put("discountPrice", discountPrice);
        skuMap.put("amount", amount);
        int i4 = goodsAdminService.insertGoodsSku(skuMap);

        if (i1 + i2 + i3 + i4 < spuImgs.size() + skuAttrs.size() + detailImgs.size() + skuImgs.size()) {
            return "error";
        }
        return "success";
    }

    //下架该商品
    @RequestMapping("/deleteSpu")
    public String deleteSpu(String id) {
        int state = 1;
        goodsAdminService.deleteSpuSku(id, state);
        goodsAdminService.deleteSpu(id, state);
        return "goodsAdmin";
    }

    //上架该商品
    @RequestMapping("/insertSpu")
    public String insertSpu(String id) {
        int state = 0;
        goodsAdminService.insertSpuSku(id, state);
        goodsAdminService.insertSpu(id, state);
        return "goodsAdmin";
    }

    //查找销售中的商品
    @RequestMapping("/OnlineGoodsSpu")
    @ResponseBody
    public String OnlineGoodsSpu() {
        int state = 0;
        List<GmsSpu> gmsSpus = goodsAdminService.selectSpuByState(state);
        return JsonUtils.getJson(gmsSpus);
    }

    //查找已下架的商品
    @RequestMapping("/unOnlineGoods")
    @ResponseBody
    public String unOnlineGoods() {
        int state = 1;
        List<GmsSpu> gmsSpus = goodsAdminService.selectSpuByState(state);
        return JsonUtils.getJson(gmsSpus);
    }

    //跳转到评论界面
    @RequestMapping("/toComment")
    public String toCommentPage(String id, Model model) {
        GmsSpu gmsSpu = goodsAdminService.selectSpuById(id);
        model.addAttribute("goodsSpu", gmsSpu);
        List<UmsComment> umsComments = goodsAdminService.selectCommentBySpuId(id);
        model.addAttribute("comments", umsComments);
        return "comment";
    }

    @RequestMapping("/deleteComment")
    @ResponseBody
    public String deleteComment(int id) {
        int i = goodsAdminService.deleteComment(id);
        if (i > 0) {
            return "true";
        }
        return "false";
    }
}
