package com.service.impl;

import com.mapper.UserRegisterMapper;
import com.pojo.UmsUserInfo;
import com.service.UserRegisterService;
import org.apache.ibatis.annotations.Param;

/**
 * @author 肖宏武
 * @date 2020/4/22 - 22:12
 */
public class UserRegisterServiceImpl implements UserRegisterService {
    private UserRegisterMapper userRegisterMapper;

    public void setUserRegisterMapper(UserRegisterMapper userRegisterMapper) {
        this.userRegisterMapper = userRegisterMapper;
    }

    @Override
    public UmsUserInfo checkUsername(@Param("username") String username) {
        return userRegisterMapper.checkUsername(username);
    }

    @Override
    public UmsUserInfo checkTelPhone(@Param("telPhone") String telPhone) {
        return userRegisterMapper.checkTelPhone(telPhone);
    }

    @Override
    public int insertUserInfo(@Param("username") String username, @Param("name") String name, @Param("birthday") String birthday, @Param("telPhone") String telPhone, @Param("sex") String sex, @Param("password") String password) {
        return userRegisterMapper.insertUserInfo(username,name,birthday,telPhone,sex,password);
    }

}
