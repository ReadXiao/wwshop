package com.service.impl;

import com.mapper.LoginMapper;
import com.pojo.MmsAdminInfo;
import com.service.LoginService;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * @author 肖宏武
 * @date 2020/3/27 - 22:44
 */
public class LoginServiceImpl implements LoginService {
    private LoginMapper loginMapper;

    public void setLoginMapper(LoginMapper loginMapper) {
        this.loginMapper = loginMapper;
    }

    //管理员，密码登录
    public MmsAdminInfo adminLoginByPass(@Param("username") String username, @Param("password") String password) {
        MmsAdminInfo admin = loginMapper.adminLoginByPass(username, password);
        return admin;
    }

    //管理员，电话短信登录
    public MmsAdminInfo adminFindUserByPhone(@Param("telPhone") String telPhone){
        MmsAdminInfo admin = loginMapper.adminFindUserByPhone(telPhone);
        return admin;
    }

    public int updateLoginTime(@Param("date") String date, @Param("id") int id) {
        int i = loginMapper.updateLoginTime(date, id);
        return i;
    }

    public int updateUnLoginDate(@Param("date") String date, @Param("id") int id) {
        int i = loginMapper.updateUnLoginDate(date, id);
        return i;
    }
}
