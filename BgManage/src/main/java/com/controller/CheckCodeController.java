package com.controller;

import com.pojo.MmsAdminInfo;
import com.pojo.UmsUserInfo;
import com.service.LoginService;
import com.util.ImageUtil;
import com.util.SendCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 肖宏武
 * @date 2020/3/26 - 19:53
 */
@Controller
public class CheckCodeController {
    @Autowired
    @Qualifier("LoginServiceImpl")
    private LoginService loginService;

    //图片验证码
    @RequestMapping(value="/checkCode")
    public void checkCode(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//设置相应类型,告诉浏览器输出的内容为图片
        response.setContentType("image/jpeg");
        //设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        ImageUtil image = new ImageUtil();
        try {
            image.getRandcode(request, response);//输出图片方法
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    //管理员发送短信验证码
    @RequestMapping("/sendCode")
    @ResponseBody
    public String messageCheckCode(String telPhone,HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession();
        MmsAdminInfo admin = loginService.adminFindUserByPhone(telPhone);
        if (admin != null){
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



}
