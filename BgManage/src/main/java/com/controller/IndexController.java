package com.controller;

import com.pojo.GmsCatalogAttr;
import com.service.TestService;
import com.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 肖宏武
 * @date 2020/3/20 - 16:24
 */
@Controller
public class IndexController {
    @Autowired
    @Qualifier("TestServiceImpl")
    private TestService testService;

    @RequestMapping("/t1")
    @ResponseBody
    public String test() {
        List<GmsCatalogAttr> attrByCatalogId = testService.getAttrByCatalogId(1);
        System.out.println(JsonUtils.getJson(attrByCatalogId));
        return JsonUtils.getJson(attrByCatalogId);
    }

    //加载首页信息
    @RequestMapping("/top")
    public String test3() {
        return "top";
    }

    @RequestMapping("/left")
    public String test4() {
        return "left";
    }

    @RequestMapping("/main")
    public String test5() {
        return "main";
    }

    @RequestMapping("/foot")
    public String test6() {
        return "foot";
    }
}
