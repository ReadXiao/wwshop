package com.controller;

import com.pojo.GmsCatalog;
import com.pojo.GmsSpu;
import com.service.UserGoodsListService;
import com.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sound.midi.Soundbank;
import java.util.List;

/**
 * @author 肖宏武
 * @date 2020/4/24 - 22:52
 */
@Controller
public class UserGoodsListController {
    @Autowired
    @Qualifier("UserGoodsListServiceImpl")
    private UserGoodsListService userGoodsListService;


    @RequestMapping("/findGoodsByCatalogId")
    public String toUserGoodsList(int catalogId, int page, Model model) {
        List<GmsSpu> goodsByCatalogId = userGoodsListService.findGoodsByCatalogId(catalogId, page);
        GmsCatalog catalogById = userGoodsListService.findCatalogById(catalogId);
        model.addAttribute("allSpuGoods", goodsByCatalogId);
        model.addAttribute("getCatalog", catalogById);
        model.addAttribute("type", "catalogId");
        return "userGoodsList";
    }

    @RequestMapping("/findGoodsByName")
    public String findGoodsByName(String goodsName, int page, Model model) {
        goodsName = goodsName.trim();
        List<GmsSpu> goodsByName = userGoodsListService.findGoodsByName(goodsName, page);
        model.addAttribute("allSpuGoods", goodsByName);
        System.out.println(goodsByName);
        System.out.println(goodsName);
        GmsCatalog catalog = new GmsCatalog(0, goodsName, "null");
        model.addAttribute("getCatalog", catalog);
        model.addAttribute("type", "goodsName");
        return "userGoodsList";
    }

    @RequestMapping("/getMoreGoodsByCatalogId")
    @ResponseBody
    public String getMoreGoodsByCatalogId(int catalogId, int page) {
        page = page * 30;
        List<GmsSpu> goodsByCatalogId = userGoodsListService.findGoodsByCatalogId(catalogId, page);
        if (goodsByCatalogId.size() > 0) {
            return JsonUtils.getJson(goodsByCatalogId);
        } else {
            return "null";
        }
    }

    @RequestMapping("/getMoreGoodsByGoodsName")
    @ResponseBody
    public String getMoreGoodsByGoodsName(String goodsName, int page) {
        page *= 30;
        List<GmsSpu> goodsByName = userGoodsListService.findGoodsByName(goodsName, page);
        if (goodsByName.size() > 0) {
            return JsonUtils.getJson(goodsByName);
        } else {
            return "null";
        }

    }
}
