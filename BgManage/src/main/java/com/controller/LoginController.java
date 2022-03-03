package com.controller;

import com.pojo.MmsAdminInfo;
import com.service.LoginService;
import com.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 肖宏武
 * @date 2020/3/27 - 21:45
 */
@Controller
public class LoginController {
    @Autowired
    @Qualifier("LoginServiceImpl")
    private LoginService loginService;

    //登陆后实现页面跳转
    @RequestMapping("/login")
    public String loginToMain(HttpServletRequest request,HttpServletResponse response) {
        HttpSession session = request.getSession();
        MmsAdminInfo admin = (MmsAdminInfo) session.getAttribute("admin");
        if(admin != null){
            return "index2";
        }else {
            return "redirect:login.jsp";
        }

    }

    @RequestMapping("/unLogin")     //退出登录
    public String unLogin(HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession();
        MmsAdminInfo admin = (MmsAdminInfo) session.getAttribute("admin");
        Date time = new Date();
        int id = admin.getId();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        String date = dateFormat.format(time);
        loginService.updateUnLoginDate(date,id);
        session.removeAttribute("admin");
        return "redirect:login.jsp";
    }

    //通过密码登录
    @RequestMapping("/loginByPass")
    @ResponseBody
    public String adminloginByPass(HttpServletRequest request,HttpServletResponse response) {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");
        String code = (String) session.getAttribute("randomcode_key");
        if (code.equals(checkCode)) {
            MmsAdminInfo admin = loginService.adminLoginByPass(username, password);
            if (admin != null){
                session.setAttribute("visitedTime",admin.getLastVisitTime());
                session.setAttribute("endTime",admin.getLastEndTime());
                Date time = new Date();
                int id = admin.getId();
                SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
                String date = dateFormat.format(time);
                loginService.updateLoginTime(date,id);
                session.setAttribute("admin", admin);
                return "success";
            }else{
                return "userFail";
            }
        }
        return "codeFail";
    }

    //通过短信登录
    @RequestMapping("/loginByMessage")
    @ResponseBody
    public String loginByMessage(String telPhone,String messageCode,HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession();
        String code = (String) session.getAttribute("messageCode_key");
        if (messageCode.equals(code)){
            MmsAdminInfo admin = loginService.adminFindUserByPhone(telPhone);
            session.setAttribute("visitedTime",admin.getLastVisitTime());
            session.setAttribute("endTime",admin.getLastEndTime());
            Date time = new Date();
            int id = admin.getId();
            SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
            String date = dateFormat.format(time);
            loginService.updateLoginTime(date,id);
            session.setAttribute("admin",admin);
            return "true";
        }else {
            return "false";
        }
    }

    //显示上次登录时间
    @RequestMapping("/loading")
    @ResponseBody
    public String loading(HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession();
        Date visitedTime = (Date) session.getAttribute("visitedTime");
        Date endTime = (Date) session.getAttribute("endTime");
        Map<String,Date> map = new HashMap<String, Date>();
        map.put("visitedTime",visitedTime);
        map.put("endTime",endTime);
        String json = JsonUtils.getJson(map);
        return json;
    }

}
