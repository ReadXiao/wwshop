package com.service.impl;

import com.mapper.UserLoginMapper;
import com.pojo.GmsCatalog;
import com.pojo.UmsUserInfo;
import com.service.UserLoginService;

import java.util.List;

/**
 * @author 肖宏武
 * @date 2020/4/21 - 21:40
 */
public class UserLoginServiceImpl implements UserLoginService {
    private UserLoginMapper userLoginMapper;

    public void setUserLoginMapper(UserLoginMapper userLoginMapper) {
        this.userLoginMapper = userLoginMapper;
    }


    @Override
    public UmsUserInfo userLoginByPass(String username, String password) {
        return userLoginMapper.userLoginByPass(username, password);
    }

    @Override
    public UmsUserInfo userFindUserByPhone(String telPhone) {
        return userLoginMapper.userFindUserByPhone(telPhone);
    }

    @Override
    public List<GmsCatalog> findAllCatalog() {
        return userLoginMapper.findAllCatalog();
    }
}
