package com.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 肖宏武
 * @date 2020/5/4 - 20:21
 */
@Controller
public class UserMyInfoController {

    @RequestMapping("/myOrder")
    public String toMyOrderPage(){
        return "userMyOrder";
    }

    @RequestMapping("mySelfInfo")
    public String toMyInfoPage(){
        return "UserMyHome";
    }
}
