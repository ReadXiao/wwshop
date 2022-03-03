package com.service.impl;

import com.mapper.UserMapper;
import com.pojo.MmsAdminInfo;
import com.pojo.UmsUserInfo;
import com.service.UserService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 肖宏武
 * @date 2020/4/12 - 18:07
 */
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<UmsUserInfo> selectAllUser() {
        return userMapper.selectAllUser();
    }

    public List<UmsUserInfo> selectUserByUserName(@Param("username") String username,@Param("state") int state) {
        return userMapper.selectUserByUserName(username,state);
    }

    public int resetPassword(@Param("id") int id) {
        return userMapper.resetPassword(id);
    }

    public int cancelUser(@Param("id") int id, @Param("state") int state){
        return userMapper.cancelUser(id,state);
    }

    public int unCancelUser(@Param("id") int id, @Param("state") int state){
        return userMapper.cancelUser(id,state);
    }

    public List<UmsUserInfo> selectUserByState(@Param("state") int state) {
        return userMapper.selectUserByState(state);
    }

    public List<UmsUserInfo> selectUserById(@Param("id") int id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public MmsAdminInfo selectAdmin() {
        return userMapper.selectAdmin();
    }
}
