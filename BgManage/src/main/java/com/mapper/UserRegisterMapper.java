package com.mapper;

import com.pojo.UmsUserInfo;
import org.apache.ibatis.annotations.Param;

/**
 * @author 肖宏武
 * @date 2020/4/22 - 22:10
 */
public interface UserRegisterMapper {
    UmsUserInfo checkUsername(@Param("username") String username);

    UmsUserInfo checkTelPhone(@Param("telPhone") String telPhone);

    int insertUserInfo(@Param("username") String username, @Param("name") String name, @Param("birthday") String birthday, @Param("telPhone") String telPhone, @Param("sex") String sex, @Param("password") String password);
}
