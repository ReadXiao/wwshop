package com.controller;

import com.pojo.MmsAdminInfo;
import com.pojo.UmsUserInfo;
import com.service.GoodsAdminService;
import com.service.UserRegisterService;
import com.util.SendCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author 肖宏武
 * @date 2020/4/21 - 21:06
 */
@Controller
public class UserRegisterController {
    @Autowired
    @Qualifier("UserRegisterServiceImpl")
    private UserRegisterService userRegisterService;


    //检查用户是否已经存在
    @RequestMapping("/checkUserName")
    @ResponseBody
    public String checkUserName(String username){
        UmsUserInfo userInfo = userRegisterService.checkUsername(username);
        if (userInfo != null){
            return "true";
        }
        return "false";
    }

    //检查电话号码是否存在并发送验证码
    @RequestMapping("/sendRegisterCode")
    @ResponseBody
    public String messageCheckCode(String telPhone, HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        UmsUserInfo userInfo = userRegisterService.checkTelPhone(telPhone);
        if (userInfo == null){
            SendCodeUtil sendCode = new SendCodeUtil();
            String s = sendCode.sendCode(telPhone);
            if (! s.equals("false")){
                session.setAttribute("messageCode_key",s);
                return "true";      //发送成功
            }else{
                return "false";     //发送失败
            }
        }else {
            return "none";          //电话号码不存在
        }
    }

    //注册
    @RequestMapping("/insertUserInfo")
    @ResponseBody
    public String insertUserInfo(String username,String name,String birthday,String telPhone,String sex,String password,String messageCode, HttpServletRequest request){
        HttpSession session = request.getSession();
        String code = (String) session.getAttribute("messageCode_key");
        if (code != null){
            if (code.equals(messageCode)){
                int i = userRegisterService.insertUserInfo(username, name, birthday, telPhone, sex, password);
                if(i>0){
                    return "true";
                }else {
                    return "false";
                }
            }else {
                return "codeError";
            }
        }
        return "noCode";
    }
}
