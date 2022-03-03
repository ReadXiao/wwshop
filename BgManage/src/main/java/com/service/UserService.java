package com.service;

import com.pojo.MmsAdminInfo;
import com.pojo.UmsUserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 肖宏武
 * @date 2020/4/12 - 18:06
 */
public interface UserService {
    List<UmsUserInfo> selectAllUser();

    List<UmsUserInfo> selectUserByUserName(@Param("username") String username,@Param("state") int state);

    int resetPassword(@Param("id") int id);

    int cancelUser(@Param("id") int id, @Param("state") int state);

    int unCancelUser(@Param("id") int id, @Param("state") int state);

    List<UmsUserInfo> selectUserByState(int state);

    List<UmsUserInfo> selectUserById(@Param("id") int id);

    MmsAdminInfo selectAdmin();
}
