package com.controller;

import com.pojo.MmsAdminInfo;
import com.pojo.UmsUserInfo;
import com.service.UserService;
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
 * @date 2020/4/12 - 18:11
 */
@Controller
public class UserController {
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;

    //跳转到用户管理页面
    @RequestMapping("/toUserAdmin")
    public String toUserAdmin(Model model){
        List<UmsUserInfo> allUser = userService.selectAllUser();
        model.addAttribute("allUser", JsonUtils.getJson(allUser));
        return "userAdmin";
    }

    //实现通过名字模糊查询
    @RequestMapping("/findByName")
    @ResponseBody
    public String findByName(String username,int state){
        System.out.println(state);
        List<UmsUserInfo> userInfos = userService.selectUserByUserName(username,state);
        return JsonUtils.getJson(userInfos);
    }

    //查询所有用户
    @RequestMapping("/getAllUser")
    @ResponseBody
    public String getAllUser(){
        List<UmsUserInfo> userInfos = userService.selectAllUser();
        return JsonUtils.getJson(userInfos);
    }

    //查询正常用户
    @RequestMapping("/getNormalUser")
    @ResponseBody
    public String getNormalUser(){
        int state = 0;
        List<UmsUserInfo> userInfos = userService.selectUserByState(state);
        return JsonUtils.getJson(userInfos);
    }

    //查询已注销用户
    @RequestMapping("/getCancelUser")
    @ResponseBody
    public String getCancelUser(){
        int state = 1;
        List<UmsUserInfo> userInfos = userService.selectUserByState(state);
        return JsonUtils.getJson(userInfos);
    }


    //重置用户密码
    @RequestMapping("/resetPassword")
    @ResponseBody
    public String resetPassWord(int id){
        int i = userService.resetPassword(id);
        if(i>0){
            return "true";
        }else {
            return "false";
        }
    }

    //注销用户
    @RequestMapping("/cancelUser")
    @ResponseBody
    public String cancelUser(int id){
        int state = 1;
        int i = userService.cancelUser(id, state);
        System.out.println(i);
        if(i>0){
            return JsonUtils.getJson(userService.selectUserById(id));
        }else {
            return "false";
        }
    }

    //恢复用户
    @RequestMapping("/unCancelUser")
    @ResponseBody
    public String unCancelUser(int id){
        int state = 0;
        int i = userService.unCancelUser(id, state);
        if(i>0){
            return JsonUtils.getJson(userService.selectUserById(id));
        }else {
            return "false";
        }
    }

    @RequestMapping("/toAdminInfo")
    public String toAdminInfoPage(Model model){
        MmsAdminInfo adminInfo = userService.selectAdmin();
        model.addAttribute("adminInfo",adminInfo);
        return "adminInfo";
    }
}
