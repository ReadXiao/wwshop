package com.mapper;

import com.pojo.MmsAdminInfo;
import com.pojo.UmsUserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * @author 肖宏武
 * @date 2020/3/27 - 22:32
 */
public interface LoginMapper {

    MmsAdminInfo adminLoginByPass(@Param("username") String username, @Param("password") String password);

    MmsAdminInfo adminFindUserByPhone(String telPhone);

    int updateLoginTime(@Param("date") String date,@Param("id") int id);

    int updateUnLoginDate(@Param("date") String date,@Param("id") int id);
}
