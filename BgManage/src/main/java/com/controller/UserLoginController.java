package com.controller;

import com.pojo.GmsCatalog;
import com.pojo.MmsAdminInfo;
import com.pojo.UmsUserInfo;
import com.service.UserLoginService;
import com.util.JsonUtils;
import com.util.SendCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 肖宏武
 * @date 2020/4/21 - 21:05
 */
@Controller
public class UserLoginController {
    @Autowired
    @Qualifier("UserLoginServiceImpl")
    private UserLoginService userLoginService;

    @RequestMapping("/checkLogin")
    @ResponseBody
    public String checkLogin(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        UmsUserInfo userInfo = (UmsUserInfo) session.getAttribute("userInfo");
        if (userInfo != null){
            return "true";
        }else {
            return "false";
        }
    }

    //登陆后实现页面跳转
    @RequestMapping("/userLogin")
    public String loginToMain(HttpServletRequest request,HttpServletResponse response) {
        HttpSession session = request.getSession();
        UmsUserInfo userInfo = (UmsUserInfo) session.getAttribute("userInfo");
        if(userInfo != null){
            return "redirect:index.jsp";
        }else {
            return "redirect:userLogin.jsp";
        }

    }

    @RequestMapping("/userUnLogin")     //退出登录
    public String unLogin(HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession();
        session.removeAttribute("userInfo");
        return "redirect:userLogin.jsp";
    }

    //通过密码登录
    @RequestMapping("/userLoginByPass")
    @ResponseBody
    public String adminloginByPass(HttpServletRequest request,HttpServletResponse response) {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");
        String code = (String) session.getAttribute("randomcode_key");
        if (code.equals(checkCode)) {
            UmsUserInfo userInfo = userLoginService.userLoginByPass(username, password);
            if (userInfo != null){
                session.setAttribute("userInfo", userInfo);
                return "success";
            }else{
                return "userFail";
            }
        }
        return "codeFail";
    }

    //通过短信登录
    @RequestMapping("/userLoginByMessage")
    @ResponseBody
    public String loginByMessage(String telPhone, String messageCode, HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        String code = (String) session.getAttribute("messageCode_key");
        if (messageCode.equals(code)){
            UmsUserInfo userInfo = userLoginService.userFindUserByPhone(telPhone);
            session.setAttribute("userInfo",userInfo);
            return "true";
        }else {
            return "false";
        }
    }

    //用户登录发送短信验证码
    @RequestMapping("/userSendCode")
    @ResponseBody
    public String userMessageCheckCode(String telPhone,HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession();
        UmsUserInfo userInfo = userLoginService.userFindUserByPhone(telPhone);
        if (userInfo != null){
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

    //前端内容加载
    @RequestMapping("/showCatalog")
    @ResponseBody
    public String showCatalog(){
        List<GmsCatalog> allCatalog = userLoginService.findAllCatalog();
        return JsonUtils.getJson(allCatalog);
    }
}
