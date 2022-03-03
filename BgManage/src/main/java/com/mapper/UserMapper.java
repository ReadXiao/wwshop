package com.mapper;

import com.pojo.MmsAdminInfo;
import com.pojo.UmsUserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 肖宏武
 * @date 2020/4/11 - 20:14
 */
public interface UserMapper {
    List<UmsUserInfo> selectAllUser();

    List<UmsUserInfo> selectUserByUserName(@Param("username") String username,@Param("state") int state);

    int resetPassword(@Param("id") int id);

    int cancelUser(@Param("id") int id, @Param("state") int state);

    int unCancelUser(@Param("id") int id, @Param("state") int state);

    List<UmsUserInfo> selectUserByState(@Param("state") int state);

    List<UmsUserInfo> selectUserById(@Param("id") int id);

    MmsAdminInfo selectAdmin();
}
